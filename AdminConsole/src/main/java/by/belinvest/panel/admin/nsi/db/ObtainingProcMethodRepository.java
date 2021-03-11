package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.obtaining_proc_method.ObtainingProcMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ObtainingProcMethodRepository {
    private static final String NAME_OF_TABLE = "'OBTAINING_PROC_METHOD'";

    private static final String GET_INFO_FROM_OBTAINING_PROC_METHOD_DIRECTORY_SQL = "SELECT * FROM OBTAINING_PROC_METHOD";
    private static final String INSERT_INFO_INTO_OBTAINING_PROC_METHOD_DIRECTORY_SQL = "INSERT INTO OBTAINING_PROC_METHOD (CODE,NAME,NOTE) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_OBTAINING_PROC_METHOD_DIRECTORY_SQL = "UPDATE OBTAINING_PROC_METHOD SET CODE = ?,NAME = ?,NOTE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_OBTAINING_PROC_METHOD_DIRECTORY_SQL = "DELETE FROM OBTAINING_PROC_METHOD WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ObtainingProcMethodRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_OBTAINING_PROC_METHOD_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ObtainingProcMethod.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ObtainingProcMethod obtainingProcMethod) {
        jdbcTemplate.update(UPDATE_INFO_INTO_OBTAINING_PROC_METHOD_DIRECTORY_SQL,
                obtainingProcMethod.getCode(),
                obtainingProcMethod.getName(),
                obtainingProcMethod.getNote(),
                obtainingProcMethod.getId());
        return true;
    }

    public boolean remove(String id) {
        jdbcTemplate.update(DELETE_INFO_FROM_OBTAINING_PROC_METHOD_DIRECTORY_SQL, id);
        return true;
    }

    public boolean create(ObtainingProcMethod obtainingProcMethod) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_OBTAINING_PROC_METHOD_DIRECTORY_SQL,
                obtainingProcMethod.getCode(),
                obtainingProcMethod.getName(),
                obtainingProcMethod.getNote()
        );
        return true;
    }
}
