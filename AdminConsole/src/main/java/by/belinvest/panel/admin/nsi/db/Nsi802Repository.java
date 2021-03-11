package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_802.Nsi802;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Nsi802Repository {
    private static final String NAME_OF_TABLE = "'NSI_802'";

    private static final String GET_INFO_FROM_NSI_802_DIRECTORY_SQL = "SELECT * FROM NSI_802";
    private static final String INSERT_INFO_INTO_NSI_802_DIRECTORY_SQL = "INSERT INTO NSI_802 (PARENTID,CODE,NAME,NSI_812) VALUES (?,?,?,?)";
    private static final String UPDATE_INFO_INTO_NSI_802_DIRECTORY_SQL = "UPDATE NSI_802 SET PARENTID = ?,CODE = ?,NAME = ?,NSI_812 = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_NSI_802_DIRECTORY_SQL = "DELETE FROM NSI_802 WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Nsi802Repository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_NSI_802_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Nsi802.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Nsi802 nsi802) {
        jdbcTemplate.update(UPDATE_INFO_INTO_NSI_802_DIRECTORY_SQL,
                nsi802.getParentId(),
                nsi802.getCode(),
                nsi802.getName(),
                nsi802.getNsi812(),
                nsi802.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_NSI_802_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Nsi802 nsi802) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_NSI_802_DIRECTORY_SQL,
                nsi802.getParentId(),
                nsi802.getCode(),
                nsi802.getName(),
                nsi802.getNsi812()
        );
        return true;
    }
}
