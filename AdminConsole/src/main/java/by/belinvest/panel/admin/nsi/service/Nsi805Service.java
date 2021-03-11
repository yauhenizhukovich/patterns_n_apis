package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_805.Nsi805;
import by.belinvest.panel.admin.nsi.db.Nsi805Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Nsi805Service {
    @Autowired
    private Nsi805Repository nsi805Repository;

    public DirectoryDTO get() {
        return nsi805Repository.get();
    }

    public boolean create(Nsi805 nsi805) {
        return nsi805Repository.create(nsi805);
    }

    public boolean update(Nsi805 nsi805) {
        return nsi805Repository.update(nsi805);
    }

    public boolean remove(String id) {
        return nsi805Repository.remove(id);
    }
}
