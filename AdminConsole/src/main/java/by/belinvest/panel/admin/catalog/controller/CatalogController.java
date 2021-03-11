package by.belinvest.panel.admin.catalog.controller;

import by.belinvest.panel.admin.catalog.service.CatalogService;
import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.Setting;
import by.belinvest.panel.admin.entity.catalog.BPCard;
import by.belinvest.panel.admin.entity.catalog.BPCardDirectory;
import by.belinvest.panel.admin.entity.catalog.BusinessInitiative;
import by.belinvest.panel.admin.entity.catalog.BusinessOffer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.SOAPException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/catalog/reestr")
public class CatalogController {

    private static final String DIRECTORY_PARAMETER = "reestrDirectory";
    private static final String MODERN_PRODUCT = "/modern-product";
    private static final String DESTROY_PRODUCT = "/destroy-product";
    private static final String MODIFY_PRODUCT ="/modify-product" ;


    private final CatalogService catalogService;

    private final String DIRECTORY_PAGE = "catalog/reestr";

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReestr(Model model) {
        model.addAttribute(DIRECTORY_PARAMETER, catalogService.get());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/bi")
    public String getReestrBI(@RequestParam(required = false) String biid,Model model) {
        if (biid!=null&&biid.matches(".*\\d.*")) {
            if (!catalogService.getBusinessInitiativeById(Integer.parseInt(biid)).getBusinessInitiatives().isEmpty()) {
                BusinessInitiative businessInitiative = catalogService.getBusinessInitiativeById(Integer.parseInt(biid)).getBusinessInitiatives().get(0);
                model.addAttribute("bi", businessInitiative);
            }
        }
        return "catalog/BI";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/bo")
    public String getReestrBO(@RequestParam(required = false) String boid,Model model) {
        if (boid!=null&&boid.matches(".*\\d.*")) {
            if (!catalogService.getBusinessOfferById(Integer.parseInt(boid)).getBusinessOffers().isEmpty()) {
                BusinessOffer businessOffer = catalogService.getBusinessOfferById(Integer.parseInt(boid)).getBusinessOffers().get(0);
                model.addAttribute("bo", businessOffer);
            }
        }
        return "catalog/BO";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/kbp")
    public String getReestrKBP(@RequestParam(required = false) String kbpid,Model model) {
        if (kbpid!=null&&kbpid.matches(".*\\d.*")) {
            if (!catalogService.getBPCardById(Integer.parseInt(kbpid)).getBpCards().isEmpty()) {
                BPCard bpCard = catalogService.getBPCardById(Integer.parseInt(kbpid)).getBpCards().get(0);
                model.addAttribute("kbp", bpCard);
            }

        }
        return "catalog/KBP";
    }




    @RequestMapping(value = "/getBusinessInitiative", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, BusinessInitiative> getBusinessInitiative(@RequestBody String bIId) {
        Map<String, BusinessInitiative> map = new HashMap<>();
        BusinessInitiative businessInitiative;
        int id = getValueFromJsonStr(bIId, "bIId");
        try {
            businessInitiative = catalogService.getBusinessInitiativeById(id).getBusinessInitiatives().get(0);
        } catch (IndexOutOfBoundsException e){
            businessInitiative = new BusinessInitiative();
        }
        map.put("businessInitiative", businessInitiative);
        return map;
    }

    @RequestMapping(value = "/getBusinessOffer", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, BusinessOffer> getBusinessOffer(@RequestBody String bOId) {
        Map<String, BusinessOffer> map = new HashMap<>();
        BusinessOffer businessOffer;
        int id = getValueFromJsonStr(bOId, "bOId");
        try {
            businessOffer = catalogService.getBusinessOfferById(id).getBusinessOffers().get(0);
        } catch (IndexOutOfBoundsException e){
            businessOffer = new BusinessOffer();
        }
        map.put("businessOffer", businessOffer);
        return map;
    }

    @RequestMapping(value = "/getBPCard", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, BPCard> getBPCard(@RequestBody String bPCId) {
        Map<String, BPCard> map = new HashMap<>();
        BPCard bpCard;
        int id = getValueFromJsonStr(bPCId, "bPCId");
        try {
            bpCard = catalogService.getBPCardById(id).getBpCards().get(0);
        } catch (IndexOutOfBoundsException e){
            bpCard = new BPCard();
        }
        map.put("bpCard", bpCard);
        return map;
    }

    @RequestMapping(value = "/getProduct", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<?> getProduct(@RequestBody String bPCId) {

        AjaxResponseBody result = null;
        String product = null;
        int id = getValueFromJsonStr(bPCId, "bPCId");
        try {
            product = catalogService.getProductByBpcard(id);
        } catch (IndexOutOfBoundsException e){
        }
        if (product.equals("")){
            product = "Не найдено соответствий";
        }
        result = new AjaxResponseBody(product);
        return ResponseEntity.ok().body(result);
    }




    @RequestMapping(value = MODERN_PRODUCT, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> modernProduct(@RequestBody String kbpid) {
        AjaxResponseBody result = null;
        try {
            int id = getValueFromJsonStr(kbpid, "kbpid");
            int idd = getValueFromJsonStr(kbpid,"bOId");
            catalogService.moderProduct(id,idd);
        }catch (UnsupportedOperationException | NumberFormatException e){
            result = new AjaxResponseBody("карточка банковского продукта не имеет id");
            return ResponseEntity.badRequest().body(result);
        }

        result = new AjaxResponseBody("Процесс запущен");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = MODIFY_PRODUCT, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> modifyProduct(@RequestBody String kbpid) {
        AjaxResponseBody result = null;
        try {
            int id = getValueFromJsonStr(kbpid, "kbpid");
            int idd = getValueFromJsonStr(kbpid,"bOId");
            catalogService.modifyProduct(id,idd);
        }catch (UnsupportedOperationException | NumberFormatException e){
            result = new AjaxResponseBody("карточка банковского продукта не имеет id");
            return ResponseEntity.badRequest().body(result);
        }

        result = new AjaxResponseBody("Процесс запущен");
        return ResponseEntity.ok().body(result);
    }


    @RequestMapping(value = DESTROY_PRODUCT, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> destroy(@RequestBody String kbpid) throws SOAPException {
        AjaxResponseBody result = null;
        BPCard bpCard = null;
        try {
            int id = getValueFromJsonStr(kbpid, "kbpid");
            int idd = getValueFromJsonStr(kbpid,"bOId");
            catalogService.liquidProduct(id,idd);

        }catch (UnsupportedOperationException | NumberFormatException e){
            result = new AjaxResponseBody("карточка банковского продукта не имеет id");
            return ResponseEntity.badRequest().body(result);
        }

        BPCard status = catalogService.getBPCardById(getValueFromJsonStr(kbpid, "kbpid")).getBpCards().get(0);
        if (status!=null) {
            if (status.getProductName() != null) {
                result = new AjaxResponseBody("Продукт" + (status.getProductName() != null ? status.getProductName() : "") + " -" + status.getProductStatus());
            }
        }

        return ResponseEntity.ok().body(result);
    }


    private int getValueFromJsonStr(String str, String fieldName){
        JsonElement root = new JsonParser().parse(str);
        JsonElement value = root.getAsJsonObject().get(fieldName);
        int result = value.getAsInt();
        return result;
    }

}
