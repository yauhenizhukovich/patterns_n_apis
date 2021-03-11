package by.compit.yauheni.zhukovich.business_initiative.service;

import org.example.TMonitorProductReport;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentMonitorProductReportException;

public interface MonitorProductReportService {

    Long add(TMonitorProductReport monitorProductReport);

    TMonitorProductReport getById(Long id) throws NonexistentMonitorProductReportException;

    void updateById(TMonitorProductReport monitorProductReport, Long id) throws NonexistentMonitorProductReportException;

}
