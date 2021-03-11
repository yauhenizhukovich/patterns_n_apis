package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.pbi_resp_status.PbiRespStatus;
import by.belinvest.panel.admin.nsi.db.PbiRespStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PbiRespStatusService {
    @Autowired
    private PbiRespStatusRepository pbiRespStatusRepository;

    public DirectoryDTO get() {
        return pbiRespStatusRepository.get();
    }

    public boolean create(PbiRespStatus pbiRespStatus) {
        return pbiRespStatusRepository.create(pbiRespStatus);
    }

    public boolean update(PbiRespStatus pbiRespStatus) {
        return pbiRespStatusRepository.update(pbiRespStatus);
    }

    public boolean remove(String dimid) {
        return pbiRespStatusRepository.remove(dimid);
    }
}
