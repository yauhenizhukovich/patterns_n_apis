package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_currency.DepCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DepCurrencyRepository {
    private static final String NAME_OF_TABLE = "'DEP_CURRENCY'";

    private static final String GET_INFO_FROM_DEP_CURRENCY_DIRECTORY_SQL = "SELECT * FROM DEP_CURRENCY";
    private static final String INSERT_INFO_INTO_DEP_CURRENCY_DIRECTORY_SQL = "INSERT INTO DEP_CURRENCY (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_DEP_CURRENCY_DIRECTORY_SQL = "UPDATE DEP_CURRENCY SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_DEP_CURRENCY_DIRECTORY_SQL = "DELETE FROM DEP_CURRENCY WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DepCurrencyRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_DEP_CURRENCY_DIRECTORY_SQL, new BeanPropertyRowMapper<>(DepCurrency.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(DepCurrency depCurrency) {
        jdbcTemplate.update(UPDATE_INFO_INTO_DEP_CURRENCY_DIRECTORY_SQL,
                depCurrency.getName(),
                depCurrency.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_DEP_CURRENCY_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(DepCurrency depCurrency) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_DEP_CURRENCY_DIRECTORY_SQL,
                depCurrency.getName()
        );
        return true;
    }
}
