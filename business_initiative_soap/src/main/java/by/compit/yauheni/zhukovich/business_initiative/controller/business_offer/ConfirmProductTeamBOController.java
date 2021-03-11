package by.compit.yauheni.zhukovich.business_initiative.controller.business_offer;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddConfirmProductTeamByBusinessOfferRequest;
import org.example.AddConfirmProductTeamByBusinessOfferResponse;
import org.example.GetConfirmProductTeamHistoryByBusinessOfferRequest;
import org.example.GetConfirmProductTeamHistoryByBusinessOfferResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_PRODUCT_TEAM_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ConfirmProductTeamBOController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessOfferService developmentBusinessOfferService;

    public ConfirmProductTeamBOController(DevelopmentBusinessOfferService developmentBusinessOfferService) {
        this.developmentBusinessOfferService = developmentBusinessOfferService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addConfirmProductTeamByBusinessOfferRequest")
    @ResponsePayload
    public AddConfirmProductTeamByBusinessOfferResponse addConfirmProductTeamByBusinessOffer(
            @RequestPayload AddConfirmProductTeamByBusinessOfferRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getConfirmProductTeam();
        Long id = request.getBusinessOfferId();
        AddConfirmProductTeamByBusinessOfferResponse response = new AddConfirmProductTeamByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(CONFIRM_PRODUCT_TEAM_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessOfferService.add(onDevelopment, id);
            response.setAddedConfirmProductTeam(addedOnDevelopmentRec);
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConfirmProductTeamHistoryByBusinessOfferRequest")
    @ResponsePayload
    public GetConfirmProductTeamHistoryByBusinessOfferResponse getConfirmProductTeamHistoryByBusinessOffer(
            @RequestPayload GetConfirmProductTeamHistoryByBusinessOfferRequest request
    ) {
        Long id = request.getBusinessOfferId();
        GetConfirmProductTeamHistoryByBusinessOfferResponse response = new GetConfirmProductTeamHistoryByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> onConfirmProductTeams = developmentBusinessOfferService.getDevelopmentHistory(id,
                    CONFIRM_PRODUCT_TEAM_PHASE);
            TBIOnDevelopmentRec onConfirmProductTeamsRec = new TBIOnDevelopmentRec();
            onConfirmProductTeamsRec.getRecord().addAll(onConfirmProductTeams);
            response.setConfirmProductTeamHistory(onConfirmProductTeamsRec);
            return response;
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
