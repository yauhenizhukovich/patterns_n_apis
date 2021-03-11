package by.compit.yauheni.zhukovich.entity_to_docx.service;

import java.io.IOException;

import by.compit.yauheni.zhukovich.entity_to_docx.service.model.BusinessOfferDTO;

public interface WordService {

    void generateMainFile(BusinessOfferDTO businessOffer) throws IOException;

    void generateMarketAnalysisFile(BusinessOfferDTO businessOffer) throws IOException;

    void generateProfitabilityCalculationFile(BusinessOfferDTO businessOffer) throws IOException;

    void generateProcessModelFile(BusinessOfferDTO businessOffer) throws IOException;

    void generateProjectDecisionFile(BusinessOfferDTO businessOffer) throws IOException;

    void generateExplanatoryNoteFile(BusinessOfferDTO businessOffer) throws IOException;

}
