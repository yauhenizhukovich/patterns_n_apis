package by.belinvest.panel.admin.entity.nsi.card_types_levels;


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
public class CardTypesLevels extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String ctlOrder;


    public static CardTypesLevels fromJSON(HashMap<String,String> json){
        return CardTypesLevels.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .ctlOrder(json.get("CTL_ORDER"))
                .build();
    }
}
