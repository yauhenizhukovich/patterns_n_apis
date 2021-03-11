package by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BPCARD")
public class BankingProductCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BPC_BPCARD_BPID", allocationSize = 1, name = "SEQ")
    @Column(name = "BPID")
    private Long id;
    @Column(name = "PRODUCTNAME")
    private String productName;
    @Column(name = "COMMONPRODUCTCHARS")
    private String commonProduct;
    @Column(name = "PRODUCTSTATUS")
    private String productStatus;
    @Column(name = "CHANGESTATUSDATE")
    private LocalDate changeStatusDate;
    @Column(name = "PRODUCTADVANTAGES")
    private String productAdvantage;
    @Column(name = "MAINPRODUCTPARAMS")
    private String mainProductParam;
    @Column(name = "DOCSFORMS")
    private String docsForm;
    @Column(name = "LPABANKS")
    private String lpaBank;
    @Column(name = "ADDMATERIALS")
    private String addMaterial;
    @OneToMany(mappedBy = "bankingProductCard", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dept> depts = new ArrayList<>();
    @OneToMany(mappedBy = "bankingProductCard", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultDept> consultDepts = new ArrayList<>();
    @OneToMany(mappedBy = "bankingProductCard", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCardDistribution> productCardDistributions = new ArrayList<>();

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setCommonProduct(String commonProduct) {
        this.commonProduct = commonProduct;
    }

    public String getCommonProduct() {
        return commonProduct;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setChangeStatusDate(LocalDate changeStatusDate) {
        this.changeStatusDate = changeStatusDate;
    }

    public LocalDate getChangeStatusDate() {
        return changeStatusDate;
    }

    public void setProductAdvantage(String productAdvantage) {
        this.productAdvantage = productAdvantage;
    }

    public String getProductAdvantage() {
        return productAdvantage;
    }

    public void setMainProductParam(String mainProductParam) {
        this.mainProductParam = mainProductParam;
    }

    public String getMainProductParam() {
        return mainProductParam;
    }

    public void setDocsForm(String docsForm) {
        this.docsForm = docsForm;
    }

    public String getDocsForm() {
        return docsForm;
    }

    public void setLpaBank(String lpaBank) {
        this.lpaBank = lpaBank;
    }

    public String getLpaBank() {
        return lpaBank;
    }

    public void setAddMaterial(String addMaterial) {
        this.addMaterial = addMaterial;
    }

    public String getAddMaterial() {
        return addMaterial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    public List<Dept> getDepts() {
        return depts;
    }

    public void setConsultDepts(List<ConsultDept> consultDepts) {
        this.consultDepts = consultDepts;
    }

    public List<ConsultDept> getConsultDepts() {
        return consultDepts;
    }

    public void setProductCardDistributions(List<ProductCardDistribution> productCardDistributions) {
        this.productCardDistributions = productCardDistributions;
    }

    public List<ProductCardDistribution> getProductCardDistributions() {
        return productCardDistributions;
    }

}
