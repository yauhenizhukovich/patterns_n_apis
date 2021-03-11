package by.compit.yauheni.zhukovich.nsi_product.service.model;

import java.util.List;

public class Data {

    private List<Long> productsId;
    private String status;

    public Data(List<Long> productsId, String status) {
        this.productsId = productsId;
        this.status = status;
    }

    public Data() {
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
