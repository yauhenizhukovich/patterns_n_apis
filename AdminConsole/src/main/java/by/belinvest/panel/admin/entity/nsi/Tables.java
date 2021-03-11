package by.belinvest.panel.admin.entity.nsi;

import by.belinvest.panel.admin.entity.nsi.Directory;
import by.belinvest.panel.admin.entity.nsi.tabledate.TableData;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tables {
    private Map<String,String> tables;

    public Map<String, String> getTables() {
        return tables;
    }

    public void setTables(Map<String, String> tables) {
        this.tables = tables;
    }
}
