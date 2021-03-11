package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import org.example.TBIBusinessGoals;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BIBusinessGoal;

public class BusinessGoalConversionUtil {

    public static BIBusinessGoal convertDTOToDatabaseObject(TBIBusinessGoals businessGoalDTO) {
        BIBusinessGoal businessGoal = new BIBusinessGoal();
        String businessGoalsName = businessGoalDTO.getBusinessGoalsName();
        if (businessGoalsName != null) {
            businessGoal.setBusinessGoalName(businessGoalsName);
        }
        return businessGoal;
    }

    public static TBIBusinessGoals convertDatabaseObjectToDTO(BIBusinessGoal businessGoal) {
        TBIBusinessGoals businessGoalDTO = new TBIBusinessGoals();
        String businessGoalName = businessGoal.getBusinessGoalName();
        if (businessGoalName != null) {
            businessGoalDTO.setBusinessGoalsName(businessGoalName);
        }
        return businessGoalDTO;
    }

}
