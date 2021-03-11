package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer;

import org.example.TBIBusinessGoals;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BOBusinessGoal;

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
