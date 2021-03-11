package by.belinvest.panel.admin.product.repository;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ListBIRepository {

    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;

    public void save(Long id, Long lineId, String nsiTable) {
        if (nsiTable.contains(".")) {
            nsiTable = nsiTable.split("\\.")[1];
        }
        Long bpId = ((BigDecimal) entityManager.createNativeQuery(
                "SELECT BPID FROM BP_PRODUCT_LINE WHERE NSI_NAME=:nsiTable AND NSI_ID=:nsiId"
        )
                .setParameter("nsiId", new TypedParameterValue(StandardBasicTypes.LONG, lineId))
                .setParameter("nsiTable", new TypedParameterValue(StandardBasicTypes.STRING, nsiTable))
                .getSingleResult()).longValue();
        entityManager.createNativeQuery("UPDATE LIST_BI SET PRODUCT_HIER_ID=:id WHERE BPCARD_ID=:bpId")
                .setParameter("id", new TypedParameterValue(StandardBasicTypes.LONG, id))
                .setParameter("bpId", new TypedParameterValue(StandardBasicTypes.LONG, bpId));
    }

}
