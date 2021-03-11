package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer;

import java.time.LocalDate;
import java.time.Month;
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
@Table(name = "BO_PROFITABILITYCALCULATION")
public class ProfitabilityCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_PROFITABILITYCALCULAT_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDPROFITABILITYCALCULATION")
    private Long id;
    @Column(name = "PRELIMINARYMONITORINGTERM")
    private LocalDate preliminaryMonitoringTerm;
    @Column(name = "PROFITABILITYCALCULATION")
    private String profitabilityCalculation;
    @Column(name = "PROFITABILITYTERM")
    private Integer profitabilityTerm;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPreliminaryMonitoringTerm() {
        return preliminaryMonitoringTerm;
    }

    public void setPreliminaryMonitoringTerm(LocalDate preliminaryMonitoringTerm) {
        this.preliminaryMonitoringTerm = preliminaryMonitoringTerm;
    }

    public String getProfitabilityCalculation() {
        return profitabilityCalculation;
    }

    public void setProfitabilityCalculation(String profitabilityCalculation) {
        this.profitabilityCalculation = profitabilityCalculation;
    }

    public Integer getProfitabilityTerm() {
        return profitabilityTerm;
    }

    public void setProfitabilityTerm(Integer profitabilityTerm) {
        this.profitabilityTerm = profitabilityTerm;
    }

    public void setBusinessOffer(BusinessOffer businessOffer) {
        this.businessOffer = businessOffer;
    }

    public BusinessOffer getBusinessOffer() {
        return businessOffer;
    }

}
