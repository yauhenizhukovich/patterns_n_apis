package by.compit.yauheni.zhukovich.business_initiative.controller.business_initiative;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddConfirmCuratorByBusinessInitiativeRequest;
import org.example.AddConfirmCuratorByBusinessInitiativeResponse;
import org.example.GetConfirmCuratorHistoryByBusinessInitiativeRequest;
import org.example.GetConfirmCuratorHistoryByBusinessInitiativeResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessInitiativeService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_CURATOR_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ConfirmCuratorBIController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessInitiativeService developmentBusinessInitiativeService;

    public ConfirmCuratorBIController(DevelopmentBusinessInitiativeService developmentBusinessInitiativeService) {
        this.developmentBusinessInitiativeService = developmentBusinessInitiativeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addConfirmCuratorByBusinessInitiativeRequest")
    @ResponsePayload
    public AddConfirmCuratorByBusinessInitiativeResponse addConfirmCuratorByBusinessInitiative(
            @RequestPayload AddConfirmCuratorByBusinessInitiativeRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getConfirmCurator();
        Long id = request.getBusinessInitiativeId();
        AddConfirmCuratorByBusinessInitiativeResponse response = new AddConfirmCuratorByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(CONFIRM_CURATOR_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessInitiativeService.add(onDevelopment, id);
            response.setAddedConfirmCurator(addedOnDevelopmentRec);
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConfirmCuratorHistoryByBusinessInitiativeRequest")
    @ResponsePayload
    public GetConfirmCuratorHistoryByBusinessInitiativeResponse getConfirmCuratorHistoryByBusinessInitiative(
            @RequestPayload GetConfirmCuratorHistoryByBusinessInitiativeRequest request
    ) {
        Long id = request.getBusinessInitiativeId();
        GetConfirmCuratorHistoryByBusinessInitiativeResponse response = new GetConfirmCuratorHistoryByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> onCuratorConfirms = developmentBusinessInitiativeService.getDevelopmentHistory(id, CONFIRM_CURATOR_PHASE);
            TBIOnDevelopmentRec onCuratorConfirmsRec = new TBIOnDevelopmentRec();
            onCuratorConfirmsRec.getRecord().addAll(onCuratorConfirms);
            response.setConfirmCuratorHistory(onCuratorConfirmsRec);
            return response;
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
