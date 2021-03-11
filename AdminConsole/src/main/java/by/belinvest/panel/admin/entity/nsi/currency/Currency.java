package by.belinvest.panel.admin.entity.nsi.currency;


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
public class Currency extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String kursKol;
    private String state;
    private String bbbCode;
    private String fgender;
    private String currPeriodKot;
    private String currOrder;
    private String signKontrol;
    private String print1P;
    private String print1R;
    private String print2R;
    private String printNP;
    private String igender;
    private String printNR;
    private String printFNR;
    private String kursPrice;
    private String kodCurrNum;
    private String printF2R;
    private String printF1;
    private String currType;

    public static Currency fromJSON(HashMap<String,String> json){
        return Currency.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .kursKol(json.get("KURS_KOL"))
                .state(json.get("STATE"))
                .bbbCode(json.get("BBB_CODE"))
                .fgender(json.get("FGENDER"))
                .currPeriodKot(json.get("CURR_PERIOD_KOT"))
                .currOrder(json.get("CURR_ORDER"))
                .signKontrol(json.get("SIGN_KONTROL"))
                .print1P(json.get("PRINT_1P"))
                .print1R(json.get("PRINT_1R"))
                .print2R(json.get("PRINT_2R"))
                .printNP(json.get("PRINT_NP"))
                .igender(json.get("IGENDER"))
                .printNR(json.get("PRINT_NR"))
                .printFNR(json.get("PRINT_FNR"))
                .kursPrice(json.get("KURS_PRICE"))
                .kodCurrNum(json.get("KOD_CURR_NUM"))
                .printF2R(json.get("PRINT_F2R"))
                .printF1(json.get("PRINT_F1"))
                .currType(json.get("CURR_TYPE"))
                .build();
    }
}
