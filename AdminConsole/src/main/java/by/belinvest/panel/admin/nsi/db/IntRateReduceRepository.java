package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.int_rate_reduce.IntRateReduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class IntRateReduceRepository {
    private static final String NAME_OF_TABLE = "'INT_RATE_REDUCE'";

    private static final String GET_INFO_FROM_INT_RATE_REDUCE_DIRECTORY_SQL = "SELECT * FROM INT_RATE_REDUCE";
    private static final String INSERT_INFO_INTO_INT_RATE_REDUCE_DIRECTORY_SQL = "INSERT INTO INT_RATE_REDUCE (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_INT_RATE_REDUCE_DIRECTORY_SQL = "UPDATE INT_RATE_REDUCE SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_INT_RATE_REDUCE_DIRECTORY_SQL = "DELETE FROM INT_RATE_REDUCE WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IntRateReduceRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_INT_RATE_REDUCE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(IntRateReduce.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(IntRateReduce intRateReduce) {
        jdbcTemplate.update(UPDATE_INFO_INTO_INT_RATE_REDUCE_DIRECTORY_SQL,
                intRateReduce.getCode(),
                intRateReduce.getName(),
                intRateReduce.getNote(),
                intRateReduce.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_INT_RATE_REDUCE_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(IntRateReduce intRateReduce) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_INT_RATE_REDUCE_DIRECTORY_SQL,
                intRateReduce.getCode(),
                intRateReduce.getName(),
                intRateReduce.getNote()
                );
        return true;
    }
}
