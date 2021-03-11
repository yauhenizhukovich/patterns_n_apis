package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.form_cr.FormCr;
import by.belinvest.panel.admin.nsi.db.FormCrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormCrService {
    @Autowired
    private FormCrRepository formCrRepository;

    public DirectoryDTO get() {
        return formCrRepository.get();
    }

    public boolean create(FormCr formCr) {
        return formCrRepository.create(formCr);
    }

    public boolean update(FormCr formCr) {
        return formCrRepository.update(formCr);
    }

    public boolean remove(String dimid) {
        return formCrRepository.remove(dimid);
    }
}
