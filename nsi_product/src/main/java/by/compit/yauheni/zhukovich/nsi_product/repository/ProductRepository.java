package by.compit.yauheni.zhukovich.nsi_product.repository;

import java.util.List;

import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Product;

public interface ProductRepository extends GenericRepository<Product> {

    List<Long> getByHierarchy(Long productHierarchyId);

}
