package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report;

import javax.xml.datatype.XMLGregorianCalendar;

import org.example.TBIOnDevelopment;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.DevelopmentMPR;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.DevelopmentPAR;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class DevelopmentMPRConversionUtil {

    public static DevelopmentMPR convertDTOToDatabaseObject(TBIOnDevelopment onDevelopmentDTO) {
        DevelopmentMPR onDevelopment = new DevelopmentMPR();
        String dlgDeptName = onDevelopmentDTO.getDLGDeptName();
        if (dlgDeptName != null) {
            onDevelopment.setDlgDeptName(dlgDeptName);
        }
        String dlgEmpPosition = onDevelopmentDTO.getDLGEmpPosition();
        if (dlgEmpPosition != null) {
            onDevelopment.setDlgEmpPosition(dlgEmpPosition);
        }
        String dlgEmpName = onDevelopmentDTO.getDLGEmpName();
        if (dlgEmpName != null) {
            onDevelopment.setDlgEmpName(dlgEmpName);
        }
        String dlgEmpLogin = onDevelopmentDTO.getDLGEmpLogin();
        if (dlgEmpLogin != null) {
            onDevelopment.setDlgEmpLogin(dlgEmpLogin);
        }
        String deptName = onDevelopmentDTO.getDeptName();
        if (deptName != null) {
            onDevelopment.setDeptName(deptName);
        }
        String empPosition = onDevelopmentDTO.getEmpPosition();
        if (empPosition != null) {
            onDevelopment.setEmpPosition(empPosition);
        }
        String empName = onDevelopmentDTO.getEmpName();
        if (empName != null) {
            onDevelopment.setEmpName(empName);
        }
        String empLogin = onDevelopmentDTO.getEmpLogin();
        if (empLogin != null) {
            onDevelopment.setEmpLogin(empLogin);
        }
        String result = onDevelopmentDTO.getResult();
        if (result != null) {
            onDevelopment.setResult(result);
        }
        String comment = onDevelopmentDTO.getComment();
        if (comment != null) {
            onDevelopment.setComment(comment);
        }
        XMLGregorianCalendar dateTo = onDevelopmentDTO.getDateTo();
        if (dateTo != null) {
            onDevelopment.setDateTo(convertCalendarToLocalDate(dateTo));
        }
        XMLGregorianCalendar dateNom = onDevelopmentDTO.getDateNom();
        if (dateNom != null) {
            onDevelopment.setDateNom(convertCalendarToLocalDate(dateNom));
        }
        String devPhase = onDevelopmentDTO.getDevPhase();
        if (devPhase != null) {
            onDevelopment.setDevPhase(devPhase);
        }
        return onDevelopment;
    }

    public static TBIOnDevelopment convertDatabaseObjectToDTO(DevelopmentMPR development) {
        TBIOnDevelopment developmentDTO = new TBIOnDevelopment();
        if (development.getDevPhase() != null) {
            developmentDTO.setDevPhase(development.getDevPhase());
        }
        if (development.getComment() != null) {
            developmentDTO.setComment(development.getComment());
        }
        if (development.getDateNom() != null) {
            developmentDTO.setDateNom(convertLocalDateToCalendar(development.getDateNom()));
        }
        if (development.getDateTo() != null) {
            developmentDTO.setDateTo(convertLocalDateToCalendar(development.getDateTo()));
        }
        if (development.getResult() != null) {
            developmentDTO.setResult(development.getResult());
        }
        if (development.getDeptName() != null) {
            developmentDTO.setDeptName(development.getDeptName());
        }
        if (development.getEmpLogin() != null) {
            developmentDTO.setEmpLogin(development.getEmpLogin());
        }
        if (development.getEmpPosition() != null) {
            developmentDTO.setEmpPosition(development.getEmpPosition());
        }
        if (development.getEmpName() != null) {
            developmentDTO.setEmpName(development.getEmpName());
        }
        if (development.getDlgDeptName() != null) {
            developmentDTO.setDLGDeptName(development.getDlgDeptName());
        }
        if (development.getDlgEmpLogin() != null) {
            developmentDTO.setDLGEmpLogin(development.getDlgEmpLogin());
        }
        if (development.getDlgEmpPosition() != null) {
            developmentDTO.setDLGEmpPosition(development.getDlgEmpPosition());
        }
        if (development.getDlgEmpName() != null) {
            developmentDTO.setDLGEmpName(development.getDlgEmpName());
        }
        return developmentDTO;
    }

}
