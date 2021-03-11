package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import java.util.List;
import java.util.stream.Collectors;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BOProductTeam;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.WorkResponsible;
import org.example.TBIResponsible;
import org.example.TBIResponsiblesRec;

public class ProductTeamConversionUtil {

    public static BOProductTeam convertDTOToDatabaseObject(TBIResponsiblesRec productTeamDTO) {
        BOProductTeam productTeam = new BOProductTeam();
        if (productTeamDTO.getResponsibles() != null) {
            List<TBIResponsible> workResponsiblesDTO = productTeamDTO.getResponsibles();
            List<WorkResponsible> workResponsibles = workResponsiblesDTO.stream()
                    .map(WorkResponsibleConversionUtil::convertDTOToDatabaseObject)
                    .peek(workResponsible -> workResponsible.setProductTeam(productTeam))
                    .collect(Collectors.toList());
            productTeam.setWorkResponsibles(workResponsibles);
        }
        return productTeam;
    }

    public static TBIResponsiblesRec convertDatabaseObjectToDTO(BOProductTeam productTeam) {
        TBIResponsiblesRec productTeamDTO = new TBIResponsiblesRec();
        if (productTeam.getWorkResponsibles() != null) {
            List<WorkResponsible> workResponsibles = productTeam.getWorkResponsibles();
            List<TBIResponsible> workResponsiblesDTO = workResponsibles.stream()
                    .map(WorkResponsibleConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            productTeamDTO.getResponsibles().addAll(workResponsiblesDTO);
        }
        return productTeamDTO;
    }

}
