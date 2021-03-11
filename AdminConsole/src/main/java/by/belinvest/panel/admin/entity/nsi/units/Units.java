package by.belinvest.panel.admin.entity.nsi.units;


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
public class Units extends Directory {
    private String idUnit;
    private String unitFullName;
    private String unitName;
    private String isDeveloper;
    private String managerName;
    private String managerPosition;
    private String curator;
    private String superiorUnit;


    public static Units fromJSON(HashMap<String,String> json){
        return Units.builder()
                .idUnit(json.get("id"))
                .unitFullName(json.get("UNIT_FULLNAME"))
                .unitName(json.get("UNIT_NAME"))
                .isDeveloper(json.get("IS_DEVELOPER"))
                .managerName(json.get("MANAGER_NAME"))
                .managerPosition(json.get("MANAGER_POSITION"))
                .curator(json.get("CURATOR"))
                .superiorUnit(json.get("SUPERIOR_UNIT"))
                .build();
    }
}
