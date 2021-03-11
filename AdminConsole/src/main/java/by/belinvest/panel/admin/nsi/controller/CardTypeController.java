package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.cardtype.CardType;
import by.belinvest.panel.admin.nsi.service.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/cardtype")
public class CardTypeController {
    private static final String CARDTYPE_CREATE_URL = "/create";
    private static final String CARDTYPE_EDIT_URL = "/edit";
    private static final String CARDTYPE_REMOVE_URL = "/remove";
    private static final String CARDTYPE_DIRECTORY_GET_URL = "/nsi/cardtype";

    private static final String CARDTYPE_DIMID_PARAMETER = "DIMID";
    private static final String CARDTYPE_NAME_PARAMETER = "NAME";
    private static final String CARDTYPE_CUR_LIST_PARAMETER = "CUR_LIST";
    private static final String CARDTYPE_CARDTYPE_CATEGORY_PARAMETER = "CARDTYPE_CATEGORY";
    private static final String CARDTYPE_CARDTYPE_PS_PARAMETER = "CARDTYPE_PS";
    private static final String CARDTYPE_CARDTYPE_TECHNOLOGY_PARAMETER = "CARDTYPE_TECHNOLOGY";
    private static final String CARDTYPE_CARDTYPE_TYPE_ADD_SERVICE_PARAMETER = "CARDTYPE_TYPE_ADD_SERVICE";
    private static final String CARDTYPE_COLOR_IB_PARAMETER = "COLOR_IB";
    private static final String CARDTYPE_CODE_PARAMETER = "CODE";

    private static final String CARDTYPE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CARDTYPE_PRIMARY_KEY = "DIMID";
    private static final String CARDTYPE_DOMAIN = "cardtype";

    @Autowired
    private CardTypeService cardTypeService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CARDTYPE_DIRECTORY_PARAMETER, cardTypeService.get());
        model.addAttribute("domain",CARDTYPE_DOMAIN);
        model.addAttribute("primaryKey",CARDTYPE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CARDTYPE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CARDTYPE_NAME_PARAMETER) String name,
                               @RequestParam(value = CARDTYPE_CODE_PARAMETER) String code,
                               @RequestParam(value = CARDTYPE_CUR_LIST_PARAMETER) String curList,
                               @RequestParam(value = CARDTYPE_CARDTYPE_CATEGORY_PARAMETER) String cardtypeCategory,
                               @RequestParam(value = CARDTYPE_CARDTYPE_PS_PARAMETER) String cardtypePs,
                               @RequestParam(value = CARDTYPE_CARDTYPE_TECHNOLOGY_PARAMETER) String cardtypeTechnology,
                               @RequestParam(value = CARDTYPE_CARDTYPE_TYPE_ADD_SERVICE_PARAMETER) String cardtypeTypeAddService,
                               @RequestParam(value = CARDTYPE_COLOR_IB_PARAMETER) String colorIb) {

        cardTypeService.create(CardType.builder()
                .code(code)
                .name(name)
                .curList(curList)
                .cardtypeCategory(cardtypeCategory)
                .cardtypePs(cardtypePs)
                .cardtypeTechnology(cardtypeTechnology)
                .cardtypeTypeAddService(cardtypeTypeAddService)
                .build()
        );
        return new RedirectView(request.getContextPath() + CARDTYPE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CARDTYPE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return cardTypeService.update(CardType.fromJSON(data));
    }

    @RequestMapping(value = CARDTYPE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return cardTypeService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CARDTYPE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDTYPE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDTYPE_CUR_LIST_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDTYPE_CARDTYPE_CATEGORY_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CARDTYPE_CARDTYPE_PS_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDTYPE_CARDTYPE_TECHNOLOGY_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDTYPE_CARDTYPE_TYPE_ADD_SERVICE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDTYPE_COLOR_IB_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
