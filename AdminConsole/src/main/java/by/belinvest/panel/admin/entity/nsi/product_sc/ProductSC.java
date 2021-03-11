package by.belinvest.panel.admin.entity.nsi.product_sc;


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
public class ProductSC extends Directory {
    private String pscId;
    private String pscName;
    private String pscDesc;



    public static ProductSC fromJSON(HashMap<String,String> json){
        return ProductSC.builder()
                .pscId(json.get("id"))
                .pscName(json.get("PSC_NAME"))
                .pscDesc(json.get("PSC_DESC"))
                .build();
    }
}
