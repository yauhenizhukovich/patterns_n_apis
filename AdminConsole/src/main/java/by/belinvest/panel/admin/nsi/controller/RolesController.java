package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.roles.Roles;
import by.belinvest.panel.admin.nsi.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/roles")
public class RolesController {

    private static final String BANK_CREATE_URL = "/create";
    private static final String BANK_EDIT_URL = "/edit";
    private static final String BANK_REMOVE_URL = "/remove";
    private static final String BANK_DIRECTORY_GET_URL = "/nsi/roles";

    private static final String ROLE_NAME_PARAMETER = "roleName";
    private static final String DESCRIPTION_PARAMETER = "description";
    private static final String LOGIN_USER_PARAMETER = "loginUser";


    private static final String ROLES_DIRECTORY_PARAMETER = "rolesDirectory";

    @Autowired
    private RolesService rolesService;


    private String NSI_ROLES_DIRECTORY_PAGE = "nsi/roles";


    @RequestMapping(method = RequestMethod.GET)
    public String getRolesDirectory(Model model) {
        model.addAttribute(ROLES_DIRECTORY_PARAMETER, rolesService.get());
        return NSI_ROLES_DIRECTORY_PAGE;
    }

    @RequestMapping(value = BANK_CREATE_URL, method = RequestMethod.POST)
    public RedirectView createBankEntry(HttpServletRequest request,
                                        @RequestParam(value = ROLE_NAME_PARAMETER) String roleName,
                                        @RequestParam(value = DESCRIPTION_PARAMETER) String description,
                                        @RequestParam(value = LOGIN_USER_PARAMETER) String loginUser) {

        rolesService.create(new Roles(
                null,
                roleName,
                description,
                loginUser)
        );

        return new RedirectView(request.getContextPath() + BANK_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = BANK_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean editRolesDirectoryEntries(@RequestBody Roles roles) {

        return rolesService.update(roles);
    }

    @RequestMapping(value = BANK_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean removeRolesDirectory(@RequestBody String id) {

        return rolesService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(ROLE_NAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(DESCRIPTION_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(LOGIN_USER_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }

}
