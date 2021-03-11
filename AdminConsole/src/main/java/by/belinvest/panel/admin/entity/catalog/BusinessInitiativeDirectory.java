package by.belinvest.panel.admin.entity.catalog;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class BusinessInitiativeDirectory {

    private final List<BusinessInitiative> businessInitiatives = new ArrayList<>();

    public List<BusinessInitiative> getBusinessInitiatives() {
        return businessInitiatives;
    }
}