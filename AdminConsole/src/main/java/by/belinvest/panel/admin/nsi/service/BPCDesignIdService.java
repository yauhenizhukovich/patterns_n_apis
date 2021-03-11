package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bpc_designid.BPCDesignId;
import by.belinvest.panel.admin.nsi.db.BPCDesignIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BPCDesignIdService {

    @Autowired
    private BPCDesignIdRepository bpcDesignIdRepository;

    public DirectoryDTO get() {
        return bpcDesignIdRepository.get();
    }

    public boolean create(BPCDesignId bpcDesignId) {
        return bpcDesignIdRepository.create(bpcDesignId);
    }

    public boolean update(BPCDesignId bpcDesignId) {
        return bpcDesignIdRepository.update(bpcDesignId);
    }

    public boolean remove(String dimid) {
        return bpcDesignIdRepository.remove(dimid);
    }
}
