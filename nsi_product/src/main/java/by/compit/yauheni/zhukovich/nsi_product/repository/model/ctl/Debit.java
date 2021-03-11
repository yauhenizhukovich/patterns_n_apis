package by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl;

import java.math.BigDecimal;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "DEBIT")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Debit {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SYS_ID")
    private Long sysId;
    @Column(name = "CONTRAGENT_TYPE")
    private Integer contragentType;
    @Column(name = "PRODUCT_CLASS")
    private String productClass;
    @Column(name = "PRODUCT_TYPE")
    private String productType;
    @Column(name = "CODE")
    private String code;
    @Column(name = "CLASS_CODE")
    private Long classCode;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "ISREVOKE")
    private Boolean isRevoke;
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @Column(name = "INTEREST_RATE_TYPE")
    private Long interestRateType;
    @Column(name = "INTEREST_RATE_KIND")
    private Long interestRateKind;
    @Column(name = "BASE_VALUE_TYPE")
    private Integer baseValueType;
    @Column(name = "CLOSING_AMOUNT")
    private BigDecimal closingAmount;
    @Column(name = "CLOSING_PROC")
    private BigDecimal closingProc;
    @Column(name = "INTEREST_CURRENCY")
    private Long interestCurrency;
    @Column(name = "TERM_UNIT")
    private String termUnit;
    @Column(name = "TERM")
    private Long term;
    @Column(name = "ISPROLONG")
    private Boolean isProlong;
    @Column(name = "ACCRUAL_PROC_FREQ")
    private String accrualProcFreq;
    @Column(name = "ACCRUAL_BASE")
    private String accrualBase;
    @Column(name = "OBTAINING_PROC_METHOD")
    private Long obtainingProcMethod;
    @Column(name = "IS_CARD_PROC")
    private Boolean isCardProc;
    @Column(name = "LIMIT_CURRENCY")
    private Long limitCurrency;
    @Column(name = "MINIMUM_DEPOSIT_AMOUNT")
    private BigDecimal minimumDepositAmount;
    @Column(name = "MAXIMUM_DEPOSIT_AMOUNT")
    private BigDecimal maximumDepositAmount;
    @Column(name = "REFILL")
    private String refill;
    @Column(name = "REFILL_MAX_AMOUNT")
    private BigDecimal refillMaxAmount;
    @Column(name = "REFILL_MIN_AMOUNT")
    private BigDecimal refillMinAmount;
    @Column(name = "REFILL_TERM_UNIT")
    private String refillTermUnit;
    @Column(name = "REFILL_TERM")
    private Long refillTerm;
    @Column(name = "PARTIAL_ISSUANCE")
    private String partialIssuance;
    @Column(name = "PARTIAL_FREQ_ISSUE")
    private String partialFreqIssue;
    @Column(name = "PARTIAL_ISSUE_AMOUNT")
    private BigDecimal partialIssueAmount;
    @Column(name = "PARTIAL_ISSUE_MIN_BALANCE")
    private BigDecimal partialIssueMinBalance;
    @Column(name = "PARTIAL_ISSUE_MIN_PROC")
    private BigDecimal partialIssueMinProc;
    @Column(name = "PART_ISSUE_MORE_MONTH")
    private Integer partIssueMoreMonth;
    @Column(name = "PART_ISSUE_DENIED")
    private Integer partIssueDenied;
    @Column(name = "PART_ISSUE_TERM_UNIT")
    private String partIssueTermUnit;
    @Column(name = "PART_REFILL_TERM")
    private Long partRefillTerm;
    @Column(name = "HAVING_LINKED_ACCOUNT")
    private Boolean havingLinkedAccount;
    @Column(name = "ONLY_CURRENT_CLOSE")
    private Boolean onlyCurrentClose;
    @Column(name = "ADDITIONAL_INFORMATION")
    private Boolean additionalInformation;
    @Column(name = "CONTRACT_FORM")
    private String contractForm;
    @Column(name = "OTHER_PERSON")
    private Boolean otherPerson;
    @Column(name = "OPEN_FOR_DISABLED_CHILD")
    private Boolean openForDisabledChild;
    @Column(name = "AUTHORIZED_REPRESENTATIVE")
    private Boolean authorizedRepresentative;
    @Column(name = "OPENING_IB")
    private Boolean openingIb;
    @Column(name = "INCOME_TAX_CALC")
    private Boolean incomeTaxCalc;
    @Column(name = "SMS_NOTIF_DISCOUNT")
    private Boolean smsNotifDiscount;
    @Column(name = "DISCOUNT_AMOUNT")
    private Long discountAmount;
    @Column(name = "POSTE_RESTANT_PROC")
    private BigDecimal posteRestantProc;
    @Column(name = "IS_INT_RATE_REDUCED_50")
    private Boolean isIntRateReduced50;
    @Column(name = "IS_INT_RATE_REDUCED_50ADD")
    private Long isIntRateReduced50Add;
    @Column(name = "INTERACTIVE_WEEKS_PROM")
    private Boolean interactiveWeeksProm;
    @Column(name = "OVERDRAFT_CONTRACT_TYPE")
    private Boolean overdraftContractType;
    @Column(name = "AGREEMENT_EXPRESS_LOAN_TYPE")
    private Boolean agreementExpressLoanType;
    @Column(name = "AGREEMENT_POSLOAN_TYPE")
    private Boolean agreementPosloanType;
    @Column(name = "INTERNET_BANK_CONRACT_TYPE")
    private Boolean internetBankConractType;
    @Column(name = "CHOOSING_PRODUCT_GROUP")
    private Long choosingProductGroup;
    @Column(name = "LOAN_PURPOSE")
    private Long loanPurpose;
    @Column(name = "PRINCIPAL_ACCOUNT")
    private Long principalAccount;
    @Column(name = "PRINCIPAL_ACCOUNT_1_YEAR")
    private Long principalAccount1Year;
    @Column(name = "CREDIT_CURRENCY")
    private Long creditCurrency;
    @Column(name = "ISSUING_METHOD")
    private Long issuingMethod;
    @Column(name = "LOAN_FORM")
    private Long loanForm;
    @Column(name = "INTEREST_RATE_TYPE_2")
    private Long interestRateType2;
    @Column(name = "REAL_ESTATE")
    private Long realEstate;
    @Column(name = "ISSUE_LIMIT")
    private Long issueLimit;
    @Column(name = "MAXIMUM_ISSUE_AMOUNT")
    private BigDecimal maximumIssueAmount;
    @Column(name = "ONETIME_COMM_BYN")
    private BigDecimal onetimeCommByn;
    @Column(name = "PROC_COMM_ISS_LOAN_NC")
    private BigDecimal procCommIssLoanNc;
    @Column(name = "PROC_COMM_ISS_LOAN_FC")
    private BigDecimal procCommIssLoanFc;
    @Column(name = "PAY_ABILITY_RATIO")
    private BigDecimal payAbilityRatio;
    @Column(name = "CONDITIONAL_OBLIG_TYPE")
    private Long conditionalObligType;
    @Column(name = "POS_ORGANIZATION")
    private Long posOrganization;
    @Column(name = "AUTOMATIC_DECISION_MAKING")
    private Boolean automaticDecisionMaking;
    @Column(name = "SINGLE_GROUP_OF_ACCOUNTS")
    private Boolean singleGroupOfAccounts;
    @Column(name = "PARENT_PRODUCT")
    private Long parentProduct;
    @Column(name = "IS_REFINANCING_RATE_DEPEND")
    private Boolean isRefinancingRateDepend;
    @Column(name = "RATE_SIGN")
    private String rateSign;
    @Column(name = "IS_MAIN_DEBT_RATE_DEPEND")
    private Boolean isMainDebtRateDepend;
    @Column(name = "IS_OVERDUE_RATE_DEPEND")
    private Boolean isOverdueRateDepend;
    @Column(name = "OVERNIGHT_RATE_DEPENDS")
    private Boolean overnightRateDepends;
    @Column(name = "MAIN_DEBT_RATE_DEPENDS_90")
    private Boolean mainDebtRateDepends90;
    @Column(name = "MAIN_DEBT_RATE_DEPENDS_180")
    private Boolean mainDebtRateDepends180;
    @Column(name = "MAIN_DEBT_RATE_DEPENDS_181")
    private Boolean mainDebtRateDepends181;
    @Column(name = "OVERDUE_RATE_DEPENDS")
    private Boolean overdueRateDepends;
    @Column(name = "CREDIT_PRODUCT_CODE")
    private Long creditProductCode;
    @Column(name = "ABS_VALUE_FIXED_RATE")
    private Boolean absValueFixedRate;
    @Column(name = "MIN_DEBT_RATE_SET")
    private Boolean minDebtRateSet;
    @Column(name = "SUBSIDIES_DECREE_NO240")
    private Boolean subsidiesDecreeNo240;
    @Column(name = "LOAN_TERM_MONTHS")
    private Long loanTermMonths;
    @Column(name = "LOAN_REPAYMENT_PERIOD_MONTHS")
    private Long loanRepaymentPeriodMonths;
    @Column(name = "LOAN_DEVELOPMENT_MONTHS")
    private Long loanDevelopmentMonths;
    @Column(name = "LOAN_REPAYMENT_DATE")
    private Long loanRepaymentDate;
    @Column(name = "ANNUITY_SCHEDULE_FORM")
    private Boolean annuityScheduleForm;
    @Column(name = "LOAN_REPAY_CONCLCONTRDAY")
    private Boolean loanRepayConclcontrday;
    @Column(name = "OVERDRAFT_TURNOVER_DAYS")
    private Long overdraftTurnoverDays;
    @Column(name = "GUARANTEE_TYPE")
    private Long guaranteeType;
    @Column(name = "GUARANTEE_TYPE_PROV")
    private Long guaranteeTypeProv;
    @Column(name = "COLLATERAL_TYPE")
    private Long collateralType;
    @Column(name = "COLLATERAL_TYPE_PROV")
    private Long collateralTypeProv;
    @Column(name = "PROVIDING_FORFEIT")
    private Boolean providingForfeit;
    @Column(name = "OVERDUE_RATE_RATIO")
    private BigDecimal overdueRateRatio;
    @Column(name = "FINE_OVERDUE_PROC")
    private BigDecimal fineOverdueProc;
    @Column(name = "PENALTY_ARREARS_PROC")
    private BigDecimal penaltyArrearsProc;
    @Column(name = "EXTENSION_DURATION_MONTHS")
    private Long extensionDurationMonths;
    @Column(name = "INTEREST_RATE")
    private BigDecimal interestRate;
    @Column(name = "CONTRACT_TYPE")
    private String contractType;
    @Column(name = "GRACE_PERIOD_DAYS")
    private Long gracePeriodDays;
    @Column(name = "PREFERENTIAL_RATE_PROC")
    private BigDecimal preferentialRateProc;
    @Column(name = "PREFERENTIAL_RATE")
    private String preferentialRate;
    @Column(name = "OPERATIONS_TYPES")
    private String operationsTypes;
    @Column(name = "GRACE_PERIOD_MONTHS")
    private Long gracePeriodMonths;
    @Column(name = "DEPENDS_ON_REFNNCOVRNGHT_RATE")
    private Boolean dependsOnRefnncovrnghtRate;
    @Column(name = "LOAN_AGREEM_DOCS")
    private Long loanAgreemDocs;
    @Column(name = "WARRANTY_AGREEM_DOCS")
    private Long warrantyAgreemDocs;
    @Column(name = "PLEDGE_AGREEM_DOCS")
    private Long pledgeAgreemDocs;
    @Column(name = "CC_MEETING_PROTOCOL")
    private String ccMeetingProtocol;
    @Column(name = "NEW_CONVEYOR")
    private Boolean newConveyor;
    @Column(name = "RULES_ANALYSIS")
    private Boolean rulesAnalysis;
    @Column(name = "KBB_HISTORY_ANALYSIS")
    private Boolean kbbHistoryAnalysis;
    @Column(name = "ISS_DATA_ANALYSIS")
    private Boolean issDataAnalysis;
    @Column(name = "LIST_ANALYSIS")
    private Boolean listAnalysis;
    @Column(name = "SECURITY")
    private Boolean security;
    @Column(name = "SECURITY_FORCIBLY")
    private Boolean securityForcibly;
    @Column(name = "VERIFIERS")
    private Boolean verifiers;
    @Column(name = "VERIFIERS_FORCIBLY")
    private Boolean verifiersForcibly;
    @Column(name = "SCORING")
    private Boolean scoring;
    @Column(name = "RISK_MANAGERS")
    private Boolean riskManagers;
    @Column(name = "RISK_MANAGERS_FORCIBLY")
    private Boolean riskManagersForcibly;
    @Column(name = "SCORING_MODEL")
    private String scoringModel;
    @Column(name = "PACKAGE_NAME")
    private String packageName;
    @Column(name = "VALIDITY")
    private Long validity;
    @Column(name = "CARD_TYPE")
    private String cardType;
    @Column(name = "NAME_ON_CARD")
    private String nameOnCard;
    @Column(name = "ALLOWED_CURRENCIES")
    private String allowedCurrencies;
    @Column(name = "VALID_CARD_TYPES")
    private String validCardTypes;
    @Column(name = "ALLOWED_PROD_DEPOS")
    private String allowedProdDepos;
    @Column(name = "ALLOWED_PROD_CREDIT")
    private String allowedProdCredit;
    @Column(name = "REQUIRED_OPTIONS")
    private String requiredOptions;
    @Column(name = "FREE_OPTIONS")
    private String freeOptions;
    @Column(name = "PAID_OPTIONS")
    private String paidOptions;
    @Column(name = "MAXIMUM_BALANCE_CONTROL")
    private Boolean maximumBalanceControl;
    @Column(name = "MINIMUM_BALANCE_AMOUNT")
    private BigDecimal minimumBalanceAmount;
    @Column(name = "MINIMUM_BALANCE_CONTROL")
    private Boolean minimumBalanceControl;
    @Column(name = "WITHDRAWS_NUMBER_PER_MONTH")
    private Boolean withdrawsNumberPerMonth;
    @Column(name = "TERMINATION_RATE")
    private String terminationRate;
    @Column(name = "RETURN_DATE")
    private String returnDate;
    @Column(name = "POSSIBLE_PART_WITHDRL_AMOUNT")
    private BigDecimal possiblePartWithdrlAmount;
    @Column(name = "MINIMUM_DEPOSIT_AMOUNT2")
    private BigDecimal minimumDepositAmount2;
    @Column(name = "INTEREST_RATE_TYPE2")
    private String interestRateType2Duplicate;
    @Column(name = "DEPOSIT_AGREEMENT_TYPE")
    private String depositAgreementType;
    @Column(name = "MINIMUM_DAYS_NUMBER")
    private Long minimumDaysNumber;
    @Column(name = "MAXIMUM_INTEREST_RATE")
    private BigDecimal maximumInterestRate;
    @Column(name = "MAXIMUM_DAYS_NUMBER")
    private Long maximumDaysNumber;
    @Column(name = "DECREASE_INCOME_PROC_50")
    private Boolean decreaseIncomeProc50;
    @Column(name = "TARIFFS_THRESHOLD_AMOUNT")
    private BigDecimal tariffsThresholdAmount;
    @Column(name = "PARTIAL_TERM_PROC")
    private BigDecimal partialTermProc;
    @Column(name = "CONTRACT_KIND")
    private Boolean contractKind;
    @Column(name = "MAX_BALANCE_CONTR_AMOUNT")
    private BigDecimal maxBalanceContrAmount;
    @Column(name = "RATE_REDUCE_PART_WITHDRWL")
    private Boolean rateReducePartWithdrwl;
    @Column(name = "FILL_PROHIBIT_DAYS_NUM")
    private Long fillProhibitDaysNum;
    @Column(name = "CNTRL_MAX_RATES_BY_PROPS")
    private Boolean cntrlMaxRatesByProps;
    @Column(name = "PRE_RATE_SCALE")
    private Boolean preRateScale;
    @Column(name = "EXTRA_INCOME")
    private Boolean extraIncome;
    @Column(name = "WAIT_PER_WITHDR_PROC_DAYS")
    private Long waitPerWithdrProcDays;
    @Column(name = "PERM_PROC_FILL_AMOUNT")
    private BigDecimal permProcFillAmount;
    @Column(name = "PART_WITHDRWL_PROC")
    private BigDecimal partWithdrwlProc;
    @Column(name = "TERMINATION_RATE_PROC")
    private BigDecimal terminationRateProc;
    @Column(name = "CURRENCY_CONV")
    private String currencyConv;
    @Column(name = "RATE")
    private BigDecimal rate;
    @Column(name = "RETURN_MEANS")
    private String returnMeans;
    @Column(name = "ACCNT_PROC_TYPE")
    private String accntProcType;
    @Column(name = "PURPOSE_PAYMENT")
    private String purposePayment;
    @Column(name = "FILL_POSSIBILITY_DAYS")
    private Boolean fillPossibilityDays;
    @Column(name = "CURRENCY_LOAN_GRNTS_FCTRNG")
    private String currencyLoanGrntsFctrng;
    @Column(name = "CONTRACT_TIME")
    private String contractTime;
    @Column(name = "LOAN_TERM")
    private String loanTerm;
    @Column(name = "TURNOVER_DAYS")
    private String turnoverDays;
    @Column(name = "TYPE_OF_LOAN")
    private String typeOfLoan;
    @Column(name = "LOAN_FORM2")
    private String loanForm2;
    @Column(name = "SPECIAL_PURPOSE")
    private String specialPurpose;
    @Column(name = "SETTLEMENT_CURRENCY")
    private String settlementCurrency;
    @Column(name = "FACTORING_TYPE")
    private String factoringType;
    @Column(name = "FACTORING_FORM")
    private String factoringForm;
    @Column(name = "PAYMENT_TERMS_FACTORING")
    private String paymentTermsFactoring;
    @Column(name = "TYPE_OF_GUARANTEE")
    private String typeOfGuarantee;
    @Column(name = "MAX_GUARANTEE_AMOUNT_USD")
    private String maxGuaranteeAmountUsd;
    @Column(name = "CLIENT_TARGET_CODES")
    private String clientTargetCodes;
    @Column(name = "PORTFOLIO_HOMOGNS_LOANS")
    private String portfolioHomognsLoans;
    @Column(name = "SDBO_AVAILABLE")
    private Boolean sdboAvailable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    public Integer getContragentType() {
        return contragentType;
    }

    public void setContragentType(Integer contragentType) {
        this.contragentType = contragentType;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getClassCode() {
        return classCode;
    }

    public void setClassCode(Long classCode) {
        this.classCode = classCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean getRevoke() {
        return isRevoke;
    }

    public void setRevoke(Boolean revoke) {
        isRevoke = revoke;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Long getInterestRateType() {
        return interestRateType;
    }

    public void setInterestRateType(Long interestRateType) {
        this.interestRateType = interestRateType;
    }

    public Long getInterestRateKind() {
        return interestRateKind;
    }

    public void setInterestRateKind(Long interestRateKind) {
        this.interestRateKind = interestRateKind;
    }

    public Integer getBaseValueType() {
        return baseValueType;
    }

    public void setBaseValueType(Integer baseValueType) {
        this.baseValueType = baseValueType;
    }

    public BigDecimal getClosingAmount() {
        return closingAmount;
    }

    public void setClosingAmount(BigDecimal closingAmount) {
        this.closingAmount = closingAmount;
    }

    public BigDecimal getClosingProc() {
        return closingProc;
    }

    public void setClosingProc(BigDecimal closingProc) {
        this.closingProc = closingProc;
    }

    public Long getInterestCurrency() {
        return interestCurrency;
    }

    public void setInterestCurrency(Long interestCurrency) {
        this.interestCurrency = interestCurrency;
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit;
    }

    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }

    public Boolean getProlong() {
        return isProlong;
    }

    public void setProlong(Boolean prolong) {
        isProlong = prolong;
    }

    public String getAccrualProcFreq() {
        return accrualProcFreq;
    }

    public void setAccrualProcFreq(String accrualProcFreq) {
        this.accrualProcFreq = accrualProcFreq;
    }

    public String getAccrualBase() {
        return accrualBase;
    }

    public void setAccrualBase(String accrualBase) {
        this.accrualBase = accrualBase;
    }

    public Long getObtainingProcMethod() {
        return obtainingProcMethod;
    }

    public void setObtainingProcMethod(Long obtainingProcMethod) {
        this.obtainingProcMethod = obtainingProcMethod;
    }

    public Boolean getCardProc() {
        return isCardProc;
    }

    public void setCardProc(Boolean cardProc) {
        isCardProc = cardProc;
    }

    public Long getLimitCurrency() {
        return limitCurrency;
    }

    public void setLimitCurrency(Long limitCurrency) {
        this.limitCurrency = limitCurrency;
    }

    public BigDecimal getMinimumDepositAmount() {
        return minimumDepositAmount;
    }

    public void setMinimumDepositAmount(BigDecimal minimumDepositAmount) {
        this.minimumDepositAmount = minimumDepositAmount;
    }

    public BigDecimal getMaximumDepositAmount() {
        return maximumDepositAmount;
    }

    public void setMaximumDepositAmount(BigDecimal maximumDepositAmount) {
        this.maximumDepositAmount = maximumDepositAmount;
    }

    public String getRefill() {
        return refill;
    }

    public void setRefill(String refill) {
        this.refill = refill;
    }

    public BigDecimal getRefillMaxAmount() {
        return refillMaxAmount;
    }

    public void setRefillMaxAmount(BigDecimal refillMaxAmount) {
        this.refillMaxAmount = refillMaxAmount;
    }

    public BigDecimal getRefillMinAmount() {
        return refillMinAmount;
    }

    public void setRefillMinAmount(BigDecimal refillMinAmount) {
        this.refillMinAmount = refillMinAmount;
    }

    public String getRefillTermUnit() {
        return refillTermUnit;
    }

    public void setRefillTermUnit(String refillTermUnit) {
        this.refillTermUnit = refillTermUnit;
    }

    public Long getRefillTerm() {
        return refillTerm;
    }

    public void setRefillTerm(Long refillTerm) {
        this.refillTerm = refillTerm;
    }

    public String getPartialIssuance() {
        return partialIssuance;
    }

    public void setPartialIssuance(String partialIssuance) {
        this.partialIssuance = partialIssuance;
    }

    public String getPartialFreqIssue() {
        return partialFreqIssue;
    }

    public void setPartialFreqIssue(String partialFreqIssue) {
        this.partialFreqIssue = partialFreqIssue;
    }

    public BigDecimal getPartialIssueAmount() {
        return partialIssueAmount;
    }

    public void setPartialIssueAmount(BigDecimal partialIssueAmount) {
        this.partialIssueAmount = partialIssueAmount;
    }

    public BigDecimal getPartialIssueMinBalance() {
        return partialIssueMinBalance;
    }

    public void setPartialIssueMinBalance(BigDecimal partialIssueMinBalance) {
        this.partialIssueMinBalance = partialIssueMinBalance;
    }

    public BigDecimal getPartialIssueMinProc() {
        return partialIssueMinProc;
    }

    public void setPartialIssueMinProc(BigDecimal partialIssueMinProc) {
        this.partialIssueMinProc = partialIssueMinProc;
    }

    public Integer getPartIssueMoreMonth() {
        return partIssueMoreMonth;
    }

    public void setPartIssueMoreMonth(Integer partIssueMoreMonth) {
        this.partIssueMoreMonth = partIssueMoreMonth;
    }

    public Integer getPartIssueDenied() {
        return partIssueDenied;
    }

    public void setPartIssueDenied(Integer partIssueDenied) {
        this.partIssueDenied = partIssueDenied;
    }

    public String getPartIssueTermUnit() {
        return partIssueTermUnit;
    }

    public void setPartIssueTermUnit(String partIssueTermUnit) {
        this.partIssueTermUnit = partIssueTermUnit;
    }

    public Long getPartRefillTerm() {
        return partRefillTerm;
    }

    public void setPartRefillTerm(Long partRefillTerm) {
        this.partRefillTerm = partRefillTerm;
    }

    public Boolean getHavingLinkedAccount() {
        return havingLinkedAccount;
    }

    public void setHavingLinkedAccount(Boolean havingLinkedAccount) {
        this.havingLinkedAccount = havingLinkedAccount;
    }

    public Boolean getOnlyCurrentClose() {
        return onlyCurrentClose;
    }

    public void setOnlyCurrentClose(Boolean onlyCurrentClose) {
        this.onlyCurrentClose = onlyCurrentClose;
    }

    public Boolean getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Boolean additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getContractForm() {
        return contractForm;
    }

    public void setContractForm(String contractForm) {
        this.contractForm = contractForm;
    }

    public Boolean getOtherPerson() {
        return otherPerson;
    }

    public void setOtherPerson(Boolean otherPerson) {
        this.otherPerson = otherPerson;
    }

    public Boolean getOpenForDisabledChild() {
        return openForDisabledChild;
    }

    public void setOpenForDisabledChild(Boolean openForDisabledChild) {
        this.openForDisabledChild = openForDisabledChild;
    }

    public Boolean getAuthorizedRepresentative() {
        return authorizedRepresentative;
    }

    public void setAuthorizedRepresentative(Boolean authorizedRepresentative) {
        this.authorizedRepresentative = authorizedRepresentative;
    }

    public Boolean getOpeningIb() {
        return openingIb;
    }

    public void setOpeningIb(Boolean openingIb) {
        this.openingIb = openingIb;
    }

    public Boolean getIncomeTaxCalc() {
        return incomeTaxCalc;
    }

    public void setIncomeTaxCalc(Boolean incomeTaxCalc) {
        this.incomeTaxCalc = incomeTaxCalc;
    }

    public Boolean getSmsNotifDiscount() {
        return smsNotifDiscount;
    }

    public void setSmsNotifDiscount(Boolean smsNotifDiscount) {
        this.smsNotifDiscount = smsNotifDiscount;
    }

    public Long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPosteRestantProc() {
        return posteRestantProc;
    }

    public void setPosteRestantProc(BigDecimal posteRestantProc) {
        this.posteRestantProc = posteRestantProc;
    }

    public Boolean getIntRateReduced50() {
        return isIntRateReduced50;
    }

    public void setIntRateReduced50(Boolean intRateReduced50) {
        isIntRateReduced50 = intRateReduced50;
    }

    public Long getIsIntRateReduced50Add() {
        return isIntRateReduced50Add;
    }

    public void setIsIntRateReduced50Add(Long isIntRateReduced50Add) {
        this.isIntRateReduced50Add = isIntRateReduced50Add;
    }

    public Boolean getInteractiveWeeksProm() {
        return interactiveWeeksProm;
    }

    public void setInteractiveWeeksProm(Boolean interactiveWeeksProm) {
        this.interactiveWeeksProm = interactiveWeeksProm;
    }

    public Boolean getOverdraftContractType() {
        return overdraftContractType;
    }

    public void setOverdraftContractType(Boolean overdraftContractType) {
        this.overdraftContractType = overdraftContractType;
    }

    public Boolean getAgreementExpressLoanType() {
        return agreementExpressLoanType;
    }

    public void setAgreementExpressLoanType(Boolean agreementExpressLoanType) {
        this.agreementExpressLoanType = agreementExpressLoanType;
    }

    public Boolean getAgreementPosloanType() {
        return agreementPosloanType;
    }

    public void setAgreementPosloanType(Boolean agreementPosloanType) {
        this.agreementPosloanType = agreementPosloanType;
    }

    public Boolean getInternetBankConractType() {
        return internetBankConractType;
    }

    public void setInternetBankConractType(Boolean internetBankConractType) {
        this.internetBankConractType = internetBankConractType;
    }

    public Long getChoosingProductGroup() {
        return choosingProductGroup;
    }

    public void setChoosingProductGroup(Long choosingProductGroup) {
        this.choosingProductGroup = choosingProductGroup;
    }

    public Long getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(Long loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Long getPrincipalAccount() {
        return principalAccount;
    }

    public void setPrincipalAccount(Long principalAccount) {
        this.principalAccount = principalAccount;
    }

    public Long getPrincipalAccount1Year() {
        return principalAccount1Year;
    }

    public void setPrincipalAccount1Year(Long principalAccount1Year) {
        this.principalAccount1Year = principalAccount1Year;
    }

    public Long getCreditCurrency() {
        return creditCurrency;
    }

    public void setCreditCurrency(Long creditCurrency) {
        this.creditCurrency = creditCurrency;
    }

    public Long getIssuingMethod() {
        return issuingMethod;
    }

    public void setIssuingMethod(Long issuingMethod) {
        this.issuingMethod = issuingMethod;
    }

    public Long getLoanForm() {
        return loanForm;
    }

    public void setLoanForm(Long loanForm) {
        this.loanForm = loanForm;
    }

    public Long getInterestRateType2() {
        return interestRateType2;
    }

    public void setInterestRateType2(Long interestRateType2) {
        this.interestRateType2 = interestRateType2;
    }

    public Long getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(Long realEstate) {
        this.realEstate = realEstate;
    }

    public Long getIssueLimit() {
        return issueLimit;
    }

    public void setIssueLimit(Long issueLimit) {
        this.issueLimit = issueLimit;
    }

    public BigDecimal getMaximumIssueAmount() {
        return maximumIssueAmount;
    }

    public void setMaximumIssueAmount(BigDecimal maximumIssueAmount) {
        this.maximumIssueAmount = maximumIssueAmount;
    }

    public BigDecimal getOnetimeCommByn() {
        return onetimeCommByn;
    }

    public void setOnetimeCommByn(BigDecimal onetimeCommByn) {
        this.onetimeCommByn = onetimeCommByn;
    }

    public BigDecimal getProcCommIssLoanNc() {
        return procCommIssLoanNc;
    }

    public void setProcCommIssLoanNc(BigDecimal procCommIssLoanNc) {
        this.procCommIssLoanNc = procCommIssLoanNc;
    }

    public BigDecimal getProcCommIssLoanFc() {
        return procCommIssLoanFc;
    }

    public void setProcCommIssLoanFc(BigDecimal procCommIssLoanFc) {
        this.procCommIssLoanFc = procCommIssLoanFc;
    }

    public BigDecimal getPayAbilityRatio() {
        return payAbilityRatio;
    }

    public void setPayAbilityRatio(BigDecimal payAbilityRatio) {
        this.payAbilityRatio = payAbilityRatio;
    }

    public Long getConditionalObligType() {
        return conditionalObligType;
    }

    public void setConditionalObligType(Long conditionalObligType) {
        this.conditionalObligType = conditionalObligType;
    }

    public Long getPosOrganization() {
        return posOrganization;
    }

    public void setPosOrganization(Long posOrganization) {
        this.posOrganization = posOrganization;
    }

    public Boolean getAutomaticDecisionMaking() {
        return automaticDecisionMaking;
    }

    public void setAutomaticDecisionMaking(Boolean automaticDecisionMaking) {
        this.automaticDecisionMaking = automaticDecisionMaking;
    }

    public Boolean getSingleGroupOfAccounts() {
        return singleGroupOfAccounts;
    }

    public void setSingleGroupOfAccounts(Boolean singleGroupOfAccounts) {
        this.singleGroupOfAccounts = singleGroupOfAccounts;
    }

    public Long getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(Long parentProduct) {
        this.parentProduct = parentProduct;
    }

    public Boolean getRefinancingRateDepend() {
        return isRefinancingRateDepend;
    }

    public void setRefinancingRateDepend(Boolean refinancingRateDepend) {
        isRefinancingRateDepend = refinancingRateDepend;
    }

    public String getRateSign() {
        return rateSign;
    }

    public void setRateSign(String rateSign) {
        this.rateSign = rateSign;
    }

    public Boolean getMainDebtRateDepend() {
        return isMainDebtRateDepend;
    }

    public void setMainDebtRateDepend(Boolean mainDebtRateDepend) {
        isMainDebtRateDepend = mainDebtRateDepend;
    }

    public Boolean getOverdueRateDepend() {
        return isOverdueRateDepend;
    }

    public void setOverdueRateDepend(Boolean overdueRateDepend) {
        isOverdueRateDepend = overdueRateDepend;
    }

    public Boolean getOvernightRateDepends() {
        return overnightRateDepends;
    }

    public void setOvernightRateDepends(Boolean overnightRateDepends) {
        this.overnightRateDepends = overnightRateDepends;
    }

    public Boolean getMainDebtRateDepends90() {
        return mainDebtRateDepends90;
    }

    public void setMainDebtRateDepends90(Boolean mainDebtRateDepends90) {
        this.mainDebtRateDepends90 = mainDebtRateDepends90;
    }

    public Boolean getMainDebtRateDepends180() {
        return mainDebtRateDepends180;
    }

    public void setMainDebtRateDepends180(Boolean mainDebtRateDepends180) {
        this.mainDebtRateDepends180 = mainDebtRateDepends180;
    }

    public Boolean getMainDebtRateDepends181() {
        return mainDebtRateDepends181;
    }

    public void setMainDebtRateDepends181(Boolean mainDebtRateDepends181) {
        this.mainDebtRateDepends181 = mainDebtRateDepends181;
    }

    public Boolean getOverdueRateDepends() {
        return overdueRateDepends;
    }

    public void setOverdueRateDepends(Boolean overdueRateDepends) {
        this.overdueRateDepends = overdueRateDepends;
    }

    public Long getCreditProductCode() {
        return creditProductCode;
    }

    public void setCreditProductCode(Long creditProductCode) {
        this.creditProductCode = creditProductCode;
    }

    public Boolean getAbsValueFixedRate() {
        return absValueFixedRate;
    }

    public void setAbsValueFixedRate(Boolean absValueFixedRate) {
        this.absValueFixedRate = absValueFixedRate;
    }

    public Boolean getMinDebtRateSet() {
        return minDebtRateSet;
    }

    public void setMinDebtRateSet(Boolean minDebtRateSet) {
        this.minDebtRateSet = minDebtRateSet;
    }

    public Boolean getSubsidiesDecreeNo240() {
        return subsidiesDecreeNo240;
    }

    public void setSubsidiesDecreeNo240(Boolean subsidiesDecreeNo240) {
        this.subsidiesDecreeNo240 = subsidiesDecreeNo240;
    }

    public Long getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(Long loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    public Long getLoanRepaymentPeriodMonths() {
        return loanRepaymentPeriodMonths;
    }

    public void setLoanRepaymentPeriodMonths(Long loanRepaymentPeriodMonths) {
        this.loanRepaymentPeriodMonths = loanRepaymentPeriodMonths;
    }

    public Long getLoanDevelopmentMonths() {
        return loanDevelopmentMonths;
    }

    public void setLoanDevelopmentMonths(Long loanDevelopmentMonths) {
        this.loanDevelopmentMonths = loanDevelopmentMonths;
    }

    public Long getLoanRepaymentDate() {
        return loanRepaymentDate;
    }

    public void setLoanRepaymentDate(Long loanRepaymentDate) {
        this.loanRepaymentDate = loanRepaymentDate;
    }

    public Boolean getAnnuityScheduleForm() {
        return annuityScheduleForm;
    }

    public void setAnnuityScheduleForm(Boolean annuityScheduleForm) {
        this.annuityScheduleForm = annuityScheduleForm;
    }

    public Boolean getLoanRepayConclcontrday() {
        return loanRepayConclcontrday;
    }

    public void setLoanRepayConclcontrday(Boolean loanRepayConclcontrday) {
        this.loanRepayConclcontrday = loanRepayConclcontrday;
    }

    public Long getOverdraftTurnoverDays() {
        return overdraftTurnoverDays;
    }

    public void setOverdraftTurnoverDays(Long overdraftTurnoverDays) {
        this.overdraftTurnoverDays = overdraftTurnoverDays;
    }

    public Long getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(Long guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public Long getGuaranteeTypeProv() {
        return guaranteeTypeProv;
    }

    public void setGuaranteeTypeProv(Long guaranteeTypeProv) {
        this.guaranteeTypeProv = guaranteeTypeProv;
    }

    public Long getCollateralType() {
        return collateralType;
    }

    public void setCollateralType(Long collateralType) {
        this.collateralType = collateralType;
    }

    public Long getCollateralTypeProv() {
        return collateralTypeProv;
    }

    public void setCollateralTypeProv(Long collateralTypeProv) {
        this.collateralTypeProv = collateralTypeProv;
    }

    public Boolean getProvidingForfeit() {
        return providingForfeit;
    }

    public void setProvidingForfeit(Boolean providingForfeit) {
        this.providingForfeit = providingForfeit;
    }

    public BigDecimal getOverdueRateRatio() {
        return overdueRateRatio;
    }

    public void setOverdueRateRatio(BigDecimal overdueRateRatio) {
        this.overdueRateRatio = overdueRateRatio;
    }

    public BigDecimal getFineOverdueProc() {
        return fineOverdueProc;
    }

    public void setFineOverdueProc(BigDecimal fineOverdueProc) {
        this.fineOverdueProc = fineOverdueProc;
    }

    public BigDecimal getPenaltyArrearsProc() {
        return penaltyArrearsProc;
    }

    public void setPenaltyArrearsProc(BigDecimal penaltyArrearsProc) {
        this.penaltyArrearsProc = penaltyArrearsProc;
    }

    public Long getExtensionDurationMonths() {
        return extensionDurationMonths;
    }

    public void setExtensionDurationMonths(Long extensionDurationMonths) {
        this.extensionDurationMonths = extensionDurationMonths;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Long getGracePeriodDays() {
        return gracePeriodDays;
    }

    public void setGracePeriodDays(Long gracePeriodDays) {
        this.gracePeriodDays = gracePeriodDays;
    }

    public BigDecimal getPreferentialRateProc() {
        return preferentialRateProc;
    }

    public void setPreferentialRateProc(BigDecimal preferentialRateProc) {
        this.preferentialRateProc = preferentialRateProc;
    }

    public String getPreferentialRate() {
        return preferentialRate;
    }

    public void setPreferentialRate(String preferentialRate) {
        this.preferentialRate = preferentialRate;
    }

    public String getOperationsTypes() {
        return operationsTypes;
    }

    public void setOperationsTypes(String operationsTypes) {
        this.operationsTypes = operationsTypes;
    }

    public Long getGracePeriodMonths() {
        return gracePeriodMonths;
    }

    public void setGracePeriodMonths(Long gracePeriodMonths) {
        this.gracePeriodMonths = gracePeriodMonths;
    }

    public Boolean getDependsOnRefnncovrnghtRate() {
        return dependsOnRefnncovrnghtRate;
    }

    public void setDependsOnRefnncovrnghtRate(Boolean dependsOnRefnncovrnghtRate) {
        this.dependsOnRefnncovrnghtRate = dependsOnRefnncovrnghtRate;
    }

    public Long getLoanAgreemDocs() {
        return loanAgreemDocs;
    }

    public void setLoanAgreemDocs(Long loanAgreemDocs) {
        this.loanAgreemDocs = loanAgreemDocs;
    }

    public Long getWarrantyAgreemDocs() {
        return warrantyAgreemDocs;
    }

    public void setWarrantyAgreemDocs(Long warrantyAgreemDocs) {
        this.warrantyAgreemDocs = warrantyAgreemDocs;
    }

    public Long getPledgeAgreemDocs() {
        return pledgeAgreemDocs;
    }

    public void setPledgeAgreemDocs(Long pledgeAgreemDocs) {
        this.pledgeAgreemDocs = pledgeAgreemDocs;
    }

    public String getCcMeetingProtocol() {
        return ccMeetingProtocol;
    }

    public void setCcMeetingProtocol(String ccMeetingProtocol) {
        this.ccMeetingProtocol = ccMeetingProtocol;
    }

    public Boolean getNewConveyor() {
        return newConveyor;
    }

    public void setNewConveyor(Boolean newConveyor) {
        this.newConveyor = newConveyor;
    }

    public Boolean getRulesAnalysis() {
        return rulesAnalysis;
    }

    public void setRulesAnalysis(Boolean rulesAnalysis) {
        this.rulesAnalysis = rulesAnalysis;
    }

    public Boolean getKbbHistoryAnalysis() {
        return kbbHistoryAnalysis;
    }

    public void setKbbHistoryAnalysis(Boolean kbbHistoryAnalysis) {
        this.kbbHistoryAnalysis = kbbHistoryAnalysis;
    }

    public Boolean getIssDataAnalysis() {
        return issDataAnalysis;
    }

    public void setIssDataAnalysis(Boolean issDataAnalysis) {
        this.issDataAnalysis = issDataAnalysis;
    }

    public Boolean getListAnalysis() {
        return listAnalysis;
    }

    public void setListAnalysis(Boolean listAnalysis) {
        this.listAnalysis = listAnalysis;
    }

    public Boolean getSecurity() {
        return security;
    }

    public void setSecurity(Boolean security) {
        this.security = security;
    }

    public Boolean getSecurityForcibly() {
        return securityForcibly;
    }

    public void setSecurityForcibly(Boolean securityForcibly) {
        this.securityForcibly = securityForcibly;
    }

    public Boolean getVerifiers() {
        return verifiers;
    }

    public void setVerifiers(Boolean verifiers) {
        this.verifiers = verifiers;
    }

    public Boolean getVerifiersForcibly() {
        return verifiersForcibly;
    }

    public void setVerifiersForcibly(Boolean verifiersForcibly) {
        this.verifiersForcibly = verifiersForcibly;
    }

    public Boolean getScoring() {
        return scoring;
    }

    public void setScoring(Boolean scoring) {
        this.scoring = scoring;
    }

    public Boolean getRiskManagers() {
        return riskManagers;
    }

    public void setRiskManagers(Boolean riskManagers) {
        this.riskManagers = riskManagers;
    }

    public Boolean getRiskManagersForcibly() {
        return riskManagersForcibly;
    }

    public void setRiskManagersForcibly(Boolean riskManagersForcibly) {
        this.riskManagersForcibly = riskManagersForcibly;
    }

    public String getScoringModel() {
        return scoringModel;
    }

    public void setScoringModel(String scoringModel) {
        this.scoringModel = scoringModel;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Long getValidity() {
        return validity;
    }

    public void setValidity(Long validity) {
        this.validity = validity;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getAllowedCurrencies() {
        return allowedCurrencies;
    }

    public void setAllowedCurrencies(String allowedCurrencies) {
        this.allowedCurrencies = allowedCurrencies;
    }

    public String getValidCardTypes() {
        return validCardTypes;
    }

    public void setValidCardTypes(String validCardTypes) {
        this.validCardTypes = validCardTypes;
    }

    public String getAllowedProdDepos() {
        return allowedProdDepos;
    }

    public void setAllowedProdDepos(String allowedProdDepos) {
        this.allowedProdDepos = allowedProdDepos;
    }

    public String getAllowedProdCredit() {
        return allowedProdCredit;
    }

    public void setAllowedProdCredit(String allowedProdCredit) {
        this.allowedProdCredit = allowedProdCredit;
    }

    public String getRequiredOptions() {
        return requiredOptions;
    }

    public void setRequiredOptions(String requiredOptions) {
        this.requiredOptions = requiredOptions;
    }

    public String getFreeOptions() {
        return freeOptions;
    }

    public void setFreeOptions(String freeOptions) {
        this.freeOptions = freeOptions;
    }

    public String getPaidOptions() {
        return paidOptions;
    }

    public void setPaidOptions(String paidOptions) {
        this.paidOptions = paidOptions;
    }

    public Boolean getMaximumBalanceControl() {
        return maximumBalanceControl;
    }

    public void setMaximumBalanceControl(Boolean maximumBalanceControl) {
        this.maximumBalanceControl = maximumBalanceControl;
    }

    public BigDecimal getMinimumBalanceAmount() {
        return minimumBalanceAmount;
    }

    public void setMinimumBalanceAmount(BigDecimal minimumBalanceAmount) {
        this.minimumBalanceAmount = minimumBalanceAmount;
    }

    public Boolean getMinimumBalanceControl() {
        return minimumBalanceControl;
    }

    public void setMinimumBalanceControl(Boolean minimumBalanceControl) {
        this.minimumBalanceControl = minimumBalanceControl;
    }

    public Boolean getWithdrawsNumberPerMonth() {
        return withdrawsNumberPerMonth;
    }

    public void setWithdrawsNumberPerMonth(Boolean withdrawsNumberPerMonth) {
        this.withdrawsNumberPerMonth = withdrawsNumberPerMonth;
    }

    public String getTerminationRate() {
        return terminationRate;
    }

    public void setTerminationRate(String terminationRate) {
        this.terminationRate = terminationRate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getPossiblePartWithdrlAmount() {
        return possiblePartWithdrlAmount;
    }

    public void setPossiblePartWithdrlAmount(BigDecimal possiblePartWithdrlAmount) {
        this.possiblePartWithdrlAmount = possiblePartWithdrlAmount;
    }

    public BigDecimal getMinimumDepositAmount2() {
        return minimumDepositAmount2;
    }

    public void setMinimumDepositAmount2(BigDecimal minimumDepositAmount2) {
        this.minimumDepositAmount2 = minimumDepositAmount2;
    }

    public String getInterestRateType2Duplicate() {
        return interestRateType2Duplicate;
    }

    public void setInterestRateType2Duplicate(String interestRateType2Duplicate) {
        this.interestRateType2Duplicate = interestRateType2Duplicate;
    }

    public String getDepositAgreementType() {
        return depositAgreementType;
    }

    public void setDepositAgreementType(String depositAgreementType) {
        this.depositAgreementType = depositAgreementType;
    }

    public Long getMinimumDaysNumber() {
        return minimumDaysNumber;
    }

    public void setMinimumDaysNumber(Long minimumDaysNumber) {
        this.minimumDaysNumber = minimumDaysNumber;
    }

    public BigDecimal getMaximumInterestRate() {
        return maximumInterestRate;
    }

    public void setMaximumInterestRate(BigDecimal maximumInterestRate) {
        this.maximumInterestRate = maximumInterestRate;
    }

    public Long getMaximumDaysNumber() {
        return maximumDaysNumber;
    }

    public void setMaximumDaysNumber(Long maximumDaysNumber) {
        this.maximumDaysNumber = maximumDaysNumber;
    }

    public Boolean getDecreaseIncomeProc50() {
        return decreaseIncomeProc50;
    }

    public void setDecreaseIncomeProc50(Boolean decreaseIncomeProc50) {
        this.decreaseIncomeProc50 = decreaseIncomeProc50;
    }

    public BigDecimal getTariffsThresholdAmount() {
        return tariffsThresholdAmount;
    }

    public void setTariffsThresholdAmount(BigDecimal tariffsThresholdAmount) {
        this.tariffsThresholdAmount = tariffsThresholdAmount;
    }

    public BigDecimal getPartialTermProc() {
        return partialTermProc;
    }

    public void setPartialTermProc(BigDecimal partialTermProc) {
        this.partialTermProc = partialTermProc;
    }

    public Boolean getContractKind() {
        return contractKind;
    }

    public void setContractKind(Boolean contractKind) {
        this.contractKind = contractKind;
    }

    public BigDecimal getMaxBalanceContrAmount() {
        return maxBalanceContrAmount;
    }

    public void setMaxBalanceContrAmount(BigDecimal maxBalanceContrAmount) {
        this.maxBalanceContrAmount = maxBalanceContrAmount;
    }

    public Boolean getRateReducePartWithdrwl() {
        return rateReducePartWithdrwl;
    }

    public void setRateReducePartWithdrwl(Boolean rateReducePartWithdrwl) {
        this.rateReducePartWithdrwl = rateReducePartWithdrwl;
    }

    public Long getFillProhibitDaysNum() {
        return fillProhibitDaysNum;
    }

    public void setFillProhibitDaysNum(Long fillProhibitDaysNum) {
        this.fillProhibitDaysNum = fillProhibitDaysNum;
    }

    public Boolean getCntrlMaxRatesByProps() {
        return cntrlMaxRatesByProps;
    }

    public void setCntrlMaxRatesByProps(Boolean cntrlMaxRatesByProps) {
        this.cntrlMaxRatesByProps = cntrlMaxRatesByProps;
    }

    public Boolean getPreRateScale() {
        return preRateScale;
    }

    public void setPreRateScale(Boolean preRateScale) {
        this.preRateScale = preRateScale;
    }

    public Boolean getExtraIncome() {
        return extraIncome;
    }

    public void setExtraIncome(Boolean extraIncome) {
        this.extraIncome = extraIncome;
    }

    public Long getWaitPerWithdrProcDays() {
        return waitPerWithdrProcDays;
    }

    public void setWaitPerWithdrProcDays(Long waitPerWithdrProcDays) {
        this.waitPerWithdrProcDays = waitPerWithdrProcDays;
    }

    public BigDecimal getPermProcFillAmount() {
        return permProcFillAmount;
    }

    public void setPermProcFillAmount(BigDecimal permProcFillAmount) {
        this.permProcFillAmount = permProcFillAmount;
    }

    public BigDecimal getPartWithdrwlProc() {
        return partWithdrwlProc;
    }

    public void setPartWithdrwlProc(BigDecimal partWithdrwlProc) {
        this.partWithdrwlProc = partWithdrwlProc;
    }

    public BigDecimal getTerminationRateProc() {
        return terminationRateProc;
    }

    public void setTerminationRateProc(BigDecimal terminationRateProc) {
        this.terminationRateProc = terminationRateProc;
    }

    public String getCurrencyConv() {
        return currencyConv;
    }

    public void setCurrencyConv(String currencyConv) {
        this.currencyConv = currencyConv;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getReturnMeans() {
        return returnMeans;
    }

    public void setReturnMeans(String returnMeans) {
        this.returnMeans = returnMeans;
    }

    public String getAccntProcType() {
        return accntProcType;
    }

    public void setAccntProcType(String accntProcType) {
        this.accntProcType = accntProcType;
    }

    public String getPurposePayment() {
        return purposePayment;
    }

    public void setPurposePayment(String purposePayment) {
        this.purposePayment = purposePayment;
    }

    public Boolean getFillPossibilityDays() {
        return fillPossibilityDays;
    }

    public void setFillPossibilityDays(Boolean fillPossibilityDays) {
        this.fillPossibilityDays = fillPossibilityDays;
    }

    public String getCurrencyLoanGrntsFctrng() {
        return currencyLoanGrntsFctrng;
    }

    public void setCurrencyLoanGrntsFctrng(String currencyLoanGrntsFctrng) {
        this.currencyLoanGrntsFctrng = currencyLoanGrntsFctrng;
    }

    public String getContractTime() {
        return contractTime;
    }

    public void setContractTime(String contractTime) {
        this.contractTime = contractTime;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getTurnoverDays() {
        return turnoverDays;
    }

    public void setTurnoverDays(String turnoverDays) {
        this.turnoverDays = turnoverDays;
    }

    public String getTypeOfLoan() {
        return typeOfLoan;
    }

    public void setTypeOfLoan(String typeOfLoan) {
        this.typeOfLoan = typeOfLoan;
    }

    public String getLoanForm2() {
        return loanForm2;
    }

    public void setLoanForm2(String loanForm2) {
        this.loanForm2 = loanForm2;
    }

    public String getSpecialPurpose() {
        return specialPurpose;
    }

    public void setSpecialPurpose(String specialPurpose) {
        this.specialPurpose = specialPurpose;
    }

    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public String getFactoringType() {
        return factoringType;
    }

    public void setFactoringType(String factoringType) {
        this.factoringType = factoringType;
    }

    public String getFactoringForm() {
        return factoringForm;
    }

    public void setFactoringForm(String factoringForm) {
        this.factoringForm = factoringForm;
    }

    public String getPaymentTermsFactoring() {
        return paymentTermsFactoring;
    }

    public void setPaymentTermsFactoring(String paymentTermsFactoring) {
        this.paymentTermsFactoring = paymentTermsFactoring;
    }

    public String getTypeOfGuarantee() {
        return typeOfGuarantee;
    }

    public void setTypeOfGuarantee(String typeOfGuarantee) {
        this.typeOfGuarantee = typeOfGuarantee;
    }

    public String getMaxGuaranteeAmountUsd() {
        return maxGuaranteeAmountUsd;
    }

    public void setMaxGuaranteeAmountUsd(String maxGuaranteeAmountUsd) {
        this.maxGuaranteeAmountUsd = maxGuaranteeAmountUsd;
    }

    public String getClientTargetCodes() {
        return clientTargetCodes;
    }

    public void setClientTargetCodes(String clientTargetCodes) {
        this.clientTargetCodes = clientTargetCodes;
    }

    public String getPortfolioHomognsLoans() {
        return portfolioHomognsLoans;
    }

    public void setPortfolioHomognsLoans(String portfolioHomognsLoans) {
        this.portfolioHomognsLoans = portfolioHomognsLoans;
    }

    public Boolean getSdboAvailable() {
        return sdboAvailable;
    }

    public void setSdboAvailable(Boolean sdboAvailable) {
        this.sdboAvailable = sdboAvailable;
    }

}
