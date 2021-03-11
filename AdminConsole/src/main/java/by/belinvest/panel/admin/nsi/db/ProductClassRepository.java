package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.product_class.ProductClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProductClassRepository {


    private static final String NAME_OF_TABLE = "'PRODUCT_CLASS'";

    private static final String GET_INFO_FROM_PRODUCT_CLASS_DIRECTORY_SQL = "SELECT * FROM PRODUCT_CLASS";
    private static final String INSERT_INFO_INTO_PRODUCT_CLASS_DIRECTORY_SQL = "INSERT INTO PRODUCT_CLASS (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_PRODUCT_CLASS_DIRECTORY_SQL = "UPDATE PRODUCT_CLASS SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_PRODUCT_CLASS_DIRECTORY_SQL = "DELETE FROM PRODUCT_CLASS WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductClassRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PRODUCT_CLASS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ProductClass.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ProductClass productClass) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PRODUCT_CLASS_DIRECTORY_SQL,
                productClass.getCode(),
                productClass.getName(),
                productClass.getNote(),
                productClass.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_PRODUCT_CLASS_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(ProductClass productClass) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PRODUCT_CLASS_DIRECTORY_SQL,
                productClass.getCode(),
                productClass.getName(),
                productClass.getNote()
        );
        return true;
    }
}
