package by.belinvest.panel.admin.product.repository;

import by.belinvest.panel.admin.entity.product.ProductHierCrit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("productHierCritRepository")
public interface ProductHierCritRepository extends JpaRepository<ProductHierCrit,Long> {
    List<ProductHierCrit> findAllByProductGroupId(Long productGroupId);
    ProductHierCrit findByProductGroupIdAndName(Long productGroupId, String name);
    Optional<ProductHierCrit> findById(Long id);
}
