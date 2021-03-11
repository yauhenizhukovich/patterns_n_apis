package by.belinvest.panel.admin.entity.audit.log_sys_event;

import by.belinvest.panel.admin.entity.audit.log_acc.LogAcc;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LogSysEventDirectory {

    private final List<LogSysEvent> logSysEvents = new ArrayList<>();

    private String eventDateDescription;
    private String eventTypeDescription;
    private String eventSourceDescription;
    private String serverNameDescription;
    private String messageDescription;

}
