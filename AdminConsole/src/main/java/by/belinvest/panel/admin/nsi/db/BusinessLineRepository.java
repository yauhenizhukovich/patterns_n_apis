package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.business_line.BusinessLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BusinessLineRepository {
    private static final String NAME_OF_TABLE = "'BUSINESS_LINE'";

    private static final String GET_INFO_FROM_BUSINESS_LINE_DIRECTORY_SQL = "SELECT * FROM BUSINESS_LINE";
    private static final String INSERT_INFO_INTO_BUSINESS_LINE_DIRECTORY_SQL = "INSERT INTO BUSINESS_LINE (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_BUSINESS_LINE_DIRECTORY_SQL = "UPDATE BUSINESS_LINE SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_BUSINESS_LINE_DIRECTORY_SQL = "DELETE FROM BUSINESS_LINE WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BusinessLineRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BUSINESS_LINE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BusinessLine.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BusinessLine businessLine) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BUSINESS_LINE_DIRECTORY_SQL,
                businessLine.getName(),
                businessLine.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_BUSINESS_LINE_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(BusinessLine businessLine) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BUSINESS_LINE_DIRECTORY_SQL,
                businessLine.getName()
        );
        return true;
    }
}
