package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.lang.invoke.MethodHandles;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.TPaybackAssessmentReport;
import org.example.TUserInfo;
import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.repository.HistoryChangeRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.PaybackAssessmentReportRepository;
import by.compit.yauheni.zhukovich.business_initiative.repository.model.report.PaybackAssessmentReport;
import by.compit.yauheni.zhukovich.business_initiative.service.PaybackAssessmentReportService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentPaybackAssessmentReportException;

import static by.compit.yauheni.zhukovich.business_initiative.service.util.CheckUtil.checkPaybackAssessmentReportForNotNull;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report.PaybackAssessmentReportConversionUtil.convertDTOToDatabaseObject;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report.PaybackAssessmentReportConversionUtil.convertDatabaseObjectToDTO;
import static by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.report.PaybackAssessmentReportConversionUtil.setDatabaseObjectByDTO;

@Service
@Transactional
public class PaybackAssessmentReportServiceImpl implements PaybackAssessmentReportService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final PaybackAssessmentReportRepository paybackAssessmentReportRepository;
    private final HistoryChangeRepository historyChangeRepository;

    public PaybackAssessmentReportServiceImpl(PaybackAssessmentReportRepository paybackAssessmentReportRepository, HistoryChangeRepository historyChangeRepository) {
        this.paybackAssessmentReportRepository = paybackAssessmentReportRepository;
        this.historyChangeRepository = historyChangeRepository;
    }

    @Override
    public Long add(TPaybackAssessmentReport parDTO) {
        PaybackAssessmentReport par = convertDTOToDatabaseObject(parDTO);
        par = paybackAssessmentReportRepository.persist(par);
        logger.info("The payment assessment report was successfully added.");
        return par.getId();
    }

    @Override
    public TPaybackAssessmentReport getById(Long id) throws NonexistentPaybackAssessmentReportException {
        PaybackAssessmentReport par = paybackAssessmentReportRepository.getById(id);
        checkPaybackAssessmentReportForNotNull(par);
        return convertDatabaseObjectToDTO(par);
    }

    @Override
    public void updateById(TPaybackAssessmentReport parDTO, Long id) throws NonexistentPaybackAssessmentReportException {
        TUserInfo userInfo = parDTO.getUserInfo();
        if (userInfo != null) {
            historyChangeRepository.initUser(userInfo);
        }
        PaybackAssessmentReport par = paybackAssessmentReportRepository.getById(id);
        checkPaybackAssessmentReportForNotNull(par);
        setDatabaseObjectByDTO(parDTO, par);
        logger.info("The payment assessment report with ID: " + id + " was successfully updated.");
    }

}
