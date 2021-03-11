package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.calc_doc_status.CalcDocStatus;
import by.belinvest.panel.admin.nsi.db.CalcDocStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcDocStatusService {

    @Autowired
    private CalcDocStatusRepository calcDocStatusRepository;

    public DirectoryDTO get() {
        return calcDocStatusRepository.get();
    }

    public boolean create(CalcDocStatus calcDocStatus) {
        return calcDocStatusRepository.create(calcDocStatus);
    }

    public boolean update(CalcDocStatus calcDocStatus) {
        return calcDocStatusRepository.update(calcDocStatus);
    }

    public boolean remove(String id) {
        return calcDocStatusRepository.remove(id);
    }
}
