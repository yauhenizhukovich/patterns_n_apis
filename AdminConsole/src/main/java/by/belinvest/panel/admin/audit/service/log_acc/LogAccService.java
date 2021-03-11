package by.belinvest.panel.admin.audit.service.log_acc;

import by.belinvest.panel.admin.audit.db.log_acc.LogAccRepository;
import by.belinvest.panel.admin.entity.audit.log_acc.LogAcc;
import by.belinvest.panel.admin.entity.audit.log_acc.LogAccDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogAccService {

    @Autowired
    private LogAccRepository logAccRepository;

    public LogAccDirectory get() {
        return logAccRepository.get();
    }

    public boolean create(LogAcc logAcc) {
        return logAccRepository.create(logAcc);
    }

}
