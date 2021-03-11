package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.predst_bank.PredstBank;
import by.belinvest.panel.admin.nsi.db.PredstBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredstBankService {
    @Autowired
    private PredstBankRepository predstBankRepository;

    public DirectoryDTO get() {
        return predstBankRepository.get();
    }

    public boolean create(PredstBank predstBank) {
        return predstBankRepository.create(predstBank);
    }

    public boolean update(PredstBank predstBank) {
        return predstBankRepository.update(predstBank);
    }

    public boolean remove(String id) {
        return predstBankRepository.remove(id);
    }
}
