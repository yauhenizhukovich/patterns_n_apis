package by.compit.yauheni.zhukovich.business_initiative.service;

import org.example.TBusinessInitiative;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

public interface BusinessInitiativeService {

    Long add(TBusinessInitiative businessInitiative);

    TBusinessInitiative getById(Long id) throws NonexistentBusinessInitiativeException;

    void updateById(TBusinessInitiative businessInitiative, Long id) throws NonexistentBusinessInitiativeException;

}
