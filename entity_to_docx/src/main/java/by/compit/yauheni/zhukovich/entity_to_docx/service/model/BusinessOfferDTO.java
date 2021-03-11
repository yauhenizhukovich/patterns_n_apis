package by.compit.yauheni.zhukovich.entity_to_docx.service.model;

import java.util.List;
import java.util.Map;

public class BusinessOfferDTO {

    private Map<String, String> simpleFields;
    private Map<String, List<String>> collections;

    public void setSimpleFields(Map<String, String> simpleFields) {
        this.simpleFields = simpleFields;
    }

    public Map<String, String> getSimpleFields() {
        return simpleFields;
    }

    public void setCollections(Map<String, List<String>> collections) {
        this.collections = collections;
    }

    public Map<String, List<String>> getCollections() {
        return collections;
    }

}
