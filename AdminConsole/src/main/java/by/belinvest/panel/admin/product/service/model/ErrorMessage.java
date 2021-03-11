package by.belinvest.panel.admin.product.service.model;

public class ErrorMessage {

    private String code;
    private String devMessage;
    private String userMessage;

    public ErrorMessage() {
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "code='" + code + '\'' +
                ", devMessage='" + devMessage + '\'' +
                ", userMessage='" + userMessage + '\'' +
                '}';
    }

    public ErrorMessage(String code, String devMessage, String userMessage) {
        this.code = code;
        this.devMessage = devMessage;
        this.userMessage = userMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
