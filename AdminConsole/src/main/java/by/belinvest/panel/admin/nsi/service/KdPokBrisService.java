package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.kd_pok_bris.KdPokBris;
import by.belinvest.panel.admin.nsi.db.KdPokBrisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KdPokBrisService {
    @Autowired
    private KdPokBrisRepository kdPokBrisRepository;

    public DirectoryDTO get() {
        return kdPokBrisRepository.get();
    }

    public boolean create(KdPokBris kdPokBris) {
        return kdPokBrisRepository.create(kdPokBris);
    }

    public boolean update(KdPokBris kdPokBris) {
        return kdPokBrisRepository.update(kdPokBris);
    }

    public boolean remove(String id) {
        return kdPokBrisRepository.remove(id);
    }
}
