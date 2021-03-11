package by.belinvest.panel.admin.entity.nsi.users;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsersDirectory {

    private final List<Users> users = new ArrayList<>();

    private String idUserDescription;
    private String adddateDescription;
    private String surnameDescription;
    private String firstNameDescription;
    private String paterNameDescription;
    private String userloginDescription;
    private String userpwdDescription;
    private String idRoleDescription;
    private String usermailDescription;
    private String phoneDescription;
    private String mobphoneDescription;
    private String birthdateDescription;
    private String deptDescription;
    private String jobDescription;
    private String iscuratorDescription;
    private String isblockedDescription;

}
