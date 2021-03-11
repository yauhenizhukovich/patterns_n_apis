package by.belinvest.panel.admin.entity.audit.log_nsi;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LogNsiDirectory {

    private final List<LogNsi> logNsis = new ArrayList<>();

    private String nsiNameDescription;
    private String nsiIdDescription;
    private String syncDateDescription;
    private String syncActionDescription;
    private String syncResultDescription;

}
