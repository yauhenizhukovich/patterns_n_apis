package by.compit.yauheni.zhukovich.business_initiative.controller.business_initiative;

import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.AddBusinessInitiativeRequest;
import org.example.AddBusinessInitiativeResponse;
import org.example.GetBusinessInitiativeByIdRequest;
import org.example.GetBusinessInitiativeByIdResponse;
import org.example.TBICommonBlock;
import org.example.TBusinessInitiative;
import org.example.TBusinessInitiativePart1;
import org.example.UpdateBusinessInitiativeByIdRequest;
import org.example.UpdateBusinessInitiativeByIdResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.BusinessInitiativeService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBusinessInitiativeException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class BusinessInitiativeController {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final BusinessInitiativeService businessInitiativeService;

    public BusinessInitiativeController(BusinessInitiativeService businessInitiativeService) {
        this.businessInitiativeService = businessInitiativeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBusinessInitiativeRequest")
    @ResponsePayload
    public AddBusinessInitiativeResponse addBusinessInitiative(
            @RequestPayload AddBusinessInitiativeRequest request
    ) throws NonexistentBusinessInitiativeException {
        logger.info("Add business initiative method started.");
        TBusinessInitiative businessInitiative = request.getBusinessInitiative();
        TBusinessInitiativePart1 biPart1 = businessInitiative.getBiPart1();
        if (biPart1 != null) {
            TBICommonBlock commonBlock = biPart1.getCommonBlock();
            if (commonBlock != null) {
                String idString = commonBlock.getIdBI();
                if (idString != null) {
                    long id = Long.parseLong(idString);
                    businessInitiativeService.updateById(businessInitiative, id);
                    AddBusinessInitiativeResponse response = new AddBusinessInitiativeResponse();
                    response.setBusinessInitiativeId(id);
                    logger.info("Updated business initiative have ID: " + id);
                    return response;
                }
            }
        }
        Long id = businessInitiativeService.add(businessInitiative);
        AddBusinessInitiativeResponse response = new AddBusinessInitiativeResponse();
        logger.info("Added business initiative have ID: " + id);
        response.setBusinessInitiativeId(id);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBusinessInitiativeByIdRequest")
    @ResponsePayload
    public GetBusinessInitiativeByIdResponse getBusinessInitiativeById(
            @RequestPayload GetBusinessInitiativeByIdRequest request
    ) throws NonexistentBusinessInitiativeException {
        Long id = request.getBusinessInitiativeId();
        TBusinessInitiative biDTO = businessInitiativeService.getById(id);
        GetBusinessInitiativeByIdResponse response = new GetBusinessInitiativeByIdResponse();
        response.setBusinessInitiative(biDTO);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBusinessInitiativeByIdRequest")
    @ResponsePayload
    public UpdateBusinessInitiativeByIdResponse updateBusinessInitiativeById(
            @RequestPayload UpdateBusinessInitiativeByIdRequest request
    ) throws NonexistentBusinessInitiativeException {
        TBusinessInitiative businessInitiative = request.getBusinessInitiative();
        Long id = request.getBusinessInitiativeId();
        businessInitiativeService.updateById(businessInitiative, id);
        UpdateBusinessInitiativeByIdResponse response = new UpdateBusinessInitiativeByIdResponse();
        response.setMessage("The business initiative with ID: " + id + " was successfully updated.");
        return response;
    }

}
