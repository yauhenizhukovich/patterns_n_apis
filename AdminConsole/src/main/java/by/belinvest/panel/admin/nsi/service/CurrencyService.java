package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.currency.Currency;
import by.belinvest.panel.admin.nsi.db.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public DirectoryDTO get() {
        return currencyRepository.get();
    }

    public boolean create(Currency currency) {
        return currencyRepository.create(currency);
    }

    public boolean update(Currency currency) {
        return currencyRepository.update(currency);
    }

    public boolean remove(String dimid) {
        return currencyRepository.remove(dimid);
    }
}
