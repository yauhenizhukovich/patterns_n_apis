package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.stop_factors.StopFactors;
import by.belinvest.panel.admin.nsi.service.StopFactorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/stop_factors")
public class StropFactorsController {
    private static final String STOP_FACTORS_CREATE_URL = "/create";
    private static final String STOP_FACTORS_EDIT_URL = "/edit";
    private static final String STOP_FACTORS_REMOVE_URL = "/remove";
    private static final String STOP_FACTORS_DIRECTORY_GET_URL = "/nsi/stop_factors";

    private static final String ID_STOP_FACTORS_PARAMETER = "SF_ID";
    private static final String STOP_FACTORS_NAME_PARAMETER = "SF_NAME";
    private static final String STOP_FACTORS_DESCRIPTION_PARAMETER = "SF_DESC";

    private static final String STOP_FACTORS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String STOP_FACTORS_PRIMARY_KEY = "SF_ID";
    private static final String STOP_FACTORS_DOMAIN = "stop_factors";

    @Autowired
    private StopFactorsService stopFactorsService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(STOP_FACTORS_DIRECTORY_PARAMETER, stopFactorsService.get());
        model.addAttribute("domain", STOP_FACTORS_DOMAIN);
        model.addAttribute("primaryKey", STOP_FACTORS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = STOP_FACTORS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = STOP_FACTORS_NAME_PARAMETER) String sfName,
                               @RequestParam(value = STOP_FACTORS_DESCRIPTION_PARAMETER) String sfDesc) {

        stopFactorsService.create(StopFactors.builder()
                .sfName(sfName)
                .sfDesc(sfDesc)
                .build()
        );
        return new RedirectView(request.getContextPath() + STOP_FACTORS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = STOP_FACTORS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return stopFactorsService.update(StopFactors.fromJSON(data));
    }

    @RequestMapping(value = STOP_FACTORS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return stopFactorsService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(STOP_FACTORS_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(STOP_FACTORS_DESCRIPTION_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
