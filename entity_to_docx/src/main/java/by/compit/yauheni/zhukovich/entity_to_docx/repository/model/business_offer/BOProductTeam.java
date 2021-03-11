package by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "BO_PRODUCTTEAM")
public class BOProductTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_PRODUCTTEAM_IDPRODUCTTEAM", allocationSize = 1, name = "SEQ")
    @Column(name = "IDPRODUCTTEAM")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKID")
    private BOWork work;
    @OneToMany(mappedBy = "productTeam", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkResponsible> workResponsibles = new ArrayList<>();

    public List<WorkResponsible> getWorkResponsibles() {
        return workResponsibles;
    }

    public void setWorkResponsibles(List<WorkResponsible> workResponsibles) {
        this.workResponsibles = workResponsibles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BOWork getWork() {
        return work;
    }

    public void setWork(BOWork work) {
        this.work = work;
    }

}
