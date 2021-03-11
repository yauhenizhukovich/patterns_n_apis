package by.compit.yauheni.zhukovich.business_initiative.controller.report;

import org.example.AddMonitorProductReportRequest;
import org.example.AddMonitorProductReportResponse;
import org.example.GetMonitorProductReportByIdRequest;
import org.example.GetMonitorProductReportByIdResponse;
import org.example.TMonitorProductReport;
import org.example.UpdateMonitorProductReportByIdRequest;
import org.example.UpdateMonitorProductReportByIdResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.MonitorProductReportService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentMonitorProductReportException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class MonitorProductReportController {

    private final MonitorProductReportService monitorProductReportService;

    public MonitorProductReportController(MonitorProductReportService monitorProductReportService) {
        this.monitorProductReportService = monitorProductReportService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMonitorProductReportRequest")
    @ResponsePayload
    public AddMonitorProductReportResponse addMonitorProductReport(
            @RequestPayload AddMonitorProductReportRequest request
    ) {
        TMonitorProductReport monitorProductReport = request.getMonitorProductReport();
        Long id = monitorProductReportService.add(monitorProductReport);
        AddMonitorProductReportResponse response = new AddMonitorProductReportResponse();
        response.setMonitorProductReportId(id);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMonitorProductReportByIdRequest")
    @ResponsePayload
    public GetMonitorProductReportByIdResponse getMonitorProductReportById(
            @RequestPayload GetMonitorProductReportByIdRequest request
    ) throws NonexistentMonitorProductReportException {
        Long id = request.getMonitorProductReportId();
        TMonitorProductReport biDTO = monitorProductReportService.getById(id);
        GetMonitorProductReportByIdResponse response = new GetMonitorProductReportByIdResponse();
        response.setMonitorProductReport(biDTO);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateMonitorProductReportByIdRequest")
    @ResponsePayload
    public UpdateMonitorProductReportByIdResponse updateMonitorProductReportById(
            @RequestPayload UpdateMonitorProductReportByIdRequest request
    ) throws NonexistentMonitorProductReportException {
        TMonitorProductReport monitorProductReport = request.getMonitorProductReport();
        Long id = request.getMonitorProductReportId();
        monitorProductReportService.updateById(monitorProductReport, id);
        UpdateMonitorProductReportByIdResponse response = new UpdateMonitorProductReportByIdResponse();
        response.setMessage("The monitor product report with ID: " + id + " was successfully updated.");
        return response;
    }

}
