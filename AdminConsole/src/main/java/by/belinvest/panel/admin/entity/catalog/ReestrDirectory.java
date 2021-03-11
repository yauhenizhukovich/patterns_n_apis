package by.belinvest.panel.admin.entity.catalog;

import by.belinvest.panel.admin.entity.audit.log_acc.LogAcc;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ReestrDirectory {

    private final List<Reestr> reestrs = new ArrayList<>();

    public List<Reestr> getReestrs() {
        return reestrs;
    }


}
