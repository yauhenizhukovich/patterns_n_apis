package by.belinvest.panel.admin.nsi.navigation.db;


import by.belinvest.panel.admin.entity.nsi.Tables;
import by.belinvest.panel.admin.nsi.db.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NavigationRepository {


    private static final String GET_TABLES_DIRECTORY_SQL = "SELECT LOWER(table_name) as T_NAME , comments as T_COMMENT FROM user_tab_comments where table_name!='BANK_NSI_JSON' AND table_name!='ERROR_LOG' AND table_name!='JSON_TABLE' AND table_name!='PROC_ROLES' AND table_name!='PROC_USERS' AND table_name!='SYSPARAMS' AND table_name!='UNITS' AND table_name!='ROLES' AND table_name!='USERS' AND table_name!='UNITS' AND table_name!='WORK_TYPE' AND LOWER(TABLE_NAME) NOT LIKE 'bin%' ORDER BY comments";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NavigationRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Tables getTables() {
        Map<String, String> tables = new LinkedHashMap<>();
        Tables tablesObj = new Tables();

        List<Map<String, Object>> result = jdbcTemplate.queryForList(GET_TABLES_DIRECTORY_SQL);
        for (Map<String, Object> map : result) {
            tables.put((String) map.get("T_NAME"), (String) map.get("T_COMMENT"));
       }
       tablesObj.setTables(tables);
        return tablesObj;
    }
}

