package by.belinvest.panel.admin.catalog.db.mappers;

import by.belinvest.panel.admin.entity.catalog.BpProductLine;
import by.belinvest.panel.admin.entity.catalog.BusinessInitiative;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BpProductLineMapper implements RowMapper<BpProductLine> {

    @Override
    public BpProductLine mapRow(ResultSet resultSet, int i) throws SQLException {

        BpProductLine bpProductLine = new BpProductLine();
        bpProductLine.setBPid(resultSet.getInt("BPID"));
        bpProductLine.setNsiName(resultSet.getString("NSI_NAME"));
        bpProductLine.setBPid(resultSet.getInt("NSI_ID"));

        return bpProductLine;
    }
}
