package by.belinvest.panel.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.DirContextSource;



@Configuration
@EnableLdapRepositories(basePackages = "by.belinvest.panel.admin.LDAP")
@PropertySource("classpath:LDAP.properties")
public class LDAPConfiguration {

    @Value( "${domain}" )
    private String domain;

    @Value( "${url}" )
    private String url;

    @Bean(name = "contextSource", destroyMethod = "")
    public DirContextSource contextSource()  {
        DirContextSource dirContextSource = new DirContextSource();
        dirContextSource.setUrl("ldap://"+url+":7001");
        dirContextSource.setUserDn("cn=Admin");
        dirContextSource.setPassword("12345678");
        dirContextSource.setBase("ou=myrealm,dc="+domain+"");
        return dirContextSource;
    }

    @Bean(name = "ldapTemplate", destroyMethod = "")
    public LdapTemplate ldapTemplate()  {
       return new LdapTemplate(contextSource());
    }

}
