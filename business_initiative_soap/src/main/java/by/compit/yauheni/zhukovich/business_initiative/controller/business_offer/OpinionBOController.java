package by.compit.yauheni.zhukovich.business_initiative.controller.business_offer;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddOpinionByBusinessOfferRequest;
import org.example.AddOpinionByBusinessOfferResponse;
import org.example.GetOpinionHistoryByBusinessOfferRequest;
import org.example.GetOpinionHistoryByBusinessOfferResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.OPINION_PHASE;

@Endpoint
public class OpinionBOController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessOfferService developmentBusinessOfferService;

    public OpinionBOController(DevelopmentBusinessOfferService developmentBusinessOfferService) {
        this.developmentBusinessOfferService = developmentBusinessOfferService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addOpinionByBusinessOfferRequest")
    @ResponsePayload
    public AddOpinionByBusinessOfferResponse addOpinionByBusinessOffer(
            @RequestPayload AddOpinionByBusinessOfferRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getOpinion();
        Long id = request.getBusinessOfferId();
        AddOpinionByBusinessOfferResponse response = new AddOpinionByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(OPINION_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessOfferService.add(onDevelopment, id);
            response.setAddedOpinion(addedOnDevelopmentRec);
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOpinionHistoryByBusinessOfferRequest")
    @ResponsePayload
    public GetOpinionHistoryByBusinessOfferResponse getOpinionHistoryByBusinessOffer(
            @RequestPayload GetOpinionHistoryByBusinessOfferRequest request
    ) {
        Long id = request.getBusinessOfferId();
        GetOpinionHistoryByBusinessOfferResponse response = new GetOpinionHistoryByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> onOpinions = developmentBusinessOfferService.getDevelopmentHistory(id, OPINION_PHASE);
            TBIOnDevelopmentRec onOpinionsRec = new TBIOnDevelopmentRec();
            onOpinionsRec.getRecord().addAll(onOpinions);
            response.setOpinionHistory(onOpinionsRec);
            return response;
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
