package by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIST_BI")
public class ListBI {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "BPCARD_ID")
    private Long bpcId;
    @Column(name = "PRODUCT_HIER_ID")
    private Long productHierId;
    @Column(name = "BPCARD_PRODUCTSTATUS")
    private String productStatus;

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBpcId() {
        return bpcId;
    }

    public void setBpcId(Long bpcId) {
        this.bpcId = bpcId;
    }

    public Long getProductHierId() {
        return productHierId;
    }

    public void setProductHierId(Long productHierId) {
        this.productHierId = productHierId;
    }

}
