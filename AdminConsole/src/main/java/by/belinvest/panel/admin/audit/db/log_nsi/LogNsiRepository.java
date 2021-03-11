package by.belinvest.panel.admin.audit.db.log_nsi;

import by.belinvest.panel.admin.entity.audit.log_nsi.LogNsi;
import by.belinvest.panel.admin.entity.audit.log_nsi.LogNsiDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class LogNsiRepository {


    private static final String GET_INFO_FROM_LOG_NSI_DIRECTORY_SQL = "SELECT nsi_name, nsi_id, sync_date, sync_action, sync_result FROM LOG_NSI";
    private static final String INSERT_INFO_INTO_LOG_NSI_DIRECTORY_SQL = "INSERT INTO LOG_NSI (NSI_NAME, NSI_ID, SYNC_DATE, SYNC_ACTION, SYNC_RESULT) VALUES (?, ?, ?, ?, ?)";

    private static final int NSI_NAME_COLUMN = 1;
    private static final int NSI_ID_COLUMN = 2;
    private static final int SYNC_DATE_COLUMN = 3;
    private static final int SYNC_ACTION_COLUMN = 4;
    private static final int SYNC_RESULT_COLUMN = 5;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LogNsiRepository(@Qualifier("auditDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public LogNsiDirectory get() {
        LogNsiDirectory logNsiDirectory = new LogNsiDirectory();
        jdbcTemplate.query(GET_INFO_FROM_LOG_NSI_DIRECTORY_SQL, rs -> {
            parseDescription(logNsiDirectory, rs.getMetaData());
            while (rs.next()) {
                logNsiDirectory.getLogNsis().add(parseLogNsi(rs));
            }
        });
        return logNsiDirectory;
    }

    public boolean create(LogNsi logNsi) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_LOG_NSI_DIRECTORY_SQL,
                logNsi.getNsiName(),
                logNsi.getNsiId(),
                logNsi.getSyncDate(),
                logNsi.getSyncAction(),
                logNsi.getSyncResult()
        );
        return true;
    }

    private void parseDescription(LogNsiDirectory logNsiDirectory, ResultSetMetaData rsmd) throws SQLException {
        logNsiDirectory.setNsiNameDescription(rsmd.getColumnName(NSI_NAME_COLUMN));
        logNsiDirectory.setNsiIdDescription(rsmd.getColumnName(NSI_ID_COLUMN));
        logNsiDirectory.setSyncDateDescription(rsmd.getColumnName(SYNC_DATE_COLUMN));
        logNsiDirectory.setSyncActionDescription(rsmd.getColumnName(SYNC_ACTION_COLUMN));
        logNsiDirectory.setSyncResultDescription(rsmd.getColumnName(SYNC_RESULT_COLUMN));

    }

    private LogNsi parseLogNsi(ResultSet rs) throws SQLException {
        return new LogNsi(
                rs.getString(NSI_NAME_COLUMN),
                rs.getString(NSI_ID_COLUMN),
                rs.getString(SYNC_DATE_COLUMN),
                rs.getString(SYNC_ACTION_COLUMN),
                rs.getString(SYNC_RESULT_COLUMN)
        );
    }

}
