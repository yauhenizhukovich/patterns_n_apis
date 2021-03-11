package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.depfl_terms.DepflTerms;
import by.belinvest.panel.admin.nsi.db.DepflTermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepflTermsService {
    @Autowired
    private DepflTermsRepository depflTermsRepository;

    public DirectoryDTO get() {
        return depflTermsRepository.get();
    }

    public boolean create(DepflTerms depTerms) {
        return depflTermsRepository.create(depTerms);
    }

    public boolean update(DepflTerms depTerms) {
        return depflTermsRepository.update(depTerms);
    }

    public boolean remove(String code) {
        return depflTermsRepository.remove(code);
    }
}
