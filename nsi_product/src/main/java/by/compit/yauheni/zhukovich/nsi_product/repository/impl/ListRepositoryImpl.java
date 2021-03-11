package by.compit.yauheni.zhukovich.nsi_product.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.nsi_product.repository.ListRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.ListBI;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NullEntityException;

@Repository
public class ListRepositoryImpl extends GenericRepositoryImpl<ListBI> implements ListRepository {

    @Override
    public Long getProductHierarchyByBPCardId(String id) throws NullEntityException {
        String queryString = "SELECT e.productHierId FROM "
                + entityClass.getSimpleName() + " e WHERE e.bpcId=:id";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("id", Long.valueOf(id));
        try {
            Object result = query.getSingleResult();
            return (Long) result;
        } catch (NoResultException e) {
            throw new NullEntityException("Карточка банковского продукта отсутствует либо иерархия продуктов не заполнена.");
        }
    }

    @Override
    public ListBI getByBankingProductCardId(String id) throws NullEntityException {
        String queryString = "FROM "
                + entityClass.getSimpleName() + " e WHERE e.bpcId=:id";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("id", Long.valueOf(id));
        try {
            Object result = query.getSingleResult();
            return (ListBI) result;
        } catch (NoResultException e) {
            throw new NullEntityException("Карточка банковского продукта отсутствует либо иерархия продуктов не заполнена.");
        }
    }

}
