package by.belinvest.panel.admin.nsi.service;

import by.belinvest.panel.admin.entity.nsi.balans2.Balans2;
import by.belinvest.panel.admin.entity.nsi.balans2.Balans2Directory;
import by.belinvest.panel.admin.nsi.db.Balans2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Balans2Service {

    private final Balans2Repository balans2Repository;

    @Autowired
    public Balans2Service(Balans2Repository balans2Repository) {
        this.balans2Repository = balans2Repository;
    }

    public Balans2Directory get() {
        return balans2Repository.get();
    }

    public boolean create(Balans2 balans2) {
        return balans2Repository.create(balans2);
    }

    public boolean update(Balans2 balans2) {
        return balans2Repository.update(balans2);
    }

    public boolean remove(String id) {
        return balans2Repository.remove(id);
    }

}
