package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer;

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
@Table(name = "BO_WORKRESPONSIBLES")
public class WorkResponsible {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_WORKRESPONSIBLES_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDWORKRESPONSIBLE")
    private Long id;
    @Column(name = "RESPNAME")
    private String respName;
    @Column(name = "DEPTNAME")
    private String deptName;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUCTTEAM")
    private BOProductTeam productTeam;

    public BOProductTeam getProductTeam() {
        return productTeam;
    }

    public void setProductTeam(BOProductTeam productTeam) {
        this.productTeam = productTeam;
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

}
