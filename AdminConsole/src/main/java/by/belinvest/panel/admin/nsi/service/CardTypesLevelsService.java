package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.card_types_levels.CardTypesLevels;
import by.belinvest.panel.admin.nsi.db.CardTypesLevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTypesLevelsService {

    @Autowired
    private CardTypesLevelsRepository cardTypesLevelsRepository;

    public DirectoryDTO get() {
        return cardTypesLevelsRepository.get();
    }

    public boolean create(CardTypesLevels cardTypesLevels) {
        return cardTypesLevelsRepository.create(cardTypesLevels);
    }

    public boolean update(CardTypesLevels cardTypesLevels) {
        return cardTypesLevelsRepository.update(cardTypesLevels);
    }

    public boolean remove(String dimid) {
        return cardTypesLevelsRepository.remove(dimid);
    }
}
