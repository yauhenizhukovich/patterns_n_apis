package by.belinvest.panel.admin.entity.nsi.dep_currency;

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
public class DepCurrency extends Directory {
    private String code;
    private String name;

    public static DepCurrency fromJSON(HashMap<String,String> json){
        return DepCurrency.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
