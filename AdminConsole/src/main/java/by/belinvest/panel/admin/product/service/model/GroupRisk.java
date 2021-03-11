package by.belinvest.panel.admin.product.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupRisk {

    private String idGroupRisk;
    private Boolean defaultGroupRisk;

    public GroupRisk() {
    }

    public GroupRisk(String idGroupRisk, Boolean defaultGroupRisk) {
        this.idGroupRisk = idGroupRisk;
        this.defaultGroupRisk = defaultGroupRisk;
    }

    public String getIdGroupRisk() {
        return idGroupRisk;
    }

    public void setIdGroupRisk(String idGroupRisk) {
        this.idGroupRisk = idGroupRisk;
    }

    public Boolean getDefaultGroupRisk() {
        return defaultGroupRisk;
    }

    public void setDefaultGroupRisk(Boolean defaultGroupRisk) {
        this.defaultGroupRisk = defaultGroupRisk;
    }

}
