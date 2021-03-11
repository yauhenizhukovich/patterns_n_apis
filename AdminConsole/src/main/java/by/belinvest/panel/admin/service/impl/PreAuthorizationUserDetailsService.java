package by.belinvest.panel.admin.service.impl;

import by.belinvest.panel.admin.LDAP.UserLDAPRepository;
import by.belinvest.panel.admin.LDAP.WlsLdapUser;
import by.belinvest.panel.admin.LDAP.WlsLdapUserRepository;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PreAuthorizationUserDetailsService implements AuthenticationUserDetailsService {

    @Autowired
    private WlsLdapUserRepository wlsLdapUserRepository;
    @Autowired
    private UserLDAPRepository userLDAPRepository;


    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {

        Set<Group> groups = getAuthRoles((String)token.getPrincipal());


        return new User(
                (String) token.getPrincipal(),
                "unused",
                true,
                true,
                true,
                true,
                groups);
    }

   private Set<Group> getAuthRoles(String tokenName){
        Set<Group> groups = new HashSet<>();
       Iterable<WlsLdapUser> ss = userLDAPRepository.findAll();
       for (WlsLdapUser wlsLdapUser : ss){
           if (wlsLdapUser.getUid().equals(tokenName)){
               groups = wlsLdapUserRepository.getUserGroups(wlsLdapUser).stream().map(s -> new Group(s)).collect(Collectors.toSet());
           }
       }
       return groups;
   }

}
