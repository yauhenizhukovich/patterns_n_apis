package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bpc_applid.BPCAppLid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BPCAppLidRepository {
    private static final String NAME_OF_TABLE = "'BPC_APPLID'";

    private static final String GET_INFO_FROM_BPC_APPLID_DIRECTORY_SQL = "SELECT * FROM BPC_APPLID";
    private static final String INSERT_INFO_INTO_BPC_APPLID_DIRECTORY_SQL = "INSERT INTO BPC_APPLID (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_BPC_APPLID_DIRECTORY_SQL = "UPDATE BPC_APPLID SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_BPC_APPLID_DIRECTORY_SQL = "DELETE FROM BPC_APPLID WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BPCAppLidRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BPC_APPLID_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BPCAppLid.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BPCAppLid bpStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BPC_APPLID_DIRECTORY_SQL,
                bpStatus.getName(),
                bpStatus.getCode(),
                bpStatus.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_BPC_APPLID_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(BPCAppLid bpStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BPC_APPLID_DIRECTORY_SQL,
                bpStatus.getName(),
                bpStatus.getCode()
        );
        return true;
    }
}
