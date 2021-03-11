package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.nsi_801.Nsi801;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Nsi801Repository {
    private static final String NAME_OF_TABLE = "'NSI_801'";

    private static final String GET_INFO_FROM_NSI_801_DIRECTORY_SQL = "SELECT * FROM NSI_801";
    private static final String INSERT_INFO_INTO_NSI_801_DIRECTORY_SQL = "INSERT INTO NSI_801 (PARENTID,CODE,NAME,LGOTNOST_SIGN,REFER_INVEST,GOSMEROPRIATIA) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_NSI_801_DIRECTORY_SQL = "UPDATE NSI_801 SET PARENTID = ?,CODE = ?,NAME = ?,LGOTNOST_SIGN = ?,REFER_INVEST = ?,GOSMEROPRIATIA = ?  WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_NSI_801_DIRECTORY_SQL = "DELETE FROM NSI_801 WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public Nsi801Repository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_NSI_801_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Nsi801.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Nsi801 nsi801) {
        jdbcTemplate.update(UPDATE_INFO_INTO_NSI_801_DIRECTORY_SQL,
                nsi801.getParentId(),
                nsi801.getCode(),
                nsi801.getName(),
                nsi801.getLgotnostSign(),
                nsi801.getReferInvest(),
                nsi801.getGosmeropriatia(),
                nsi801.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_NSI_801_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Nsi801 nsi801) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_NSI_801_DIRECTORY_SQL,
                nsi801.getParentId(),
                nsi801.getCode(),
                nsi801.getName(),
                nsi801.getLgotnostSign(),
                nsi801.getReferInvest(),
                nsi801.getGosmeropriatia()
        );
        return true;
    }
}
