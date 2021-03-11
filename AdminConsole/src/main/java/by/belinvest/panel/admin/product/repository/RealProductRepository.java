package by.belinvest.panel.admin.product.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RealProductRepository {

    @PersistenceContext
    @Qualifier("productHierarchyEntityManagerFactory")
    private EntityManager entityManager;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RealProductRepository(@Qualifier("nsiDatasource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int updateDebitSetSysId(Long id, Long sysId) {
        Query query = entityManager.createNativeQuery(
                "UPDATE DEBIT SET SYS_ID=:sysId WHERE ID=:id"
        )
                .setParameter("sysId", new TypedParameterValue(StandardBasicTypes.LONG, sysId))
                .setParameter("id", new TypedParameterValue(StandardBasicTypes.LONG, id));
        return query.executeUpdate();
    }

    public int updateCreditSetSysId(Long id, Long sysId) {
        Query query = entityManager.createNativeQuery(
                "UPDATE CREDIT SET SYS_ID=:sysId WHERE ID=:id"
        )
                .setParameter("sysId", new TypedParameterValue(StandardBasicTypes.LONG, sysId))
                .setParameter("id", new TypedParameterValue(StandardBasicTypes.LONG, id));
        return query.executeUpdate();
    }

    public int updateCardSetSysId(Long id, Long sysId) {
        Query query = entityManager.createNativeQuery(
                "UPDATE CARD SET SYS_ID=:sysId WHERE ID=:id"
        )
                .setParameter("sysId", new TypedParameterValue(StandardBasicTypes.LONG, sysId))
                .setParameter("id", new TypedParameterValue(StandardBasicTypes.LONG, id));
        return query.executeUpdate();
    }

    public boolean updateUrDepSetDimId(Long id, Long brisId) {
        jdbcTemplate.execute(
                "INSERT INTO DIMID_BUNDLE VALUES (" + brisId + "," + "'URDEP'" + "," + id + ")"
        );
        return true;
    }

    public boolean updateUrCredSetDimId(Long id, Long brisId) {
        jdbcTemplate.execute(
                "INSERT INTO DIMID_BUNDLE VALUES (" + brisId + "," + "'URCRED'" + "," + id + ")"
        );
        return true;
    }

    public Long getUrCredBarsIdByDimId(Long dimId) {
        return jdbcTemplate.queryForObject(
                "SELECT UUID FROM DIMID_BUNDLE WHERE DIMID=? AND TABLENAME='URCRED'",
                new Long[] {dimId},
                Long.class
        );
    }

    public Long getUrDepBarsIdByDimId(Long dimId) {
        return jdbcTemplate.queryForObject(
                "SELECT UUID FROM DIMID_BUNDLE WHERE DIMID=? AND TABLENAME='URDEP'",
                new Long[] {dimId},
                Long.class
        );
    }

}
