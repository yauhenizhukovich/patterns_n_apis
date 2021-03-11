package by.belinvest.panel.admin.entity.nsi.freq_issue;


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
public class FreqIssue extends Directory {
    private String id;
    private String code;
    private String name;
    private String note;


    public static FreqIssue fromJSON(HashMap<String,String> json){
        return FreqIssue.builder()
                .id(json.get("id"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .note(json.get("NOTE"))
                .build();
    }
}
