package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.types_orgstrucrure.TypesOrgStructure;
import by.belinvest.panel.admin.nsi.service.TypesOrgstructureSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/types_orgstructure")
public class TypesOrgStructureController {

    private static final String TYPES_ORGSTRUCTURE_CREATE_URL = "/create";
    private static final String TYPES_ORGSTRUCTURE_EDIT_URL = "/edit";
    private static final String TYPES_ORGSTRUCTURE_REMOVE_URL = "/remove";
    private static final String TYPES_ORGSTRUCTURE_DIRECTORY_GET_URL = "/nsi/types_orgstructure";

    private static final String TYPES_ORGSTRUCTURE_DIMID_PARAMETER = "DIMID";
    private static final String TYPES_ORGSTRUCTURE_NAME_PARAMETER = "NAME";
    private static final String TYPES_ORGSTRUCTURE_CODE_PARAMETER = "CODE";

    private static final String TYPES_ORGSTRUCTURE_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String TYPES_ORGSTRUCTURE_PRIMARY_KEY = "DIMID";
    private static final String TYPES_ORGSTRUCTURE_DOMAIN = "types_orgstructure";

    @Autowired
    private TypesOrgstructureSerivce typesOrgstructureSerivce;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(TYPES_ORGSTRUCTURE_DIRECTORY_PARAMETER, typesOrgstructureSerivce.get());
        model.addAttribute("domain",TYPES_ORGSTRUCTURE_DOMAIN);
        model.addAttribute("primaryKey",TYPES_ORGSTRUCTURE_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = TYPES_ORGSTRUCTURE_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = TYPES_ORGSTRUCTURE_NAME_PARAMETER) String name,
                               @RequestParam(value = TYPES_ORGSTRUCTURE_CODE_PARAMETER) String code) {

        typesOrgstructureSerivce.create(TypesOrgStructure.builder()
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + TYPES_ORGSTRUCTURE_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = TYPES_ORGSTRUCTURE_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return typesOrgstructureSerivce.update(TypesOrgStructure.fromJSON(data));
    }

    @RequestMapping(value = TYPES_ORGSTRUCTURE_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return typesOrgstructureSerivce.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(TYPES_ORGSTRUCTURE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(TYPES_ORGSTRUCTURE_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }

}
