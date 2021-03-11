package by.compit.yauheni.zhukovich.business_initiative.controller.business_offer;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddConfirmByBusinessOfferRequest;
import org.example.AddConfirmByBusinessOfferResponse;
import org.example.GetConfirmHistoryByBusinessOfferRequest;
import org.example.GetConfirmHistoryByBusinessOfferResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.CONFIRM_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ConfirmBOController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessOfferService developmentBusinessOfferService;

    public ConfirmBOController(DevelopmentBusinessOfferService developmentBusinessOfferService) {
        this.developmentBusinessOfferService = developmentBusinessOfferService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addConfirmByBusinessOfferRequest")
    @ResponsePayload
    public AddConfirmByBusinessOfferResponse addConfirmByBusinessOffer(
            @RequestPayload AddConfirmByBusinessOfferRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getConfirm();
        Long id = request.getBusinessOfferId();
        AddConfirmByBusinessOfferResponse response = new AddConfirmByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(CONFIRM_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessOfferService.add(onDevelopment, id);
            response.setAddedConfirm(addedOnDevelopmentRec);
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getConfirmHistoryByBusinessOfferRequest")
    @ResponsePayload
    public GetConfirmHistoryByBusinessOfferResponse getConfirmHistoryByBusinessOffer(
            @RequestPayload GetConfirmHistoryByBusinessOfferRequest request
    ) {
        Long id = request.getBusinessOfferId();
        GetConfirmHistoryByBusinessOfferResponse response = new GetConfirmHistoryByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> onConfirms = developmentBusinessOfferService.getDevelopmentHistory(id, CONFIRM_PHASE);
            TBIOnDevelopmentRec onConfirmsRec = new TBIOnDevelopmentRec();
            onConfirmsRec.getRecord().addAll(onConfirms);
            response.setConfirmHistory(onConfirmsRec);
            return response;
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
