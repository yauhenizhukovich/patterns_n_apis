package by.belinvest.panel.admin.entity.nsi.prospects;


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
public class Prospects extends Directory {
    private String idProspects;
    private String prospectsName;
    private String prospectsDesc;



    public static Prospects fromJSON(HashMap<String,String> json){
        return Prospects.builder()
                .idProspects(json.get("id"))
                .prospectsName(json.get("PROSPECTS_NAME"))
                .prospectsDesc(json.get("PROSPECTS_DESC"))
                .build();
    }
}
