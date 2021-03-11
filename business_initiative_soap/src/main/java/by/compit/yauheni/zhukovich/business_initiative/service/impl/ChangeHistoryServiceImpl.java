package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.example.TChangesHistory;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.ChangeHistoryRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.change_history.HistoryChange;
import by.compit.yauheni.zhukovich.business_initiative.service.ChangeHistoryService;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.DateUtil.convertLocalDateToCalendar;

@Service
@Transactional
public class ChangeHistoryServiceImpl implements ChangeHistoryService {

    private final ChangeHistoryRepository changeHistoryRepository;

    public ChangeHistoryServiceImpl(ChangeHistoryRepository changeHistoryRepository) {
        this.changeHistoryRepository = changeHistoryRepository;
    }

    @Override
    public List<TChangesHistory> getChangesHistoryById(Long id) {
        List<HistoryChange> changesHistories = changeHistoryRepository.getByIdAndType(id, 1);
        return changesHistories.stream()
                .map(this::convertDatabaseObjectToDTO)
                .collect(Collectors.toList());
    }

    private TChangesHistory convertDatabaseObjectToDTO(HistoryChange change) {
        TChangesHistory changeDTO = new TChangesHistory();
        changeDTO.setAttributeName(change.getAttributeName());
        changeDTO.setAttributeValueChanged(change.getValueNew());
        changeDTO.setAttributeValuePrev(change.getValueOld());
        changeDTO.setChangingDate(convertLocalDateToCalendar(change.getChangeDate()));
        changeDTO.setUser(change.getUsername());
        return changeDTO;
    }

}
