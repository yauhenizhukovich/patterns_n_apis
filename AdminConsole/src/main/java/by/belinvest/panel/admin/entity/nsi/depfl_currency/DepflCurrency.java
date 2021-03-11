package by.belinvest.panel.admin.entity.nsi.depfl_currency;

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
public class DepflCurrency extends Directory {
    private String code;
    private String name;

    public static DepflCurrency fromJSON(HashMap<String,String> json){
        return DepflCurrency.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
