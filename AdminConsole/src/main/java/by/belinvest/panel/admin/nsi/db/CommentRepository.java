package by.belinvest.panel.admin.nsi.db;


import by.belinvest.panel.admin.entity.nsi.tabledate.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {

    private static final String GET_COMMENT_OF_TABLE_AND_COLUMNS_SQL = "SELECT USER_COL_COMMENTS.TABLE_NAME,USER_TAB_COMMENTS.COMMENTS AS TAB_COMMENTS,COLUMN_NAME,USER_COL_COMMENTS.COMMENTS as COL_COMMENTS FROM USER_TAB_COMMENTS INNER JOIN USER_COL_COMMENTS ON USER_TAB_COMMENTS.TABLE_NAME = USER_COL_COMMENTS.TABLE_NAME WHERE USER_COL_COMMENTS.TABLE_NAME = ";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentRepository(@Qualifier("nsiDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public TableData getCommentOfTableAndColumns(String nameOfTable){
        TableData tableData = new TableData();
        Map<String,String> columns = new LinkedHashMap<>();

        List<Map<String,Object>> result= jdbcTemplate.queryForList(GET_COMMENT_OF_TABLE_AND_COLUMNS_SQL+nameOfTable);
        for (Map<String,Object> map:result) {
            columns.put((String) map.get("COLUMN_NAME"),(String) map.get("COL_COMMENTS"));
        }

       /* for (Map.Entry<String, String> entry : columns.entrySet()) {
            if (entry.getKey().contains("ID")){
                columns.remove(entry.getKey());
            }
        }*/

       columns.entrySet().removeIf(stringStringEntry -> stringStringEntry.getKey().contains("ID"));

        tableData.setNameOfColumns(columns);
        tableData.setNameOfTable((String) result.get(0).get("TAB_COMMENTS"));

        return tableData;
    }

}
