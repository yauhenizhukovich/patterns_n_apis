package by.belinvest.panel.admin.service.impl;

import by.belinvest.panel.admin.LDAP.*;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.User;
import by.belinvest.panel.admin.service.GroupService;
import by.belinvest.panel.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GroupServiceImpl implements GroupService {


    private final UserService userService;
    private final GroupLDAPRepository groupLDAPRepository;
    private final WlsLdapUserRepository wlsLdapUserRepository;
    private final UserLDAPRepository userLDAPRepository;

    @Autowired
    public GroupServiceImpl(UserService userService,GroupLDAPRepository groupLDAPRepository,
                            WlsLdapUserRepository wlsLdapUserRepository,
                            UserLDAPRepository userLDAPRepository) {
        this.userLDAPRepository = userLDAPRepository;
        this.wlsLdapUserRepository = wlsLdapUserRepository;
        this.groupLDAPRepository = groupLDAPRepository;
        this.userService = userService;
    }


    @Override
    public List<Group> getGroups()  {
        List<Group> groups = new ArrayList<>();
        Iterable<WlsLdapGroup> iterable = groupLDAPRepository.findAll();


        for (WlsLdapGroup wlsLdapGroup : iterable){
            Group group = new Group(wlsLdapGroup.getUid());
            group.setDescription(wlsLdapGroup.getDescription());
            List<String> strings  = getUsersByGroup(group.getAuthority());
            List<User> users = strings.stream().map(User::new).collect(Collectors.toList());
            group.setUsernames(users);
            groups.add(group);
        }
       // groups.removeIf(group -> group.getAuthority().equals("Administrators"));

        return groups;
    }

    @Override
    public List<Group> getGroupsUserNotMembership(String username)  {
        return getGroups();
    }

    @Override
    public List<String> getUsersByGroup(String roleName)  {
        List<User> userList = userService.getUsersList();
        Iterable<WlsLdapGroup> groups = groupLDAPRepository.findAll();

        List<String> strings = new ArrayList<>();
       // userList.stream().filter(u)

        for (User user : userList){
            if(user.getGroups()!=null && !user.getGroups().isEmpty()){
                Set<Group> groupsSet = user.getGroups();
               List<Group> filterGroups =  groupsSet.stream()
                        .filter(group -> group.getAuthority().equals(roleName)).collect(Collectors.toList());

               if (!filterGroups.isEmpty()){
                   strings.add(user.getLogin());
               }
            }
        }
        return strings;
    }

    @Override
    public boolean updateUserGroupsMembershipRole(String role, HashSet<String> users, String operation,Set<String> removeUsers) {

        for (String user : users) {
            userService.updateUserGroupsMembership(user, Collections.singleton(role),operation,removeUsers);

        }
        return true;
    }
}
