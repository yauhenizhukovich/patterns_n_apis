package by.belinvest.panel.admin.product.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import by.belinvest.panel.admin.entity.product.Field;
import by.belinvest.panel.admin.entity.product.ProductGroup;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import static by.belinvest.panel.admin.product.service.constant.ProductConstant.URCRED;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.URDEP;

@Component
public class ProductJDBCRepository {

    private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplateCtl;
    private JdbcTemplate jdbcTemplateNSI;

    @Autowired
    public ProductJDBCRepository(@Qualifier("catalogDatasource") DataSource dataSourceCtl, @Qualifier("nsiDatasource") DataSource dataSourceNsi) {
        this.jdbcTemplate = new JdbcTemplate(dataSourceCtl);
        this.jdbcTemplateCtl = new JdbcTemplate(dataSourceCtl);
        this.jdbcTemplateNSI = new JdbcTemplate(dataSourceNsi);
    }

    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    public Map<String, Object> getProductAsMapById(Long productId, String tableName) {
        String idName;
        switch (tableName) {
            case URDEP:
            case URCRED:
                idName = "DIMID";
                break;
            default:
                idName = "ID";
        }
        String query = "SELECT * FROM " + tableName + " WHERE " + idName + " = " + productId;

        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);

        if (!list.isEmpty()) {
            return list.stream().findFirst().get();
        }

