package by.compit.yauheni.zhukovich.business_initiative.controller.business_offer;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddApproveByBusinessOfferRequest;
import org.example.AddApproveByBusinessOfferResponse;
import org.example.GetApproveHistoryByBusinessOfferRequest;
import org.example.GetApproveHistoryByBusinessOfferResponse;
import org.example.TBIOnDevelopment;
import org.example.TBIOnDevelopmentRec;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.DevelopmentBusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.APPROVE_PHASE;
import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class ApproveBOController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final DevelopmentBusinessOfferService developmentBusinessOfferService;

    public ApproveBOController(DevelopmentBusinessOfferService developmentBusinessOfferService) {
        this.developmentBusinessOfferService = developmentBusinessOfferService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addApproveByBusinessOfferRequest")
    @ResponsePayload
    public AddApproveByBusinessOfferResponse addApproveByBusinessOffer(
            @RequestPayload AddApproveByBusinessOfferRequest request
    ) {
        TBIOnDevelopmentRec onDevelopment = request.getApprove();
        Long id = request.getBusinessOfferId();
        AddApproveByBusinessOfferResponse response = new AddApproveByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> record = onDevelopment.getRecord();
            record.forEach(dev -> dev.setDevPhase(APPROVE_PHASE));
            TBIOnDevelopmentRec addedOnDevelopmentRec = developmentBusinessOfferService.add(onDevelopment, id);
            response.setAddedApprove(addedOnDevelopmentRec);
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getApproveHistoryByBusinessOfferRequest")
    @ResponsePayload
    public GetApproveHistoryByBusinessOfferResponse getApproveHistoryByBusinessOffer(
            @RequestPayload GetApproveHistoryByBusinessOfferRequest request
    ) {
        Long id = request.getBusinessOfferId();
        GetApproveHistoryByBusinessOfferResponse response = new GetApproveHistoryByBusinessOfferResponse();
        try {
            List<TBIOnDevelopment> onApproves = developmentBusinessOfferService.getDevelopmentHistory(id, APPROVE_PHASE);
            TBIOnDevelopmentRec onApprovesRec = new TBIOnDevelopmentRec();
            onApprovesRec.getRecord().addAll(onApproves);
            response.setApproveHistory(onApprovesRec);
            return response;
        } catch (NonexistentBusinessOfferException e) {
            logger.info(e.getMessage() + id);
        }
        return response;
    }

}
