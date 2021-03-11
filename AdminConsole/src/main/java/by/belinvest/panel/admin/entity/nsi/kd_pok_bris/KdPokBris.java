package by.belinvest.panel.admin.entity.nsi.kd_pok_bris;


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
public class KdPokBris extends Directory {
    private String dimid;
    private String code;
    private String name;
    private String listKdProducts;
    private String checkToppdnRezerv;
    private String reservePersentForKd;


    public static KdPokBris fromJSON(HashMap<String,String> json){
        return KdPokBris.builder()
                .dimid(json.get("id"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .listKdProducts(json.get("LIST_KD_PRODUCTS"))
                .checkToppdnRezerv(json.get("CHECK_TOPPDN_REZERV"))
                .reservePersentForKd(json.get("RESERVE_PERSENT_FOR_KD"))
                .build();
    }
}
