package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.interest_rate_type.InterestRateType;
import by.belinvest.panel.admin.nsi.db.InterestRateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestRateTypeService {
    @Autowired
    private InterestRateTypeRepository interestRateTypeRepository;

    public DirectoryDTO get() {
        return interestRateTypeRepository.get();
    }

    public boolean create(InterestRateType interestRateType) {
        return interestRateTypeRepository.create(interestRateType);
    }

    public boolean update(InterestRateType interestRateType) {
        return interestRateTypeRepository.update(interestRateType);
    }

    public boolean remove(String id) {
        return interestRateTypeRepository.remove(id);
    }

}
