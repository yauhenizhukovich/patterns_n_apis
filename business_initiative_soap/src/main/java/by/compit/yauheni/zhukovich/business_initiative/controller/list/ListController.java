package by.compit.yauheni.zhukovich.business_initiative.controller.list;

import java.util.List;

import org.example.GetBusinessInitiativesListResponse;
import org.example.GetComplexObjectByRecordIdRequest;
import org.example.GetComplexObjectByRecordIdResponse;
import org.example.GetListRecordByIdRequest;
import org.example.GetListRecordByIdResponse;
import org.example.GetListRecordsByPreliminaryMonitoringTermRequest;
import org.example.GetListRecordsByPreliminaryMonitoringTermResponse;
import org.example.GetListRecordsByProfitabilityRequest;
import org.example.GetListRecordsByProfitabilityResponse;
import org.example.TBankingProductCard;
import org.example.TBusinessInitiative;
import org.example.TBusinessOffer;
import org.example.TList;
import org.example.TListRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.ListService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBankingProductCardException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBusinessInitiativesListRequest")
    @ResponsePayload
    public GetBusinessInitiativesListResponse getBusinessInitiativesList() {
        GetBusinessInitiativesListResponse response = new GetBusinessInitiativesListResponse();
        List<TList> list = listService.getBusinessInitiativesList();
        TListRec listRec = new TListRec();
        listRec.getRecords().addAll(list);
        response.setList(listRec);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListRecordsByPreliminaryMonitoringTermRequest")
    @ResponsePayload
    public GetListRecordsByPreliminaryMonitoringTermResponse getListRecordsByPreliminaryMonitoringTerm(
            @RequestPayload GetListRecordsByPreliminaryMonitoringTermRequest request
    ) {
        TListRec listRec = new TListRec();
        List<TList> records = listService.getByPreliminaryMonitoringTerm();
        listRec.getRecords().addAll(records);
        GetListRecordsByPreliminaryMonitoringTermResponse response = new GetListRecordsByPreliminaryMonitoringTermResponse();
        response.setListRecords(listRec);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListRecordsByProfitabilityRequest")
    @ResponsePayload
    public GetListRecordsByProfitabilityResponse getListRecordsByProfitability(
            @RequestPayload GetListRecordsByProfitabilityRequest request
    ) {
        TListRec listRec = new TListRec();
        List<TList> records = listService.getByProfitability();
        listRec.getRecords().addAll(records);
        GetListRecordsByProfitabilityResponse response = new GetListRecordsByProfitabilityResponse();
        response.setListRecords(listRec);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getComplexObjectByRecordIdRequest")
    @ResponsePayload
    public GetComplexObjectByRecordIdResponse getComplexObjectByRecordId(
            @RequestPayload GetComplexObjectByRecordIdRequest request
    ) throws NonexistentBusinessInitiativeException, NonexistentBusinessOfferException, NonexistentBankingProductCardException {
        long recordId = request.getRecordId();
        TBusinessInitiative bi = listService.getBusinessInitiativeByRecordId(recordId);
        TBusinessOffer bo = listService.getBusinessOfferByRecordId(recordId);
        TBankingProductCard bpc = listService.getBankingProductCardByRecordId(recordId);
        GetComplexObjectByRecordIdResponse response = new GetComplexObjectByRecordIdResponse();
        response.setBankingProductCard(bpc);
        response.setBusinessInitiative(bi);
        response.setBusinessOffer(bo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListRecordByIdRequest")
    @ResponsePayload
    public GetListRecordByIdResponse getListRecordById(
            @RequestPayload GetListRecordByIdRequest request
    ) {
        long recordId = request.getRecordId();
        TList listRecord = listService.getRecordById(recordId);
        GetListRecordByIdResponse response = new GetListRecordByIdResponse();
        response.setListRecord(listRecord);
        return response;
    }

}
