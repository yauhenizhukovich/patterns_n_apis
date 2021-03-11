package by.belinvest.panel.admin.entity.nsi.nsi_805;


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
public class Nsi805 extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String krVidSdelki805;
    private String krObesp805;



    public static Nsi805 fromJSON(HashMap<String,String> json){
        return Nsi805.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .krVidSdelki805(json.get("KR_VID_SDELKI_805"))
                .krObesp805(json.get("KR_OBESP_805"))
                .build();
    }
}
