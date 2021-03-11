package by.compit.yauheni.zhukovich.business_initiative.controller.business_initiative;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddFamiliarizeByBusinessInitiativeRequest;
import org.example.AddFamiliarizeByBusinessInitiativeResponse;
import org.example.GetFamiliarizeHistoryByBusinessInitiativeRequest;
import org.example.GetFamiliarizeHistoryByBusinessInitiativeResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessInitiativeService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.FAMILIARIZE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class FamiliarizeBIController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessInitiativeService developmentBusinessInitiativeService;

    public FamiliarizeBIController(DevelopmentBusinessInitiativeService developmentBusinessInitiativeService) {
        this.developmentBusinessInitiativeService = developmentBusinessInitiativeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addFamiliarizeByBusinessInitiativeRequest")
    @ResponsePayload
    public AddFamiliarizeByBusinessInitiativeResponse addFamiliarizeByBusinessInitiative(
            @RequestPayload AddFamiliarizeByBusinessInitiativeRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getFamiliarize();
        Long biId = request.getBusinessInitiativeId();
        logger.info("Get business initiative with ID: " + biId + " to add familiarize.");
        AddFamiliarizeByBusinessInitiativeResponse response = new AddFamiliarizeByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            logger.info("Number of familiarize records to add: " + record.size());
            record.forEach(dev -> dev.setDevPhase(FAMILIARIZE_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessInitiativeService.add(onDevelopment, biId);
            logger.info("Familiarize records was successfully added.");
            response.setAddedFamiliarize(addedOnDevelopmentRec);
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + biId);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFamiliarizeHistoryByBusinessInitiativeRequest")
    @ResponsePayload
    public GetFamiliarizeHistoryByBusinessInitiativeResponse getFamiliarizeHistoryByBusinessInitiative(
            @RequestPayload GetFamiliarizeHistoryByBusinessInitiativeRequest request
    ) {
        Long id = request.getBusinessInitiativeId();
        GetFamiliarizeHistoryByBusinessInitiativeResponse response = new GetFamiliarizeHistoryByBusinessInitiativeResponse();
        try {
            List<TBIOnDevelopment> onFamiliarizes = developmentBusinessInitiativeService.getDevelopmentHistory(id, FAMILIARIZE_PHASE);
            TBIOnDevelopmentRec onFamiliarizesRec = new TBIOnDevelopmentRec();
            onFamiliarizesRec.getRecord().addAll(onFamiliarizes);
            response.setFamiliarizeHistory(onFamiliarizesRec);
            return response;
        } catch (NonexistentBusinessInitiativeException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
