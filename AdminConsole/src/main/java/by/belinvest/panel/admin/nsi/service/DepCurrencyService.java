package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_currency.DepCurrency;
import by.belinvest.panel.admin.nsi.db.DepCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepCurrencyService {
    @Autowired
    private DepCurrencyRepository depCurrencyRepository;

    public DirectoryDTO get() {
        return depCurrencyRepository.get();
    }

    public boolean create(DepCurrency depCurrency) {
        return depCurrencyRepository.create(depCurrency);
    }

    public boolean update(DepCurrency depCurrency) {
        return depCurrencyRepository.update(depCurrency);
    }

    public boolean remove(String code) {
        return depCurrencyRepository.remove(code);
    }
}
