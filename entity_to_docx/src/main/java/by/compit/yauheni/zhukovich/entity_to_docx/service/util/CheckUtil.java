package by.compit.yauheni.zhukovich.entity_to_docx.service.util;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.entity_to_docx.service.exception.NonexistentBusinessOfferException;

public class CheckUtil {
    public static void checkBusinessOfferForNotNull(BusinessOffer bo) throws NonexistentBusinessOfferException {
        if (bo == null) {
            throw new NonexistentBusinessOfferException();
        }
    }
}
