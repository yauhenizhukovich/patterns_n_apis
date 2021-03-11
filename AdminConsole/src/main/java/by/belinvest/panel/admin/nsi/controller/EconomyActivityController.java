package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.economy_activity.EconomyActivity;
import by.belinvest.panel.admin.nsi.service.EconomyActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/economy_activity")
public class EconomyActivityController {

    private static final String CURRENCY_CREATE_URL = "/create";
    private static final String CURRENCY_EDIT_URL = "/edit";
    private static final String CURRENCY_REMOVE_URL = "/remove";
    private static final String CURRENCY_DIRECTORY_GET_URL = "/nsi/economy_activity";

    private static final String CURRENCY_DIMID_PARAMETER = "DIMID";
    private static final String CURRENCY_PARENTID_PARAMETER = "PARENTID";
    private static final String CURRENCY_CODE_PARAMETER = "CODE";
    private static final String CURRENCY_NAME_PARAMETER = "NAME";
    private static final String CURRENCY_KURS_KOL_PARAMETER = "K1";
    private static final String CURRENCY_STATE_PARAMETER = "K2";
    private static final String CURRENCY_BBB_CODE_PARAMETER = "K3";
    private static final String CURRENCY_FGENDER_PARAMETER = "OLD_CODES";




    private static final String CURRENCY_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CURRENCY_PRIMARY_KEY = "DIMID";
    private static final String CURRENCY_DOMAIN = "economy_activity";

    @Autowired
    private EconomyActivityService economyActivityService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CURRENCY_DIRECTORY_PARAMETER, economyActivityService.get());
        model.addAttribute("domain",CURRENCY_DOMAIN);
        model.addAttribute("primaryKey",CURRENCY_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());

        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CURRENCY_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CURRENCY_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = CURRENCY_NAME_PARAMETER) String name,
                               @RequestParam(value = CURRENCY_CODE_PARAMETER) String code,
                               @RequestParam(value = CURRENCY_KURS_KOL_PARAMETER) String k1,
                               @RequestParam(value = CURRENCY_STATE_PARAMETER) String k2,
                               @RequestParam(value = CURRENCY_BBB_CODE_PARAMETER) String k3,
                               @RequestParam(value = CURRENCY_FGENDER_PARAMETER) String oldCodes) {

        economyActivityService.create(EconomyActivity.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .k1(k1)
                .k2(k2)
                .k3(k3)
                .oldCodes(oldCodes)
                .build()
        );
        return new RedirectView(request.getContextPath() + CURRENCY_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CURRENCY_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return economyActivityService.update(EconomyActivity.fromJSON(data));
    }

    @RequestMapping(value = CURRENCY_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return economyActivityService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CURRENCY_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_KURS_KOL_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_STATE_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(CURRENCY_BBB_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CURRENCY_FGENDER_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
