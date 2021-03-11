package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.org_legal_forms.OrgLegalForms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class OrgLegalFormsRepository {

    private static final String NAME_OF_TABLE = "'ORG_LEGAL_FORMS'";

    private static final String GET_INFO_FROM_ORG_LEGAL_FORMS_DIRECTORY_SQL = "SELECT * FROM ORG_LEGAL_FORMS";
    private static final String INSERT_INFO_INTO_ORG_LEGAL_FORMS_DIRECTORY_SQL = "INSERT INTO ORG_LEGAL_FORMS (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_ORG_LEGAL_FORMS_DIRECTORY_SQL = "UPDATE ORG_LEGAL_FORMS SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_ORG_LEGAL_FORMS_DIRECTORY_SQL = "DELETE FROM ORG_LEGAL_FORMS WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrgLegalFormsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_ORG_LEGAL_FORMS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(OrgLegalForms.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(OrgLegalForms orgLegalForms) {
        jdbcTemplate.update(UPDATE_INFO_INTO_ORG_LEGAL_FORMS_DIRECTORY_SQL,
                orgLegalForms.getName(),
                orgLegalForms.getCode(),
                orgLegalForms.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_ORG_LEGAL_FORMS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(OrgLegalForms orgLegalForms) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_ORG_LEGAL_FORMS_DIRECTORY_SQL,
                orgLegalForms.getName(),
                orgLegalForms.getCode()
        );
        return true;
    }
}
