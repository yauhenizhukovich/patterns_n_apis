package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.nsi.users.Users;
import by.belinvest.panel.admin.nsi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/nsi/users")
public class UsersController {

    private static final String USERS_CREATE_URL = "/create";
    private static final String USERS_EDIT_URL = "/edit";
    private static final String USERS_REMOVE_URL = "/remove";
    private static final String USERS_DIRECTORY_GET_URL = "/nsi/users";

    private static final String USERS_DIMID_PARAMETER = "DIMID";
    private static final String USERS_ADDDATE_PARAMETER = "adddate";
    private static final String USERS_SURNAME_PARAMETER = "surname";
    private static final String USERS_FIRST_NAME_PARAMETER = "firstName";
    private static final String USERS_PATER_NAME_PARAMETER = "paterName";
    private static final String USERS_USERLOGIN_PARAMETER = "userlogin";
    private static final String USERS_USERPWD_PARAMETER = "userpwd";
    private static final String USERS_ID_ROLE_PARAMETER = "idRole";
    private static final String USERS_USEREMAIL_PARAMETER = "usermail";
    private static final String USERS_PHONE_PARAMETER = "phone";
    private static final String USERS_MOBPHONE_PARAMETER = "mobphone";
    private static final String USERS_BIRTHDATE_PARAMETER = "birthdate";
    private static final String USERS_DEPT_PARAMETER = "dept";
    private static final String USERS_JOB_PARAMETER = "job";
    private static final String USERS_ISCURATOR_PARAMETER = "iscurator";
    private static final String USERS_ISBLOCKED_PARAMETER = "isblocked";


    private static final String USERS_DIRECTORY_PARAMETER = "usersDirectory";

    @Autowired
    private UsersService usersService;

    private String DIRECTORY_PAGE = "nsi/users";

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        System.out.println("!!!!!!!!!!!!!!!!!!"+usersService.get());
        model.addAttribute(USERS_DIRECTORY_PARAMETER, usersService.get());
        return DIRECTORY_PAGE;
    }

    @RequestMapping(value = USERS_CREATE_URL, method = RequestMethod.POST)
    public RedirectView create(HttpServletRequest request,
                               @RequestParam(value = USERS_ADDDATE_PARAMETER) String adddate,
                               @RequestParam(value = USERS_SURNAME_PARAMETER) String surname,
                               @RequestParam(value = USERS_FIRST_NAME_PARAMETER) String firstName,
                               @RequestParam(value = USERS_PATER_NAME_PARAMETER) String paterName,
                               @RequestParam(value = USERS_USERLOGIN_PARAMETER) String userlogin,
                               @RequestParam(value = USERS_USERPWD_PARAMETER) String userpwd,
                               @RequestParam(value = USERS_ID_ROLE_PARAMETER) String idRole,
                               @RequestParam(value = USERS_USEREMAIL_PARAMETER) String usermail,
                               @RequestParam(value = USERS_PHONE_PARAMETER) String phone,
                               @RequestParam(value = USERS_MOBPHONE_PARAMETER) String mobphone,
                               @RequestParam(value = USERS_BIRTHDATE_PARAMETER) String birthdate,
                               @RequestParam(value = USERS_DEPT_PARAMETER) String dept,
                               @RequestParam(value = USERS_JOB_PARAMETER) String job,
                               @RequestParam(value = USERS_ISCURATOR_PARAMETER) String iscurator,
                               @RequestParam(value = USERS_ISBLOCKED_PARAMETER) String isblocked) {
        System.out.println(new Users(null, adddate, surname, firstName, paterName,
                userlogin, userpwd, idRole, usermail, phone, mobphone, birthdate,
                dept, job, iscurator, isblocked));
        usersService.create(new Users(null, adddate, surname, firstName, paterName,
                userlogin, userpwd, idRole, usermail, phone, mobphone, birthdate,
                dept, job, iscurator, isblocked)
        );
        return new RedirectView(request.getContextPath() + USERS_DIRECTORY_GET_URL);
    }

    @RequestMapping(value = USERS_EDIT_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean edit(@RequestBody Users users) {
        return usersService.update(users);
    }

    @RequestMapping(value = USERS_REMOVE_URL, method = RequestMethod.POST)
    @ResponseBody
    public boolean remove(@RequestBody String id) {
        return usersService.remove(id);
    }


}
