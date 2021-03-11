package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.partial_issuance.PartialIssuance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PartialIssuanceRepository {

    private static final String NAME_OF_TABLE = "'PARTIAL_ISSUANCE'";

    private static final String GET_INFO_FROM_PARTIAL_ISSUANCE_DIRECTORY_SQL = "SELECT * FROM PARTIAL_ISSUANCE";
    private static final String INSERT_INFO_INTO_PARTIAL_ISSUANCE_DIRECTORY_SQL = "INSERT INTO PARTIAL_ISSUANCE (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_PARTIAL_ISSUANCE_DIRECTORY_SQL = "UPDATE PARTIAL_ISSUANCE SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_PARTIAL_ISSUANCE_DIRECTORY_SQL = "DELETE FROM PARTIAL_ISSUANCE WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PartialIssuanceRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PARTIAL_ISSUANCE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(PartialIssuance.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(PartialIssuance partialIssuance) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PARTIAL_ISSUANCE_DIRECTORY_SQL,
                partialIssuance.getCode(),
                partialIssuance.getName(),
                partialIssuance.getNote(),
                partialIssuance.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_PARTIAL_ISSUANCE_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(PartialIssuance partialIssuance) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PARTIAL_ISSUANCE_DIRECTORY_SQL,
                partialIssuance.getCode(),
                partialIssuance.getName(),
                partialIssuance.getNote()
        );
        return true;
    }
}
