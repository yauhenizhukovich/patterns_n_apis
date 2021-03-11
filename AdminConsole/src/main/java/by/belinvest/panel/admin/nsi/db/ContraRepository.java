package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.contra.Contra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ContraRepository {

    private static final String NAME_OF_TABLE = "'CONTRA'";

    private static final String GET_INFO_FROM_CONTRA_DIRECTORY_SQL = "SELECT DIMID,PARENTID,CODE,NAME,NSI_010_CONTRA FROM CONTRA";
    private static final String INSERT_INFO_INTO_CONTRA_DIRECTORY_SQL = "INSERT INTO CONTRA (PARENTID,CODE,NAME,NSI_010_CONTRA) VALUES (?,?,?,?)";
    private static final String UPDATE_INFO_INTO_CONTRA_DIRECTORY_SQL = "UPDATE CONTRA SET PARENTID = ?,CODE = ?,NAME = ?,NSI_010_CONTRA = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_CONTRA_DIRECTORY_SQL = "DELETE FROM CONTRA WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ContraRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CONTRA_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Contra.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Contra contra) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CONTRA_DIRECTORY_SQL,
                contra.getParentId(),
                contra.getCode(),
                contra.getName(),
                contra.getNsi010contra(),
                contra.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_CONTRA_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Contra contra) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CONTRA_DIRECTORY_SQL,
                contra.getParentId(),
                contra.getCode(),
                contra.getName(),
                contra.getNsi010contra()
        );
        return true;
    }
}
