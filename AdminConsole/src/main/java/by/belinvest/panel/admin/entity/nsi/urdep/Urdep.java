package by.belinvest.panel.admin.entity.nsi.urdep;


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
public class Urdep extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String decreaseStav;
    private String prodStav;
    private String depSumbl;
    private String srok;
    private String type;
    private String srVozvrat;
    private String porogSum;
    private String sumSpis;
    private String maxSrok;
    private String stavSpis;
    private String uslRastor;
    private String bloc;
    private String sumdog;
    private String allowAddition;
    private String banDeys;
    private String stavRast;
    private String depStavka;
    private String goal;
    private String shkalaStav;
    private String kol;
    private String nachProc;
    private String procRast;
    private String maxStav;
    private String maxLimit;
    private String takeAllow;
    private String minSrok;
    private String stavRastVal;
    private String srokWaitReturn;
    private String limit;
    private String contract;
    private String additionalIncome;
    private String kontrMaxStav;
    private String currency;
    private String stavPorog;


    public static Urdep fromJSON(HashMap<String,String> json){
        return Urdep.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .decreaseStav(json.get("DEP_PROC_DECREASE_STAV"))
                .prodStav(json.get("DEP_VID_PROC_STAV"))
                .depSumbl(json.get("DEP_SUMBL"))
                .srok(json.get("DEP_SROK"))
                .type(json.get("DEP_TYPE"))
                .srVozvrat(json.get("DEP_SR_VOZVRAT"))
                .porogSum(json.get("DEP_POROG_SUM"))
                .sumSpis(json.get("DEP_SUM_SPIS"))
                .maxSrok(json.get("DEP_MAX_SROK"))
                .stavSpis(json.get("DEP_STAV_SPIS"))
                .uslRastor(json.get("DEP_USL_RASTOR"))
                .bloc(json.get("DEP_BLOC"))
                .sumdog(json.get("DEP_SUMDOG"))
                .allowAddition(json.get("DEP_ALLOW_ADDITION"))
                .banDeys(json.get("DEP_BAN_DEYS"))
                .stavRast(json.get("DEP_STAV_RAST"))
                .depStavka(json.get("DEP_STAVKA"))
                .goal(json.get("DEP_GOAL"))
                .shkalaStav(json.get("DEP_SHKALA_STAV"))
                .kol(json.get("DEP_KOL"))
                .nachProc(json.get("DEP_TYPE_NACH_PROC"))
                .procRast(json.get("DEP_PROC_RAST"))
                .maxStav(json.get("DEP_MAX_STAV"))
                .maxLimit(json.get("DEP_MAX_LIMIT"))
                .takeAllow(json.get("DEP_PROC_TAKE_ALLOW"))
                .minSrok(json.get("DEP_MIN_SROK"))
                .stavRastVal(json.get("DEP_STAV_RAST_VAL"))
                .srokWaitReturn(json.get("DEP_SROK_WAIT_RETURN"))
                .limit(json.get("DEP_LIMIT"))
                .contract(json.get("DEP_TYPE_CONTRACT"))
                .additionalIncome(json.get("DEP_ADDITIONAL_INCOME"))
                .kontrMaxStav(json.get("DEP_KONTR_MAX_STAV"))
                .currency(json.get("DEP_CURRENCY"))
                .stavPorog(json.get("DEP_STAV_POROG"))
                .build();
    }
}
