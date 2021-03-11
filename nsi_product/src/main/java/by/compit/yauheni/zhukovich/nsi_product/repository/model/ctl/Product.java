package by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;
    @Column(name = "PRODUCT_HIERARCHY_ID")
    private Long productHierId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_GROUP")
    private ProductGroup productGroup;

    public Long getProductHierId() {
        return productHierId;
    }

    public void setProductHierId(Long productHierId) {
        this.productHierId = productHierId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

}
