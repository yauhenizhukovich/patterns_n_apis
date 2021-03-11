package by.belinvest.panel.admin.entity.nsi.bn_refresh_log;

import by.belinvest.panel.admin.entity.nsi.Directory;
import by.belinvest.panel.admin.entity.nsi.bl_target_audience.BLTargetAudience;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.logging.Logger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BNRefreshLog extends Directory {
    private String name;
    private String startDate;
    private String endDate;
    private String cntrecIns;
    private String cntrecUpd;
    private String cntrecDel;
    private String note;

    public static BNRefreshLog fromJSON(HashMap<String,String> json){
        return BNRefreshLog.builder()
                .startDate(json.get("STARTDATE"))
                .endDate(json.get("ENDDATE"))
                .cntrecIns(json.get("CNTRECINS"))
                .cntrecUpd(json.get("CNTRECUPD"))
                .cntrecDel(json.get("CNTRECDEL"))
                .note(json.get("NOTE"))
                .name(json.get("id"))
                .build();
    }
}
