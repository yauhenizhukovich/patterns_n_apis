package by.belinvest.panel.admin.entity.nsi.interest_rate_type;


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
public class InterestRateType extends Directory {
    private String id;
    private String code;
    private String name;
    private String note;



    public static InterestRateType fromJSON(HashMap<String,String> json){
        return InterestRateType.builder()
                .id(json.get("id"))
                .note(json.get("NOTE"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .build();
    }
}
