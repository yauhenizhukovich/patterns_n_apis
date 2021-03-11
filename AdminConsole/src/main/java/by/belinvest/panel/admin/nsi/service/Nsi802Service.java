package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_802.Nsi802;
import by.belinvest.panel.admin.nsi.db.Nsi802Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Nsi802Service {
    @Autowired
    private Nsi802Repository nsi802Repository;

    public DirectoryDTO get() {
        return nsi802Repository.get();
    }

    public boolean create(Nsi802 nsi802) {
        return nsi802Repository.create(nsi802);
    }

    public boolean update(Nsi802 nsi802) {
        return nsi802Repository.update(nsi802);
    }

    public boolean remove(String id) {
        return nsi802Repository.remove(id);
    }
}
