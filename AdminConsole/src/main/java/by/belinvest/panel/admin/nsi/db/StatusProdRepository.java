package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.status_prod.StatusProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StatusProdRepository {
    private static final String NAME_OF_TABLE = "'STATUS_PROD'";

    private static final String GET_INFO_FROM_STATUS_PROD_DIRECTORY_SQL = "SELECT * FROM STATUS_PROD";
    private static final String INSERT_INFO_INTO_STATUS_PROD_DIRECTORY_SQL = "INSERT INTO STATUS_PROD (NAME_RUS,NAME_ENG) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_STATUS_PROD_DIRECTORY_SQL = "UPDATE STATUS_PROD SET NAME_RUS = ? ,NAME_ENG = ? WHERE ID=?";
    private static final String DELETE_INFO_FROM_STATUS_PROD_DIRECTORY_SQL = "DELETE FROM STATUS_PROD WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StatusProdRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_STATUS_PROD_DIRECTORY_SQL, new BeanPropertyRowMapper<>(StatusProd.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(StatusProd statusProd) {
        jdbcTemplate.update(UPDATE_INFO_INTO_STATUS_PROD_DIRECTORY_SQL,
                statusProd.getNameRus(),
                statusProd.getNameEng(),
                statusProd.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_STATUS_PROD_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(StatusProd statusProd) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_STATUS_PROD_DIRECTORY_SQL,
                statusProd.getNameRus(),
                statusProd.getNameEng()
        );
        return true;
    }
}
