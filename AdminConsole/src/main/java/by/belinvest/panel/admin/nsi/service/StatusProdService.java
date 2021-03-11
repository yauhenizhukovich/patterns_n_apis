package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.accstatus.AccStatus;
import by.belinvest.panel.admin.entity.nsi.status_prod.StatusProd;
import by.belinvest.panel.admin.nsi.db.AccStatusRepository;
import by.belinvest.panel.admin.nsi.db.StatusProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusProdService {

    @Autowired
    private StatusProdRepository statusProdRepository;

    public DirectoryDTO get() {
        return statusProdRepository.get();
    }

    public boolean create(StatusProd statusProd) {
        return statusProdRepository.create(statusProd);
    }

    public boolean update(StatusProd statusProd) {
        return statusProdRepository.update(statusProd);
    }

    public boolean remove(String id) {
        return statusProdRepository.remove(id);
    }

}
