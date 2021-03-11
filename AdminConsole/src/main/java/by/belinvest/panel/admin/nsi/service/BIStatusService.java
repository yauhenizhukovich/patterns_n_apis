package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bi_status.BIStatus;
import by.belinvest.panel.admin.nsi.db.BIStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BIStatusService {
    @Autowired
    private BIStatusRepository biStatusRepository;

    public DirectoryDTO get() {
        return biStatusRepository.get();
    }

    public boolean create(BIStatus biStatus) {
        return biStatusRepository.create(biStatus);
    }

    public boolean update(BIStatus biStatus) {
        return biStatusRepository.update(biStatus);
    }

    public boolean remove(String id) {
        return biStatusRepository.remove(id);
    }

}
