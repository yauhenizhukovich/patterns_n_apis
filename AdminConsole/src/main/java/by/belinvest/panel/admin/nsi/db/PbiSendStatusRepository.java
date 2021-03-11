package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.pbi_send_status.PbiSendStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PbiSendStatusRepository {

    private static final String NAME_OF_TABLE = "'PBI_RESP_STATUS'";

    private static final String GET_INFO_FROM_PBI_SEND_STATUS_DIRECTORY_SQL = "SELECT * FROM PBI_SEND_STATUS";
    private static final String INSERT_INFO_INTO_PBI_SEND_STATUS_DIRECTORY_SQL = "INSERT INTO PBI_SEND_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_PBI_SEND_STATUS_DIRECTORY_SQL = "UPDATE PBI_SEND_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_PBI_SEND_STATUS_DIRECTORY_SQL = "DELETE FROM PBI_SEND_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PbiSendStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PBI_SEND_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(PbiSendStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(PbiSendStatus pbiSendStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PBI_SEND_STATUS_DIRECTORY_SQL,
                pbiSendStatus.getName(),
                pbiSendStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_PBI_SEND_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(PbiSendStatus pbiSendStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PBI_SEND_STATUS_DIRECTORY_SQL,
                pbiSendStatus.getName()
        );
        return true;
    }
}
