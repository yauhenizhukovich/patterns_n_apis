package by.belinvest.panel.admin.entity.nsi.economy_activity;


import by.belinvest.panel.admin.entity.nsi.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EconomyActivity extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String k1;
    private String k2;
    private String k3;
    private String oldCodes;

    public static EconomyActivity fromJSON(HashMap<String,String> json){
        return EconomyActivity.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .k1(json.get("K1"))
                .k2(json.get("K2"))
                .k3(json.get("K3"))
                .oldCodes(json.get("OLD_CODES"))
                .build();
    }
}
