package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.pos_credit_organisations.PosCreditOrganisations;
import by.belinvest.panel.admin.nsi.db.PosCreditOrganisationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosCreditOrganistionsService {
    @Autowired
    private PosCreditOrganisationsRepository posCreditOrganisationsRepository;

    public DirectoryDTO get() {
        return posCreditOrganisationsRepository.get();
    }

    public boolean create(PosCreditOrganisations posCreditOrganisations) {
        return posCreditOrganisationsRepository.create(posCreditOrganisations);
    }

    public boolean update(PosCreditOrganisations posCreditOrganisations) {
        return posCreditOrganisationsRepository.update(posCreditOrganisations);
    }

    public boolean remove(String id) {
        return posCreditOrganisationsRepository.remove(id);
    }
}
