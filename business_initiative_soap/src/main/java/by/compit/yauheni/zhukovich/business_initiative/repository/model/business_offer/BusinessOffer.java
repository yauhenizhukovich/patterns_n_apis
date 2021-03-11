package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUSINESSOFFER")
public class BusinessOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BUSINESSOFFER_IDBO", allocationSize = 1, name = "SEQ")
    @Column(name = "IDBO")
    private Long id;
    @Column(name = "BONAME")
    private String name;
    @Column(name = "BOSTATUS")
    private String status;
    @Column(name = "PRODUCTMANAGER")
    private String productManager;
    @Column(name = "PRODUCTMANAGERPOSITION")
    private String productManagerPosition;
    @Column(name = "PRODUCTMANAGERSUPERVISORPHONE")
    private String productManagerSupervisorPhone;
    @Column(name = "PRODUCTMANAGERSUPERVISORPOS")
    private String productManagerSupervisorPos;
    @Column(name = "PRODUCTMANAGERSUPERVISOR")
    private String productManagerSupervisor;
    @Column(name = "PRODUCTMANAGERDEPT")
    private String productManagerDept;
    @Column(name = "PRODUCTMANAGERPHONE")
    private String productManagerPhone;
    @OneToMany(mappedBy = "businessOffer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BOBusinessGoal> businessGoals = new ArrayList<>();
    @OneToMany(mappedBy = "businessOffer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelevanceRisk> relevanceRisks = new ArrayList<>();
    @OneToMany(mappedBy = "businessOffer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BOWork> works = new ArrayList<>();
    @OneToMany(mappedBy = "businessOffer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DevelopmentBusinessOffer> onDevelopments = new ArrayList<>();
    @OneToMany(mappedBy = "businessOffer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarketAnalysis> marketAnalysises = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "businessOffer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Product product;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "businessOffer", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProfitabilityCalculation profitabilityCalculation;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "businessOffer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Term term;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "businessOffer", cascade = CascadeType.ALL, orphanRemoval = true)
    private CommitteeMaterial committeeMaterial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setProductManager(String productManager) {
        this.productManager = productManager;
    }

    public String getProductManager() {
        return productManager;
    }

    public void setProductManagerPosition(String productManagerPosition) {
        this.productManagerPosition = productManagerPosition;
    }

    public String getProductManagerPosition() {
        return productManagerPosition;
    }

    public void setProductManagerSupervisorPhone(String productManagerSupervisorPhone) {
        this.productManagerSupervisorPhone = productManagerSupervisorPhone;
    }

    public String getProductManagerSupervisorPhone() {
        return productManagerSupervisorPhone;
    }

    public void setProductManagerSupervisorPos(String productManagerSupervisorPos) {
        this.productManagerSupervisorPos = productManagerSupervisorPos;
    }

    public String getProductManagerSupervisorPos() {
        return productManagerSupervisorPos;
    }

    public void setProductManagerSupervisor(String productManagerSupervisor) {
        this.productManagerSupervisor = productManagerSupervisor;
    }

    public String getProductManagerSupervisor() {
        return productManagerSupervisor;
    }

    public void setProductManagerDept(String productManagerDept) {
        this.productManagerDept = productManagerDept;
    }

    public String getProductManagerDept() {
        return productManagerDept;
    }

    public void setProductManagerPhone(String productManagerPhone) {
        this.productManagerPhone = productManagerPhone;
    }

    public String getProductManagerPhone() {
        return productManagerPhone;
    }

    public List<BOBusinessGoal> getBusinessGoals() {
        return businessGoals;
    }

    public void setBusinessGoals(List<BOBusinessGoal> businessGoals) {
        this.businessGoals = businessGoals;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProfitabilityCalculation getProfitabilityCalculation() {
        return profitabilityCalculation;
    }

    public void setProfitabilityCalculation(ProfitabilityCalculation profitabilityCalculation) {
        this.profitabilityCalculation = profitabilityCalculation;
    }

    public List<MarketAnalysis> getMarketAnalysises() {
        return marketAnalysises;
    }

    public void setMarketAnalysises(List<MarketAnalysis> marketAnalysises) {
        this.marketAnalysises = marketAnalysises;
    }

    public List<RelevanceRisk> getRelevanceRisks() {
        return relevanceRisks;
    }

    public void setRelevanceRisks(List<RelevanceRisk> relevanceRisks) {
        this.relevanceRisks = relevanceRisks;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public List<BOWork> getWorks() {
        return works;
    }

    public void setWorks(List<BOWork> works) {
        this.works = works;
    }

    public CommitteeMaterial getCommitteeMaterial() {
        return committeeMaterial;
    }

    public void setCommitteeMaterial(CommitteeMaterial committeeMaterial) {
        this.committeeMaterial = committeeMaterial;
    }

    public List<DevelopmentBusinessOffer> getOnDevelopments() {
        return onDevelopments;
    }

    public void setOnDevelopments(List<DevelopmentBusinessOffer> onDevelopments) {
        this.onDevelopments = onDevelopments;
    }

}
