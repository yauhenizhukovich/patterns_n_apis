package by.belinvest.panel.admin.entity.nsi.fo_oper_status;


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
public class FoOperStatus extends Directory {
    private String code;
    private String name;

    public static FoOperStatus fromJSON(HashMap<String,String> json){
        return FoOperStatus.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