        return new HashMap<>();
    }

    public Map<String, Object> getProductAsMapForSynchronizationById(Long productId, String tableName) {
        String idName;
        switch (tableName) {
            case URDEP:
            case URCRED:
                idName = "DIMID";
                break;
            default:
                idName = "SYS_ID";
        }
        String query = "SELECT * FROM " + tableName + " WHERE " + idName + " = " + productId;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
        if (!list.isEmpty()) {
            return list.stream().findFirst().get();
        }
        return new HashMap<>();
    }

    public int updateHierarchyLevel(List<Field> fields, String tableName, List<String> productsId) {
        /*StringBuilder QUERY = new StringBuilder("UPDATE ");
        QUERY.append(tableName).append(" ");
        int current = 0;
        QUERY.append("SET ");
        for (Field field : fields){
            current++;
            QUERY.append(field.getFieldName());
            QUERY.append("=?");

            if(field.getDataType().equals("VARCHAR") || field.getDataType().equals("VARCHAR2") || field.getDataType().equals("DATE") ){
                if(field.getValue().equals("")){
                    QUERY.append("NULL");
                }else {
                    QUERY.append("'").append(field.getValue()).append("'");
                }
            }else{
                if(field.getValue().equals("")){
                    QUERY.append("NULL");
                }else {
                    QUERY.append(field.getValue());
                }

            }
            if(current != fields.size()){
                QUERY.append(" , ");
            }
        }

        current = 0;
        QUERY.append(" WHERE ID IN (");
        for (String id: productsId){
            current++;
            QUERY.append(id);
            if (current != productsId.size()){
                QUERY.append(",");
            }
        }
        QUERY.append(")");*/

        String tableId;
        switch (tableName) {
            case URDEP:
            case URCRED:
                tableId = "DIMID";
                break;
            default:
                tableId = "ID";
        }

        /**
         *Create dynamic query for update
         */
        StringBuilder QUERY = new StringBuilder("UPDATE " + tableName + " SET ");
        int current = 0;
        for (Field field : fields) {
            current++;
            if (field.getFieldName().equals("ID")) {
                continue;
            }
            QUERY.append(field.getFieldName()).append(" =:").append(field.getFieldName());
            if (current != fields.size()) {
                QUERY.append(" , ");
            }
        }
        QUERY.append(" WHERE " + tableId + " IN (");
        current = 0;
        for (String id : productsId) {
            current++;
            QUERY.append(id);
            if (current != productsId.size()) {
                QUERY.append(",");
            }
        }
        QUERY.append(")");
        Query query = entityManager.createNativeQuery(QUERY.toString());

        /**
         * Inject params for query
         */

        for (Field field : fields) {
            if (field.getFieldName().equals(tableId)) {
                continue;
            }
            if (field.getDataType().equals("VARCHAR") || field.getDataType().equals("VARCHAR2") || field.getDataType().equals("DATE")) {
                if (field.getValue().equals("")) {
                    query.setParameter(field.getFieldName(), new TypedParameterValue(StandardBasicTypes.STRING, null));
                } else {
                    query.setParameter(field.getFieldName(), new TypedParameterValue(StandardBasicTypes.STRING, field.getValue()));
                }
            } else {
                if (field.getValue().equals("")) {
                    query.setParameter(field.getFieldName(), new TypedParameterValue(StandardBasicTypes.LONG, null));
                } else {
                    query.setParameter(field.getFieldName(),
                            new TypedParameterValue(StandardBasicTypes.LONG, Long.parseLong(field.getValue())));
                }
            }
        }

        return query.executeUpdate();
    }

    public Long createRealProduct(List<Field> fields, String tableName) {

        /** Если таблица находится в другой базе данных (т.е. в названии именеет приставку
         *  другой бызы), то оставляем  только название (без приставки) **/
        if (tableName.contains(".")) {
            tableName = tableName.split("\\.")[1];
        }
        SimpleJdbcInsert simpleJdbcInsert;
        String id;

        switch (tableName) {
            case "URDEP":
            case "URCRED":
                simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplateNSI.getDataSource());
                id = "DIMID";
                break;
            default:
                simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplateCtl.getDataSource());
                id = "ID";
        }

        simpleJdbcInsert.withTableName(tableName);
        simpleJdbcInsert.usingGeneratedKeyColumns(id);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        for (Field field : fields) {
            if (field.getFieldName().equals(id)) {
                continue;
            }
            if (field.getDataType().equals("VARCHAR") || field.getDataType().equals("VARCHAR2") || field.getDataType().equals("DATE")) {
                if (field.getValue().equals("")) {
                    parameters.addValue(field.getFieldName(), null);
                } else {
                    parameters.addValue(field.getFieldName(), field.getValue());
                }
            } else {
                if (field.getValue().equals("")) {
                    parameters.addValue(field.getFieldName(), null);
                } else {
                    parameters.addValue(field.getFieldName(), field.getValue());
                }
            }
        }

        Number resultId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return resultId.longValue();
    }

    public String getNameOfProductById(String tableName, String nameOfField, Long id) {
        String idName;
        switch (tableName) {
            case URDEP:
            case URCRED:
                idName = "DIMID";
                break;
            default:
                idName = "ID";
        }
        List<String> name = jdbcTemplate.queryForList("SELECT " + nameOfField + " as name FROM " + tableName + " WHERE " + idName + " = " + id,
                String.class);
        if (name.isEmpty()) {
            return "";
        }
        return name.stream().findFirst().get();
    }

    public void deleteRealProductById(Long id, String tableName) {
        entityManager.createNativeQuery("DELETE FROM " + tableName + " WHERE ID = :param1")
                .setParameter("param1", id)
                .executeUpdate();
    }

    public void saveProductGroup(ProductGroup productGroup) {

        String sql = "INSERT INTO PRODUCT_GROUP values(SQ_PRODUCT_GROUP.nextval,'" + productGroup.getName() + "'," + productGroup.getHiId() + ",'','','','','')";
        jdbcTemplate.execute(sql);

    }

    public void updateProductView(ProductGroup productGroup) {
        StringBuilder stringBuilder = new StringBuilder("update product_group set name = '" + productGroup.getName() + "'");
        if (productGroup.getHiId() != null) {
            stringBuilder.append(", HI_ID=" + productGroup.getHiId() + "");
        }

        stringBuilder.append(" where id = " + productGroup.getId() + "");

        // String sql = "update product_group set name = '"+productGroup.getName()+"', HI_ID="+productGroup.getHiId()+" where id = "+productGroup.getId()+"";
        jdbcTemplate.execute(stringBuilder.toString());
    }

    public void deleteProductView(Integer id) {
        String sql = "delete from product_group where id=" + id + "";
        jdbcTemplate.execute(sql);
    }

}
