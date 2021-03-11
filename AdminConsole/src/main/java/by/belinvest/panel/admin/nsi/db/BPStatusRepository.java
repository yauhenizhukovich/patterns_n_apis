package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bp_status.BPStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BPStatusRepository {
    private static final String NAME_OF_TABLE = "'BP_STATUS'";

    private static final String GET_INFO_FROM_BP_STATUS_DIRECTORY_SQL = "SELECT * FROM BP_STATUS";
    private static final String INSERT_INFO_INTO_BP_STATUS_DIRECTORY_SQL = "INSERT INTO BP_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_BP_STATUS_DIRECTORY_SQL = "UPDATE BP_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_BP_STATUS_DIRECTORY_SQL = "DELETE FROM BP_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BPStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BP_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BPStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BPStatus bpStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BP_STATUS_DIRECTORY_SQL,
                bpStatus.getName(),
                bpStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_BP_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(BPStatus bpStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BP_STATUS_DIRECTORY_SQL,
                bpStatus.getName()
        );
        return true;
    }
}
