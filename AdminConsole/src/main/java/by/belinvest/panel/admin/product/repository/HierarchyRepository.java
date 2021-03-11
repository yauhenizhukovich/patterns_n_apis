package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Component
public class HierarchyRepository {

    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    private static final String QUERY_GET_HIERARCHY_ID = "select ID from PRODUCT_HIERARCHY where PRODUCT_GROUP = :param1";

    private static final String QUERY_GET_HIERARCHY_LIST_BY_PRODUCTS_GROUP = "select * from PRODUCT_HIERARCHY where PRODUCT_GROUP in (" +
            "    with t1 as (select id,hi_id from product_group" +
            "                WHERE level <= 3" +
            "                  and ((level = 1 and (:a1 is NULL or id = :a1))" +
            "                    or (level = 2 and (:a2 is NULL or id = :a2))" +
            "                    or (level = 3 and (:a3 is NULL or id = :a3)))" +
            "                CONNECT BY PRIOR id = hi_id START WITH hi_id IS NULL)" +
            "    SELECT id" +
            "    FROM t1 t2" +
            "    WHERE exists (select null from t1 where t1.id = t2.hi_id)" +
            "    CONNECT BY PRIOR id = hi_id START WITH hi_id IS NULL) ";

    @SuppressWarnings("unchecked")
    public List<ProductHierarchy> getProductHierarchyByProductGroups(Long pg1, Long pg2, Long pg3){
        return entityManager.createNativeQuery(QUERY_GET_HIERARCHY_LIST_BY_PRODUCTS_GROUP, ProductHierarchy.class)
                .setParameter("a1", new TypedParameterValue(StandardBasicTypes.LONG, pg1))
                .setParameter("a2", new TypedParameterValue(StandardBasicTypes.LONG, pg2))
                .setParameter("a3", new TypedParameterValue(StandardBasicTypes.LONG, pg3))
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public Long getProductHierarchyId(Long productGroupId){
        return ((BigDecimal)entityManager.createNativeQuery(QUERY_GET_HIERARCHY_ID)
                .setParameter("param1", new TypedParameterValue(StandardBasicTypes.LONG, productGroupId))
                .getResultList().get(0)).longValue();
    }
}
