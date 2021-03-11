package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.form_cr.FormCr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FormCrRepository {
    private static final String NAME_OF_TABLE = "'FORM_CR'";

    private static final String GET_INFO_FROM_FORM_CR_DIRECTORY_SQL = "SELECT * FROM FORM_CR";
    private static final String INSERT_INFO_INTO_FORM_CR_DIRECTORY_SQL = "INSERT INTO FORM_CR (CODE,NAME,KR_VID_SDELKI) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_FORM_CR_DIRECTORY_SQL = "UPDATE FORM_CR SET CODE = ?,NAME = ?,KR_VID_SDELKI = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_FORM_CR_DIRECTORY_SQL = "DELETE FROM FORM_CR WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FormCrRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_FORM_CR_DIRECTORY_SQL, new BeanPropertyRowMapper<>(FormCr.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(FormCr formCr) {
        jdbcTemplate.update(UPDATE_INFO_INTO_FORM_CR_DIRECTORY_SQL,
                formCr.getCode(),
                formCr.getName(),
                formCr.getKrVidSdelki(),
                formCr.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_FORM_CR_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(FormCr formCr) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_FORM_CR_DIRECTORY_SQL,
                formCr.getCode(),
                formCr.getName(),
                formCr.getKrVidSdelki()
        );
        return true;
    }
}
