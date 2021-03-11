package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.cd_doc_status.CdDocStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CdDocStatusRepository {
    private static final String NAME_OF_TABLE = "'CD_DOC_STATUS'";

    private static final String GET_INFO_FROM_CD_DOC_STATUS_DIRECTORY_SQL = "SELECT * FROM CD_DOC_STATUS";
    private static final String INSERT_INFO_INTO_CD_DOC_STATUS_DIRECTORY_SQL = "INSERT INTO CD_DOC_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_CD_DOC_STATUS_DIRECTORY_SQL = "UPDATE CD_DOC_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_CD_DOC_STATUS_DIRECTORY_SQL = "DELETE FROM CD_DOC_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CdDocStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_CD_DOC_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(CdDocStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(CdDocStatus cdDocStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_CD_DOC_STATUS_DIRECTORY_SQL,
                cdDocStatus.getName(),
                cdDocStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_CD_DOC_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(CdDocStatus cdDocStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_CD_DOC_STATUS_DIRECTORY_SQL,
                cdDocStatus.getName()
        );
        return true;
    }
}
