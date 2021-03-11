package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.base_value_type.BaseValueType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BaseValueTypeRepository {

    private static final String NAME_OF_TABLE = "'BASE_VALUE_TYPE'";

    private static final String GET_INFO_FROM_BASE_VALUE_TYPE_DIRECTORY_SQL = "SELECT * FROM BASE_VALUE_TYPE";
    private static final String INSERT_INFO_INTO_BASE_VALUE_TYPE_DIRECTORY_SQL = "INSERT INTO BASE_VALUE_TYPE (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_BASE_VALUE_TYPE_DIRECTORY_SQL = "UPDATE BASE_VALUE_TYPE SET NAME = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_BASE_VALUE_TYPE_DIRECTORY_SQL = "DELETE FROM BASE_VALUE_TYPE WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BaseValueTypeRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BASE_VALUE_TYPE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BaseValueType.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BaseValueType baseValueType) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BASE_VALUE_TYPE_DIRECTORY_SQL,
                baseValueType.getName(),
                baseValueType.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_BASE_VALUE_TYPE_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(BaseValueType baseValueType) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BASE_VALUE_TYPE_DIRECTORY_SQL,
                baseValueType.getName()
        );
        return true;
    }


}
