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
@Table(name = "BI_BUSINESSDIRECTION")
public class BusinessDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_BUSINESSDIRECTION_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDBUSINESSDIRECTION")
    private Long id;
    @Column(name = "IDTARGETAUDIENCE")
    private Integer targetAudienceType;
    @Column(name = "BUSINESSDIRECTION")
    private String businessDirection;
    @OneToOne(mappedBy = "businessDirection", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private TargetAudience targetAudience;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBI")
    private BusinessInitiative businessInitiative;

    public Integer getTargetAudienceType() {
        return targetAudienceType;
    }

    public void setTargetAudienceType(Integer targetAudienceType) {
        this.targetAudienceType = targetAudienceType;
    }

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

    public void setTargetAudience(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }

    public TargetAudience getTargetAudience() {
        return targetAudience;
    }

    public String getBusinessDirection() {
        return businessDirection;
    }

    public void setBusinessDirection(String businessDirection) {
        this.businessDirection = businessDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusinessDirection that = (BusinessDirection) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(targetAudienceType, that.targetAudienceType) &&
                businessDirection == that.businessDirection &&
                Objects.equals(targetAudience, that.targetAudience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, targetAudienceType, businessDirection, targetAudience);
    }

}
