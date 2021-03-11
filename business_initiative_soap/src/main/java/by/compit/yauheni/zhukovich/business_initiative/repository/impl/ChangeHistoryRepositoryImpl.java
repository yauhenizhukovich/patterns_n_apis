package by.compit.yauheni.zhukovich.business_initiative.repository.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.compit.yauheni.zhukovich.business_initiative.repository.ChangeHistoryRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.change_history.HistoryChange;

@Repository
public class ChangeHistoryRepositoryImpl extends GenericRepositoryImpl<Long, HistoryChange> implements ChangeHistoryRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<HistoryChange> getByIdAndType(Long id, Integer type) {
        Query query = entityManager.createNativeQuery(
                "SELECT ATTR_NAME, CHANGE_DATE, VALUE_OLD, VALUE_NEW, USER_NAME FROM HISTORY_CHANGE WHERE ID=? AND CTL_TYPE=? ORDER BY CHANGE_DATE DESC "
        );
        query.setParameter(1, id);
        query.setParameter(2, type);
        List resultList = query.getResultList();
        List<HistoryChange> changes = new ArrayList<>();
        for (Object resultRow : resultList) {
            Object[] resultObjects = (Object[]) resultRow;
            HistoryChange change = new HistoryChange();
            change.setAttributeName((String) resultObjects[0]);
            Timestamp date = (Timestamp) resultObjects[1];
            change.setChangeDate(date.toLocalDateTime().toLocalDate());
            change.setValueOld((String) resultObjects[2]);
            change.setValueNew((String) resultObjects[3]);
            change.setUsername((String) resultObjects[4]);
            changes.add(change);
        }
        return changes;
    }

}
