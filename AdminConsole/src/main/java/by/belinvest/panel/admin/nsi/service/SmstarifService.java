package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.smstarif.Smstarif;
import by.belinvest.panel.admin.nsi.db.SmstarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmstarifService {
    @Autowired
    private SmstarifRepository smstarifRepository;

    public DirectoryDTO get() {
        return smstarifRepository.get();
    }

    public boolean create(Smstarif smstarif) {
        return smstarifRepository.create(smstarif);
    }

    public boolean update(Smstarif smstarif) {
        return smstarifRepository.update(smstarif);
    }

    public boolean remove(String dimid) {
        return smstarifRepository.remove(dimid);
    }
}
