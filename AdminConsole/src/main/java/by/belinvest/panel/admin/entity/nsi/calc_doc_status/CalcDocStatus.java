package by.belinvest.panel.admin.entity.nsi.calc_doc_status;


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
public class CalcDocStatus extends Directory {
    private String code;
    private String name;

    public static CalcDocStatus fromJSON(HashMap<String,String> json){
        return CalcDocStatus.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .build();
    }
}
