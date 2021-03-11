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

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.DevelopmentBusinessInitiative;

@Entity
@Table(name = "MONITOR_PRODUCT_REPORT")
public class MonitorProductReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_MONITOR_PRODUCT_REPORT_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "ID")
    private Long id;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "CREATION_REPORT_DATE")
    private LocalDate creationReportDate;
    @Column(name = "MONITORING_TERM")
    private LocalDate monitoringTerm;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "BI_NAME")
    private String biName;
    @Column(name = "PROFITABILITY_CALC")
    private String profitabilityCalc;
    @Column(name = "PAYBACK_TERM")
    private String paybackTerm;
    @Column(name = "PRODUCT_MONITORING_REPORT")
    private String productMonitoringReport;
    @Column(name = "NEXT_MONITORING_DATE")
    private LocalDate nextMonitoringDate;
    @Column(name = "DECISION")
    private String decision;
    @Column(name = "BI_IMPL_DATE")
    private LocalDate biImplDate;
    @OneToMany(mappedBy = "monitorProductReport", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DevelopmentMPR> onDevelopments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getCreationReportDate() {
        return creationReportDate;
    }

    public void setCreationReportDate(LocalDate creationReportDate) {
        this.creationReportDate = creationReportDate;
    }

    public LocalDate getMonitoringTerm() {
        return monitoringTerm;
    }

    public void setMonitoringTerm(LocalDate monitoringTerm) {
        this.monitoringTerm = monitoringTerm;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBiName() {
        return biName;
    }

    public void setBiName(String biName) {
        this.biName = biName;
    }

    public String getProfitabilityCalc() {
        return profitabilityCalc;
    }

    public void setProfitabilityCalc(String profitabilityCalc) {
        this.profitabilityCalc = profitabilityCalc;
    }

    public String getPaybackTerm() {
        return paybackTerm;
    }

    public void setPaybackTerm(String paybackTerm) {
        this.paybackTerm = paybackTerm;
    }

    public String getProductMonitoringReport() {
        return productMonitoringReport;
    }

    public void setProductMonitoringReport(String productMonitoringReport) {
        this.productMonitoringReport = productMonitoringReport;
    }

    public LocalDate getNextMonitoringDate() {
        return nextMonitoringDate;
    }

    public void setNextMonitoringDate(LocalDate nextMonitoringDate) {
        this.nextMonitoringDate = nextMonitoringDate;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public LocalDate getBiImplDate() {
        return biImplDate;
    }

    public void setBiImplDate(LocalDate biImplDate) {
        this.biImplDate = biImplDate;
    }

    public List<DevelopmentMPR> getOnDevelopments() {
        return onDevelopments;
    }

    public void setOnDevelopments(List<DevelopmentMPR> onDevelopments) {
        this.onDevelopments = onDevelopments;
    }

}
