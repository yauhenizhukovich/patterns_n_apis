package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.ministry.Ministry;
import by.belinvest.panel.admin.nsi.service.MinistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/ministry")
public class MinistryController {
    private static final String MINISTRY_CREATE_URL = "/create";
    private static final String MINISTRY_EDIT_URL = "/edit";
    private static final String MINISTRY_REMOVE_URL = "/remove";
    private static final String MINISTRY_DIRECTORY_GET_URL = "/nsi/ministry";

    private static final String MINISTRY_DIMID_PARAMETER = "DIMID";
    private static final String MINISTRY_INTER_CODE_PARAMETER = "INTER_CODE";
    private static final String MINISTRY_CODE_PARAMETER = "CODE";
    private static final String MINISTRY_NAME_PARAMETER = "NAME";


    private static final String MINISTRY_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String MINISTRY_PRIMARY_KEY = "DIMID";
    private static final String MINISTRY_DOMAIN = "ministry";

    @Autowired
    private MinistryService ministryService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(MINISTRY_DIRECTORY_PARAMETER, ministryService.get());
        model.addAttribute("domain",MINISTRY_DOMAIN);
        model.addAttribute("primaryKey",MINISTRY_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = MINISTRY_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = MINISTRY_INTER_CODE_PARAMETER) String interCode,
                               @RequestParam(value = MINISTRY_CODE_PARAMETER) String code,
                               @RequestParam(value = MINISTRY_NAME_PARAMETER) String name) {

        ministryService.create(Ministry.builder()
                .code(code)
                .name(name)
                .interCode(interCode)
                .build()
        );
        return new RedirectView(request.getContextPath() + MINISTRY_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = MINISTRY_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return ministryService.update(Ministry.fromJSON(data));
    }

    @RequestMapping(value = MINISTRY_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return ministryService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(MINISTRY_INTER_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(MINISTRY_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(MINISTRY_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
