package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.real_estate.RealEstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class RealEstateRepository {

    private static final String NAME_OF_TABLE = "'REAL_ESTATE'";

    private static final String GET_INFO_FROM_REAL_ESTATE_DIRECTORY_SQL = "SELECT * FROM REAL_ESTATE";
    private static final String INSERT_INFO_INTO_REAL_ESTATE_DIRECTORY_SQL = "INSERT INTO REAL_ESTATE (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_REAL_ESTATE_DIRECTORY_SQL = "UPDATE REAL_ESTATE SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_REAL_ESTATE_DIRECTORY_SQL = "DELETE FROM REAL_ESTATE WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RealEstateRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_REAL_ESTATE_DIRECTORY_SQL, new BeanPropertyRowMapper<>(RealEstate.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(RealEstate realEstate) {
        jdbcTemplate.update(UPDATE_INFO_INTO_REAL_ESTATE_DIRECTORY_SQL,
                realEstate.getName(),
                realEstate.getCode(),
                realEstate.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_REAL_ESTATE_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(RealEstate realEstate) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_REAL_ESTATE_DIRECTORY_SQL,
                realEstate.getName(),
                realEstate.getCode()
        );
        return true;
    }
}
