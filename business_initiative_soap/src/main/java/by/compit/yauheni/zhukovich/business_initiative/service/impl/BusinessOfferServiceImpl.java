package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.lang.invoke.MethodHandles;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.TBusinessOffer;
import org.example.TUserInfo;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessInitiativeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessOfferRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.HistoryChangeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.ListRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.ListBI;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.service.BusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.ListConversionUtil;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer.BusinessOfferConversionUtil;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBusinessOfferForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer.BusinessOfferConversionUtil.convertDatabaseObjectToDTO;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer.BusinessOfferConversionUtil.setDatabaseObjectByDTO;

@Service
@Transactional
public class BusinessOfferServiceImpl implements BusinessOfferService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final BusinessOfferRepository businessOfferRepository;
    private final ListRepository listRepository;
    private final BusinessInitiativeRepository businessInitiativeRepository;
    private final HistoryChangeRepository historyChangeRepository;

    public BusinessOfferServiceImpl(
            BusinessOfferRepository businessOfferRepository,
            ListRepository listRepository,
            BusinessInitiativeRepository businessInitiativeRepository, HistoryChangeRepository historyChangeRepository) {
        this.businessOfferRepository = businessOfferRepository;
        this.listRepository = listRepository;
        this.businessInitiativeRepository = businessInitiativeRepository;
        this.historyChangeRepository = historyChangeRepository;
    }

    @Override
    public Long add(TBusinessOffer boDTO) {
        BusinessOffer bo = BusinessOfferConversionUtil.convertDTOToDatabaseObject(boDTO);
        bo = businessOfferRepository.persist(bo);
        String biId = boDTO.getBusinessInitiativeId();
        if (biId != null) {
            Long biIdNumber = Long.valueOf(biId);
            BusinessInitiative bi = businessInitiativeRepository.getById(biIdNumber);
            ListBI listBI = listRepository.getByBusinessInitiativeId(biIdNumber);
            if (listBI != null && bi != null) {
                ListConversionUtil.updateByBusinessOffer(bo, bi, listBI);
            }
        }
        logger.info("The business offer was successfully added.");
        return bo.getId();
    }

    @Override
    public TBusinessOffer getById(Long id) throws NonexistentBusinessOfferException {
        BusinessOffer bo = businessOfferRepository.getById(id);
        checkBusinessOfferForNotNull(bo);
        TBusinessOffer boDTO = convertDatabaseObjectToDTO(bo);
        Long businessOfferId = bo.getId();
        if (businessOfferId != null) {
            ListBI record = listRepository.getByBusinessOfferId(businessOfferId);
            if (record != null) {
                Long businessInitiativeId = record.getBiId();
                if (businessInitiativeId != null) {
                    boDTO.setBusinessInitiativeId(String.valueOf(businessInitiativeId));
                }
            }
        }
        return boDTO;
    }

    @Override
    public void updateById(TBusinessOffer boDTO, Long id) throws NonexistentBusinessOfferException {
        TUserInfo userInfo = boDTO.getUserInfo();
        if (userInfo != null) {
            historyChangeRepository.initUser(userInfo);
        }
        BusinessOffer bo = businessOfferRepository.getById(id);
        checkBusinessOfferForNotNull(bo);
        setDatabaseObjectByDTO(boDTO, bo);
        ListBI listBI = listRepository.getByBusinessOfferId(id);
        if (listBI != null) {
            ListConversionUtil.setDatabaseObjectByDTO(bo, listBI);
        }
        logger.info("The business offer with ID: " + id + " was successfully updated.");
    }

}
