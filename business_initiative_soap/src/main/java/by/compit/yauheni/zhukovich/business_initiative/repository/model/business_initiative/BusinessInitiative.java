package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
@Table(name = "BUSINESSINITIATIVE")
public class BusinessInitiative {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BUSINESSINITIATIVE_IDBI", allocationSize = 1, name = "SEQ")
    @Column(name = "IDBI")
    private Long id;
    @Column(name = "PRODUCTDEVELOPERDEPT")
    private String productDeveloperDept;
    @Column(name = "PRODUCTDEVELOPERFIO")
    private String productDeveloperFIO;
    @Column(name = "BIDATE")
    private LocalDate date;
    @Column(name = "BISTATUS")
    private String status;
    @Column(name = "BINAME")
    private String name;
    @Column(name = "JOBTYPES")
    private String jobType;
    @Column(name = "BIPOINT")
    private String point;
    @Column(name = "PRODUCT")
    private String product;
    @Column(name = "REALIZEPROSPECTIVE")
    private String realizeProspective;
    @Column(name = "NONREALIZEEFFECTS")
    private String nonRealizeEffects;
    @Column(name = "IMPLPLANNINGDATE")
    private LocalDate implPlanningDate;
    @Column(name = "ADDINFO")
    private String addInfo;
    @Column(name = "MARKETANALISYS")
    private String marketAnalysis;
    @Column(name = "MARKETANALISYSFILE")
    private String marketAnalysisFile;
    @Column(name = "BUSINESSAPPIMPLDATE")
    private LocalDate businessAppImplDate;
    @Column(name = "PLANGRAPHICDATE")
    private LocalDate planGraphicDate;
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BusinessDirection> businessDirections = new ArrayList<>();
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BIBusinessGoal> businessGoals = new ArrayList<>();
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalesChannel> salesChannels = new ArrayList<>();
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InfoSystemInfluence> infoSystemInfluences = new ArrayList<>();
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImplementationRisk> implementationRisks = new ArrayList<>();
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectedExpenses> projectedExpensess = new ArrayList<>();
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BIProductTeam> productTeams = new ArrayList<>();
    @OneToMany(mappedBy = "businessInitiative", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DevelopmentBusinessInitiative> onDevelopments = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "businessInitiative", cascade = CascadeType.ALL, orphanRemoval = true)
    private PlanGraphic planGraphic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductDeveloperDept(String productDeveloperDept) {
        this.productDeveloperDept = productDeveloperDept;
    }

    public String getProductDeveloperDept() {
        return productDeveloperDept;
    }

    public void setProductDeveloperFIO(String productDeveloperFIO) {
        this.productDeveloperFIO = productDeveloperFIO;
    }

