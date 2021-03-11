package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.freq_issue.FreqIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FreqIssueRepository {

    private static final String NAME_OF_TABLE = "'FREQ_ISSUE'";

    private static final String GET_INFO_FROM_FREQ_ISSUE_DIRECTORY_SQL = "SELECT * FROM FREQ_ISSUE";
    private static final String INSERT_INFO_INTO_FREQ_ISSUE_DIRECTORY_SQL = "INSERT INTO FREQ_ISSUE (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_FREQ_ISSUE_DIRECTORY_SQL = "UPDATE FREQ_ISSUE SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_FREQ_ISSUE_DIRECTORY_SQL = "DELETE FROM FREQ_ISSUE WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FreqIssueRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_FREQ_ISSUE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(FreqIssue.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(FreqIssue freqIssue) {
        jdbcTemplate.update(UPDATE_INFO_INTO_FREQ_ISSUE_DIRECTORY_SQL,
                freqIssue.getCode(),
                freqIssue.getName(),
                freqIssue.getNote(),
                freqIssue.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_FREQ_ISSUE_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(FreqIssue freqIssue) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_FREQ_ISSUE_DIRECTORY_SQL,
                freqIssue.getCode(),
                freqIssue.getName(),
                freqIssue.getNote()
        );
        return true;
    }
}
