package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import org.example.TBIImplementationRisk;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.ImplementationRisk;

public class ImplementationRiskConversionUtil {

    public static ImplementationRisk convertDTOToDatabaseObject(TBIImplementationRisk implementationRiskDTO) {
        ImplementationRisk implementationRisk = new ImplementationRisk();
        String occurProbability = implementationRiskDTO.getOccurProbability();
        if (occurProbability != null) {
            implementationRisk.setOccurProbability(occurProbability);
        }
        String riskName = implementationRiskDTO.getRiskName();
        if (riskName != null) {
            implementationRisk.setRiskName(riskName);
        }
        String stopFactorsMinProp = implementationRiskDTO.getStopFactorsMinProp();
        if (stopFactorsMinProp != null) {
            implementationRisk.setStopFactor(stopFactorsMinProp);
        }
        String availability = implementationRiskDTO.getAvalability();
        if (availability != null) {
            implementationRisk.setAvailability(availability);
        }
        return implementationRisk;
    }

    public static TBIImplementationRisk convertDatabaseObjectToDTO(ImplementationRisk implementationRisk) {
        TBIImplementationRisk implementationRiskDTO = new TBIImplementationRisk();
        String occurProbability = implementationRisk.getOccurProbability();
        if (occurProbability != null) {
            implementationRiskDTO.setOccurProbability(occurProbability);
        }
        String riskName = implementationRisk.getRiskName();
        if (riskName != null) {
            implementationRiskDTO.setRiskName(riskName);
        }
        String stopFactor = implementationRisk.getStopFactor();
        if (stopFactor != null) {
            implementationRiskDTO.setStopFactorsMinProp(stopFactor);
        }
        String availability = implementationRisk.getAvailability();
        if (availability != null) {
            implementationRiskDTO.setAvalability(availability);
        }
        return implementationRiskDTO;
    }

}
