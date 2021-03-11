package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bn_refresh_log.BNRefreshLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Repository
public class BNRefreshLogRepository {
    private static final String NAME_OF_TABLE = "'BN_REFRESH_LOG'";

    private static final String GET_INFO_FROM_BN_REFRESH_LOG_DIRECTORY_SQL = "SELECT * FROM BN_REFRESH_LOG";
    private static final String INSERT_INFO_INTO_BN_REFRESH_LOG_DIRECTORY_SQL = "INSERT INTO BN_REFRESH_LOG (STARTDATE,ENDDATE,CNTRECINS,CNTRECUPD,CNTRECDEL,NOTE) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_BN_REFRESH_LOG_DIRECTORY_SQL = "UPDATE BN_REFRESH_LOG SET STARTDATE = ?,ENDDATE = ?,CNTRECINS = ?,CNTRECUPD = ?,CNTRECDEL = ?,NOTE = ? WHERE NAME = ?";
    private static final String DELETE_INFO_FROM_BN_REFRESH_LOG_DIRECTORY_SQL = "DELETE FROM BN_REFRESH_LOG WHERE NAME = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BNRefreshLogRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BN_REFRESH_LOG_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BNRefreshLog.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BNRefreshLog bnRefreshLog) {
        System.out.println(bnRefreshLog);
        Logger.getAnonymousLogger().info(bnRefreshLog.toString());
        jdbcTemplate.update(UPDATE_INFO_INTO_BN_REFRESH_LOG_DIRECTORY_SQL,
                bnRefreshLog.getStartDate(),
                bnRefreshLog.getEndDate(),
                bnRefreshLog.getCntrecIns(),
                bnRefreshLog.getCntrecUpd(),
                bnRefreshLog.getCntrecDel(),
                bnRefreshLog.getNote(),
                bnRefreshLog.getName());
        return true;
    }

    public boolean remove(String name) {
        jdbcTemplate.update(DELETE_INFO_FROM_BN_REFRESH_LOG_DIRECTORY_SQL, name);
        return true;
    }

    public boolean create(BNRefreshLog bnRefreshLog) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BN_REFRESH_LOG_DIRECTORY_SQL,
                bnRefreshLog.getStartDate(),
                bnRefreshLog.getEndDate(),
                bnRefreshLog.getCntrecIns(),
                bnRefreshLog.getCntrecUpd(),
                bnRefreshLog.getCntrecDel(),
                bnRefreshLog.getNote()
        );
        return true;
    }
}
