package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_product_line.DepProductLine;
import by.belinvest.panel.admin.nsi.db.BLResidencyRepository;
import by.belinvest.panel.admin.nsi.db.DepProductLineRepository;
import by.belinvest.panel.admin.nsi.db.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepProductLineService {
    @Autowired
    private DepProductLineRepository depProductLineRepository;
    @Autowired
    private ListRepository listRepository;

    public DirectoryDTO get() {
        return depProductLineRepository.get();
    }

    public boolean create(DepProductLine depProductLine,String nsiId) {
        listRepository.create(depProductLine,nsiId);
        return depProductLineRepository.create(depProductLine,nsiId);
    }

    public boolean update(DepProductLine depProductLine) {
        return depProductLineRepository.update(depProductLine);
    }

    public boolean remove(String code) {
        return depProductLineRepository.remove(code);
    }
}
