package by.belinvest.panel.admin.product.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.sql.DataSource;

import by.belinvest.panel.admin.entity.product.Field;
import by.belinvest.panel.admin.entity.product.Level;
import by.belinvest.panel.admin.entity.product.Product;
import by.belinvest.panel.admin.entity.product.ProductGroup;
import by.belinvest.panel.admin.entity.product.ProductHierCrit;
import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import by.belinvest.panel.admin.entity.product.ProductHierarchyStruct;
import by.belinvest.panel.admin.entity.product.TreeElement;
import by.belinvest.panel.admin.product.dto.FullProductHierarchyDTO;
import by.belinvest.panel.admin.product.dto.ProductGroupDTO;
import by.belinvest.panel.admin.product.dto.ProductHierarchyDTO;
import by.belinvest.panel.admin.product.dto.ProductLine;
import by.belinvest.panel.admin.product.repository.HierarchyRepository;
import by.belinvest.panel.admin.product.repository.LevelHierarchyRepository;
import by.belinvest.panel.admin.product.repository.ProductGroupRepository;
import by.belinvest.panel.admin.product.repository.ProductHierCritRepository;
import by.belinvest.panel.admin.product.repository.ProductHierValueRepository;
import by.belinvest.panel.admin.product.repository.ProductHierarchyRepository;
import by.belinvest.panel.admin.product.repository.ProductHierarchyStructRepository;
import by.belinvest.panel.admin.product.repository.ProductLineRepository;
import by.belinvest.panel.admin.product.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductHierarchyService {

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductHierarchyRepository productHierarchyRepository;

    @Autowired
    private ProductHierarchyStructRepository productHierarchyStructRepository;

    @Autowired
    private ProductHierValueRepository productHierValueRepository;

    @Autowired
    private LevelHierarchyRepository levelHierarchyRepository;

    @Autowired
    @Qualifier("productHierCritRepository")
    private ProductHierCritRepository productHierCritRepository;

    @Autowired
    private ProductLineRepository productLineRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private HierarchyRepository hierarchyRepository;

    @Autowired
    private TreeRepository treeRepository;

    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ListBIService listBIService;

    @Autowired
    public ProductHierarchyService(@Qualifier("catalogDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    public List<ProductHierarchy> findAllByProductGroupIdAndLineId(Long productGroupId, Long lineId) {
        return productHierarchyRepository.findAllByProductGroupIdAndLineId(productGroupId, lineId);
    }

    @Transactional
    public List<ProductHierarchy> findAllByProductGroupIdAndActivity(Long productGroupId) {
        Integer activeFlag = 1;
        return productHierarchyRepository.findAllByProductGroupIdAndActivity(productGroupId, activeFlag);
    }

    @Transactional
    public List<ProductLine> findProductLines(Long productGroupId) {
        ProductGroup productGroup = productGroupRepository.findById(productGroupId).get();

        List<ProductHierarchy> productHierarchies = productHierarchyRepository.findAllByProductGroup(productGroup);

        if (productHierarchies.isEmpty()) {
            return new ArrayList<>();
        }

        ProductHierarchy productHierarchy = productHierarchies.get(0);
        Long criterionId = productLineRepository.getFirstLineCriterion(productHierarchy.getId());
        Optional<ProductHierCrit> productHierCrit = productHierCritRepository.findById(criterionId);
        return productLineRepository.getProductLines(productHierCrit.get().getTableName());

    }

    @Transactional
    public List<FullProductHierarchyDTO> getProductHierarchyByProductGroups(Long pg1, Long pg2, Long pg3) {
        List<FullProductHierarchyDTO> fullProductHierarchyDTOList = FullProductHierarchyDTO.toDTOList(hierarchyRepository.getProductHierarchyByProductGroups(
                pg1,
                pg2,
                pg3));

        for (FullProductHierarchyDTO fullProductHierarchyDTO : fullProductHierarchyDTOList) {
            fullProductHierarchyDTO.setHaveProducts(
                    !productService.getProductsByHierarchyId(fullProductHierarchyDTO.getProductHierarchyDTO().getId()).isEmpty()
            );
            fullProductHierarchyDTO.setSecondProductGroup(ProductGroupDTO.toDTO(productGroupRepository.getOne(fullProductHierarchyDTO.getProductHierarchyDTO()
                    .getProductGroupDTO()
                    .getHiId())));
            fullProductHierarchyDTO.setFirstProductGroup(ProductGroupDTO.toDTO(productGroupRepository.getOne(fullProductHierarchyDTO.getSecondProductGroup()
                    .getHiId())));
        }


        return fullProductHierarchyDTOList;
    }

    public FullProductHierarchyDTO findById(Long hierarchyId) {
        FullProductHierarchyDTO fullProductHierarchyDTO = FullProductHierarchyDTO.toDTO(productHierarchyRepository.findById(hierarchyId)
                .get());
        fullProductHierarchyDTO.setSecondProductGroup(ProductGroupDTO.toDTO(productGroupRepository.findById(fullProductHierarchyDTO.getProductHierarchyDTO()
                .getProductGroupDTO()
                .getHiId()).get()));
        fullProductHierarchyDTO.setFirstProductGroup(ProductGroupDTO.toDTO(productGroupRepository.findById(fullProductHierarchyDTO.getSecondProductGroup()
                .getHiId()).get()));

        List<Field> fieldList = levelHierarchyRepository.getFieldList(fullProductHierarchyDTO.getProductHierarchyDTO()
                .getProductGroupDTO()
                .getTableName());
        fullProductHierarchyDTO.setLevels(
                getLevelList(fullProductHierarchyDTO.getProductHierarchyDTO().getProductHierarchyStructs(), fieldList)
        );
        fullProductHierarchyDTO.setFreeFields(fieldList);
        fullProductHierarchyDTO.setProductList(productService.getProductAsMapByHierarchyId(fullProductHierarchyDTO.getProductHierarchyDTO()
                .getId()));

        List<TreeElement> lineList = treeRepository.getTree(fullProductHierarchyDTO.getFirstProductGroup().getId(),
                fullProductHierarchyDTO.getSecondProductGroup().getId(),
                fullProductHierarchyDTO.getProductHierarchyDTO().getProductGroupDTO().getId());
        lineList = lineList
                .stream()
                .filter(treeElement -> treeElement.getLev() == 4 && treeElement.getProdHierId() == hierarchyId)
                .collect(Collectors.toList());

        Optional<TreeElement> line = lineList
                .stream()
                .findFirst();

        if (line.isPresent()) {
            fullProductHierarchyDTO.setProductLine(line.get().getName());
        } else {
            fullProductHierarchyDTO.setProductLine(null);
        }

        return fullProductHierarchyDTO;
    }

    private List<Level> getLevelList(List<ProductHierarchyStruct> structList, List<Field> fieldList) {
        List<Level> levels = new ArrayList<>();

        for (ProductHierarchyStruct struct : structList) {
            Level newLevel;
            if (struct.getCrit() != null) {
                newLevel = new Level();
                ProductHierCrit crit = productHierCritRepository.findById(struct.getCrit()).get();
                newLevel.setCriterionList(levelHierarchyRepository.getCriterionList(crit));
                newLevel.setLevel((struct.getLevel()));
                newLevel.setProductHierStructId(struct.getId());
                levels.add(newLevel);
            }

        }
        for (ProductHierarchyStruct struct : structList) {
            if (struct.getCrit() == null) {
                Level currentLevel = levels.stream().filter(level -> level.getLevel() == struct.getLevel()).findFirst().get();
                Iterator<Field> iterator = fieldList.listIterator();
                Field field;
                while (iterator.hasNext()) {
                    field = iterator.next();
                    if (field.getFieldName().equals(struct.getFieldName())) {
                        currentLevel.getFieldList().add(field);
                        iterator.remove();
                    }
                }
            }
        }

        return levels.stream().sorted(Comparator.comparing(Level::getLevel)).collect(Collectors.toList());
    }

    @Transactional
    public List<ProductHierarchy> findAllByProductGroupId(Long productGroupId) {
        return productHierarchyRepository.findAllByProductGroup_Id(productGroupId);
    }


    @Transactional
    public boolean update(ProductHierarchy productHierarchy) {

        if(productService.getProductsByHierarchyId(productHierarchy.getId()).isEmpty()){
            /**delete structs*/
            productHierarchyStructRepository.deleteAllByProductHierarchy(productHierarchy);

            for (ProductHierarchyStruct struct : productHierarchy.getProductHierarchyStructs()) {
                struct.setProductHierarchy(productHierarchy);
            }
        }else {
            /**delete structs*/
            productHierarchyStructRepository.deleteAllByProductHierarchyAndCrit(productHierarchy,null);
            productHierarchy.setProductHierarchyStructs(
                    productHierarchy.getProductHierarchyStructs()
                            .stream()
                            .filter(productHierarchyStruct -> productHierarchyStruct.getCrit()==null)
                            .collect(Collectors.toList())
            );

            for (ProductHierarchyStruct struct : productHierarchy.getProductHierarchyStructs()) {
                struct.setProductHierarchy(productHierarchy);
            }
        }

        productHierarchy = productHierarchyRepository.save(productHierarchy);

        /**delete values
        List<ProductHierarchyStruct> productHierarchyStructList = productHierarchyStructRepository.findAllByProductHierarchy(
                productHierarchy);
        productHierarchyStructList.forEach(struct -> {
            productHierValueRepository.deleteByProductHierarchyStruct(struct);
        });

         delete products
         List<Product> productList = productService.getProductsByHierarchyId(productHierarchy.getId());
         for (Product product : productList) {
         productService.deleteProduct(product);
         }
         */

        return true;
    }

    @Transactional
    public boolean create(ProductHierarchy productHierarchy) {
        for (ProductHierarchyStruct struct : productHierarchy.getProductHierarchyStructs()) {
            struct.setProductHierarchy(productHierarchy);
        }
        productHierarchy = productHierarchyRepository.save(productHierarchy);

        Optional<ProductGroup> optionalProductGroup = productGroupRepository.findById(productHierarchy.getProductGroup().getId());
        if (optionalProductGroup.isPresent()) {
            productHierarchy.setProductGroup(optionalProductGroup.get());
        }

        System.out.println("Commit");

        listBIService.saveListRecord(productHierarchy);
        return true;
    }


    @Transactional
    public List<ProductHierarchy> getProductHierarchyByName(String name) {
        return productHierarchyRepository.findProductHierarchiesByName(name);
    }

    @Transactional
    public List<ProductHierarchyDTO> findAllNamesAndId() {
        return productHierarchyRepository.findAll()
                .stream()
                .filter(productHierarchy -> productHierarchy.getActivity() == 1)
                .map(element -> ProductHierarchyDTO.builder()
                        .id(element.getId())
                        .name(element.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ProductHierarchyDTO> findAll() {
        return productHierarchyRepository.findAll().stream().map(ProductHierarchyDTO::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public boolean isLineExist(Long productGroupId, String productLine) {
        List<Long> productHierarchiesId =
                productHierarchyRepository.findAllByProductGroup(ProductGroup.builder().id(productGroupId).build())
                        .stream()
                        .map(ProductHierarchy::getId)
                        .collect(Collectors.toList());

        List<TreeElement> elements = new ArrayList<>();
        try {
            ProductGroup thirdProductGroup = productGroupRepository.findById(productGroupId).get();
            ProductGroup secondProductGroup = productGroupRepository.findById(thirdProductGroup.getHiId()).get();
            ProductGroup firstProductGroup = productGroupRepository.findById(secondProductGroup.getHiId()).get();
            elements = treeRepository.getTree(firstProductGroup.getId(), secondProductGroup.getId(), thirdProductGroup.getId());
        } catch (NoSuchElementException ignored) {
        }

        return elements.stream()
                .filter(element -> element.getLev() == 4 && productHierarchiesId.contains(element.getProdHierId()))
                .anyMatch(element -> element.getName().equals(productLine));
    }

    @Transactional
    public boolean isValueUsed(Long productHierId, Long productStructId, Long value) {
        Optional<ProductHierarchyStruct> productHierarchyStruct
                = productHierarchyStructRepository.findById(productStructId);

        Optional<ProductHierCrit> productHierCrit
                = productHierCritRepository.findById(productHierarchyStruct.get().getCrit());

        assert Objects.requireNonNull(productHierCrit).isPresent();
        Long temp = productLineRepository.isValueUsed(productHierCrit.get().getTableName(), value, productHierId);

        return temp == 0;
    }

}
