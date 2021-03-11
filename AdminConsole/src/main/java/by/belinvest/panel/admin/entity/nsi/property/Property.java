package by.belinvest.panel.admin.entity.nsi.property;


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
public class Property extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String propertyDepositName;


    public static Property fromJSON(HashMap<String,String> json){
        return Property.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .propertyDepositName(json.get("PROPERTY_DEPOSIT_NAME"))
                .build();
    }
}
