package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.interest_rate_type.InterestRateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class InterestRateTypeRepository {
    private static final String NAME_OF_TABLE = "'INTEREST_RATE_TYPE'";

    private static final String GET_INFO_FROM_INTEREST_RATE_TYPE_DIRECTORY_SQL = "SELECT * FROM INTEREST_RATE_TYPE";
    private static final String INSERT_INFO_INTO_INTEREST_RATE_TYPE_DIRECTORY_SQL = "INSERT INTO INTEREST_RATE_TYPE (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_INTEREST_RATE_TYPE_DIRECTORY_SQL = "UPDATE INTEREST_RATE_TYPE SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_INTEREST_RATE_TYPE_DIRECTORY_SQL = "DELETE FROM INTEREST_RATE_TYPE WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InterestRateTypeRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate =  new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_INTEREST_RATE_TYPE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(InterestRateType.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(InterestRateType interestRateType) {
        jdbcTemplate.update(UPDATE_INFO_INTO_INTEREST_RATE_TYPE_DIRECTORY_SQL,
                interestRateType.getCode(),
                interestRateType.getName(),
                interestRateType.getNote(),
                interestRateType.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_INTEREST_RATE_TYPE_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(InterestRateType interestRateType) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_INTEREST_RATE_TYPE_DIRECTORY_SQL,
                interestRateType.getCode(),
                interestRateType.getName(),
                interestRateType.getNote()
        );
        return true;
    }
}
