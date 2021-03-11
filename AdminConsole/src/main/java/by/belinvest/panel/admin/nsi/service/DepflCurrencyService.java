package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.depfl_currency.DepflCurrency;
import by.belinvest.panel.admin.nsi.db.DepflCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepflCurrencyService {
    @Autowired
    private DepflCurrencyRepository depflCurrencyRepository;

    public DirectoryDTO get() {
        return depflCurrencyRepository.get();
    }

    public boolean create(DepflCurrency depflCurrency) {
        return depflCurrencyRepository.create(depflCurrency);
    }

    public boolean update(DepflCurrency depflCurrency) {
        return depflCurrencyRepository.update(depflCurrency);
    }

    public boolean remove(String code) {
        return depflCurrencyRepository.remove(code);
    }
}
