package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.stop_factors.StopFactors;
import by.belinvest.panel.admin.nsi.db.StopFactorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopFactorsService {
    @Autowired
    private StopFactorsRepository stopFactorsRepository;

    public DirectoryDTO get() {
        return stopFactorsRepository.get();
    }

    public boolean create(StopFactors stopFactors) {
        return stopFactorsRepository.create(stopFactors);
    }

    public boolean update(StopFactors stopFactors) {
        return stopFactorsRepository.update(stopFactors);
    }

    public boolean remove(String dimid) {
        return stopFactorsRepository.remove(dimid);
    }
}
