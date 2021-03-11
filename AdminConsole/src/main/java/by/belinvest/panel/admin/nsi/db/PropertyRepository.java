package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PropertyRepository {

    private static final String NAME_OF_TABLE = "'PROPERTY'";

    private static final String GET_INFO_FROM_PROPERTY_DIRECTORY_SQL = "SELECT * FROM PROPERTY";
    private static final String INSERT_INFO_INTO_PROPERTY_DIRECTORY_SQL = "INSERT INTO PROPERTY (PARENTID,CODE,NAME,PROPERTY_DEPOSIT_NAME) VALUES (?,?,?,?)";
    private static final String UPDATE_INFO_INTO_PROPERTY_DIRECTORY_SQL = "UPDATE PROPERTY SET PARENTID = ?,CODE = ?,NAME = ?,PROPERTY_DEPOSIT_NAME = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_PROPERTY_DIRECTORY_SQL = "DELETE FROM PROPERTY WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PropertyRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PROPERTY_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Property.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Property property) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PROPERTY_DIRECTORY_SQL,
                property.getParentId(),
                property.getCode(),
                property.getName(),
                property.getPropertyDepositName(),
                property.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_PROPERTY_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Property property) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PROPERTY_DIRECTORY_SQL,
                property.getParentId(),
                property.getCode(),
                property.getName(),
                property.getPropertyDepositName()
        );
        return true;
    }
}
