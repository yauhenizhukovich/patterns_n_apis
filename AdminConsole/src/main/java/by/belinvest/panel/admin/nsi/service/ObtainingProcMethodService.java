package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.obtaining_proc_method.ObtainingProcMethod;
import by.belinvest.panel.admin.nsi.db.ObtainingProcMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtainingProcMethodService {
    @Autowired
    private ObtainingProcMethodRepository repository;

    public DirectoryDTO get() {
        return repository.get();
    }

    public boolean create(ObtainingProcMethod obtainingProcMethod) {
        return repository.create(obtainingProcMethod);
    }

    public boolean update(ObtainingProcMethod obtainingProcMethod) {
        return repository.update(obtainingProcMethod);
    }

    public boolean remove(String id) {
        return repository.remove(id);
    }
}
