package by.belinvest.panel.admin.entity.audit.log_acc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogAcc {
    private String taskName;
    private String nsiId;
    private String syncDate;
    private String syncAction;
    private String syncResult;
}
