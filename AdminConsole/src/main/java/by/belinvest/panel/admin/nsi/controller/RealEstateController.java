package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.real_estate.RealEstate;
import by.belinvest.panel.admin.nsi.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/real_estate")
public class RealEstateController {
    private static final String REAL_ESTATE_CREATE_URL = "/create";
    private static final String REAL_ESTATE_EDIT_URL = "/edit";
    private static final String REAL_ESTATE_REMOVE_URL = "/remove";
    private static final String REAL_ESTATE_DIRECTORY_GET_URL = "/nsi/real_estate";

    private static final String REAL_ESTATE_DIMID_PARAMETER = "DIMID";
    private static final String REAL_ESTATE_NAME_PARAMETER = "NAME";
    private static final String REAL_ESTATE_CODE_PARAMETER = "CODE";

    private static final String REAL_ESTATE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String REAL_ESTATE_PRIMARY_KEY = "DIMID";
    private static final String REAL_ESTATE_DOMAIN = "real_estate";

    @Autowired
    private RealEstateService realEstateService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(REAL_ESTATE_DIRECTORY_PARAMETER, realEstateService.get());
        model.addAttribute("domain", REAL_ESTATE_DOMAIN);
        model.addAttribute("primaryKey", REAL_ESTATE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = REAL_ESTATE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = REAL_ESTATE_NAME_PARAMETER) String name,
                               @RequestParam(value = REAL_ESTATE_CODE_PARAMETER) String code) {

        realEstateService.create(RealEstate.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + REAL_ESTATE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = REAL_ESTATE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return realEstateService.update(RealEstate.fromJSON(data));
    }

    @RequestMapping(value = REAL_ESTATE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return realEstateService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(REAL_ESTATE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(REAL_ESTATE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
