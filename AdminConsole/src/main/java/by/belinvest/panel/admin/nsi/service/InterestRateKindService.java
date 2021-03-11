package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.interest_rate_kind.InterestRateKind;
import by.belinvest.panel.admin.nsi.db.InterestRateKindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestRateKindService {
    @Autowired
    private InterestRateKindRepository interestRateKindRepository;

    public DirectoryDTO get() {
        return interestRateKindRepository.get();
    }

    public boolean create(InterestRateKind interestRateKind) {
        return interestRateKindRepository.create(interestRateKind);
    }

    public boolean update(InterestRateKind interestRateKind) {
        return interestRateKindRepository.update(interestRateKind);
    }

    public boolean remove(String id) {
        return interestRateKindRepository.remove(id);
    }
}
