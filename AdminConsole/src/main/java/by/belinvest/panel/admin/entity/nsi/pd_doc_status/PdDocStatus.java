package by.belinvest.panel.admin.entity.nsi.pd_doc_status;


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
public class PdDocStatus extends Directory {
    private String code;
    private String name;

    public static PdDocStatus fromJSON(HashMap<String,String> json){
        return PdDocStatus.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
