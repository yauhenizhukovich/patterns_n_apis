package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.exec_status.ExecStatus;
import by.belinvest.panel.admin.nsi.db.ExecStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecStatusService {
    @Autowired
    private ExecStatusRepository execStatusRepository;

    public DirectoryDTO get() {
        return execStatusRepository.get();
    }

    public boolean create(ExecStatus execStatus) {
        return execStatusRepository.create(execStatus);
    }

    public boolean update(ExecStatus execStatus) {
        return execStatusRepository.update(execStatus);
    }

    public boolean remove(String dimid) {
        return execStatusRepository.remove(dimid);
    }
}
