package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.fo_oper_status.FoOperStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FoOperStatusRepository {
    private static final String NAME_OF_TABLE = "'FO_OPER_STATUS'";

    private static final String GET_INFO_FROM_FO_OPER_STATUS_DIRECTORY_SQL = "SELECT * FROM FO_OPER_STATUS";
    private static final String INSERT_INFO_INTO_FO_OPER_STATUS_DIRECTORY_SQL = "INSERT INTO FO_OPER_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_FO_OPER_STATUS_DIRECTORY_SQL = "UPDATE FO_OPER_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_FO_OPER_STATUS_DIRECTORY_SQL = "DELETE FROM FO_OPER_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FoOperStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_FO_OPER_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(FoOperStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(FoOperStatus foOperStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_FO_OPER_STATUS_DIRECTORY_SQL,
                foOperStatus.getName(),
                foOperStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_FO_OPER_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(FoOperStatus foOperStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_FO_OPER_STATUS_DIRECTORY_SQL,
                foOperStatus.getName()
        );
        return true;
    }
}
