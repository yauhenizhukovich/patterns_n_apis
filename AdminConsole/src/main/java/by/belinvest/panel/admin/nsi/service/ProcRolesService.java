package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.proc_roles.ProcRoles;
import by.belinvest.panel.admin.nsi.db.ProcRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcRolesService {
    @Autowired
    private ProcRolesRepository procRolesRepository;

    public DirectoryDTO get() {
        return procRolesRepository.get();
    }

    public boolean create(ProcRoles procRoles) {
        return procRolesRepository.create(procRoles);
    }

    public boolean update(ProcRoles procRoles) {
        return procRolesRepository.update(procRoles);
    }

    public boolean remove(String id) {
        return procRolesRepository.remove(id);
    }
}
