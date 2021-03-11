package by.compit.yauheni.zhukovich.business_initiative.repository.impl;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.business_initiative.repository.BankingProductCardRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.banking_product_card.BankingProductCard;

@Repository
public class BankingProductCardRepositoryImpl extends GenericRepositoryImpl<Long, BankingProductCard> implements BankingProductCardRepository {
}
