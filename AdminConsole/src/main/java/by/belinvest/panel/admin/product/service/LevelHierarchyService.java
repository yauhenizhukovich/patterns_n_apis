package by.belinvest.panel.admin.product.service;

import by.belinvest.panel.admin.entity.product.ProductGroup;
import by.belinvest.panel.admin.product.dto.LevelHierarchyDTO;
import by.belinvest.panel.admin.product.repository.LevelHierarchyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LevelHierarchyService {
    @Autowired
    private LevelHierarchyRepository levelHierarchyRepository;

    @Autowired
    private ProductGroupService productGroupService;

    @Transactional
    public LevelHierarchyDTO getLevelHierarchy(Long productGroupId){
        ProductGroup productGroup = productGroupService.findById(productGroupId);
        String tableName = productGroup.getTableName();
        String nsiTableName = productGroup.getNsiTable();
        return levelHierarchyRepository.getLevelHierarchyDTOList(tableName,nsiTableName,productGroupId);
    }


}
