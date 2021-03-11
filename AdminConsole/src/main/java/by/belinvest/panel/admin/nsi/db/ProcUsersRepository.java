package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.proc_users.ProcUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProcUsersRepository {

    private static final String NAME_OF_TABLE = "'PROC_USERS'";

    private static final String GET_INFO_FROM_PROC_USERS_DIRECTORY_SQL = "SELECT * FROM PROC_USERS";
    private static final String INSERT_INFO_INTO_PROC_USERS_DIRECTORY_SQL = "INSERT INTO PROC_USERS (USER_ID,ROLE_ID,ROLE_DESC,ROLE_LOCK,DATE_FROM,DATE_TO,USER_FULLNAME) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_PROC_USERS_DIRECTORY_SQL = "UPDATE PROC_USERS SET USER_ID = ?,ROLE_ID = ?,ROLE_DESC = ?,ROLE_LOCK = ?,DATE_FROM = ?,DATE_TO = ?,USER_FULLNAME = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_PROC_USERS_DIRECTORY_SQL = "DELETE FROM PROC_USERS WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcUsersRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PROC_USERS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ProcUsers.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ProcUsers procUsers) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PROC_USERS_DIRECTORY_SQL,
                procUsers.getUserId(),
                procUsers.getRoleId(),
                procUsers.getRoleDesc(),
                procUsers.getRoleLock(),
                procUsers.getDateFrom(),
                procUsers.getDateTo(),
                procUsers.getRoleLock(),
                procUsers.getUserFullname(),
                procUsers.getId());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_PROC_USERS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(ProcUsers procUsers) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PROC_USERS_DIRECTORY_SQL,
                procUsers.getUserId(),
                procUsers.getRoleId(),
                procUsers.getRoleDesc(),
                procUsers.getRoleLock(),
                procUsers.getDateFrom(),
                procUsers.getDateTo(),
                procUsers.getRoleLock(),
                procUsers.getUserFullname()
        );
        return true;
    }
}
