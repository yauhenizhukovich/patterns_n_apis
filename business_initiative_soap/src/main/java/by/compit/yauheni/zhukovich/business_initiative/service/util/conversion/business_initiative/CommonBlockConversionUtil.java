package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import java.time.LocalDate;
import javax.xml.datatype.XMLGregorianCalendar;

import org.example.TBICommonBlock;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

public class CommonBlockConversionUtil {

    public static TBICommonBlock convertDatabaseObjectToDTO(BusinessInitiative bi) {
        TBICommonBlock commonBlockDTO = new TBICommonBlock();
        commonBlockDTO.setIdBI(String.valueOf(bi.getId()));
        String productDeveloperDept = bi.getProductDeveloperDept();
        if (productDeveloperDept != null) {
            commonBlockDTO.setProductDeveloperDept(productDeveloperDept);
        }
        String productDeveloperFIO = bi.getProductDeveloperFIO();
        if (productDeveloperFIO != null) {
            commonBlockDTO.setProductDeveloperFIO(productDeveloperFIO);
        }
        LocalDate date = bi.getDate();
        if (date != null) {
            commonBlockDTO.setBiDate(convertLocalDateToCalendar(date));
        }
        String status = bi.getStatus();
        if (status != null) {
            commonBlockDTO.setBiStatus(status);
        }
        return commonBlockDTO;
    }

    public static void setDatabaseObjectByDTO(TBICommonBlock commonBlockDTO, BusinessInitiative bi) {
        String productDeveloperDept = commonBlockDTO.getProductDeveloperDept();
        if (productDeveloperDept != null) {
            bi.setProductDeveloperDept(productDeveloperDept);
        }
        String productDeveloperFIO = commonBlockDTO.getProductDeveloperFIO();
        if (productDeveloperFIO != null) {
            bi.setProductDeveloperFIO(productDeveloperFIO);
        }
        String biStatus = commonBlockDTO.getBiStatus();
        if (biStatus != null) {
            bi.setStatus(biStatus);
        }
        XMLGregorianCalendar biDate = commonBlockDTO.getBiDate();
        if (biDate != null) {
            bi.setDate(convertCalendarToLocalDate(biDate));
        }
    }

}
