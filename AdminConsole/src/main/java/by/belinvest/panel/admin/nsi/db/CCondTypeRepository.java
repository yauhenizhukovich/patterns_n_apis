package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.ccond_type.CCondType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CCondTypeRepository {
    private static final String NAME_OF_TABLE = "'CCOND_TYPE'";

    private static final String GET_INFO_FROM_CCOND_TYPE_DIRECTORY_SQL = "SELECT * FROM CCOND_TYPE";
    private static final String INSERT_INFO_INTO_CCOND_TYPE_DIRECTORY_SQL = "INSERT INTO CCOND_TYPE (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_CCOND_TYPE_DIRECTORY_SQL = "UPDATE CCOND_TYPE SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_CCOND_TYPE_DIRECTORY_SQL = "DELETE FROM CCOND_TYPE WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CCondTypeRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CCOND_TYPE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(CCondType.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(CCondType cCondType) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CCOND_TYPE_DIRECTORY_SQL,
                cCondType.getName(),
                cCondType.getCode(),
                cCondType.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_CCOND_TYPE_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(CCondType cCondType) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CCOND_TYPE_DIRECTORY_SQL,
                cCondType.getName(),
                cCondType.getCode()
        );
        return true;
    }
}
