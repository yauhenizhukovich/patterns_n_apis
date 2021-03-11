package by.belinvest.panel.admin.entity.nsi.nsi_802;


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
public class Nsi802 extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String nsi812;


    public static Nsi802 fromJSON(HashMap<String,String> json){
        return Nsi802.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .nsi812(json.get("NSI_812"))
                .build();
    }
}
