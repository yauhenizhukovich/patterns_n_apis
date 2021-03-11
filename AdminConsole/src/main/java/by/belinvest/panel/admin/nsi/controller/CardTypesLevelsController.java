package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.card_types_levels.CardTypesLevels;
import by.belinvest.panel.admin.nsi.service.CardTypesLevelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/card_types_levels")
public class CardTypesLevelsController {
    private static final String CARD_TYPES_LEVELS_CREATE_URL = "/create";
    private static final String CARD_TYPES_LEVELS_EDIT_URL = "/edit";
    private static final String CARD_TYPES_LEVELS_REMOVE_URL = "/remove";
    private static final String CARD_TYPES_LEVELS_DIRECTORY_GET_URL = "/nsi/card_types_levels";

    private static final String CARD_TYPES_LEVELS_DIMID_PARAMETER = "DIMID";
    private static final String CARD_TYPES_LEVELS_NAME_PARAMETER = "NAME";
    private static final String CARD_TYPES_LEVELS_CODE_PARAMETER = "CODE";
    private static final String CARD_TYPES_LEVELS_CTL_ORDER_PARAMETER = "CTL_ORDER";

    private static final String CARD_TYPES_LEVELS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CARD_TYPES_LEVELS_PRIMARY_KEY = "DIMID";
    private static final String CARD_TYPES_LEVELS_DOMAIN = "card_types_levels";

    @Autowired
    private CardTypesLevelsService cardTypesLevelsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CARD_TYPES_LEVELS_DIRECTORY_PARAMETER, cardTypesLevelsService.get());
        model.addAttribute("domain",CARD_TYPES_LEVELS_DOMAIN);
        model.addAttribute("primaryKey",CARD_TYPES_LEVELS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CARD_TYPES_LEVELS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CARD_TYPES_LEVELS_NAME_PARAMETER) String name,
                               @RequestParam(value = CARD_TYPES_LEVELS_CODE_PARAMETER) String code,
                               @RequestParam(value = CARD_TYPES_LEVELS_CTL_ORDER_PARAMETER) String ctlOrder) {

        cardTypesLevelsService.create(CardTypesLevels.builder()
                .code(code)
                .name(name)
                .ctlOrder(ctlOrder)
                .build()
        );
        return new RedirectView(request.getContextPath() + CARD_TYPES_LEVELS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CARD_TYPES_LEVELS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return cardTypesLevelsService.update(CardTypesLevels.fromJSON(data));
    }

    @RequestMapping(value = CARD_TYPES_LEVELS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return cardTypesLevelsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CARD_TYPES_LEVELS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARD_TYPES_LEVELS_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CARD_TYPES_LEVELS_CTL_ORDER_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        return fieldsMap;
    }
}
