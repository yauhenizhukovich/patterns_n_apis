package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.cardopt.CardOpt;
import by.belinvest.panel.admin.nsi.service.CardOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/cardopt")
public class CardOptController {
    private static final String CARDOPT_CREATE_URL = "/create";
    private static final String CARDOPT_EDIT_URL = "/edit";
    private static final String CARDOPT_REMOVE_URL = "/remove";
    private static final String CARDOPT_DIRECTORY_GET_URL = "/nsi/cardopt";

    private static final String CARDOPT_DIMID_PARAMETER = "DIMID";
    private static final String CARDOPT_NAME_PARAMETER = "NAME";
    private static final String CARDOPT_CODE_PARAMETER = "CODE";
    private static final String CARDOPT_CARD_OPT_ELEMENT_PARAMETER = "CARD_OPT_ELEMENT";
    private static final String CARDOPT_CARD_OPT_SEARCH_PARAMETER = "CARD_OPT_SEARCH";

    private static final String CARDOPT_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CARDOPT_PRIMARY_KEY = "DIMID";
    private static final String CARDOPT_DOMAIN = "cardopt";

    @Autowired
    private CardOptService cardOptService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CARDOPT_DIRECTORY_PARAMETER, cardOptService.get());
        model.addAttribute("domain", CARDOPT_DOMAIN);
        model.addAttribute("primaryKey", CARDOPT_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CARDOPT_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CARDOPT_NAME_PARAMETER) String name,
                               @RequestParam(value = CARDOPT_CODE_PARAMETER) String code,
                               @RequestParam(value = CARDOPT_CARD_OPT_ELEMENT_PARAMETER) String cardOptElement,
                               @RequestParam(value = CARDOPT_CARD_OPT_SEARCH_PARAMETER) String cardOptSearch) {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + name + " " + code + " " + cardOptElement + " " + cardOptSearch);
        cardOptService.create(CardOpt.builder()
                .code(code)
                .name(name)
                .cardOptElement(cardOptElement)
                .cardOptSearch(cardOptSearch)
                .build()
        );
        return new RedirectView(request.getContextPath() + CARDOPT_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CARDOPT_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return cardOptService.update(CardOpt.fromJSON(data));
    }

    @RequestMapping(value = CARDOPT_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return cardOptService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CARDOPT_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDOPT_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDOPT_CARD_OPT_ELEMENT_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARDOPT_CARD_OPT_SEARCH_PARAMETER, FieldsType.SELECT_0_1_FIELD_TYPE);
        return fieldsMap;
    }

}
