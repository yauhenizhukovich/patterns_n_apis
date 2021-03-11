package by.belinvest.panel.admin.entity.nsi.conditional_obligations;


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
public class ConditionalObligations extends Directory {
    private String code;
    private String name;

    public static ConditionalObligations fromJSON(HashMap<String,String> json){
        return ConditionalObligations.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
