package by.compit.yauheni.zhukovich.business_initiative.service;

import java.util.List;

import org.example.TBankingProductCard;
import org.example.TBusinessInitiative;
import org.example.TBusinessOffer;
import org.example.TList;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBankingProductCardException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

public interface ListService {

    List<TList> getBusinessInitiativesList();

    List<TList> getByPreliminaryMonitoringTerm();

    List<TList> getByProfitability();

    TBankingProductCard getBankingProductCardByRecordId(long recordId) throws NonexistentBankingProductCardException;

    TBusinessInitiative getBusinessInitiativeByRecordId(long recordId) throws NonexistentBusinessInitiativeException;

    TBusinessOffer getBusinessOfferByRecordId(long recordId) throws NonexistentBusinessOfferException;

    TList getRecordById(long recordId);

}
