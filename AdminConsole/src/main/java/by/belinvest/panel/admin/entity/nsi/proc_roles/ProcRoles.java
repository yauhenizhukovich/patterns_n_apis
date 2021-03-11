package by.belinvest.panel.admin.entity.nsi.proc_roles;


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
public class ProcRoles extends Directory {
    private String id;
    private String roleName;
    private String roleDesc;
    private String roleDesc2;
    private String creatDate;



    public static ProcRoles fromJSON(HashMap<String,String> json){
        return ProcRoles.builder()
                .id(json.get("id"))
                .roleName(json.get("ROLE_NAME"))
                .roleDesc(json.get("ROLE_DESC"))
                .roleDesc2(json.get("ROLE_DESC2"))
                .creatDate(json.get("CREATE_DATE"))
                .build();
    }
}
