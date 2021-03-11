package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.conditional_obligations.ConditionalObligations;
import by.belinvest.panel.admin.nsi.db.ConditionalObligationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionalObligationsService {
    @Autowired
    private ConditionalObligationsRepository conditionalObligationsRepository;

    public DirectoryDTO get() {
        return conditionalObligationsRepository.get();
    }

    public boolean create(ConditionalObligations conditionalObligations) {
        return conditionalObligationsRepository.create(conditionalObligations);
    }

    public boolean update(ConditionalObligations conditionalObligations) {
        return conditionalObligationsRepository.update(conditionalObligations);
    }

    public boolean remove(String dimid) {
        return conditionalObligationsRepository.remove(dimid);
    }
}
