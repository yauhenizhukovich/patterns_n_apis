package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_116.Nsi116;
import by.belinvest.panel.admin.nsi.db.Nsi116Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Nsi116Service {
    @Autowired
    private Nsi116Repository nsi116Repository;

    public DirectoryDTO get() {
        return nsi116Repository.get();
    }

    public boolean create(Nsi116 nsi116) {
        return nsi116Repository.create(nsi116);
    }

    public boolean update(Nsi116 nsi116) {
        return nsi116Repository.update(nsi116);
    }

    public boolean remove(String id) {
        return nsi116Repository.remove(id);
    }
}
