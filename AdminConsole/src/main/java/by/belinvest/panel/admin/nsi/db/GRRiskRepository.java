package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.gr_risk.GRRisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class GRRiskRepository {
    private static final String NAME_OF_TABLE = "'GR_RISK'";

    private static final String GET_INFO_FROM_GR_RISK_DIRECTORY_SQL = "SELECT * FROM GR_RISK";
    private static final String INSERT_INFO_INTO_GR_RISK_DIRECTORY_SQL = "INSERT INTO GR_RISK (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_GR_RISK_DIRECTORY_SQL = "UPDATE GR_RISK SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_GR_RISK_DIRECTORY_SQL = "DELETE FROM GR_RISK WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GRRiskRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_GR_RISK_DIRECTORY_SQL, new BeanPropertyRowMapper<>(GRRisk.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(GRRisk grRisk) {
        jdbcTemplate.update(UPDATE_INFO_INTO_GR_RISK_DIRECTORY_SQL,
                grRisk.getName(),
                grRisk.getCode(),
                grRisk.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_GR_RISK_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(GRRisk grRisk) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_GR_RISK_DIRECTORY_SQL,
                grRisk.getName(),
                grRisk.getCode()
        );
        return true;
    }
}
