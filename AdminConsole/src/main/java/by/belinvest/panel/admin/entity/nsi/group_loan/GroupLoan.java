package by.belinvest.panel.admin.entity.nsi.group_loan;


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
public class GroupLoan extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;


    public static GroupLoan fromJSON(HashMap<String,String> json){
        return GroupLoan.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .build();
    }
}
