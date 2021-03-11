package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.property.Property;
import by.belinvest.panel.admin.nsi.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/property")
public class PropertyController {
    private static final String PROPERTY_CREATE_URL = "/create";
    private static final String PROPERTY_EDIT_URL = "/edit";
    private static final String PROPERTY_REMOVE_URL = "/remove";
    private static final String PROPERTY_DIRECTORY_GET_URL = "/nsi/property";

    private static final String PROPERTY_DIMID_PARAMETER = "DIMID";
    private static final String PROPERTY_PARENTID_PARAMETER = "PARENTID";
    private static final String PROPERTY_CODE_PARAMETER = "CODE";
    private static final String PROPERTY_NAME_PARAMETER = "NAME";
    private static final String PROPERTY_PROPERTY_DEPOSIT_NAME_PARAMETER = "PROPERTY_DEPOSIT_NAME";


    private static final String PROPERTY_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PROPERTY_PRIMARY_KEY = "DIMID";
    private static final String PROPERTY_DOMAIN = "property";

    @Autowired
    private PropertyService propertyService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PROPERTY_DIRECTORY_PARAMETER, propertyService.get());
        model.addAttribute("domain",PROPERTY_DOMAIN);
        model.addAttribute("primaryKey",PROPERTY_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PROPERTY_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PROPERTY_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = PROPERTY_CODE_PARAMETER) String code,
                               @RequestParam(value = PROPERTY_NAME_PARAMETER) String name,
                               @RequestParam(value = PROPERTY_PROPERTY_DEPOSIT_NAME_PARAMETER) String propertyDepositName) {

        propertyService.create(Property.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .propertyDepositName(propertyDepositName)
                .build()
        );
        return new RedirectView(request.getContextPath() + PROPERTY_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PROPERTY_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return propertyService.update(Property.fromJSON(data));
    }

    @RequestMapping(value = PROPERTY_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return propertyService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PROPERTY_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(PROPERTY_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROPERTY_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROPERTY_PROPERTY_DEPOSIT_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
