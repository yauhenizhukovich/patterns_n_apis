package by.belinvest.panel.admin.LDAP;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import java.util.Collection;

@Entry(base="ou=groups", objectClasses = { "top", "groupOfURLs", "groupOfUniqueNames" })
public class WlsLdapGroup {
    @Id
    private Name dn;

    private @Attribute(name = "cn")
    String uid;

    private @Attribute(name = "description")
    String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Name getDn() {
        return dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
