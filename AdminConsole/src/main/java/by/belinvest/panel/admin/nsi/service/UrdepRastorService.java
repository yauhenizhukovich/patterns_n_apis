package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.urdep_rastor.UrdepRastor;
import by.belinvest.panel.admin.nsi.db.UrdepRastorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrdepRastorService {
    @Autowired
    private UrdepRastorRepository urdepRastorRepository;

    public DirectoryDTO get() {
        return urdepRastorRepository.get();
    }

    public boolean create(UrdepRastor urdepRastor) {
        return urdepRastorRepository.create(urdepRastor);
    }

    public boolean update(UrdepRastor urdepRastor) {
        return urdepRastorRepository.update(urdepRastor);
    }

    public boolean remove(String dimid) {
        return urdepRastorRepository.remove(dimid);
    }
}
