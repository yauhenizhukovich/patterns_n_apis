package by.belinvest.panel.admin.entity.catalog;

import javax.persistence.criteria.CriteriaBuilder;

public class BpProductLine {
    private Integer BPid;
    private String NsiName;
    private Integer NsiId;

    public Integer getBPid() {
        return BPid;
    }

    public void setBPid(Integer BPid) {
        this.BPid = BPid;
    }

    public String getNsiName() {
        return NsiName;
    }

    public void setNsiName(String nsiName) {
        NsiName = nsiName;
    }

    public Integer getNsiId() {
        return NsiId;
    }

    public void setNsiId(Integer nsiId) {
        NsiId = nsiId;
    }
}
