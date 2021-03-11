package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.types_orgstrucrure.TypesOrgStructure;
import by.belinvest.panel.admin.nsi.db.TypesOrgstructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypesOrgstructureSerivce {
    @Autowired
    private TypesOrgstructureRepository typesOrgstructureRepository;

    public DirectoryDTO get() {
        return typesOrgstructureRepository.get();
    }

    public boolean create(TypesOrgStructure typesOrgStructure) {
        return typesOrgstructureRepository.create(typesOrgStructure);
    }

    public boolean update(TypesOrgStructure typesOrgStructure) {
        return typesOrgstructureRepository.update(typesOrgStructure);
    }

    public boolean remove(String dimid) {
        return typesOrgstructureRepository.remove(dimid);
    }
}
