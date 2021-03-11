package by.belinvest.panel.admin.entity.nsi.nsi_803;


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
public class Nsi803 extends Directory {
    private String dimid;
    private String code;
    private String name;

    public static Nsi803 fromJSON(HashMap<String,String> json){
        return Nsi803.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .build();
    }
}
