package by.belinvest.panel.admin.audit.service.log_user_act;

import by.belinvest.panel.admin.audit.db.log_user_act.LogUserActRepository;
import by.belinvest.panel.admin.entity.audit.log_user_act.LogUserAct;
import by.belinvest.panel.admin.entity.audit.log_user_act.LogUserActDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogUserActService {

    @Autowired
    private LogUserActRepository logUserActRepository;

    public LogUserActDirectory get() {
        return logUserActRepository.get();
    }

    public boolean create(LogUserAct logUserAct) {
        return logUserActRepository.create(logUserAct);
    }

}
