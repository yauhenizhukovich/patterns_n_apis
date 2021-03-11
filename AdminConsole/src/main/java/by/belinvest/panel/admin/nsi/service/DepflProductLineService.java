package by.belinvest.panel.admin.nsi.service;

import java.util.List;

import by.belinvest.panel.admin.entity.catalog.BPCard;
import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.depfl_product_line.DepflProductLine;
import by.belinvest.panel.admin.nsi.db.DepflProductLineRepository;
import by.belinvest.panel.admin.nsi.db.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepflProductLineService {

    @Autowired
    private DepflProductLineRepository depflProductLineRepository;
    @Autowired
    private ListRepository listRepository;

    public DirectoryDTO get() {
        return depflProductLineRepository.get();
    }

    public boolean create(DepflProductLine depflProductLine, String nsiId) {
       listRepository.create(depflProductLine, nsiId);
        return depflProductLineRepository.create(depflProductLine, nsiId);
    }

    public boolean update(DepflProductLine depflProductLine) {
        return depflProductLineRepository.update(depflProductLine);
    }

    public boolean remove(String code) {
        return depflProductLineRepository.remove(code);
    }

    public List<BPCard> getBPCard() {
        return depflProductLineRepository.getBPCard();
    }

    public List<BPCard> getBPCard2() {
        return depflProductLineRepository.getBPCard2();
    }



    public BPCard getBPCardById(String id) {
        return depflProductLineRepository.getBPCardById(id);
    }

}
