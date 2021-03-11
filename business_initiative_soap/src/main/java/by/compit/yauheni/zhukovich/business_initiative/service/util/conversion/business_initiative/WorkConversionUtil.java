package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;

import org.example.TBIWork;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BIWork;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.Responsible;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class WorkConversionUtil {

    public static BIWork convertDTOToDatabaseObject(TBIWork workDTO) {
        BIWork work = new BIWork();
        BigInteger ppWorks = workDTO.getPpWorks();
        if (ppWorks != null) {
            work.setPPWorks(ppWorks.intValue());
        }
        BigInteger nestingLevel = workDTO.getNestingLevel();
        if (nestingLevel != null) {
            work.setNestingLevel(nestingLevel.intValue());
        }
        String worksName = workDTO.getWorksName();
        if (worksName != null) {
            work.setWorksName(worksName);
        }
        XMLGregorianCalendar worksDate = workDTO.getWorksDate();
        if (worksDate != null) {
            work.setWorksDate(convertCalendarToLocalDate(worksDate));
        }
        XMLGregorianCalendar execDate = workDTO.getExecDate();
        if (execDate != null) {
            work.setExecDate(convertCalendarToLocalDate(execDate));
        }
        BigInteger duration = workDTO.getDuration();
        if (duration != null) {
            work.setDuration(duration.intValue());
        }
        BigInteger ancestor = workDTO.getAncestor();
        if (ancestor != null) {
            work.setAncestor(ancestor.intValue());
        }
        String execStatus = workDTO.getExecStatus();
        if (execStatus != null) {
            work.setExecStatus(execStatus);
        }
        BigInteger readinessPercentage = workDTO.getReadinessPercentage();
        if (readinessPercentage != null) {
            work.setReadinessPercentage(readinessPercentage.intValue());
        }
        String comments = workDTO.getComments();
        if (comments != null) {
            work.setComments(comments);
        }
        XMLGregorianCalendar plannedProdLaunchDate = workDTO.getPlannedProdLaunchDate();
        if (plannedProdLaunchDate != null) {
            work.setPlannedProdLaunchDate(convertCalendarToLocalDate(plannedProdLaunchDate));
        }
        XMLGregorianCalendar monitorReadyDate = workDTO.getMonitorReadyDate();
        if (monitorReadyDate != null) {
            work.setMonitorReadyDate(convertCalendarToLocalDate(monitorReadyDate));
        }
        Responsible responsible = new Responsible();
        String respDeptName = workDTO.getRespDeptName();
        if (respDeptName != null) {
            responsible.setDeptName(respDeptName);
        }
        String respEmpName = workDTO.getRespEmpName();
        if (respEmpName != null) {
            responsible.setRespName(respEmpName);
        }
        work.setResponsibles(responsible);
        return work;
    }

    public static TBIWork convertDatabaseObjectToDTO(BIWork work) {
        TBIWork workDTO = new TBIWork();
        if (work.getId() != null) {
            workDTO.setIdWorks(String.valueOf(work.getId()));
        }
        if (work.getPPWorks() != null) {
            workDTO.setPpWorks(BigInteger.valueOf(work.getPPWorks()));
        }
        if (work.getAncestor() != null) {
            workDTO.setAncestor(BigInteger.valueOf(work.getAncestor()));
        }
        if (work.getNestingLevel() != null) {
            workDTO.setNestingLevel(BigInteger.valueOf(work.getNestingLevel()));
        }
        if (work.getReadinessPercentage() != null) {
            workDTO.setReadinessPercentage(BigInteger.valueOf(work.getReadinessPercentage()));
        }
        if (work.getDuration() != null) {
            workDTO.setDuration(BigInteger.valueOf(work.getDuration()));
        }
        if (work.getWorksDate() != null) {
            workDTO.setWorksDate(convertLocalDateToCalendar(work.getWorksDate()));
        }
        if (work.getPlannedProdLaunchDate() != null) {
            workDTO.setPlannedProdLaunchDate(convertLocalDateToCalendar(work.getPlannedProdLaunchDate()));
        }
        if (work.getMonitorReadyDate() != null) {
            workDTO.setMonitorReadyDate(convertLocalDateToCalendar(work.getMonitorReadyDate()));
        }
        if (work.getExecDate() != null) {
            workDTO.setExecDate(convertLocalDateToCalendar(work.getExecDate()));
        }
        if (work.getComments() != null) {
            workDTO.setComments(work.getComments());
        }
        if (work.getWorksName() != null) {
            workDTO.setWorksName(work.getWorksName());
        }
        if (work.getExecStatus() != null) {
            workDTO.setExecStatus(work.getExecStatus());
        }
        Responsible responsibles = work.getResponsibles();
        if (responsibles != null) {
            String deptName = responsibles.getDeptName();
            if (deptName != null) {
                workDTO.setRespDeptName(deptName);
            }
            String respName = responsibles.getRespName();
            if (respName != null) {
                workDTO.setRespEmpName(respName);
            }
        }
        return workDTO;
    }

}
