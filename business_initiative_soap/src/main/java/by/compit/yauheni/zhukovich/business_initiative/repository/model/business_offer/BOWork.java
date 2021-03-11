package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer;

import java.time.LocalDate;
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
@Table(name = "BO_WORKS")
public class BOWork {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_WORKS_WORKID", allocationSize = 1, name = "SEQ")
    @Column(name = "WORKID")
    private Long id;
    @Column(name = "PPWORKS")
    private Integer ppWork;
    @Column(name = "PPNESTINGLEVEL")
    private Integer ppNestingLevel;
    @Column(name = "WORKSNAME")
    private String worksName;
    @Column(name = "STARTEXECDATE")
    private LocalDate startExecDate;
    @Column(name = "DATEEXEC")
    private LocalDate dateExec;
    @Column(name = "DURATION")
    private Integer duration;
    @Column(name = "ANCESTOR")
    private Integer ancestor;
    @Column(name = "EXECSTATUS")
    private String execStatus;
    @Column(name = "READINESSPERCENT")
    private Integer readinessPercent;
    @Column(name = "COMMENTS")
    private String comment;
    @Column(name = "PLANNEDPRODUCTLAUNCHDATE")
    private LocalDate plannedProductLaunchDate;
    @Column(name = "READINESSMONFREQ")
    private Integer readinessMonFreq;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "work", cascade = CascadeType.ALL, orphanRemoval = true)
    private BOProductTeam productTeam;

    public void setPpWork(Integer ppWorks) {
        this.ppWork = ppWorks;
    }

    public Integer getPpWork() {
        return ppWork;
    }

    public void setPpNestingLevel(Integer ppNestingLevel) {
        this.ppNestingLevel = ppNestingLevel;
    }

    public Integer getPpNestingLevel() {
        return ppNestingLevel;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    public String getWorksName() {
        return worksName;
    }

    public void setStartExecDate(LocalDate startExecDate) {
        this.startExecDate = startExecDate;
    }

    public LocalDate getStartExecDate() {
        return startExecDate;
    }

    public void setDateExec(LocalDate dateExec) {
        this.dateExec = dateExec;
    }

    public LocalDate getDateExec() {
        return dateExec;
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

    public void setExecStatus(String execStatus) {
        this.execStatus = execStatus;
    }

    public String getExecStatus() {
        return execStatus;
    }

    public void setReadinessPercent(Integer readinessPercent) {
        this.readinessPercent = readinessPercent;
    }

    public Integer getReadinessPercent() {
        return readinessPercent;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setPlannedProductLaunchDate(LocalDate plannedProductLaunchDate) {
        this.plannedProductLaunchDate = plannedProductLaunchDate;
    }

    public LocalDate getPlannedProductLaunchDate() {
        return plannedProductLaunchDate;
    }

    public void setReadinessMonFreq(Integer readinessMonFreq) {
        this.readinessMonFreq = readinessMonFreq;
    }

    public Integer getReadinessMonFreq() {
        return readinessMonFreq;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusinessOffer getBusinessOffer() {
        return businessOffer;
    }

    public void setBusinessOffer(BusinessOffer businessOffer) {
        this.businessOffer = businessOffer;
    }

    public BOProductTeam getProductTeam() {
        return productTeam;
    }

    public void setProductTeam(BOProductTeam productTeam) {
        this.productTeam = productTeam;
    }

}
