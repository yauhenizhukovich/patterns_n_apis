package by.belinvest.panel.admin.LDAP;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import javax.naming.Name;
import java.util.List;

@Entry(base="ou=people", objectClasses = { "top", "person", "inetOrgPerson", "organizationalPerson", "wlsuser" })
public class WlsLdapUser {
    @Id
    private Name dn;

    private @Attribute(name = "uid")
    String uid;

    private @Attribute(name = "userpassword")String password;

    private @Attribute(name = "st")String adddate;
    private @Attribute(name = "secretary") String surName;
    private @Attribute(name = "description")String firstName;
    private @Attribute(name = "pager")String paterName;
    private @Attribute(name = "mail")String usermail;
    private @Attribute(name = "homePhone")String telephoneNumber;
    private @Attribute(name = "telephoneNumber")String mobphone;
    private @Attribute(name = "postOfficeBox")String birthdate;
    private @Attribute(name = "departmentNumber")String dept;
    private @Attribute(name = "employeeType")String job;
    private @Attribute(name = "manager")String isCurator;
    private @Attribute(name = "seeAlso")String isblocked;
    private @Attribute(name = "initials") String roles;
    private List<String> groups;


    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPaterName() {
        return paterName;
    }

    public void setPaterName(String paterName) {
        this.paterName = paterName;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getMobphone() {
        return mobphone;
    }

    public void setMobphone(String mobphone) {
        this.mobphone = mobphone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIsCurator() {
        return isCurator;
    }

    public void setIsCurator(String isCurator) {
        this.isCurator = isCurator;
    }

    public String getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(String isblocked) {
        this.isblocked = isblocked;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WlsLdapUser() {
    }

    public WlsLdapUser(String uid) {
        this.uid = uid;

    }
}