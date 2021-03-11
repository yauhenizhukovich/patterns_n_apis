package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.units.Units;
import by.belinvest.panel.admin.nsi.db.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitsService {
    @Autowired
    private UnitsRepository unitsRepository;

    public DirectoryDTO get() {
        return unitsRepository.get();
    }

    public boolean create(Units units) {
        return unitsRepository.create(units);
    }

    public boolean update(Units units) {
        return unitsRepository.update(units);
    }

    public boolean remove(String dimid) {
        return unitsRepository.remove(dimid);
    }
}
