package by.compit.yauheni.zhukovich.business_initiative.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.business_initiative.repository.ListRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.impl.GenericRepositoryImpl;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.ListBI;

@Repository
public class ListRepositoryImpl extends GenericRepositoryImpl<Long, ListBI> implements ListRepository {

    @Override
    public ListBI getByBusinessInitiativeId(Long biId) {
        String queryString =
                "FROM " + entityClass.getSimpleName() + " e WHERE e.biId=:biId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("biId", biId);
        try {
            Object result = query.getSingleResult();
            return (ListBI) result;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public ListBI getByBusinessOfferId(Long boId) {
        String queryString =
                "FROM " + entityClass.getSimpleName() + " e WHERE e.boId=:boId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("boId", boId);
        try {
            Object result = query.getSingleResult();
            return (ListBI) result;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public ListBI getByBankingProductCard(Long bpcId) {
        String queryString =
                "FROM " + entityClass.getSimpleName() + " e WHERE e.bpcId=:bpcId";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("bpcId", bpcId);
        try {
            Object result = query.getSingleResult();
            return (ListBI) result;
        } catch (NoResultException e) {
            return null;
        }
    }

}
