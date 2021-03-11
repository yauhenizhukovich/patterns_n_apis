package by.compit.yauheni.zhukovich.business_initiative.repository;

import java.util.List;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.ListBI;

public interface ListRepository extends GenericRepository<Long, ListBI> {

    ListBI getByBusinessInitiativeId(Long biId);

    ListBI getByBusinessOfferId(Long id);

    ListBI getByBankingProductCard(Long id);

}
