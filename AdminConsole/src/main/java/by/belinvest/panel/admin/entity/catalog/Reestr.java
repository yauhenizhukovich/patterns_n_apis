package by.belinvest.panel.admin.entity.catalog;


import by.belinvest.panel.admin.entity.nsi.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reestr extends Directory {

    private String noteId;
    private String sign;
    private String busInitId;
    private String busInitName;
    private String busInitStatus;
    private String busInitDate;
    private String busOffId;
    private String busOffName;
    private String busOffStatus;
    private String busOffDate;
    private String busProdCardId;
    private String busProdCardProductName;
    private String busProdCardProductStatus;
    private String busProdCardName;
    private String productId;
    private String productName;
    private String productHierId;

//    public static Reestr fromJSON(HashMap<String,String> json){
//        return Reestr.builder()
//                .id(json.get("id"))
//                .sign(json.get("SIGN"))
//                .bIId(json.get("BUSINESSINITIATIVE_ID"))
//                .bIName(json.get("BUSINESSINITIATIVE_NAME"))
//                .bIStatus(json.get("BUSINESSINITIATIVE_STATUS"))
//                .bIDate(json.get("BUSINESSINITIATIVE_DATE"))
//                .bIId(json.get("BUSINESSOFFER_ID"))
//                .bIName(json.get("BUSINESSOFFER_NAME"))
//                .bIStatus(json.get("BUSINESSOFFER_STATUS"))
//                .bIDate(json.get("BUSINESSOFFER_DATE"))
//                .bIId(json.get("BPCARD_ID"))
//                .bIName(json.get("BPCARD_PRODUCTNAME"))
//                .bIStatus(json.get("BPCARD_PRODUCTSTATUS"))
//                .bIDate(json.get("PRODUCT_NAME"))
//                .build();
//    }


    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBusInitId() {
        return busInitId;
    }

    public void setBusInitId(String busInitId) {
        this.busInitId = busInitId;
    }

    public String getBusInitName() {
        return busInitName;
    }

    public void setBusInitName(String busInitName) {
        this.busInitName = busInitName;
    }

    public String getBusInitStatus() {
        return busInitStatus;
    }

    public void setBusInitStatus(String busInitStatus) {
        this.busInitStatus = busInitStatus;
    }

    public String getBusInitDate() {
        return busInitDate;
    }

    public void setBusInitDate(String busInitDate) {
        this.busInitDate = busInitDate;
    }

    public String getBusOffId() {
        return busOffId;
    }

    public void setBusOffId(String busOffId) {
        this.busOffId = busOffId;
    }

    public String getBusOffName() {
        return busOffName;
    }

    public void setBusOffName(String busOffName) {
        this.busOffName = busOffName;
    }

    public String getBusOffStatus() {
        return busOffStatus;
    }

    public void setBusOffStatus(String busOffStatus) {
        this.busOffStatus = busOffStatus;
    }

    public String getBusOffDate() {
        return busOffDate;
    }

    public void setBusOffDate(String busOffDate) {
        this.busOffDate = busOffDate;
    }

    public String getBusProdCardId() {
        return busProdCardId;
    }

    public void setBusProdCardId(String busProdCardId) {
        this.busProdCardId = busProdCardId;
    }

    public String getBusProdCardProductName() {
        return busProdCardProductName;
    }

    public void setBusProdCardProductName(String busProdCardProductName) {
        this.busProdCardProductName = busProdCardProductName;
    }

    public String getBusProdCardProductStatus() {
        return busProdCardProductStatus;
    }

    public void setBusProdCardProductStatus(String busProdCardProductStatus) {
        this.busProdCardProductStatus = busProdCardProductStatus;
    }

    public String getBusProdCardName() {
        return busProdCardName;
    }

    public void setBusProdCardName(String busProdCardName) {
        this.busProdCardName = busProdCardName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductHierId() {
        return productHierId;
    }

    public void setProductHierId(String productHierId) {
        this.productHierId = productHierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reestr reestr = (Reestr) o;
        return Objects.equals(noteId, reestr.noteId) &&
                Objects.equals(sign, reestr.sign) &&
                Objects.equals(busInitId, reestr.busInitId) &&
                Objects.equals(busInitName, reestr.busInitName) &&
                Objects.equals(busInitStatus, reestr.busInitStatus) &&
                Objects.equals(busInitDate, reestr.busInitDate) &&
                Objects.equals(busOffId, reestr.busOffId) &&
                Objects.equals(busOffName, reestr.busOffName) &&
                Objects.equals(busOffStatus, reestr.busOffStatus) &&
                Objects.equals(busOffDate, reestr.busOffDate) &&
                Objects.equals(busProdCardId, reestr.busProdCardId) &&
                Objects.equals(busProdCardProductName, reestr.busProdCardProductName) &&
                Objects.equals(busProdCardProductStatus, reestr.busProdCardProductStatus) &&
                Objects.equals(busProdCardName, reestr.busProdCardName) &&
                Objects.equals(productId, reestr.productId) &&
                Objects.equals(productName, reestr.productName) &&
                Objects.equals(productHierId, reestr.productHierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, sign, busInitId, busInitName, busInitStatus, busInitDate, busOffId, busOffName, busOffStatus, busOffDate, busProdCardId, busProdCardProductName, busProdCardProductStatus, busProdCardName, productId, productName, productHierId);
    }
}
