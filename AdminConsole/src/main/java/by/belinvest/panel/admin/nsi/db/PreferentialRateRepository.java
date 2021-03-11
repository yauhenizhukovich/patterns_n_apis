package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.preferential_rate.PreferentialRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PreferentialRateRepository {

    private static final String NAME_OF_TABLE = "'PREFERENTIAL_RATE'";

    private static final String GET_INFO_FROM_PREFERENTIAL_RATE_DIRECTORY_SQL = "SELECT * FROM PREFERENTIAL_RATE";
    private static final String INSERT_INFO_INTO_PREFERENTIAL_RATE_DIRECTORY_SQL = "INSERT INTO PREFERENTIAL_RATE (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_PREFERENTIAL_RATE_DIRECTORY_SQL = "UPDATE PREFERENTIAL_RATE SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_PREFERENTIAL_RATE_DIRECTORY_SQL = "DELETE FROM PREFERENTIAL_RATE WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PreferentialRateRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PREFERENTIAL_RATE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(PreferentialRate.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(PreferentialRate preferentialRate) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PREFERENTIAL_RATE_DIRECTORY_SQL,
                preferentialRate.getCode(),
                preferentialRate.getName(),
                preferentialRate.getNote(),
                preferentialRate.getId());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_PREFERENTIAL_RATE_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(PreferentialRate preferentialRate) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PREFERENTIAL_RATE_DIRECTORY_SQL,
                preferentialRate.getCode(),
                preferentialRate.getName(),
                preferentialRate.getNote()
        );
        return true;
    }
}
