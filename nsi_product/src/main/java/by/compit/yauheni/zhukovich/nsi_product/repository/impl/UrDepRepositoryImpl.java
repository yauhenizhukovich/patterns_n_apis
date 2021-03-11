package by.compit.yauheni.zhukovich.nsi_product.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.nsi_product.repository.UrDepRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi.UrDep;

@Repository
public class UrDepRepositoryImpl extends GenericRepositoryImpl<UrDep> implements UrDepRepository {

    @Autowired
    @Qualifier("nsiEntityManager")
    protected EntityManager nsiEntityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<UrDep> getAll() {
        String queryString = "FROM " + entityClass.getName() + " e";
        Query query = nsiEntityManager.createQuery(queryString);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public UrDep getById(Long id) {
        return nsiEntityManager.find(entityClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UrDep> getByProductClass(String productClass) {
        String queryString = "SELECT e.id, e.productName, e.productClasss, e.productType FROM "
                + entityClass.getSimpleName() + " e WHERE e.productClass=:productClass";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("productClass", productClass);
        List resultList = query.getResultList();
        return (List<UrDep>) resultList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UrDep> getByProductType(String productType) {
        String queryString = "SELECT e.id, e.productName, e.productClasss, e.productType FROM "
                + entityClass.getSimpleName() + " e WHERE e.productType=:productType";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("productType", productType);
        List resultList = query.getResultList();
        return (List<UrDep>) resultList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UrDep> getByProductName(String productName) {
        String queryString = "FROM " + entityClass.getName() + " e WHERE e.name=:productName";
        Query query = nsiEntityManager.createQuery(queryString);
        query.setParameter("productName", productName);
        return query.getResultList();
    }

}
