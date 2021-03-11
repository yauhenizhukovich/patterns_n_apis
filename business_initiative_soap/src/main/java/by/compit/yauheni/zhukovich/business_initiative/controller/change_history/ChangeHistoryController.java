package by.compit.yauheni.zhukovich.business_initiative.controller.change_history;

import java.util.List;

import org.example.GetChangesHistoryByBusinessInitiativeRequest;
import org.example.GetChangesHistoryByBusinessInitiativeResponse;
import org.example.TChangesHistory;
import org.example.TChangesHistoryRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.ChangeHistoryService;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ChangeHistoryController {

    private final ChangeHistoryService changeHistoryService;

    public ChangeHistoryController(ChangeHistoryService changeHistoryService) {
        this.changeHistoryService = changeHistoryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getChangesHistoryByBusinessInitiativeRequest")
    @ResponsePayload
    public GetChangesHistoryByBusinessInitiativeResponse getChangesHistoryByBusinessInitiative(
            @RequestPayload GetChangesHistoryByBusinessInitiativeRequest request
    ) {
        Long id = request.getBusinessInitiativeId();
        GetChangesHistoryByBusinessInitiativeResponse response = new GetChangesHistoryByBusinessInitiativeResponse();
        List<TChangesHistory> changesHistories = changeHistoryService.getChangesHistoryById(id);
        TChangesHistoryRec changesHistoryRec = new TChangesHistoryRec();
        changesHistoryRec.getRecords().addAll(changesHistories);
        response.setChangesHistory(changesHistoryRec);
        return response;
    }

}
