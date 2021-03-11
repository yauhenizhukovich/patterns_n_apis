package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_801.Nsi801;
import by.belinvest.panel.admin.nsi.db.Nsi801Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Nsi801Service {
    @Autowired
    private Nsi801Repository nsi801Repository;

    public DirectoryDTO get() {
        return nsi801Repository.get();
    }

    public boolean create(Nsi801 nsi801) {
        return nsi801Repository.create(nsi801);
    }

    public boolean update(Nsi801 nsi801) {
        return nsi801Repository.update(nsi801);
    }

    public boolean remove(String id) {
        return nsi801Repository.remove(id);
    }
}
