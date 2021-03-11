package by.compit.yauheni.zhukovich.business_initiative.controller.business_initiative;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddConfirmByBusinessInitiativeRequest;
import org.example.AddConfirmByBusinessInitiativeResponse;
import org.example.GetConfirmHistoryByBusinessInitiativeRequest;
import org.example.GetConfirmHistoryByBusinessInitiativeResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessInitiativeService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ConfirmBIController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessInitiativeService developmentBusinessInitiativeService;

    public ConfirmBIController(DevelopmentBusinessInitiativeService developmentBusinessInitiativeService) {
        this.developmentBusinessInitiativeService = developmentBusinessInitiativeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addConfirmByBusinessInitiativeRequest")
    @ResponsePayload
    public AddConfirmByBusinessInitiativeResponse addConfirmByBusinessInitiative(
            @RequestPayload AddConfirmByBusinessInitiativeRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getConfirm();
        Long id = request.getBusinessInitiativeId();
        AddConfirmByBusinessInitiativeResponse response = new AddConfirmByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(CONFIRM_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessInitiativeService.add(onDevelopment, id);
            response.setAddedConfirm(addedOnDevelopmentRec);
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConfirmHistoryByBusinessInitiativeRequest")
    @ResponsePayload
    public GetConfirmHistoryByBusinessInitiativeResponse getConfirmHistoryByBusinessInitiative(
            @RequestPayload GetConfirmHistoryByBusinessInitiativeRequest request
    ) {
        Long id = request.getBusinessInitiativeId();
        GetConfirmHistoryByBusinessInitiativeResponse response = new GetConfirmHistoryByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> onConfirms = developmentBusinessInitiativeService.getDevelopmentHistory(id, CONFIRM_PHASE);
            TBIOnDevelopmentRec onConfirmsRec = new TBIOnDevelopmentRec();
            onConfirmsRec.getRecord().addAll(onConfirms);
            response.setConfirmHistory(onConfirmsRec);
            return response;
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
