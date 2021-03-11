package by.belinvest.panel.admin.entity.nsi.risks;


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
public class Risks extends Directory {
    private String idRisk;
    private String riskName;
    private String description;

    public static Risks fromJSON(HashMap<String,String> json){
        return Risks.builder()
                .idRisk(json.get("id"))
                .riskName(json.get("RISK_NAME"))
                .description(json.get("DESCRIPTION"))
                .build();
    }
}
