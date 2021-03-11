package by.belinvest.panel.admin.service;

import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.User;
import by.belinvest.panel.admin.entity.UserTable;


import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> getUsersList();

    List<User> getLDAPUsers();

    boolean createUser(User user);


    List<Group> getUserGroups(String username) ;

    boolean updateUserGroupsMembership(String username, Set<String> groupNames,String operation,Set<String> removeUsers);

    User getUserInfo(String username);
}
