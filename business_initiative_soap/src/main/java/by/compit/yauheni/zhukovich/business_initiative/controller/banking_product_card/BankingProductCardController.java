package by.compit.yauheni.zhukovich.business_initiative.controller.banking_product_card;

import org.example.AddBankingProductCardRequest;
import org.example.AddBankingProductCardResponse;
import org.example.GetBankingProductCardByIdRequest;
import org.example.GetBankingProductCardByIdResponse;
import org.example.TBPCommon;
import org.example.TBankingProductCard;
import org.example.UpdateBankingProductCardByIdRequest;
import org.example.UpdateBankingProductCardByIdResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.BankingProductCardService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.NonexistentBankingProductCardException;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class BankingProductCardController {

    private final BankingProductCardService bankingProductCardService;

    public BankingProductCardController(BankingProductCardService bankingProductCardService) {
        this.bankingProductCardService = bankingProductCardService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBankingProductCardRequest")
    @ResponsePayload
    public AddBankingProductCardResponse addBankingProductCard(
            @RequestPayload AddBankingProductCardRequest request
    ) throws NonexistentBankingProductCardException {
        TBankingProductCard bankingProductCard = request.getBankingProductCard();
        TBPCommon common = bankingProductCard.getCommon();
        if (common != null) {
            String bpID = common.getBpID();
            if (bpID != null) {
                long id = Long.parseLong(bpID);
                bankingProductCardService.updateById(bankingProductCard, id);
                AddBankingProductCardResponse response = new AddBankingProductCardResponse();
                response.setBankingProductCardId(id);
                return response;
            }
        }
        Long id = bankingProductCardService.add(bankingProductCard);
        AddBankingProductCardResponse response = new AddBankingProductCardResponse();
        response.setBankingProductCardId(id);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBankingProductCardByIdRequest")
    @ResponsePayload
    public GetBankingProductCardByIdResponse getBankingProductCardById(
            @RequestPayload GetBankingProductCardByIdRequest request
    ) throws NonexistentBankingProductCardException {
        Long id = request.getBankingProductCardId();
        TBankingProductCard bankingProductCard = bankingProductCardService.getById(id);
        GetBankingProductCardByIdResponse response = new GetBankingProductCardByIdResponse();
        response.setBankingProductCard(bankingProductCard);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBankingProductCardByIdRequest")
    @ResponsePayload
    public UpdateBankingProductCardByIdResponse updateBankingProductCardById(
            @RequestPayload UpdateBankingProductCardByIdRequest request
    ) throws NonexistentBankingProductCardException {
        TBankingProductCard bpc = request.getBankingProductCard();
        Long id = request.getBankingProductCardId();
        bankingProductCardService.updateById(bpc, id);
        UpdateBankingProductCardByIdResponse response = new UpdateBankingProductCardByIdResponse();
        response.setMessage("The banking product card with ID: " + id + " was successfully updated.");
        return response;
    }

}
