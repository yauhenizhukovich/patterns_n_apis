package by.compit.yauheni.zhukovich.nsi_product.service;

import java.util.List;

import by.compit.yauheni.zhukovich.nsi_product.service.exception.NonexistentProductException;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NullEntityException;
import by.compit.yauheni.zhukovich.nsi_product.service.model.ProductAggregation;

public interface ProductService {

    Object getById(Long id) throws NonexistentProductException;

    ProductAggregation getByContraAgentType(String contrAgentType);

    ProductAggregation getByProductClass(String productClass);

    ProductAggregation getByProductType(String productType);

    ProductAggregation getByProductName(String productName);

    List<Long> getIdsByBPCardId(String id) throws NullEntityException;

    ProductAggregation getAll();

}
