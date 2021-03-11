package by.compit.yauheni.zhukovich.nsi_product.service;

import by.compit.yauheni.zhukovich.nsi_product.service.exception.NullEntityException;

public interface BankingProductCardService {

    void updateStatusById(String id, String status) throws NullEntityException;

}
