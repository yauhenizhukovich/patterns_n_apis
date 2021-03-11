package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.product_sc.ProductSC;
import by.belinvest.panel.admin.nsi.db.ProductSCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSCService {
    @Autowired
    private ProductSCRepository productSCRepository;

    public DirectoryDTO get() {
        return productSCRepository.get();
    }

    public boolean create(ProductSC productSC) {
        return productSCRepository.create(productSC);
    }

    public boolean update(ProductSC productSC) {
        return productSCRepository.update(productSC);
    }

    public boolean remove(String id) {
        return productSCRepository.remove(id);
    }
}
