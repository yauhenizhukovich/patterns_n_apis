package by.compit.yauheni.zhukovich.nsi_product.repository;

import java.util.List;

import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Debit;

public interface DebitRepository extends GenericRepository<Debit> {

    List<Debit> getByProductClass(String productClass);

    List<Debit> getByProductType(String productType);

}
