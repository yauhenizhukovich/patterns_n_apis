package by.belinvest.panel.admin.product.service.model;

import java.math.BigDecimal;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditProductAddRequest {

    private String userCode;
    private String creditProductId;
    private String kodProd;
    private String nameProd;
    private String kodProdBank;
    private String account;
    private String accountDop;
    private String typeGive;
    private String percentStavka;
    private String prodParent;
    private String ifObyaz;
    private String orgPOS;
    private String typeGarant;
    private String typeLessDep;
    private String typeRefLessDeb;
    private String typeOvernLessDeb;
    private String docKD;
    private String docGarant;
    private String docGarantCol;
    private String docZalog;
    private String docZalogCol;
    private Boolean isOnline;
    private Boolean IB;
    private Boolean POS;
    private Boolean IsInstallment;
    private Boolean IsOver;
    private Boolean Discount;
    private Boolean avtoResh;
    private Boolean edGroupAccount;
    private Boolean anGrafik;
    private Boolean payDateFinish;
    private Boolean stRefLess;
    private Boolean IsObespNeust;
    private Boolean testRule;
    private Boolean testKBB;
    private Boolean testISS;
    private Boolean testList;
    private Boolean safety;
    private Boolean safetyDop;
    private Boolean ver;
    private Boolean verDop;
    private Boolean rickM;
    private Boolean rickMgDop;
    private BigDecimal choiceGroup;
    private BigDecimal limitGive;
    private BigDecimal maxSum;
    private BigDecimal razCommission;
    private BigDecimal commissionNac;
    private BigDecimal commissionIN;
    private BigDecimal kofPlat;
    private BigDecimal datePay;
    private BigDecimal Turn;
    private BigDecimal kofProsroch;
    private BigDecimal penProsroch;
    private BigDecimal Neust;
    private BigDecimal ProlongPeriod;
    private BigDecimal ProlongSt;
    private BigDecimal GracePeriod;
    private BigDecimal GraceSt;
    private BigDecimal GracePeriodDeb;
    private BigDecimal GraceStDeb;
    private BigDecimal GracePeriodLess;
    private BigDecimal GraceStLess;
    private String[] goalKP;
    private String[] currency;
    private String[] formKP;
    private String[] realEstate;
    private String[] typeGarantOb;
    private String[] typeZalog;
    private String[] typeZalogOb;
    private String[] GraseTypeOper;
    private BigDecimal[] termGive;
    private BigDecimal[] termPay;
    private BigDecimal[] termDevelop;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCreditProductId() {
        return creditProductId;
    }

    public void setCreditProductId(String creditProductId) {
        this.creditProductId = creditProductId;
    }

    public String getKodProd() {
        return kodProd;
    }

    public void setKodProd(String kodProd) {
        this.kodProd = kodProd;
    }

    public String getNameProd() {
        return nameProd;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }

    public String getKodProdBank() {
        return kodProdBank;
    }

    public void setKodProdBank(String kodProdBank) {
        this.kodProdBank = kodProdBank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountDop() {
        return accountDop;
    }

    public void setAccountDop(String accountDop) {
        this.accountDop = accountDop;
    }

    public String getTypeGive() {
        return typeGive;
    }

    public void setTypeGive(String typeGive) {
        this.typeGive = typeGive;
    }

    public String getPercentStavka() {
        return percentStavka;
    }

    public void setPercentStavka(String percentStavka) {
        this.percentStavka = percentStavka;
    }

    public String getProdParent() {
        return prodParent;
    }

    public void setProdParent(String prodParent) {
        this.prodParent = prodParent;
    }

    public String getIfObyaz() {
        return ifObyaz;
    }

    public void setIfObyaz(String ifObyaz) {
        this.ifObyaz = ifObyaz;
    }

    public String getOrgPOS() {
        return orgPOS;
    }

    public void setOrgPOS(String orgPOS) {
        this.orgPOS = orgPOS;
    }

    public String getTypeGarant() {
        return typeGarant;
    }

    public void setTypeGarant(String typeGarant) {
        this.typeGarant = typeGarant;
    }

    public String getTypeLessDep() {
        return typeLessDep;
    }

    public void setTypeLessDep(String typeLessDep) {
        this.typeLessDep = typeLessDep;
    }

    public String getTypeRefLessDeb() {
        return typeRefLessDeb;
    }

    public void setTypeRefLessDeb(String typeRefLessDeb) {
        this.typeRefLessDeb = typeRefLessDeb;
    }

    public String getTypeOvernLessDeb() {
        return typeOvernLessDeb;
    }

    public void setTypeOvernLessDeb(String typeOvernLessDeb) {
        this.typeOvernLessDeb = typeOvernLessDeb;
    }

    public String getDocKD() {
        return docKD;
    }

    public void setDocKD(String docKD) {
        this.docKD = docKD;
    }

    public String getDocGarant() {
        return docGarant;
    }

    public void setDocGarant(String docGarant) {
        this.docGarant = docGarant;
    }

    public String getDocGarantCol() {
        return docGarantCol;
    }

    public void setDocGarantCol(String docGarantCol) {
        this.docGarantCol = docGarantCol;
    }

    public String getDocZalog() {
        return docZalog;
    }

    public void setDocZalog(String docZalog) {
        this.docZalog = docZalog;
    }

    public String getDocZalogCol() {
        return docZalogCol;
    }

    public void setDocZalogCol(String docZalogCol) {
        this.docZalogCol = docZalogCol;
    }

    @JsonProperty("isOnline")
    public Boolean getOnline() {
        return isOnline;
    }

    @JsonProperty("isOnline")
    public void setOnline(Boolean online) {
        isOnline = online;
    }

    @JsonProperty("IB")
    public Boolean getIB() {
        return IB;
    }

    @JsonProperty("IB")
    public void setIB(Boolean IB) {
        this.IB = IB;
    }

    @JsonProperty("POS")
    public Boolean getPOS() {
        return POS;
    }

    @JsonProperty("POS")
    public void setPOS(Boolean POS) {
        this.POS = POS;
    }

    @JsonProperty("IsInstallment")
    public Boolean getInstallment() {
        return IsInstallment;
    }

    @JsonProperty("IsInstallment")
    public void setInstallment(Boolean installment) {
        IsInstallment = installment;
    }

    @JsonProperty("IsOver")
    public Boolean getOver() {
        return IsOver;
    }

    @JsonProperty("IsOver")
    public void setOver(Boolean over) {
        IsOver = over;
    }

    @JsonProperty("Discount")
    public Boolean getDiscount() {
        return Discount;
    }

    @JsonProperty("Discount")
    public void setDiscount(Boolean discount) {
        Discount = discount;
    }

    public Boolean getAvtoResh() {
        return avtoResh;
    }

    public void setAvtoResh(Boolean avtoResh) {
        this.avtoResh = avtoResh;
    }

    public Boolean getEdGroupAccount() {
        return edGroupAccount;
    }

    public void setEdGroupAccount(Boolean edGroupAccount) {
        this.edGroupAccount = edGroupAccount;
    }

    public Boolean getAnGrafik() {
        return anGrafik;
    }

    public void setAnGrafik(Boolean anGrafik) {
        this.anGrafik = anGrafik;
    }

    public Boolean getPayDateFinish() {
        return payDateFinish;
    }

    public void setPayDateFinish(Boolean payDateFinish) {
        this.payDateFinish = payDateFinish;
    }

    public Boolean getStRefLess() {
        return stRefLess;
    }

    public void setStRefLess(Boolean stRefLess) {
        this.stRefLess = stRefLess;
    }

    @JsonProperty("IsObespNeust")
    public Boolean getObespNeust() {
        return IsObespNeust;
    }

    @JsonProperty("IsObespNeust")
    public void setObespNeust(Boolean obespNeust) {
        IsObespNeust = obespNeust;
    }

    public Boolean getTestRule() {
        return testRule;
    }

    public void setTestRule(Boolean testRule) {
        this.testRule = testRule;
    }

    public Boolean getTestKBB() {
        return testKBB;
    }

    public void setTestKBB(Boolean testKBB) {
        this.testKBB = testKBB;
    }

    public Boolean getTestISS() {
        return testISS;
    }

    public void setTestISS(Boolean testISS) {
        this.testISS = testISS;
    }

    public Boolean getTestList() {
        return testList;
    }

    public void setTestList(Boolean testList) {
        this.testList = testList;
    }

    public Boolean getSafety() {
        return safety;
    }

    public void setSafety(Boolean safety) {
        this.safety = safety;
    }

    public Boolean getSafetyDop() {
        return safetyDop;
    }

    public void setSafetyDop(Boolean safetyDop) {
        this.safetyDop = safetyDop;
    }

    public Boolean getVer() {
        return ver;
    }

    public void setVer(Boolean ver) {
        this.ver = ver;
    }

    public Boolean getVerDop() {
        return verDop;
    }

    public void setVerDop(Boolean verDop) {
        this.verDop = verDop;
    }

    public Boolean getRickM() {
        return rickM;
    }

    public void setRickM(Boolean rickM) {
        this.rickM = rickM;
    }

    public Boolean getRickMgDop() {
        return rickMgDop;
    }

    public void setRickMgDop(Boolean rickMgDop) {
        this.rickMgDop = rickMgDop;
    }

    public BigDecimal getChoiceGroup() {
        return choiceGroup;
    }

    public void setChoiceGroup(BigDecimal choiceGroup) {
        this.choiceGroup = choiceGroup;
    }

    public BigDecimal getLimitGive() {
        return limitGive;
    }

    public void setLimitGive(BigDecimal limitGive) {
        this.limitGive = limitGive;
    }

    public BigDecimal getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(BigDecimal maxSum) {
        this.maxSum = maxSum;
    }

    public BigDecimal getRazCommission() {
        return razCommission;
    }

    public void setRazCommission(BigDecimal razCommission) {
        this.razCommission = razCommission;
    }

    public BigDecimal getCommissionNac() {
        return commissionNac;
    }

    public void setCommissionNac(BigDecimal commissionNac) {
        this.commissionNac = commissionNac;
    }

    public BigDecimal getCommissionIN() {
        return commissionIN;
    }

    public void setCommissionIN(BigDecimal commissionIN) {
        this.commissionIN = commissionIN;
    }

    public BigDecimal getKofPlat() {
        return kofPlat;
    }

    public void setKofPlat(BigDecimal kofPlat) {
        this.kofPlat = kofPlat;
    }

    public BigDecimal getDatePay() {
        return datePay;
    }

    public void setDatePay(BigDecimal datePay) {
        this.datePay = datePay;
    }

    @JsonProperty("Turn")
    public BigDecimal getTurn() {
        return Turn;
    }

    @JsonProperty("Turn")
    public void setTurn(BigDecimal turn) {
        Turn = turn;
    }

    public BigDecimal getKofProsroch() {
        return kofProsroch;
    }

    public void setKofProsroch(BigDecimal kofProsroch) {
        this.kofProsroch = kofProsroch;
    }

    public BigDecimal getPenProsroch() {
        return penProsroch;
    }

    public void setPenProsroch(BigDecimal penProsroch) {
        this.penProsroch = penProsroch;
    }

    @JsonProperty("Neust")
    public BigDecimal getNeust() {
        return Neust;
    }

    @JsonProperty("Neust")
    public void setNeust(BigDecimal neust) {
        Neust = neust;
    }

    @JsonProperty("ProlongPeriod")
    public BigDecimal getProlongPeriod() {
        return ProlongPeriod;
    }

    @JsonProperty("ProlongPeriod")
    public void setProlongPeriod(BigDecimal prolongPeriod) {
        ProlongPeriod = prolongPeriod;
    }

    @JsonProperty("ProlongSt")
    public BigDecimal getProlongSt() {
        return ProlongSt;
    }

    @JsonProperty("ProlongSt")
    public void setProlongSt(BigDecimal prolongSt) {
        ProlongSt = prolongSt;
    }

    @JsonProperty("GracePeriod")
    public BigDecimal getGracePeriod() {
        return GracePeriod;
    }

    @JsonProperty("GracePeriod")
    public void setGracePeriod(BigDecimal gracePeriod) {
        GracePeriod = gracePeriod;
    }

    @JsonProperty("GraceSt")
    public BigDecimal getGraceSt() {
        return GraceSt;
    }

    @JsonProperty("GraceSt")
    public void setGraceSt(BigDecimal graceSt) {
        GraceSt = graceSt;
    }

    @JsonProperty("GracePeriodDeb")
    public BigDecimal getGracePeriodDeb() {
        return GracePeriodDeb;
    }

    @JsonProperty("GracePeriodDeb")
    public void setGracePeriodDeb(BigDecimal gracePeriodDeb) {
        GracePeriodDeb = gracePeriodDeb;
    }

    @JsonProperty("GraceStDeb")
    public BigDecimal getGraceStDeb() {
        return GraceStDeb;
    }

    @JsonProperty("GraceStDeb")
    public void setGraceStDeb(BigDecimal graceStDeb) {
        GraceStDeb = graceStDeb;
    }

    @JsonProperty("GracePeriodLess")
    public BigDecimal getGracePeriodLess() {
        return GracePeriodLess;
    }

    @JsonProperty("GracePeriodLess")
    public void setGracePeriodLess(BigDecimal gracePeriodLess) {
        GracePeriodLess = gracePeriodLess;
    }

    @JsonProperty("GraceStLess")
    public BigDecimal getGraceStLess() {
        return GraceStLess;
    }

    @JsonProperty("GraceStLess")
    public void setGraceStLess(BigDecimal graceStLess) {
        GraceStLess = graceStLess;
    }

    public String[] getGoalKP() {
        return goalKP;
    }

    public void setGoalKP(String[] goalKP) {
        this.goalKP = goalKP;
    }

    public String[] getCurrency() {
        return currency;
    }

    public void setCurrency(String[] currency) {
        this.currency = currency;
    }

    public String[] getFormKP() {
        return formKP;
    }

    public void setFormKP(String[] formKP) {
        this.formKP = formKP;
    }

    public String[] getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(String[] realEstate) {
        this.realEstate = realEstate;
    }

    public String[] getTypeGarantOb() {
        return typeGarantOb;
    }

    public void setTypeGarantOb(String[] typeGarantOb) {
        this.typeGarantOb = typeGarantOb;
    }

    public String[] getTypeZalog() {
        return typeZalog;
    }

    public void setTypeZalog(String[] typeZalog) {
        this.typeZalog = typeZalog;
    }

    public String[] getTypeZalogOb() {
        return typeZalogOb;
    }

    public void setTypeZalogOb(String[] typeZalogOb) {
        this.typeZalogOb = typeZalogOb;
    }

    @JsonProperty("GraseTypeOper")
    public String[] getGraseTypeOper() {
        return GraseTypeOper;
    }

    @JsonProperty("GraseTypeOper")
    public void setGraseTypeOper(String[] graseTypeOper) {
        GraseTypeOper = graseTypeOper;
    }

    public BigDecimal[] getTermGive() {
        return termGive;
    }

    public void setTermGive(BigDecimal[] termGive) {
        this.termGive = termGive;
    }

    public BigDecimal[] getTermPay() {
        return termPay;
    }

    public void setTermPay(BigDecimal[] termPay) {
        this.termPay = termPay;
    }

    public BigDecimal[] getTermDevelop() {
        return termDevelop;
    }

    public void setTermDevelop(BigDecimal[] termDevelop) {
        this.termDevelop = termDevelop;
    }

    @Override
    public String toString() {
        return "CreditProductAddRequest{" +
                "userCode='" + userCode + '\'' +
                ", creditProductId='" + creditProductId + '\'' +
                ", kodProd='" + kodProd + '\'' +
                ", nameProd='" + nameProd + '\'' +
                ", kodProdBank='" + kodProdBank + '\'' +
                ", account='" + account + '\'' +
                ", accountDop='" + accountDop + '\'' +
                ", typeGive='" + typeGive + '\'' +
                ", percentStavka='" + percentStavka + '\'' +
                ", prodParent='" + prodParent + '\'' +
                ", ifObyaz='" + ifObyaz + '\'' +
                ", orgPOS='" + orgPOS + '\'' +
                ", typeGarant='" + typeGarant + '\'' +
                ", typeLessDep='" + typeLessDep + '\'' +
                ", typeRefLessDeb='" + typeRefLessDeb + '\'' +
                ", typeOvernLessDeb='" + typeOvernLessDeb + '\'' +
                ", docKD='" + docKD + '\'' +
                ", docGarant='" + docGarant + '\'' +
                ", docGarantCol='" + docGarantCol + '\'' +
                ", docZalog='" + docZalog + '\'' +
                ", docZalogCol='" + docZalogCol + '\'' +
                ", isOnline=" + isOnline +
                ", IB=" + IB +
                ", POS=" + POS +
                ", IsInstallment=" + IsInstallment +
                ", IsOver=" + IsOver +
                ", Discount=" + Discount +
                ", avtoResh=" + avtoResh +
                ", edGroupAccount=" + edGroupAccount +
                ", anGrafik=" + anGrafik +
                ", payDateFinish=" + payDateFinish +
                ", stRefLess=" + stRefLess +
                ", IsObespNeust=" + IsObespNeust +
                ", testRule=" + testRule +
                ", testKBB=" + testKBB +
                ", testISS=" + testISS +
                ", testList=" + testList +
                ", safety=" + safety +
                ", safetyDop=" + safetyDop +
                ", ver=" + ver +
                ", verDop=" + verDop +
                ", rickM=" + rickM +
                ", rickMgDop=" + rickMgDop +
                ", choiceGroup=" + choiceGroup +
                ", limitGive=" + limitGive +
                ", maxSum=" + maxSum +
                ", razCommission=" + razCommission +
                ", commissionNac=" + commissionNac +
                ", commissionIN=" + commissionIN +
                ", kofPlat=" + kofPlat +
                ", datePay=" + datePay +
                ", Turn=" + Turn +
                ", kofProsroch=" + kofProsroch +
                ", penProsroch=" + penProsroch +
                ", Neust=" + Neust +
                ", ProlongPeriod=" + ProlongPeriod +
                ", ProlongSt=" + ProlongSt +
                ", GracePeriod=" + GracePeriod +
                ", GraceSt=" + GraceSt +
                ", GracePeriodDeb=" + GracePeriodDeb +
                ", GraceStDeb=" + GraceStDeb +
                ", GracePeriodLess=" + GracePeriodLess +
                ", GraceStLess=" + GraceStLess +
                ", goalKP=" + Arrays.toString(goalKP) +
                ", currency=" + Arrays.toString(currency) +
                ", formKP=" + Arrays.toString(formKP) +
                ", realEstate=" + Arrays.toString(realEstate) +
                ", typeGarantOb=" + Arrays.toString(typeGarantOb) +
                ", typeZalog=" + Arrays.toString(typeZalog) +
                ", typeZalogOb=" + Arrays.toString(typeZalogOb) +
                ", GraseTypeOper=" + Arrays.toString(GraseTypeOper) +
                ", termGive=" + Arrays.toString(termGive) +
                ", termPay=" + Arrays.toString(termPay) +
                ", termDevelop=" + Arrays.toString(termDevelop) +
                '}';
    }

    public static final class Builder {

        private String userCode;
        private String creditProductId;
        private String kodProd;
        private String nameProd;
        private String kodProdBank;
        private String account;
        private String accountDop;
        private String typeGive;
        private String percentStavka;
        private String prodParent;
        private String ifObyaz;
        private String orgPOS;
        private String typeGarant;
        private String typeLessDep;
        private String typeRefLessDeb;
        private String typeOvernLessDeb;
        private String docKD;
        private String docGarant;
        private String docGarantCol;
        private String docZalog;
        private String docZalogCol;
        private Boolean isOnline;
        private Boolean IB;
        private Boolean POS;
        private Boolean IsInstallment;
        private Boolean IsOver;
        private Boolean Discount;
        private Boolean avtoResh;
        private Boolean edGroupAccount;
        private Boolean anGrafik;
        private Boolean payDateFinish;
        private Boolean stRefLess;
        private Boolean IsObespNeust;
        private Boolean testRule;
        private Boolean testKBB;
        private Boolean testISS;
        private Boolean testList;
        private Boolean safety;
        private Boolean safetyDop;
        private Boolean ver;
        private Boolean verDop;
        private Boolean rickM;
        private Boolean rickMgDop;
        private BigDecimal choiceGroup;
        private BigDecimal limitGive;
        private BigDecimal maxSum;
        private BigDecimal razCommission;
        private BigDecimal commissionNac;
        private BigDecimal commissionIN;
        private BigDecimal kofPlat;
        private BigDecimal datePay;
        private BigDecimal Turn;
        private BigDecimal kofProsroch;
        private BigDecimal penProsroch;
        private BigDecimal Neust;
        private BigDecimal ProlongPeriod;
        private BigDecimal ProlongSt;
        private BigDecimal GracePeriod;
        private BigDecimal GraceSt;
        private BigDecimal GracePeriodDeb;
        private BigDecimal GraceStDeb;
        private BigDecimal GracePeriodLess;
        private BigDecimal GraceStLess;
        private String[] goalKP;
        private String[] currency;
        private String[] formKP;
        private String[] realEstate;
        private String[] typeGarantOb;
        private String[] typeZalog;
        private String[] typeZalogOb;
        private String[] GraseTypeOper;
        private BigDecimal[] termGive;
        private BigDecimal[] termPay;
        private BigDecimal[] termDevelop;

        private Builder() {}

        public static Builder aCreditProductAddRequest() { return new Builder(); }

        public Builder userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder creditProductId(String creditProductId) {
            this.creditProductId = creditProductId;
            return this;
        }

        public Builder kodProd(String kodProd) {
            this.kodProd = kodProd;
            return this;
        }

        public Builder nameProd(String nameProd) {
            this.nameProd = nameProd;
            return this;
        }

        public Builder kodProdBank(String kodProdBank) {
            this.kodProdBank = kodProdBank;
            return this;
        }

        public Builder account(String account) {
            this.account = account;
            return this;
        }

        public Builder accountDop(String accountDop) {
            this.accountDop = accountDop;
            return this;
        }

        public Builder typeGive(String typeGive) {
            this.typeGive = typeGive;
            return this;
        }

        public Builder percentStavka(String percentStavka) {
            this.percentStavka = percentStavka;
            return this;
        }

        public Builder prodParent(String prodParent) {
            this.prodParent = prodParent;
            return this;
        }

        public Builder ifObyaz(String ifObyaz) {
            this.ifObyaz = ifObyaz;
            return this;
        }

        public Builder orgPOS(String orgPOS) {
            this.orgPOS = orgPOS;
            return this;
        }

        public Builder typeGarant(String typeGarant) {
            this.typeGarant = typeGarant;
            return this;
        }

        public Builder typeLessDep(String typeLessDep) {
            this.typeLessDep = typeLessDep;
            return this;
        }

        public Builder typeRefLessDeb(String typeRefLessDeb) {
            this.typeRefLessDeb = typeRefLessDeb;
            return this;
        }

        public Builder typeOvernLessDeb(String typeOvernLessDeb) {
            this.typeOvernLessDeb = typeOvernLessDeb;
            return this;
        }

        public Builder docKD(String docKD) {
            this.docKD = docKD;
            return this;
        }

        public Builder docGarant(String docGarant) {
            this.docGarant = docGarant;
            return this;
        }

        public Builder docGarantCol(String docGarantCol) {
            this.docGarantCol = docGarantCol;
            return this;
        }

        public Builder docZalog(String docZalog) {
            this.docZalog = docZalog;
            return this;
        }

        public Builder docZalogCol(String docZalogCol) {
            this.docZalogCol = docZalogCol;
            return this;
        }

        public Builder isOnline(Boolean isOnline) {
            this.isOnline = isOnline;
            return this;
        }

        public Builder IB(Boolean IB) {
            this.IB = IB;
            return this;
        }

        public Builder POS(Boolean POS) {
            this.POS = POS;
            return this;
        }

        public Builder IsInstallment(Boolean IsInstallment) {
            this.IsInstallment = IsInstallment;
            return this;
        }

        public Builder IsOver(Boolean IsOver) {
            this.IsOver = IsOver;
            return this;
        }

        public Builder Discount(Boolean Discount) {
            this.Discount = Discount;
            return this;
        }

        public Builder avtoResh(Boolean avtoResh) {
            this.avtoResh = avtoResh;
            return this;
        }

        public Builder edGroupAccount(Boolean edGroupAccount) {
            this.edGroupAccount = edGroupAccount;
            return this;
        }

        public Builder anGrafik(Boolean anGrafik) {
            this.anGrafik = anGrafik;
            return this;
        }

        public Builder payDateFinish(Boolean payDateFinish) {
            this.payDateFinish = payDateFinish;
            return this;
        }

        public Builder stRefLess(Boolean stRefLess) {
            this.stRefLess = stRefLess;
            return this;
        }

        public Builder IsObespNeust(Boolean IsObespNeust) {
            this.IsObespNeust = IsObespNeust;
            return this;
        }

        public Builder testRule(Boolean testRule) {
            this.testRule = testRule;
            return this;
        }

        public Builder testKBB(Boolean testKBB) {
            this.testKBB = testKBB;
            return this;
        }

        public Builder testISS(Boolean testISS) {
            this.testISS = testISS;
            return this;
        }

        public Builder testList(Boolean testList) {
            this.testList = testList;
            return this;
        }

        public Builder safety(Boolean safety) {
            this.safety = safety;
            return this;
        }

        public Builder safetyDop(Boolean safetyDop) {
            this.safetyDop = safetyDop;
            return this;
        }

        public Builder ver(Boolean ver) {
            this.ver = ver;
            return this;
        }

        public Builder verDop(Boolean verDop) {
            this.verDop = verDop;
            return this;
        }

        public Builder rickM(Boolean rickM) {
            this.rickM = rickM;
            return this;
        }

        public Builder rickMgDop(Boolean rickMgDop) {
            this.rickMgDop = rickMgDop;
            return this;
        }

        public Builder choiceGroup(BigDecimal choiceGroup) {
            this.choiceGroup = choiceGroup;
            return this;
        }

        public Builder limitGive(BigDecimal limitGive) {
            this.limitGive = limitGive;
            return this;
        }

        public Builder maxSum(BigDecimal maxSum) {
            this.maxSum = maxSum;
            return this;
        }

        public Builder razCommission(BigDecimal razCommission) {
            this.razCommission = razCommission;
            return this;
        }

        public Builder commissionNac(BigDecimal commissionNac) {
            this.commissionNac = commissionNac;
            return this;
        }

        public Builder commissionIN(BigDecimal commissionIN) {
            this.commissionIN = commissionIN;
            return this;
        }

        public Builder kofPlat(BigDecimal kofPlat) {
            this.kofPlat = kofPlat;
            return this;
        }

        public Builder datePay(BigDecimal datePay) {
            this.datePay = datePay;
            return this;
        }

        public Builder Turn(BigDecimal Turn) {
            this.Turn = Turn;
            return this;
        }

        public Builder kofProsroch(BigDecimal kofProsroch) {
            this.kofProsroch = kofProsroch;
            return this;
        }

        public Builder penProsroch(BigDecimal penProsroch) {
            this.penProsroch = penProsroch;
            return this;
        }

        public Builder Neust(BigDecimal Neust) {
            this.Neust = Neust;
            return this;
        }

        public Builder ProlongPeriod(BigDecimal ProlongPeriod) {
            this.ProlongPeriod = ProlongPeriod;
            return this;
        }

        public Builder ProlongSt(BigDecimal ProlongSt) {
            this.ProlongSt = ProlongSt;
            return this;
        }

        public Builder GracePeriod(BigDecimal GracePeriod) {
            this.GracePeriod = GracePeriod;
            return this;
        }

        public Builder GraceSt(BigDecimal GraceSt) {
            this.GraceSt = GraceSt;
            return this;
        }

        public Builder GracePeriodDeb(BigDecimal GracePeriodDeb) {
            this.GracePeriodDeb = GracePeriodDeb;
            return this;
        }

        public Builder GraceStDeb(BigDecimal GraceStDeb) {
            this.GraceStDeb = GraceStDeb;
            return this;
        }

        public Builder GracePeriodLess(BigDecimal GracePeriodLess) {
            this.GracePeriodLess = GracePeriodLess;
            return this;
        }

        public Builder GraceStLess(BigDecimal GraceStLess) {
            this.GraceStLess = GraceStLess;
            return this;
        }

        public Builder goalKP(String[] goalKP) {
            this.goalKP = goalKP;
            return this;
        }

        public Builder currency(String[] currency) {
            this.currency = currency;
            return this;
        }

        public Builder formKP(String[] formKP) {
            this.formKP = formKP;
            return this;
        }

        public Builder realEstate(String[] realEstate) {
            this.realEstate = realEstate;
            return this;
        }

        public Builder typeGarantOb(String[] typeGarantOb) {
            this.typeGarantOb = typeGarantOb;
            return this;
        }

        public Builder typeZalog(String[] typeZalog) {
            this.typeZalog = typeZalog;
            return this;
        }

        public Builder typeZalogOb(String[] typeZalogOb) {
            this.typeZalogOb = typeZalogOb;
            return this;
        }

        public Builder GraseTypeOper(String[] GraseTypeOper) {
            this.GraseTypeOper = GraseTypeOper;
            return this;
        }

        public Builder termGive(BigDecimal[] termGive) {
            this.termGive = termGive;
            return this;
        }

        public Builder termPay(BigDecimal[] termPay) {
            this.termPay = termPay;
            return this;
        }

        public Builder termDevelop(BigDecimal[] termDevelop) {
            this.termDevelop = termDevelop;
            return this;
        }

        public CreditProductAddRequest build() {
            CreditProductAddRequest creditProductAddRequest = new CreditProductAddRequest();
            creditProductAddRequest.setUserCode(userCode);
            creditProductAddRequest.setCreditProductId(creditProductId);
            creditProductAddRequest.setKodProd(kodProd);
            creditProductAddRequest.setNameProd(nameProd);
            creditProductAddRequest.setKodProdBank(kodProdBank);
            creditProductAddRequest.setAccount(account);
            creditProductAddRequest.setAccountDop(accountDop);
            creditProductAddRequest.setTypeGive(typeGive);
            creditProductAddRequest.setPercentStavka(percentStavka);
            creditProductAddRequest.setProdParent(prodParent);
            creditProductAddRequest.setIfObyaz(ifObyaz);
            creditProductAddRequest.setOrgPOS(orgPOS);
            creditProductAddRequest.setTypeGarant(typeGarant);
            creditProductAddRequest.setTypeLessDep(typeLessDep);
            creditProductAddRequest.setTypeRefLessDeb(typeRefLessDeb);
            creditProductAddRequest.setTypeOvernLessDeb(typeOvernLessDeb);
            creditProductAddRequest.setDocKD(docKD);
            creditProductAddRequest.setDocGarant(docGarant);
            creditProductAddRequest.setDocGarantCol(docGarantCol);
            creditProductAddRequest.setDocZalog(docZalog);
            creditProductAddRequest.setDocZalogCol(docZalogCol);
            creditProductAddRequest.setIB(IB);
            creditProductAddRequest.setPOS(POS);
            creditProductAddRequest.setDiscount(Discount);
            creditProductAddRequest.setAvtoResh(avtoResh);
            creditProductAddRequest.setEdGroupAccount(edGroupAccount);
            creditProductAddRequest.setAnGrafik(anGrafik);
            creditProductAddRequest.setPayDateFinish(payDateFinish);
            creditProductAddRequest.setStRefLess(stRefLess);
            creditProductAddRequest.setTestRule(testRule);
            creditProductAddRequest.setTestKBB(testKBB);
            creditProductAddRequest.setTestISS(testISS);
            creditProductAddRequest.setTestList(testList);
            creditProductAddRequest.setSafety(safety);
            creditProductAddRequest.setSafetyDop(safetyDop);
            creditProductAddRequest.setVer(ver);
            creditProductAddRequest.setVerDop(verDop);
            creditProductAddRequest.setRickM(rickM);
            creditProductAddRequest.setRickMgDop(rickMgDop);
            creditProductAddRequest.setChoiceGroup(choiceGroup);
            creditProductAddRequest.setLimitGive(limitGive);
            creditProductAddRequest.setMaxSum(maxSum);
            creditProductAddRequest.setRazCommission(razCommission);
            creditProductAddRequest.setCommissionNac(commissionNac);
            creditProductAddRequest.setCommissionIN(commissionIN);
            creditProductAddRequest.setKofPlat(kofPlat);
            creditProductAddRequest.setDatePay(datePay);
            creditProductAddRequest.setTurn(Turn);
            creditProductAddRequest.setKofProsroch(kofProsroch);
            creditProductAddRequest.setPenProsroch(penProsroch);
            creditProductAddRequest.setNeust(Neust);
            creditProductAddRequest.setProlongPeriod(ProlongPeriod);
            creditProductAddRequest.setProlongSt(ProlongSt);
            creditProductAddRequest.setGracePeriod(GracePeriod);
            creditProductAddRequest.setGraceSt(GraceSt);
            creditProductAddRequest.setGracePeriodDeb(GracePeriodDeb);
            creditProductAddRequest.setGraceStDeb(GraceStDeb);
            creditProductAddRequest.setGracePeriodLess(GracePeriodLess);
            creditProductAddRequest.setGraceStLess(GraceStLess);
            creditProductAddRequest.setGoalKP(goalKP);
            creditProductAddRequest.setCurrency(currency);
            creditProductAddRequest.setFormKP(formKP);
            creditProductAddRequest.setRealEstate(realEstate);
            creditProductAddRequest.setTypeGarantOb(typeGarantOb);
            creditProductAddRequest.setTypeZalog(typeZalog);
            creditProductAddRequest.setTypeZalogOb(typeZalogOb);
            creditProductAddRequest.setGraseTypeOper(GraseTypeOper);
            creditProductAddRequest.setTermGive(termGive);
            creditProductAddRequest.setTermPay(termPay);
            creditProductAddRequest.setTermDevelop(termDevelop);
            creditProductAddRequest.IsObespNeust = this.IsObespNeust;
            creditProductAddRequest.IsOver = this.IsOver;
            creditProductAddRequest.isOnline = this.isOnline;
            creditProductAddRequest.IsInstallment = this.IsInstallment;
            return creditProductAddRequest;
        }

    }

}