    public String getProductDeveloperFIO() {
        return productDeveloperFIO;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setJobType(String jobTypes) {
        this.jobType = jobTypes;
    }

    public String getJobType() {
        return jobType;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setRealizeProspective(String realizeProspective) {
        this.realizeProspective = realizeProspective;
    }

    public String getRealizeProspective() {
        return realizeProspective;
    }

    public void setNonRealizeEffects(String nonRealizeEffects) {
        this.nonRealizeEffects = nonRealizeEffects;
    }

    public String getNonRealizeEffects() {
        return nonRealizeEffects;
    }

    public void setImplPlanningDate(LocalDate implPlanningDate) {
        this.implPlanningDate = implPlanningDate;
    }

    public LocalDate getImplPlanningDate() {
        return implPlanningDate;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setMarketAnalysis(String marketAnalysis) {
        this.marketAnalysis = marketAnalysis;
    }

    public String getMarketAnalysis() {
        return marketAnalysis;
    }

    public void setMarketAnalysisFile(String marketAnalysisFile) {
        this.marketAnalysisFile = marketAnalysisFile;
    }

    public String getMarketAnalysisFile() {
        return marketAnalysisFile;
    }

    public void setBusinessAppImplDate(LocalDate businessAppImplDate) {
        this.businessAppImplDate = businessAppImplDate;
    }

    public LocalDate getBusinessAppImplDate() {
        return businessAppImplDate;
    }

    public void setPlanGraphicDate(LocalDate planGraphicDate) {
        this.planGraphicDate = planGraphicDate;
    }

    public LocalDate getPlanGraphicDate() {
        return planGraphicDate;
    }

    public List<BusinessDirection> getBusinessDirections() {
        return businessDirections;
    }

    public void setBusinessDirections(List<BusinessDirection> businessDirections) {
        this.businessDirections = businessDirections;
    }

    public List<BIBusinessGoal> getBusinessGoals() {
        return businessGoals;
    }

    public void setBusinessGoals(List<BIBusinessGoal> businessGoals) {
        this.businessGoals = businessGoals;
    }

    public List<SalesChannel> getSalesChannels() {
        return salesChannels;
    }

    public void setSalesChannels(List<SalesChannel> salesChannels) {
        this.salesChannels = salesChannels;
    }

    public List<InfoSystemInfluence> getInfoSystemInfluences() {
        return infoSystemInfluences;
    }

    public void setInfoSystemInfluences(List<InfoSystemInfluence> infoSystemInfluences) {
        this.infoSystemInfluences = infoSystemInfluences;
    }

    public List<ImplementationRisk> getImplementationRisks() {
        return implementationRisks;
    }

    public void setImplementationRisks(List<ImplementationRisk> implementationRisks) {
        this.implementationRisks = implementationRisks;
    }

    public List<ProjectedExpenses> getProjectedExpensess() {
        return projectedExpensess;
    }

    public void setProjectedExpensess(List<ProjectedExpenses> projectedExpensessDBS) {
        this.projectedExpensess = projectedExpensessDBS;
    }

    public List<BIProductTeam> getProductTeams() {
        return productTeams;
    }

    public void setProductTeams(List<BIProductTeam> productTeams) {
        this.productTeams = productTeams;
    }

    public PlanGraphic getPlanGraphic() {
        return planGraphic;
    }

    public void setPlanGraphic(PlanGraphic planGraphic) {
        this.planGraphic = planGraphic;
    }

    public List<DevelopmentBusinessInitiative> getOnDevelopments() {
        return onDevelopments;
    }

    public void setOnDevelopments(List<DevelopmentBusinessInitiative> onDevelopments) {
        this.onDevelopments = onDevelopments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusinessInitiative that = (BusinessInitiative) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productDeveloperDept, that.productDeveloperDept) &&
                Objects.equals(productDeveloperFIO, that.productDeveloperFIO) &&
                Objects.equals(date, that.date) &&
                Objects.equals(status, that.status) &&
                Objects.equals(name, that.name) &&
                jobType == that.jobType &&
                Objects.equals(point, that.point) &&
                Objects.equals(product, that.product) &&
                Objects.equals(realizeProspective, that.realizeProspective) &&
                Objects.equals(nonRealizeEffects, that.nonRealizeEffects) &&
                Objects.equals(implPlanningDate, that.implPlanningDate) &&
                Objects.equals(addInfo, that.addInfo) &&
                Objects.equals(marketAnalysis, that.marketAnalysis) &&
                Objects.equals(marketAnalysisFile, that.marketAnalysisFile) &&
                Objects.equals(businessAppImplDate, that.businessAppImplDate) &&
                Objects.equals(planGraphicDate, that.planGraphicDate) &&
                Objects.equals(businessDirections, that.businessDirections) &&
                Objects.equals(businessGoals, that.businessGoals) &&
                Objects.equals(salesChannels, that.salesChannels) &&
                Objects.equals(infoSystemInfluences, that.infoSystemInfluences) &&
                Objects.equals(implementationRisks, that.implementationRisks) &&
                Objects.equals(projectedExpensess, that.projectedExpensess) &&
                Objects.equals(productTeams, that.productTeams) &&
                Objects.equals(onDevelopments, that.onDevelopments) &&
                Objects.equals(planGraphic, that.planGraphic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                productDeveloperDept,
                productDeveloperFIO,
                date,
                status,
                name,
                jobType,
                point,
                product,
                realizeProspective,
                nonRealizeEffects,
                implPlanningDate,
                addInfo,
                marketAnalysis,
                marketAnalysisFile,
                businessAppImplDate,
                planGraphicDate,
                businessDirections,
                businessGoals,
                salesChannels,
                infoSystemInfluences,
                implementationRisks,
                projectedExpensess,
                productTeams,
                onDevelopments,
                planGraphic);
    }

}
