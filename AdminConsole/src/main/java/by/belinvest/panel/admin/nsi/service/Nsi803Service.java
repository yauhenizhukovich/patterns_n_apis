package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_803.Nsi803;
import by.belinvest.panel.admin.nsi.db.Nsi803Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Nsi803Service {
    @Autowired
    private Nsi803Repository nsi803Repository;

    public DirectoryDTO get() {
        return nsi803Repository.get();
    }

    public boolean create(Nsi803 nsi803) {
        return nsi803Repository.create(nsi803);
    }

    public boolean update(Nsi803 nsi803) {
        return nsi803Repository.update(nsi803);
    }

    public boolean remove(String dimid) {
        return nsi803Repository.remove(dimid);
    }
}
