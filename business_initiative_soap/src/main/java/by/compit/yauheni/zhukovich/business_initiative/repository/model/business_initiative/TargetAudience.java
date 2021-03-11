package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BI_TARGETAUDIENCE")
public class TargetAudience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_TARGETAUDIENCE_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDTARGETAUDIENCE")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBUSINESSDIRECTION")
    private BusinessDirection businessDirection;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "targetAudience", cascade = CascadeType.ALL, orphanRemoval = true)
    private TargetAudienceLgE targetAudienceLgE;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "targetAudience", cascade = CascadeType.ALL, orphanRemoval = true)
    private TargetAudiencePhP targetAudiencePhP;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBI")
    private BusinessInitiative businessInitiative;

    public BusinessInitiative getBusinessInitiative() {
        return businessInitiative;
    }

    public void setBusinessInitiative(BusinessInitiative businessInitiative) {
        this.businessInitiative = businessInitiative;
    }

    public BusinessDirection getBusinessDirection() {
        return businessDirection;
    }

    public void setBusinessDirection(BusinessDirection businessDirection) {
        this.businessDirection = businessDirection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTargetAudienceLgE(TargetAudienceLgE targetAudienceLgE) {
        this.targetAudienceLgE = targetAudienceLgE;
    }

    public TargetAudienceLgE getTargetAudienceLgE() {
        return targetAudienceLgE;
    }

    public void setTargetAudiencePhP(TargetAudiencePhP targetAudiencePhP) {
        this.targetAudiencePhP = targetAudiencePhP;
    }

    public TargetAudiencePhP getTargetAudiencePhP() {
        return targetAudiencePhP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TargetAudience that = (TargetAudience) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(targetAudienceLgE, that.targetAudienceLgE) &&
                Objects.equals(targetAudiencePhP, that.targetAudiencePhP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, targetAudienceLgE, targetAudiencePhP);
    }

}
