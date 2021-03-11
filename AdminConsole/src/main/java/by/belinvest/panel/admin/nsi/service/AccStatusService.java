package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.accstatus.AccStatus;
import by.belinvest.panel.admin.nsi.db.AccStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccStatusService {

    @Autowired
    private AccStatusRepository accStatusRepository;

    public DirectoryDTO get() {
        return accStatusRepository.get();
    }

    public boolean create(AccStatus accStatus) {
        return accStatusRepository.create(accStatus);
    }

    public boolean update(AccStatus accStatus) {
        return accStatusRepository.update(accStatus);
    }

    public boolean remove(String id) {
        return accStatusRepository.remove(id);
    }

}
