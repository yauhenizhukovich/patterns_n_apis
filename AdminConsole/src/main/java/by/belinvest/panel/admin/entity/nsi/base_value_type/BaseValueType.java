package by.belinvest.panel.admin.entity.nsi.base_value_type;

import by.belinvest.panel.admin.entity.nsi.Directory;
import by.belinvest.panel.admin.entity.nsi.accstatus.AccStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseValueType extends Directory {
    private String id;
    private String name;

    public static BaseValueType fromJSON(HashMap<String,String> json){
        return BaseValueType.builder()
                .name(json.get("NAME"))
                .id(json.get("id"))
                .build();
    }
}
