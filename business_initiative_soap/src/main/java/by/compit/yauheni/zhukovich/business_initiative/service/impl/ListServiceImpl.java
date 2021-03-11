package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.example.TBankingProductCard;
import org.example.TBusinessInitiative;
import org.example.TBusinessOffer;
import org.example.TList;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.BankingProductCardRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessInitiativeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessOfferRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.ListRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.ListBI;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.BankingProductCard;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.BusinessOffer;
import by.compit.yauheni.zhukovich.business_initiative.service.ListService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBankingProductCardException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.ListConversionUtil;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.banking_product_card.BankingProductCardConversionUtil;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative.BusinessInitiativeConversionUtil;
import by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer.BusinessOfferConversionUtil;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBankingProductCardForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBusinessInitiativeForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkBusinessOfferForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.ListConversionUtil.convertDatabaseObjectToDTO;

@Service
@Transactional
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;
    private final BusinessOfferRepository businessOfferRepository;
    private final BankingProductCardRepository bankingProductCardRepository;
    private final BusinessInitiativeRepository businessInitiativeRepository;

    public ListServiceImpl(
            ListRepository listRepository,
            BusinessOfferRepository businessOfferRepository,
            BankingProductCardRepository bankingProductCardRepository, BusinessInitiativeRepository businessInitiativeRepository) {
        this.listRepository = listRepository;
        this.businessOfferRepository = businessOfferRepository;
        this.bankingProductCardRepository = bankingProductCardRepository;
        this.businessInitiativeRepository = businessInitiativeRepository;
    }

    @Override
    public List<TList> getBusinessInitiativesList() {
        List<ListBI> list = listRepository.getAll();
        return list.stream()
                .map(ListConversionUtil::convertDatabaseObjectToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TList> getByPreliminaryMonitoringTerm() {
        List<Long> ids = businessOfferRepository.getByPreliminaryMonitoringTerm(LocalDate.now());
        return ids.stream()
                .map(listRepository::getByBusinessOfferId)
                .filter(Objects::nonNull)
                .map(ListConversionUtil::convertDatabaseObjectToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TList> getByProfitability() {
        List<Long> ids = businessOfferRepository.getByProfitability(LocalDate.now());
        return ids.stream()
                .map(listRepository::getByBusinessOfferId)
                .filter(Objects::nonNull)
                .map(ListConversionUtil::convertDatabaseObjectToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TBankingProductCard getBankingProductCardByRecordId(long recordId) throws NonexistentBankingProductCardException {
        ListBI record = listRepository.getById(recordId);
        if (record != null) {
            Long bpcId = record.getBpcId();
            if (bpcId != null) {
                BankingProductCard bpc = bankingProductCardRepository.getById(bpcId);
                checkBankingProductCardForNotNull(bpc);
                return BankingProductCardConversionUtil.convertDatabaseObjectToDTO(bpc);
            }
        }
        return null;
    }

    @Override
    public TBusinessInitiative getBusinessInitiativeByRecordId(long recordId) throws NonexistentBusinessInitiativeException {
        ListBI record = listRepository.getById(recordId);
        if (record != null) {
            Long biId = record.getBiId();
            if (biId != null) {
                BusinessInitiative bi = businessInitiativeRepository.getById(biId);
                checkBusinessInitiativeForNotNull(bi);
                return BusinessInitiativeConversionUtil.convertDatabaseObjectToDTO(bi);
            }
        }
        return null;
    }

    @Override
    public TBusinessOffer getBusinessOfferByRecordId(long recordId) throws NonexistentBusinessOfferException {
        ListBI record = listRepository.getById(recordId);
        if (record != null) {
            Long boId = record.getBoId();
            if (boId != null) {
                BusinessOffer bo = businessOfferRepository.getById(boId);
                checkBusinessOfferForNotNull(bo);
                return BusinessOfferConversionUtil.convertDatabaseObjectToDTO(bo);
            }
        }
        return null;
    }

    @Override
    public TList getRecordById(long recordId) {
        ListBI record = listRepository.getById(recordId);
        if (record != null) {
            return convertDatabaseObjectToDTO(record);
        }
        return null;
    }

}
