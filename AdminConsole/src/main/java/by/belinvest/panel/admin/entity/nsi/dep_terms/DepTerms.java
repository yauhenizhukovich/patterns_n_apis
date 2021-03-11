package by.belinvest.panel.admin.entity.nsi.dep_terms;

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
public class DepTerms extends Directory {
    private String code;
    private String name;

    public static DepTerms fromJSON(HashMap<String,String> json){
        return DepTerms.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
