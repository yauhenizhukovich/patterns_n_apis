package by.belinvest.panel.admin.audit.db.log_user_act;

import by.belinvest.panel.admin.entity.audit.log_user_act.LogUserAct;
import by.belinvest.panel.admin.entity.audit.log_user_act.LogUserActDirectory;
import by.belinvest.panel.admin.entity.nsi.balans2.Balans2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class LogUserActRepository {

    private static final String GET_INFO_FROM_LOG_USER_ACT_DIRECTORY_SQL = "SELECT * FROM LOG_USER_ACT";
    private static final String INSERT_INFO_INTO_LOG_USER_ACT_DIRECTORY_SQL = "INSERT INTO LOG_USER_ACT (USER_NAME, ACT_DATE, ACTION) VALUES (?, ?, ?)";

    private static final int USER_NAME_COLUMN = 1;
    private static final int ACT_DATE_COLUMN = 2;
    private static final int ACTION_COLUMN = 3;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LogUserActRepository(@Qualifier("auditDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public LogUserActDirectory get() {
        LogUserActDirectory logUserActDirectory = new LogUserActDirectory();
        jdbcTemplate.query(GET_INFO_FROM_LOG_USER_ACT_DIRECTORY_SQL, rs -> {

            parseDescription(logUserActDirectory, rs.getMetaData());
            while (rs.next()) {
                logUserActDirectory.getLogUserActs().add(parseLogUserAct(rs));
            }
        });

        return logUserActDirectory;
    }

    public boolean create(LogUserAct logUserAct) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_LOG_USER_ACT_DIRECTORY_SQL,
                logUserAct.getUserName(),
                logUserAct.getActDate(),
                logUserAct.getAction()
        );
        return true;
    }

    private LogUserAct parseLogUserAct(ResultSet rs) throws SQLException {
        return new LogUserAct(
                rs.getString(USER_NAME_COLUMN),
                rs.getString(ACT_DATE_COLUMN),
                rs.getString(ACTION_COLUMN)
        );
    }

    private void parseDescription(LogUserActDirectory logUserActDirectory, ResultSetMetaData rsmd) throws SQLException {
        logUserActDirectory.setUserNameDescription(rsmd.getColumnLabel(USER_NAME_COLUMN));
        logUserActDirectory.setActDateDescription(rsmd.getColumnName(ACT_DATE_COLUMN));
        logUserActDirectory.setActionDescription(rsmd.getColumnName(ACTION_COLUMN));

    }

}
