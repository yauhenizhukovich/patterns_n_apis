package by.belinvest.panel.admin.entity.nsi.kd_prod_prog;


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
public class KdProdProg extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String kdPpStRisk;
    private String kdPpTarg;
    private String kdPpRmDec;
    private String kdPpCondOblig;
    private String kdPpProd;
    private String kdPpType;
    private String kdPpPenyaVal;
    private String kdPpCurClient;
    private String kdPpCurForm;
    private String kdPpVidObes;
    private String kdPpIstFin;
    private String kdPpDost;
    private String kdPpCurBank;
    private String kdPpMicro;
    private String kdPpObor;
    private String kdPpTarif;
    private String kdPpTypeKr;
    private String kdPpTerm;
    private String kdPPDaysInY;


    public static KdProdProg fromJSON(HashMap<String,String> json){
        return KdProdProg.builder()
                .dimid(json.get("id"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .kdPpStRisk(json.get("KD_PP_ST_RISK"))
                .kdPpTarg(json.get("KD_PP_TARG"))
                .kdPpRmDec(json.get("KD_PP_RM_DEC"))
                .kdPpCondOblig(json.get("KD_PP_COND_OBLIG"))
                .kdPpProd(json.get("KD_PP_PROD"))
                .kdPpType(json.get("KD_PP_TYPE"))
                .kdPpPenyaVal(json.get("KD_PP_PENYA_VAL"))
                .kdPpCurClient(json.get("KD_PP_CUR_CLIENT"))
                .kdPpCurForm(json.get("KD_PP_FORM"))
                .kdPpVidObes(json.get("KD_PP_VID_OBES"))
                .kdPpIstFin(json.get("KD_PP_IST_FIN"))
                .kdPpDost(json.get("KD_PP_DOST"))
                .kdPpCurBank(json.get("KD_PP_CUR_BANK"))
                .kdPpMicro(json.get("KD_PP_MICRO"))
                .kdPpObor(json.get("KD_PP_OBOR"))
                .kdPpTarif(json.get("KD_PP_TARIF"))
                .kdPpTypeKr(json.get("KD_PP_TYPE_KR"))
                .kdPpTerm(json.get("KD_PP_TERM"))
                .kdPPDaysInY(json.get("KD_PP_DAYS_IN_Y"))
                .build();
    }
}
