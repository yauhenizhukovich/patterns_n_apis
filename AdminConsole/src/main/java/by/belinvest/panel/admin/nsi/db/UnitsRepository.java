package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.units.Units;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UnitsRepository {
    private static final String NAME_OF_TABLE = "'UNITS'";

    private static final String GET_INFO_FROM_UNITS_DIRECTORY_SQL = "SELECT * FROM UNITS";
    private static final String INSERT_INFO_INTO_UNITS_DIRECTORY_SQL = "INSERT INTO UNITS (UNIT_FULLNAME,UNIT_NAME,IS_DEVELOPER,MANAGER_NAME,MANAGER_POSITION,CURATOR,SUPERIOR_UNIT) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_UNITS_DIRECTORY_SQL = "UPDATE UNITS SET UNIT_FULLNAME = ?,UNIT_NAME = ?,IS_DEVELOPER = ?,MANAGER_NAME = ?,MANAGER_POSITION = ?,CURATOR = ?,SUPERIOR_UNIT = ?  WHERE ID_UNIT = ?";
    private static final String DELETE_INFO_FROM_UNITS_DIRECTORY_SQL = "DELETE FROM UNITS WHERE ID_UNIT = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UnitsRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_UNITS_DIRECTORY_SQL, new BeanPropertyRowMapper<>(Units.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(Units units) {
        jdbcTemplate.update(UPDATE_INFO_INTO_UNITS_DIRECTORY_SQL,
                units.getIdUnit(),
                units.getUnitFullName(),
                units.getUnitName(),
                units.getIsDeveloper(),
                units.getManagerName(),
                units.getManagerPosition(),
                units.getCurator(),
                units.getSuperiorUnit(),
                units.getIdUnit());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_UNITS_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(Units units) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_UNITS_DIRECTORY_SQL,
                units.getIdUnit(),
                units.getUnitFullName(),
                units.getUnitName(),
                units.getIsDeveloper(),
                units.getManagerName(),
                units.getManagerPosition(),
                units.getCurator(),
                units.getSuperiorUnit()
        );
        return true;
    }
}
