package by.belinvest.panel.admin.product.controller.model;

import java.util.List;

public class Data {

    private List<String> productsId;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<String> productsId) {
        this.productsId = productsId;
    }

}
