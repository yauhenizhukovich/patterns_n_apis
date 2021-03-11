package by.belinvest.panel.admin.entity.nsi.depfl_product_line;

import by.belinvest.panel.admin.entity.nsi.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepflProductLine extends Directory {
    private String code;
    private String name;

    public static DepflProductLine fromJSON(HashMap<String,String> json){
        return DepflProductLine.builder()
                .code(json.get("id"))
                .name(json.get("NAME"))
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
}
