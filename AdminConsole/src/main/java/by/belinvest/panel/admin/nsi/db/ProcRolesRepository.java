package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.proc_roles.ProcRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProcRolesRepository {

    private static final String NAME_OF_TABLE = "'PROC_ROLES'";

    private static final String GET_INFO_FROM_PROC_ROLES_DIRECTORY_SQL = "SELECT * FROM PROC_ROLES";
    private static final String INSERT_INFO_INTO_PROC_ROLES_DIRECTORY_SQL = "INSERT INTO PROC_ROLES (ROLE_NAME,ROLE_DESC,ROLE_DESC2,CREATE_DATE) VALUES (?,?,?,?)";
    private static final String UPDATE_INFO_INTO_PROC_ROLES_DIRECTORY_SQL = "UPDATE PROC_ROLES SET ROLE_NAME = ?,ROLE_DESC = ?,ROLE_DESC2 = ?,CREATE_DATE = ? WHERE ID = ?";
    private static final String DELETE_INFO_FROM_PROC_ROLES_DIRECTORY_SQL = "DELETE FROM PROC_ROLES WHERE ID = ?";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcRolesRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }

    public DirectoryDTO get() {
        DirectoryDTO directoryDTO = new DirectoryDTO();
        directoryDTO.setDirectory(jdbcTemplate.query(GET_INFO_FROM_PROC_ROLES_DIRECTORY_SQL, new BeanPropertyRowMapper<>(ProcRoles.class)));
        directoryDTO.setTableData(commentRepository.getCommentOfTableAndColumns(NAME_OF_TABLE));
        return directoryDTO;
    }

    public boolean update(ProcRoles procRoles) {
        jdbcTemplate.update(UPDATE_INFO_INTO_PROC_ROLES_DIRECTORY_SQL,
                procRoles.getRoleName(),
                procRoles.getRoleDesc(),
                procRoles.getRoleDesc2(),
                procRoles.getCreatDate(),
                procRoles.getId());
        return true;
    }

    public boolean remove(String dimid) {
        jdbcTemplate.update(DELETE_INFO_FROM_PROC_ROLES_DIRECTORY_SQL, dimid);
        return true;
    }

    public boolean create(ProcRoles procRoles) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_PROC_ROLES_DIRECTORY_SQL,
                procRoles.getRoleName(),
                procRoles.getRoleDesc(),
                procRoles.getRoleDesc2(),
                procRoles.getCreatDate()
        );
        return true;
    }
}
