package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.risks.Risks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class RisksRepository {

    private static final String NAME_OF_TABLE = "'RISKS'";

    private static final String GET_INFO_FROM_RISKS_DIRECTORY_SQL = "SELECT * FROM RISKS";
    private static final String INSERT_INFO_INTO_RISKS_DIRECTORY_SQL = "INSERT INTO RISKS (RISK_NAME,DESCRIPTION) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_RISKS_DIRECTORY_SQL = "UPDATE RISKS SET RISK_NAME = ?,DESCRIPTION = ? WHERE ID_RISK = ?";
    private static final String DELETE_INFO_FROM_RISKS_DIRECTORY_SQL = "DELETE FROM RISKS WHERE ID_RISK = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RisksRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_RISKS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Risks.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Risks risks) {
        jdbcTemplate.update(UPDATE_INFO_INTO_RISKS_DIRECTORY_SQL,
                risks.getRiskName(),
                risks.getDescription(),
                risks.getIdRisk());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_RISKS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Risks risks) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_RISKS_DIRECTORY_SQL,
                risks.getRiskName(),
                risks.getDescription()
        );
        return true;
    }
}
