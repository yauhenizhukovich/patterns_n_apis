package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bank_nsi_json.BankNsiJson;
import by.belinvest.panel.admin.nsi.db.BankNsiJsonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankNsiJsonService {
    @Autowired
    private BankNsiJsonRepository bankNsiJsonRepository;

    public DirectoryDTO get() {
        return bankNsiJsonRepository.get();
    }

    public boolean create(BankNsiJson bankNsiJson) {
        return bankNsiJsonRepository.create(bankNsiJson);
    }

    public boolean update(BankNsiJson bankNsiJson) {
        return bankNsiJsonRepository.update(bankNsiJson);
    }

    public boolean remove(String id) {
        return bankNsiJsonRepository.remove(id);
    }
}
