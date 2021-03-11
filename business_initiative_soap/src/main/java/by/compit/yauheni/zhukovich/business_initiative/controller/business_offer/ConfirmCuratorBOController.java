package by.compit.yauheni.zhukovich.business_initiative.controller.business_offer;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddConfirmCuratorByBusinessOfferRequest;
import org.example.AddConfirmCuratorByBusinessOfferResponse;
import org.example.GetConfirmCuratorHistoryByBusinessOfferRequest;
import org.example.GetConfirmCuratorHistoryByBusinessOfferResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_CURATOR_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ConfirmCuratorBOController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessOfferService developmentBusinessOfferService;

    public ConfirmCuratorBOController(DevelopmentBusinessOfferService developmentBusinessOfferService) {
        this.developmentBusinessOfferService = developmentBusinessOfferService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addConfirmCuratorByBusinessOfferRequest")
    @ResponsePayload
    public AddConfirmCuratorByBusinessOfferResponse addConfirmCuratorByBusinessOffer(
            @RequestPayload AddConfirmCuratorByBusinessOfferRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getConfirmCurator();
        Long id = request.getBusinessOfferId();
        AddConfirmCuratorByBusinessOfferResponse response = new AddConfirmCuratorByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(CONFIRM_CURATOR_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessOfferService.add(onDevelopment, id);
            response.setAddedConfirmCurator(addedOnDevelopmentRec);
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConfirmCuratorHistoryByBusinessOfferRequest")
    @ResponsePayload
    public GetConfirmCuratorHistoryByBusinessOfferResponse getConfirmCuratorHistoryByBusinessOffer(
            @RequestPayload GetConfirmCuratorHistoryByBusinessOfferRequest request
    ) {
        Long id = request.getBusinessOfferId();
        GetConfirmCuratorHistoryByBusinessOfferResponse response = new GetConfirmCuratorHistoryByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> onConfirms = developmentBusinessOfferService.getDevelopmentHistory(id, CONFIRM_CURATOR_PHASE);
            TBIOnDevelopmentRec onConfirmsRec = new TBIOnDevelopmentRec();
            onConfirmsRec.getRecord().addAll(onConfirms);
            response.setConfirmCuratorHistory(onConfirmsRec);
            return response;
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
