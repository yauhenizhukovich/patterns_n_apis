package by.belinvest.panel.admin.entity.nsi.client_business_category;


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
public class ClientBusinessCategory extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String clbEmplMinCnt;
    private String clbMaxSum;
    private String clbCreditSumMin;
    private String clbDefault;
    private String clbPublicAdmin;
    private String clbCreditSumMax;
    private String clbOwnershipType;
    private String clbBgSumMax;
    private String clbEmplMaxCnt;
    private String clbContragent;
    private String clbBankChildComp;
    private String clbBgSumMin;
    private String clbMinSum;
    private String clbCreditDebtCur;
    private String clbCurrency;


    public static ClientBusinessCategory fromJSON(HashMap<String,String> json){
        return ClientBusinessCategory.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .clbEmplMinCnt(json.get("CLB_EMPL_MIN_CNT"))
                .clbMaxSum(json.get("CLB_MAX_SUM"))
                .clbCreditSumMin(json.get("CLB_CREDIT_SUM_MIN"))
                .clbDefault(json.get("CLB_DEFAULT"))
                .clbPublicAdmin(json.get("CLB_PUBLIC_ADMIN"))
                .clbCreditSumMax(json.get("CLB_CREDIT_SUM_MAX"))
                .clbOwnershipType(json.get("CLB_OWNERSHIP_TYPE"))
                .clbBgSumMax(json.get("CLB_BG_SUM_MAX"))
                .clbEmplMaxCnt(json.get("CLB_EMPL_MAX_CNT"))
                .clbContragent(json.get("CLB_CONTRAGENT"))
                .clbBankChildComp(json.get("CLB_BANK_CHILD_COMP"))
                .clbBgSumMin(json.get("CLB_BG_SUM_MIN"))
                .clbMinSum(json.get("CLB_MIN_SUM"))
                .clbCreditDebtCur(json.get("CLB_CREDIT_DEBT_CUR"))
                .clbCurrency(json.get("CLB_CURRENCY"))
                .build();
    }
}
