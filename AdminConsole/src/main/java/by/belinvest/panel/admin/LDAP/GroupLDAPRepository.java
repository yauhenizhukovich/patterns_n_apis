package by.belinvest.panel.admin.LDAP;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface GroupLDAPRepository extends LdapRepository<WlsLdapGroup> {

}
