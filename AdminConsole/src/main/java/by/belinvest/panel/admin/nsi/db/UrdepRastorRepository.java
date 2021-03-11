package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.urdep_rastor.UrdepRastor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UrdepRastorRepository {

    private static final String NAME_OF_TABLE = "'URDEP_RASTOR'";

    private static final String GET_INFO_FROM_URDEP_RASTOR_DIRECTORY_SQL = "SELECT * FROM URDEP_RASTOR";
    private static final String INSERT_INFO_INTO_URDEP_RASTOR_DIRECTORY_SQL = "INSERT INTO URDEP_RASTOR (NAME,CODE) VALUES (?,?)";
    private static final String UPDATE_INFO_INTO_URDEP_RASTOR_DIRECTORY_SQL = "UPDATE URDEP_RASTOR SET NAME = ?,CODE = ? WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_URDEP_RASTOR_DIRECTORY_SQL = "DELETE FROM URDEP_RASTOR WHERE DIMID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UrdepRastorRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_URDEP_RASTOR_DIRECTORY_SQL, new BeanPropertyRowMapper<>(UrdepRastor.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(UrdepRastor urdepRastor) {
        jdbcTemplate.update(UPDATE_INFO_INTO_URDEP_RASTOR_DIRECTORY_SQL,
                urdepRastor.getName(),
                urdepRastor.getCode(),
                urdepRastor.getDimid());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_URDEP_RASTOR_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(UrdepRastor urdepRastor) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_URDEP_RASTOR_DIRECTORY_SQL,
                urdepRastor.getName(),
                urdepRastor.getCode()
        );
        return true;
    }
}
