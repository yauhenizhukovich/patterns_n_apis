package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.datatype.XMLGregorianCalendar;

import org.example.TBIPlanGraphic;
import org.example.TBIWork;
import org.example.TBIWorksRec;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BIWork;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.PlanGraphic;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class PlanGraphicConversionUtil {

    public static PlanGraphic convertDTOToDatabaseObject(TBIPlanGraphic planGraphicDTO, BusinessInitiative bi) {
        PlanGraphic planGraphic = new PlanGraphic();
        String idPlanGraphic = planGraphicDTO.getIdPlanGraphic();
        if (idPlanGraphic != null) {
            planGraphic.setPlanGraphic(idPlanGraphic);
        }
        XMLGregorianCalendar planGraphicDate = planGraphicDTO.getPlanGraphicDate();
        if (planGraphicDate != null) {
            planGraphic.setPlanGraphicDate(convertCalendarToLocalDate(planGraphicDate));
        }
        TBIWorksRec worksBlock = planGraphicDTO.getWorksBlock();
        if (worksBlock != null) {
            List<TBIWork> worksDTO = worksBlock.getWorks();
            if (worksDTO != null) {
                List<BIWork> works = worksDTO.stream()
                        .map(WorkConversionUtil::convertDTOToDatabaseObject)
                        .peek(work -> work.setPlanGraphic(planGraphic))
                        .peek(work -> work.getResponsibles().setBusinessInitiative(bi))
                        .peek(work -> work.getResponsibles().setWork(work))
                        .collect(Collectors.toList());
                planGraphic.setWorks(works);
            }
        }
        return planGraphic;
    }

    public static TBIPlanGraphic convertDatabaseObjectToDTO(PlanGraphic planGraphic) {
        TBIPlanGraphic planGraphicDTO = new TBIPlanGraphic();
        String uniqueNumber = planGraphic.getPlanGraphic();
        if (uniqueNumber != null) {
            planGraphicDTO.setIdPlanGraphic(uniqueNumber);
        }
        LocalDate date = planGraphic.getPlanGraphicDate();
        if (date != null) {
            planGraphicDTO.setPlanGraphicDate(convertLocalDateToCalendar(date));
        }
        List<BIWork> works = planGraphic.getWorks();
        if (works != null) {
            List<TBIWork> worksDTO = works.stream()
                    .map(WorkConversionUtil::convertDatabaseObjectToDTO)
                    .collect(Collectors.toList());
            TBIWorksRec workRec = new TBIWorksRec();
            workRec.getWorks().addAll(worksDTO);
            planGraphicDTO.setWorksBlock(workRec);
        }
        return planGraphicDTO;
    }

}
