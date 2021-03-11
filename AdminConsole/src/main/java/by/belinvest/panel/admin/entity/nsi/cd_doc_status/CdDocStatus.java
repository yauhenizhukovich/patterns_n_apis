package by.belinvest.panel.admin.entity.nsi.cd_doc_status;


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
public class CdDocStatus extends Directory {
    private String code;
    private String name;

    public static CdDocStatus fromJSON(HashMap<String,String> json){
        return CdDocStatus.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
