package by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BO_COMMITEEMATERIALS")
public class CommitteeMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_COMMITEEMATERIALS_IDCOMMITEEMATERIALS", allocationSize = 1, name = "SEQ")
    @Column(name = "IDCOMMITEEMATERIALS")
    private Long id;
    @Column(name = "EXPLANATORYNOTE")
    private String explanatoryNote;
    @Column(name = "DECISIONPROJECT")
    private String decisionProject;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public String getExplanatoryNote() {
        return explanatoryNote;
    }

    public void setExplanatoryNote(String explanatoryNote) {
        this.explanatoryNote = explanatoryNote;
    }

    public String getDecisionProject() {
        return decisionProject;
    }

    public void setDecisionProject(String decisionProject) {
        this.decisionProject = decisionProject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusinessOffer(BusinessOffer businessOffer) {
        this.businessOffer = businessOffer;
    }

    public BusinessOffer getBusinessOffer() {
        return businessOffer;
    }

}
