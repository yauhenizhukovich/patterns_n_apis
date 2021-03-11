package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import org.example.TBIProductTeam;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BIProductTeam;

public class ProductTeamConversionUtil {

    public static BIProductTeam convertDTOToDatabaseObject(TBIProductTeam productTeamDTO) {
        BIProductTeam productTeam = new BIProductTeam();
        if (productTeamDTO.getDevelopDept() != null) {
            productTeam.setDevelopDept(productTeamDTO.getDevelopDept());
        }
        if (productTeamDTO.getDevelopMemberDept() != null) {
            productTeam.setDevelopMemberDept(productTeamDTO.getDevelopMemberDept());
        }
        if (productTeamDTO.getDevelopMemberName() != null) {
            productTeam.setDevelopMemberName(productTeamDTO.getDevelopMemberName());
        }
        if (productTeamDTO.getProductManagerName() != null) {
            productTeam.setProductManagerName(productTeamDTO.getProductManagerName());
        }
        return productTeam;
    }

    public static TBIProductTeam convertDatabaseObjectToDTO(BIProductTeam productTeam) {
        TBIProductTeam productTeamDTO = new TBIProductTeam();
        if (productTeam.getDevelopDept() != null) {
            productTeamDTO.setDevelopDept(productTeam.getDevelopDept());
        }
        if (productTeam.getDevelopMemberDept() != null) {
            productTeamDTO.setDevelopMemberDept(productTeam.getDevelopMemberDept());
        }
        if (productTeam.getDevelopMemberName() != null) {
            productTeamDTO.setDevelopMemberName(productTeam.getDevelopMemberName());
        }
        if (productTeam.getProductManagerName() != null) {
            productTeamDTO.setProductManagerName(productTeam.getProductManagerName());
        }
        return productTeamDTO;
    }

}
