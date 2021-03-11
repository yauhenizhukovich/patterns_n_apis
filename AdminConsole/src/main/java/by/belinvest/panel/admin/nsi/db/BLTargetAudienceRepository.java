package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bl_target_audience.BLTargetAudience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BLTargetAudienceRepository {
    private static final String NAME_OF_TABLE = "'BL_TARGET_AUDIENCE'";

    private static final String GET_INFO_FROM_BL_TARGET_AUDIENCE_DIRECTORY_SQL = "SELECT * FROM BL_TARGET_AUDIENCE";
    private static final String INSERT_INFO_INTO_BL_TARGET_AUDIENCE_DIRECTORY_SQL = "INSERT INTO BL_TARGET_AUDIENCE (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_BL_TARGET_AUDIENCE_DIRECTORY_SQL = "UPDATE BL_TARGET_AUDIENCE SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_BL_TARGET_AUDIENCE_DIRECTORY_SQL = "DELETE FROM BL_TARGET_AUDIENCE WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BLTargetAudienceRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BL_TARGET_AUDIENCE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BLTargetAudience.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BLTargetAudience blTargetAudience) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BL_TARGET_AUDIENCE_DIRECTORY_SQL,
                blTargetAudience.getName(),
                blTargetAudience.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_BL_TARGET_AUDIENCE_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(BLTargetAudience blTargetAudience) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BL_TARGET_AUDIENCE_DIRECTORY_SQL,
                blTargetAudience.getName()
        );
        return true;
    }
}
