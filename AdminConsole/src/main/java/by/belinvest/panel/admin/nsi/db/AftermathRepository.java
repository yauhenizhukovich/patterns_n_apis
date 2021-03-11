package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.aftermath.Aftermath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AftermathRepository {
    private static final String NAME_OF_TABLE = "'AFTERMATH'";

    private static final String GET_INFO_FROM_AFTERMATH_DIRECTORY_SQL = "SELECT * FROM AFTERMATH";
    private static final String INSERT_INFO_INTO_AFTERMATH_DIRECTORY_SQL = "INSERT INTO AFTERMATH (AFTERMATH_NAME,AFTERMATH_DESC) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_AFTERMATH_DIRECTORY_SQL = "UPDATE AFTERMATH SET AFTERMATH_NAME = ?,AFTERMATH_DESC = ? WHERE ID_AFTERMATH = ?";
    private static final String DELETE_INFO_FROM_AFTERMATH_DIRECTORY_SQL = "DELETE FROM AFTERMATH WHERE ID_AFTERMATH = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AftermathRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_AFTERMATH_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Aftermath.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Aftermath aftermath) {
        jdbcTemplate.update(UPDATE_INFO_INTO_AFTERMATH_DIRECTORY_SQL,
                aftermath.getAftermathName(),
                aftermath.getAftermathDesc(),
                aftermath.getIdAftermath());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_AFTERMATH_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(Aftermath aftermath) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_AFTERMATH_DIRECTORY_SQL,
                aftermath.getAftermathName(),
                aftermath.getAftermathDesc()
        );
        return true;
    }
}
