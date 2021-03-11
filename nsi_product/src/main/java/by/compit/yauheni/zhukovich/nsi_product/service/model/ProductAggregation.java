package by.compit.yauheni.zhukovich.nsi_product.service.model;

import java.util.List;

import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Card;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Credit;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Debit;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi.UrCred;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi.UrDep;

public class ProductAggregation {

    private List<UrDep> urDeps;
    private List<UrCred> urCreds;
    private List<Credit> credits;
    private List<Debit> debits;
    private List<Card> cards;

    public void setUrDeps(List<UrDep> urDeps) {
        this.urDeps = urDeps;
    }

    public List<UrDep> getUrDeps() {
        return urDeps;
    }

    public void setUrCreds(List<UrCred> urCreds) {
        this.urCreds = urCreds;
    }

    public List<UrCred> getUrCreds() {
        return urCreds;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setDebits(List<Debit> debits) {
        this.debits = debits;
    }

    public List<Debit> getDebits() {
        return debits;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

}
