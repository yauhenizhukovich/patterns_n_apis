package by.belinvest.panel.admin.entity.audit.log_sys_event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogSysEvent {
    private String eventDate;
    private String eventType;
    private String eventSource;
    private String serverName;
    private String message;
}
