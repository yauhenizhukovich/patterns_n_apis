package by.belinvest.panel.admin.entity.nsi.bank;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BankDirectory {

    private final List<Bank> banks = new ArrayList<>();

    private String codeDescription;
    private String nameDescription;
    private String banksPryamDescription;
    private String banksRegionDescription;
    private String banksOldCodeDescription;
    private String banksBicisoDescription;
    private String banksRangDescription;
    private String banksKodGbDescription;
    private String banksKodAutuDescription;
    private String banksAddressDescription;
    private String banksKodTypeDescription;
    private String banksKodSoatoDescription;
    private String banksKodStatuDescription;
    private String banksPhoneDescription;

}
