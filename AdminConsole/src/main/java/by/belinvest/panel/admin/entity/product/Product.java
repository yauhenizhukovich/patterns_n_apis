package by.belinvest.panel.admin.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class  Product {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_PRODUCT",
            sequenceName = "SQ_PRODUCT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_PRODUCT")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_GROUP")
    private ProductGroup productGroup;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_HIERARCHY_ID")
    private ProductHierarchy productHierarchy;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductHierValue> productHierValues;

    @Column(name = "BN_ID")
    private Long bnId;

    @Column(name = "DB_ID")
    private Long dbId;

    @Column(name = "F_SYNCHRONIZ")
    private Byte fSynchroniz;


    public Byte getfSynchroniz() {
        return fSynchroniz;
    }

    public void setfSynchroniz(Byte fSynchroniz) {
        this.fSynchroniz = fSynchroniz;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public ProductHierarchy getProductHierarchy() {
        return productHierarchy;
    }

    public void setProductHierarchy(ProductHierarchy productHierarchy) {
        this.productHierarchy = productHierarchy;
    }

    public List<ProductHierValue> getProductHierValues() {
        return productHierValues;
    }

    public void setProductHierValues(List<ProductHierValue> productHierValues) {
        this.productHierValues = productHierValues;
    }

    public Long getBnId() {
        return bnId;
    }

    public void setBnId(Long bnId) {
        this.bnId = bnId;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productGroup=" + productGroup +
                ", productHierarchy=" + productHierarchy +
                ", productHierValues=" + productHierValues +
                ", bnId=" + bnId +
                ", dbId=" + dbId +
                ", fSynchroniz=" + fSynchroniz +
                '}';
    }
}
