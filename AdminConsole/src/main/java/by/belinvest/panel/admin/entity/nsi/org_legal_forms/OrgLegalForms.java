package by.belinvest.panel.admin.entity.nsi.org_legal_forms;


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
public class OrgLegalForms extends Directory {
    private String dimid;
    private String code;
    private String name;

    public static OrgLegalForms fromJSON(HashMap<String,String> json){
        return OrgLegalForms.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .build();
    }
}
