package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.dep_currency.DepCurrency;
import by.belinvest.panel.admin.entity.nsi.dep_terms.DepTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DepTermsRepository {
    private static final String NAME_OF_TABLE = "'DEP_TERMS'";

    private static final String GET_INFO_FROM_DEP_TERMS_DIRECTORY_SQL = "SELECT * FROM DEP_TERMS";
    private static final String INSERT_INFO_INTO_DEP_TERMS_DIRECTORY_SQL = "INSERT INTO DEP_TERMS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_DEP_TERMS_DIRECTORY_SQL = "UPDATE DEP_TERMS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_DEP_TERMS_DIRECTORY_SQL = "DELETE FROM DEP_TERMS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DepTermsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_DEP_TERMS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(DepTerms.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(DepTerms depTerms) {
        jdbcTemplate.update(UPDATE_INFO_INTO_DEP_TERMS_DIRECTORY_SQL,
                depTerms.getName(),
                depTerms.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_DEP_TERMS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(DepTerms depTerms) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_DEP_TERMS_DIRECTORY_SQL,
                depTerms.getName()
        );
        return true;
    }
}
