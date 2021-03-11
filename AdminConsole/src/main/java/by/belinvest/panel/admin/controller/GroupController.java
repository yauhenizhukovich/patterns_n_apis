package by.belinvest.panel.admin.controller;

import by.belinvest.panel.admin.LDAP.UserLDAPRepository;
import by.belinvest.panel.admin.LDAP.WlsLdapUserRepository;
import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.User;
import by.belinvest.panel.admin.entity.UsersForRoles;
import by.belinvest.panel.admin.service.GroupService;
import by.belinvest.panel.admin.service.UserService;
import by.belinvest.panel.admin.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class GroupController {

    private static final String GET_GROUPS_URL = "/roles";
    private static final String GET_GROUPS_USER_NOT_MEMBERSHIP_URL = "/roles-user-is-not";
    private static final String CREATE_GROUP_URL = "/create-role";
    private static final String EDIT_GROUP_URL = "/edit-role";
    private static final String REMOVE_GROUP_URL = "/remove-role";

    private static final String GROUP_NAME_PARAMETER = "roleName";
    private static final String GROUP_DESCRIPTION_PARAMETER = "roleDescription";
    private static final String USER_NAME_PARAMETER = "userName";

    private static final String GROUPS_LIST_PARAMETER = "groups";
    private static final String GET_USERS_URL_JSON = "/get-user-names";
    private static final String GET_USERS_BY_ROLE = "/get-users-by-role";
    private static final String UPDATE_USER_GROUPS_MEMBERSHIP_URL_ROLE = "/update-user-roles-users";
    private static final String GET_AUTH = "get-auth";

    private final GroupService groupService;
    private final UserService userService;
    private final WlsLdapUserRepository wlsLdapUserRepository;
    private final UserLDAPRepository userLDAPRepository;

    private String GROUPS_JSP_PAGE = "roles";

    @Autowired
    public GroupController(GroupService groupService, UserService userService, WlsLdapUserRepository wlsLdapUserRepository,
                           UserLDAPRepository userLDAPRepository) {
        this.wlsLdapUserRepository = wlsLdapUserRepository;
        this.groupService = groupService;
        this.userService = userService;
        this.userLDAPRepository = userLDAPRepository;
    }

    @RequestMapping(value = GET_GROUPS_URL, method = RequestMethod.GET)
    public String getGroups(Model model) {
        model.addAttribute(GROUPS_LIST_PARAMETER, groupService.getGroups());
        return GROUPS_JSP_PAGE;
    }

    @RequestMapping(value = GET_USERS_URL_JSON, method = RequestMethod.GET)
    @ResponseBody
    public Set<String> getUserNames()  {
        Set<String> strings = userService.getUsersList().stream().map(User::getLogin).collect(Collectors.toSet());
        return strings;
    }

    @RequestMapping(value = GET_GROUPS_USER_NOT_MEMBERSHIP_URL, method = RequestMethod.GET)
    @ResponseBody
    public List<Group> getGroupsUserNotMembership(@RequestParam(required = false, value = USER_NAME_PARAMETER) String username) {

        List<Group> groups = groupService.getGroupsUserNotMembership(username);
        return groups;
    }

    @RequestMapping(value = CREATE_GROUP_URL, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createRole(@RequestBody Group group)  {
        AjaxResponseBody result = null;
        try {
            boolean isExist = true;//groupService.createGroup(group);
            if (!isExist) {
                result = new AjaxResponseBody("Роль  уже существует");
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Роль успешно создалась");
        return ResponseEntity.ok().body(result);
    }


    @RequestMapping(value = EDIT_GROUP_URL, method = RequestMethod.POST)
    public RedirectView editGroup(HttpServletRequest request,
                                  @RequestParam(value = GROUP_NAME_PARAMETER) String name,
                                  @RequestParam(value = GROUP_DESCRIPTION_PARAMETER) String description)  {

       // groupService.editGroup(name, description);
        return new RedirectView(request.getContextPath() + GET_GROUPS_URL);
    }


    @RequestMapping(value = REMOVE_GROUP_URL, method = RequestMethod.POST)
    public RedirectView removeGroup(HttpServletRequest request,
                                    @RequestParam(value = GROUP_NAME_PARAMETER) String name) {

        //groupService.removeGroup(name);
        return new RedirectView(request.getContextPath() + GET_GROUPS_URL);
    }

    @RequestMapping(value = GET_USERS_BY_ROLE, method = RequestMethod.GET)
    @ResponseBody
    public List<String> getUsersByGroup(@RequestParam String roleName)  {

        List<String> users = groupService.getUsersByGroup(roleName);
        return users;
    }

    @RequestMapping(value = UPDATE_USER_GROUPS_MEMBERSHIP_URL_ROLE, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> updateUserGroupsMembershipRole(@RequestParam String role,
                                                            @RequestBody UsersForRoles usersForRoles) {

        AjaxResponseBody result = null;
        try {
            groupService.updateUserGroupsMembershipRole(role, new HashSet<>(usersForRoles.getUsers()), Constants.CHANGE_SINGLE_USER,
                    new HashSet<>(usersForRoles.getRemoveUsers()));

        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Роль успешно создана");
        return ResponseEntity.ok().body(result);

    }

    @RequestMapping(value = GET_AUTH, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> c() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        //String authoritiesString = parseAuthorities(authenticationList);

        AjaxResponseBody result = new AjaxResponseBody(name);

        return ResponseEntity.ok().body(result);
    }

    private String parseAuthorities(Collection<? extends GrantedAuthority> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        collection.forEach(grantedAuthority -> {
            stringBuilder.append(grantedAuthority.getAuthority()).append("\n");
        });

        return stringBuilder.toString();
    }


}
