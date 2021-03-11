package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer;

import javax.xml.datatype.XMLGregorianCalendar;

import org.example.TBOProfitabilityCalculation;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.ProfitabilityCalculation;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class ProfitabilityCalculationConversionUtil {

    public static ProfitabilityCalculation convertDTOToDatabaseObject(TBOProfitabilityCalculation pcDTO) {
        ProfitabilityCalculation pc = new ProfitabilityCalculation();
        String profitabilityCalculation = pcDTO.getProfitabilityCalculation();
        if (profitabilityCalculation != null) {
            pc.setProfitabilityCalculation(profitabilityCalculation);
        }
        Integer profitabilityTerm = pcDTO.getProfitabilityTerm();
        if (profitabilityTerm != null) {
            pc.setProfitabilityTerm(profitabilityTerm);
        }
        XMLGregorianCalendar preliminaryMonitoringTerm = pcDTO.getPreliminaryMonitoringTerm();
        if (preliminaryMonitoringTerm != null) {
            pc.setPreliminaryMonitoringTerm(convertCalendarToLocalDate(preliminaryMonitoringTerm));
        }
        return pc;
    }

    public static TBOProfitabilityCalculation convertDatabaseObjectToDTO(ProfitabilityCalculation pc) {
        TBOProfitabilityCalculation pcDTO = new TBOProfitabilityCalculation();
        if (pc.getProfitabilityCalculation() != null) {
            pcDTO.setProfitabilityCalculation(pc.getProfitabilityCalculation());
        }
        if (pc.getProfitabilityTerm() != null) {
            pcDTO.setProfitabilityTerm(pc.getProfitabilityTerm());
        }
        if (pc.getPreliminaryMonitoringTerm() != null) {
            pcDTO.setPreliminaryMonitoringTerm(convertLocalDateToCalendar(pc.getPreliminaryMonitoringTerm()));
        }
        return pcDTO;
    }

}
