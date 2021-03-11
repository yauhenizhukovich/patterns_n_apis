package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bl_target_audience.BLTargetAudience;
import by.belinvest.panel.admin.nsi.db.BLTargetAudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BLTargetAudienceService {
    @Autowired
    private BLTargetAudienceRepository blTargetAudienceRepository;

    public DirectoryDTO get() {
        return blTargetAudienceRepository.get();
    }

    public boolean create(BLTargetAudience blTargetAudience) {
        return blTargetAudienceRepository.create(blTargetAudience);
    }

    public boolean update(BLTargetAudience blTargetAudience) {
        return blTargetAudienceRepository.update(blTargetAudience);
    }

    public boolean remove(String id) {
        return blTargetAudienceRepository.remove(id);
    }
}
