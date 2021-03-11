package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.prospects.Prospects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProspectsRepository {

    private static final String NAME_OF_TABLE = "'PROSPECTS'";

    private static final String GET_INFO_FROM_PROSPECTS_DIRECTORY_SQL = "SELECT * FROM PROSPECTS";
    private static final String INSERT_INFO_INTO_PROSPECTS_DIRECTORY_SQL = "INSERT INTO PROSPECTS (PROSPECTS_NAME,PROSPECTS_DESC) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_PROSPECTS_DIRECTORY_SQL = "UPDATE PROSPECTS SET PROSPECTS_NAME = ?,PROSPECTS_DESC = ? WHERE ID_PROSPECTS = ?";
    private static final String DELETE_INFO_FROM_PROSPECTS_DIRECTORY_SQL = "DELETE FROM PROSPECTS WHERE ID_PROSPECTS = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProspectsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PROSPECTS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Prospects.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Prospects prospects) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PROSPECTS_DIRECTORY_SQL,
                prospects.getProspectsName(),
                prospects.getProspectsDesc(),
                prospects.getIdProspects()
        );
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_PROSPECTS_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(Prospects prospects) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PROSPECTS_DIRECTORY_SQL,
                prospects.getProspectsName(),
                prospects.getProspectsDesc()
        );
        return true;
    }
}
