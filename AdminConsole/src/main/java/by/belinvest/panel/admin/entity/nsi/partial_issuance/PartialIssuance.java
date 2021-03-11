package by.belinvest.panel.admin.entity.nsi.partial_issuance;


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
public class PartialIssuance extends Directory {
    private String id;
    private String code;
    private String name;
    private String note;



    public static PartialIssuance fromJSON(HashMap<String,String> json){
        return PartialIssuance.builder()
                .id(json.get("id"))
                .note(json.get("NOTE"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .build();
    }
}
