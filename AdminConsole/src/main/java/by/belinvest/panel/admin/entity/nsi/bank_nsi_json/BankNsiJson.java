package by.belinvest.panel.admin.entity.nsi.bank_nsi_json;

import by.belinvest.panel.admin.entity.nsi.Directory;
import by.belinvest.panel.admin.entity.nsi.aftermath.Aftermath;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankNsiJson extends Directory {
    private String id;
    private String dateLoad;
    private String name;
    private String note;
    private String jsonTable;
    private String xmlTable;
    private String urlSrv;
    private String sqlText;


    public static BankNsiJson fromJSON(HashMap<String,String> json){
        return BankNsiJson.builder()
                .id(json.get("id"))
                .dateLoad(json.get("DATE_LOAD"))
                .name(json.get("NAME"))
                .note(json.get("NOTE"))
                .jsonTable(json.get("JSON_TABLE"))
                .xmlTable(json.get("XML_TABLE"))
                .urlSrv(json.get("URL_SRV"))
                .sqlText(json.get("SQL_TEXT"))
                .build();
    }
}
