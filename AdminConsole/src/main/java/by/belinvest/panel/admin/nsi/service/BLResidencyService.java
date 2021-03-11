package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bl_residency.BLResidency;
import by.belinvest.panel.admin.nsi.db.BLResidencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BLResidencyService {
    @Autowired
    private BLResidencyRepository blResidencyRepository;

    public DirectoryDTO get() {
        return blResidencyRepository.get();
    }

    public boolean create(BLResidency blResidency) {
        return blResidencyRepository.create(blResidency);
    }

    public boolean update(BLResidency blResidency) {
        return blResidencyRepository.update(blResidency);
    }

    public boolean remove(String id) {
        return blResidencyRepository.remove(id);
    }
}
