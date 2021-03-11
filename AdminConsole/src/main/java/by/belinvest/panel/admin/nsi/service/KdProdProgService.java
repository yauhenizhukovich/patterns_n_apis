package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.kd_prod_prog.KdProdProg;
import by.belinvest.panel.admin.nsi.db.KdProdProgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KdProdProgService {
    @Autowired
    private KdProdProgRepository kdProdProgRepository;

    public DirectoryDTO get() {
        return kdProdProgRepository.get();
    }

    public boolean create(KdProdProg kdProdProg) {
        return kdProdProgRepository.create(kdProdProg);
    }

    public boolean update(KdProdProg kdProdProg) {
        return kdProdProgRepository.update(kdProdProg);
    }

    public boolean remove(String id) {
        return kdProdProgRepository.remove(id);
    }
}
