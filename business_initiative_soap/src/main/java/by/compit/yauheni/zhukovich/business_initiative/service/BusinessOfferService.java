package by.compit.yauheni.zhukovich.business_initiative.service;

import org.example.TBusinessOffer;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

public interface BusinessOfferService {

    Long add(TBusinessOffer bo);

    TBusinessOffer getById(Long id) throws NonexistentBusinessOfferException;

    void updateById(TBusinessOffer bo, Long id) throws NonexistentBusinessOfferException;

}
