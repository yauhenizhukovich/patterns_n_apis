package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.cardopt.CardOpt;
import by.belinvest.panel.admin.nsi.db.CardOptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardOptService {

    @Autowired
    private CardOptRepository cardOptRepository;

    public DirectoryDTO get() {
        return cardOptRepository.get();
    }

    public boolean create(CardOpt cardOpt) {
        return cardOptRepository.create(cardOpt);
    }

    public boolean update(CardOpt cardOpt) {
        return cardOptRepository.update(cardOpt);
    }

    public boolean remove(String dimid) {
        return cardOptRepository.remove(dimid);
    }
}
