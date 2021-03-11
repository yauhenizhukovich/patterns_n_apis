package by.belinvest.panel.admin.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.Max;
import java.util.List;


public class Group implements GrantedAuthority {

    private String name;

    private String description;

    private List<User> usernames;


    public Group(String name) {
        this.name = name;
    }


    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<User> usernames) {
        this.usernames = usernames;
    }

}
