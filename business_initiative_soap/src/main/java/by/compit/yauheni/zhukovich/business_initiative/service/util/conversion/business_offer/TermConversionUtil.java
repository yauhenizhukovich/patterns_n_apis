package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer;

import java.time.LocalDate;
import javax.xml.datatype.XMLGregorianCalendar;

import org.example.TBOTerms;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.Term;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class TermConversionUtil {

    public static Term convertDTOToDatabaseObject(TBOTerms termDTO) {
        Term term = new Term();
        XMLGregorianCalendar proposedProductImplDate = termDTO.getProposedProductImplDate();
        if (proposedProductImplDate != null) {
            term.setProposedProductImplDate(convertCalendarToLocalDate(proposedProductImplDate));
        }
        XMLGregorianCalendar proposedDeadlineAchieveEffect = termDTO.getProposedDeadlineAchieveEffect();
        if (proposedDeadlineAchieveEffect != null) {
            term.setProposedDeadlineAchieveEffect(convertCalendarToLocalDate(proposedDeadlineAchieveEffect));
        }
        return term;
    }

    public static TBOTerms convertDatabaseObjectToDTO(Term term) {
        TBOTerms termDTO = new TBOTerms();
        LocalDate proposedProductImplDate = term.getProposedProductImplDate();
        if (proposedProductImplDate != null) {
            termDTO.setProposedProductImplDate(convertLocalDateToCalendar(proposedProductImplDate));
        }
        LocalDate proposedDeadlineAchieveEffect = term.getProposedDeadlineAchieveEffect();
        if (proposedDeadlineAchieveEffect != null) {
            termDTO.setProposedDeadlineAchieveEffect(convertLocalDateToCalendar(proposedDeadlineAchieveEffect));
        }
        return termDTO;
    }

}
