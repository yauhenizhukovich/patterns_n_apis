package by.belinvest.panel.admin.entity.audit.log_user_act;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogUserAct {
    private String userName;
    private String actDate;
    private String action;
}
