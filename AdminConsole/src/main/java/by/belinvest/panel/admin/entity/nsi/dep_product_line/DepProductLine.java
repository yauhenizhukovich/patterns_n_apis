package by.belinvest.panel.admin.entity.nsi.dep_product_line;

import by.belinvest.panel.admin.entity.nsi.Directory;
import by.belinvest.panel.admin.entity.nsi.conditional_obligations.ConditionalObligations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepProductLine extends Directory {
    private String code;
    private String name;
    private String idCard;

    public static DepProductLine fromJSON(HashMap<String,String> json){
        return DepProductLine.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
                .idCard(json.get("idCard"))
                .build();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
