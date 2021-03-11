package by.belinvest.panel.admin.entity.nsi.accstatus;


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
public class AccStatus extends Directory {
    private String code;
    private String name;

    public static AccStatus fromJSON(HashMap<String,String> json){
        return AccStatus.builder()
                .name(json.get("NAME"))
                .code(json.get("id"))
                .build();
    }
}
