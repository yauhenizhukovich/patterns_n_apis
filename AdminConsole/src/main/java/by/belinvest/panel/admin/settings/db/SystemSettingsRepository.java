package by.belinvest.panel.admin.settings.db;

import by.belinvest.panel.admin.entity.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class SystemSettingsRepository {

    private static final String GET_SETTINGS_SQL = "SELECT * FROM SYSPARAMS";
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SystemSettingsRepository(@Qualifier("settings") DataSource dataSource) throws SQLException, NamingException {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Setting> getSettings() {
        List<Setting> settings = jdbcTemplate.query(GET_SETTINGS_SQL, new SystemRepoRowMapper());
        return settings;
    }

    public boolean saveSettings(Setting setting) throws RuntimeException {
        String query = "insert into sysparams values(" +
                "'" + setting.getSysOwner() + "','" + setting.getEmailServer() + "','" + setting.getNotificationTemplate() + "" +
                "','" + setting.getApiBarsNsiAddress() + "','" + setting.getApiBarsNsiUser() + "','" + setting.getApiBarsNsiPwd() + "" +
                "','" + setting.getApiBrisNsiAdress() + "','" + setting.getApiBrisNsiUser() + "','" + setting.getApiBrisNsiPwd() + "" +
                "','" + setting.getApiBarsAccAdress() + "','" + setting.getApiBarsAccUser() + "','" + setting.getApiBarsAccPwd() + "" +
                "','" + setting.getSedFolderPath() + "','" + setting.getTimeoutSyncNsi() + "','" + setting.getTimeoutSyncAcc() + "'"+")";

                jdbcTemplate.update(query);
        return true;
    }


    public boolean editSettings(Setting setting, String id) throws RuntimeException {

        HashMap<String, String> map = new HashMap<>();
        map.put("SYS_OWNER",setting.getSysOwner());
       // map.put("EMAIL_SERVER",setting.getEmailServer());
       // map.put("NOTIFICATION_TEMPLATE",setting.getNotificationTemplate());

       // map.put("API_BARS_NSI_ADDRESS",setting.getApiBarsNsiAddress());
       // map.put("API_BARS_NSI_USER",setting.getApiBarsNsiUser());
       // map.put("API_BARS_NSI_PWD",setting.getApiBarsNsiPwd() );

        map.put("API_BRIS_NSI_ADDRESS", setting.getApiBrisNsiAdress());
        map.put("API_BRIS_NSI_USER",setting.getApiBrisNsiUser());
        map.put("API_BRIS_NSI_PWD",setting.getApiBrisNsiPwd() );

       // map.put("API_BARS_ACC_ADDRESS",setting.getApiBarsAccAdress());
       // map.put("API_BARS_ACC_USER", setting.getApiBarsAccUser());
       // map.put("API_BARS_ACC_PWD", setting.getApiBarsAccPwd());

       // map.put("SED_FOLDER_PATH", setting.getSedFolderPath());
       // map.put("TIMEOUT_SYNC_NSI", setting.getTimeoutSyncNsi());
       // map.put("TIMEOUT_SYNC_ACC", setting.getTimeoutSyncAcc());

        map.entrySet().removeIf(stringStringEntry -> stringStringEntry.getKey() == null); // remove nullable elements
        map.entrySet().removeIf(stringStringEntry -> stringStringEntry.getKey().equals(""));

        StringBuilder stringBuilder = new StringBuilder("update sysparams set");

        boolean isFirst = true;

        for (Map.Entry<String, String> s : map.entrySet()) { //makeup query with params
            if (isFirst) {
                stringBuilder.append(" ");
                isFirst = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(s.getKey() + " = " + "'" + s.getValue() + "'");
        }

        stringBuilder.append(" WHERE SYS_OWNER='" + id + "'");
        String query = stringBuilder.toString();

        jdbcTemplate.update(query);

        return false;

    }
}
