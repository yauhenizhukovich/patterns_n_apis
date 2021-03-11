package by.compit.yauheni.zhukovich.business_initiative.service;

import java.util.List;

import org.example.TChangesHistory;

public interface ChangeHistoryService {

    List<TChangesHistory> getChangesHistoryById(Long id);

}
