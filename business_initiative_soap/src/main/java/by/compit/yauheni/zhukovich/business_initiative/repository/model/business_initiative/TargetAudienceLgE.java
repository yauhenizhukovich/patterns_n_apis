package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BI_TARGETAUDIENCELGE")
public class TargetAudienceLgE {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_TARGETAUDIENCELGE", allocationSize = 1, name = "SEQ")
    @Column(name = "TARGETAUDIENCELGE")
    private Long id;
    @Column(name = "ACTIVITYKIND")
    private String activityKind;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDTARGETAUDIENCE")
    private TargetAudience targetAudience;

    public TargetAudience getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivityKind(String activityKind) {
        this.activityKind = activityKind;
    }

    public String getActivityKind() {
        return activityKind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TargetAudienceLgE that = (TargetAudienceLgE) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(activityKind, that.activityKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activityKind);
    }

}
