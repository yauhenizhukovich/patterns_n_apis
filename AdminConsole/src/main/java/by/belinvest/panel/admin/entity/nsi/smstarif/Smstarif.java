package by.belinvest.panel.admin.entity.nsi.smstarif;


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
public class Smstarif extends Directory {
    private String dimid;
    private String code;
    private String name;

    public static Smstarif fromJSON(HashMap<String,String> json){
        return Smstarif.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .build();
    }
}
