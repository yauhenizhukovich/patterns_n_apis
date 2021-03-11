package by.compit.yauheni.zhukovich.nsi_product.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.nsi_product.repository.UrCredRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi.UrCred;

@Repository
public class UrCredRepositoryImpl extends GenericRepositoryImpl<UrCred> implements UrCredRepository {

    @Autowired
    @Qualifier("nsiEntityManager")
    protected EntityManager nsiEntityManager;

    @Override
    public List<UrCred> getAll() {
        String queryString = "FROM " + entityClass.getName() + " e";
        Query query = nsiEntityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public UrCred getById(Long id) {
        return nsiEntityManager.find(entityClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UrCred> getByProductName(String productName) {
        String queryString = "FROM " + entityClass.getName() + " e WHERE e.name=:productName";
        Query query = nsiEntityManager.createQuery(queryString);
        query.setParameter("productName", productName);
        return query.getResultList();
    }

}

