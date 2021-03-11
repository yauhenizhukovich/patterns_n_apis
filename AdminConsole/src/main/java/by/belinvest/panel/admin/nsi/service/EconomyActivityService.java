package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.economy_activity.EconomyActivity;
import by.belinvest.panel.admin.nsi.db.EconomyActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EconomyActivityService {
    @Autowired
    private EconomyActivityRepository economyActivityRepository;

    public DirectoryDTO get() {
        return economyActivityRepository.get();
    }

    public boolean create(EconomyActivity economyActivity) {
        return economyActivityRepository.create(economyActivity);
    }

    public boolean update(EconomyActivity economyActivity) {
        return economyActivityRepository.update(economyActivity);
    }

    public boolean remove(String dimid) {
        return economyActivityRepository.remove(dimid);
    }
}
