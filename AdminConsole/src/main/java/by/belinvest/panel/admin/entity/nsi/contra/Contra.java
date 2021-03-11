package by.belinvest.panel.admin.entity.nsi.contra;


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
public class Contra extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String nsi010contra;


    public static Contra fromJSON(HashMap<String,String> json){
        return Contra.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .nsi010contra(json.get("NSI_010_CONTRA"))
                .build();
    }
}
