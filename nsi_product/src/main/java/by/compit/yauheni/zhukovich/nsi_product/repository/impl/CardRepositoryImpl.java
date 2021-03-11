package by.compit.yauheni.zhukovich.nsi_product.repository.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.nsi_product.repository.CardRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Card;

@Repository
public class CardRepositoryImpl extends GenericRepositoryImpl<Card> implements CardRepository {

    @Override
    public List<Card> getByProductName(String productName) {
        String queryString = "FROM " + entityClass.getName() + " e WHERE e.name=:productName";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("productName", productName);
        return query.getResultList();
    }

}
