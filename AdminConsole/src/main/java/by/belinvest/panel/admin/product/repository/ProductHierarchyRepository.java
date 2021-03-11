package by.belinvest.panel.admin.product.repository;


import by.belinvest.panel.admin.entity.product.ProductGroup;
import by.belinvest.panel.admin.entity.product.ProductHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductHierarchyRepository extends JpaRepository<ProductHierarchy,Long> {
    List<ProductHierarchy> findAllByProductGroup_Id(Long productGroupId);
    List<ProductHierarchy> findProductHierarchiesByName(String name);
    Optional<ProductHierarchy> findById(Long hierarchyId);

    List<ProductHierarchy> findAllByProductGroup(ProductGroup productGroup);

    @Query("select id,name from ProductHierarchy")
    List<ProductHierarchy> findAllNamesAndId();

    List<ProductHierarchy> findAll();

    Optional<ProductHierarchy> getByProductGroup(ProductGroup productGroup);

    List<ProductHierarchy> findAllByProductGroupIdAndActivity(Long productGroupId,Integer activity);

    List<ProductHierarchy> findAllByProductGroupIdAndLineId(Long productGroupId,Long lineId);
}
