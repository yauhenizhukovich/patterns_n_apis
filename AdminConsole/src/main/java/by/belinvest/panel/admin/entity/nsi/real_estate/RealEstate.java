package by.belinvest.panel.admin.entity.nsi.real_estate;


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
public class RealEstate extends Directory {
    private String dimid;
    private String code;
    private String name;

    public static RealEstate fromJSON(HashMap<String,String> json){
        return RealEstate.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .build();
    }
}
