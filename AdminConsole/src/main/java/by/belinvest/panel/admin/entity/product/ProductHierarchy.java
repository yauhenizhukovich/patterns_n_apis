package by.belinvest.panel.admin.entity.product;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_HIERARCHY")
public class ProductHierarchy {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_PRODUCT_HIERARCHY",
            sequenceName = "SQ_PRODUCT_HIERARCHY", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_PRODUCT_HIERARCHY")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVITY")
    private Integer activity;

    @Column(name = "LEVEL_QUANT")
    private Integer levelQuant;

    @Column(name = "DATE_BEGIN")
    private LocalDate dateBegin;

    @Column(name = "DATE_END")
    private LocalDate dateEnd;

    @Column(name = "CREATED_BY")
    private Integer userId;

    @Column(name = "LINE_ID")
    private Long lineId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_GROUP")
    private ProductGroup productGroup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productHierarchy", fetch = FetchType.EAGER)
    private List<ProductHierarchyStruct> productHierarchyStructs;

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
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

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public Integer getLevelQuant() {
        return levelQuant;
    }

    public void setLevelQuant(Integer levelQuant) {
        this.levelQuant = levelQuant;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public List<ProductHierarchyStruct> getProductHierarchyStructs() {
        return productHierarchyStructs;
    }

    public void setProductHierarchyStructs(List<ProductHierarchyStruct> productHierarchyStructs) {
        this.productHierarchyStructs = productHierarchyStructs;
    }

    @Override
    public String toString() {
        return "ProductHierarchy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activity=" + activity +
                ", levelQuant=" + levelQuant +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", userId=" + userId +
                ", lineId=" + lineId +
                ", productGroup=" + productGroup.getId();
    }

}
