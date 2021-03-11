package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.pbi_resp_status.PbiRespStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PbiRespStatusRepository {

    private static final String NAME_OF_TABLE = "'PBI_RESP_STATUS'";

    private static final String GET_INFO_FROM_PBI_RESP_STATUS_DIRECTORY_SQL = "SELECT * FROM PBI_RESP_STATUS";
    private static final String INSERT_INFO_INTO_PBI_RESP_STATUS_DIRECTORY_SQL = "INSERT INTO PBI_RESP_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_PBI_RESP_STATUS_DIRECTORY_SQL = "UPDATE PBI_RESP_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_PBI_RESP_STATUS_DIRECTORY_SQL = "DELETE FROM PBI_RESP_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PbiRespStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PBI_RESP_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(PbiRespStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(PbiRespStatus pbiRespStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PBI_RESP_STATUS_DIRECTORY_SQL,
                pbiRespStatus.getName(),
                pbiRespStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_PBI_RESP_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(PbiRespStatus pbiRespStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PBI_RESP_STATUS_DIRECTORY_SQL,
                pbiRespStatus.getName()
        );
        return true;
    }

}
