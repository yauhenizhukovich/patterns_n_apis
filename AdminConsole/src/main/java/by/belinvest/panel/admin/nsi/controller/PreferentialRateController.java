package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.preferential_rate.PreferentialRate;
import by.belinvest.panel.admin.nsi.service.PreferentialRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/preferential_rate")
public class PreferentialRateController {
    private static final String PREFERENTIAL_RATE_CREATE_URL = "/create";
    private static final String PREFERENTIAL_RATE_EDIT_URL = "/edit";
    private static final String PREFERENTIAL_RATE_REMOVE_URL = "/remove";
    private static final String PREFERENTIAL_RATE_DIRECTORY_GET_URL = "/nsi/preferential_rate";

    private static final String PREFERENTIAL_RATE_ID_PARAMETER = "ID";
    private static final String PREFERENTIAL_RATE_NOTE_PARAMETER = "NOTE";
    private static final String PREFERENTIAL_RATE_CODE_PARAMETER = "CODE";
    private static final String PREFERENTIAL_RATE_NAME_PARAMETER = "NAME";

    private static final String PREFERENTIAL_RATE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PREFERENTIAL_RATE_PRIMARY_KEY = "ID";
    private static final String PREFERENTIAL_RATE_DOMAIN = "preferential_rate";

    @Autowired
    private PreferentialRateService preferentialRateService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PREFERENTIAL_RATE_DIRECTORY_PARAMETER, preferentialRateService.get());
        model.addAttribute("domain",PREFERENTIAL_RATE_DOMAIN);
        model.addAttribute("primaryKey",PREFERENTIAL_RATE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PREFERENTIAL_RATE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PREFERENTIAL_RATE_NOTE_PARAMETER) String note,
                               @RequestParam(value = PREFERENTIAL_RATE_CODE_PARAMETER) String code,
                               @RequestParam(value = PREFERENTIAL_RATE_NAME_PARAMETER) String name){

        preferentialRateService.create(PreferentialRate.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + PREFERENTIAL_RATE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PREFERENTIAL_RATE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return preferentialRateService.update(PreferentialRate.fromJSON(data));
    }

    @RequestMapping(value = PREFERENTIAL_RATE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return preferentialRateService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PREFERENTIAL_RATE_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREFERENTIAL_RATE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PREFERENTIAL_RATE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
