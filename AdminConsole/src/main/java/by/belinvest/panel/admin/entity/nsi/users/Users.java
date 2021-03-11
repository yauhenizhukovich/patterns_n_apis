package by.belinvest.panel.admin.entity.nsi.users;


import by.belinvest.panel.admin.entity.nsi.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users extends Directory {
    private String idUser;
    private String adddate;
    private String surname;
    private String firstName;
    private String paterName;
    private String userlogin;
    private String userpwd;
    private String idRole;
    private String usermail;
    private String phone;
    private String mobphone;
    private String birthdate;
    private String dept;
    private String job;
    private String iscurator;
    private String isblocked;

//    public static Users fromJSON(HashMap<String,String> json){
//        return Users.builder()
//                .idUser(json.get("id"))
//                .addate(json.get("ADDDATE"))
//                .surname(json.get("SURNAME"))
//                .firstName(json.get("FIRST_NAME"))
//                .paterName(json.get("PATER_NAME"))
//                .userlogin(json.get("USERLOGIN"))
//                .userpwd(json.get("USERPWD"))
//                .idRole(json.get("ID_ROLE"))
//                .usermail(json.get("USEREMAIL"))
//                .phone(json.get("PHONE"))
//                .mobphone(json.get("MOBPHONE"))
//                .birthdate(json.get("BIRTHDATE"))
//                .dept(json.get("DEPT"))
//                .job(json.get("JOB"))
//                .iscurator(json.get("ISCURATOR"))
//                .isblocked(json.get("ISBLOCKED"))
//                .build();
//    }
}
