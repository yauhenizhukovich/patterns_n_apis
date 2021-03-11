package by.belinvest.panel.admin.entity.nsi.proc_users;


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
public class ProcUsers extends Directory {
    private String id;
    private String userId;
    private String roleId;
    private String roleDesc;
    private String roleLock;
    private String dateFrom;
    private String dateTo;
    private String userFullname;



    public static ProcUsers fromJSON(HashMap<String,String> json){
        return ProcUsers.builder()
                .id(json.get("id"))
                .userId(json.get("USER_ID"))
                .roleId(json.get("ROLE_ID"))
                .roleDesc(json.get("ROLE_DESC"))
                .roleLock(json.get("ROLE_LOCK"))
                .dateFrom(json.get("DATE_FROM"))
                .dateTo(json.get("DATE_TO"))
                .userFullname(json.get("USER_FULLNAME"))
                .build();
    }
}
