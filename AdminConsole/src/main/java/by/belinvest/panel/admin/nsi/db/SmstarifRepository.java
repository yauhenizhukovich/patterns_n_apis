package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.smstarif.Smstarif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SmstarifRepository {

    private static final String NAME_OF_TABLE = "'SMSTARIF'";

    private static final String GET_INFO_FROM_SMSTARIF_DIRECTORY_SQL = "SELECT * FROM SMSTARIF";
    private static final String INSERT_INFO_INTO_SMSTARIF_DIRECTORY_SQL = "INSERT INTO SMSTARIF (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_SMSTARIF_DIRECTORY_SQL = "UPDATE SMSTARIF SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_SMSTARIF_DIRECTORY_SQL = "DELETE FROM SMSTARIF WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SmstarifRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_SMSTARIF_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Smstarif.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Smstarif smstarif) {
        jdbcTemplate.update(UPDATE_INFO_INTO_SMSTARIF_DIRECTORY_SQL,
                smstarif.getName(),
                smstarif.getCode(),
                smstarif.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_SMSTARIF_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Smstarif smstarif) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_SMSTARIF_DIRECTORY_SQL,
                smstarif.getName(),
                smstarif.getCode()
        );
        return true;
    }
}
