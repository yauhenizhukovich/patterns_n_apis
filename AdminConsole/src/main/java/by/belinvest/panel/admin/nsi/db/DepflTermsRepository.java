package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.depfl_terms.DepflTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DepflTermsRepository {
    private static final String NAME_OF_TABLE = "'DEPFL_TERMS'";

    private static final String GET_INFO_FROM_DEPFL_TERMS_DIRECTORY_SQL = "SELECT * FROM DEPFL_TERMS";
    private static final String INSERT_INFO_INTO_DEPFL_TERMS_DIRECTORY_SQL = "INSERT INTO DEPFL_TERMS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_DEPFL_TERMS_DIRECTORY_SQL = "UPDATE DEPFL_TERMS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_DEPFL_TERMS_DIRECTORY_SQL = "DELETE FROM DEPFL_TERMS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DepflTermsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_DEPFL_TERMS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(DepflTerms.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(DepflTerms depflTerms) {
        jdbcTemplate.update(UPDATE_INFO_INTO_DEPFL_TERMS_DIRECTORY_SQL,
                depflTerms.getName(),
                depflTerms.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_DEPFL_TERMS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(DepflTerms depflTerms) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_DEPFL_TERMS_DIRECTORY_SQL,
                depflTerms.getName()
        );
        return true;
    }
}
