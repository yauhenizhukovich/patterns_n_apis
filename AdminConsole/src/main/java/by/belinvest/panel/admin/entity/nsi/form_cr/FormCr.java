package by.belinvest.panel.admin.entity.nsi.form_cr;


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
public class FormCr extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String krVidSdelki;


    public static FormCr fromJSON(HashMap<String,String> json){
        return FormCr.builder()
                .dimid(json.get("id"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .krVidSdelki(json.get("KR_VID_SDELKI"))
                .build();
    }
}
