package by.belinvest.panel.admin.nsi.controller;


import by.belinvest.panel.admin.entity.FieldsType;
import by.belinvest.panel.admin.entity.nsi.proc_users.ProcUsers;
import by.belinvest.panel.admin.nsi.service.ProcUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/nsi/proc_users")
public class ProcUsersController {
    private static final String PROC_USERS_CREATE_URL = "/create";
    private static final String PROC_USERS_EDIT_URL = "/edit";
    private static final String PROC_USERS_REMOVE_URL = "/remove";
    private static final String PROC_USERS_DIRECTORY_GET_URL = "/nsi/proc_users";

    private static final String PROC_USERS_ID_PARAMETER = "DIMID";
    private static final String PROC_USERS_USER_ID_PARAMETER = "USER_ID";
    private static final String PROC_USERS_ROLE_ID_PARAMETER = "ROLE_ID";
    private static final String PROC_USERS_ROLE_DESC_PARAMETER = "ROLE_DESC";
    private static final String PROC_USERS_ROLE_LOCK_PARAMETER = "ROLE_LOCK";
    private static final String PROC_USERS_DATE_FROM_PARAMETER = "DATE_FROM";
    private static final String PROC_USERS_DATE_TO_PARAMETER = "DATE_TO";
    private static final String PROC_USERS_USER_FULLNAME_PARAMETER = "USER_FULLNAME";

    private static final String PROC_USERS_DIRECTORY_PARAMETER = "directoryDTO";
    private static final String PROC_USERS_PRIMARY_KEY = "ID";
    private static final String PROC_USERS_DOMAIN = "proc_users";

    @Autowired
    private ProcUsersService procUsersService;

    private String DIRECTORY_PAGE = "nsi/directory";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute(PROC_USERS_DIRECTORY_PARAMETER, procUsersService.get());
        model.addAttribute("domain", PROC_USERS_DOMAIN);
        model.addAttribute("primaryKey", PROC_USERS_PRIMARY_KEY);
        model.addAttribute("fields", getFieldsType());
return DIRECTORY_PAGE;
    }

    @RequestMapping(value = PROC_USERS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = PROC_USERS_USER_ID_PARAMETER) String userId,
                               @RequestParam(value = PROC_USERS_ROLE_ID_PARAMETER) String roleId,
                               @RequestParam(value = PROC_USERS_ROLE_DESC_PARAMETER) String roleDesc,
                               @RequestParam(value = PROC_USERS_ROLE_LOCK_PARAMETER) String roleLock,
                               @RequestParam(value = PROC_USERS_DATE_FROM_PARAMETER) String dateFrom,
                               @RequestParam(value = PROC_USERS_DATE_TO_PARAMETER) String dateTo,
                               @RequestParam(value = PROC_USERS_USER_FULLNAME_PARAMETER) String userFullname) {

        procUsersService.create(ProcUsers.builder()
                .userId(userId)
                .roleId(roleId)
                .roleDesc(roleDesc)
                .roleLock(roleLock)
                .dateFrom(dateFrom)
                .dateTo(dateTo)
                .userFullname(userFullname)
                .build()
        );
        return new RedirectView(request.getContextPath() + PROC_USERS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = PROC_USERS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody HashMap<String, String> data) {
        return procUsersService.update(ProcUsers.fromJSON(data));
    }

    @RequestMapping(value = PROC_USERS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return procUsersService.remove(id);
    }

    private Map<String, String> getFieldsType(){
        Map<String, String> fieldsMap = new HashMap<>();
        fieldsMap.put(PROC_USERS_USER_ID_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_USERS_ROLE_ID_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_USERS_ROLE_DESC_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_USERS_ROLE_LOCK_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_USERS_DATE_FROM_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_USERS_DATE_TO_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        fieldsMap.put(PROC_USERS_USER_FULLNAME_PARAMETER, FieldsType.VARCHAR_FIELD_TYPE);
        return fieldsMap;
    }
}
