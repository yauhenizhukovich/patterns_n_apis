package by.belinvest.panel.admin.entity.nsi.balans2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Balans2Directory {

    private final List<Balans2> balanses = new ArrayList<>();

    private String idDescription;
    private String dimIdDescription;
    private String scode1Description;
    private String scode2Description;
    private String scode3Description;
    private String scode4Description;
    private String nameDescription;
    private String accApDescription;
    private String accOcDescription;
    private String accPnDescription;
    private String auditCodeDescription;
    private String blClBankDescription;
    private String blDefaultDescription;
    private String blFormNameDescription;
    private String blNoDescription;
    private String blRequDescription;
    private String caOcDescription;
    private String raOcDescription;
    private String closeDescription;

}
