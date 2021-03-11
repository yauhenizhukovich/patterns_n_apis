package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.cardtype.CardType;
import by.belinvest.panel.admin.nsi.db.CardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTypeService {

    @Autowired
    private CardTypeRepository cardTypeRepository;

    public DirectoryDTO get() {
        return cardTypeRepository.get();
    }

    public boolean create(CardType cardType) {
        return cardTypeRepository.create(cardType);
    }

    public boolean update(CardType cardType) {
        return cardTypeRepository.update(cardType);
    }

    public boolean remove(String dimid) {
        return cardTypeRepository.remove(dimid);
    }
}
