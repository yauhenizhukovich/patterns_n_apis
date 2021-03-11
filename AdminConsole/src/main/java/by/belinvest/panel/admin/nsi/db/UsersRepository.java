package by.belinvest.panel.admin.nsi.db;

import by.belinvest.panel.admin.entity.nsi.users.Users;
import by.belinvest.panel.admin.entity.nsi.users.UsersDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@Repository
public class UsersRepository {

    private static final String GET_INFO_FROM_USERS_DIRECTORY_SQL = "SELECT * FROM USERS";
    private static final String INSERT_INFO_INTO_USERS_DIRECTORY_SQL = "INSERT INTO USERS (ADDDATE,SURNAME,FIRST_NAME,PATER_NAME,USERLOGIN,USERPWD,ID_ROLE,USEREMAIL,PHONE,MOBPHONE,BIRTHDATE,DEPT,JOB,ISCURATOR,ISBLOCKED) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_INFO_INTO_USERS_DIRECTORY_SQL = "UPDATE USERS SET ADDDATE = ?,SURNAME = ?,FIRST_NAME = ?,PATER_NAME = ?,USERLOGIN = ?,USERPWD = ?, ID_ROLE = ?,USEREMAIL = ?,PHONE = ?,MOBPHONE = ?,BIRTHDATE = ?,DEPT = ?,JOB = ?,ISCURATOR = ?,ISBLOCKED = ?,  WHERE DIMID = ?";
    private static final String DELETE_INFO_FROM_USERS_DIRECTORY_SQL = "DELETE FROM USERS WHERE DIMID = ?";


    private static final int ID_COLUMN = 1;
    private static final int ADDDATE_COLUMN = 2;
    private static final int SURNAME_COLUMN = 3;
    private static final int FIRST_NAME_COLUMN = 4;
    private static final int PATER_NAME_COLUMN = 5;
    private static final int USERLOGIN_COLUMN = 6;
    private static final int USERPWD_COLUMN = 7;
    private static final int ID_ROLE_COLUMN = 8;
    private static final int USEREMAIL_COLUMN = 9;
    private static final int PHONE_COLUMN = 10;
    private static final int MOBPHONE_COLUMN = 11;
    private static final int BIRTHDATE_COLUMN = 12;
    private static final int DEPT_COLUMN = 13;
    private static final int JOB_COLUMN = 14;
    private static final int ISCURATOR_COLUMN = 15;
    private static final int ISBLOCKED_COLUMN = 16;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepository(@Qualifier("nsiDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public UsersDirectory get() {
        UsersDirectory usersDirectory = new UsersDirectory();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        jdbcTemplate.query(GET_INFO_FROM_USERS_DIRECTORY_SQL, rs -> {
            parseDescription(usersDirectory, rs.getMetaData());
            while (rs.next()) {
                System.out.println("^^^^^^^^^^^^^^"+parseUser(rs));
                usersDirectory.getUsers().add(parseUser(rs));
            }
        });

        return usersDirectory;
    }

    public boolean update(Users users) {
        jdbcTemplate.update(UPDATE_INFO_INTO_USERS_DIRECTORY_SQL,
                users.getAdddate(),
                users.getSurname(),
                users.getFirstName(),
                users.getPaterName(),
                users.getUserlogin(),
                users.getUserpwd(),
                users.getIdRole(),
                users.getUsermail(),
                users.getPhone(),
                users.getMobphone(),
                users.getBirthdate(),
                users.getDept(),
                users.getJob(),
                users.getIscurator(),
                users.getIsblocked(),
                users.getIdUser());
        return true;
    }

    public boolean remove(String rowId) {
        jdbcTemplate.update(DELETE_INFO_FROM_USERS_DIRECTORY_SQL, rowId);
        return true;
    }

    public boolean create(Users users) {
        jdbcTemplate.update(
                INSERT_INFO_INTO_USERS_DIRECTORY_SQL,
                users.getAdddate(),
                users.getSurname(),
                users.getFirstName(),
                users.getPaterName(),
                users.getUserlogin(),
                users.getUserpwd(),
                users.getIdRole(),
                users.getUsermail(),
                users.getPhone(),
                users.getMobphone(),
                users.getBirthdate(),
                users.getDept(),
                users.getJob(),
                users.getIscurator(),
                users.getIsblocked()
        );
        return true;
    }

    private Users parseUser(ResultSet rs) throws SQLException {
        return new Users(
                rs.getString(ID_COLUMN),
                rs.getString(ADDDATE_COLUMN),
                rs.getString(SURNAME_COLUMN),
                rs.getString(FIRST_NAME_COLUMN),
                rs.getString(PATER_NAME_COLUMN),
                rs.getString(USERLOGIN_COLUMN),
                rs.getString(USERPWD_COLUMN),
                rs.getString(ID_ROLE_COLUMN),
                rs.getString(USEREMAIL_COLUMN),
                rs.getString(PHONE_COLUMN),
                rs.getString(MOBPHONE_COLUMN),
                rs.getString(BIRTHDATE_COLUMN),
                rs.getString(DEPT_COLUMN),
                rs.getString(JOB_COLUMN),
                rs.getString(ISCURATOR_COLUMN),
                rs.getString(ISBLOCKED_COLUMN)
        );
    }

    private void parseDescription(UsersDirectory usersDirectory, ResultSetMetaData rsmd) throws SQLException {
        System.out.println("@@@@@@@@@@@@@@"+usersDirectory);
        usersDirectory.setAdddateDescription(rsmd.getColumnName(ADDDATE_COLUMN));
        usersDirectory.setSurnameDescription(rsmd.getColumnName(SURNAME_COLUMN));
        usersDirectory.setFirstNameDescription(rsmd.getColumnName(FIRST_NAME_COLUMN));
        usersDirectory.setPaterNameDescription(rsmd.getColumnName(PATER_NAME_COLUMN));
        usersDirectory.setUserloginDescription(rsmd.getColumnName(USERLOGIN_COLUMN));
        usersDirectory.setUserpwdDescription(rsmd.getColumnName(USERPWD_COLUMN));
        usersDirectory.setIdRoleDescription(rsmd.getColumnName(ID_ROLE_COLUMN));
        usersDirectory.setUsermailDescription(rsmd.getColumnName(USEREMAIL_COLUMN));
        usersDirectory.setPhoneDescription(rsmd.getColumnName(PHONE_COLUMN));
        usersDirectory.setMobphoneDescription(rsmd.getColumnName(MOBPHONE_COLUMN));
        usersDirectory.setBirthdateDescription(rsmd.getColumnName(BIRTHDATE_COLUMN));
        usersDirectory.setDeptDescription(rsmd.getColumnName(DEPT_COLUMN));
        usersDirectory.setJobDescription(rsmd.getColumnName(JOB_COLUMN));
        usersDirectory.setIscuratorDescription(rsmd.getColumnName(ISCURATOR_COLUMN));
        usersDirectory.setIsblockedDescription(rsmd.getColumnName(ISBLOCKED_COLUMN));


    }

}
