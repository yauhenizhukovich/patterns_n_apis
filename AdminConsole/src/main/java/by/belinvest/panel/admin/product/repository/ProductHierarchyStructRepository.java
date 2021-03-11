package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import by.belinvest.panel.admin.entity.product.ProductHierarchyStruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductHierarchyStructRepository extends JpaRepository<ProductHierarchyStruct,Long> {
    void deleteAllByProductHierarchy(ProductHierarchy productHierarchy);
    void deleteAllByProductHierarchyAndCrit(ProductHierarchy productHierarchy, Long crit);
    List<ProductHierarchyStruct> findAllByProductHierarchy(ProductHierarchy productHierarchy);
    Optional<ProductHierarchyStruct> findById(Long id);
}
