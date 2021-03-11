package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import by.belinvest.panel.admin.entity.product.ProductHierarchyStruct;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@Repository
public class ProductFilterRepository {

    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    private final static String FIND_PRODUCT_LINE_CRITERION_BY_HIERARCHY_ID = "SELECT * " +
            " FROM PRODUCT_HIER_STRUCT" +
            " WHERE PRODUCT_HIER_ID = :param1 AND LEV = 1 AND CRIT IS NOT NULL";

    private final static String FIND_TABLE_NAME_OF_CRITERION = "SELECT TABLE_NAME " +
            " FROM PRODUCT_HIER_CRIT" +
            " WHERE ID = :param1";

    private final static String FIND_VALUE_BY_STRUCT_ID = "SELECT VALUE " +
            " FROM PRODUCT_HIER_VALUE" +
            " WHERE IDSTRUCT = :param1";

    private final static String FIND_BP_ID_BY_NSI_NAME_AND_NSI_ID = "SELECT BPID " +
            " FROM BP_PRODUCT_LINE" +
            " WHERE NSI_NAME = :param1 AND NSI_ID = :param2";

    private final static String FIND_PRODUCT_STATUS_BY_BP_ID = "SELECT PRODUCTSTATUS " +
            " FROM BPCARD" +
            " WHERE BPID = :param1";


    @SuppressWarnings("unchecked")
    public ProductHierarchyStruct findProductLineCriterionByHierarchyId(Long hierarchyId){
        return (ProductHierarchyStruct) entityManager.createNativeQuery(FIND_PRODUCT_LINE_CRITERION_BY_HIERARCHY_ID,ProductHierarchyStruct.class)
                .setParameter("param1", new TypedParameterValue(StandardBasicTypes.LONG, hierarchyId))
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public String findTableNameOfCriterion(Long criterionId){
        return (String) entityManager.createNativeQuery(FIND_TABLE_NAME_OF_CRITERION)
                .setParameter("param1", new TypedParameterValue(StandardBasicTypes.LONG, criterionId))
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public String findValueByStructId(Long structId){
        return (String) entityManager.createNativeQuery(FIND_VALUE_BY_STRUCT_ID)
                .setParameter("param1", new TypedParameterValue(StandardBasicTypes.LONG, structId))
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public Long findBPIdByNsiNameAndNsiId(String nsiName,Long nsiId){
        return ((BigDecimal) entityManager.createNativeQuery(FIND_BP_ID_BY_NSI_NAME_AND_NSI_ID)
                .setParameter("param1", new TypedParameterValue(StandardBasicTypes.STRING, nsiName))
                .setParameter("param2", new TypedParameterValue(StandardBasicTypes.LONG, nsiId))
                .getSingleResult()).longValue();
    }

    @SuppressWarnings("unchecked")
    public String findProductStatusByBPId(Long bpId){
        return (String) entityManager.createNativeQuery(FIND_PRODUCT_STATUS_BY_BP_ID)
                .setParameter("param1", new TypedParameterValue(StandardBasicTypes.LONG, bpId))
                .getSingleResult();
    }



}
