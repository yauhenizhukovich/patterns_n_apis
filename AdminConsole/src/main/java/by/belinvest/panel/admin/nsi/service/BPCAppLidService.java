package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bpc_applid.BPCAppLid;
import by.belinvest.panel.admin.nsi.db.BPCAppLidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BPCAppLidService {

    @Autowired
    private BPCAppLidRepository bpcAppLidRepository;

    public DirectoryDTO get() {
        return bpcAppLidRepository.get();
    }

    public boolean create(BPCAppLid bpcAppLid) {
        return bpcAppLidRepository.create(bpcAppLid);
    }

    public boolean update(BPCAppLid bpcAppLid) {
        return bpcAppLidRepository.update(bpcAppLid);
    }

    public boolean remove(String dimid) {
        return bpcAppLidRepository.remove(dimid);
    }
}
