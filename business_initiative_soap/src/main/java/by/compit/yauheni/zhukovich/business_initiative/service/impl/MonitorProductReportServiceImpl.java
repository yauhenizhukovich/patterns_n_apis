package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.lang.invoke.MethodHandles;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.TMonitorProductReport;
import org.example.TUserInfo;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.HistoryChangeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.MonitorProductReportRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.MonitorProductReport;
import by.compit.yauheni.zhukovich.business_initiative.service.MonitorProductReportService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentMonitorProductReportException;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkMonitorProductReportForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report.MonitorProductReportConversionUtil.convertDTOToDatabaseObject;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report.MonitorProductReportConversionUtil.convertDatabaseObjectToDTO;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report.MonitorProductReportConversionUtil.setDatabaseObjectByDTO;

@Service
@Transactional
public class MonitorProductReportServiceImpl implements MonitorProductReportService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final MonitorProductReportRepository monitorProductReportRepository;
    private final HistoryChangeRepository historyChangeRepository;

    public MonitorProductReportServiceImpl(MonitorProductReportRepository monitorProductReportRepository, HistoryChangeRepository historyChangeRepository) {
        this.monitorProductReportRepository = monitorProductReportRepository;
        this.historyChangeRepository = historyChangeRepository;
    }

    @Override
    public Long add(TMonitorProductReport mprDTO) {
        MonitorProductReport mpr = convertDTOToDatabaseObject(mprDTO);
        mpr = monitorProductReportRepository.persist(mpr);
        logger.info("The monitor product report was successfully added.");
        return mpr.getId();
    }

    @Override
    public TMonitorProductReport getById(Long id) throws NonexistentMonitorProductReportException {
        MonitorProductReport par = monitorProductReportRepository.getById(id);
        checkMonitorProductReportForNotNull(par);
        return convertDatabaseObjectToDTO(par);
    }

    @Override
    public void updateById(TMonitorProductReport parDTO, Long id) throws NonexistentMonitorProductReportException {
        TUserInfo userInfo = parDTO.getUserInfo();
        if (userInfo != null) {
            historyChangeRepository.initUser(userInfo);
        }
        MonitorProductReport par = monitorProductReportRepository.getById(id);
        checkMonitorProductReportForNotNull(par);
        setDatabaseObjectByDTO(parDTO, par);
        logger.info("The monitor product report with ID: " + id + " was successfully updated.");
    }

}
