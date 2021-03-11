package by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BPCARD")
public class BankingProductCard {

    @Id
    @Column(name = "BPID")
    private Long id;
    @Column(name = "PRODUCTSTATUS")
    private String productStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

}
