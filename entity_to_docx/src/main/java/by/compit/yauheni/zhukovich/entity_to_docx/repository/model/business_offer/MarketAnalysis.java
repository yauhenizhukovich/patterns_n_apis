package by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer;

import javax.persistence.*;

@Entity
@Table(name = "BO_MARKETANALISYS")
public class MarketAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @SequenceGenerator(sequenceName = "SQ_BO_MARKETANALYSIS_IDMARKETANALYSIS", allocationSize = 1, name = "SEQ")
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
