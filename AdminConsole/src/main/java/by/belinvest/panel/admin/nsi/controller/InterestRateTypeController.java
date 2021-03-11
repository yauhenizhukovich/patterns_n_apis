package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.interest_rate_type.InterestRateType;
import by.belinvest.panel.admin.nsi.service.InterestRateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/interest_rate_type")
public class InterestRateTypeController {
    private static final String INTEREST_RATE_TYPE_CREATE_URL = "/create";
    private static final String INTEREST_RATE_TYPE_EDIT_URL = "/edit";
    private static final String INTEREST_RATE_TYPE_REMOVE_URL = "/remove";
    private static final String INTEREST_RATE_TYPE_DIRECTORY_GET_URL = "/nsi/interest_rate_type";

    private static final String INTEREST_RATE_TYPE_ID_PARAMETER = "ID";
    private static final String INTEREST_RATE_TYPE_NOTE_PARAMETER = "NOTE";
    private static final String INTEREST_RATE_TYPE_CODE_PARAMETER = "CODE";
    private static final String INTEREST_RATE_TYPE_NAME_PARAMETER = "NAME";

    private static final String INTEREST_RATE_TYPE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String INTEREST_RATE_TYPE_PRIMARY_KEY = "ID";
    private static final String INTEREST_RATE_TYPE_DOMAIN = "interest_rate_type";

    @Autowired
    private InterestRateTypeService interestRateTypeService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(INTEREST_RATE_TYPE_DIRECTORY_PARAMETER, interestRateTypeService.get());
        model.addAttribute("domain",INTEREST_RATE_TYPE_DOMAIN);
        model.addAttribute("primaryKey",INTEREST_RATE_TYPE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = INTEREST_RATE_TYPE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = INTEREST_RATE_TYPE_NOTE_PARAMETER) String note,
                               @RequestParam(value = INTEREST_RATE_TYPE_CODE_PARAMETER) String code,
                               @RequestParam(value = INTEREST_RATE_TYPE_NAME_PARAMETER) String name){

        interestRateTypeService.create(InterestRateType.builder()
                .note(note)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + INTEREST_RATE_TYPE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = INTEREST_RATE_TYPE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return interestRateTypeService.update(InterestRateType.fromJSON(data));
    }

    @RequestMapping(value = INTEREST_RATE_TYPE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return interestRateTypeService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(INTEREST_RATE_TYPE_NOTE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(INTEREST_RATE_TYPE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(INTEREST_RATE_TYPE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
