package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bi_status.BIStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BIStatusRepository {
    private static final String NAME_OF_TABLE = "'BI_STATUS'";

    private static final String GET_INFO_FROM_BI_STATUS_DIRECTORY_SQL = "SELECT * FROM BI_STATUS";
    private static final String INSERT_INFO_INTO_BI_STATUS_DIRECTORY_SQL = "INSERT INTO BI_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_BI_STATUS_DIRECTORY_SQL = "UPDATE BI_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_BI_STATUS_DIRECTORY_SQL = "DELETE FROM BI_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BIStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BI_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BIStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BIStatus biStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BI_STATUS_DIRECTORY_SQL,
                biStatus.getName(),
                biStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_BI_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(BIStatus biStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BI_STATUS_DIRECTORY_SQL,
                biStatus.getName()
        );
        return true;
    }

}
