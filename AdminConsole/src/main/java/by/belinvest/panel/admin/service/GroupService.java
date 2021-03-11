package by.belinvest.panel.admin.service;

import by.belinvest.panel.admin.entity.Group;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface GroupService {

    List<Group> getGroups();

    List<Group> getGroupsUserNotMembership(String username) ;

    List<String> getUsersByGroup(String roleName) ;

    boolean updateUserGroupsMembershipRole(String role, HashSet<String> strings,String operation,Set<String> removeUsers);
}
