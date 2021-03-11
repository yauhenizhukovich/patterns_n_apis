package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.partial_issuance.PartialIssuance;
import by.belinvest.panel.admin.nsi.db.PartialIssuanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartialIssuanceService {
    @Autowired
    private PartialIssuanceRepository partialIssuanceRepository;

    public DirectoryDTO get() {
        return partialIssuanceRepository.get();
    }

    public boolean create(PartialIssuance partialIssuance) {
        return partialIssuanceRepository.create(partialIssuance);
    }

    public boolean update(PartialIssuance partialIssuance) {
        return partialIssuanceRepository.update(partialIssuance);
    }

    public boolean remove(String dimid) {
        return partialIssuanceRepository.remove(dimid);
    }
}
