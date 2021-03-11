package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.urdep.Urdep;
import by.belinvest.panel.admin.nsi.db.UrdepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrdepService {
    @Autowired
    private UrdepRepository urdepRepository;

    public DirectoryDTO get() {
        return urdepRepository.get();
    }

    public boolean create(Urdep urdep) {
        return urdepRepository.create(urdep);
    }

    public boolean update(Urdep urdep) {
        return urdepRepository.update(urdep);
    }

    public boolean remove(String id) {
        return urdepRepository.remove(id);
    }
}
