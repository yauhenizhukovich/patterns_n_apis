package by.belinvest.panel.admin.product.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Uvkv {

    private String viewUvkv;
    private String idUvkv;
    private Boolean defaultUvkv;

    public Uvkv(String viewUvkv, String idUvkv, Boolean defaultUvkv) {
        this.viewUvkv = viewUvkv;
        this.idUvkv = idUvkv;
        this.defaultUvkv = defaultUvkv;
    }

    public Uvkv() {
    }

    public String getViewUvkv() {
        return viewUvkv;
    }

    public void setViewUvkv(String viewUvkv) {
        this.viewUvkv = viewUvkv;
    }

    public String getIdUvkv() {
        return idUvkv;
    }

    public void setIdUvkv(String idUvkv) {
        this.idUvkv = idUvkv;
    }

    public Boolean getDefaultUvkv() {
        return defaultUvkv;
    }

    public void setDefaultUvkv(Boolean defaultUvkv) {
        this.defaultUvkv = defaultUvkv;
    }

}
