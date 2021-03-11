package by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer;

import java.time.LocalDate;
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
@Table(name = "BO_TERMS")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_TERMS_IDTERMS", allocationSize = 1, name = "SEQ")
    @Column(name = "IDTERMS")
    private Long id;
    @Column(name = "PROPOSEDPRODUCTIMPLDATE")
    private LocalDate proposedProductImplDate;
    @Column(name = "PROPOSEDDEADLINEACHIEVEEFFECT")
    private LocalDate proposedDeadlineAchieveEffect;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public LocalDate getProposedProductImplDate() {
        return proposedProductImplDate;
    }

    public void setProposedProductImplDate(LocalDate proposedProductImplDate) {
        this.proposedProductImplDate = proposedProductImplDate;
    }

    public LocalDate getProposedDeadlineAchieveEffect() {
        return proposedDeadlineAchieveEffect;
    }

    public void setProposedDeadlineAchieveEffect(LocalDate proposedDeadlineAchieveEffect) {
        this.proposedDeadlineAchieveEffect = proposedDeadlineAchieveEffect;
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
