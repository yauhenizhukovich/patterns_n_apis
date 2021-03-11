package by.belinvest.panel.admin.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Setting {

    private String sysOwner;
    private String emailServer;
    private String notificationTemplate;
    private String apiBarsNsiAddress;
    private String apiBarsNsiUser;
    private String apiBarsNsiPwd;
    private String apiBrisNsiAdress;
    private String apiBrisNsiUser;
    private String apiBrisNsiPwd;
    private String apiBarsAccAdress;
    private String apiBarsAccUser;
    private String apiBarsAccPwd;
    private String sedFolderPath;
    private String timeoutSyncNsi;
    private String timeoutSyncAcc;

    public String getSysOwner() {
        return sysOwner;
    }

    public void setSysOwner(String sysOwner) {
        this.sysOwner = sysOwner;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    public String getNotificationTemplate() {
        return notificationTemplate;
    }

    public void setNotificationTemplate(String notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
    }

    public String getApiBarsNsiAddress() {
        return apiBarsNsiAddress;
    }

    public void setApiBarsNsiAddress(String apiBarsNsiAddress) {
        this.apiBarsNsiAddress = apiBarsNsiAddress;
    }

    public String getApiBarsNsiUser() {
        return apiBarsNsiUser;
    }

    public void setApiBarsNsiUser(String apiBarsNsiUser) {
        this.apiBarsNsiUser = apiBarsNsiUser;
    }

    public String getApiBarsNsiPwd() {
        return apiBarsNsiPwd;
    }

    public void setApiBarsNsiPwd(String apiBarsNsiPwd) {
        this.apiBarsNsiPwd = apiBarsNsiPwd;
    }

    public String getApiBrisNsiAdress() {
        return apiBrisNsiAdress;
    }

    public void setApiBrisNsiAdress(String apiBrisNsiAdress) {
        this.apiBrisNsiAdress = apiBrisNsiAdress;
    }

    public String getApiBrisNsiUser() {
        return apiBrisNsiUser;
    }

    public void setApiBrisNsiUser(String apiBrisNsiUser) {
        this.apiBrisNsiUser = apiBrisNsiUser;
    }

    public String getApiBrisNsiPwd() {
        return apiBrisNsiPwd;
    }

    public void setApiBrisNsiPwd(String apiBrisNsiPwd) {
        this.apiBrisNsiPwd = apiBrisNsiPwd;
    }

    public String getApiBarsAccAdress() {
        return apiBarsAccAdress;
    }

    public void setApiBarsAccAdress(String apiBarsAccAdress) {
        this.apiBarsAccAdress = apiBarsAccAdress;
    }

    public String getApiBarsAccUser() {
        return apiBarsAccUser;
    }

    public void setApiBarsAccUser(String apiBarsAccUser) {
        this.apiBarsAccUser = apiBarsAccUser;
    }

    public String getApiBarsAccPwd() {
        return apiBarsAccPwd;
    }

    public void setApiBarsAccPwd(String apiBarsAccPwd) {
        this.apiBarsAccPwd = apiBarsAccPwd;
    }

    public String getSedFolderPath() {
        return sedFolderPath;
    }

    public void setSedFolderPath(String sedFolderPath) {
        this.sedFolderPath = sedFolderPath;
    }

    public String getTimeoutSyncNsi() {
        return timeoutSyncNsi;
    }

    public void setTimeoutSyncNsi(String timeoutSyncNsi) {
        this.timeoutSyncNsi = timeoutSyncNsi;
    }

    public String getTimeoutSyncAcc() {
        return timeoutSyncAcc;
    }

    public void setTimeoutSyncAcc(String timeoutSyncAcc) {
        this.timeoutSyncAcc = timeoutSyncAcc;
    }
}
