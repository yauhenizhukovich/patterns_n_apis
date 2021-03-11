package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.cd_doc_status.CdDocStatus;
import by.belinvest.panel.admin.nsi.db.CdDocStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CdDocStatusService {

    @Autowired
    private CdDocStatusRepository cdDocStatusRepository;

    public DirectoryDTO get() {
        return cdDocStatusRepository.get();
    }

    public boolean create(CdDocStatus cdDocStatus) {
        return cdDocStatusRepository.create(cdDocStatus);
    }

    public boolean update(CdDocStatus cdDocStatus) {
        return cdDocStatusRepository.update(cdDocStatus);
    }

    public boolean remove(String dimid) {
        return cdDocStatusRepository.remove(dimid);
    }
}
