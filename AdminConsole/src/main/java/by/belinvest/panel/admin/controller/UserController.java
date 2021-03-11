package by.belinvest.panel.admin.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.User;
import by.belinvest.panel.admin.service.Permission;
import by.belinvest.panel.admin.service.UserService;
import com.google.gson.internal.$Gson$Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class UserController {

    private static final String GET_USERS_URL = "/users";
    private static final String GET_LDAP_USERS = "/ldap-users";
    private static final String CREATE_USER_URL = "/create-user";
    private static final String LOAD_LDAP_USERS_URL = "/load-ldap-users";
    private static final String UPDATE_LDAP_USER_URL = "/update-ldap-user";
    private static final String GET_USER_GROUPS_URL = "/user-roles";
    private static final String UPDATE_USER_GROUPS_MEMBERSHIP_URL = "/update-user-roles";
    private static final String GET_USER_INFO = "/get-info-by-user";

    private static final String USER_NAME_PARAMETER = "userName";
    private static final String USER_DESCRIPTION_PARAMETER = "userDescription";
    private static final String UPDATE_LDAP_USERS_IF_EXIST_PARAMETER = "updateIfExist";

    private static final String USERS_LIST_PARAMETER = "usersList";

    private String USERS_JSP_PAGE = "users-list";

    private final UserService userService;
    private final Permission permission;

    @Autowired
    public UserController(UserService userService, Permission permission) {
        this.permission = permission;
        this.userService = userService;
    }


    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers()  {
        return userService.getUsersList();
    }

    @RequestMapping(value = GET_USERS_URL, method = RequestMethod.GET)
    public String getUsersList(Model model,
                               @RequestParam(required = false) String fail){


        model.addAttribute(USERS_LIST_PARAMETER, userService.getUsersList());

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
       // if (permission.isAdmin(username)) {
            return USERS_JSP_PAGE;
       // }
        //return "denied";
    }

    @RequestMapping(value = GET_LDAP_USERS, method = RequestMethod.GET)
    @ResponseBody
    public List<User> getLDAPUsers()  {
        return userService.getLDAPUsers();
    }

    @RequestMapping(value = GET_USER_INFO, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserInfo(@RequestParam(value = USER_NAME_PARAMETER) String username) {
       User user  = userService.getUserInfo(username);
       if (user==null){
           return ResponseEntity.badRequest().body("");
       }
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = CREATE_USER_URL, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody User user) {
        AjaxResponseBody result = null;
        try {
            boolean isExist = userService.createUser(user);
            if (!isExist) {
                result = new AjaxResponseBody("пользователь уже существует");
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("пользователь успешно создался");
        return ResponseEntity.ok().body(result);
    }


    @RequestMapping(value = UPDATE_USER_GROUPS_MEMBERSHIP_URL, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> updateUserGroupsMembership(@RequestParam(value = USER_NAME_PARAMETER) String username,
                                              @RequestBody List<String> groupNames) {

        AjaxResponseBody result = null;
        try {
             userService.updateUserGroupsMembership(username, new HashSet<>(groupNames),"",new HashSet<>());
        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            e.printStackTrace();
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Роль пользователя изменена");
        return ResponseEntity.ok().body(result);

    }

    @RequestMapping(value = GET_USER_GROUPS_URL, method = RequestMethod.GET)
    @ResponseBody
    public List<Group> getUserGroups(@RequestParam(value = USER_NAME_PARAMETER) String username)  {
        return userService.getUserGroups(username);
    }
}
