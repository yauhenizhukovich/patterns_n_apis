package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.RelevanceRisk;
import org.example.TBIImplementationRisk;

public class RelevanceRiskConversionUtil {

    public static RelevanceRisk convertDTOToDatabaseObject(TBIImplementationRisk implementationRiskDTO) {
        RelevanceRisk relevanceRisk = new RelevanceRisk();
        String occurProbability = implementationRiskDTO.getOccurProbability();
        if (occurProbability != null) {
            relevanceRisk.setOccurrenceProbability(occurProbability);
        }
        String riskName = implementationRiskDTO.getRiskName();
        if (riskName != null) {
            relevanceRisk.setProductRiskDesc(riskName);
        }
        String stopFactorsMinProp = implementationRiskDTO.getStopFactorsMinProp();
        if (stopFactorsMinProp != null) {
            relevanceRisk.setRiskMinimProposal(stopFactorsMinProp);
        }
        String availability = implementationRiskDTO.getAvalability();
        if (availability != null) {
            relevanceRisk.setAvailability(availability);
        }
        return relevanceRisk;
    }

    public static TBIImplementationRisk convertDatabaseObjectToDTO(RelevanceRisk relevanceRisk) {
        TBIImplementationRisk implementationRiskDTO = new TBIImplementationRisk();
        String occurProbability = relevanceRisk.getOccurrenceProbability();
        if (occurProbability != null) {
            implementationRiskDTO.setOccurProbability(occurProbability);
        }
        String riskName = relevanceRisk.getProductRiskDesc();
        if (riskName != null) {
            implementationRiskDTO.setRiskName(riskName);
        }
        String stopFactor = relevanceRisk.getRiskMinimProposal();
        if (stopFactor != null) {
            implementationRiskDTO.setStopFactorsMinProp(stopFactor);
        }
        String availability = relevanceRisk.getAvailability();
        if (availability != null) {
            implementationRiskDTO.setAvalability(availability);
        }
        return implementationRiskDTO;
    }

}
