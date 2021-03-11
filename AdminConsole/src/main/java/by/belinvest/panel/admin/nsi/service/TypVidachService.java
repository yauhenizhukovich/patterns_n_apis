package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.typ_vidach.TypVidach;
import by.belinvest.panel.admin.nsi.db.TypVidachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypVidachService {
    @Autowired
    private TypVidachRepository typVidachRepository;

    public DirectoryDTO get() {
        return typVidachRepository.get();
    }

    public boolean create(TypVidach typVidach) {
        return typVidachRepository.create(typVidach);
    }

    public boolean update(TypVidach typVidach) {
        return typVidachRepository.update(typVidach);
    }

    public boolean remove(String dimid) {
        return typVidachRepository.remove(dimid);
    }
}
