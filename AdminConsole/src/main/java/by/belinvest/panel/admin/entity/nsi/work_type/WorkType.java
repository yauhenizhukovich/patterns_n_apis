package by.belinvest.panel.admin.entity.nsi.work_type;


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
public class WorkType extends Directory {
    private String code;
    private String name;

    public static WorkType fromJSON(HashMap<String,String> json){
        return WorkType.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
