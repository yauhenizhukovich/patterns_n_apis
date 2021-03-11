package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import org.example.TBIBusinessDirection;
import org.example.TBITargetAudience;
import org.example.TBITargetAudienceLgE;
import org.example.TBITargetAudiencePhP;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessDirection;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.TargetAudience;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.TargetAudienceLgE;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.TargetAudiencePhP;

public class BusinessDirectionConversionUtil {

    public static BusinessDirection convertDTOToDatabaseObject(TBIBusinessDirection businessDirectionDTO) {
        BusinessDirection businessDirection = new BusinessDirection();
        if (businessDirectionDTO.getBusinessDirection() != null) {
            businessDirection.setBusinessDirection(businessDirectionDTO.getBusinessDirection());
        }
        TargetAudience targetAudience = new TargetAudience();
        String choiseTargetAudience = businessDirectionDTO.getChoiseTargetAudience();
        if (choiseTargetAudience != null) {
            switch (choiseTargetAudience) {
                case "физ.":
                    businessDirection.setTargetAudienceType(1);
                    setTargetAudiencePhP(businessDirectionDTO, targetAudience);
                    break;
                case "юр.":
                    businessDirection.setTargetAudienceType(2);
                    setTargetAudienceLgE(businessDirectionDTO, targetAudience);
                    break;
                default:
                    throw new UnsupportedOperationException("Business direction choice target audience can be \"юр.\" or \"физ.\"");
            }
        }
        targetAudience.setBusinessDirection(businessDirection);
        businessDirection.setTargetAudience(targetAudience);
        return businessDirection;
    }

    public static TBIBusinessDirection convertDatabaseObjectToDTO(BusinessDirection businessDirection) {
        TBIBusinessDirection businessDirectionDTO = new TBIBusinessDirection();
        if (businessDirection.getBusinessDirection() != null) {
            businessDirectionDTO.setBusinessDirection(businessDirection.getBusinessDirection());
        }
        if (businessDirection.getTargetAudience() != null) {
            TargetAudience targetAudience = businessDirection.getTargetAudience();
            Integer targetAudienceType = businessDirection.getTargetAudienceType();
            if (targetAudienceType != null) {
                switch (targetAudienceType) {
                    case 1:
                        businessDirectionDTO.setChoiseTargetAudience("физ.");
                        setTargetAudiencePhP(targetAudience, businessDirectionDTO);
                        break;
                    case 2:
                        businessDirectionDTO.setChoiseTargetAudience("юр.");
                        setTargetAudienceLgE(targetAudience, businessDirectionDTO);
                        break;
                    default:
                        throw new UnsupportedOperationException("Unsupported target audience type.");
                }
            }
        }
        return businessDirectionDTO;
    }

    private static void setTargetAudiencePhP(TBIBusinessDirection businessDirectionDTO, TargetAudience targetAudience) {
        TargetAudiencePhP targetAudiencePhP = new TargetAudiencePhP();
        if (businessDirectionDTO.getTargetAudience() != null) {
            TBITargetAudiencePhP targetAudiencePhPDTO = businessDirectionDTO.getTargetAudience().getTargetAudiencePhP();
            if (targetAudiencePhPDTO != null) {
                String resident = targetAudiencePhPDTO.getResident();
                if (resident != null) {
                    targetAudiencePhP.setResident(resident);
                }
                targetAudiencePhP.setTargetAudience(targetAudience);
                targetAudience.setTargetAudiencePhP(targetAudiencePhP);
            }
        }
    }

    private static void setTargetAudienceLgE(TBIBusinessDirection businessDirectionDTO, TargetAudience targetAudience) {
        TargetAudienceLgE targetAudienceLgE = new TargetAudienceLgE();
        if (businessDirectionDTO.getTargetAudience() != null) {
            TBITargetAudienceLgE targetAudienceLgEDTO = businessDirectionDTO.getTargetAudience().getTargetAudienceLgE();
            if (targetAudienceLgEDTO != null) {
                String activityKind = targetAudienceLgEDTO.getActivityKind();
                if (activityKind != null) {
                    targetAudienceLgE.setActivityKind(activityKind);
                }
                targetAudienceLgE.setTargetAudience(targetAudience);
                targetAudience.setTargetAudienceLgE(targetAudienceLgE);
            }
        }
    }

    private static void setTargetAudiencePhP(TargetAudience targetAudience, TBIBusinessDirection businessDirectionDTO) {
        TBITargetAudience targetAudienceDTO = new TBITargetAudience();
        TBITargetAudiencePhP targetAudiencePhPDTO = new TBITargetAudiencePhP();
        TargetAudiencePhP targetAudiencePhP = targetAudience.getTargetAudiencePhP();
        if (targetAudiencePhP != null) {
            if (targetAudiencePhP.getResident() != null) {
                targetAudiencePhPDTO.setResident(targetAudiencePhP.getResident());
                targetAudienceDTO.setTargetAudiencePhP(targetAudiencePhPDTO);
                businessDirectionDTO.setTargetAudience(targetAudienceDTO);
            }
        }
    }

    private static void setTargetAudienceLgE(TargetAudience targetAudience, TBIBusinessDirection businessDirectionDTO) {
        TBITargetAudience targetAudienceDTO = new TBITargetAudience();
        TBITargetAudienceLgE targetAudienceLgEDTO = new TBITargetAudienceLgE();
        if (targetAudience.getTargetAudienceLgE() != null) {
            if (targetAudience.getTargetAudienceLgE().getActivityKind() != null) {
                targetAudienceLgEDTO.setActivityKind(targetAudience.getTargetAudienceLgE().getActivityKind());
                targetAudienceDTO.setTargetAudienceLgE(targetAudienceLgEDTO);
                businessDirectionDTO.setTargetAudience(targetAudienceDTO);
            }
        }
    }

}
