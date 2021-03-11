package by.belinvest.panel.admin.product.service.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositProductAddRequest {

    private String codeDepProduct;
    private BigDecimal typeDepProduct;
    private String classifierDepProduct;
    private String nameDepProduct;
    private Boolean annulDepProduct;
    private String currencyDepProduct;
    private BigDecimal typePercentDepProduct;
    private BigDecimal typeBaseDepProduct;
    private BigDecimal viewPercentDepProduct;
    private BigDecimal sumCloseDepProduct;
    private BigDecimal procCloseDepProduct;
    private BigDecimal termTypeDepProduct;
    private BigDecimal termDepProduct;
    private BigDecimal capitalizationDepProduct;
    private Boolean accountCardDepProduct;
    private String currencyLimitDepProduct;
    private BigDecimal minSumDepProduct;
    private BigDecimal renewalSumDepProduct;
    private BigDecimal maxRenewalSumDepProduct;
    private BigDecimal withdrawalTypeDepProduct;
    private Boolean linkedAccountDepProduct;
    private Boolean closeToCurrentDepProduct;
    private Boolean extraDepProduct;
    private Boolean otherFaceDepProduct;
    private Boolean invalidChildDepProduct;
    private Boolean representDepProduct;
    private Boolean ibOpenDepProduct;
    private Boolean taxDepProduct;
    private Boolean smsDiscDepProduct;
    private BigDecimal smsDiscSizeDepProduct;
    private BigDecimal currentSumDepProduct;
    private BigDecimal termRenewalTypeDepProduct;
    private BigDecimal termRenewalDepProduct;
    private BigDecimal withdrawalPeriodDepProduct;
    private BigDecimal withdrawalSumDepProduct;
    private BigDecimal withdrawalMinBalanceDepProduct;
    private BigDecimal withdrawalPercentDepProduct;
    private Boolean withdrawalSumMaxDepProduct;
    private Boolean withdrawalProhibitedDepProduct;
    private Boolean withdrawalTermTypDepProduct;
    private BigDecimal withdrawalTermDepProduct;
    private String formDepProduct;
    private String userCode;
    private String depositProductId;
    private BigDecimal renewalPeriodDepProduct;
    private Boolean legalrepresentDepProduct;
    private Boolean prohibManualOpenDepProduct;
    private Boolean prohibManualCloseDepProduct;
    private Boolean isCancelPeriodDepProduct;
    private BigDecimal cancelPeriodDepProduct;

    @Override
    public String toString() {
        return "DepositProductAddRequest{" +
                "codeDepProduct='" + codeDepProduct + '\'' +
                ", typeDepProduct=" + typeDepProduct +
                ", classifierDepProduct='" + classifierDepProduct + '\'' +
                ", nameDepProduct='" + nameDepProduct + '\'' +
                ", annulDepProduct=" + annulDepProduct +
                ", currencyDepProduct='" + currencyDepProduct + '\'' +
                ", typePercentDepProduct=" + typePercentDepProduct +
                ", typeBaseDepProduct=" + typeBaseDepProduct +
                ", viewPercentDepProduct=" + viewPercentDepProduct +
                ", sumCloseDepProduct=" + sumCloseDepProduct +
                ", procCloseDepProduct=" + procCloseDepProduct +
                ", termTypeDepProduct=" + termTypeDepProduct +
                ", termDepProduct=" + termDepProduct +
                ", capitalizationDepProduct=" + capitalizationDepProduct +
                ", accountCardDepProduct=" + accountCardDepProduct +
                ", currencyLimitDepProduct='" + currencyLimitDepProduct + '\'' +
                ", minSumDepProduct=" + minSumDepProduct +
                ", renewalSumDepProduct=" + renewalSumDepProduct +
                ", maxRenewalSumDepProduct=" + maxRenewalSumDepProduct +
                ", withdrawalTypeDepProduct=" + withdrawalTypeDepProduct +
                ", linkedAccountDepProduct=" + linkedAccountDepProduct +
                ", closeToCurrentDepProduct=" + closeToCurrentDepProduct +
                ", extraDepProduct=" + extraDepProduct +
                ", otherFaceDepProduct=" + otherFaceDepProduct +
                ", invalidChildDepProduct=" + invalidChildDepProduct +
                ", representDepProduct=" + representDepProduct +
                ", ibOpenDepProduct=" + ibOpenDepProduct +
                ", taxDepProduct=" + taxDepProduct +
                ", smsDiscDepProduct=" + smsDiscDepProduct +
                ", smsDiscSizeDepProduct=" + smsDiscSizeDepProduct +
                ", currentSumDepProduct=" + currentSumDepProduct +
                ", termRenewalTypeDepProduct=" + termRenewalTypeDepProduct +
                ", termRenewalDepProduct=" + termRenewalDepProduct +
                ", withdrawalPeriodDepProduct=" + withdrawalPeriodDepProduct +
                ", withdrawalSumDepProduct=" + withdrawalSumDepProduct +
                ", withdrawalMinBalanceDepProduct=" + withdrawalMinBalanceDepProduct +
                ", withdrawalPercentDepProduct=" + withdrawalPercentDepProduct +
                ", withdrawalSumMaxDepProduct=" + withdrawalSumMaxDepProduct +
                ", withdrawalProhibitedDepProduct=" + withdrawalProhibitedDepProduct +
                ", withdrawalTermTypDepProduct=" + withdrawalTermTypDepProduct +
                ", withdrawalTermDepProduct=" + withdrawalTermDepProduct +
                ", formDepProduct='" + formDepProduct + '\'' +
                ", userCode='" + userCode + '\'' +
                ", depositProductId='" + depositProductId + '\'' +
                ", renewalPeriodDepProduct=" + renewalPeriodDepProduct +
                ", legalrepresentDepProduct=" + legalrepresentDepProduct +
                ", prohibManualOpenDepProduct=" + prohibManualOpenDepProduct +
                ", prohibManualCloseDepProduct=" + prohibManualCloseDepProduct +
                ", isCancelPeriodDepProduct=" + isCancelPeriodDepProduct +
                ", cancelPeriodDepProduct=" + cancelPeriodDepProduct +
                '}';
    }

    public String getCodeDepProduct() {
        return codeDepProduct;
    }

    public void setCodeDepProduct(String codeDepProduct) {
        this.codeDepProduct = codeDepProduct;
    }

    public BigDecimal getTypeDepProduct() {
        return typeDepProduct;
    }

    public void setTypeDepProduct(BigDecimal typeDepProduct) {
        this.typeDepProduct = typeDepProduct;
    }

    public String getClassifierDepProduct() {
        return classifierDepProduct;
    }

    public void setClassifierDepProduct(String classifierDepProduct) {
        this.classifierDepProduct = classifierDepProduct;
    }

    public String getNameDepProduct() {
        return nameDepProduct;
    }

    public void setNameDepProduct(String nameDepProduct) {
        this.nameDepProduct = nameDepProduct;
    }

    public Boolean getAnnulDepProduct() {
        return annulDepProduct;
    }

    public void setAnnulDepProduct(Boolean annulDepProduct) {
        this.annulDepProduct = annulDepProduct;
    }

    public String getCurrencyDepProduct() {
        return currencyDepProduct;
    }

    public void setCurrencyDepProduct(String currencyDepProduct) {
        this.currencyDepProduct = currencyDepProduct;
    }

    public BigDecimal getTypePercentDepProduct() {
        return typePercentDepProduct;
    }

    public void setTypePercentDepProduct(BigDecimal typePercentDepProduct) {
        this.typePercentDepProduct = typePercentDepProduct;
    }

    public BigDecimal getTypeBaseDepProduct() {
        return typeBaseDepProduct;
    }

    public void setTypeBaseDepProduct(BigDecimal typeBaseDepProduct) {
        this.typeBaseDepProduct = typeBaseDepProduct;
    }

    public BigDecimal getViewPercentDepProduct() {
        return viewPercentDepProduct;
    }

    public void setViewPercentDepProduct(BigDecimal viewPercentDepProduct) {
        this.viewPercentDepProduct = viewPercentDepProduct;
    }

    public BigDecimal getSumCloseDepProduct() {
        return sumCloseDepProduct;
    }

    public void setSumCloseDepProduct(BigDecimal sumCloseDepProduct) {
        this.sumCloseDepProduct = sumCloseDepProduct;
    }

    public BigDecimal getProcCloseDepProduct() {
        return procCloseDepProduct;
    }

    public void setProcCloseDepProduct(BigDecimal procCloseDepProduct) {
        this.procCloseDepProduct = procCloseDepProduct;
    }

    public BigDecimal getTermTypeDepProduct() {
        return termTypeDepProduct;
    }

    public void setTermTypeDepProduct(BigDecimal termTypeDepProduct) {
        this.termTypeDepProduct = termTypeDepProduct;
    }

    public BigDecimal getTermDepProduct() {
        return termDepProduct;
    }

    public void setTermDepProduct(BigDecimal termDepProduct) {
        this.termDepProduct = termDepProduct;
    }

    public BigDecimal getCapitalizationDepProduct() {
        return capitalizationDepProduct;
    }

    public void setCapitalizationDepProduct(BigDecimal capitalizationDepProduct) {
        this.capitalizationDepProduct = capitalizationDepProduct;
    }

    public Boolean getAccountCardDepProduct() {
        return accountCardDepProduct;
    }

    public void setAccountCardDepProduct(Boolean accountCardDepProduct) {
        this.accountCardDepProduct = accountCardDepProduct;
    }

    public String getCurrencyLimitDepProduct() {
        return currencyLimitDepProduct;
    }

    public void setCurrencyLimitDepProduct(String currencyLimitDepProduct) {
        this.currencyLimitDepProduct = currencyLimitDepProduct;
    }

    public BigDecimal getMinSumDepProduct() {
        return minSumDepProduct;
    }

    public void setMinSumDepProduct(BigDecimal minSumDepProduct) {
        this.minSumDepProduct = minSumDepProduct;
    }

    public BigDecimal getRenewalSumDepProduct() {
        return renewalSumDepProduct;
    }

    public void setRenewalSumDepProduct(BigDecimal renewalSumDepProduct) {
        this.renewalSumDepProduct = renewalSumDepProduct;
    }

    public BigDecimal getMaxRenewalSumDepProduct() {
        return maxRenewalSumDepProduct;
    }

    public void setMaxRenewalSumDepProduct(BigDecimal maxRenewalSumDepProduct) {
        this.maxRenewalSumDepProduct = maxRenewalSumDepProduct;
    }

    public BigDecimal getWithdrawalTypeDepProduct() {
        return withdrawalTypeDepProduct;
    }

    public void setWithdrawalTypeDepProduct(BigDecimal withdrawalTypeDepProduct) {
        this.withdrawalTypeDepProduct = withdrawalTypeDepProduct;
    }

    public Boolean getLinkedAccountDepProduct() {
        return linkedAccountDepProduct;
    }

    public void setLinkedAccountDepProduct(Boolean linkedAccountDepProduct) {
        this.linkedAccountDepProduct = linkedAccountDepProduct;
    }

    public Boolean getCloseToCurrentDepProduct() {
        return closeToCurrentDepProduct;
    }

    public void setCloseToCurrentDepProduct(Boolean closeToCurrentDepProduct) {
        this.closeToCurrentDepProduct = closeToCurrentDepProduct;
    }

    public Boolean getExtraDepProduct() {
        return extraDepProduct;
    }

    public void setExtraDepProduct(Boolean extraDepProduct) {
        this.extraDepProduct = extraDepProduct;
    }

    public Boolean getOtherFaceDepProduct() {
        return otherFaceDepProduct;
    }

    public void setOtherFaceDepProduct(Boolean otherFaceDepProduct) {
        this.otherFaceDepProduct = otherFaceDepProduct;
    }

    public Boolean getInvalidChildDepProduct() {
        return invalidChildDepProduct;
    }

    public void setInvalidChildDepProduct(Boolean invalidChildDepProduct) {
        this.invalidChildDepProduct = invalidChildDepProduct;
    }

    public Boolean getRepresentDepProduct() {
        return representDepProduct;
    }

    public void setRepresentDepProduct(Boolean representDepProduct) {
        this.representDepProduct = representDepProduct;
    }

    public Boolean getIbOpenDepProduct() {
        return ibOpenDepProduct;
    }

    public void setIbOpenDepProduct(Boolean ibOpenDepProduct) {
        this.ibOpenDepProduct = ibOpenDepProduct;
    }

    public Boolean getTaxDepProduct() {
        return taxDepProduct;
    }

    public void setTaxDepProduct(Boolean taxDepProduct) {
        this.taxDepProduct = taxDepProduct;
    }

    public Boolean getSmsDiscDepProduct() {
        return smsDiscDepProduct;
    }

    public void setSmsDiscDepProduct(Boolean smsDiscDepProduct) {
        this.smsDiscDepProduct = smsDiscDepProduct;
    }

    public BigDecimal getSmsDiscSizeDepProduct() {
        return smsDiscSizeDepProduct;
    }

    public void setSmsDiscSizeDepProduct(BigDecimal smsDiscSizeDepProduct) {
        this.smsDiscSizeDepProduct = smsDiscSizeDepProduct;
    }

    public BigDecimal getCurrentSumDepProduct() {
        return currentSumDepProduct;
    }

    public void setCurrentSumDepProduct(BigDecimal currentSumDepProduct) {
        this.currentSumDepProduct = currentSumDepProduct;
    }

    public BigDecimal getTermRenewalTypeDepProduct() {
        return termRenewalTypeDepProduct;
    }

    public void setTermRenewalTypeDepProduct(BigDecimal termRenewalTypeDepProduct) {
        this.termRenewalTypeDepProduct = termRenewalTypeDepProduct;
    }

    public BigDecimal getTermRenewalDepProduct() {
        return termRenewalDepProduct;
    }

    public void setTermRenewalDepProduct(BigDecimal termRenewalDepProduct) {
        this.termRenewalDepProduct = termRenewalDepProduct;
    }

    public BigDecimal getWithdrawalPeriodDepProduct() {
        return withdrawalPeriodDepProduct;
    }

    public void setWithdrawalPeriodDepProduct(BigDecimal withdrawalPeriodDepProduct) {
        this.withdrawalPeriodDepProduct = withdrawalPeriodDepProduct;
    }

    public BigDecimal getWithdrawalSumDepProduct() {
        return withdrawalSumDepProduct;
    }

    public void setWithdrawalSumDepProduct(BigDecimal withdrawalSumDepProduct) {
        this.withdrawalSumDepProduct = withdrawalSumDepProduct;
    }

    public BigDecimal getWithdrawalMinBalanceDepProduct() {
        return withdrawalMinBalanceDepProduct;
    }

    public void setWithdrawalMinBalanceDepProduct(BigDecimal withdrawalMinBalanceDepProduct) {
        this.withdrawalMinBalanceDepProduct = withdrawalMinBalanceDepProduct;
    }

    public BigDecimal getWithdrawalPercentDepProduct() {
        return withdrawalPercentDepProduct;
    }

    public void setWithdrawalPercentDepProduct(BigDecimal withdrawalPercentDepProduct) {
        this.withdrawalPercentDepProduct = withdrawalPercentDepProduct;
    }

    public Boolean getWithdrawalSumMaxDepProduct() {
        return withdrawalSumMaxDepProduct;
    }

    public void setWithdrawalSumMaxDepProduct(Boolean withdrawalSumMaxDepProduct) {
        this.withdrawalSumMaxDepProduct = withdrawalSumMaxDepProduct;
    }

    public Boolean getWithdrawalProhibitedDepProduct() {
        return withdrawalProhibitedDepProduct;
    }

    public void setWithdrawalProhibitedDepProduct(Boolean withdrawalProhibitedDepProduct) {
        this.withdrawalProhibitedDepProduct = withdrawalProhibitedDepProduct;
    }

    public Boolean getWithdrawalTermTypDepProduct() {
        return withdrawalTermTypDepProduct;
    }

    public void setWithdrawalTermTypDepProduct(Boolean withdrawalTermTypDepProduct) {
        this.withdrawalTermTypDepProduct = withdrawalTermTypDepProduct;
    }

    public BigDecimal getWithdrawalTermDepProduct() {
        return withdrawalTermDepProduct;
    }

    public void setWithdrawalTermDepProduct(BigDecimal withdrawalTermDepProduct) {
        this.withdrawalTermDepProduct = withdrawalTermDepProduct;
    }

    public String getFormDepProduct() {
        return formDepProduct;
    }

    public void setFormDepProduct(String formDepProduct) {
        this.formDepProduct = formDepProduct;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDepositProductId() {
        return depositProductId;
    }

    public void setDepositProductId(String depositProductId) {
        this.depositProductId = depositProductId;
    }

    public BigDecimal getRenewalPeriodDepProduct() {
        return renewalPeriodDepProduct;
    }

    public void setRenewalPeriodDepProduct(BigDecimal renewalPeriodDepProduct) {
        this.renewalPeriodDepProduct = renewalPeriodDepProduct;
    }

    public Boolean getLegalrepresentDepProduct() {
        return legalrepresentDepProduct;
    }

    public void setLegalrepresentDepProduct(Boolean legalrepresentDepProduct) {
        this.legalrepresentDepProduct = legalrepresentDepProduct;
    }

    public Boolean getProhibManualOpenDepProduct() {
        return prohibManualOpenDepProduct;
    }

    public void setProhibManualOpenDepProduct(Boolean prohibManualOpenDepProduct) {
        this.prohibManualOpenDepProduct = prohibManualOpenDepProduct;
    }

    public Boolean getProhibManualCloseDepProduct() {
        return prohibManualCloseDepProduct;
    }

    public void setProhibManualCloseDepProduct(Boolean prohibManualCloseDepProduct) {
        this.prohibManualCloseDepProduct = prohibManualCloseDepProduct;
    }

    @JsonProperty("isCancelPeriodDepProduct")
    public Boolean getIsCancelPeriodDepProduct() {
        return isCancelPeriodDepProduct;
    }

    @JsonProperty("isCancelPeriodDepProduct")
    public void setIsCancelPeriodDepProduct(Boolean isCancelPeriodDepProduct) {
        this.isCancelPeriodDepProduct = isCancelPeriodDepProduct;
    }

    public BigDecimal getCancelPeriodDepProduct() {
        return cancelPeriodDepProduct;
    }

    public void setCancelPeriodDepProduct(BigDecimal cancelPeriodDepProduct) {
        this.cancelPeriodDepProduct = cancelPeriodDepProduct;
    }

    public static final class Builder {

        private String codeDepProduct;
        private BigDecimal typeDepProduct;
        private String classifierDepProduct;
        private String nameDepProduct;
        private Boolean annulDepProduct;
        private String currencyDepProduct;
        private BigDecimal typePercentDepProduct;
        private BigDecimal typeBaseDepProduct;
        private BigDecimal viewPercentDepProduct;
        private BigDecimal sumCloseDepProduct;
        private BigDecimal procCloseDepProduct;
        private BigDecimal termTypeDepProduct;
        private BigDecimal termDepProduct;
        private BigDecimal capitalizationDepProduct;
        private Boolean accountCardDepProduct;
        private String currencyLimitDepProduct;
        private BigDecimal minSumDepProduct;
        private BigDecimal renewalSumDepProduct;
        private BigDecimal maxRenewalSumDepProduct;
        private BigDecimal withdrawalTypeDepProduct;
        private Boolean linkedAccountDepProduct;
        private Boolean closeToCurrentDepProduct;
        private Boolean extraDepProduct;
        private Boolean otherFaceDepProduct;
        private Boolean invalidChildDepProduct;
        private Boolean representDepProduct;
        private Boolean ibOpenDepProduct;
        private Boolean taxDepProduct;
        private Boolean smsDiscDepProduct;
        private BigDecimal smsDiscSizeDepProduct;
        private BigDecimal currentSumDepProduct;
        private BigDecimal termRenewalTypeDepProduct;
        private BigDecimal termRenewalDepProduct;
        private BigDecimal withdrawalPeriodDepProduct;
        private BigDecimal withdrawalSumDepProduct;
        private BigDecimal withdrawalMinBalanceDepProduct;
        private BigDecimal withdrawalPercentDepProduct;
        private Boolean withdrawalSumMaxDepProduct;
        private Boolean withdrawalProhibitedDepProduct;
        private Boolean withdrawalTermTypDepProduct;
        private BigDecimal withdrawalTermDepProduct;
        private String formDepProduct;
        private String userCode;
        private String depositProductId;
        private BigDecimal renewalPeriodDepProduct;
        private Boolean legalrepresentDepProduct;
        private Boolean prohibManualOpenDepProduct;
        private Boolean prohibManualCloseDepProduct;
        private Boolean isCancelPeriodDepProduct;
        private BigDecimal cancelPeriodDepProduct;

        private Builder() {}

        public static Builder aDepositProductAddRequest() { return new Builder(); }

        public Builder codeDepProduct(String codeDepProduct) {
            this.codeDepProduct = codeDepProduct;
            return this;
        }

        public Builder typeDepProduct(BigDecimal typeDepProduct) {
            this.typeDepProduct = typeDepProduct;
            return this;
        }

        public Builder classifierDepProduct(String classifierDepProduct) {
            this.classifierDepProduct = classifierDepProduct;
            return this;
        }

        public Builder nameDepProduct(String nameDepProduct) {
            this.nameDepProduct = nameDepProduct;
            return this;
        }

        public Builder annulDepProduct(Boolean annulDepProduct) {
            this.annulDepProduct = annulDepProduct;
            return this;
        }

        public Builder currencyDepProduct(String currencyDepProduct) {
            this.currencyDepProduct = currencyDepProduct;
            return this;
        }

        public Builder typePercentDepProduct(BigDecimal typePercentDepProduct) {
            this.typePercentDepProduct = typePercentDepProduct;
            return this;
        }

        public Builder typeBaseDepProduct(BigDecimal typeBaseDepProduct) {
            this.typeBaseDepProduct = typeBaseDepProduct;
            return this;
        }

        public Builder viewPercentDepProduct(BigDecimal viewPercentDepProduct) {
            this.viewPercentDepProduct = viewPercentDepProduct;
            return this;
        }

        public Builder sumCloseDepProduct(BigDecimal sumCloseDepProduct) {
            this.sumCloseDepProduct = sumCloseDepProduct;
            return this;
        }

        public Builder procCloseDepProduct(BigDecimal procCloseDepProduct) {
            this.procCloseDepProduct = procCloseDepProduct;
            return this;
        }

        public Builder termTypeDepProduct(BigDecimal termTypeDepProduct) {
            this.termTypeDepProduct = termTypeDepProduct;
            return this;
        }

        public Builder termDepProduct(BigDecimal termDepProduct) {
            this.termDepProduct = termDepProduct;
            return this;
        }

        public Builder capitalizationDepProduct(BigDecimal capitalizationDepProduct) {
            this.capitalizationDepProduct = capitalizationDepProduct;
            return this;
        }

        public Builder accountCardDepProduct(Boolean accountCardDepProduct) {
            this.accountCardDepProduct = accountCardDepProduct;
            return this;
        }

        public Builder currencyLimitDepProduct(String currencyLimitDepProduct) {
            this.currencyLimitDepProduct = currencyLimitDepProduct;
            return this;
        }

        public Builder minSumDepProduct(BigDecimal minSumDepProduct) {
            this.minSumDepProduct = minSumDepProduct;
            return this;
        }

        public Builder renewalSumDepProduct(BigDecimal renewalSumDepProduct) {
            this.renewalSumDepProduct = renewalSumDepProduct;
            return this;
        }

        public Builder maxRenewalSumDepProduct(BigDecimal maxRenewalSumDepProduct) {
            this.maxRenewalSumDepProduct = maxRenewalSumDepProduct;
            return this;
        }

        public Builder withdrawalTypeDepProduct(BigDecimal withdrawalTypeDepProduct) {
            this.withdrawalTypeDepProduct = withdrawalTypeDepProduct;
            return this;
        }

        public Builder linkedAccountDepProduct(Boolean linkedAccountDepProduct) {
            this.linkedAccountDepProduct = linkedAccountDepProduct;
            return this;
        }

        public Builder closeToCurrentDepProduct(Boolean closeToCurrentDepProduct) {
            this.closeToCurrentDepProduct = closeToCurrentDepProduct;
            return this;
        }

        public Builder extraDepProduct(Boolean extraDepProduct) {
            this.extraDepProduct = extraDepProduct;
            return this;
        }

        public Builder otherFaceDepProduct(Boolean otherFaceDepProduct) {
            this.otherFaceDepProduct = otherFaceDepProduct;
            return this;
        }

        public Builder invalidChildDepProduct(Boolean invalidChildDepProduct) {
            this.invalidChildDepProduct = invalidChildDepProduct;
            return this;
        }

        public Builder representDepProduct(Boolean representDepProduct) {
            this.representDepProduct = representDepProduct;
            return this;
        }

        public Builder ibOpenDepProduct(Boolean ibOpenDepProduct) {
            this.ibOpenDepProduct = ibOpenDepProduct;
            return this;
        }

        public Builder taxDepProduct(Boolean taxDepProduct) {
            this.taxDepProduct = taxDepProduct;
            return this;
        }

        public Builder smsDiscDepProduct(Boolean smsDiscDepProduct) {
            this.smsDiscDepProduct = smsDiscDepProduct;
            return this;
        }

        public Builder smsDiscSizeDepProduct(BigDecimal smsDiscSizeDepProduct) {
            this.smsDiscSizeDepProduct = smsDiscSizeDepProduct;
            return this;
        }

        public Builder currentSumDepProduct(BigDecimal currentSumDepProduct) {
            this.currentSumDepProduct = currentSumDepProduct;
            return this;
        }

        public Builder termRenewalTypeDepProduct(BigDecimal termRenewalTypeDepProduct) {
            this.termRenewalTypeDepProduct = termRenewalTypeDepProduct;
            return this;
        }

        public Builder termRenewalDepProduct(BigDecimal termRenewalDepProduct) {
            this.termRenewalDepProduct = termRenewalDepProduct;
            return this;
        }

        public Builder withdrawalPeriodDepProduct(BigDecimal withdrawalPeriodDepProduct) {
            this.withdrawalPeriodDepProduct = withdrawalPeriodDepProduct;
            return this;
        }

        public Builder withdrawalSumDepProduct(BigDecimal withdrawalSumDepProduct) {
            this.withdrawalSumDepProduct = withdrawalSumDepProduct;
            return this;
        }

        public Builder withdrawalMinBalanceDepProduct(BigDecimal withdrawalMinBalanceDepProduct) {
            this.withdrawalMinBalanceDepProduct = withdrawalMinBalanceDepProduct;
            return this;
        }

        public Builder withdrawalPercentDepProduct(BigDecimal withdrawalPercentDepProduct) {
            this.withdrawalPercentDepProduct = withdrawalPercentDepProduct;
            return this;
        }

        public Builder withdrawalSumMaxDepProduct(Boolean withdrawalSumMaxDepProduct) {
            this.withdrawalSumMaxDepProduct = withdrawalSumMaxDepProduct;
            return this;
        }

        public Builder withdrawalProhibitedDepProduct(Boolean withdrawalProhibitedDepProduct) {
            this.withdrawalProhibitedDepProduct = withdrawalProhibitedDepProduct;
            return this;
        }

        public Builder withdrawalTermTypDepProduct(Boolean withdrawalTermTypDepProduct) {
            this.withdrawalTermTypDepProduct = withdrawalTermTypDepProduct;
            return this;
        }

        public Builder withdrawalTermDepProduct(BigDecimal withdrawalTermDepProduct) {
            this.withdrawalTermDepProduct = withdrawalTermDepProduct;
            return this;
        }

        public Builder formDepProduct(String formDepProduct) {
            this.formDepProduct = formDepProduct;
            return this;
        }

        public Builder userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder depositProductId(String depositProductId) {
            this.depositProductId = depositProductId;
            return this;
        }

        public Builder renewalPeriodDepProduct(BigDecimal renewalPeriodDepProduct) {
            this.renewalPeriodDepProduct = renewalPeriodDepProduct;
            return this;
        }

        public Builder legalrepresentDepProduct(Boolean legalrepresentDepProduct) {
            this.legalrepresentDepProduct = legalrepresentDepProduct;
            return this;
        }

        public Builder prohibManualOpenDepProduct(Boolean prohibManualOpenDepProduct) {
            this.prohibManualOpenDepProduct = prohibManualOpenDepProduct;
            return this;
        }

        public Builder prohibManualCloseDepProduct(Boolean prohibManualCloseDepProduct) {
            this.prohibManualCloseDepProduct = prohibManualCloseDepProduct;
            return this;
        }

        public Builder isCancelPeriodDepProduct(Boolean isCancelPeriodDepProduct) {
            this.isCancelPeriodDepProduct = isCancelPeriodDepProduct;
            return this;
        }

        public Builder cancelPeriodDepProduct(BigDecimal cancelPeriodDepProduct) {
            this.cancelPeriodDepProduct = cancelPeriodDepProduct;
            return this;
        }

        public DepositProductAddRequest build() {
            DepositProductAddRequest depositProductAddRequest = new DepositProductAddRequest();
            depositProductAddRequest.setCodeDepProduct(codeDepProduct);
            depositProductAddRequest.setTypeDepProduct(typeDepProduct);
            depositProductAddRequest.setClassifierDepProduct(classifierDepProduct);
            depositProductAddRequest.setNameDepProduct(nameDepProduct);
            depositProductAddRequest.setAnnulDepProduct(annulDepProduct);
            depositProductAddRequest.setCurrencyDepProduct(currencyDepProduct);
            depositProductAddRequest.setTypePercentDepProduct(typePercentDepProduct);
            depositProductAddRequest.setTypeBaseDepProduct(typeBaseDepProduct);
            depositProductAddRequest.setViewPercentDepProduct(viewPercentDepProduct);
            depositProductAddRequest.setSumCloseDepProduct(sumCloseDepProduct);
            depositProductAddRequest.setProcCloseDepProduct(procCloseDepProduct);
            depositProductAddRequest.setTermTypeDepProduct(termTypeDepProduct);
            depositProductAddRequest.setTermDepProduct(termDepProduct);
            depositProductAddRequest.setCapitalizationDepProduct(capitalizationDepProduct);
            depositProductAddRequest.setAccountCardDepProduct(accountCardDepProduct);
            depositProductAddRequest.setCurrencyLimitDepProduct(currencyLimitDepProduct);
            depositProductAddRequest.setMinSumDepProduct(minSumDepProduct);
            depositProductAddRequest.setRenewalSumDepProduct(renewalSumDepProduct);
            depositProductAddRequest.setMaxRenewalSumDepProduct(maxRenewalSumDepProduct);
            depositProductAddRequest.setWithdrawalTypeDepProduct(withdrawalTypeDepProduct);
            depositProductAddRequest.setLinkedAccountDepProduct(linkedAccountDepProduct);
            depositProductAddRequest.setCloseToCurrentDepProduct(closeToCurrentDepProduct);
            depositProductAddRequest.setExtraDepProduct(extraDepProduct);
            depositProductAddRequest.setOtherFaceDepProduct(otherFaceDepProduct);
            depositProductAddRequest.setInvalidChildDepProduct(invalidChildDepProduct);
            depositProductAddRequest.setRepresentDepProduct(representDepProduct);
            depositProductAddRequest.setIbOpenDepProduct(ibOpenDepProduct);
            depositProductAddRequest.setTaxDepProduct(taxDepProduct);
            depositProductAddRequest.setSmsDiscDepProduct(smsDiscDepProduct);
            depositProductAddRequest.setSmsDiscSizeDepProduct(smsDiscSizeDepProduct);
            depositProductAddRequest.setCurrentSumDepProduct(currentSumDepProduct);
            depositProductAddRequest.setTermRenewalTypeDepProduct(termRenewalTypeDepProduct);
            depositProductAddRequest.setTermRenewalDepProduct(termRenewalDepProduct);
            depositProductAddRequest.setWithdrawalPeriodDepProduct(withdrawalPeriodDepProduct);
            depositProductAddRequest.setWithdrawalSumDepProduct(withdrawalSumDepProduct);
            depositProductAddRequest.setWithdrawalMinBalanceDepProduct(withdrawalMinBalanceDepProduct);
            depositProductAddRequest.setWithdrawalPercentDepProduct(withdrawalPercentDepProduct);
            depositProductAddRequest.setWithdrawalSumMaxDepProduct(withdrawalSumMaxDepProduct);
            depositProductAddRequest.setWithdrawalProhibitedDepProduct(withdrawalProhibitedDepProduct);
            depositProductAddRequest.setWithdrawalTermTypDepProduct(withdrawalTermTypDepProduct);
            depositProductAddRequest.setWithdrawalTermDepProduct(withdrawalTermDepProduct);
            depositProductAddRequest.setFormDepProduct(formDepProduct);
            depositProductAddRequest.setUserCode(userCode);
            depositProductAddRequest.setDepositProductId(depositProductId);
            depositProductAddRequest.setRenewalPeriodDepProduct(renewalPeriodDepProduct);
            depositProductAddRequest.setLegalrepresentDepProduct(legalrepresentDepProduct);
            depositProductAddRequest.setProhibManualOpenDepProduct(prohibManualOpenDepProduct);
            depositProductAddRequest.setProhibManualCloseDepProduct(prohibManualCloseDepProduct);
            depositProductAddRequest.setIsCancelPeriodDepProduct(isCancelPeriodDepProduct);
            depositProductAddRequest.setCancelPeriodDepProduct(cancelPeriodDepProduct);
            return depositProductAddRequest;
        }

    }

}
