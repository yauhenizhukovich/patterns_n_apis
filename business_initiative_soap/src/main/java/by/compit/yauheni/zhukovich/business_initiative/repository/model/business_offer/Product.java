package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BO_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_PRODUCT_IDPRODUCT", allocationSize = 1, name = "SEQ")
    @Column(name = "IDPRODUCT")
    private Long id;
    @Column(name = "PRODUCTDESC")
    private String productDesc;
    @Column(name = "TECHPROCESSDESC")
    private String techProcessDesc;
    @Column(name = "PROCESSMODEL")
    private String processModel;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getTechProcessDesc() {
        return techProcessDesc;
    }

    public void setTechProcessDesc(String techProcessDesk) {
        this.techProcessDesc = techProcessDesk;
    }

    public String getProcessModel() {
        return processModel;
    }

    public void setProcessModel(String processModel) {
        this.processModel = processModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusinessOffer(BusinessOffer businessOffer) {
        this.businessOffer = businessOffer;
    }

    public BusinessOffer getBusinessOffer() {
        return businessOffer;
    }

}
