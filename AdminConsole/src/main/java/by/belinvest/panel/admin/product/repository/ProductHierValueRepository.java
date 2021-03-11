package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.product.ProductHierValue;
import by.belinvest.panel.admin.entity.product.ProductHierarchyStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHierValueRepository extends JpaRepository<ProductHierValue,Long> {
    List<ProductHierValue> findAllByProductId(Long productId);
    List<ProductHierValue> findAllByProductHierarchyStructId(Long productHierarchyStructId);
    void deleteByProductHierarchyStruct(ProductHierarchyStruct productHierarchyStruct);
}
