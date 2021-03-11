package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_570.Nsi570;
import by.belinvest.panel.admin.nsi.db.Nsi570Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Nsi570Service {
    @Autowired
    private Nsi570Repository nsi570Repository;

    public DirectoryDTO get() {
        return nsi570Repository.get();
    }

    public boolean create(Nsi570 nsi570) {
        return nsi570Repository.create(nsi570);
    }

    public boolean update(Nsi570 nsi570) {
        return nsi570Repository.update(nsi570);
    }

    public boolean remove(String id) {
        return nsi570Repository.remove(id);
    }
}
