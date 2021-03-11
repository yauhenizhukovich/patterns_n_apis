package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.term_unit.TermUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TermUnitRepository {

    private static final String NAME_OF_TABLE = "'TERM_UNIT'";

    private static final String GET_INFO_FROM_TERM_UNIT_DIRECTORY_SQL = "SELECT * FROM TERM_UNIT";
    private static final String INSERT_INFO_INTO_TERM_UNIT_DIRECTORY_SQL = "INSERT INTO TERM_UNIT (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_TERM_UNIT_DIRECTORY_SQL = "UPDATE TERM_UNIT SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_TERM_UNIT_DIRECTORY_SQL = "DELETE FROM TERM_UNIT WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TermUnitRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_TERM_UNIT_DIRECTORY_SQL, new BeanPropertyRowMapper<>(TermUnit.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(TermUnit termUnit) {
        jdbcTemplate.update(UPDATE_INFO_INTO_TERM_UNIT_DIRECTORY_SQL,
                termUnit.getCode(),
                termUnit.getName(),
                termUnit.getNote(),
                termUnit.getId());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_TERM_UNIT_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(TermUnit termUnit) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_TERM_UNIT_DIRECTORY_SQL,
                termUnit.getCode(),
                termUnit.getName(),
                termUnit.getNote()
        );
        return true;
    }
}
