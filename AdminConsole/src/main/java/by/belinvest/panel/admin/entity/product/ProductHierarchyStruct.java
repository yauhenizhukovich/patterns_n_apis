package by.belinvest.panel.admin.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_HIER_STRUCT")
public class ProductHierarchyStruct {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SQ_PRODUCT_HIER_VALUE",
            sequenceName = "SQ_PRODUCT_HIER_VALUE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SQ_PRODUCT_HIER_VALUE")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_HIER_ID")
    @JsonIgnore
    private ProductHierarchy productHierarchy;

    @Column(name = "LEV")
    private Integer level;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Column(name = "CRIT")
    private Long crit;

    @Override
    public String toString() {
        StringBuilder fieldNameForJSON = new StringBuilder();
        char letter;
        for (int i=0;i<fieldName.length();i++) {
            letter = fieldName.charAt(i);
            if(letter == '\"' || letter == '\''){
                fieldNameForJSON.append('\\');
            }
            fieldNameForJSON.append(letter);
        }

        return "{" +
                "\"id\":" + id +
                " ,\"productHierarchy\":" + productHierarchy.getId() +
                " ,\"level\":" + level +
                " ,\"tableName\":\"" + tableName + '\"' +
                " ,\"fieldName\":\"" + fieldNameForJSON + '\"' +
                " ,\"crit\":" + crit +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductHierarchy getProductHierarchy() {
        return productHierarchy;
    }

    public void setProductHierarchy(ProductHierarchy productHierarchy) {
        this.productHierarchy = productHierarchy;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Long getCrit() {
        return crit;
    }

    public void setCrit(Long crit) {
        this.crit = crit;
    }
}
