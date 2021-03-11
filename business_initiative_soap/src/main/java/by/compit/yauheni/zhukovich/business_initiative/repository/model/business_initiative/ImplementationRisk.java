package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BI_IMPLEMENTATIONRISKS")
public class ImplementationRisk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_IMPLEMENTATIONRISKS_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDIMPLEMENTATIONRISKS")
    private Long id;
    @Column(name = "RISKNAME")
    private String riskName;
    @Column(name = "OCCURPROBABILITY")
    private String occurProbability;
    @Column(name = "STOPFACTORS")
    private String stopFactor;
    @Column(name = "AVAILABILITY")
    private String availability;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBI")
    private BusinessInitiative businessInitiative;

    public BusinessInitiative getBusinessInitiative() {
        return businessInitiative;
    }

    public void setBusinessInitiative(BusinessInitiative businessInitiative) {
        this.businessInitiative = businessInitiative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setOccurProbability(String occurProbability) {
        this.occurProbability = occurProbability;
    }

    public String getOccurProbability() {
        return occurProbability;
    }

    public void setStopFactor(String stopFactor) {
        this.stopFactor = stopFactor;
    }

    public String getStopFactor() {
        return stopFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImplementationRisk that = (ImplementationRisk) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(riskName, that.riskName) &&
                Objects.equals(occurProbability, that.occurProbability) &&
                Objects.equals(stopFactor, that.stopFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, riskName, occurProbability, stopFactor);
    }

}
