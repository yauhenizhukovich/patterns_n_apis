package by.compit.yauheni.zhukovich.nsi_product.repository;

import java.util.List;

import by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi.UrDep;

public interface UrDepRepository extends GenericRepository<UrDep> {

    List<UrDep> getByProductClass(String productClass);

    List<UrDep> getByProductType(String productType);

}
