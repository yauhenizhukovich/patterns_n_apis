package by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer;

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
@Table(name = "BO_RELEVANCERISKS")
public class RelevanceRisk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_RELEVANCERISKS_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDRELEVANCERISKS")
    private Long id;
    @Column(name = "PRODUCTRISKDESC")
    private String productRiskDesc;
    @Column(name = "OCCURRENCEPROBABILITY")
    private String occurrenceProbability;
    @Column(name = "RISKMINIMPROPOSAL")
    private String riskMinimProposal;
    @Column(name = "AVAILABILITY")
    private String availability;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public void setBusinessOffer(BusinessOffer businessOffer) {
        this.businessOffer = businessOffer;
    }

    public BusinessOffer getBusinessOffer() {
        return businessOffer;
    }

    public void setProductRiskDesc(String productRiskDesc) {
        this.productRiskDesc = productRiskDesc;
    }

    public String getProductRiskDesc() {
        return productRiskDesc;
    }

    public void setOccurrenceProbability(String occurenceProbability) {
        this.occurrenceProbability = occurenceProbability;
    }

    public String getOccurrenceProbability() {
        return occurrenceProbability;
    }

    public void setRiskMinimProposal(String riskMinimProposal) {
        this.riskMinimProposal = riskMinimProposal;
    }

    public String getRiskMinimProposal() {
        return riskMinimProposal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
