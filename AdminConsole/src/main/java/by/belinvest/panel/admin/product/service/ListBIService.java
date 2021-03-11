package by.belinvest.panel.admin.product.service;

import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import by.belinvest.panel.admin.product.repository.ListBIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListBIService {

    @Autowired
    private ListBIRepository listBIRepository;

    public void saveListRecord(ProductHierarchy productHierarchy) {
        Long id = productHierarchy.getId();
        Long lineId = productHierarchy.getLineId();
        String nsiTable = productHierarchy.getProductGroup().getNsiTable();
        listBIRepository.save(id, lineId, nsiTable);
    }

}
