package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.WorkResponsible;
import org.example.TBIResponsible;

public class WorkResponsibleConversionUtil {

    public static WorkResponsible convertDTOToDatabaseObject(TBIResponsible workResponsibleDTO) {
        WorkResponsible workResponsible = new WorkResponsible();
        String deptName = workResponsibleDTO.getDeptName();
        if (deptName != null) {
            workResponsible.setDeptName(deptName);
        }
        String respName = workResponsibleDTO.getRespName();
        if (respName != null) {
            workResponsible.setRespName(respName);
        }
        return workResponsible;
    }

    public static TBIResponsible convertDatabaseObjectToDTO(WorkResponsible workResponsible) {
        TBIResponsible workResponsibleDTO = new TBIResponsible();
        String deptName = workResponsible.getDeptName();
        if (deptName != null) {
            workResponsibleDTO.setDeptName(deptName);
        }
        String respName = workResponsible.getRespName();
        if (respName != null) {
            workResponsibleDTO.setRespName(respName);
        }
        return workResponsibleDTO;
    }

}
