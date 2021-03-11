package by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Product;

@Entity
@Table(name = "PRODUCT_GROUP")
public class ProductGroup {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "TABLE_NAME")
    private String tableName;
    @OneToMany(mappedBy = "productGroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
