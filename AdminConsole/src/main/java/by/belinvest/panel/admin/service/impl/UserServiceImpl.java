package by.belinvest.panel.admin.service.impl;

import by.belinvest.panel.admin.LDAP.*;
import by.belinvest.panel.admin.LDAP.mappers.StaticMapper;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.User;
import by.belinvest.panel.admin.service.Permission;
import by.belinvest.panel.admin.service.UserService;

import by.belinvest.panel.admin.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final static String USERNAME = "userName";
    private final static String PASSWORD = "passWord";
    private final static String DESCRIPTION = "userDescription";
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final WlsLdapUserRepository wlsLdapUserRepository;
    private final UserLDAPRepository userLDAPRepository;
    private final GroupLDAPRepository groupLDAPRepository;
    private final Permission permission;


    @Autowired
    public UserServiceImpl(
            WlsLdapUserRepository wlsLdapUserRepository, UserLDAPRepository userLDAPRepository,
            GroupLDAPRepository groupLDAPRepository,
            Permission permission) {
        this.permission = permission;
        this.groupLDAPRepository = groupLDAPRepository;
        this.wlsLdapUserRepository = wlsLdapUserRepository;
        this.userLDAPRepository = userLDAPRepository;
    }

    @Override
    public List<User> getUsersList() {
        Iterable<WlsLdapUser> users = userLDAPRepository.findAll();
        List<User> userList = new ArrayList<>();

        for (WlsLdapUser wlsLdapUser : users) {
            wlsLdapUser.setGroups(wlsLdapUserRepository.getUserGroups(wlsLdapUser));
            User user = StaticMapper.mapWlsToUser(wlsLdapUser);
            userList.add(user);
        }
        return userList;
    }


    @Override
    public List<User> getLDAPUsers() {
        return new ArrayList<>();
    }

    @Override
    public User getUserInfo(String username) {
        Iterable<WlsLdapUser> all = userLDAPRepository.findAll();
        List<User> users = new ArrayList<>();

        all.forEach(wlsLdapUser -> {
            if (wlsLdapUser.getUid().equals(username)) {
                User user = StaticMapper.mapWlsToUser(wlsLdapUser);
                users.add(user);
            }
        });
        if (users.isEmpty()) {
            return null;
        }

        return users.get(0);
    }


    @Override
    public boolean createUser(User user) {
        user.setAdddate(dateFormat.format(new Date()));

        Iterable<WlsLdapUser> wlsLdapUsers = userLDAPRepository.findAll();

        for (WlsLdapUser wlsLdapUser : wlsLdapUsers) {
            if (wlsLdapUser.getUid().equals(user.getLogin())) {
                return false;
            }
        }

        wlsLdapUserRepository.create(StaticMapper.mapUserToWls(user));
        if (!user.getRoles().isEmpty()) {
        }
        return true;
    }


    @Override
    public List<Group> getUserGroups(String username) {
        List<Group> groups = new ArrayList<>();
        Iterable<WlsLdapUser> wlsLdapUsers = userLDAPRepository.findAll();

        for (WlsLdapUser wlsLdapUser : wlsLdapUsers) {
            if (wlsLdapUser.getUid().equals(username)) {
                List<String> strings = wlsLdapUserRepository.getUserGroups(wlsLdapUser);
                groups = strings.stream().map(s -> new Group(s)).collect(Collectors.toList());
            }
        }
        return groups;
    }

    @Override
    public boolean updateUserGroupsMembership(String username, Set<String> groupNames, String operation, Set<String> removeUsers) {

        Iterable<WlsLdapUser> wlsLdapUsers = userLDAPRepository.findAll();

        List<String> oldRoles = new ArrayList<>();

        WlsLdapUser w = null;

        for (WlsLdapUser wlsLdapUser : wlsLdapUsers) {
            if (wlsLdapUser.getUid().equals(username)) {
                List<String> strings = groupNames.stream().collect(Collectors.toList());
                w = wlsLdapUser;
                w.setPassword(wlsLdapUser.getPassword());
                List<String> userGroups = wlsLdapUserRepository.getUserGroups(wlsLdapUser);
                oldRoles = userGroups;

                if (operation.equals(Constants.CHANGE_SINGLE_USER)) {

                    strings.addAll(userGroups);
                }
                strings.stream().distinct().collect(Collectors.toList());
                w.getGroups().addAll(strings);
            }
        }
        if (w != null) {
            wlsLdapUserRepository.updateRoles(w);
        }
        for (WlsLdapUser wlsLdapUser : wlsLdapUsers) {
            if (removeUsers.contains(wlsLdapUser.getUid())){
                List<String> userGroups = wlsLdapUserRepository.getUserGroups(wlsLdapUser);
                List<String> g = new ArrayList<>(groupNames);
                userGroups.removeIf(s -> s.equals(g.get(0)));
                w = wlsLdapUser;
                w.setPassword(wlsLdapUser.getPassword());

                wlsLdapUserRepository.deleteRoles(w,new ArrayList<>(groupNames).get(0));
            }
        }
        return true;
    }
}
