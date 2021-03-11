package by.belinvest.panel.admin.product.service.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DimItem {

    private String dimId;
    private String parentId;
    private String code;
    private String name;
    private String dimType;
    private String userCode;
    private Map<String, Attribute> attributes = new HashMap<>();

    public String getDimId() {
        return dimId;
    }

    public void setDimId(String dimId) {
        this.dimId = dimId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDimType() {
        return dimType;
    }

    public void setDimType(String dimType) {
        this.dimType = dimType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @JsonAnyGetter
    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Attribute> attributes) {
        this.attributes = attributes;
    }

    public void addAttribute(String property, Attribute value) {
        attributes.put(property, value);
    }

    @Override
    public String toString() {
        return "DimItem{" +
                "dimId='" + dimId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dimType='" + dimType + '\'' +
                ", userCode='" + userCode + '\'' +
                ", attributes=" + attributes +
                '}';
    }

}
