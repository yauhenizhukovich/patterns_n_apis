package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.ministry.Ministry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MinistryRepository {

    private static final String NAME_OF_TABLE = "'KD_POK_BRIS'";

    private static final String GET_INFO_FROM_MINISTRY_DIRECTORY_SQL = "SELECT * FROM MINISTRY";
    private static final String INSERT_INFO_INTO_MINISTRY_DIRECTORY_SQL = "INSERT INTO MINISTRY (CODE,NAME,INTER_CODE) VALUES (?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_MINISTRY_DIRECTORY_SQL = "UPDATE MINISTRY SET CODE = ?,NAME = ?,INTER_CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_MINISTRY_DIRECTORY_SQL = "DELETE FROM MINISTRY WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MinistryRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_MINISTRY_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Ministry.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Ministry ministry) {
        jdbcTemplate.update(UPDATE_INFO_INTO_MINISTRY_DIRECTORY_SQL,
                ministry.getCode(),
                ministry.getName(),
                ministry.getInterCode(),
                ministry.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_MINISTRY_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Ministry ministry) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_MINISTRY_DIRECTORY_SQL,
                ministry.getCode(),
                ministry.getName(),
                ministry.getInterCode()
        );
        return true;
    }
}
