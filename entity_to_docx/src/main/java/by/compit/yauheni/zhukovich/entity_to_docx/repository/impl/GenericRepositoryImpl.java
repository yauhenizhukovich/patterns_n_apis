package by.compit.yauheni.zhukovich.entity_to_docx.repository.impl;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.GenericRepository;

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
}
