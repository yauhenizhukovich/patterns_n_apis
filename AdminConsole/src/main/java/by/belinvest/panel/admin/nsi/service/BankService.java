package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.bank.Bank;
import by.belinvest.panel.admin.entity.nsi.bank.BankDirectory;
import by.belinvest.panel.admin.nsi.db.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public BankDirectory get() {
        return bankRepository.get();
    }

    public boolean create(Bank bank) {
        return bankRepository.create(bank);
    }

    public boolean update(Bank bank) {
        return bankRepository.update(bank);
    }

    public boolean remove(String id) {
        return bankRepository.remove(id);
    }
}

