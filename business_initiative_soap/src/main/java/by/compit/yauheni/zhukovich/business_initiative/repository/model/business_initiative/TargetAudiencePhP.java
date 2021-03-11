package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BI_TARGETAUDIENCEPHP")
public class TargetAudiencePhP {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_TARGETAUDIENCEPHP", allocationSize = 1, name = "SEQ")
    @Column(name = "TARGETAUDIENCEPHP")
    private Long id;
    @Column(name = "RESIDENT")
    private String resident;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDTARGETAUDIENCE")
    private TargetAudience targetAudience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public String getResident() {
        return resident;
    }

    public TargetAudience getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TargetAudiencePhP that = (TargetAudiencePhP) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(resident, that.resident);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resident);
    }

}
