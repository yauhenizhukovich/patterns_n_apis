package by.belinvest.panel.admin.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_HIER_VALUE")
public class ProductHierValue {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_PRODUCT_HIER_VALUE",
            sequenceName = "SQ_PRODUCT_HIER_VALUE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_PRODUCT_HIER_VALUE")
    private Long id;

    @OneToOne
    @JoinColumn(name = "IDSTRUCT")
    private ProductHierarchyStruct productHierarchyStruct;

    @ManyToOne
    @JoinColumn(name = "IDPRODUCT")
    private Product product;

    @Column(name = "VALUE")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductHierarchyStruct getProductHierarchyStruct() {
        return productHierarchyStruct;
    }

    public void setProductHierarchyStruct(ProductHierarchyStruct productHierarchyStruct) {
        this.productHierarchyStruct = productHierarchyStruct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
