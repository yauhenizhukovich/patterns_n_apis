package by.belinvest.panel.admin.entity.nsi.spis_scan_doc;


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
public class SpisScanDoc extends Directory {
    private String dimid;
    private String parentid;
    private String code;
    private String name;
    private String scanPac;
    private String scanType;
    private String dzVidZal;
    private String dzPredmet;
    private String dzVidObesp;

    public static SpisScanDoc fromJSON(HashMap<String,String> json){
        return SpisScanDoc.builder()
                .dimid(json.get("id"))
                .parentid(json.get("PARENTID"))
                .code(json.get("CODE"))
                .name(json.get("NAME"))
                .scanPac(json.get("SCAN_PAC"))
                .scanType(json.get("SCAN_TYPE"))
                .dzVidZal(json.get("DZ_VID_ZAL"))
                .dzPredmet(json.get("DZ_PREDMET"))
                .dzVidObesp(json.get("DZ_VID_OBESP"))
                .build();
    }
}
