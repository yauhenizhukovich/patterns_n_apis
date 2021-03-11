package by.belinvest.panel.admin.entity.nsi.term_unit;


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
public class TermUnit extends Directory {
    private String id;
    private String code;
    private String name;
    private String note;

    public static TermUnit fromJSON(HashMap<String,String> json){
        return TermUnit.builder()
                .id(json.get("id"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .note(json.get("NOTE"))
                .build();
    }
}
