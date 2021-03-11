package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.client_business_category.ClientBusinessCategory;
import by.belinvest.panel.admin.nsi.db.ClientBusinessCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientBusinessCategoryService {
    @Autowired
    private ClientBusinessCategoryRepository clientBusinessCategoryRepository;

    public DirectoryDTO get() {
        return clientBusinessCategoryRepository.get();
    }

    public boolean create(ClientBusinessCategory clientBusinessCategory) {
        return clientBusinessCategoryRepository.create(clientBusinessCategory);
    }

    public boolean update(ClientBusinessCategory clientBusinessCategory) {
        return clientBusinessCategoryRepository.update(clientBusinessCategory);
    }

    public boolean remove(String dimid) {
        return clientBusinessCategoryRepository.remove(dimid);
    }
}
