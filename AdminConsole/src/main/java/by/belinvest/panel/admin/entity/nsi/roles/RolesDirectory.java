package by.belinvest.panel.admin.entity.nsi.roles;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RolesDirectory {

    private final List<Roles> roles = new ArrayList<>();

    private String idRoleDescription;
    private String roleNameDescription;
    private String descriptionDescription;
    private String loginUserDescription;

}
