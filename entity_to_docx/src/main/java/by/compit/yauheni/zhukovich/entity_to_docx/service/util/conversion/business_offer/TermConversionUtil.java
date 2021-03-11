package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import java.time.LocalDate;
import javax.xml.datatype.XMLGregorianCalendar;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.Term;
import by.compit.yauheni.zhukovich.entity_to_docx.service.util.DateUtil;
import org.example.TBOTerms;

public class TermConversionUtil {

    public static Term convertDTOToDatabaseObject(TBOTerms termDTO) {
        Term term = new Term();
        XMLGregorianCalendar proposedProductImplDate = termDTO.getProposedProductImplDate();
        if (proposedProductImplDate != null) {
            term.setProposedProductImplDate(DateUtil.convertCalendarToLocalDate(proposedProductImplDate));
        }
        XMLGregorianCalendar proposedDeadlineAchieveEffect = termDTO.getProposedDeadlineAchieveEffect();
        if (proposedDeadlineAchieveEffect != null) {
            term.setProposedDeadlineAchieveEffect(DateUtil.convertCalendarToLocalDate(proposedDeadlineAchieveEffect));
        }
        return term;
    }

}
