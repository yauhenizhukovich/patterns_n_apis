package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import java.time.Month;
import javax.xml.datatype.XMLGregorianCalendar;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.ProfitabilityCalculation;
import by.compit.yauheni.zhukovich.entity_to_docx.service.util.DateUtil;
import org.example.TBOProfitabilityCalculation;

public class ProfitabilityCalculationConversionUtil {

    public static ProfitabilityCalculation convertDTOToDatabaseObject(TBOProfitabilityCalculation pcDTO) {
        ProfitabilityCalculation pc = new ProfitabilityCalculation();
        String profitabilityCalculation = pcDTO.getProfitabilityCalculation();
        if (profitabilityCalculation != null) {
            pc.setProfitabilityCalculation(profitabilityCalculation);
        }
        Integer profitabilityTerm = pcDTO.getProfitabilityTerm();
        if (profitabilityTerm != null) {
            Month month = Month.of(profitabilityTerm);
            pc.setProfitabilityTerm(month);
        }
        XMLGregorianCalendar preliminaryMonitoringTerm = pcDTO.getPreliminaryMonitoringTerm();
        if (preliminaryMonitoringTerm != null) {
            pc.setPreliminaryMonitoringTerm(DateUtil.convertCalendarToLocalDate(preliminaryMonitoringTerm));
        }
        return pc;
    }

    public static TBOProfitabilityCalculation convertDatabaseObjectToDTO(ProfitabilityCalculation pc) {
        TBOProfitabilityCalculation pcDTO = new TBOProfitabilityCalculation();
        return pcDTO;
    }

}
