package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.typ_cr.TypCr;
import by.belinvest.panel.admin.nsi.db.TypCrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypCrService {
    @Autowired
    private TypCrRepository typCrRepository;

    public DirectoryDTO get() {
        return typCrRepository.get();
    }

    public boolean create(TypCr typCr) {
        return typCrRepository.create(typCr);
    }

    public boolean update(TypCr typCr) {
        return typCrRepository.update(typCr);
    }

    public boolean remove(String dimid) {
        return typCrRepository.remove(dimid);
    }
}
