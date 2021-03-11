package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.economy_activity.EconomyActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EconomyActivityRepository {

    private static final String NAME_OF_TABLE = "'ECONOMY_ACTIVITY'";

    private static final String GET_INFO_FROM_ECONOMY_ACTIVITY_DIRECTORY_SQL = "SELECT * FROM ECONOMY_ACTIVITY";
    private static final String INSERT_INFO_INTO_ECONOMY_ACTIVITY_DIRECTORY_SQL = "INSERT INTO ECONOMY_ACTIVITY (PARENTID,CODE,NAME,K1,K2,K3,OLD_CODES) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_ECONOMY_ACTIVITY_DIRECTORY_SQL = "UPDATE ECONOMY_ACTIVITY SET PARENTID = ?,CODE = ?,NAME = ?,K1 = ?,K2 = ?,K3 = ?,OLD_CODES = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_ECONOMY_ACTIVITY_DIRECTORY_SQL = "DELETE FROM ECONOMY_ACTIVITY WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EconomyActivityRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_ECONOMY_ACTIVITY_DIRECTORY_SQL, new BeanPropertyRowMapper<>(EconomyActivity.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(EconomyActivity economyActivity) {
        jdbcTemplate.update(UPDATE_INFO_INTO_ECONOMY_ACTIVITY_DIRECTORY_SQL,
                economyActivity.getParentId(),
                economyActivity.getCode(),
                economyActivity.getName(),
                economyActivity.getK1(),
                economyActivity.getK2(),
                economyActivity.getK3(),
                economyActivity.getOldCodes(),
                economyActivity.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_ECONOMY_ACTIVITY_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(EconomyActivity EconomyActivity) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_ECONOMY_ACTIVITY_DIRECTORY_SQL,
                EconomyActivity.getParentId(),
                EconomyActivity.getCode(),
                EconomyActivity.getName(),
                EconomyActivity.getK1(),
                EconomyActivity.getK2(),
                EconomyActivity.getK3(),
                EconomyActivity.getOldCodes()

        );
        return true;
    }
}
