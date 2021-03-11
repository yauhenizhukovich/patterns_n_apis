package by.belinvest.panel.admin.entity.nsi.roles;


import by.belinvest.panel.admin.entity.nsi.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles extends Directory {
    private String idRole;
    private String roleName;
    private String description;
    private String loginUser;
}
