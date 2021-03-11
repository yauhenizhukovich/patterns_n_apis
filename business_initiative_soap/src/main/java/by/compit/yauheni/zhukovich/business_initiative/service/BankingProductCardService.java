package by.compit.yauheni.zhukovich.business_initiative.service;

import org.example.TBankingProductCard;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBankingProductCardException;

public interface BankingProductCardService {

    Long add(TBankingProductCard bpc);

    TBankingProductCard getById(Long id) throws NonexistentBankingProductCardException;

    void updateById(TBankingProductCard bpc, Long id) throws NonexistentBankingProductCardException;


}
