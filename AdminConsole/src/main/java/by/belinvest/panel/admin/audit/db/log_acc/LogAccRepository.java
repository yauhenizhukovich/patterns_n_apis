package by.belinvest.panel.admin.audit.db.log_acc;
import by.belinvest.panel.admin.entity.audit.log_acc.LogAcc;
import by.belinvest.panel.admin.entity.audit.log_acc.LogAccDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class LogAccRepository {

    private static final String GET_INFO_FROM_LOG_ACC_DIRECTORY_SQL = "SELECT task_name, nsi_id, sync_date, sync_action, sync_result FROM LOG_ACC";
    private static final String INSERT_INFO_INTO_LOG_ACC_DIRECTORY_SQL = "INSERT INTO LOG_ACC (TASK_NAME, NSI_ID, SYNC_DATE, SYNC_ACTION, SYNC_RESULT) VALUES (?, ?, ?, ?, ?)";

    private static final int TASK_NAME_COLUMN = 1;
    private static final int NSI_ID_COLUMN = 2;
    private static final int SYNC_DATE_COLUMN = 3;
    private static final int SYNC_ACTION_COLUMN = 4;
    private static final int SYNC_RESULT_COLUMN = 5;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LogAccRepository(@Qualifier("auditDatasource") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public LogAccDirectory get() {
        LogAccDirectory logAccDirectory = new LogAccDirectory();
        jdbcTemplate.query(GET_INFO_FROM_LOG_ACC_DIRECTORY_SQL, rs -> {

            parseDescription(logAccDirectory, rs.getMetaData());
            while (rs.next()) {
                logAccDirectory.getLogAccs().add(parseLogAcc(rs));
            }
        });

        return logAccDirectory;
    }

    public boolean create(LogAcc logAcc) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_LOG_ACC_DIRECTORY_SQL,
                logAcc.getTaskName(),
                logAcc.getNsiId(),
                logAcc.getSyncDate(),
                logAcc.getSyncAction(),
                logAcc.getSyncResult()
        );
        return true;
    }

    private LogAcc parseLogAcc(ResultSet rs) throws SQLException {
        return new LogAcc(
                rs.getString(TASK_NAME_COLUMN),
                rs.getString(NSI_ID_COLUMN),
                rs.getString(SYNC_DATE_COLUMN),
                rs.getString(SYNC_ACTION_COLUMN),
                rs.getString(SYNC_RESULT_COLUMN)
        );
    }

    private void parseDescription(LogAccDirectory logAccDirectory, ResultSetMetaData rsmd) throws SQLException {
        logAccDirectory.setTaskNameDescription(rsmd.getColumnLabel(TASK_NAME_COLUMN));
        logAccDirectory.setNsiIdDescription(rsmd.getColumnName(NSI_ID_COLUMN));
        logAccDirectory.setSyncDateDescription(rsmd.getColumnName(SYNC_DATE_COLUMN));
        logAccDirectory.setSyncActionDescription(rsmd.getColumnName(SYNC_ACTION_COLUMN));
        logAccDirectory.setSyncResultDescription(rsmd.getColumnName(SYNC_RESULT_COLUMN));

    }

}
