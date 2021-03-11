package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import java.math.BigDecimal;

import org.example.TBIProjectedExpenses;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.ProjectedExpenses;

public class ProjectedExpensesConversionUtil {

    public static ProjectedExpenses convertDTOToDatabaseObject(TBIProjectedExpenses projectedExpensesDTO) {
        ProjectedExpenses projectedExpenses = new ProjectedExpenses();
        String expensesTypes = projectedExpensesDTO.getExpensesTypes();
        if (expensesTypes != null) {
            projectedExpenses.setExpensesType(expensesTypes);
        }
        Float expensesSizeFloat = projectedExpensesDTO.getExpencesSize();
        if (expensesSizeFloat != null) {
            BigDecimal expensesSize = BigDecimal.valueOf(expensesSizeFloat);
            projectedExpenses.setExpensesSize(expensesSize);
        }
        return projectedExpenses;
    }

    public static TBIProjectedExpenses convertDatabaseObjectToDTO(ProjectedExpenses projectedExpenses) {
        TBIProjectedExpenses projectedExpensesDTO = new TBIProjectedExpenses();
        if (projectedExpenses.getExpensesSize() != null) {
            BigDecimal expensesSize = projectedExpenses.getExpensesSize();
            projectedExpensesDTO.setExpencesSize(expensesSize.floatValue());
        }
        if (projectedExpenses.getExpensesType() != null) {
            projectedExpensesDTO.setExpensesTypes(projectedExpenses.getExpensesType());
        }
        return projectedExpensesDTO;
    }

}
