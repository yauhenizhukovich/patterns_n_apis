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
@Table(name = "BI_BUSINESSGOALS")
public class BIBusinessGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_BUSINESSGOALS_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDBUSINESSGOALS")
    private Long id;
    @Column(name = "BUSINESSGOALSNAME")
    private String businessGoalName;
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

    public void setBusinessGoalName(String businessGoalName) {
        this.businessGoalName = businessGoalName;
    }

    public String getBusinessGoalName() {
        return businessGoalName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BIBusinessGoal that = (BIBusinessGoal) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(businessGoalName, that.businessGoalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, businessGoalName);
    }

}
