package by.compit.yauheni.zhukovich.nsi_product.repository;

import java.util.List;

public interface GenericRepository<T> {

    T getById(Long id);

    @SuppressWarnings("unchecked")
    List<T> getAll();

    List<T> getByProductName(String productName);

    List<T> getByValidityTerm(Long validityTerm);

}
