package by.compit.yauheni.zhukovich.entity_to_docx.controller;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.WriteBusinessOfferRequest;
import org.example.WriteBusinessOfferResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessInitiativeConstant;
import by.compit.yauheni.zhukovich.entity_to_docx.service.BusinessOfferService;
import by.compit.yauheni.zhukovich.entity_to_docx.service.WordService;
import by.compit.yauheni.zhukovich.entity_to_docx.service.exception.NonexistentBusinessOfferException;
import by.compit.yauheni.zhukovich.entity_to_docx.service.model.BusinessOfferDTO;

import static by.compit.yauheni.zhukovich.entity_to_docx.constant.BusinessOfferConstant.PRODUCT_MANAGER_SUPERVISOR;

@Endpoint
public class BusinessOfferControllerSOAP {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final BusinessOfferService businessOfferService;
    private final WordService wordService;

    public BusinessOfferControllerSOAP(BusinessOfferService businessOfferService, WordService wordService) {
        this.businessOfferService = businessOfferService;
        this.wordService = wordService;
    }

    @PayloadRoot(namespace = BusinessInitiativeConstant.NAMESPACE_URI, localPart = "writeBusinessOfferRequest")
    @ResponsePayload
    public WriteBusinessOfferResponse writeBusinessOffer(
            @RequestPayload WriteBusinessOfferRequest request
    ) throws NonexistentBusinessOfferException, IOException {
        String id = request.getBusinessOfferId();
        BusinessOfferDTO businessOffer = businessOfferService.getById(Long.valueOf(id));
        logger.info(businessOffer.getSimpleFields().get(PRODUCT_MANAGER_SUPERVISOR));
        wordService.generateMarketAnalysisFile(businessOffer);
        wordService.generateProcessModelFile(businessOffer);
        wordService.generateProfitabilityCalculationFile(businessOffer);
        wordService.generateProjectDecisionFile(businessOffer);
        wordService.generateExplanatoryNoteFile(businessOffer);
        wordService.generateMainFile(businessOffer);
        WriteBusinessOfferResponse response = new WriteBusinessOfferResponse();
        response.setMessageFileWrote("Файл сохранен");
        return response;
    }

}
