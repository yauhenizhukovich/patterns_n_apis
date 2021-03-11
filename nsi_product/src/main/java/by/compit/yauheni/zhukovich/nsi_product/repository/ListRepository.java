package by.compit.yauheni.zhukovich.nsi_product.repository;

import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.ListBI;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NullEntityException;

public interface ListRepository extends GenericRepository<ListBI>{

    Long getProductHierarchyByBPCardId(String id) throws NullEntityException;

    ListBI getByBankingProductCardId(String id) throws NullEntityException;

}
