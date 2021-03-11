package by.belinvest.panel.admin.entity.catalog;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class BusinessOfferDirectory {

    private final List<BusinessOffer> businessOffers = new ArrayList<>();

    public List<BusinessOffer> getBusinessOffers() {
        return businessOffers;
    }
}
