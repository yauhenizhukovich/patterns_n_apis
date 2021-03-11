package by.compit.yauheni.zhukovich.business_initiative.service.util;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.MonitorProductReport;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.BankingProductCard;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.PaybackAssessmentReport;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBankingProductCardException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentMonitorProductReportException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentPaybackAssessmentReportException;

public class CheckUtil {

    public static void checkBusinessInitiativeForNotNull(BusinessInitiative bi) throws NonexistentBusinessInitiativeException {
        if (bi == null) {
            throw new NonexistentBusinessInitiativeException();
        }
    }

    public static void checkBusinessOfferForNotNull(BusinessOffer bo) throws NonexistentBusinessOfferException {
        if (bo == null) {
            throw new NonexistentBusinessOfferException();
        }
    }

    public static void checkBankingProductCardForNotNull(BankingProductCard bpc) throws NonexistentBankingProductCardException {
        if (bpc == null) {
            throw new NonexistentBankingProductCardException();
        }
    }

    public static void checkPaybackAssessmentReportForNotNull(PaybackAssessmentReport par) throws NonexistentPaybackAssessmentReportException {
        if (par == null) {
            throw new NonexistentPaybackAssessmentReportException();
        }
    }

    public static void checkMonitorProductReportForNotNull(MonitorProductReport mpr) throws NonexistentMonitorProductReportException {
        if (mpr == null) {
            throw new NonexistentMonitorProductReportException();
        }
    }

}
