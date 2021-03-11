package by.belinvest.panel.admin.entity.nsi.bi_status;

import by.belinvest.panel.admin.entity.nsi.Directory;
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
public class BIStatus extends Directory {
    private String code;
    private String name;

    public static BIStatus fromJSON(HashMap<String,String> json){
        return BIStatus.builder()
                .name(json.get("NAME"))
                .code(json.get("id"))
                .build();
    }
}
