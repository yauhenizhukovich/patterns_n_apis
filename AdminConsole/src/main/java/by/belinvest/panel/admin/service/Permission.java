package by.belinvest.panel.admin.service;

import by.belinvest.panel.admin.LDAP.UserLDAPRepository;
import by.belinvest.panel.admin.LDAP.WlsLdapUser;
import by.belinvest.panel.admin.LDAP.WlsLdapUserRepository;
import by.belinvest.panel.admin.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Permission {
    @Autowired
    private UserLDAPRepository userLDAPRepository;

    @Autowired
    private WlsLdapUserRepository wlsLdapUserRepository;


    public boolean isAdmin(String username){

        Iterable<WlsLdapUser> users = userLDAPRepository.findAll();

        for (WlsLdapUser wlsLdapUser :users){
            if (wlsLdapUser.getUid().equals(username)){
                List<String> groupListt = wlsLdapUserRepository.getUserGroups(wlsLdapUser);
                   if (groupListt.contains("Admin")) {
                       return true;
                   }
            }
        }
        return false;
    }

}
