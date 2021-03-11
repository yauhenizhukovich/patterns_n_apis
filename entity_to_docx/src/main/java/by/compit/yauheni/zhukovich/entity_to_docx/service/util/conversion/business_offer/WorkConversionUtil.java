package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import java.math.BigInteger;
import java.time.LocalDate;
import javax.xml.datatype.XMLGregorianCalendar;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BOProductTeam;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BOWork;
import by.compit.yauheni.zhukovich.entity_to_docx.service.util.DateUtil;
import org.example.TBIResponsiblesRec;
import org.example.TBIWork;

public class WorkConversionUtil {

    public static BOWork convertDTOToDatabaseObject(TBIWork workDTO) {
        BOWork work = new BOWork();
        BigInteger ppWorks = workDTO.getPpWorks();
        if (ppWorks != null) {
            work.setPpWork(ppWorks.intValue());
        }
        BigInteger nestingLevel = workDTO.getNestingLevel();
        if (nestingLevel != null) {
            work.setPpNestingLevel(nestingLevel.intValue());
        }
        String worksName = workDTO.getWorksName();
        if (worksName != null) {
            work.setWorksName(worksName);
        }
        XMLGregorianCalendar execDate = workDTO.getExecDate();
        if (execDate != null) {
            work.setStartExecDate(DateUtil.convertCalendarToLocalDate(execDate));
        }
        XMLGregorianCalendar worksDate = workDTO.getWorksDate();
        if (worksDate != null) {
            work.setDateExec(DateUtil.convertCalendarToLocalDate(worksDate));
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
            work.setReadinessPercent(readinessPercentage.intValue());
        }
        String comments = workDTO.getComments();
        if (comments != null) {
            work.setComment(comments);
        }
        XMLGregorianCalendar plannedProdLaunchDate = workDTO.getPlannedProdLaunchDate();
        if (plannedProdLaunchDate != null) {
            work.setPlannedProductLaunchDate(DateUtil.convertCalendarToLocalDate(plannedProdLaunchDate));
        }
        BigInteger readinessMonFreq = workDTO.getReadinessMonFreq();
        if (readinessMonFreq != null) {
            work.setReadinessMonFreq(readinessMonFreq.intValue());
        }
        TBIResponsiblesRec responsibles = workDTO.getResponsibles();
        if (responsibles != null) {
            BOProductTeam productTeam = ProductTeamConversionUtil.convertDTOToDatabaseObject(responsibles);
            productTeam.setWork(work);
            work.setProductTeam(productTeam);
        }
        return work;
    }

    public static TBIWork convertDatabaseObjectToDTO(BOWork work) {
        TBIWork workDTO = new TBIWork();
        Long id = work.getId();
        workDTO.setIdWorks(String.valueOf(id));
        Integer ppWork = work.getPpWork();
        if (ppWork != null) {
            workDTO.setPpWorks(BigInteger.valueOf(ppWork));
        }
        Integer ppNestingLevel = work.getPpNestingLevel();
        if (ppNestingLevel != null) {
            workDTO.setNestingLevel(BigInteger.valueOf(ppNestingLevel));
        }
        String worksName = work.getWorksName();
        if (worksName != null) {
            workDTO.setWorksName(worksName);
        }
        LocalDate startExecDate = work.getStartExecDate();
        if (startExecDate != null) {
            workDTO.setWorksDate(DateUtil.convertLocalDateToCalendar(startExecDate));
        }
        LocalDate dateExec = work.getDateExec();
        if (dateExec != null) {
            workDTO.setExecDate(DateUtil.convertLocalDateToCalendar(dateExec));
        }
        Integer duration = work.getDuration();
        if (duration != null) {
            workDTO.setDuration(BigInteger.valueOf(duration));
        }
        Integer ancestor = work.getAncestor();
        if (ancestor != null) {
            workDTO.setAncestor(BigInteger.valueOf(ancestor));
        }
        String execStatus = work.getExecStatus();
        if (execStatus != null) {
            workDTO.setExecStatus(execStatus);
        }
        Integer readinessPercent = work.getReadinessPercent();
        if (readinessPercent != null) {
            workDTO.setReadinessPercentage(BigInteger.valueOf(readinessPercent));
        }
        String comment = work.getComment();
        if (comment != null) {
            workDTO.setComments(comment);
        }
        LocalDate plannedProductLaunchDate = work.getPlannedProductLaunchDate();
        if (plannedProductLaunchDate != null) {
            workDTO.setPlannedProdLaunchDate(DateUtil.convertLocalDateToCalendar(plannedProductLaunchDate));
        }
        Integer readinessMonFreq = work.getReadinessMonFreq();
        if (readinessMonFreq != null) {
            workDTO.setReadinessMonFreq(BigInteger.valueOf(readinessMonFreq));
        }
        BOProductTeam productTeam = work.getProductTeam();
        if (productTeam != null) {
            workDTO.setResponsibles(ProductTeamConversionUtil.convertDatabaseObjectToDTO(productTeam));
        }
        return workDTO;
    }

}
