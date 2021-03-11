package by.belinvest.panel.admin.entity.nsi.tabledate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableData {
    private String nameOfTable;
    private Map<String,String> nameOfColumns;
}
