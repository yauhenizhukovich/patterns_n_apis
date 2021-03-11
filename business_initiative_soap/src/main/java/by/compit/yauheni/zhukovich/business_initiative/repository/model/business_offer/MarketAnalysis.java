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
@Table(name = "BO_MARKETANALISYS")
public class MarketAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_MARKETANALYSIS_ID", allocationSize = 1, name = "SEQ")
    @Column(name = "IDMARKETANALISYS")
    private Long id;
    @Column(name = "MARKETANALISYSFILE")
    private String marketAnalysisFile;
    @Column(name = "MARKETANALISYS")
    private String marketAnalysis;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDBO")
    private BusinessOffer businessOffer;

    public String getMarketAnalysisFile() {
        return marketAnalysisFile;
    }

    public void setMarketAnalysisFile(String marketAnalysisFile) {
        this.marketAnalysisFile = marketAnalysisFile;
    }

    public String getMarketAnalysis() {
        return marketAnalysis;
    }

    public void setMarketAnalysis(String marketAnalysis) {
        this.marketAnalysis = marketAnalysis;
    }

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

}
