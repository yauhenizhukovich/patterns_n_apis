package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.nsi.calc_doc_status.CalcDocStatus;
import by.belinvest.panel.admin.entity.product.ProductGroup;
import by.belinvest.panel.admin.entity.product.ProductHierCrit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductHierCritJDBCRepository {
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_RECORDS_QUERY = "SELECT * FROM PRODUCT_HIER_CRIT WHERE GROUP_ID = ?";

    @Autowired
    public ProductHierCritJDBCRepository(@Qualifier("catalogDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<ProductHierCrit> findAllByProductGroupId(Long productGroupId){
        Object [] params = {productGroupId};
        List<Map<String,Object>> result = jdbcTemplate.queryForList(SELECT_ALL_RECORDS_QUERY,params);
        return result.stream().map(record ->
            ProductHierCrit.builder()
                    .id(((BigDecimal) record.get("ID")).longValue())
                    .name((String) record.get("CRITERY_NAME"))
                    .tableName((String) record.get("TABLE_NAME"))
                    .fieldName((String) record.get("FIELD_NAME"))
                    .fieldText((String) record.get("FIELD_TEXT"))
                    .productGroup(ProductGroup.builder()
                            .id(((BigDecimal) record.get("GROUP_ID")).longValue())
                            .build())
                    .build()
        ).collect(Collectors.toList());
    }
}
