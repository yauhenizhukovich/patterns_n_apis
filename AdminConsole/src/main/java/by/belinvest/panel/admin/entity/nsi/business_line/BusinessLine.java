package by.belinvest.panel.admin.entity.nsi.business_line;


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
public class BusinessLine extends Directory {
    private String code;
    private String name;

    public static BusinessLine fromJSON(HashMap<String,String> json){
        return BusinessLine.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
