package by.belinvest.panel.admin.entity.nsi.gr_risk;


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
public class GRRisk extends Directory {
    private String dimid;
    private String code;
    private String name;

    public static GRRisk fromJSON(HashMap<String,String> json){
        return GRRisk.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .build();
    }
}
