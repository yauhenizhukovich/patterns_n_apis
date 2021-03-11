package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.product_type.ProductType;
import by.belinvest.panel.admin.nsi.db.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public DirectoryDTO get() {
        return productTypeRepository.get();
    }

    public boolean create(ProductType productType) {
        return productTypeRepository.create(productType);
    }

    public boolean update(ProductType productType) {
        return productTypeRepository.update(productType);
    }

    public boolean remove(String id) {
        return productTypeRepository.remove(id);
    }
}
