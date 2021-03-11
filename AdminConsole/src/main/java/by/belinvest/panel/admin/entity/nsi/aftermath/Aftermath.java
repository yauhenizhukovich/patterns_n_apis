package by.belinvest.panel.admin.entity.nsi.aftermath;

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
public class Aftermath extends Directory {
    private String idAftermath;
    private String aftermathName;
    private String aftermathDesc;

    public static Aftermath fromJSON(HashMap<String,String> json){
        return Aftermath.builder()
                .idAftermath(json.get("id"))
                .aftermathName(json.get("AFTERMATH_NAME"))
                .aftermathDesc(json.get("AFTERMATH_DESC"))
                .build();
    }
}
