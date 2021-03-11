package by.belinvest.panel.admin.entity.nsi.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    private String id;
    private String code;
    private String name;
    private String banksPryam;
    private String banksRegion;
    private String banksOldCode;
    private String banksBiciso;
    private String banksRang;
    private String banksKodGb;
    private String banksKodAutu;
    private String banksAddress;
    private String banksKodType;
    private String banksKodSoato;
    private String banksKodStatu;
    private String banksPhone;

}
