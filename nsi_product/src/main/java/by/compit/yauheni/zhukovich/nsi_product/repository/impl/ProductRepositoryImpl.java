package by.compit.yauheni.zhukovich.nsi_product.repository.impl;

import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.nsi_product.repository.ProductRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Product;

@Repository
public class ProductRepositoryImpl extends GenericRepositoryImpl<Product> implements ProductRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<Long> getByHierarchy(Long productHierarchyId) {
        String queryString =
                "SELECT e.id FROM " + entityClass.getSimpleName() + " e WHERE e.productHierId=:productHierarchyId";
        Query query = ctlEntityManager.createQuery(queryString);
        query.setParameter("productHierarchyId", productHierarchyId);
        List resultList = query.getResultList();
        return (List<Long>) resultList;
    }

}
