package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.lang.invoke.MethodHandles;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.TBankingProductCard;
import org.example.TUserInfo;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.BankingProductCardRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessOfferRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.HistoryChangeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.ListRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.ListBI;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.BankingProductCard;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.service.BankingProductCardService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBankingProductCardException;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.ListConversionUtil;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBankingProductCardForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.banking_product_card.BankingProductCardConversionUtil.convertDTOToDatabaseObject;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.banking_product_card.BankingProductCardConversionUtil.convertDatabaseObjectToDTO;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.banking_product_card.BankingProductCardConversionUtil.setDatabaseObjectByDTO;

@Service
@Transactional
public class BankingProductCardServiceImpl implements BankingProductCardService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final BankingProductCardRepository bankingProductCardRepository;
    private final BusinessOfferRepository businessOfferRepository;
    private final ListRepository listRepository;
    private final HistoryChangeRepository historyChangeRepository;

    public BankingProductCardServiceImpl(BankingProductCardRepository bankingProductCardRepository, BusinessOfferRepository businessOfferRepository, ListRepository listRepository, HistoryChangeRepository historyChangeRepository) {
        this.bankingProductCardRepository = bankingProductCardRepository;
        this.businessOfferRepository = businessOfferRepository;
        this.listRepository = listRepository;
        this.historyChangeRepository = historyChangeRepository;
    }

    @Override
    public Long add(TBankingProductCard bpcDTO) {
        BankingProductCard bpc = convertDTOToDatabaseObject(bpcDTO);
        bpc = bankingProductCardRepository.persist(bpc);
        String boId = bpcDTO.getBusinessOfferId();
        if (boId != null) {
            Long boIdNumber = Long.valueOf(boId);
            BusinessOffer bo = businessOfferRepository.getById(boIdNumber);
            ListBI listBI = listRepository.getByBusinessOfferId(boIdNumber);
            if (listBI != null && bo != null) {
                ListConversionUtil.updateByBankingProductCard(bpc, listBI);
            }
        }
        logger.info("The banking product card was successfully added.");
        return bpc.getId();
    }

    @Override
    public TBankingProductCard getById(Long id) throws NonexistentBankingProductCardException {
        BankingProductCard bpc = bankingProductCardRepository.getById(id);
        checkBankingProductCardForNotNull(bpc);
        TBankingProductCard bpcDTO = convertDatabaseObjectToDTO(bpc);
        Long bankingProductCardId = bpc.getId();
        if (bankingProductCardId != null) {
            ListBI record = listRepository.getByBankingProductCard(bankingProductCardId);
            if (record != null) {
                Long businessOfferId = record.getBoId();
                if (businessOfferId != null) {
                    bpcDTO.setBusinessOfferId(String.valueOf(businessOfferId));
                }
            }
        }
        return bpcDTO;
    }

    @Override
    public void updateById(TBankingProductCard bpcDTO, Long id) throws NonexistentBankingProductCardException {
        TUserInfo userInfo = bpcDTO.getUserInfo();
        if (userInfo != null) {
            historyChangeRepository.initUser(userInfo);
        }
        BankingProductCard bpc = bankingProductCardRepository.getById(id);
        checkBankingProductCardForNotNull(bpc);
        setDatabaseObjectByDTO(bpcDTO, bpc);
        ListBI listBI = listRepository.getByBankingProductCard(id);
        if (listBI != null) {
            ListConversionUtil.setDatabaseObjectByDTO(bpc, listBI);
        }
        logger.info("The banking product card with ID: " + id + " was successfully updated.");
    }

}
