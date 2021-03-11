package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative;

import java.time.LocalDate;
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
@Table(name = "BI_WORKS")
public class BIWork {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_WORKS_IDWORKS", allocationSize = 1, name = "SEQ")
    @Column(name = "IDWORKS")
    private Long id;
    @Column(name = "PPWORKS")
    private Integer ppWorks;
    @Column(name = "NESTINGLEVEL")
    private Integer nestingLevel;
    @Column(name = "WORKSNAME")
    private String worksName;
    @Column(name = "WORKSDATE")
    private LocalDate worksDate;
    @Column(name = "EXECDATE")
    private LocalDate execDate;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "ANCESTOR")
    private Integer ancestor;
    @Column(name = "EXECSTATUS")
    private String execStatus;
    @Column(name = "READINESSPERCENTAGE")
    private Integer readinessPercentage;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "PLANNEDPRODLAUNCHDATE")
    private LocalDate plannedProdLaunchDate;
    @Column(name = "MONITORREADYDATE")
    private LocalDate monitorReadyDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPG")
    private PlanGraphic planGraphic;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "work", cascade = CascadeType.ALL, orphanRemoval = true)
    private Responsible responsibles;

    public PlanGraphic getPlanGraphic() {
        return planGraphic;
    }

    public void setPlanGraphic(PlanGraphic planGraphic) {
        this.planGraphic = planGraphic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPPWorks(Integer ppWorks) {
        this.ppWorks = ppWorks;
    }

    public Integer getPPWorks() {
        return ppWorks;
    }

    public void setNestingLevel(Integer nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    public Integer getNestingLevel() {
        return nestingLevel;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    public String getWorksName() {
        return worksName;
    }

    public void setWorksDate(LocalDate worksDate) {
        this.worksDate = worksDate;
    }

    public LocalDate getWorksDate() {
        return worksDate;
    }

    public void setExecDate(LocalDate execDate) {
        this.execDate = execDate;
    }

    public LocalDate getExecDate() {
        return execDate;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setAncestor(Integer ancestor) {
        this.ancestor = ancestor;
    }

    public Integer getAncestor() {
        return ancestor;
    }

    public String getExecStatus() {
        return execStatus;
    }

    public void setExecStatus(String execStatus) {
        this.execStatus = execStatus;
    }

    public void setReadinessPercentage(Integer readinessPercentage) {
        this.readinessPercentage = readinessPercentage;
    }

    public Integer getReadinessPercentage() {
        return readinessPercentage;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setPlannedProdLaunchDate(LocalDate planProdLaunchDate) {
        this.plannedProdLaunchDate = planProdLaunchDate;
    }

    public LocalDate getPlannedProdLaunchDate() {
        return plannedProdLaunchDate;
    }

    public void setMonitorReadyDate(LocalDate monitorReadyDate) {
        this.monitorReadyDate = monitorReadyDate;
    }

    public LocalDate getMonitorReadyDate() {
        return monitorReadyDate;
    }

    public Integer getPpWorks() {
        return ppWorks;
    }

    public void setPpWorks(Integer ppWorks) {
        this.ppWorks = ppWorks;
    }

    public Responsible getResponsibles() {
        return responsibles;
    }

    public void setResponsibles(Responsible responsibles) {
        this.responsibles = responsibles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BIWork work = (BIWork) o;
        return Objects.equals(id, work.id) &&
                Objects.equals(ppWorks, work.ppWorks) &&
                Objects.equals(nestingLevel, work.nestingLevel) &&
                Objects.equals(worksName, work.worksName) &&
                Objects.equals(worksDate, work.worksDate) &&
                Objects.equals(execDate, work.execDate) &&
                Objects.equals(duration, work.duration) &&
                Objects.equals(ancestor, work.ancestor) &&
                execStatus == work.execStatus &&
                Objects.equals(readinessPercentage, work.readinessPercentage) &&
                Objects.equals(comments, work.comments) &&
                Objects.equals(plannedProdLaunchDate, work.plannedProdLaunchDate) &&
                Objects.equals(monitorReadyDate, work.monitorReadyDate) &&
                Objects.equals(responsibles, work.responsibles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                ppWorks,
                nestingLevel,
                worksName,
                worksDate,
                execDate,
                duration,
                ancestor,
                execStatus,
                readinessPercentage,
                comments,
                plannedProdLaunchDate,
                monitorReadyDate,
                responsibles);
    }

}
