package by.compit.yauheni.zhukovich.business_initiative.controller.report;

import org.example.AddPaybackAssessmentReportRequest;
import org.example.AddPaybackAssessmentReportResponse;
import org.example.GetPaybackAssessmentReportByIdRequest;
import org.example.GetPaybackAssessmentReportByIdResponse;
import org.example.TPaybackAssessmentReport;
import org.example.UpdatePaybackAssessmentReportByIdRequest;
import org.example.UpdatePaybackAssessmentReportByIdResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.PaybackAssessmentReportService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentPaybackAssessmentReportException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class PaybackAssessmentReportController {

    private final PaybackAssessmentReportService paybackAssessmentReportService;

    public PaybackAssessmentReportController(PaybackAssessmentReportService paybackAssessmentReportService) {
        this.paybackAssessmentReportService = paybackAssessmentReportService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPaybackAssessmentReportRequest")
    @ResponsePayload
    public AddPaybackAssessmentReportResponse addPaybackAssessmentReport(
            @RequestPayload AddPaybackAssessmentReportRequest request
    ) {
        TPaybackAssessmentReport paybackAssessmentReport = request.getPaybackAssessmentReport();
        Long id = paybackAssessmentReportService.add(paybackAssessmentReport);
        AddPaybackAssessmentReportResponse response = new AddPaybackAssessmentReportResponse();
        response.setPaybackAssessmentReportId(id);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaybackAssessmentReportByIdRequest")
    @ResponsePayload
    public GetPaybackAssessmentReportByIdResponse getPaybackAssessmentReportById(
            @RequestPayload GetPaybackAssessmentReportByIdRequest request
    ) throws NonexistentPaybackAssessmentReportException {
        Long id = request.getPaybackAssessmentReportId();
        TPaybackAssessmentReport biDTO = paybackAssessmentReportService.getById(id);
        GetPaybackAssessmentReportByIdResponse response = new GetPaybackAssessmentReportByIdResponse();
        response.setPaybackAssessmentReport(biDTO);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePaybackAssessmentReportByIdRequest")
    @ResponsePayload
    public UpdatePaybackAssessmentReportByIdResponse updatePaybackAssessmentReportById(
            @RequestPayload UpdatePaybackAssessmentReportByIdRequest request
    ) throws NonexistentPaybackAssessmentReportException {
        TPaybackAssessmentReport paybackAssessmentReport = request.getPaybackAssessmentReport();
        Long id = request.getPaybackAssessmentReportId();
        paybackAssessmentReportService.updateById(paybackAssessmentReport, id);
        UpdatePaybackAssessmentReportByIdResponse response = new UpdatePaybackAssessmentReportByIdResponse();
        response.setMessage("The payback assessment report with ID: " + id + " was successfully updated.");
        return response;
    }

}
