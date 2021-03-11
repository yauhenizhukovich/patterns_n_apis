package by.belinvest.panel.admin.entity.nsi.status_prod;


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
public class StatusProd extends Directory {
    private String id;
    private String nameRus;
    private String nameEng;

    public static StatusProd fromJSON(HashMap<String,String> json){
        return StatusProd.builder()
                .id(json.get("id"))
                .nameRus(json.get("NAME_RUS"))
                .nameEng(json.get("NAME_ENG"))
                .build();
    }
}
