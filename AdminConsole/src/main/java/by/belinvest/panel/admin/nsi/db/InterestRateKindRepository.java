package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.interest_rate_kind.InterestRateKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class InterestRateKindRepository {
    private static final String NAME_OF_TABLE = "'INTEREST_RATE_KIND'";

    private static final String GET_INFO_FROM_INTEREST_RATE_KINDDIRECTORY_SQL = "SELECT * FROM INTEREST_RATE_KIND";
    private static final String INSERT_INFO_INTO_INTEREST_RATE_KIND_DIRECTORY_SQL = "INSERT INTO INTEREST_RATE_KIND (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_INTEREST_RATE_KIND_DIRECTORY_SQL = "UPDATE INTEREST_RATE_KIND SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_INTEREST_RATE_KIND_DIRECTORY_SQL = "DELETE FROM INTEREST_RATE_KIND WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InterestRateKindRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_INTEREST_RATE_KINDDIRECTORY_SQL, new BeanPropertyRowMapper<>(InterestRateKind.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(InterestRateKind interestRateKind) {
        jdbcTemplate.update(UPDATE_INFO_INTO_INTEREST_RATE_KIND_DIRECTORY_SQL,
                interestRateKind.getCode(),
                interestRateKind.getName(),
                interestRateKind.getNote(),
                interestRateKind.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_INTEREST_RATE_KIND_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(InterestRateKind interestRateKind) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_INTEREST_RATE_KIND_DIRECTORY_SQL,
                interestRateKind.getCode(),
                interestRateKind.getName(),
                interestRateKind.getNote()
        );
        return true;
    }
}
