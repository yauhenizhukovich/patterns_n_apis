package by.belinvest.panel.admin.audit.db.log_sys_event;

import by.belinvest.panel.admin.entity.audit.log_acc.LogAcc;
import by.belinvest.panel.admin.entity.audit.log_acc.LogAccDirectory;
import by.belinvest.panel.admin.entity.audit.log_sys_event.LogSysEvent;
import by.belinvest.panel.admin.entity.audit.log_sys_event.LogSysEventDirectory;
import by.belinvest.panel.admin.entity.nsi.balans2.Balans2;
import by.belinvest.panel.admin.entity.nsi.bank.Bank;
import by.belinvest.panel.admin.entity.nsi.bank.BankDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class LogSysEventRepository {

    private static final String GET_INFO_FROM_LOG_SYS_EVENT_DIRECTORY_SQL = "SELECT * FROM LOG_SYS_EVENT";
    private static final String INSERT_INFO_INTO_LOG_SYS_EVENT_DIRECTORY_SQL = "INSERT INTO LOG_SYS_EVENT (EVENT_DATE, EVENT_TYPE, EVENT_SOURCE, SERVER_NAME, MESSAGE) VALUES (?, ?, ?, ?, ?)";

    private static final int EVENT_DATE_COLUMN = 1;
    private static final int EVENT_TYPE_COLUMN = 2;
    private static final int EVENT_SOURCE_COLUMN = 3;
    private static final int SERVER_NAME_COLUMN = 4;
    private static final int MESSAGE_COLUMN = 5;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LogSysEventRepository(@Qualifier("auditDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public LogSysEventDirectory get() {
        LogSysEventDirectory logSysEventDirectory = new LogSysEventDirectory();
        jdbcTemplate.query(GET_INFO_FROM_LOG_SYS_EVENT_DIRECTORY_SQL, rs -> {

            parseDescription(logSysEventDirectory, rs.getMetaData());
            while (rs.next()) {
                logSysEventDirectory.getLogSysEvents().add(parseLogSysEvent(rs));
            }
        });

        return logSysEventDirectory;
    }

    public boolean create(LogSysEvent logSysEvent) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_LOG_SYS_EVENT_DIRECTORY_SQL,
                logSysEvent.getEventDate(),
                logSysEvent.getEventType(),
                logSysEvent.getEventSource(),
                logSysEvent.getServerName(),
                logSysEvent.getMessage()
        );
        return true;
    }

    private LogSysEvent parseLogSysEvent(ResultSet rs) throws SQLException {
        return new LogSysEvent(
                rs.getString(EVENT_DATE_COLUMN),
                rs.getString(EVENT_TYPE_COLUMN),
                rs.getString(EVENT_SOURCE_COLUMN),
                rs.getString(SERVER_NAME_COLUMN),
                rs.getString(MESSAGE_COLUMN)
        );
    }

    private void parseDescription(LogSysEventDirectory logSysEventDirectory, ResultSetMetaData rsmd) throws SQLException {
        logSysEventDirectory.setEventDateDescription(rsmd.getColumnLabel(EVENT_DATE_COLUMN));
        logSysEventDirectory.setEventTypeDescription(rsmd.getColumnName(EVENT_TYPE_COLUMN));
        logSysEventDirectory.setEventSourceDescription(rsmd.getColumnName(EVENT_SOURCE_COLUMN));
        logSysEventDirectory.setServerNameDescription(rsmd.getColumnName(SERVER_NAME_COLUMN));
        logSysEventDirectory.setMessageDescription(rsmd.getColumnName(MESSAGE_COLUMN));

    }

}

