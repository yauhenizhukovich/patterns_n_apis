package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.risks.Risks;
import by.belinvest.panel.admin.nsi.db.RisksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RisksService {
    @Autowired
    private RisksRepository risksRepository;

    public DirectoryDTO get() {
        return risksRepository.get();
    }

    public boolean create(Risks risks) {
        return risksRepository.create(risks);
    }

    public boolean update(Risks risks) {
        return risksRepository.update(risks);
    }

    public boolean remove(String dimid) {
        return risksRepository.remove(dimid);
    }
}
