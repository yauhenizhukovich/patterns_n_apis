package by.belinvest.panel.admin.entity.nsi.ministry;


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
public class Ministry extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String interCode;


    public static Ministry fromJSON(HashMap<String,String> json){
        return Ministry.builder()
                .dimid(json.get("id"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .interCode(json.get("INTER_CODE"))
                .build();
    }
}
