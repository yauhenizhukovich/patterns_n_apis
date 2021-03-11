package by.belinvest.panel.admin.entity.nsi.nsi_570;


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
public class Nsi570 extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String note;



    public static Nsi570 fromJSON(HashMap<String,String> json){
        return Nsi570.builder()
                .dimid(json.get("id"))
                .note(json.get("NOTE"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .build();
    }
}
