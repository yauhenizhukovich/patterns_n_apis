package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.roles.Roles;
import by.belinvest.panel.admin.entity.nsi.roles.RolesDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class RolesRepository {

    private static final String GET_INFO_FROM_ROLES_DIRECTORY_SQL = "SELECT * FROM ROLES";
    private static final String INSERT_INFO_INTO_ROLES_DIRECTORY_SQL = "INSERT INTO ROLES (ROLE_NAME,DESCRIPTION,LOGIN_USER) VALUES (?,?,?)";
    private static final String UPDATE_INFO_INTO_ROLES_DIRECTORY_SQL = "UPDATE ROLES SET ROLE_NAME = ?,DESCRIPTION = ?,LOGIN_USER = ? WHERE ID_ROLE = ?";
    private static final String DELETE_INFO_FROM_ROLES_DIRECTORY_SQL = "DELETE FROM ROLES WHERE ID_ROLE = ?";

    private static final int ID_COLUMN = 1;
    private static final int ROLE_NAME_COLUMN = 2;
    private static final int DESCRIPTION_COLUMN = 3;
    private static final int LOGIN_USER_COLUMN = 4;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolesRepository(@Qualifier("nsiDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public RolesDirectory get() {
        RolesDirectory rolesDirectory = new RolesDirectory();
        jdbcTemplate.query(GET_INFO_FROM_ROLES_DIRECTORY_SQL, rs -> {
            parseDescription(rolesDirectory, rs.getMetaData());
            while (rs.next()) {
                rolesDirectory.getRoles().add(parseRole(rs));
            }
        });

        return rolesDirectory;
    }

    public boolean update(Roles roles) {
        jdbcTemplate.update(UPDATE_INFO_INTO_ROLES_DIRECTORY_SQL,
                roles.getRoleName(),
                roles.getDescription(),
                roles.getLoginUser(),
                roles.getIdRole());
        return true;
    }

    public boolean remove(String rowId) {
        jdbcTemplate.update(DELETE_INFO_FROM_ROLES_DIRECTORY_SQL, rowId);
        return true;
    }

    public boolean create(Roles roles) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_ROLES_DIRECTORY_SQL,
                roles.getRoleName(),
                roles.getDescription(),
                roles.getLoginUser()
        );
        return true;
    }

    private Roles parseRole(ResultSet rs) throws SQLException {
        return new Roles(
                rs.getString(ID_COLUMN),
                rs.getString(ROLE_NAME_COLUMN),
                rs.getString(DESCRIPTION_COLUMN),
                rs.getString(LOGIN_USER_COLUMN)
        );
    }

    private void parseDescription(RolesDirectory rolesDirectory, ResultSetMetaData rsmd) throws SQLException {
        rolesDirectory.setRoleNameDescription(rsmd.getColumnName(ROLE_NAME_COLUMN));
        rolesDirectory.setDescriptionDescription(rsmd.getColumnName(DESCRIPTION_COLUMN));
        rolesDirectory.setLoginUserDescription(rsmd.getColumnName(LOGIN_USER_COLUMN));


    }

}
