package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bpc_prod_status.BPCProdStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BPCProdStatusRepository {
    private static final String NAME_OF_TABLE = "'BPC_PROD_STATUS'";

    private static final String GET_INFO_FROM_BPC_PROD_STATUS_DIRECTORY_SQL = "SELECT * FROM BPC_PROD_STATUS";
    private static final String INSERT_INFO_INTO_BPC_PROD_STATUS_DIRECTORY_SQL = "INSERT INTO BPC_PROD_STATUS (NAME) VALUES (?)";
    private static final String UPDATE_INFO_INTO_BPC_PROD_STATUS_DIRECTORY_SQL = "UPDATE BPC_PROD_STATUS SET NAME = ? WHERE CODE = ?";
    private static final String DELETE_INFO_FROM_BPC_PROD_STATUS_DIRECTORY_SQL = "DELETE FROM BPC_PROD_STATUS WHERE CODE = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BPCProdStatusRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_BPC_PROD_STATUS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(BPCProdStatus.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(BPCProdStatus bpcProdStatus) {
        jdbcTemplate.update(UPDATE_INFO_INTO_BPC_PROD_STATUS_DIRECTORY_SQL,
                bpcProdStatus.getName(),
                bpcProdStatus.getCode());
        return true;
    }

    public boolean remove(String code) {
        jdbcTemplate.update(DELETE_INFO_FROM_BPC_PROD_STATUS_DIRECTORY_SQL, code);
        return true;
    }

    public boolean create(BPCProdStatus bpcProdStatus) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_BPC_PROD_STATUS_DIRECTORY_SQL,
                bpcProdStatus.getName()
        );
        return true;
    }
}
