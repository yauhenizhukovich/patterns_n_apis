package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.product.dto.ProductLine;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductLineRepository {
    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    private final static String SELECT_ALL_FROM_DIRECTORY_NSI = "SELECT * FROM ";

    private final static String FIND_FIRST_LINE_CRITERION = "SELECT CRIT " +
            " FROM PRODUCT_HIER_STRUCT" +
            " WHERE LEV = 1 AND PRODUCT_HIER_ID = :param1 AND CRIT IS NOT NULL";

    private final static String IS_VALUE_FROM_NSI_USED = "select case when exists (select NULL from product_hier_crit hc, product_hier_struct hs, product_hier_value hv" +
            "                         where hc.ID = hs.crit" +
            "                           and hv.IDSTRUCT = hs.ID" +
            "                           and lev = 1" +
            "                           and hc.TABLE_NAME = :TABLE_NAME and hv.VALUE = :VALUE" +
            "                           and hs.PRODUCT_HIER_ID <> :PRODUCT_HIER_ID) then 0 else 1 end EX from dual";

    @SuppressWarnings("unchecked")
    public List<ProductLine> getProductLines(String tableName){
        String query = SELECT_ALL_FROM_DIRECTORY_NSI + tableName;
        List<Tuple> tuples = entityManager.createNativeQuery(query, Tuple.class)
                .getResultList();

        return tuples.stream().map(tuple->
             ProductLine.builder()
                    .code(tuple.get("CODE", BigDecimal.class).longValue())
                    .name(tuple.get("NAME", String.class))
                    .build()
        ).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public Long isValueUsed(String tableName, Long value, Long productHierId){
         return ((BigDecimal)entityManager.createNativeQuery(IS_VALUE_FROM_NSI_USED)
                .setParameter("TABLE_NAME", new TypedParameterValue(StandardBasicTypes.STRING, tableName))
                .setParameter("VALUE", new TypedParameterValue(StandardBasicTypes.LONG, value))
                .setParameter("PRODUCT_HIER_ID", new TypedParameterValue(StandardBasicTypes.LONG, productHierId))
                .getSingleResult()).longValue();
    }

    public Long getFirstLineCriterion(Long productHierarchyId){
        return ((BigDecimal)entityManager.createNativeQuery(FIND_FIRST_LINE_CRITERION)
                .setParameter("param1", new TypedParameterValue(StandardBasicTypes.LONG, productHierarchyId))
                .getSingleResult()).longValue();
    }
}
