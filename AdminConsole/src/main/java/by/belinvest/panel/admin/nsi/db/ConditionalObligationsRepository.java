package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.conditional_obligations.ConditionalObligations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ConditionalObligationsRepository {

    private static final String NAME_OF_TABLE = "'CONDITIONAL_OBLIGATIONS'";

    private static final String GET_INFO_FROM_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL = "SELECT * FROM CONDITIONAL_OBLIGATIONS";
    private static final String INSERT_INFO_INTO_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL = "INSERT INTO CONDITIONAL_OBLIGATIONS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL = "UPDATE CONDITIONAL_OBLIGATIONS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL = "DELETE FROM CONDITIONAL_OBLIGATIONS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConditionalObligationsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ConditionalObligations.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ConditionalObligations conditionalObligations) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL,
                conditionalObligations.getName(),
                conditionalObligations.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(ConditionalObligations conditionalObligations) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CONDITIONAL_OBLIGATIONS_DIRECTORY_SQL,
                conditionalObligations.getName()
        );
        return true;
    }
}
