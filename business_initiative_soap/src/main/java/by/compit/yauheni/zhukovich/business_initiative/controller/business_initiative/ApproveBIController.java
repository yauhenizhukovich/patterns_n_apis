package by.compit.yauheni.zhukovich.business_initiative.controller.business_initiative;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddApproveByBusinessInitiativeRequest;
import org.example.AddApproveByBusinessInitiativeResponse;
import org.example.GetApprovesHistoryByBusinessInitiativeRequest;
import org.example.GetApprovesHistoryByBusinessInitiativeResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessInitiativeService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.APPROVE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ApproveBIController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessInitiativeService developmentBusinessInitiativeService;

    public ApproveBIController(DevelopmentBusinessInitiativeService developmentBusinessInitiativeService) {
        this.developmentBusinessInitiativeService = developmentBusinessInitiativeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addApproveByBusinessInitiativeRequest")
    @ResponsePayload
    public AddApproveByBusinessInitiativeResponse addApproveByBusinessInitiative(
            @RequestPayload AddApproveByBusinessInitiativeRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getApprove();
        Long id = request.getBusinessInitiativeId();
        AddApproveByBusinessInitiativeResponse response = new AddApproveByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(APPROVE_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessInitiativeService.add(onDevelopment, id);
            response.setAddedApprove(addedOnDevelopmentRec);
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getApprovesHistoryByBusinessInitiativeRequest")
    @ResponsePayload
    public GetApprovesHistoryByBusinessInitiativeResponse getApprovesHistoryByBusinessInitiative(
            @RequestPayload GetApprovesHistoryByBusinessInitiativeRequest request
    ) {
        Long id = request.getBusinessInitiativeId();
        GetApprovesHistoryByBusinessInitiativeResponse response = new GetApprovesHistoryByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> onApproves = developmentBusinessInitiativeService.getDevelopmentHistory(id, APPROVE_PHASE);
            TBIOnDevelopmentRec onApprovesRec = new TBIOnDevelopmentRec();
            onApprovesRec.getRecord().addAll(onApproves);
            response.setApproveHistory(onApprovesRec);
            return response;
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
