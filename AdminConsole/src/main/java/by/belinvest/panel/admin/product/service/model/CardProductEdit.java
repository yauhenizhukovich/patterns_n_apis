package by.belinvest.panel.admin.product.service.model;

import java.math.BigDecimal;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardProductEdit {

    private String userCode;
    private String cardProductId;
    private String nameCardProduct;
    private BigDecimal expireCardProduct;
    private String binCardProduct;
    private String codeCardTypeCardProduct;
    private String nameLangCardProduct;
    private String cardNameCardProduct;
    private String urlCardProduct;
    private String isicCardProduct;
    private Boolean onlineOrderCardProduct;
    private Boolean comissionCardProduct;
    private Boolean mainCardProduct;
    private Boolean virtualOperationCardProduct;
    private Boolean banProlongCardProduct;
    private Boolean banReemisionCardProduct;
    private Boolean additionalCardProduct;
    private Boolean cashbackCardProduct;
    private Boolean dispatchPinCardProduct;
    private Boolean analysisNonCashTurnoverCardProduct;
    private Boolean megatransactorCardProduct;
    private Boolean banGiveMoneyCardProduct;
    private Boolean doNotIncludeDocumentsCardProduct;
    private Boolean notChangeCardAtTheCardPackageInIBCardProduct;
    private Boolean manyFunctionalCardsCardProduct;
    private Boolean customDesignCardProduct;
    private Boolean customDeliveryCardProduct;
    private Boolean cancelCompareVspomCardProduct;
    private Boolean saveCardNameVspomCardProduct;
    private Boolean banOperationInternetCardProduct;
    private Boolean freeVeiwBalanceCardProduct;
    private Boolean allowComissionCardProduct;
    private String designIdEmvCardProduct;
    private String applIdEmvCardProduct;
    private Boolean virtualCardProduct;
    private Boolean avtomaticEmissionCardProduct;
    private Boolean dboCardProduct;
    private BigDecimal minCountCardProduct;
    private BigDecimal countForGenerationCardProduct;
    private Boolean allowSetLimitCardProduct;
    private BigDecimal sumSetLimitBrisCardProduct;
    private BigDecimal sumSetLimitIbCardProduct;
    private Boolean editCardNameCardProduct;
    private BigDecimal lenCardNameCardProduct;
    private Boolean allowProlongIbCardProduct;
    private Boolean allowReemissionCardProduct;
    private String mediaView1934CardProduct;
    private String cardView1934CardProduct;
    private String socialPurpose1934CardProduct;
    private String dopServicesCardProduct;
    private Boolean kobrendovayaCardProduct;
    private Boolean contactlessCardProduct;
    private Options[] optionsCardProduct;
    private Boolean avtomaticReplaceRateCardProduct;
    private BigDecimal rateValueCardProduct;
    private Boolean transferDepositRateCardProduct;
    private Boolean disableAdditionalPaymentsCardProduct;
    private Boolean noActiveDepositCardProduct;
    private DepositOrCreditProducts[] depositOrCreditCardProduct;
    private Boolean transferCreditRateWhenProlongCardProduct;
    private Boolean transferCreditRateWhenLimitChangedCardProduct;
    private Boolean transferCreditRateWhenReplaceCardProduct;
    private DopProducts[] dopProductForCardProduct;
    private CurrencyProducts[] currencyProductForCardProduct;
    private Fine[] fineCardProduct;
    private ReplaceProductsForProlong[] replaceProductForProlongCardProduct;
    private ReplaceProductsForReemision[] replaceProductForReemisionCardProduct;
    private HandReplaceProduct[] handReplaceProductCardProduct;
    private BigDecimal minSumNonCashTurnoverCardProduct;
    private BigDecimal cardServiceDiscountCardProduct;
    private Boolean isFreeCardProduct;
    private SmsTariff[] smsTariffCardProduct;
    private Uvkv[] uvkvCardProduct;
    private GroupRisk[] groupRiskCardProduct;
    private MegatransactorOptions[] megatransactorOptionsCardProduct;
    private Enterprise[] enterpriseCardProduct;



    @Override
    public String toString() {
        return "CardProductEdit{" +
                "userCode='" + userCode + '\'' +
                ", cardProductId='" + cardProductId + '\'' +
                ", nameCardProduct='" + nameCardProduct + '\'' +
                ", expireCardProduct=" + expireCardProduct +
                ", binCardProduct='" + binCardProduct + '\'' +
                ", codeCardTypeCardProduct='" + codeCardTypeCardProduct + '\'' +
                ", nameLangCardProduct='" + nameLangCardProduct + '\'' +
                ", cardNameCardProduct='" + cardNameCardProduct + '\'' +
                ", urlCardProduct='" + urlCardProduct + '\'' +
                ", isicCardProduct='" + isicCardProduct + '\'' +
                ", onlineOrderCardProduct=" + onlineOrderCardProduct +
                ", comissionCardProduct=" + comissionCardProduct +
                ", mainCardProduct=" + mainCardProduct +
                ", virtualOperationCardProduct=" + virtualOperationCardProduct +
                ", banProlongCardProduct=" + banProlongCardProduct +
                ", banReemisionCardProduct=" + banReemisionCardProduct +
                ", additionalCardProduct=" + additionalCardProduct +
                ", cashbackCardProduct=" + cashbackCardProduct +
                ", dispatchPinCardProduct=" + dispatchPinCardProduct +
                ", analysisNonCashTurnoverCardProduct=" + analysisNonCashTurnoverCardProduct +
                ", megatransactorCardProduct=" + megatransactorCardProduct +
                ", banGiveMoneyCardProduct=" + banGiveMoneyCardProduct +
                ", doNotIncludeDocumentsCardProduct=" + doNotIncludeDocumentsCardProduct +
                ", notChangeCardAtTheCardPackageInIBCardProduct=" + notChangeCardAtTheCardPackageInIBCardProduct +
                ", manyFunctionalCardsCardProduct=" + manyFunctionalCardsCardProduct +
                ", customDesignCardProduct=" + customDesignCardProduct +
                ", customDeliveryCardProduct=" + customDeliveryCardProduct +
                ", cancelCompareVspomCardProduct=" + cancelCompareVspomCardProduct +
                ", saveCardNameVspomCardProduct=" + saveCardNameVspomCardProduct +
                ", banOperationInternetCardProduct=" + banOperationInternetCardProduct +
                ", freeVeiwBalanceCardProduct=" + freeVeiwBalanceCardProduct +
                ", allowComissionCardProduct=" + allowComissionCardProduct +
                ", designIdEmvCardProduct='" + designIdEmvCardProduct + '\'' +
                ", applIdEmvCardProduct='" + applIdEmvCardProduct + '\'' +
                ", virtualCardProduct=" + virtualCardProduct +
                ", avtomaticEmissionCardProduct=" + avtomaticEmissionCardProduct +
                ", dboCardProduct=" + dboCardProduct +
                ", minCountCardProduct=" + minCountCardProduct +
                ", countForGenerationCardProduct=" + countForGenerationCardProduct +
                ", allowSetLimitCardProduct=" + allowSetLimitCardProduct +
                ", sumSetLimitBrisCardProduct=" + sumSetLimitBrisCardProduct +
                ", sumSetLimitIbCardProduct=" + sumSetLimitIbCardProduct +
                ", editCardNameCardProduct=" + editCardNameCardProduct +
                ", lenCardNameCardProduct=" + lenCardNameCardProduct +
                ", allowProlongIbCardProduct=" + allowProlongIbCardProduct +
                ", allowReemissionCardProduct=" + allowReemissionCardProduct +
                ", mediaView1934CardProduct='" + mediaView1934CardProduct + '\'' +
                ", cardView1934CardProduct='" + cardView1934CardProduct + '\'' +
                ", socialPurpose1934CardProduct='" + socialPurpose1934CardProduct + '\'' +
                ", dopServicesCardProduct='" + dopServicesCardProduct + '\'' +
                ", kobrendovayaCardProduct=" + kobrendovayaCardProduct +
                ", contactlessCardProduct=" + contactlessCardProduct +
                ", optionsCardProduct=" + Arrays.toString(optionsCardProduct) +
                ", avtomaticReplaceRateCardProduct=" + avtomaticReplaceRateCardProduct +
                ", rateValueCardProduct=" + rateValueCardProduct +
                ", transferDepositRateCardProduct=" + transferDepositRateCardProduct +
                ", disableAdditionalPaymentsCardProduct=" + disableAdditionalPaymentsCardProduct +
                ", noActiveDepositCardProduct=" + noActiveDepositCardProduct +
                ", depositOrCreditCardProduct=" + Arrays.toString(depositOrCreditCardProduct) +
                ", transferCreditRateWhenProlongCardProduct=" + transferCreditRateWhenProlongCardProduct +
                ", transferCreditRateWhenLimitChangedCardProduct=" + transferCreditRateWhenLimitChangedCardProduct +
                ", transferCreditRateWhenReplaceCardProduct=" + transferCreditRateWhenReplaceCardProduct +
                ", dopProductForCardProduct=" + Arrays.toString(dopProductForCardProduct) +
                ", currencyProductForCardProduct=" + Arrays.toString(currencyProductForCardProduct) +
                ", fineCardProduct=" + Arrays.toString(fineCardProduct) +
                ", replaceProductForProlongCardProduct=" + Arrays.toString(replaceProductForProlongCardProduct) +
                ", replaceProductForReemisionCardProduct=" + Arrays.toString(replaceProductForReemisionCardProduct) +
                ", handReplaceProductCardProduct=" + Arrays.toString(handReplaceProductCardProduct) +
                ", minSumNonCashTurnoverCardProduct=" + minSumNonCashTurnoverCardProduct +
                ", cardServiceDiscountCardProduct=" + cardServiceDiscountCardProduct +
                ", isFreeCardProduct=" + isFreeCardProduct +
                ", smsTariffCardProduct=" + Arrays.toString(smsTariffCardProduct) +
                ", uvkvCardProduct=" + Arrays.toString(uvkvCardProduct) +
                ", groupRiskCardProduct=" + Arrays.toString(groupRiskCardProduct) +
                ", megatransactorOptionsCardProduct=" + Arrays.toString(megatransactorOptionsCardProduct) +
                ", enterpriseCardProduct=" + Arrays.toString(enterpriseCardProduct) +
                '}';
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCardProductId() {
        return cardProductId;
    }

    public void setCardProductId(String cardProductId) {
        this.cardProductId = cardProductId;
    }

    public String getNameCardProduct() {
        return nameCardProduct;
    }

    public void setNameCardProduct(String nameCardProduct) {
        this.nameCardProduct = nameCardProduct;
    }

    public BigDecimal getExpireCardProduct() {
        return expireCardProduct;
    }

    public void setExpireCardProduct(BigDecimal expireCardProduct) {
        this.expireCardProduct = expireCardProduct;
    }

    public String getBinCardProduct() {
        return binCardProduct;
    }

    public void setBinCardProduct(String binCardProduct) {
        this.binCardProduct = binCardProduct;
    }

    public String getCodeCardTypeCardProduct() {
        return codeCardTypeCardProduct;
    }

    public void setCodeCardTypeCardProduct(String codeCardTypeCardProduct) {
        this.codeCardTypeCardProduct = codeCardTypeCardProduct;
    }

    public String getNameLangCardProduct() {
        return nameLangCardProduct;
    }

    public void setNameLangCardProduct(String nameLangCardProduct) {
        this.nameLangCardProduct = nameLangCardProduct;
    }

    public String getCardNameCardProduct() {
        return cardNameCardProduct;
    }

    public void setCardNameCardProduct(String cardNameCardProduct) {
        this.cardNameCardProduct = cardNameCardProduct;
    }

    public String getUrlCardProduct() {
        return urlCardProduct;
    }

    public void setUrlCardProduct(String urlCardProduct) {
        this.urlCardProduct = urlCardProduct;
    }

    public String getIsicCardProduct() {
        return isicCardProduct;
    }

    public void setIsicCardProduct(String isicCardProduct) {
        this.isicCardProduct = isicCardProduct;
    }

    public Boolean getOnlineOrderCardProduct() {
        return onlineOrderCardProduct;
    }

    public void setOnlineOrderCardProduct(Boolean onlineOrderCardProduct) {
        this.onlineOrderCardProduct = onlineOrderCardProduct;
    }

    public Boolean getComissionCardProduct() {
        return comissionCardProduct;
    }

    public void setComissionCardProduct(Boolean comissionCardProduct) {
        this.comissionCardProduct = comissionCardProduct;
    }

    public Boolean getMainCardProduct() {
        return mainCardProduct;
    }

    public void setMainCardProduct(Boolean mainCardProduct) {
        this.mainCardProduct = mainCardProduct;
    }

    public Boolean getVirtualOperationCardProduct() {
        return virtualOperationCardProduct;
    }

    public void setVirtualOperationCardProduct(Boolean virtualOperationCardProduct) {
        this.virtualOperationCardProduct = virtualOperationCardProduct;
    }

    public Boolean getBanProlongCardProduct() {
        return banProlongCardProduct;
    }

    public void setBanProlongCardProduct(Boolean banProlongCardProduct) {
        this.banProlongCardProduct = banProlongCardProduct;
    }

    public Boolean getBanReemisionCardProduct() {
        return banReemisionCardProduct;
    }

    public void setBanReemisionCardProduct(Boolean banReemisionCardProduct) {
        this.banReemisionCardProduct = banReemisionCardProduct;
    }

    public Boolean getAdditionalCardProduct() {
        return additionalCardProduct;
    }

    public void setAdditionalCardProduct(Boolean additionalCardProduct) {
        this.additionalCardProduct = additionalCardProduct;
    }

    public Boolean getCashbackCardProduct() {
        return cashbackCardProduct;
    }

    public void setCashbackCardProduct(Boolean cashbackCardProduct) {
        this.cashbackCardProduct = cashbackCardProduct;
    }

    public Boolean getDispatchPinCardProduct() {
        return dispatchPinCardProduct;
    }

    public void setDispatchPinCardProduct(Boolean dispatchPinCardProduct) {
        this.dispatchPinCardProduct = dispatchPinCardProduct;
    }

    public Boolean getAnalysisNonCashTurnoverCardProduct() {
        return analysisNonCashTurnoverCardProduct;
    }

    public void setAnalysisNonCashTurnoverCardProduct(Boolean analysisNonCashTurnoverCardProduct) {
        this.analysisNonCashTurnoverCardProduct = analysisNonCashTurnoverCardProduct;
    }

    public Boolean getMegatransactorCardProduct() {
        return megatransactorCardProduct;
    }

    public void setMegatransactorCardProduct(Boolean megatransactorCardProduct) {
        this.megatransactorCardProduct = megatransactorCardProduct;
    }

    public Boolean getBanGiveMoneyCardProduct() {
        return banGiveMoneyCardProduct;
    }

    public void setBanGiveMoneyCardProduct(Boolean banGiveMoneyCardProduct) {
        this.banGiveMoneyCardProduct = banGiveMoneyCardProduct;
    }

    public Boolean getDoNotIncludeDocumentsCardProduct() {
        return doNotIncludeDocumentsCardProduct;
    }

    public void setDoNotIncludeDocumentsCardProduct(Boolean doNotIncludeDocumentsCardProduct) {
        this.doNotIncludeDocumentsCardProduct = doNotIncludeDocumentsCardProduct;
    }

    public Boolean getNotChangeCardAtTheCardPackageInIBCardProduct() {
        return notChangeCardAtTheCardPackageInIBCardProduct;
    }

    public void setNotChangeCardAtTheCardPackageInIBCardProduct(Boolean notChangeCardAtTheCardPackageInIBCardProduct) {
        this.notChangeCardAtTheCardPackageInIBCardProduct = notChangeCardAtTheCardPackageInIBCardProduct;
    }

    public Boolean getManyFunctionalCardsCardProduct() {
        return manyFunctionalCardsCardProduct;
    }

    public void setManyFunctionalCardsCardProduct(Boolean manyFunctionalCardsCardProduct) {
        this.manyFunctionalCardsCardProduct = manyFunctionalCardsCardProduct;
    }

    public Boolean getCustomDesignCardProduct() {
        return customDesignCardProduct;
    }

    public void setCustomDesignCardProduct(Boolean customDesignCardProduct) {
        this.customDesignCardProduct = customDesignCardProduct;
    }

    public Boolean getCustomDeliveryCardProduct() {
        return customDeliveryCardProduct;
    }

    public void setCustomDeliveryCardProduct(Boolean customDeliveryCardProduct) {
        this.customDeliveryCardProduct = customDeliveryCardProduct;
    }

    public Boolean getCancelCompareVspomCardProduct() {
        return cancelCompareVspomCardProduct;
    }

    public void setCancelCompareVspomCardProduct(Boolean cancelCompareVspomCardProduct) {
        this.cancelCompareVspomCardProduct = cancelCompareVspomCardProduct;
    }

    public Boolean getSaveCardNameVspomCardProduct() {
        return saveCardNameVspomCardProduct;
    }

    public void setSaveCardNameVspomCardProduct(Boolean saveCardNameVspomCardProduct) {
        this.saveCardNameVspomCardProduct = saveCardNameVspomCardProduct;
    }

    public Boolean getBanOperationInternetCardProduct() {
        return banOperationInternetCardProduct;
    }

    public void setBanOperationInternetCardProduct(Boolean banOperationInternetCardProduct) {
        this.banOperationInternetCardProduct = banOperationInternetCardProduct;
    }

    public Boolean getFreeVeiwBalanceCardProduct() {
        return freeVeiwBalanceCardProduct;
    }

    public void setFreeVeiwBalanceCardProduct(Boolean freeVeiwBalanceCardProduct) {
        this.freeVeiwBalanceCardProduct = freeVeiwBalanceCardProduct;
    }

    public Boolean getAllowComissionCardProduct() {
        return allowComissionCardProduct;
    }

    public void setAllowComissionCardProduct(Boolean allowComissionCardProduct) {
        this.allowComissionCardProduct = allowComissionCardProduct;
    }

    public String getDesignIdEmvCardProduct() {
        return designIdEmvCardProduct;
    }

    public void setDesignIdEmvCardProduct(String designIdEmvCardProduct) {
        this.designIdEmvCardProduct = designIdEmvCardProduct;
    }

    public String getApplIdEmvCardProduct() {
        return applIdEmvCardProduct;
    }

    public void setApplIdEmvCardProduct(String applIdEmvCardProduct) {
        this.applIdEmvCardProduct = applIdEmvCardProduct;
    }

    public Boolean getVirtualCardProduct() {
        return virtualCardProduct;
    }

    public void setVirtualCardProduct(Boolean virtualCardProduct) {
        this.virtualCardProduct = virtualCardProduct;
    }

    public Boolean getAvtomaticEmissionCardProduct() {
        return avtomaticEmissionCardProduct;
    }

    public void setAvtomaticEmissionCardProduct(Boolean avtomaticEmissionCardProduct) {
        this.avtomaticEmissionCardProduct = avtomaticEmissionCardProduct;
    }

    public Boolean getDboCardProduct() {
        return dboCardProduct;
    }

    public void setDboCardProduct(Boolean dboCardProduct) {
        this.dboCardProduct = dboCardProduct;
    }

    public BigDecimal getMinCountCardProduct() {
        return minCountCardProduct;
    }

    public void setMinCountCardProduct(BigDecimal minCountCardProduct) {
        this.minCountCardProduct = minCountCardProduct;
    }

    public BigDecimal getCountForGenerationCardProduct() {
        return countForGenerationCardProduct;
    }

    public void setCountForGenerationCardProduct(BigDecimal countForGenerationCardProduct) {
        this.countForGenerationCardProduct = countForGenerationCardProduct;
    }

    public Boolean getAllowSetLimitCardProduct() {
        return allowSetLimitCardProduct;
    }

    public void setAllowSetLimitCardProduct(Boolean allowSetLimitCardProduct) {
        this.allowSetLimitCardProduct = allowSetLimitCardProduct;
    }

    public BigDecimal getSumSetLimitBrisCardProduct() {
        return sumSetLimitBrisCardProduct;
    }

    public void setSumSetLimitBrisCardProduct(BigDecimal sumSetLimitBrisCardProduct) {
        this.sumSetLimitBrisCardProduct = sumSetLimitBrisCardProduct;
    }

    public BigDecimal getSumSetLimitIbCardProduct() {
        return sumSetLimitIbCardProduct;
    }

    public void setSumSetLimitIbCardProduct(BigDecimal sumSetLimitIbCardProduct) {
        this.sumSetLimitIbCardProduct = sumSetLimitIbCardProduct;
    }

    public Boolean getEditCardNameCardProduct() {
        return editCardNameCardProduct;
    }

    public void setEditCardNameCardProduct(Boolean editCardNameCardProduct) {
        this.editCardNameCardProduct = editCardNameCardProduct;
    }

    public BigDecimal getLenCardNameCardProduct() {
        return lenCardNameCardProduct;
    }

    public void setLenCardNameCardProduct(BigDecimal lenCardNameCardProduct) {
        this.lenCardNameCardProduct = lenCardNameCardProduct;
    }

    public Boolean getAllowProlongIbCardProduct() {
        return allowProlongIbCardProduct;
    }

    public void setAllowProlongIbCardProduct(Boolean allowProlongIbCardProduct) {
        this.allowProlongIbCardProduct = allowProlongIbCardProduct;
    }

    public Boolean getAllowReemissionCardProduct() {
        return allowReemissionCardProduct;
    }

    public void setAllowReemissionCardProduct(Boolean allowReemissionCardProduct) {
        this.allowReemissionCardProduct = allowReemissionCardProduct;
    }

    public String getMediaView1934CardProduct() {
        return mediaView1934CardProduct;
    }

    public void setMediaView1934CardProduct(String mediaView1934CardProduct) {
        this.mediaView1934CardProduct = mediaView1934CardProduct;
    }

    public String getCardView1934CardProduct() {
        return cardView1934CardProduct;
    }

    public void setCardView1934CardProduct(String cardView1934CardProduct) {
        this.cardView1934CardProduct = cardView1934CardProduct;
    }

    public String getSocialPurpose1934CardProduct() {
        return socialPurpose1934CardProduct;
    }

    public void setSocialPurpose1934CardProduct(String socialPurpose1934CardProduct) {
        this.socialPurpose1934CardProduct = socialPurpose1934CardProduct;
    }

    public String getDopServicesCardProduct() {
        return dopServicesCardProduct;
    }

    public void setDopServicesCardProduct(String dopServicesCardProduct) {
        this.dopServicesCardProduct = dopServicesCardProduct;
    }

    public Boolean getKobrendovayaCardProduct() {
        return kobrendovayaCardProduct;
    }

    public void setKobrendovayaCardProduct(Boolean kobrendovayaCardProduct) {
        this.kobrendovayaCardProduct = kobrendovayaCardProduct;
    }

    public Boolean getContactlessCardProduct() {
        return contactlessCardProduct;
    }

    public void setContactlessCardProduct(Boolean contactlessCardProduct) {
        this.contactlessCardProduct = contactlessCardProduct;
    }

    public Options[] getOptionsCardProduct() {
        return optionsCardProduct;
    }

    public void setOptionsCardProduct(Options[] optionsCardProduct) {
        this.optionsCardProduct = optionsCardProduct;
    }

    public Boolean getAvtomaticReplaceRateCardProduct() {
        return avtomaticReplaceRateCardProduct;
    }

    public void setAvtomaticReplaceRateCardProduct(Boolean avtomaticReplaceRateCardProduct) {
        this.avtomaticReplaceRateCardProduct = avtomaticReplaceRateCardProduct;
    }

    public BigDecimal getRateValueCardProduct() {
        return rateValueCardProduct;
    }

    public void setRateValueCardProduct(BigDecimal rateValueCardProduct) {
        this.rateValueCardProduct = rateValueCardProduct;
    }

    public Boolean getTransferDepositRateCardProduct() {
        return transferDepositRateCardProduct;
    }

    public void setTransferDepositRateCardProduct(Boolean transferDepositRateCardProduct) {
        this.transferDepositRateCardProduct = transferDepositRateCardProduct;
    }

    public Boolean getDisableAdditionalPaymentsCardProduct() {
        return disableAdditionalPaymentsCardProduct;
    }

    public void setDisableAdditionalPaymentsCardProduct(Boolean disableAdditionalPaymentsCardProduct) {
        this.disableAdditionalPaymentsCardProduct = disableAdditionalPaymentsCardProduct;
    }

    public Boolean getNoActiveDepositCardProduct() {
        return noActiveDepositCardProduct;
    }

    public void setNoActiveDepositCardProduct(Boolean noActiveDepositCardProduct) {
        this.noActiveDepositCardProduct = noActiveDepositCardProduct;
    }

    public DepositOrCreditProducts[] getDepositOrCreditCardProduct() {
        return depositOrCreditCardProduct;
    }

    public void setDepositOrCreditCardProduct(DepositOrCreditProducts[] depositOrCreditCardProduct) {
        this.depositOrCreditCardProduct = depositOrCreditCardProduct;
    }

    public Boolean getTransferCreditRateWhenProlongCardProduct() {
        return transferCreditRateWhenProlongCardProduct;
    }

    public void setTransferCreditRateWhenProlongCardProduct(Boolean transferCreditRateWhenProlongCardProduct) {
        this.transferCreditRateWhenProlongCardProduct = transferCreditRateWhenProlongCardProduct;
    }

    public Boolean getTransferCreditRateWhenLimitChangedCardProduct() {
        return transferCreditRateWhenLimitChangedCardProduct;
    }

    public void setTransferCreditRateWhenLimitChangedCardProduct(Boolean transferCreditRateWhenLimitChangedCardProduct) {
        this.transferCreditRateWhenLimitChangedCardProduct = transferCreditRateWhenLimitChangedCardProduct;
    }

    public Boolean getTransferCreditRateWhenReplaceCardProduct() {
        return transferCreditRateWhenReplaceCardProduct;
    }

    public void setTransferCreditRateWhenReplaceCardProduct(Boolean transferCreditRateWhenReplaceCardProduct) {
        this.transferCreditRateWhenReplaceCardProduct = transferCreditRateWhenReplaceCardProduct;
    }

    public DopProducts[] getDopProductForCardProduct() {
        return dopProductForCardProduct;
    }

    public void setDopProductForCardProduct(DopProducts[] dopProductForCardProduct) {
        this.dopProductForCardProduct = dopProductForCardProduct;
    }

    public CurrencyProducts[] getCurrencyProductForCardProduct() {
        return currencyProductForCardProduct;
    }

    public void setCurrencyProductForCardProduct(CurrencyProducts[] currencyProductForCardProduct) {
        this.currencyProductForCardProduct = currencyProductForCardProduct;
    }

    public Fine[] getFineCardProduct() {
        return fineCardProduct;
    }

    public void setFineCardProduct(Fine[] fineCardProduct) {
        this.fineCardProduct = fineCardProduct;
    }

    public ReplaceProductsForProlong[] getReplaceProductForProlongCardProduct() {
        return replaceProductForProlongCardProduct;
    }

    public void setReplaceProductForProlongCardProduct(ReplaceProductsForProlong[] replaceProductForProlongCardProduct) {
        this.replaceProductForProlongCardProduct = replaceProductForProlongCardProduct;
    }

    public ReplaceProductsForReemision[] getReplaceProductForReemisionCardProduct() {
        return replaceProductForReemisionCardProduct;
    }

    public void setReplaceProductForReemisionCardProduct(ReplaceProductsForReemision[] replaceProductForReemisionCardProduct) {
        this.replaceProductForReemisionCardProduct = replaceProductForReemisionCardProduct;
    }

    public HandReplaceProduct[] getHandReplaceProductCardProduct() {
        return handReplaceProductCardProduct;
    }

    public void setHandReplaceProductCardProduct(HandReplaceProduct[] handReplaceProductCardProduct) {
        this.handReplaceProductCardProduct = handReplaceProductCardProduct;
    }

    public BigDecimal getMinSumNonCashTurnoverCardProduct() {
        return minSumNonCashTurnoverCardProduct;
    }

    public void setMinSumNonCashTurnoverCardProduct(BigDecimal minSumNonCashTurnoverCardProduct) {
        this.minSumNonCashTurnoverCardProduct = minSumNonCashTurnoverCardProduct;
    }

    public BigDecimal getCardServiceDiscountCardProduct() {
        return cardServiceDiscountCardProduct;
    }

    public void setCardServiceDiscountCardProduct(BigDecimal cardServiceDiscountCardProduct) {
        this.cardServiceDiscountCardProduct = cardServiceDiscountCardProduct;
    }

    @JsonProperty("isFreeCardProduct")
    public Boolean getFreeCardProduct() {
        return isFreeCardProduct;
    }

    @JsonProperty("isFreeCardProduct")
    public void setFreeCardProduct(Boolean freeCardProduct) {
        isFreeCardProduct = freeCardProduct;
    }

    public SmsTariff[] getSmsTariffCardProduct() {
        return smsTariffCardProduct;
    }

    public void setSmsTariffCardProduct(SmsTariff[] smsTariffCardProduct) {
        this.smsTariffCardProduct = smsTariffCardProduct;
    }

    public Uvkv[] getUvkvCardProduct() {
        return uvkvCardProduct;
    }

    public void setUvkvCardProduct(Uvkv[] uvkvCardProduct) {
        this.uvkvCardProduct = uvkvCardProduct;
    }

    public GroupRisk[] getGroupRiskCardProduct() {
        return groupRiskCardProduct;
    }

    public void setGroupRiskCardProduct(GroupRisk[] groupRiskCardProduct) {
        this.groupRiskCardProduct = groupRiskCardProduct;
    }

    public MegatransactorOptions[] getMegatransactorOptionsCardProduct() {
        return megatransactorOptionsCardProduct;
    }

    public void setMegatransactorOptionsCardProduct(MegatransactorOptions[] megatransactorOptionsCardProduct) {
        this.megatransactorOptionsCardProduct = megatransactorOptionsCardProduct;
    }

    public Enterprise[] getEnterpriseCardProduct() {
        return enterpriseCardProduct;
    }

    public void setEnterpriseCardProduct(Enterprise[] enterpriseCardProduct) {
        this.enterpriseCardProduct = enterpriseCardProduct;
    }

    public static final class Builder {

        private String userCode;
        private String cardProductId;
        private String nameCardProduct;
        private BigDecimal expireCardProduct;
        private String binCardProduct;
        private String codeCardTypeCardProduct;
        private String nameLangCardProduct;
        private String cardNameCardProduct;
        private String urlCardProduct;
        private String isicCardProduct;
        private Boolean onlineOrderCardProduct;
        private Boolean comissionCardProduct;
        private Boolean mainCardProduct;
        private Boolean virtualOperationCardProduct;
        private Boolean banProlongCardProduct;
        private Boolean banReemisionCardProduct;
        private Boolean additionalCardProduct;
        private Boolean cashbackCardProduct;
        private Boolean dispatchPinCardProduct;
        private Boolean analysisNonCashTurnoverCardProduct;
        private Boolean megatransactorCardProduct;
        private Boolean banGiveMoneyCardProduct;
        private Boolean doNotIncludeDocumentsCardProduct;
        private Boolean notChangeCardAtTheCardPackageInIBCardProduct;
        private Boolean manyFunctionalCardsCardProduct;
        private Boolean customDesignCardProduct;
        private Boolean customDeliveryCardProduct;
        private Boolean cancelCompareVspomCardProduct;
        private Boolean saveCardNameVspomCardProduct;
        private Boolean banOperationInternetCardProduct;
        private Boolean freeVeiwBalanceCardProduct;
        private Boolean allowComissionCardProduct;
        private String designIdEmvCardProduct;
        private String applIdEmvCardProduct;
        private Boolean virtualCardProduct;
        private Boolean avtomaticEmissionCardProduct;
        private Boolean dboCardProduct;
        private BigDecimal minCountCardProduct;
        private BigDecimal countForGenerationCardProduct;
        private Boolean allowSetLimitCardProduct;
        private BigDecimal sumSetLimitBrisCardProduct;
        private BigDecimal sumSetLimitIbCardProduct;
        private Boolean editCardNameCardProduct;
        private BigDecimal lenCardNameCardProduct;
        private Boolean allowProlongIbCardProduct;
        private Boolean allowReemissionCardProduct;
        private String mediaView1934CardProduct;
        private String cardView1934CardProduct;
        private String socialPurpose1934CardProduct;
        private String dopServicesCardProduct;
        private Boolean kobrendovayaCardProduct;
        private Boolean contactlessCardProduct;
        private Options[] optionsCardProduct;
        private Boolean avtomaticReplaceRateCardProduct;
        private BigDecimal rateValueCardProduct;
        private Boolean transferDepositRateCardProduct;
        private Boolean disableAdditionalPaymentsCardProduct;
        private Boolean noActiveDepositCardProduct;
        private DepositOrCreditProducts[] depositOrCreditCardProduct;
        private Boolean transferCreditRateWhenProlongCardProduct;
        private Boolean transferCreditRateWhenLimitChangedCardProduct;
        private Boolean transferCreditRateWhenReplaceCardProduct;
        private DopProducts[] dopProductForCardProduct;
        private CurrencyProducts[] currencyProductForCardProduct;
        private Fine[] fineCardProduct;
        private ReplaceProductsForProlong[] replaceProductForProlongCardProduct;
        private ReplaceProductsForReemision[] replaceProductForReemisionCardProduct;
        private HandReplaceProduct[] handReplaceProductCardProduct;
        private BigDecimal minSumNonCashTurnoverCardProduct;
        private BigDecimal cardServiceDiscountCardProduct;
        private Boolean isFreeCardProduct;
        private SmsTariff[] smsTariffCardProduct;
        private Uvkv[] uvkvCardProduct;
        private GroupRisk[] groupRiskCardProduct;
        private MegatransactorOptions[] megatransactorOptionsCardProduct;
        private Enterprise[] enterpriseCardProduct;

        private Builder() {}

        public static Builder aCardProductEdit() { return new Builder(); }

        public Builder userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder cardProductId(String cardProductId) {
            this.cardProductId = cardProductId;
            return this;
        }

        public Builder nameCardProduct(String nameCardProduct) {
            this.nameCardProduct = nameCardProduct;
            return this;
        }

        public Builder expireCardProduct(BigDecimal expireCardProduct) {
            this.expireCardProduct = expireCardProduct;
            return this;
        }

        public Builder binCardProduct(String binCardProduct) {
            this.binCardProduct = binCardProduct;
            return this;
        }

        public Builder codeCardTypeCardProduct(String codeCardTypeCardProduct) {
            this.codeCardTypeCardProduct = codeCardTypeCardProduct;
            return this;
        }

        public Builder nameLangCardProduct(String nameLangCardProduct) {
            this.nameLangCardProduct = nameLangCardProduct;
            return this;
        }

        public Builder cardNameCardProduct(String cardNameCardProduct) {
            this.cardNameCardProduct = cardNameCardProduct;
            return this;
        }

        public Builder urlCardProduct(String urlCardProduct) {
            this.urlCardProduct = urlCardProduct;
            return this;
        }

        public Builder isicCardProduct(String isicCardProduct) {
            this.isicCardProduct = isicCardProduct;
            return this;
        }

        public Builder onlineOrderCardProduct(Boolean onlineOrderCardProduct) {
            this.onlineOrderCardProduct = onlineOrderCardProduct;
            return this;
        }

        public Builder comissionCardProduct(Boolean comissionCardProduct) {
            this.comissionCardProduct = comissionCardProduct;
            return this;
        }

        public Builder mainCardProduct(Boolean mainCardProduct) {
            this.mainCardProduct = mainCardProduct;
            return this;
        }

        public Builder virtualOperationCardProduct(Boolean virtualOperationCardProduct) {
            this.virtualOperationCardProduct = virtualOperationCardProduct;
            return this;
        }

        public Builder banProlongCardProduct(Boolean banProlongCardProduct) {
            this.banProlongCardProduct = banProlongCardProduct;
            return this;
        }

        public Builder banReemisionCardProduct(Boolean banReemisionCardProduct) {
            this.banReemisionCardProduct = banReemisionCardProduct;
            return this;
        }

        public Builder additionalCardProduct(Boolean additionalCardProduct) {
            this.additionalCardProduct = additionalCardProduct;
            return this;
        }

        public Builder cashbackCardProduct(Boolean cashbackCardProduct) {
            this.cashbackCardProduct = cashbackCardProduct;
            return this;
        }

        public Builder dispatchPinCardProduct(Boolean dispatchPinCardProduct) {
            this.dispatchPinCardProduct = dispatchPinCardProduct;
            return this;
        }

        public Builder analysisNonCashTurnoverCardProduct(Boolean analysisNonCashTurnoverCardProduct) {
            this.analysisNonCashTurnoverCardProduct = analysisNonCashTurnoverCardProduct;
            return this;
        }

        public Builder megatransactorCardProduct(Boolean megatransactorCardProduct) {
            this.megatransactorCardProduct = megatransactorCardProduct;
            return this;
        }

        public Builder banGiveMoneyCardProduct(Boolean banGiveMoneyCardProduct) {
            this.banGiveMoneyCardProduct = banGiveMoneyCardProduct;
            return this;
        }

        public Builder doNotIncludeDocumentsCardProduct(Boolean doNotIncludeDocumentsCardProduct) {
            this.doNotIncludeDocumentsCardProduct = doNotIncludeDocumentsCardProduct;
            return this;
        }

        public Builder notChangeCardAtTheCardPackageInIBCardProduct(Boolean notChangeCardAtTheCardPackageInIBCardProduct) {
            this.notChangeCardAtTheCardPackageInIBCardProduct = notChangeCardAtTheCardPackageInIBCardProduct;
            return this;
        }

        public Builder manyFunctionalCardsCardProduct(Boolean manyFunctionalCardsCardProduct) {
            this.manyFunctionalCardsCardProduct = manyFunctionalCardsCardProduct;
            return this;
        }

        public Builder customDesignCardProduct(Boolean customDesignCardProduct) {
            this.customDesignCardProduct = customDesignCardProduct;
            return this;
        }

        public Builder customDeliveryCardProduct(Boolean customDeliveryCardProduct) {
            this.customDeliveryCardProduct = customDeliveryCardProduct;
            return this;
        }

        public Builder cancelCompareVspomCardProduct(Boolean cancelCompareVspomCardProduct) {
            this.cancelCompareVspomCardProduct = cancelCompareVspomCardProduct;
            return this;
        }

        public Builder saveCardNameVspomCardProduct(Boolean saveCardNameVspomCardProduct) {
            this.saveCardNameVspomCardProduct = saveCardNameVspomCardProduct;
            return this;
        }

        public Builder banOperationInternetCardProduct(Boolean banOperationInternetCardProduct) {
            this.banOperationInternetCardProduct = banOperationInternetCardProduct;
            return this;
        }

        public Builder freeVeiwBalanceCardProduct(Boolean freeVeiwBalanceCardProduct) {
            this.freeVeiwBalanceCardProduct = freeVeiwBalanceCardProduct;
            return this;
        }

        public Builder allowComissionCardProduct(Boolean allowComissionCardProduct) {
            this.allowComissionCardProduct = allowComissionCardProduct;
            return this;
        }

        public Builder designIdEmvCardProduct(String designIdEmvCardProduct) {
            this.designIdEmvCardProduct = designIdEmvCardProduct;
            return this;
        }

        public Builder applIdEmvCardProduct(String applIdEmvCardProduct) {
            this.applIdEmvCardProduct = applIdEmvCardProduct;
            return this;
        }

        public Builder virtualCardProduct(Boolean virtualCardProduct) {
            this.virtualCardProduct = virtualCardProduct;
            return this;
        }

        public Builder avtomaticEmissionCardProduct(Boolean avtomaticEmissionCardProduct) {
            this.avtomaticEmissionCardProduct = avtomaticEmissionCardProduct;
            return this;
        }

        public Builder dboCardProduct(Boolean dboCardProduct) {
            this.dboCardProduct = dboCardProduct;
            return this;
        }

        public Builder minCountCardProduct(BigDecimal minCountCardProduct) {
            this.minCountCardProduct = minCountCardProduct;
            return this;
        }

        public Builder countForGenerationCardProduct(BigDecimal countForGenerationCardProduct) {
            this.countForGenerationCardProduct = countForGenerationCardProduct;
            return this;
        }

        public Builder allowSetLimitCardProduct(Boolean allowSetLimitCardProduct) {
            this.allowSetLimitCardProduct = allowSetLimitCardProduct;
            return this;
        }

        public Builder sumSetLimitBrisCardProduct(BigDecimal sumSetLimitBrisCardProduct) {
            this.sumSetLimitBrisCardProduct = sumSetLimitBrisCardProduct;
            return this;
        }

        public Builder sumSetLimitIbCardProduct(BigDecimal sumSetLimitIbCardProduct) {
            this.sumSetLimitIbCardProduct = sumSetLimitIbCardProduct;
            return this;
        }

        public Builder editCardNameCardProduct(Boolean editCardNameCardProduct) {
            this.editCardNameCardProduct = editCardNameCardProduct;
            return this;
        }

        public Builder lenCardNameCardProduct(BigDecimal lenCardNameCardProduct) {
            this.lenCardNameCardProduct = lenCardNameCardProduct;
            return this;
        }

        public Builder allowProlongIbCardProduct(Boolean allowProlongIbCardProduct) {
            this.allowProlongIbCardProduct = allowProlongIbCardProduct;
            return this;
        }

        public Builder allowReemissionCardProduct(Boolean allowReemissionCardProduct) {
            this.allowReemissionCardProduct = allowReemissionCardProduct;
            return this;
        }

        public Builder mediaView1934CardProduct(String mediaView1934CardProduct) {
            this.mediaView1934CardProduct = mediaView1934CardProduct;
            return this;
        }

        public Builder cardView1934CardProduct(String cardView1934CardProduct) {
            this.cardView1934CardProduct = cardView1934CardProduct;
            return this;
        }

        public Builder socialPurpose1934CardProduct(String socialPurpose1934CardProduct) {
            this.socialPurpose1934CardProduct = socialPurpose1934CardProduct;
            return this;
        }

        public Builder dopServicesCardProduct(String dopServicesCardProduct) {
            this.dopServicesCardProduct = dopServicesCardProduct;
            return this;
        }

        public Builder kobrendovayaCardProduct(Boolean kobrendovayaCardProduct) {
            this.kobrendovayaCardProduct = kobrendovayaCardProduct;
            return this;
        }

        public Builder contactlessCardProduct(Boolean contactlessCardProduct) {
            this.contactlessCardProduct = contactlessCardProduct;
            return this;
        }

        public Builder optionsCardProduct(Options[] optionsCardProduct) {
            this.optionsCardProduct = optionsCardProduct;
            return this;
        }

        public Builder avtomaticReplaceRateCardProduct(Boolean avtomaticReplaceRateCardProduct) {
            this.avtomaticReplaceRateCardProduct = avtomaticReplaceRateCardProduct;
            return this;
        }

        public Builder rateValueCardProduct(BigDecimal rateValueCardProduct) {
            this.rateValueCardProduct = rateValueCardProduct;
            return this;
        }

        public Builder transferDepositRateCardProduct(Boolean transferDepositRateCardProduct) {
            this.transferDepositRateCardProduct = transferDepositRateCardProduct;
            return this;
        }

        public Builder disableAdditionalPaymentsCardProduct(Boolean disableAdditionalPaymentsCardProduct) {
            this.disableAdditionalPaymentsCardProduct = disableAdditionalPaymentsCardProduct;
            return this;
        }

        public Builder noActiveDepositCardProduct(Boolean noActiveDepositCardProduct) {
            this.noActiveDepositCardProduct = noActiveDepositCardProduct;
            return this;
        }

        public Builder depositOrCreditCardProduct(DepositOrCreditProducts[] depositOrCreditCardProduct) {
            this.depositOrCreditCardProduct = depositOrCreditCardProduct;
            return this;
        }

        public Builder transferCreditRateWhenProlongCardProduct(Boolean transferCreditRateWhenProlongCardProduct) {
            this.transferCreditRateWhenProlongCardProduct = transferCreditRateWhenProlongCardProduct;
            return this;
        }

        public Builder transferCreditRateWhenLimitChangedCardProduct(Boolean transferCreditRateWhenLimitChangedCardProduct) {
            this.transferCreditRateWhenLimitChangedCardProduct = transferCreditRateWhenLimitChangedCardProduct;
            return this;
        }

        public Builder transferCreditRateWhenReplaceCardProduct(Boolean transferCreditRateWhenReplaceCardProduct) {
            this.transferCreditRateWhenReplaceCardProduct = transferCreditRateWhenReplaceCardProduct;
            return this;
        }

        public Builder dopProductForCardProduct(DopProducts[] dopProductForCardProduct) {
            this.dopProductForCardProduct = dopProductForCardProduct;
            return this;
        }

        public Builder currencyProductForCardProduct(CurrencyProducts[] currencyProductForCardProduct) {
            this.currencyProductForCardProduct = currencyProductForCardProduct;
            return this;
        }

        public Builder fineCardProduct(Fine[] fineCardProduct) {
            this.fineCardProduct = fineCardProduct;
            return this;
        }

        public Builder replaceProductForProlongCardProduct(ReplaceProductsForProlong[] replaceProductForProlongCardProduct) {
            this.replaceProductForProlongCardProduct = replaceProductForProlongCardProduct;
            return this;
        }

        public Builder replaceProductForReemisionCardProduct(ReplaceProductsForReemision[] replaceProductForReemisionCardProduct) {
            this.replaceProductForReemisionCardProduct = replaceProductForReemisionCardProduct;
            return this;
        }

        public Builder handReplaceProductCardProduct(HandReplaceProduct[] handReplaceProductCardProduct) {
            this.handReplaceProductCardProduct = handReplaceProductCardProduct;
            return this;
        }

        public Builder minSumNonCashTurnoverCardProduct(BigDecimal minSumNonCashTurnoverCardProduct) {
            this.minSumNonCashTurnoverCardProduct = minSumNonCashTurnoverCardProduct;
            return this;
        }

        public Builder cardServiceDiscountCardProduct(BigDecimal cardServiceDiscountCardProduct) {
            this.cardServiceDiscountCardProduct = cardServiceDiscountCardProduct;
            return this;
        }

        public Builder isFreeCardProduct(Boolean isFreeCardProduct) {
            this.isFreeCardProduct = isFreeCardProduct;
            return this;
        }

        public Builder smsTariffCardProduct(SmsTariff[] smsTariffCardProduct) {
            this.smsTariffCardProduct = smsTariffCardProduct;
            return this;
        }

        public Builder uvkvCardProduct(Uvkv[] uvkvCardProduct) {
            this.uvkvCardProduct = uvkvCardProduct;
            return this;
        }

        public Builder groupRiskCardProduct(GroupRisk[] groupRiskCardProduct) {
            this.groupRiskCardProduct = groupRiskCardProduct;
            return this;
        }

        public Builder megatransactorOptionsCardProduct(MegatransactorOptions[] megatransactorOptionsCardProduct) {
            this.megatransactorOptionsCardProduct = megatransactorOptionsCardProduct;
            return this;
        }

        public Builder enterpriseCardProduct(Enterprise[] enterpriseCardProduct) {
            this.enterpriseCardProduct = enterpriseCardProduct;
            return this;
        }

        public CardProductEdit build() {
            CardProductEdit cardProductEdit = new CardProductEdit();
            cardProductEdit.setUserCode(userCode);
            cardProductEdit.setCardProductId(cardProductId);
            cardProductEdit.setNameCardProduct(nameCardProduct);
            cardProductEdit.setExpireCardProduct(expireCardProduct);
            cardProductEdit.setBinCardProduct(binCardProduct);
            cardProductEdit.setCodeCardTypeCardProduct(codeCardTypeCardProduct);
            cardProductEdit.setNameLangCardProduct(nameLangCardProduct);
            cardProductEdit.setCardNameCardProduct(cardNameCardProduct);
            cardProductEdit.setUrlCardProduct(urlCardProduct);
            cardProductEdit.setIsicCardProduct(isicCardProduct);
            cardProductEdit.setOnlineOrderCardProduct(onlineOrderCardProduct);
            cardProductEdit.setComissionCardProduct(comissionCardProduct);
            cardProductEdit.setMainCardProduct(mainCardProduct);
            cardProductEdit.setVirtualOperationCardProduct(virtualOperationCardProduct);
            cardProductEdit.setBanProlongCardProduct(banProlongCardProduct);
            cardProductEdit.setBanReemisionCardProduct(banReemisionCardProduct);
            cardProductEdit.setAdditionalCardProduct(additionalCardProduct);
            cardProductEdit.setCashbackCardProduct(cashbackCardProduct);
            cardProductEdit.setDispatchPinCardProduct(dispatchPinCardProduct);
            cardProductEdit.setAnalysisNonCashTurnoverCardProduct(analysisNonCashTurnoverCardProduct);
            cardProductEdit.setMegatransactorCardProduct(megatransactorCardProduct);
            cardProductEdit.setBanGiveMoneyCardProduct(banGiveMoneyCardProduct);
            cardProductEdit.setDoNotIncludeDocumentsCardProduct(doNotIncludeDocumentsCardProduct);
            cardProductEdit.setNotChangeCardAtTheCardPackageInIBCardProduct(notChangeCardAtTheCardPackageInIBCardProduct);
            cardProductEdit.setManyFunctionalCardsCardProduct(manyFunctionalCardsCardProduct);
            cardProductEdit.setCustomDesignCardProduct(customDesignCardProduct);
            cardProductEdit.setCustomDeliveryCardProduct(customDeliveryCardProduct);
            cardProductEdit.setCancelCompareVspomCardProduct(cancelCompareVspomCardProduct);
            cardProductEdit.setSaveCardNameVspomCardProduct(saveCardNameVspomCardProduct);
            cardProductEdit.setBanOperationInternetCardProduct(banOperationInternetCardProduct);
            cardProductEdit.setFreeVeiwBalanceCardProduct(freeVeiwBalanceCardProduct);
            cardProductEdit.setAllowComissionCardProduct(allowComissionCardProduct);
            cardProductEdit.setDesignIdEmvCardProduct(designIdEmvCardProduct);
            cardProductEdit.setApplIdEmvCardProduct(applIdEmvCardProduct);
            cardProductEdit.setVirtualCardProduct(virtualCardProduct);
            cardProductEdit.setAvtomaticEmissionCardProduct(avtomaticEmissionCardProduct);
            cardProductEdit.setDboCardProduct(dboCardProduct);
            cardProductEdit.setMinCountCardProduct(minCountCardProduct);
            cardProductEdit.setCountForGenerationCardProduct(countForGenerationCardProduct);
            cardProductEdit.setAllowSetLimitCardProduct(allowSetLimitCardProduct);
            cardProductEdit.setSumSetLimitBrisCardProduct(sumSetLimitBrisCardProduct);
            cardProductEdit.setSumSetLimitIbCardProduct(sumSetLimitIbCardProduct);
            cardProductEdit.setEditCardNameCardProduct(editCardNameCardProduct);
            cardProductEdit.setLenCardNameCardProduct(lenCardNameCardProduct);
            cardProductEdit.setAllowProlongIbCardProduct(allowProlongIbCardProduct);
            cardProductEdit.setAllowReemissionCardProduct(allowReemissionCardProduct);
            cardProductEdit.setMediaView1934CardProduct(mediaView1934CardProduct);
            cardProductEdit.setCardView1934CardProduct(cardView1934CardProduct);
            cardProductEdit.setSocialPurpose1934CardProduct(socialPurpose1934CardProduct);
            cardProductEdit.setDopServicesCardProduct(dopServicesCardProduct);
            cardProductEdit.setKobrendovayaCardProduct(kobrendovayaCardProduct);
            cardProductEdit.setContactlessCardProduct(contactlessCardProduct);
            cardProductEdit.setOptionsCardProduct(optionsCardProduct);
            cardProductEdit.setAvtomaticReplaceRateCardProduct(avtomaticReplaceRateCardProduct);
            cardProductEdit.setRateValueCardProduct(rateValueCardProduct);
            cardProductEdit.setTransferDepositRateCardProduct(transferDepositRateCardProduct);
            cardProductEdit.setDisableAdditionalPaymentsCardProduct(disableAdditionalPaymentsCardProduct);
            cardProductEdit.setNoActiveDepositCardProduct(noActiveDepositCardProduct);
            cardProductEdit.setDepositOrCreditCardProduct(depositOrCreditCardProduct);
            cardProductEdit.setTransferCreditRateWhenProlongCardProduct(transferCreditRateWhenProlongCardProduct);
            cardProductEdit.setTransferCreditRateWhenLimitChangedCardProduct(transferCreditRateWhenLimitChangedCardProduct);
            cardProductEdit.setTransferCreditRateWhenReplaceCardProduct(transferCreditRateWhenReplaceCardProduct);
            cardProductEdit.setDopProductForCardProduct(dopProductForCardProduct);
            cardProductEdit.setCurrencyProductForCardProduct(currencyProductForCardProduct);
            cardProductEdit.setFineCardProduct(fineCardProduct);
            cardProductEdit.setReplaceProductForProlongCardProduct(replaceProductForProlongCardProduct);
            cardProductEdit.setReplaceProductForReemisionCardProduct(replaceProductForReemisionCardProduct);
            cardProductEdit.setHandReplaceProductCardProduct(handReplaceProductCardProduct);
            cardProductEdit.setMinSumNonCashTurnoverCardProduct(minSumNonCashTurnoverCardProduct);
            cardProductEdit.setCardServiceDiscountCardProduct(cardServiceDiscountCardProduct);
            cardProductEdit.setSmsTariffCardProduct(smsTariffCardProduct);
            cardProductEdit.setUvkvCardProduct(uvkvCardProduct);
            cardProductEdit.setGroupRiskCardProduct(groupRiskCardProduct);
            cardProductEdit.setMegatransactorOptionsCardProduct(megatransactorOptionsCardProduct);
            cardProductEdit.setEnterpriseCardProduct(enterpriseCardProduct);
            cardProductEdit.isFreeCardProduct = this.isFreeCardProduct;
            return cardProductEdit;
        }

    }

}
