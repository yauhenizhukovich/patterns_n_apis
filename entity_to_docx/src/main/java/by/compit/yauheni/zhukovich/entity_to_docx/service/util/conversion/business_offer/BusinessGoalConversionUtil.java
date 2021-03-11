package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BOBusinessGoal;
import org.example.TBIBusinessGoals;

public class BusinessGoalConversionUtil {

    public static BOBusinessGoal convertDTOToDatabaseObject(TBIBusinessGoals businessGoalDTO) {
        BOBusinessGoal businessGoal = new BOBusinessGoal();
        String businessGoalsName = businessGoalDTO.getBusinessGoalsName();
        if (businessGoalsName != null) {
            businessGoal.setGoalsName(businessGoalsName);
        }
        return businessGoal;
    }

    public static TBIBusinessGoals convertDatabaseObjectToDTO(BOBusinessGoal businessGoal) {
        TBIBusinessGoals businessGoalDTO = new TBIBusinessGoals();
        String goalsName = businessGoal.getGoalsName();
        if (goalsName != null) {
            businessGoalDTO.setBusinessGoalsName(goalsName);
        }
        return businessGoalDTO;
    }

}
