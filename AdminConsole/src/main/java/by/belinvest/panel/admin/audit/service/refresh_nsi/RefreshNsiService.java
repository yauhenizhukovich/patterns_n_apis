package by.belinvest.panel.admin.audit.service.refresh_nsi;

import by.belinvest.panel.admin.audit.db.refresh_nsi.RefreshNsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshNsiService {

    @Autowired
    private RefreshNsiRepository refreshNsiRepository;

    public void refreshNsi(){
        refreshNsiRepository.refreshNsi();
    }

}
