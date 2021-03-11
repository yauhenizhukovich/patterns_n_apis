package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.ccond_type.CCondType;
import by.belinvest.panel.admin.nsi.service.CCondTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/ccond_type")
public class CCondTypeController {
    private static final String CCOND_TYPE_CREATE_URL = "/create";
    private static final String CCOND_TYPE_EDIT_URL = "/edit";
    private static final String CCOND_TYPE_REMOVE_URL = "/remove";
    private static final String CCOND_TYPE_DIRECTORY_GET_URL = "/nsi/ccond_type";

    private static final String CCOND_TYPE_DIMID_PARAMETER = "DIMID";
    private static final String CCOND_TYPE_NAME_PARAMETER = "NAME";
    private static final String CCOND_TYPE_CODE_PARAMETER = "CODE";

    private static final String CCOND_TYPE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String CCOND_TYPE_PRIMARY_KEY = "DIMID";
    private static final String CCOND_TYPE_DOMAIN = "ccond_type";

    @Autowired
    private CCondTypeService cCondTypeService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(CCOND_TYPE_DIRECTORY_PARAMETER, cCondTypeService.get());
        model.addAttribute("domain",CCOND_TYPE_DOMAIN);
        model.addAttribute("primaryKey",CCOND_TYPE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = CCOND_TYPE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = CCOND_TYPE_NAME_PARAMETER) String name,
                               @RequestParam(value = CCOND_TYPE_CODE_PARAMETER) String code) {

        cCondTypeService.create(CCondType.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + CCOND_TYPE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = CCOND_TYPE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return cCondTypeService.update(CCondType.fromJSON(data));
    }

    @RequestMapping(value = CCOND_TYPE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return cCondTypeService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(CCOND_TYPE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(CCOND_TYPE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
