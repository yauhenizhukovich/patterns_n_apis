package by.belinvest.panel.admin.LDAP.mappers;

import by.belinvest.panel.admin.LDAP.WlsLdapUser;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StaticMapper {
    public static User mapWlsToUser(WlsLdapUser wlsLdapUser){
        User user = new User();
        user.setLogin(wlsLdapUser.getUid()==null ? "" :wlsLdapUser.getUid());
        user.setAdddate(wlsLdapUser.getAdddate()==null ? "" :wlsLdapUser.getAdddate());
        user.setFirstName(wlsLdapUser.getFirstName()==null ? "" :wlsLdapUser.getFirstName());
        user.setSurName(wlsLdapUser.getSurName()==null ? "" :wlsLdapUser.getSurName());
        user.setPaterName(wlsLdapUser.getPaterName()==null ? "" :wlsLdapUser.getPaterName());

        user.setUsermail(wlsLdapUser.getUsermail()==null ? "" :wlsLdapUser.getUsermail());
        user.setPhone(wlsLdapUser.getTelephoneNumber()==null ? "" :wlsLdapUser.getTelephoneNumber());
        user.setMobphone(wlsLdapUser.getMobphone()==null ? " " :wlsLdapUser.getMobphone());
        user.setSurName(wlsLdapUser.getSurName()==null ? "" :wlsLdapUser.getSurName());
        user.setBirthdate(wlsLdapUser.getBirthdate()==null ? "" :wlsLdapUser.getBirthdate());

        user.setDept(wlsLdapUser.getDept()==null ? "" :wlsLdapUser.getDept());
        user.setJob(wlsLdapUser.getJob()==null ? "" :wlsLdapUser.getJob());
        user.setIsCurator(wlsLdapUser.getIsCurator()==null ? "" :wlsLdapUser.getIsCurator());
        user.setIsblocked(wlsLdapUser.getIsblocked()==null ? "" : wlsLdapUser.getIsblocked());

        /*if (wlsLdapUser.getRoles()!=null){
            Set<Group> groups = new HashSet<>();
            String[] rolz = wlsLdapUser.getRoles().split(" ");
            for (int i = 0; i < rolz.length; i++) {
                groups.add(new Group(rolz[i]));
            }
            user.setGroups(groups);
        }*/

        if (wlsLdapUser.getGroups()!=null){
           Set<Group> groups =  wlsLdapUser.getGroups().stream().map(s -> new Group(s)).collect(Collectors.toSet());
           user.setGroups(groups);
        }


        return user;
    }

    public static WlsLdapUser mapUserToWls(User userr){
        WlsLdapUser user = new WlsLdapUser();

        user.setUid(userr.getLogin()==null ? "" :userr.getLogin());
        user.setPassword(userr.getPassword()==null ? "" :userr.getPassword());
        user.setAdddate(userr.getAdddate()==null ? "" :userr.getAdddate());

        user.setFirstName(userr.getFirstName()==null ? "" :userr.getFirstName());
        user.setSurName(userr.getSurName()==null ? "" :userr.getSurName());
        user.setPaterName(userr.getPaterName()==null ? "" :userr.getPaterName());

        user.setUsermail(userr.getUsermail()==null ? "" :userr.getUsermail());
        user.setTelephoneNumber(userr.getPhone()==null ? "" :userr.getPhone());
        user.setMobphone(userr.getMobphone()==null ? "" : userr.getMobphone());
        user.setBirthdate(userr.getBirthdate()==null ? "" : userr.getBirthdate());

        user.setDept(userr.getDept()==null ? "" :userr.getDept());
        user.setJob(userr.getJob()==null ? "" :userr.getJob());
        user.setIsCurator(userr.getIsCurator()==null ? "" :userr.getIsCurator());
        user.setIsblocked(userr.getIsblocked()==null ? "" : userr.getIsblocked());

        if (userr.getRoles()!=null && !userr.getRoles().isEmpty()){
            //Set<Group> groups = userr.getRoles().stream().map(s -> new Group(s)).collect(Collectors.toSet());
            user.setGroups(userr.getRoles());
        }



        if (userr.getGroups()!=null && !userr.getGroups().isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            userr.getGroups().forEach(s -> {
                stringBuilder.append(s.getAuthority()+ " ");
                user.setRoles(stringBuilder.toString());
            });


        }
        return user;
    }
}
