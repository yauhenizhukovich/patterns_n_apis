package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.product_sc.ProductSC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProductSCRepository {

    private static final String NAME_OF_TABLE = "'PRODUCT_SC'";

    private static final String GET_INFO_FROM_PRODUCT_SC_DIRECTORY_SQL = "SELECT * FROM PRODUCT_SC";
    private static final String INSERT_INFO_INTO_PRODUCT_SC_DIRECTORY_SQL = "INSERT INTO PRODUCT_SC (PSC_NAME,PSC_DESC) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_PRODUCT_SC_DIRECTORY_SQL = "UPDATE PRODUCT_SC SET PSC_NAME = ?,PSC_DESC = ? WHERE PSC_ID = ?";
    private static final String DELETE_INFO_FROM_PRODUCT_SC_DIRECTORY_SQL = "DELETE FROM PRODUCT_SC WHERE PSC_ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductSCRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate =new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PRODUCT_SC_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ProductSC.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ProductSC productSC) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PRODUCT_SC_DIRECTORY_SQL,
                productSC.getPscName(),
                productSC.getPscDesc(),
                productSC.getPscId()
        );
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_PRODUCT_SC_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(ProductSC productSC) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PRODUCT_SC_DIRECTORY_SQL,
                productSC.getPscName(),
                productSC.getPscDesc()
        );
        return true;
    }
}
