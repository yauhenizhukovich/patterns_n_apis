package by.belinvest.panel.admin.entity.nsi.exec_status;


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
public class ExecStatus extends Directory {
    private String code;
    private String name;

    public static ExecStatus fromJSON(HashMap<String,String> json){
        return ExecStatus.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
