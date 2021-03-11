package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.product.Criterion;
import by.belinvest.panel.admin.entity.product.Field;
import by.belinvest.panel.admin.entity.product.ProductHierCrit;
import by.belinvest.panel.admin.entity.product.ValueNSI;
import by.belinvest.panel.admin.product.dto.LevelHierarchyDTO;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LevelHierarchyRepository {

    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    @Autowired
    private ProductHierCritJDBCRepository productHierCritJDBCRepository;

    /*@Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LevelHierarchyRepository(@Qualifier("catalogDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String GET_FIELDS_BY_TABLE_NAME = "select c.table_name, c.column_name, c.comments, f.data_type, f.data_length from all_col_comments c, all_tab_columns f\n" +
            "            where c.OWNER||'.'||c.TABLE_NAME = c.OWNER||'.'||f.TABLE_NAME and c.COLUMN_NAME = f.COLUMN_NAME\n" +
            "            and c.COLUMN_NAME not in ('ID','DIMID','SYS_ID') and\n" +
            "            c.OWNER||'.'||c.TABLE_NAME = case when instr(:TABLE_NAME,'.') = 0 then 'CTL.'||:TABLE_NAME else :TABLE_NAME end";*/

    private static final String GET_FIELDS_BY_TABLE_NAME = "select c.table_name, c.column_name, c.comments, f.data_type, case when f.CHAR_USED = 'C' then f.char_length else f.data_length end data_length from all_col_comments c, all_tab_columns f\n" +
            "where c.OWNER||'.'||c.TABLE_NAME = c.OWNER||'.'||f.TABLE_NAME and c.COLUMN_NAME = f.COLUMN_NAME\n" +
            "  and c.COLUMN_NAME not in ('ID','DIMID','SYS_ID') and\n" +
            "            c.OWNER||'.'||c.TABLE_NAME = case when instr(:TABLE_NAME,'.') = 0 then 'CTL.'||:TABLE_NAME else :TABLE_NAME end";

    public LevelHierarchyDTO getLevelHierarchyDTOList(String tableName,String nsiTableName, Long productGroupId) {
        LevelHierarchyDTO levelHierarchyDTO = new LevelHierarchyDTO();

        levelHierarchyDTO.setCriterionList(productHierCritJDBCRepository.findAllByProductGroupId(productGroupId));
        levelHierarchyDTO.setFieldList(getFieldList(tableName));
        levelHierarchyDTO.setLineValues(getValueNSI(nsiTableName));

        return levelHierarchyDTO;
    }

    @SuppressWarnings("unchecked")
    public List<Criterion> getCriterionList(ProductHierCrit crit){
        List<Tuple> criterions = entityManager.createNativeQuery("SELECT "+crit.getFieldName()+","+crit.getFieldText()+" FROM "+crit.getTableName(),Tuple.class)
                .getResultList();
        return criterions.stream()
                .map(criterion -> Criterion
                        .builder()
                        .id(criterion.get(crit.getFieldName(),BigDecimal.class).longValue())
                        .name(criterion.get(crit.getFieldText(),String.class))
                        .build()
                )
                .collect(Collectors.toList());

        /*List<Criterion> criterionList = new ArrayList<>();

        List<Map<String,Object>> result = jdbcTemplate.queryForList("SELECT "+crit.getFieldName()+","+crit.getFieldText()+" FROM "+crit.getTableName());
        for (Map<String,Object> entity:result) {
            criterionList.add(Criterion.builder()
                    .name(entity.get(crit.getFieldText()).toString())
                    .id(Long.parseLong(entity.get(crit.getFieldName()).toString()))
                    .build());
        }
        return criterionList;*/
    }

    @SuppressWarnings("unchecked")
    public List<Field> getFieldList(String tableName){
        List<Tuple> fields = entityManager.createNativeQuery(GET_FIELDS_BY_TABLE_NAME,Tuple.class)
                .setParameter("TABLE_NAME", new TypedParameterValue(StandardBasicTypes.STRING, tableName))
                .getResultList();
        fields = fields.stream()
                .filter(field -> field.get("COMMENTS") != null)
                .collect(Collectors.toList());

        List<Field> fieldList = new ArrayList<>();
        long id = 0L;

        for (Tuple field:fields) {
            fieldList.add(Field.builder()
                    .id(++id)
                    .name(field.get("COMMENTS").toString())
                    .tableName(field.get("TABLE_NAME").toString())
                    .fieldName(field.get("COLUMN_NAME").toString())
                    .dataType(field.get("DATA_TYPE").toString())
                    .dataLength(((BigDecimal) field.get("DATA_LENGTH")).intValue())
                    .build());
        }
        return fieldList;



        /*return fields.stream()
                .filter(field -> field.get("COMMENTS") != null)
                .map(field ->
                    Field.builder()
                        .id()
                        .name(field.get("COMMENTS").toString())
                        .tableName(field.get("TABLE_NAME").toString())
                        .fieldName(field.get("COLUMN_NAME").toString())
                        .dataType(field.get("DATA_TYPE").toString())
                        .dataLength(((BigDecimal) field.get("DATA_LENGTH")).intValue())
                        .build()
                )
                .collect(Collectors.toList());

        List<Field> fieldList = new ArrayList<>();

        StringBuilder query = new StringBuilder("select c.table_name, c.column_name, c.comments, f.data_type, f.data_length from user_col_comments c, user_tab_columns f\n" +
                "where c.TABLE_NAME = f.TABLE_NAME and c.COLUMN_NAME = f.COLUMN_NAME and c.TABLE_NAME = ");
        query.append("'").append(tableName).append("'");
        Long id = 1L;
        for (Map<String,Object> entity:jdbcTemplate.queryForList(query.toString())) {
            if(entity.get("COMMENTS")!=null){
                fieldList.add(Field.builder()
                        .id(id)
                        .name(entity.get("COMMENTS").toString())
                        .tableName(entity.get("TABLE_NAME").toString())
                        .fieldName(entity.get("COLUMN_NAME").toString())
                        .dataType(entity.get("DATA_TYPE").toString())
                        .dataLength(((BigDecimal) entity.get("DATA_LENGTH")).intValue())
                        .build());
                ++id;
            }
        }
        return fieldList;*/
    }

    @SuppressWarnings("unchecked")
    public List<ValueNSI> getValueNSI(String nsiTableName){
        List<Tuple> values = entityManager.createNativeQuery("SELECT * FROM " + nsiTableName,Tuple.class)
                .getResultList();
        return values.stream()
                .map(value -> ValueNSI
                        .builder()
                        .code(value.get("CODE",BigDecimal.class).longValue())
                        .name(value.get("NAME",String.class))
                        .build()
                )
                .collect(Collectors.toList());
    }
}
