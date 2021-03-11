package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.banking_product_card;

import org.example.TBEmployeeType;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.ProductCardDistribution;

public class ProductCardDistributionConversionUtil {

    public static ProductCardDistribution convertDTOToDatabaseObject(TBEmployeeType productCardDistributionDTO) {
        ProductCardDistribution productCardDistribution = new ProductCardDistribution();
        String deptName = productCardDistributionDTO.getDeptName();
        if (deptName != null) {
            productCardDistribution.setDeptName(deptName);
        }
        String employeeName = productCardDistributionDTO.getEmployeeName();
        if (employeeName != null) {
            productCardDistribution.setEmployeeName(employeeName);
        }
        String employeePosition = productCardDistributionDTO.getEmployeePosition();
        if (employeePosition != null) {
            productCardDistribution.setEmployeePosition(employeePosition);
        }
        return productCardDistribution;
    }

    public static TBEmployeeType convertDatabaseObjectToDTO(ProductCardDistribution productCardDistribution) {
        TBEmployeeType productCardDistributionDTO = new TBEmployeeType();
        String employeeName = productCardDistribution.getEmployeeName();
        if (employeeName != null) {
            productCardDistributionDTO.setEmployeeName(employeeName);
        }
        String deptName = productCardDistribution.getDeptName();
        if (deptName != null) {
            productCardDistributionDTO.setDeptName(deptName);
        }
        String employeePosition = productCardDistribution.getEmployeePosition();
        if (employeePosition != null) {
            productCardDistributionDTO.setEmployeePosition(employeePosition);
        }
        return productCardDistributionDTO;
    }

}
