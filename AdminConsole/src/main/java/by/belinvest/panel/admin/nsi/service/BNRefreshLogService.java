package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.DirectoryDTO;
import by.belinvest.panel.admin.entity.nsi.bn_refresh_log.BNRefreshLog;
import by.belinvest.panel.admin.nsi.db.BNRefreshLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BNRefreshLogService {
    @Autowired
    private BNRefreshLogRepository bnRefreshLogRepository;

    public DirectoryDTO get() {
        return bnRefreshLogRepository.get();
    }

    public boolean create(BNRefreshLog bnRefreshLog) {
        return bnRefreshLogRepository.create(bnRefreshLog);
    }

    public boolean update(BNRefreshLog bnRefreshLog) {
        return bnRefreshLogRepository.update(bnRefreshLog);
    }

    public boolean remove(String id) {
        return bnRefreshLogRepository.remove(id);
    }
}
