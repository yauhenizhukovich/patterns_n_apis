package by.belinvest.panel.admin.entity.nsi.nsi_116;


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
public class Nsi116 extends Directory {
    private String dimid;
    private String parentId;
    private String code;
    private String name;
    private String nsi116ShVd;
    private String nsi116GroupNum;
    private String nsi116Tarif;
    private String nsi116Op;
    private String nsi116DateClose;
    private String nsi116Tunn;
    private String nsi116AvaliableForDbo;
    private String nsi116Tmin;
    private String nsi116Nopay;
    private String nsi116ShVo;
    private String nsi116TypeTarif;
    private String nsi116DateOpen;
    private String nsi116ShOp;
    private String nsi116PackGroup;
    private String nsi116Val;
    private String nsi116ShNp;
    private String nsi116Tmax;
    private String nsi116Tpodr;
    private String nsi116TypeItem;
    private String nsi116Tval;


    public static Nsi116 fromJSON(HashMap<String,String> json){
        return Nsi116.builder()
                .dimid(json.get("id"))
                .parentId(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .nsi116ShVd(json.get("NSI_116_SH_VD"))
                .nsi116GroupNum(json.get("NSI_116_GROUP_NUM"))
                .nsi116Tarif(json.get("NSI_116_TARIF"))
                .nsi116Op(json.get("NSI_116_OP"))
                .nsi116DateClose(json.get("NSI_116_DATE_CLOSE"))
                .nsi116Tunn(json.get("NSI_116_TUNN"))
                .nsi116AvaliableForDbo(json.get("NSI_116_AVALIABLE_FOR_DBO"))
                .nsi116Tmin(json.get("NSI_116_TMIN"))
                .nsi116Nopay(json.get("NSI_116_NOPAY"))
                .nsi116ShVo(json.get("NSI_116_SH_VO"))
                .nsi116TypeTarif(json.get("NSI_116_TYPE_TARIF"))
                .nsi116DateOpen(json.get("NSI_116_DATE_OPEN"))
                .nsi116ShOp(json.get("NSI_116_SH_OP"))
                .nsi116PackGroup(json.get("NSI_116_PACK_GROUP"))
                .nsi116Val(json.get("NSI_116_VAL"))
                .nsi116ShNp(json.get("NSI_116_SH_NP"))
                .nsi116Tmax(json.get("NSI_116_TMAX"))
                .nsi116Tpodr(json.get("NSI_116_TPODR"))
                .nsi116TypeItem(json.get("NSI_116_TYPE_ITEM"))
                .nsi116Tval(json.get("NSI_116_TVAL"))
                .build();
    }
}
