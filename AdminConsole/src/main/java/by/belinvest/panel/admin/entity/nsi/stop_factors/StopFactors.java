package by.belinvest.panel.admin.entity.nsi.stop_factors;


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
public class StopFactors extends Directory {
    private String sfId;
    private String sfName;
    private String sfDesc;

    public static StopFactors fromJSON(HashMap<String,String> json){
        return StopFactors.builder()
                .sfId(json.get("id"))
                .sfName(json.get("SF_NAME"))
                .sfDesc(json.get("SF_DESC"))
                .build();
    }
}
