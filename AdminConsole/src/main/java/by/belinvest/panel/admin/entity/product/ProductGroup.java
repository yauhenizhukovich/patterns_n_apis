package by.belinvest.panel.admin.entity.product;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_GROUP")
public class ProductGroup {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_PRODUCT_GROUP",
            sequenceName = "SQ_PRODUCT_GROUP", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_PRODUCT_GROUP")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HI_ID")
    private Long hiId;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "PRODUCT_CURR")
    private String productCurr;

    @Column(name = "NSI_TABLE")
    private String nsiTable;

    @OneToMany(mappedBy = "productGroup", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ProductHierarchy> productHierarchies = new ArrayList<>();

    public String getNsiTable() {
        return nsiTable;
    }

    public void setNsiTable(String nsiTable) {
        this.nsiTable = nsiTable;
    }

    public String getProductCurr() {
        return productCurr;
    }

    public void setProductCurr(String productCurr) {
        this.productCurr = productCurr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHiId() {
        return hiId;
    }

    public void setHiId(Long hiId) {
        this.hiId = hiId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public List<ProductHierarchy> getProductHierarchies() {
        return productHierarchies;
    }

    public void setProductHierarchies(List<ProductHierarchy> productHierarchies) {
        this.productHierarchies = productHierarchies;
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hiId=" + hiId +
                ", tableName='" + tableName + '\'' +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productCurr='" + productCurr + '\'' +
                ", nsiTable='" + nsiTable + '\'';
    }

}
