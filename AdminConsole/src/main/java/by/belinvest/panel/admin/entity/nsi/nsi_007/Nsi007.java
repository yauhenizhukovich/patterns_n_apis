package by.belinvest.panel.admin.entity.nsi.nsi_007;


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
public class Nsi007 extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String nameSwift;
    private String borderState;
    private String ratingValuta;
    private String codeSwift;
    private String ratingNacval;
    private String signOesr;
    private String offshorZone;
    private String signEu;
    private String signsCorruption;
    private String hazardousRegion;
    private String codeValuta;
    private String isoAlpha3Code;
    private String groupCountry;


    public static Nsi007 fromJSON(HashMap<String,String> json){
        return Nsi007.builder()
                .dimid(json.get("id"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .nameSwift(json.get("NAME_SWIFT"))
                .borderState(json.get("BORDER_STATE"))
                .ratingValuta(json.get("RATING_VALUTA"))
                .codeSwift(json.get("CODE_SWIFT"))
                .ratingNacval(json.get("RATING_NACVAL"))
                .signOesr(json.get("SIGN_OESR"))
                .offshorZone(json.get("OFFSHOR_ZONE"))
                .signEu(json.get("SIGN_EU"))
                .signsCorruption(json.get("SIGNS_CORRUPTION"))
                .hazardousRegion(json.get("HAZARDOUS_REGION"))
                .codeValuta(json.get("CODE_VALUTA"))
                .isoAlpha3Code(json.get("ISO_ALPHA3_CODE"))
                .groupCountry(json.get("GROUP_COUNTRY"))
                .build();
    }
}
