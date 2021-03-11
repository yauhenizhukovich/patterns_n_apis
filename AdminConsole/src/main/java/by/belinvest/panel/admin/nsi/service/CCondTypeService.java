package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.ccond_type.CCondType;
import by.belinvest.panel.admin.nsi.db.CCondTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCondTypeService {

    @Autowired
    private CCondTypeRepository cCondTypeRepository;

    public DirectoryDTO get() {
        return cCondTypeRepository.get();
    }

    public boolean create(CCondType cCondType) {
        return cCondTypeRepository.create(cCondType);
    }

    public boolean update(CCondType cCondType) {
        return cCondTypeRepository.update(cCondType);
    }

    public boolean remove(String dimid) {
        return cCondTypeRepository.remove(dimid);
    }
}
