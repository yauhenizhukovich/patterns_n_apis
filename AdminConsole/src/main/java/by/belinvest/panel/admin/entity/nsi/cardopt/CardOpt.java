package by.belinvest.panel.admin.entity.nsi.cardopt;


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
public class CardOpt extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String cardOptElement;
    private String cardOptSearch;


    public static CardOpt fromJSON(HashMap<String,String> json){
        return CardOpt.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .cardOptElement(json.get("CARD_OPT_ELEMENT"))
                .cardOptSearch(json.get("CARD_OPT_SEARCH"))
                .build();
    }
}
