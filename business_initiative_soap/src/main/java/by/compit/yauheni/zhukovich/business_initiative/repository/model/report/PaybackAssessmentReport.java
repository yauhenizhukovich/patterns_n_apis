package by.compit.yauheni.zhukovich.business_initiative.repository.model.report;

import java.time.LocalDate;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PAYBACK_ASSESSMENT_REPORT")
public class PaybackAssessmentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_PAYBACK_ASSESSMENT_REPORT", allocationSize = 1, name = "SEQ")
    @Column(name = "ID")
    private Long id;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "BI_NAME")
    private String biName;
    @Column(name = "BI_IMPL_DATE")
    private LocalDate biImplDate;
    @Column(name = "CREATION_REPORT_DATE")
    private LocalDate creationReportDate;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "DECISION")
    private String decision;
    @Column(name = "MONITORING_TERM")
    private LocalDate monitoringTerm;
    @Column(name = "NEXT_ASSESSMENT_DATE")
    private LocalDate nextAssessmentDate;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "PAYBACK_PLAN_TERM")
    private String paybackPlanTerm;
    @Column(name = "PAYBACK_FACT_TERM")
    private String paybackFactTerm;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PROFITABILITY_CALC")
    private String profitabilityCalc;
    @OneToMany(mappedBy = "paybackAssessmentReport", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DevelopmentPAR> onDevelopments = new ArrayList<>();

    public List<DevelopmentPAR> getOnDevelopments() {
        return onDevelopments;
    }

    public void setOnDevelopments(List<DevelopmentPAR> onDevelopments) {
        this.onDevelopments = onDevelopments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setBiName(String biName) {
        this.biName = biName;
    }

    public String getBiName() {
        return biName;
    }

    public void setBiImplDate(LocalDate biImplDate) {
        this.biImplDate = biImplDate;
    }

    public LocalDate getBiImplDate() {
        return biImplDate;
    }

    public void setCreationReportDate(LocalDate creationReportDate) {
        this.creationReportDate = creationReportDate;
    }

    public LocalDate getCreationReportDate() {
        return creationReportDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecision() {
        return decision;
    }

    public void setMonitoringTerm(LocalDate monitoringTerm) {
        this.monitoringTerm = monitoringTerm;
    }

    public LocalDate getMonitoringTerm() {
        return monitoringTerm;
    }

    public void setNextAssessmentDate(LocalDate nextAssessmentDate) {
        this.nextAssessmentDate = nextAssessmentDate;
    }

    public LocalDate getNextAssessmentDate() {
        return nextAssessmentDate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPaybackPlanTerm(String paybackPlanTerm) {
        this.paybackPlanTerm = paybackPlanTerm;
    }

    public String getPaybackPlanTerm() {
        return paybackPlanTerm;
    }

    public void setPaybackFactTerm(String paybackFactTerm) {
        this.paybackFactTerm = paybackFactTerm;
    }

    public String getPaybackFactTerm() {
        return paybackFactTerm;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProfitabilityCalc(String profitabilityCalc) {
        this.profitabilityCalc = profitabilityCalc;
    }

    public String getProfitabilityCalc() {
        return profitabilityCalc;
    }

}
