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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BI_INFOSYSTEMINFLUENCE")
public class InfoSystemInfluence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BI_INFOSYSTEMINFLUENCE_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDINFOSYSTEMINFLUENCE")
    private Long id;
    @Column(name = "INFLUENCEDESCRIPTION")
    private String influenceDescription;
    @Column(name = "INFOSYSTEMINFLUENCE")
    private String infoSystemInfluence;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBI")
    private BusinessInitiative businessInitiative;

    public BusinessInitiative getBusinessInitiative() {
        return businessInitiative;
    }

    public void setBusinessInitiative(BusinessInitiative businessInitiative) {
        this.businessInitiative = businessInitiative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInfluenceDescription(String influenceDescription) {
        this.influenceDescription = influenceDescription;
    }

    public String getInfluenceDescription() {
        return influenceDescription;
    }

    public void setInfoSystemInfluence(String infoSystemInfluence) {
        this.infoSystemInfluence = infoSystemInfluence;
    }

    public String getInfoSystemInfluence() {
        return infoSystemInfluence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InfoSystemInfluence that = (InfoSystemInfluence) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(influenceDescription, that.influenceDescription) &&
                Objects.equals(infoSystemInfluence, that.infoSystemInfluence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, influenceDescription, infoSystemInfluence);
    }

}
