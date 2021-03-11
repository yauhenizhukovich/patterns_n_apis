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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BI_RESPONSIBLES")
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_RESPONSIBLES_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDRESPONSIBLES")
    private Long id;
    @Column(name = "RESPNAME")
    private String respName;
    @Column(name = "DEPTNAME")
    private String deptName;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDWORKS")
    private BIWork work;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBI")
    private BusinessInitiative businessInitiative;

    public void setWork(BIWork work) {
        this.work = work;
    }

    public BIWork getWork() {
        return work;
    }

    public void setRespName(String respName) {
        this.respName = respName;
    }

    public String getRespName() {
        return respName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Responsible that = (Responsible) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(respName, that.respName) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(work, that.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, respName, deptName, work);
    }

}
