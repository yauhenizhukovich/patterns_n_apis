package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.base_value_type.BaseValueType;
import by.belinvest.panel.admin.nsi.service.BaseValueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/base_value_type")
public class BaseValueTypeController {

    private static final String BASE_VALUE_TYPE_CREATE_URL = "/create";
    private static final String BASE_VALUE_TYPE_EDIT_URL = "/edit";
    private static final String BASE_VALUE_TYPE_REMOVE_URL = "/remove";
    private static final String BASE_VALUE_TYPE_GET_URL = "/nsi/bank_nsi_json";

    private static final String BASE_VALUE_TYPE_ID_PARAMETER = "ID";
    private static final String BASE_VALUE_TYPE_NAME_PARAMETER = "NAME";

    private static final String BASE_VALUE_TYPE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String BASE_VALUE_TYPE_PRIMARY_KEY = "ID";
    private static final String BASE_VALUE_TYPE_DOMAIN = "base_value_type";

    @Autowired
    private BaseValueTypeService baseValueTypeService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(BASE_VALUE_TYPE_DIRECTORY_PARAMETER, baseValueTypeService.get());
        model.addAttribute("domain",BASE_VALUE_TYPE_DOMAIN);
        model.addAttribute("primaryKey",BASE_VALUE_TYPE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = BASE_VALUE_TYPE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = BASE_VALUE_TYPE_NAME_PARAMETER) String name) {

        baseValueTypeService.create(BaseValueType.builder()
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + BASE_VALUE_TYPE_GET_URL);
    }

    @RequestMapping(value = BASE_VALUE_TYPE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return baseValueTypeService.update(BaseValueType.fromJSON(data));
    }

    @RequestMapping(value = BASE_VALUE_TYPE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return baseValueTypeService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(BASE_VALUE_TYPE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
