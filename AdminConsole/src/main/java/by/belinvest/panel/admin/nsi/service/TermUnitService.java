package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.term_unit.TermUnit;
import by.belinvest.panel.admin.nsi.db.TermUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermUnitService {
    @Autowired
    private TermUnitRepository termUnitRepository;

    public DirectoryDTO get() {
        return termUnitRepository.get();
    }

    public boolean create(TermUnit termUnit) {
        return termUnitRepository.create(termUnit);
    }

    public boolean update(TermUnit termUnit) {
        return termUnitRepository.update(termUnit);
    }

    public boolean remove(String dimid) {
        return termUnitRepository.remove(dimid);
    }
}
