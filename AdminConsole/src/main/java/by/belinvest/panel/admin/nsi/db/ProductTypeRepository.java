package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.product_type.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProductTypeRepository {
    private static final String NAME_OF_TABLE = "'PRODUCT_TYPE'";

    private static final String GET_INFO_FROM_PRODUCT_TYPE_DIRECTORY_SQL = "SELECT * FROM PRODUCT_TYPE";
    private static final String INSERT_INFO_INTO_PRODUCT_TYPE_DIRECTORY_SQL = "INSERT INTO PRODUCT_TYPE (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_PRODUCT_TYPE_DIRECTORY_SQL = "UPDATE PRODUCT_TYPE SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_PRODUCT_TYPE_DIRECTORY_SQL = "DELETE FROM PRODUCT_TYPE WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductTypeRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PRODUCT_TYPE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ProductType.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ProductType productType) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PRODUCT_TYPE_DIRECTORY_SQL,
                productType.getCode(),
                productType.getName(),
                productType.getNote(),
                productType.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_PRODUCT_TYPE_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(ProductType productType) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PRODUCT_TYPE_DIRECTORY_SQL,
                productType.getCode(),
                productType.getName(),
                productType.getNote()
        );
        return true;
    }
}
