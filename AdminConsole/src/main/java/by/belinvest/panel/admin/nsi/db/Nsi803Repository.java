package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_803.Nsi803;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Nsi803Repository {

    private static final String NAME_OF_TABLE = "'NSI_803'";

    private static final String GET_INFO_FROM_NSI_803_DIRECTORY_SQL = "SELECT * FROM NSI_803";
    private static final String INSERT_INFO_INTO_NSI_803_DIRECTORY_SQL = "INSERT INTO NSI_803 (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_NSI_803_DIRECTORY_SQL = "UPDATE NSI_803 SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_NSI_803_DIRECTORY_SQL = "DELETE FROM NSI_803 WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Nsi803Repository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_NSI_803_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Nsi803.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Nsi803 nsi803) {
        jdbcTemplate.update(UPDATE_INFO_INTO_NSI_803_DIRECTORY_SQL,
                nsi803.getName(),
                nsi803.getCode(),
                nsi803.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_NSI_803_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Nsi803 nsi803) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_NSI_803_DIRECTORY_SQL,
                nsi803.getName(),
                nsi803.getCode()
        );
        return true;
    }
}
