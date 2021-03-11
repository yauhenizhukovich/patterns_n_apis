package by.belinvest.panel.admin.entity.nsi.typ_vidach;


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
public class TypVidach extends Directory {
    private String dimid;
    private String code;
    private String name;

    public static TypVidach fromJSON(HashMap<String,String> json){
        return TypVidach.builder()
                .dimid(json.get("id"))
                .name(json.get("NAME"))
                .code(json.get("CODE"))
                .build();
    }
}
