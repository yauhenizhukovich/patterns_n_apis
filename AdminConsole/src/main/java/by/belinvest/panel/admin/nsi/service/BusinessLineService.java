package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.business_line.BusinessLine;
import by.belinvest.panel.admin.nsi.db.BusinessLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessLineService {

    @Autowired
    private BusinessLineRepository businessLineRepository;

    public DirectoryDTO get() {
        return businessLineRepository.get();
    }

    public boolean create(BusinessLine businessLine) {
        return businessLineRepository.create(businessLine);
    }

    public boolean update(BusinessLine businessLine) {
        return businessLineRepository.update(businessLine);
    }

    public boolean remove(String id) {
        return businessLineRepository.remove(id);
    }
}
