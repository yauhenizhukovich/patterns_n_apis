package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.exec_status.ExecStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ExecStatusRepository {
    private static final String NAME_OF_TABLE = "'EXEC_STATUS'";

    private static final String GET_INFO_FROM_EXEC_STATUS_DIRECTORY_SQL = "SELECT * FROM EXEC_STATUS";
    private static final String INSERT_INFO_INTO_EXEC_STATUS_DIRECTORY_SQL = "INSERT INTO EXEC_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_EXEC_STATUS_DIRECTORY_SQL = "UPDATE EXEC_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_EXEC_STATUS_DIRECTORY_SQL = "DELETE FROM EXEC_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExecStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_EXEC_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ExecStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ExecStatus execStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_EXEC_STATUS_DIRECTORY_SQL,
                execStatus.getName(),
                execStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_EXEC_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(ExecStatus execStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_EXEC_STATUS_DIRECTORY_SQL,
                execStatus.getName()
        );
        return true;
    }
}
