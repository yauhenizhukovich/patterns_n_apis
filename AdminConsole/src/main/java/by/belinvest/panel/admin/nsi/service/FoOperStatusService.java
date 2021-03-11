package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.fo_oper_status.FoOperStatus;
import by.belinvest.panel.admin.nsi.db.FoOperStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoOperStatusService {
    @Autowired
    private FoOperStatusRepository foOperStatusRepository;

    public DirectoryDTO get() {
        return foOperStatusRepository.get();
    }

    public boolean create(FoOperStatus foOperStatus) {
        return foOperStatusRepository.create(foOperStatus);
    }

    public boolean update(FoOperStatus foOperStatus) {
        return foOperStatusRepository.update(foOperStatus);
    }

    public boolean remove(String dimid) {
        return foOperStatusRepository.remove(dimid);
    }
}
