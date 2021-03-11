package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.ownership_okrb.OwnershipOkrb;
import by.belinvest.panel.admin.nsi.db.OwnershipOkrbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnershipOkrbService {
    @Autowired
    private OwnershipOkrbRepository ownershipOkrbRepository;

    public DirectoryDTO get() {
        return ownershipOkrbRepository.get();
    }

    public boolean create(OwnershipOkrb ownershipOkrb) {
        return ownershipOkrbRepository.create(ownershipOkrb);
    }

    public boolean update(OwnershipOkrb ownershipOkrb) {
        return ownershipOkrbRepository.update(ownershipOkrb);
    }

    public boolean remove(String dimid) {
        return ownershipOkrbRepository.remove(dimid);
    }
}
