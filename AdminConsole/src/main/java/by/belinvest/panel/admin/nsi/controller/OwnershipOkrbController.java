package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.ownership_okrb.OwnershipOkrb;
import by.belinvest.panel.admin.nsi.service.OwnershipOkrbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/ownership_okrb")
public class OwnershipOkrbController {

    private static final String OWNERSHIP_OKRB_CREATE_URL = "/create";
    private static final String OWNERSHIP_OKRB_EDIT_URL = "/edit";
    private static final String OWNERSHIP_OKRB_REMOVE_URL = "/remove";
    private static final String OWNERSHIP_OKRB_DIRECTORY_GET_URL = "/nsi/ownership_okrb";

    private static final String OWNERSHIP_OKRB_DIMID_PARAMETER = "DIMID";
    private static final String OWNERSHIP_OKRB_PARENTID_PARAMETER = "PARENTID";
    private static final String OWNERSHIP_OKRB_CODE_PARAMETER = "CODE";
    private static final String OWNERSHIP_OKRB_NAME_PARAMETER = "NAME";

    private static final String OWNERSHIP_OKRB_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String OWNERSHIP_OKRB_PRIMARY_KEY = "DIMID";
    private static final String OWNERSHIP_OKRB_DOMAIN = "ownership_okrb";

    @Autowired
    private OwnershipOkrbService ownershipOkrbService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(OWNERSHIP_OKRB_DIRECTORY_PARAMETER, ownershipOkrbService.get());
        model.addAttribute("domain",OWNERSHIP_OKRB_DOMAIN);
        model.addAttribute("primaryKey",OWNERSHIP_OKRB_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = OWNERSHIP_OKRB_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = OWNERSHIP_OKRB_PARENTID_PARAMETER) String parentId,
                               @RequestParam(value = OWNERSHIP_OKRB_CODE_PARAMETER) String code,
                               @RequestParam(value = OWNERSHIP_OKRB_NAME_PARAMETER) String name){

        ownershipOkrbService.create(OwnershipOkrb.builder()
                .parentId(parentId)
                .code(code)
                .name(name)
                .build()
        );
        return new RedirectView(request.getContextPath() + OWNERSHIP_OKRB_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = OWNERSHIP_OKRB_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String,String> data) {
        return ownershipOkrbService.update(OwnershipOkrb.fromJSON(data));
    }

    @RequestMapping(value = OWNERSHIP_OKRB_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return ownershipOkrbService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(OWNERSHIP_OKRB_PARENTID_PARAMETER, FieldsType.NUMBER_FIELD_TYPE);
        fieldsMap.put(OWNERSHIP_OKRB_CODE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(OWNERSHIP_OKRB_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
