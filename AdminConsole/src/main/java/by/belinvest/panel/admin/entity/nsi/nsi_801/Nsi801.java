package by.belinvest.panel.admin.entity.nsi.nsi_801;


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
public class Nsi801 extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String lgotnostSign;
    private String referInvest;
    private String gosmeropriatia;


    public static Nsi801 fromJSON(HashMap<String,String> json){
        return Nsi801.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .lgotnostSign(json.get("LGOTNOST_SIGN"))
                .referInvest(json.get("REFER_INVEST"))
                .gosmeropriatia(json.get("GOSMEROPRIATIA"))
                .build();
    }
}
