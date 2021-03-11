package by.belinvest.panel.admin.entity.nsi.depfl_terms;

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
public class DepflTerms extends Directory {
    private String code;
    private String name;

    public static DepflTerms fromJSON(HashMap<String,String> json){
        return DepflTerms.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
