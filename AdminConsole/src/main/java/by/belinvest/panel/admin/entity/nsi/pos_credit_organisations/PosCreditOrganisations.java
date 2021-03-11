package by.belinvest.panel.admin.entity.nsi.pos_credit_organisations;


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
public class PosCreditOrganisations extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String pkoName;
    private String pkoAdress;
    private String pkoUnp;
    private String pkoBanks;
    private String pkoAccount;
    private String pkoBankPos;
    private String pkoNameTt;
    private String pkoAdressTt;
    private String pkoUnpTt;
    private String pkoBanksTt;
    private String pkoAccountTt;


    public static PosCreditOrganisations fromJSON(HashMap<String,String> json){
        return PosCreditOrganisations.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .pkoName(json.get("PKO_NAME"))
                .pkoAdress(json.get("PKO_ADRESS"))
                .pkoUnp(json.get("PKO_UNP"))
                .pkoBanks(json.get("PKO_BANKS"))
                .pkoAccount(json.get("PKO_ACCOUNT"))
                .pkoBankPos(json.get("PKO_BANKS_POS"))
                .pkoNameTt(json.get("PKO_NAME_TT"))
                .pkoAdressTt(json.get("PKO_ADRESS_TT"))
                .pkoUnpTt(json.get("PKO_UNP_TT"))
                .pkoBanksTt(json.get("PKO_BANKS_TT"))
                .pkoAccountTt(json.get("PKO_ACCOUNT_TT"))
                .build();
    }
}
