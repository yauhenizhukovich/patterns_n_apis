package by.belinvest.panel.admin.entity.catalog;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class BPCardDirectory {

    private final List<BPCard> bpCards = new ArrayList<>();

    public List<BPCard> getBpCards() {
        return bpCards;
    }
}
