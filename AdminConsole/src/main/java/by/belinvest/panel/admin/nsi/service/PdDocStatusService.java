package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.pd_doc_status.PdDocStatus;
import by.belinvest.panel.admin.nsi.db.PdDocStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdDocStatusService {

    @Autowired
    private PdDocStatusRepository pdDocStatusRepository;

    public DirectoryDTO get() {
        return pdDocStatusRepository.get();
    }

    public boolean create(PdDocStatus pdDocStatus) {
        return pdDocStatusRepository.create(pdDocStatus);
    }

    public boolean update(PdDocStatus pdDocStatus) {
        return pdDocStatusRepository.update(pdDocStatus);
    }

    public boolean remove(String dimid) {
        return pdDocStatusRepository.remove(dimid);
    }
}
