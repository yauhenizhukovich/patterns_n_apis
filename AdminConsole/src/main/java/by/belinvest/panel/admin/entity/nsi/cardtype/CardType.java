package by.belinvest.panel.admin.entity.nsi.cardtype;


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
public class CardType extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String curList;
    private String cardtypeCategory;
    private String cardtypePs;
    private String cardtypeTechnology;
    private String cardtypeTypeAddService;
    private String colorIb;


    public static CardType fromJSON(HashMap<String,String> json){
        return CardType.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .curList(json.get("CUR_LIST"))
                .cardtypeCategory(json.get("CARDTYPE_CATEGORY"))
                .cardtypePs(json.get("CARDTYPE_PS"))
                .cardtypeTechnology(json.get("CARDTYPE_TECHNOLOGY"))
                .cardtypeTypeAddService(json.get("CARDTYPE_TYPE_ADD_SERVICE"))
                .colorIb(json.get("COLOR_IB"))
                .build();
    }
}
