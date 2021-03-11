package by.belinvest.panel.admin.product.repository;


import by.belinvest.panel.admin.entity.product.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {
    Optional<ProductGroup> findById(Long id);
}
