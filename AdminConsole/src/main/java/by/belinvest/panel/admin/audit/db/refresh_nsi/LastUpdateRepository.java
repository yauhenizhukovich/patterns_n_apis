package by.belinvest.panel.admin.audit.db.refresh_nsi;


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
public class LastUpdateRepository {
    public static final String SQL_GET_LAST_UPDATE = "select NVL(TO_CHAR(MAX(t.enddate), 'dd-mm-yyyy hh24:mi:ss'), 'Данные не обновлялись.') as LAST_UPDATE_DATE from BN_REFRESH_LOG t";

    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LastUpdateRepository(@Qualifier("nsiDatasource") DataSource dataSource, CommentRepository commentRepository) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.commentRepository = commentRepository;
    }


    public Map<String, String> getLastUpdateDate() {
        Map<String, String> updateDate = new LinkedHashMap<>();
        String updateDateResult;
        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(SQL_GET_LAST_UPDATE);
            for (Map<String, Object> map : result) {
                updateDate.put("LAST_UPDATE_DATE", (String) map.get("LAST_UPDATE_DATE"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return updateDate;
    }

}