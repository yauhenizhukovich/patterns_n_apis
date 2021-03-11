package by.belinvest.panel.admin.nsi.db;


import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.accstatus.AccStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AccStatusRepository {

    private static final String NAME_OF_TABLE = "'ACC_STATUS'";

    private static final String GET_INFO_FROM_ACC_STATUS_DIRECTORY_SQL = "SELECT * FROM ACC_STATUS";
    private static final String INSERT_INFO_INTO_ACC_STATUS_DIRECTORY_SQL = "INSERT INTO ACC_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_ACC_STATUS_DIRECTORY_SQL = "UPDATE ACC_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_ACC_STATUS_DIRECTORY_SQL = "DELETE FROM ACC_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AccStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_ACC_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(AccStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(AccStatus accStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_ACC_STATUS_DIRECTORY_SQL,
                accStatus.getName(),
                accStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_ACC_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(AccStatus accStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_ACC_STATUS_DIRECTORY_SQL,
                accStatus.getName()
        );
        return true;
    }


}
