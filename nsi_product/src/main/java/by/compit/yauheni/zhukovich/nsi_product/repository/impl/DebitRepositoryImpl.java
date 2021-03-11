package by.compit.yauheni.zhukovich.nsi_product.repository.impl;

import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.nsi_product.repository.DebitRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Debit;

@Repository
public class DebitRepositoryImpl extends GenericRepositoryImpl<Debit> implements DebitRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<Debit> getByProductClass(String productClass) {
        String queryString = "SELECT e.id, e.productName, e.productClasss, e.productType FROM "
                + entityClass.getSimpleName() + " e WHERE e.productClass=:productClass";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("productClass", productClass);
        List resultList = query.getResultList();
        return (List<Debit>) resultList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Debit> getByProductType(String productType) {
        String queryString = "SELECT e.id, e.productName, e.productClasss, e.productType FROM "
                + entityClass.getSimpleName() + " e WHERE e.productType=:productType";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("productType", productType);
        List resultList = query.getResultList();
        return (List<Debit>) resultList;
    }

}
