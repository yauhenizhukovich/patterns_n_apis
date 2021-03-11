package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.ministry.Ministry;
import by.belinvest.panel.admin.nsi.db.MinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinistryService {

    @Autowired
    private MinistryRepository ministryRepository;

    public DirectoryDTO get() {
        return ministryRepository.get();
    }

    public boolean create(Ministry ministry) {
        return ministryRepository.create(ministry);
    }

    public boolean update(Ministry ministry) {
        return ministryRepository.update(ministry);
    }

    public boolean remove(String dimid) {
        return ministryRepository.remove(dimid);
    }
}
