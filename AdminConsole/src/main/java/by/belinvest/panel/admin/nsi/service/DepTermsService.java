package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_terms.DepTerms;
import by.belinvest.panel.admin.nsi.db.DepTermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepTermsService {
    @Autowired
    private DepTermsRepository depTermsRepository;

    public DirectoryDTO get() {
        return depTermsRepository.get();
    }

    public boolean create(DepTerms depTerms) {
        return depTermsRepository.create(depTerms);
    }

    public boolean update(DepTerms depTerms) {
        return depTermsRepository.update(depTerms);
    }

    public boolean remove(String code) {
        return depTermsRepository.remove(code);
    }
}
