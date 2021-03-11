package by.compit.yauheni.zhukovich.entity_to_docx.service;

import by.compit.yauheni.zhukovich.entity_to_docx.service.exception.NonexistentBusinessOfferException;
import by.compit.yauheni.zhukovich.entity_to_docx.service.model.BusinessOfferDTO;

public interface BusinessOfferService {

    BusinessOfferDTO getById(Long id) throws NonexistentBusinessOfferException;

}
