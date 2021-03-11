package by.compit.yauheni.zhukovich.entity_to_docx.service.util;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static javax.xml.datatype.DatatypeFactory.newInstance;

public class DateUtil {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static XMLGregorianCalendar convertLocalDateToCalendar(LocalDate date) {
        GregorianCalendar calendar = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        try {
            return newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            logger.error("Cannot convert LocalDate to XMLGregorianCalendar.");
            logger.error(e.getMessage());
        }
        return null;
    }

    public static LocalDate convertCalendarToLocalDate(XMLGregorianCalendar xmlCalendar) {
        if (xmlCalendar != null) {
            return xmlCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
        }
        return null;
    }

}
