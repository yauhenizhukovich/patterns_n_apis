package by.compit.yauheni.zhukovich.business_initiative.service;

import java.util.List;

import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

public interface DevelopmentBusinessOfferService {

    TBIOnDevelopmentRec add(TBIOnDevelopmentRec onDevelopment, Long id) throws NonexistentBusinessOfferException;

    List<TBIOnDevelopment> getDevelopmentHistory(Long id, String devPhase) throws NonexistentBusinessOfferException;

}
