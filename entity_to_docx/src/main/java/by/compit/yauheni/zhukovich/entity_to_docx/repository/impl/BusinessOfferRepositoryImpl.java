package by.compit.yauheni.zhukovich.entity_to_docx.repository.impl;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.BusinessOfferRepository;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BusinessOffer;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessOfferRepositoryImpl extends GenericRepositoryImpl<Long, BusinessOffer> implements BusinessOfferRepository {
}
