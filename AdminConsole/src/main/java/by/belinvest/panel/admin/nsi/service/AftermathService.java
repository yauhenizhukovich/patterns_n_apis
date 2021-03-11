package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.aftermath.Aftermath;
import by.belinvest.panel.admin.nsi.db.AftermathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AftermathService {
    @Autowired
    private AftermathRepository aftermathRepository;

    public DirectoryDTO get() {
        return aftermathRepository.get();
    }

    public boolean create(Aftermath aftermath) {
        return aftermathRepository.create(aftermath);
    }

    public boolean update(Aftermath aftermath) {
        return aftermathRepository.update(aftermath);
    }

    public boolean remove(String id) {
        return aftermathRepository.remove(id);
    }
}
