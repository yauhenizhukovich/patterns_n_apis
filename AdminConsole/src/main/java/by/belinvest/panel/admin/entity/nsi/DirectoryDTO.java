package by.belinvest.panel.admin.entity.nsi;

import by.belinvest.panel.admin.entity.nsi.tabledate.TableData;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DirectoryDTO {
    private List<? extends Directory> directory;
    private TableData tableData;

    public List<? extends Directory> getDirectory() {
        return directory;
    }

    public void setDirectory(List<? extends Directory> directory) {
        this.directory = directory;
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }
}
