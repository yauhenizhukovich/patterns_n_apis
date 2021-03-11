package by.belinvest.panel.admin.entity.audit.log_user_act;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LogUserActDirectory {

    private final List<LogUserAct> logUserActs = new ArrayList<>();

    private String userNameDescription;
    private String actDateDescription;
    private String actionDescription;

}
