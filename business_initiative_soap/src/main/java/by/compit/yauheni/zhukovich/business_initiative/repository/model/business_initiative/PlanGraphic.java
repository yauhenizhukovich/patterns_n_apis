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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BI_PLANGRAPHIC")
public class PlanGraphic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_PLANGRAPHIC_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDPG")
    private Long id;
    @Column(name = "IDPLANGRAPHIC")
    private String planGraphic;
    @Column(name = "PLANGRAPHICDATE")
    private LocalDate planGraphicDate;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBI")
    private BusinessInitiative businessInitiative;
    @OneToMany(mappedBy = "planGraphic", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BIWork> works = new ArrayList<>();

    public String getPlanGraphic() {
        return planGraphic;
    }

    public void setPlanGraphic(String idPlanGraphic) {
        this.planGraphic = idPlanGraphic;
    }

    public LocalDate getPlanGraphicDate() {
        return planGraphicDate;
    }

    public void setPlanGraphicDate(LocalDate planGraphicDate) {
        this.planGraphicDate = planGraphicDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusinessInitiative(BusinessInitiative businessInitiative) {
        this.businessInitiative = businessInitiative;
    }

    public BusinessInitiative getBusinessInitiative() {
        return businessInitiative;
    }

    public List<BIWork> getWorks() {
        return works;
    }

    public void setWorks(List<BIWork> works) {
        this.works = works;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlanGraphic that = (PlanGraphic) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(planGraphic, that.planGraphic) &&
                Objects.equals(planGraphicDate, that.planGraphicDate) &&
                Objects.equals(works, that.works);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planGraphic, planGraphicDate, works);
    }

}
