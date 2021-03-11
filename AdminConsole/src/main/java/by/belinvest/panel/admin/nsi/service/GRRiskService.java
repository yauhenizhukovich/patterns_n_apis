package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.gr_risk.GRRisk;
import by.belinvest.panel.admin.nsi.db.GRRiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GRRiskService {
    @Autowired
    private GRRiskRepository grRiskRepository;

    public DirectoryDTO get() {
        return grRiskRepository.get();
    }

    public boolean create(GRRisk grRisk) {
        return grRiskRepository.create(grRisk);
    }

    public boolean update(GRRisk grRisk) {
        return grRiskRepository.update(grRisk);
    }

    public boolean remove(String id) {
        return grRiskRepository.remove(id);
    }
}
