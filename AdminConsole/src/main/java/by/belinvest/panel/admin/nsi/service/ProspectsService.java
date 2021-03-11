package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.prospects.Prospects;
import by.belinvest.panel.admin.nsi.db.ProspectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProspectsService {
    @Autowired
    private ProspectsRepository prospectsRepository;

    public DirectoryDTO get() {
        return prospectsRepository.get();
    }

    public boolean create(Prospects prospects) {
        return prospectsRepository.create(prospects);
    }

    public boolean update(Prospects prospects) {
        return prospectsRepository.update(prospects);
    }

    public boolean remove(String id) {
        return prospectsRepository.remove(id);
    }
}
