package by.compit.yauheni.zhukovich.nsi_product.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.nsi_product.repository.BankingProductCardRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.ListRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.BankingProductCard;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.ListBI;
import by.compit.yauheni.zhukovich.nsi_product.service.BankingProductCardService;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NullEntityException;

@Service
@Transactional
public class BankingProductCardServiceImpl implements BankingProductCardService {

    private final BankingProductCardRepository bankingProductCardRepository;
    private final ListRepository listRepository;

    public BankingProductCardServiceImpl(BankingProductCardRepository bankingProductCardRepository, ListRepository listRepository) {
        this.bankingProductCardRepository = bankingProductCardRepository;
        this.listRepository = listRepository;
    }

    @Override
    public void updateStatusById(String id, String status) throws NullEntityException {
        Long longId = Long.valueOf(id);
        BankingProductCard bankingProductCard = bankingProductCardRepository.getById(longId);
        if (bankingProductCard != null) {
            bankingProductCard.setProductStatus(status);
        } else {
            throw new NullEntityException("Статус продукта не может быть обновлен, так как карточка банковского продукта отсутствует.");
        }
        ListBI listRecord = listRepository.getByBankingProductCardId(id);
        listRecord.setProductStatus(status);
    }

}
