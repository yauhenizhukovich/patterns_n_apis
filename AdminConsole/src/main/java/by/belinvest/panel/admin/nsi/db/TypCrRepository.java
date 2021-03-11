package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.typ_cr.TypCr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TypCrRepository {

    private static final String NAME_OF_TABLE = "'TYP_CR'";

    private static final String GET_INFO_FROM_TYP_CR_DIRECTORY_SQL = "SELECT * FROM TYP_CR";
    private static final String INSERT_INFO_INTO_TYP_CR_DIRECTORY_SQL = "INSERT INTO TYP_CR (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_TYP_CR_DIRECTORY_SQL = "UPDATE TYP_CR SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_TYP_CR_DIRECTORY_SQL = "DELETE FROM TYP_CR WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TypCrRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_TYP_CR_DIRECTORY_SQL, new BeanPropertyRowMapper<>(TypCr.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(TypCr typCr) {
        jdbcTemplate.update(UPDATE_INFO_INTO_TYP_CR_DIRECTORY_SQL,
                typCr.getName(),
                typCr.getCode(),
                typCr.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_TYP_CR_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(TypCr typCr) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_TYP_CR_DIRECTORY_SQL,
                typCr.getName(),
                typCr.getCode()
        );
        return true;
    }
}
