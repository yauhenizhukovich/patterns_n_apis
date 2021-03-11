package by.compit.yauheni.zhukovich.business_initiative.service;

import java.util.List;

import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

public interface DevelopmentBusinessInitiativeService {

    TBIOnDevelopmentRec add(TBIOnDevelopmentRec onDevelopmentDTO, Long id) throws NonexistentBusinessInitiativeException;

    List<TBIOnDevelopment> getDevelopmentHistory(Long id, String devPhase) throws NonexistentBusinessInitiativeException;

}
