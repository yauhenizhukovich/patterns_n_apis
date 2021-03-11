package by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer;

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
@Table(name = "BO_BUSINESSGOALS")
public class BOBusinessGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_BUSINESSGOALS_IDBUSINESSGOALS", allocationSize = 1, name = "SEQ")
    @Column(name = "IDBUSINESSGOALS")
    private Long id;
    @Column(name = "GOALSNAME")
    private String goalsName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public void setBusinessOffer(BusinessOffer businessOffer) {
        this.businessOffer = businessOffer;
    }

    public BusinessOffer getBusinessOffer() {
        return businessOffer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGoalsName(String goalsName) {
        this.goalsName = goalsName;
    }

    public String getGoalsName() {
        return goalsName;
    }

}
