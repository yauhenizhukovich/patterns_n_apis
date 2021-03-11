package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.contra.Contra;
import by.belinvest.panel.admin.nsi.db.ContraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContraService {
    @Autowired
    private ContraRepository contraRepository;

    public DirectoryDTO get() {
        return contraRepository.get();
    }

    public boolean create(Contra contra) {
        return contraRepository.create(contra);
    }

    public boolean update(Contra contra) {
        return contraRepository.update(contra);
    }

    public boolean remove(String dimid) {
        return contraRepository.remove(dimid);
    }
}
