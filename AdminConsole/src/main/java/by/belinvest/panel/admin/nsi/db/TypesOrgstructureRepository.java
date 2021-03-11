package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.types_orgstrucrure.TypesOrgStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TypesOrgstructureRepository {

    private static final String NAME_OF_TABLE = "'TYPES_ORGSTRUCTURE'";

    private static final String GET_INFO_FROM_TYPES_ORGSTRUCTURE_DIRECTORY_SQL = "SELECT * FROM TYPES_ORGSTRUCTURE";
    private static final String INSERT_INFO_INTO_TYPES_ORGSTRUCTURE_DIRECTORY_SQL = "INSERT INTO TYPES_ORGSTRUCTURE (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_TYPES_ORGSTRUCTURE_DIRECTORY_SQL = "UPDATE TYPES_ORGSTRUCTURE SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_TYPES_ORGSTRUCTURE_DIRECTORY_SQL = "DELETE FROM TYPES_ORGSTRUCTURE WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TypesOrgstructureRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_TYPES_ORGSTRUCTURE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(TypesOrgStructure.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(TypesOrgStructure typesOrgStructure) {
        jdbcTemplate.update(UPDATE_INFO_INTO_TYPES_ORGSTRUCTURE_DIRECTORY_SQL,
                typesOrgStructure.getName(),
                typesOrgStructure.getCode(),
                typesOrgStructure.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_TYPES_ORGSTRUCTURE_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(TypesOrgStructure typesOrgStructure) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_TYPES_ORGSTRUCTURE_DIRECTORY_SQL,
                typesOrgStructure.getName(),
                typesOrgStructure.getCode()
        );
        return true;
    }
}
