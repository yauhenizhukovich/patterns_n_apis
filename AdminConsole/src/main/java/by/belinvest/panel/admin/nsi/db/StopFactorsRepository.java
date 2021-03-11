package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.stop_factors.StopFactors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StopFactorsRepository {

    private static final String NAME_OF_TABLE = "'STOP_FACTORS'";

    private static final String GET_INFO_FROM_STOP_FACTORS_DIRECTORY_SQL = "SELECT * FROM STOP_FACTORS";
    private static final String INSERT_INFO_INTO_STOP_FACTORS_DIRECTORY_SQL = "INSERT INTO STOP_FACTORS (SF_NAME,SF_DESC) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_STOP_FACTORS_DIRECTORY_SQL = "UPDATE STOP_FACTORS SET SF_NAME = ?,SF_DESC = ? WHERE SF_ID = ?";
    private static final String DELETE_INFO_FROM_STOP_FACTORS_DIRECTORY_SQL = "DELETE FROM STOP_FACTORS WHERE SF_ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StopFactorsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_STOP_FACTORS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(StopFactors.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(StopFactors stopFactors) {
        jdbcTemplate.update(UPDATE_INFO_INTO_STOP_FACTORS_DIRECTORY_SQL,
                stopFactors.getSfName(),
                stopFactors.getSfDesc(),
                stopFactors.getSfId());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_STOP_FACTORS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(StopFactors stopFactors) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_STOP_FACTORS_DIRECTORY_SQL,
                stopFactors.getSfName(),
                stopFactors.getSfDesc()
        );
        return true;
    }
}
