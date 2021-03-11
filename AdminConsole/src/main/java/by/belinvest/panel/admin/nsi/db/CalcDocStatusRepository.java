package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.calc_doc_status.CalcDocStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CalcDocStatusRepository {
    private static final String NAME_OF_TABLE = "'CALC_DOC_STATUS'";

    private static final String GET_INFO_FROM_CALC_DOC_STATUS_DIRECTORY_SQL = "SELECT * FROM CALC_DOC_STATUS";
    private static final String INSERT_INFO_INTO_CALC_DOC_STATUS_DIRECTORY_SQL = "INSERT INTO CALC_DOC_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_CALC_DOC_STATUS_DIRECTORY_SQL = "UPDATE CALC_DOC_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_CALC_DOC_STATUS_DIRECTORY_SQL = "DELETE FROM CALC_DOC_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CalcDocStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CALC_DOC_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(CalcDocStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(CalcDocStatus calcDocStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CALC_DOC_STATUS_DIRECTORY_SQL,
                calcDocStatus.getName(),
                calcDocStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_CALC_DOC_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(CalcDocStatus calcDocStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CALC_DOC_STATUS_DIRECTORY_SQL,
                calcDocStatus.getName()
        );
        return true;
    }
}
