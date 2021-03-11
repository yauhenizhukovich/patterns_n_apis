package by.belinvest.panel.admin.product.service;

import by.belinvest.panel.admin.entity.product.*;
import by.belinvest.panel.admin.product.dto.FullProductDto;
import by.belinvest.panel.admin.product.dto.LevelUpdateData;
import by.belinvest.panel.admin.product.dto.ProductDTO;
import by.belinvest.panel.admin.product.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private LevelHierarchyRepository levelHierarchyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductJDBCRepository productJDBCRepository;

    @Autowired
    private ProductHierValueRepository productHierValueRepository;

    @Autowired
    private ProductFilterRepository productFilterRepository;

    @Transactional
    public List<Product> getProductsByHierarchyId(Long productHierarchyId){
        return productRepository.findAllByProductHierarchyId(productHierarchyId);
    }

    @Transactional
    public FullProductDto getProductById(Long id){

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProduct(productRepository.findById(id).get());

        String tableName = productDTO.getProduct().getProductGroup().getTableName();
        productDTO.setRealProduct(productJDBCRepository.getProductAsMapById(productDTO.getProduct().getProductId(),tableName));

        List<Field> fields = levelHierarchyRepository.getFieldList(tableName);


        return FullProductDto.builder()
                .productDTO(productDTO)
                .fields(fields)
                .build();
    }

    @Transactional
    public List<Product> findAll(){
        //return productJDBCRepository.findAll();
        return productRepository.findAll();
    }

    @Transactional
    public List<Product> findAllByProductGroup(Long productGroupId){
        return productRepository.findAllByProductGroupId(productGroupId);
    }
    @Transactional
    public List<Product> findAllByProductGroupIdAndBnId(Long productGroupId, Long bnId){
        return productRepository.findAllByProductGroupIdAndBnId(productGroupId,bnId);
    }
    @Transactional
    public List<Product> findAllByProductGroupIdAndBnIdAndDbId(Long productGroupId, Long bnId, Long dbId){
        return productRepository.findAllByProductGroupIdAndBnIdAndDbId(productGroupId,bnId,dbId);
    }


    @Transactional
    public Product updateBnIdAndDbId(Long id, Long bnId, Long dbId){
        Product product = productRepository.findById(id).get();
        product.setBnId(bnId);
        product.setDbId(dbId);
        return productRepository.save(product);
    }

    @Transactional
    public List<ProductDTO> getProductAsMapByHierarchyId(Long productHierarchyId){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> productList = getProductsByHierarchyId(productHierarchyId);
        productList.forEach(product -> product.setProductHierValues(productHierValueRepository.findAllByProductId(product.getId())));

        for (Product product : productList) {
            Map<String,Object> realProduct = productJDBCRepository.getProductAsMapById(product.getProductId(), product.getProductGroup().getTableName());

            realProduct.entrySet().removeIf(el->el.getKey().equals("ID") || el.getKey().equals("DIMID") || el.getKey().equals("SYS_ID"));

            productDTOList.add(ProductDTO.builder()
                    .product(product)
                    .realProduct(realProduct)
                    .build());
        }

        return productDTOList;
    }

    @Transactional
    public int updateHierarchyLevel(LevelUpdateData data){
        return productJDBCRepository.updateHierarchyLevel(data.getFields(),data.getTableName(),data.getProductsId());
    }

    @Transactional
    public Product createProduct(LevelUpdateData data){
        Long realProductId = productJDBCRepository.createRealProduct(data.getFields(),data.getTableName());
        Product product = Product.builder()
                .productId(realProductId)
                .productGroup(ProductGroup.builder().id(Long.parseLong(data.getProductGroupId())).build())
                .productHierarchy(ProductHierarchy.builder().id(Long.parseLong(data.getHierarchyId())).build())
                .productCode(data.getFieldNameProductCode())
                .productHierValues(data.getProductHierValues())
                .build();
        productRepository.save(product);
        product.getProductHierValues().forEach(element->element.setProduct(product));
        productHierValueRepository.saveAll(product.getProductHierValues());

        return product;
    }



    @Transactional
    public String getNameOfProductById(String tableName,String nameOfField, Long id){
        return productJDBCRepository.getNameOfProductById(tableName,nameOfField,id);
    }

    @Transactional
    public List<Product> filterProductsByCurrency(List<Product> products, String currency){
        return products.stream().filter(product -> {
                    Map<String,Object> realProduct = productJDBCRepository.getProductAsMapById(product.getProductId(),product.getProductGroup().getTableName());
                    Object currentCurrency = realProduct.get(product.getProductGroup().getProductCurr());
                    if(currentCurrency == null){
                        return false;
                    }else {
                        return currentCurrency.toString().equals(currency);
                    }
        }
        ).collect(Collectors.toList());
    }

    @Transactional
    public List<Product> filterProductsByStatus(List<Product> productList,String status){
        Long productHierarchyId;
        Long bpId;
        ProductHierarchyStruct productHierarchyStruct;
        String tableName;
        String value;
        String productStatus;
        Product product;

        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()){
            product = iterator.next();

            productHierarchyId = product.getProductHierarchy().getId();
            System.out.println("productHierarchyId "+ productHierarchyId);
            productHierarchyStruct = productFilterRepository.findProductLineCriterionByHierarchyId(productHierarchyId);
            tableName = productFilterRepository.findTableNameOfCriterion(productHierarchyStruct.getCrit());
            tableName = tableName.split("\\.")[1];
            System.out.println("tableName "+ tableName);

            value = productFilterRepository.findValueByStructId(productHierarchyStruct.getId());
            System.out.println("value "+ value);
            bpId = productFilterRepository.findBPIdByNsiNameAndNsiId(tableName,Long.parseLong(value));
            System.out.println("bpId "+ bpId);

            productStatus = productFilterRepository.findProductStatusByBPId(bpId);
            System.out.println("productStatus "+ productStatus);
            System.out.println("status "+ status);

            if(!status.equals(productStatus)){
                iterator.remove();
            }
        }

        return productList;
    }

    @Transactional
    public void deleteProduct(Product product){
        productJDBCRepository.deleteRealProductById(product.getProductId(),product.getProductGroup().getTableName());
        productRepository.delete(product);
    }
}
