package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.roles.Roles;
import by.belinvest.panel.admin.entity.nsi.roles.RolesDirectory;
import by.belinvest.panel.admin.nsi.db.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public RolesDirectory get() {
        return rolesRepository.get();
    }

    public boolean create(Roles roles) {
        return rolesRepository.create(roles);
    }

    public boolean update(Roles roles) {
        return rolesRepository.update(roles);
    }

    public boolean remove(String id) {
        return rolesRepository.remove(id);
    }
}

