package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.typ_vidach.TypVidach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TypVidachRepository {

    private static final String NAME_OF_TABLE = "'TYP_VIDACH'";

    private static final String GET_INFO_FROM_TYP_VIDACH_DIRECTORY_SQL = "SELECT * FROM TYP_VIDACH";
    private static final String INSERT_INFO_INTO_TYP_VIDACH_DIRECTORY_SQL = "INSERT INTO TYP_VIDACH (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_TYP_VIDACH_DIRECTORY_SQL = "UPDATE TYP_VIDACH SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_TYP_VIDACH_DIRECTORY_SQL = "DELETE FROM TYP_VIDACH WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TypVidachRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_TYP_VIDACH_DIRECTORY_SQL, new BeanPropertyRowMapper<>(TypVidach.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(TypVidach typVidach) {
        jdbcTemplate.update(UPDATE_INFO_INTO_TYP_VIDACH_DIRECTORY_SQL,
                typVidach.getName(),
                typVidach.getCode(),
                typVidach.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_TYP_VIDACH_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(TypVidach typVidach) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_TYP_VIDACH_DIRECTORY_SQL,
                typVidach.getName(),
                typVidach.getCode()
        );
        return true;
    }
}
