package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.org_legal_forms.OrgLegalForms;
import by.belinvest.panel.admin.nsi.db.OrgLegalFormsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgLegalFormsService {
    @Autowired
    private OrgLegalFormsRepository orgLegalFormsRepository;

    public DirectoryDTO get() {
        return orgLegalFormsRepository.get();
    }

    public boolean create(OrgLegalForms orgLegalForms) {
        return orgLegalFormsRepository.create(orgLegalForms);
    }

    public boolean update(OrgLegalForms orgLegalForms) {
        return orgLegalFormsRepository.update(orgLegalForms);
    }

    public boolean remove(String dimid) {
        return orgLegalFormsRepository.remove(dimid);
    }
}
