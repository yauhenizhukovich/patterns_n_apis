package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.product_class.ProductClass;
import by.belinvest.panel.admin.nsi.db.ProductClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductClassService {
    @Autowired
    private ProductClassRepository productClassRepository;

    public DirectoryDTO get() {
        return productClassRepository.get();
    }

    public boolean create(ProductClass productClass) {
        return productClassRepository.create(productClass);
    }

    public boolean update(ProductClass productClass) {
        return productClassRepository.update(productClass);
    }

    public boolean remove(String id) {
        return productClassRepository.remove(id);
    }
}
