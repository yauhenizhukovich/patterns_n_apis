package by.compit.yauheni.zhukovich.nsi_product.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import by.compit.yauheni.zhukovich.nsi_product.repository.GenericRepository;

public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> {

    protected final Class<T> entityClass;
    @Autowired
    @Qualifier("ctlEntityManager")
    protected EntityManager ctlEntityManager;

    @SuppressWarnings("unchecked")
    public GenericRepositoryImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T getById(Long id) {
        return ctlEntityManager.find(entityClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        String queryString = "FROM " + entityClass.getName() + " e";
        Query query = ctlEntityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getByProductName(String productName) {
        String queryString = "FROM " + entityClass.getName() + " e WHERE e.productName=:productName";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("productName", productName);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getByValidityTerm(Long validityTerm) {
        String queryString = "FROM " + entityClass.getName() + " e WHERE e.validityTerm=:validityTerm";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("validityTerm", validityTerm);
        return query.getResultList();
    }

}
