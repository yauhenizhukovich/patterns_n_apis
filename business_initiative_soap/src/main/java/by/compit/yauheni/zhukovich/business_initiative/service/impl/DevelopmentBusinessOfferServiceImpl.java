package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessOfferRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.DevelopmentBusinessOfferRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.DevelopmentBusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBusinessOfferForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertCalendarToLocalDate;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer.DevelopmentBusinessOfferConversionUtil.convertDTOToDatabaseObject;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer.DevelopmentBusinessOfferConversionUtil.convertDatabaseObjectToDTO;

@Service
@Transactional
public class DevelopmentBusinessOfferServiceImpl implements DevelopmentBusinessOfferService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final BusinessOfferRepository businessOfferRepository;
    private final DevelopmentBusinessOfferRepository developmentBusinessOfferRepository;

    public DevelopmentBusinessOfferServiceImpl(
            BusinessOfferRepository businessOfferRepository,
            DevelopmentBusinessOfferRepository developmentBusinessOfferRepository
    ) {
        this.businessOfferRepository = businessOfferRepository;
        this.developmentBusinessOfferRepository = developmentBusinessOfferRepository;
    }

    @Override
    public TBIOnDevelopmentRec add(TBIOnDevelopmentRec onDevelopmentRec, Long id) throws NonexistentBusinessOfferException {
        BusinessOffer bo = businessOfferRepository.getById(id);
        checkBusinessOfferForNotNull(bo);
        List<DevelopmentBusinessOffer> onDevelopments = bo.getOnDevelopments();
        List<TBIOnDevelopment> onDevelopmentsDTO = onDevelopmentRec.getRecord();
        TBIOnDevelopmentRec addedOnDevelopmentRec = new TBIOnDevelopmentRec();
        for (TBIOnDevelopment onDevelopmentDTO : onDevelopmentsDTO) {
            DevelopmentBusinessOffer onDevelopment = convertDTOToDatabaseObject(onDevelopmentDTO);
            onDevelopment.setBusinessOffer(bo);
            onDevelopment = developmentBusinessOfferRepository.persist(onDevelopment);
            onDevelopments.add(onDevelopment);
            addedOnDevelopmentRec.getRecord().add(convertDatabaseObjectToDTO(onDevelopment));
        }
        logger.info("The \"on development(s)\" was successfully added to business offer with ID: " + id);
        return addedOnDevelopmentRec;
    }

    @Override
    public List<TBIOnDevelopment> getDevelopmentHistory(Long id, String devPhase) throws NonexistentBusinessOfferException {
        BusinessOffer bo = businessOfferRepository.getById(id);
        checkBusinessOfferForNotNull(bo);
        List<DevelopmentBusinessOffer> onDevelopments = bo.getOnDevelopments();
        List<TBIOnDevelopment> onDevelopmentsDTO = new ArrayList<>();
        for (DevelopmentBusinessOffer onDevelopment : onDevelopments) {
            if (onDevelopment.getDevPhase().equals(devPhase)) {
                TBIOnDevelopment onDevelopmentDTO = convertDatabaseObjectToDTO(onDevelopment);
                onDevelopmentsDTO.add(onDevelopmentDTO);
            }
        }
        return onDevelopmentsDTO;
    }

}
