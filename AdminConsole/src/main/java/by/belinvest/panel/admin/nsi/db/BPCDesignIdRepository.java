package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bpc_designid.BPCDesignId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BPCDesignIdRepository {
    private static final String NAME_OF_TABLE = "'BPC_DESIGNID'";

    private static final String GET_INFO_FROM_BPC_DESIGNID_DIRECTORY_SQL = "SELECT * FROM BPC_DESIGNID";
    private static final String INSERT_INFO_INTO_BPC_DESIGNID_DIRECTORY_SQL = "INSERT INTO BPC_DESIGNID (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_BPC_DESIGNID_DIRECTORY_SQL = "UPDATE BPC_DESIGNID SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_BPC_DESIGNID_DIRECTORY_SQL = "DELETE FROM BPC_DESIGNID WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BPCDesignIdRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BPC_DESIGNID_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BPCDesignId.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BPCDesignId bpcDesignId) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BPC_DESIGNID_DIRECTORY_SQL,
                bpcDesignId.getName(),
                bpcDesignId.getCode(),
                bpcDesignId.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_BPC_DESIGNID_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(BPCDesignId bpcDesignId) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BPC_DESIGNID_DIRECTORY_SQL,
                bpcDesignId.getName(),
                bpcDesignId.getCode()
        );
        return true;
    }
}
