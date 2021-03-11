package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.preferential_rate.PreferentialRate;
import by.belinvest.panel.admin.nsi.db.PreferentialRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferentialRateService {

    @Autowired
    private PreferentialRateRepository preferentialRateRepository;

    public DirectoryDTO get() {
        return preferentialRateRepository.get();
    }

    public boolean create(PreferentialRate preferentialRate) {
        return preferentialRateRepository.create(preferentialRate);
    }

    public boolean update(PreferentialRate preferentialRate) {
        return preferentialRateRepository.update(preferentialRate);
    }

    public boolean remove(String dimid) {
        return preferentialRateRepository.remove(dimid);
    }
}
