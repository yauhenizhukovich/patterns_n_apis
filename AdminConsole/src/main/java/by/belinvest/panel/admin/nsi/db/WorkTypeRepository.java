package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.work_type.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class WorkTypeRepository {

    private static final String NAME_OF_TABLE = "'WORK_TYPE'";

    private static final String GET_INFO_FROM_WORK_TYPE_DIRECTORY_SQL = "SELECT * FROM WORK_TYPE";
    private static final String INSERT_INFO_INTO_WORK_TYPE_DIRECTORY_SQL = "INSERT INTO WORK_TYPE (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_WORK_TYPE_DIRECTORY_SQL = "UPDATE WORK_TYPE SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_WORK_TYPE_DIRECTORY_SQL = "DELETE FROM WORK_TYPE WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkTypeRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_WORK_TYPE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(WorkType.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(WorkType workType) {
        jdbcTemplate.update(UPDATE_INFO_INTO_WORK_TYPE_DIRECTORY_SQL,
                workType.getName(),
                workType.getCode());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_WORK_TYPE_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(WorkType workType) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_WORK_TYPE_DIRECTORY_SQL,
                workType.getName()
        );
        return true;
    }
}
