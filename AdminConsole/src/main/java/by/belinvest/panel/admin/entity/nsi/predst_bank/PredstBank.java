package by.belinvest.panel.admin.entity.nsi.predst_bank;


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
public class PredstBank extends Directory {
    private String code;
    private String name;
    private String doljnPredst;
    private String postR;
    private String fioRAdress;
    private String fioR;
    private String postRAccess;
    private String managerPersonNum;
    private String documPredst;


    public static PredstBank fromJSON(HashMap<String,String> json){
        return PredstBank.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .doljnPredst(json.get("DOLJN_PREDST"))
                .postR(json.get("POST_R"))
                .fioRAdress(json.get("FIO_R_ACCESS"))
                .fioR(json.get("FIO_R"))
                .postRAccess(json.get("POST_R_ACCESS"))
                .managerPersonNum(json.get("MANAGER_PERSON_NUM"))
                .documPredst(json.get("DOKUM_PREDST"))
                .build();
    }
}
