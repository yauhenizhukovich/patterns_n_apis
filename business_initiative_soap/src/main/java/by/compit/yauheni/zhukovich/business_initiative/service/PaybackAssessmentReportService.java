package by.compit.yauheni.zhukovich.business_initiative.service;

import org.example.TPaybackAssessmentReport;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentPaybackAssessmentReportException;

public interface PaybackAssessmentReportService {

    Long add(TPaybackAssessmentReport paybackAssessmentReport);

    TPaybackAssessmentReport getById(Long id) throws NonexistentPaybackAssessmentReportException;

    void updateById(TPaybackAssessmentReport paybackAssessmentReport, Long id) throws NonexistentPaybackAssessmentReportException;

}
