package by.belinvest.panel.admin.audit.service.log_sys_event;

import by.belinvest.panel.admin.audit.db.log_sys_event.LogSysEventRepository;
import by.belinvest.panel.admin.entity.audit.log_sys_event.LogSysEvent;
import by.belinvest.panel.admin.entity.audit.log_sys_event.LogSysEventDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogSysEventService {

    @Autowired
    private LogSysEventRepository logSysEventRepository;

    public LogSysEventDirectory get() {
        return logSysEventRepository.get();
    }

    public boolean create(LogSysEvent logSysEvent) {
        return logSysEventRepository.create(logSysEvent);
    }

}
