package by.belinvest.panel.admin.product.controller.model;

import java.util.List;

public class ProductStatusRequest {

    private List<Long> productsId;
    private String status;

    public ProductStatusRequest(List<Long> productsId, String status) {
        this.productsId = productsId;
        this.status = status;
    }

    public ProductStatusRequest() {
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
