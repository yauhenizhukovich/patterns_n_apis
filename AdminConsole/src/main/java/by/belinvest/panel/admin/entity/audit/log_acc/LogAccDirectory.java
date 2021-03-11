package by.belinvest.panel.admin.entity.audit.log_acc;

import by.belinvest.panel.admin.entity.audit.log_nsi.LogNsi;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LogAccDirectory {

    private final List<LogAcc> logAccs = new ArrayList<>();

    private String taskNameDescription;
    private String nsiIdDescription;
    private String syncDateDescription;
    private String syncActionDescription;
    private String syncResultDescription;

}
