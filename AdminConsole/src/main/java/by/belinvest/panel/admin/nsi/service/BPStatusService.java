package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bp_status.BPStatus;
import by.belinvest.panel.admin.nsi.db.BPStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BPStatusService {

    @Autowired
    private BPStatusRepository bpStatusRepository;

    public DirectoryDTO get() {
        return bpStatusRepository.get();
    }

    public boolean create(BPStatus bpStatus) {
        return bpStatusRepository.create(bpStatus);
    }

    public boolean update(BPStatus bpStatus) {
        return bpStatusRepository.update(bpStatus);
    }

    public boolean remove(String id) {
        return bpStatusRepository.remove(id);
    }
}
