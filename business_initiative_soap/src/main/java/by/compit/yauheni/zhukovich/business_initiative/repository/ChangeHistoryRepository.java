package by.compit.yauheni.zhukovich.business_initiative.repository;

import java.util.List;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.change_history.HistoryChange;

public interface ChangeHistoryRepository extends GenericRepository<Long, HistoryChange> {

    @SuppressWarnings("unchecked")
    List<HistoryChange> getByIdAndType(Long id, Integer type);

}
