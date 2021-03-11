package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bpc_prod_status.BPCProdStatus;
import by.belinvest.panel.admin.nsi.db.BPCProdStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BPCProdStatusService {

    @Autowired
    private BPCProdStatusRepository bpcProdStatusRepository;

    public DirectoryDTO get() {
        return bpcProdStatusRepository.get();
    }

    public boolean create(BPCProdStatus bpcProdStatus) {
        return bpcProdStatusRepository.create(bpcProdStatus);
    }

    public boolean update(BPCProdStatus bpcProdStatus) {
        return bpcProdStatusRepository.update(bpcProdStatus);
    }

    public boolean remove(String id) {
        return bpcProdStatusRepository.remove(id);
    }
}
