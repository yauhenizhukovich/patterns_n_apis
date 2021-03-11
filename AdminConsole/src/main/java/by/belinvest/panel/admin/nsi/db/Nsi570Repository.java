package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_570.Nsi570;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Nsi570Repository {

    private static final String NAME_OF_TABLE = "'NSI_570'";

    private static final String GET_INFO_FROM_NSI_570_DIRECTORY_SQL = "SELECT * FROM NSI_570";
    private static final String INSERT_INFO_INTO_NSI_570_DIRECTORY_SQL = "INSERT INTO NSI_570 (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_NSI_570_DIRECTORY_SQL = "UPDATE NSI_570 SET CODE = ?,NAME = ?,NOTE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_NSI_570_DIRECTORY_SQL = "DELETE FROM NSI_570 WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Nsi570Repository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_NSI_570_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Nsi570.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Nsi570 nsi570) {
        jdbcTemplate.update(UPDATE_INFO_INTO_NSI_570_DIRECTORY_SQL,
                nsi570.getCode(),
                nsi570.getName(),
                nsi570.getNote(),
                nsi570.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_NSI_570_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Nsi570 nsi570) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_NSI_570_DIRECTORY_SQL,
                nsi570.getCode(),
                nsi570.getName(),
                nsi570.getNote()
        );
        return true;
    }
}
