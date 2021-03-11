package by.belinvest.panel.admin.settings.db;

import by.belinvest.panel.admin.entity.Setting;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemRepoRowMapper implements RowMapper<Setting> {
    @Override
    public Setting mapRow(ResultSet resultSet, int i) throws SQLException {
        Setting setting = new Setting();
        setting.setSysOwner(resultSet.getString("SYS_OWNER"));
        setting.setEmailServer(resultSet.getString("EMAIL_SERVER"));
        setting.setNotificationTemplate(resultSet.getString("NOTIFICATION_TEMPLATE"));
        setting.setApiBarsNsiAddress(resultSet.getString("API_BARS_NSI_ADDRESS"));
        setting.setApiBarsNsiUser(resultSet.getString("API_BARS_NSI_USER"));
        setting.setApiBarsNsiPwd(resultSet.getString("API_BARS_NSI_PWD"));
        setting.setApiBrisNsiAdress(resultSet.getString("API_BRIS_NSI_ADDRESS"));
        setting.setApiBrisNsiUser(resultSet.getString("API_BRIS_NSI_USER"));
        setting.setApiBrisNsiPwd(resultSet.getString("API_BRIS_NSI_PWD"));
        setting.setApiBarsAccAdress(resultSet.getString("API_BARS_ACC_ADDRESS"));
        setting.setApiBarsAccUser(resultSet.getString("API_BARS_ACC_USER"));
        setting.setApiBarsAccPwd(resultSet.getString("API_BARS_ACC_PWD"));
        setting.setSedFolderPath(resultSet.getString("SED_FOLDER_PATH"));
        setting.setTimeoutSyncNsi(resultSet.getString("TIMEOUT_SYNC_NSI"));
        setting.setTimeoutSyncAcc(resultSet.getString("TIMEOUT_SYNC_ACC"));
        return setting;
    }
}
