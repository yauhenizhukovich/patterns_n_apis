package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.MarketAnalysis;
import org.example.TBOMarketAnalisys;

public class MarketAnalysisConversionUtil {

    public static MarketAnalysis convertDTOToDatabaseObject(TBOMarketAnalisys marketAnalysisDTO) {
        MarketAnalysis marketAnalysis = new MarketAnalysis();
        String marketAnalisys = marketAnalysisDTO.getMarketAnalisys();
        if (marketAnalisys != null) {
            marketAnalysis.setMarketAnalysis(marketAnalisys);
        }
        String marketAnalisysFile = marketAnalysisDTO.getMarketAnalisysFile();
        if (marketAnalisysFile != null) {
            marketAnalysis.setMarketAnalysisFile(marketAnalisysFile);
        }
        return marketAnalysis;
    }

    public static TBOMarketAnalisys convertDatabaseObjectToDTO(MarketAnalysis marketAnalysis) {
        TBOMarketAnalisys marketAnalysisDTO = new TBOMarketAnalisys();
        String marketAnalysisString = marketAnalysis.getMarketAnalysis();
        if (marketAnalysisString != null) {
            marketAnalysisDTO.setMarketAnalisys(marketAnalysisString);
        }
        String marketAnalysisFile = marketAnalysis.getMarketAnalysisFile();
        if (marketAnalysisFile != null) {
            marketAnalysisDTO.setMarketAnalisysFile(marketAnalysisFile);
        }
        return marketAnalysisDTO;
    }

}
