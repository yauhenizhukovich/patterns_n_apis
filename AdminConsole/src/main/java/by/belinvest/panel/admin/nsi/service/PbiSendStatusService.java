package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.pbi_send_status.PbiSendStatus;
import by.belinvest.panel.admin.nsi.db.PbiSendStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PbiSendStatusService {

    @Autowired
    private PbiSendStatusRepository pbiSendStatusRepository;

    public DirectoryDTO get() {
        return pbiSendStatusRepository.get();
    }

    public boolean create(PbiSendStatus pbiSendStatus) {
        return pbiSendStatusRepository.create(pbiSendStatus);
    }

    public boolean update(PbiSendStatus pbiSendStatus) {
        return pbiSendStatusRepository.update(pbiSendStatus);
    }

    public boolean remove(String dimid) {
        return pbiSendStatusRepository.remove(dimid);
    }
}
