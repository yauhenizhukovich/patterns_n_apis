package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.proc_roles.ProcRoles;
import by.belinvest.panel.admin.nsi.service.ProcRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/proc_roles")
public class ProcRolesController {
    private static final String PROC_ROLES_CREATE_URL = "/create";
    private static final String PROC_ROLES_EDIT_URL = "/edit";
    private static final String PROC_ROLES_REMOVE_URL = "/remove";
    private static final String PROC_ROLES_DIRECTORY_GET_URL = "/nsi/proc_roles";

    private static final String PROC_ROLES_ID_PARAMETER = "ID";
    private static final String PROC_ROLES_ROLE_NAME_PARAMETER = "ROLE_NAME";
    private static final String PROC_ROLES_ROLE_DESC_PARAMETER = "ROLE_DESC";
    private static final String PROC_ROLES_ROLE_DESC2_PARAMETER = "ROLE_DESC2";
    private static final String PROC_ROLES_CREATE_DATE_PARAMETER = "CREATE_DATE";

    private static final String PROC_ROLES_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PROC_ROLES_PRIMARY_KEY = "ID";
    private static final String PROC_ROLES_DOMAIN = "proc_roles";

    @Autowired
    private ProcRolesService procRolesService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PROC_ROLES_DIRECTORY_PARAMETER, procRolesService.get());
        model.addAttribute("domain", PROC_ROLES_DOMAIN);
        model.addAttribute("primaryKey", PROC_ROLES_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PROC_ROLES_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PROC_ROLES_ROLE_NAME_PARAMETER) String roleName,
                               @RequestParam(value = PROC_ROLES_ROLE_DESC_PARAMETER) String roleDesc,
                               @RequestParam(value = PROC_ROLES_ROLE_DESC2_PARAMETER) String roleDesc2,
                               @RequestParam(value = PROC_ROLES_CREATE_DATE_PARAMETER) String creatDate) {

        procRolesService.create(ProcRoles.builder()
                .roleName(roleName)
                .roleDesc(roleDesc)
                .roleDesc2(roleDesc2)
                .creatDate(creatDate)
                .build()
        );
        return new RedirectView(request.getContextPath() + PROC_ROLES_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PROC_ROLES_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return procRolesService.update(ProcRoles.fromJSON(data));
    }

    @RequestMapping(value = PROC_ROLES_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return procRolesService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PROC_ROLES_ROLE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_ROLES_ROLE_DESC_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_ROLES_ROLE_DESC2_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_ROLES_CREATE_DATE_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
