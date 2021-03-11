package by.belinvest.panel.admin.audit.service.refresh_nsi;

import by.belinvest.panel.admin.audit.db.refresh_nsi.LastUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LastUpdateService {

    @Autowired
    private LastUpdateRepository lastUpdateRepository;

    public Map<String, String> getLastUpdateDate(){
        return lastUpdateRepository.getLastUpdateDate();
    }

}
