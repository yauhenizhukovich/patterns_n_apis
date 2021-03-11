package by.belinvest.panel.admin.entity;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

public class UsersForRoles {

    List<String> users;
    List<String> removeUsers;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<String> getRemoveUsers() {
        return removeUsers;
    }

    public void setRemoveUsers(List<String> removeUsers) {
        this.removeUsers = removeUsers;
    }
}
