package by.belinvest.panel.admin.entity;

import by.belinvest.panel.admin.entity.nsi.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String login;
    private String description;
    private String password;
    private List<String> roles;
    private String rolez;
    private Set<Group> groups;

    private String adddate;
    private String surName;
    private String firstName;
    private String paterName;
    private String usermail;
    private String phone;
    private String mobphone;
    private String birthdate;
    private String dept;
    private String job;
    private String isCurator;
    private String isblocked;

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public User(String name, String adddate, String surName, Set<Group> groups) {
        this.login = name;
        this.adddate = adddate;
        this.groups = groups;
        this.surName = surName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getRolez() {
        return rolez;
    }

    public void setRolez(String rolez) {
        this.rolez = rolez;
    }
}
