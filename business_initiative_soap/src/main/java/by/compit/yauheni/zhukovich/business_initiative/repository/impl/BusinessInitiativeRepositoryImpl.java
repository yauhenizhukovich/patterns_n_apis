package by.compit.yauheni.zhukovich.business_initiative.repository.impl;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.business_initiative.repository.BusinessInitiativeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.BusinessInitiative;

@Repository
public class BusinessInitiativeRepositoryImpl extends GenericRepositoryImpl<Long, BusinessInitiative> implements BusinessInitiativeRepository {
}
