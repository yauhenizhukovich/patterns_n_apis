package by.belinvest.panel.admin.audit.service.log_nsi;

import by.belinvest.panel.admin.audit.db.log_nsi.LogNsiRepository;
import by.belinvest.panel.admin.entity.audit.log_nsi.LogNsi;
import by.belinvest.panel.admin.entity.audit.log_nsi.LogNsiDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogNsiService {

    @Autowired
    private LogNsiRepository logNsiRepository;

    public LogNsiDirectory getLogNsi() {
        return logNsiRepository.get();
    }

    public boolean create(LogNsi logNsi) {
        return logNsiRepository.create(logNsi);
    }

}
