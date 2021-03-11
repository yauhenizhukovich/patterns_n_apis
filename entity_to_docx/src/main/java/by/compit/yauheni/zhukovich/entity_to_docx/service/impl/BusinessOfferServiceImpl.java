package by.compit.yauheni.zhukovich.entity_to_docx.service.impl;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.entity_to_docx.service.BusinessOfferService;
import by.compit.yauheni.zhukovich.entity_to_docx.service.exception.NonexistentBusinessOfferException;
import by.compit.yauheni.zhukovich.entity_to_docx.repository.BusinessOfferRepository;
import by.compit.yauheni.zhukovich.entity_to_docx.service.model.BusinessOfferDTO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.invoke.MethodHandles;

import static by.compit.yauheni.zhukovich.entity_to_docx.service.util.CheckUtil.checkBusinessOfferForNotNull;
import static by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer.BusinessOfferConversionUtil.convertDatabaseObjectToDTO;

@Service
@Transactional
public class BusinessOfferServiceImpl implements BusinessOfferService {

    private final BusinessOfferRepository businessOfferRepository;

    public BusinessOfferServiceImpl(BusinessOfferRepository businessOfferRepository) {
        this.businessOfferRepository = businessOfferRepository;
    }

    @Override
    public BusinessOfferDTO getById(Long id) throws NonexistentBusinessOfferException {
        BusinessOffer bo = businessOfferRepository.getById(id);
        checkBusinessOfferForNotNull(bo);
        return convertDatabaseObjectToDTO(bo);
    }
}
