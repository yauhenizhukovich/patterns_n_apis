package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_007.Nsi007;
import by.belinvest.panel.admin.nsi.db.Nsi007Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Nsi007Service {
    @Autowired
    private Nsi007Repository nsi007Repository;

    public DirectoryDTO get() {
        return nsi007Repository.get();
    }

    public boolean create(Nsi007 nsi007) {
        return nsi007Repository.create(nsi007);
    }

    public boolean update(Nsi007 nsi007) {
        return nsi007Repository.update(nsi007);
    }

    public boolean remove(String id) {
        return nsi007Repository.remove(id);
    }
}
