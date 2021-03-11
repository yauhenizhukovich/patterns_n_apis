package by.belinvest.panel.admin.entity.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessOffer {

    private String idBo;
    private String boName;
    private String boStatus;
    private String productManeger;
    private String productManegerPosition;
    private String productManegerPhone;
    private String productManegerDept;
    private String productManegerSupervisor;
    private String productManegerSupervisorPos;
    private String productManegerSupervisorPhone;
}
