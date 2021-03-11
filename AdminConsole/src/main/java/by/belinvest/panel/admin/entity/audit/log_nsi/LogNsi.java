package by.belinvest.panel.admin.entity.audit.log_nsi;


import by.belinvest.panel.admin.entity.nsi.accstatus.AccStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogNsi {
    private String nsiName;
    private String nsiId;
    private String syncDate;
    private String syncAction;
    private String syncResult;
//
//    public static LogNsi fromJSON(HashMap<String,String> json){
//        return LogNsi.builder()
//                .nsiName(json.get("id"))
//                .nsiId(json.get("NSI_ID"))
//                .syncDate(json.get("SYNC_DATE"))
//                .syncAction(json.get("SYNC_ACTION"))
//                .syncResult(json.get("SYNC_RESULT"))
//                .build();
//    }


}
