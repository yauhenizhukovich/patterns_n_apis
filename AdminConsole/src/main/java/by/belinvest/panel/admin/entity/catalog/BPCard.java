package by.belinvest.panel.admin.entity.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BPCard {

    private String bPId;
    private String productName;
    private String commonProductChars;
    private String productStatus;
    private String changeStatusDate;
    private String productAdvantages;
    private String mainProductParams;
    private String docsForms;
    private String lbaBanks;
    private String addMaterials;

    public String getbPId() {
        return bPId;
    }

    public void setbPId(String bPId) {
        this.bPId = bPId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCommonProductChars() {
        return commonProductChars;
    }

    public void setCommonProductChars(String commonProductChars) {
        this.commonProductChars = commonProductChars;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getChangeStatusDate() {
        return changeStatusDate;
    }

    public void setChangeStatusDate(String changeStatusDate) {
        this.changeStatusDate = changeStatusDate;
    }

    public String getProductAdvantages() {
        return productAdvantages;
    }

    public void setProductAdvantages(String productAdvantages) {
        this.productAdvantages = productAdvantages;
    }

    public String getMainProductParams() {
        return mainProductParams;
    }

    public void setMainProductParams(String mainProductParams) {
        this.mainProductParams = mainProductParams;
    }

    public String getDocsForms() {
        return docsForms;
    }

    public void setDocsForms(String docsForms) {
        this.docsForms = docsForms;
    }

    public String getLbaBanks() {
        return lbaBanks;
    }

    public void setLbaBanks(String lbaBanks) {
        this.lbaBanks = lbaBanks;
    }

    public String getAddMaterials() {
        return addMaterials;
    }

    public void setAddMaterials(String addMaterials) {
        this.addMaterials = addMaterials;
    }


}
