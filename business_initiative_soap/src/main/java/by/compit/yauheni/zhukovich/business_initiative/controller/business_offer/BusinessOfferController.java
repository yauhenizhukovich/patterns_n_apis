package by.compit.yauheni.zhukovich.business_initiative.controller.business_offer;

import org.example.AddBusinessOfferRequest;
import org.example.AddBusinessOfferResponse;
import org.example.GetBusinessOfferByIdRequest;
import org.example.GetBusinessOfferByIdResponse;
import org.example.TBOCommon;
import org.example.TBusinessOffer;
import org.example.UpdateBusinessOfferByIdRequest;
import org.example.UpdateBusinessOfferByIdResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.BusinessOfferService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessOfferException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class BusinessOfferController {

    private final BusinessOfferService businessOfferService;

    public BusinessOfferController(BusinessOfferService businessOfferService) {
        this.businessOfferService = businessOfferService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBusinessOfferRequest")
    @ResponsePayload
    public AddBusinessOfferResponse addBusinessOffer(
            @RequestPayload AddBusinessOfferRequest request
    ) throws NonexistentBusinessOfferException {
        TBusinessOffer businessOffer = request.getBusinessOffer();
        TBOCommon common = businessOffer.getCommon();
        if (common != null) {
            String boID = common.getBoID();
            if (boID != null) {
                long id = Long.parseLong(boID);
                businessOfferService.updateById(businessOffer, id);
                AddBusinessOfferResponse response = new AddBusinessOfferResponse();
                response.setBusinessOfferId(id);
                return response;
            }
        }
        Long id = businessOfferService.add(businessOffer);
        AddBusinessOfferResponse response = new AddBusinessOfferResponse();
        response.setBusinessOfferId(id);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBusinessOfferByIdRequest")
    @ResponsePayload
    public GetBusinessOfferByIdResponse getBusinessOfferById(
            @RequestPayload GetBusinessOfferByIdRequest request
    ) throws NonexistentBusinessOfferException {
        Long id = request.getBusinessOfferId();
        TBusinessOffer biDTO = businessOfferService.getById(id);
        GetBusinessOfferByIdResponse response = new GetBusinessOfferByIdResponse();
        response.setBusinessOffer(biDTO);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBusinessOfferByIdRequest")
    @ResponsePayload
    public UpdateBusinessOfferByIdResponse updateBusinessOfferById(
            @RequestPayload UpdateBusinessOfferByIdRequest request
    ) throws NonexistentBusinessOfferException {
        TBusinessOffer businessOffer = request.getBusinessOffer();
        Long id = request.getBusinessOfferId();
        businessOfferService.updateById(businessOffer, id);
        UpdateBusinessOfferByIdResponse response = new UpdateBusinessOfferByIdResponse();
        response.setMessage("The business offer with ID: " + id + " was successfully updated.");
        return response;
    }

}

