package by.compit.yauheni.zhukovich.business_initiative.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import by.compit.yauheni.zhukovich.business_initiative.repository.GenericRepository;

public abstract class GenericRepositoryImpl<I, T> implements GenericRepository<I, T> {

    protected Class<T> entityClass;
    @PersistenceContext
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericRepositoryImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public T getById(I id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public T persist(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        String queryString = "FROM " + entityClass.getName() + " e";
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

}
