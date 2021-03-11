package by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl;

import java.math.BigDecimal;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "CREDIT")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Credit {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "SYS_ID")
    private Long sysId;
    @Column(name = "PROMOT_INTERACT_WEEKS")
    private Boolean promotInteractWeeks;
    @Column(name = "TYPE_CONTRACT_OVERDRAFT")
    private Boolean typeContractOverdraft;
    @Column(name = "TYPE_INSTALLMENT_AGREEMENT")
    private Boolean typeInstallmentAgreement;
    @Column(name = "TYPE_AGREEMENT_EXPRESS_LOAN")
    private Boolean typeAgreementExpressLoan;
    @Column(name = "TYPE_AGREEMENT_POSLOAN")
    private Boolean typeAgreementPosloan;
    @Column(name = "TYPECONTRACT_INT_BANKING")
    private Boolean typecontractIntBanking;
    @Column(name = "TYPE_CONTRACT_ONLINE")
    private Boolean typeContractOnline;
    @Column(name = "CHOOSING_GROUP_PRODUCT")
    private Long choosingGroupProduct;
    @Column(name = "PRODUCT_CODE")
    private String productCode;
    @Column(name = "BANK_CLASSIFIER_PROD_CODE")
    private String bankClassifierProdCode;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PURPOSE_LOAN")
    private String purposeLoan;
    @Column(name = "PRINCIPAL_DEBT_ACCOUNT")
    private Long principalDebtAccount;
    @Column(name = "PRINCIPAL_DEBT_ACCOUNT_1Y")
    private Long principalDebtAccount1Y;
    @Column(name = "LOAN_CURRENCY")
    private String loanCurrency;
    @Column(name = "ISSUING_METHOD")
    private String issuingMethod;
    @Column(name = "LOAN_FORM")
    private String loanForm;
    @Column(name = "INTEREST_RATE_TYPE")
    private String interestRateType;
    @Column(name = "PROPERTY")
    private String property;
    @Column(name = "ISSUE_LIMIT")
    private Long issueLimit;
    @Column(name = "MAXIMUM_ISSUE_AMOUNT")
    private BigDecimal maximumIssueAmount;
    @Column(name = "ONETIME_COMMISSION_BYN")
    private BigDecimal onetimeCommissionByn;
    @Column(name = "COMM_ISSUING_LOAN_NATION_CUR")
    private BigDecimal commIssuingLoanNationCur;
    @Column(name = "COMM_ISSUING_LOAN_FOR_CUR")
    private BigDecimal commIssuingLoanForCur;
    @Column(name = "SOLVENCY_RATIO")
    private BigDecimal solvencyRatio;
    @Column(name = "TYPE_CONTINGENT_LIABILITIES")
    private Long typeContingentLiabilities;
    @Column(name = "POS_ORGANIZATION")
    private Long posOrganization;
    @Column(name = "AUTOMATIC_DECISION_MAKING")
    private Boolean automaticDecisionMaking;
    @Column(name = "SINGLE_GROUP_ACCOUNTS")
    private Boolean singleGroupAccounts;
    @Column(name = "PARENT_PRODUCT_SPEC_APRTPRTNR")
    private Long parentProductSpecAprtprtnr;
    @Column(name = "DEPENDS_REFINANCING_RATE")
    private Integer dependsRefinancingRate;
    @Column(name = "PRINCIPAL_DEBT_DEPENDENCE")
    private String principalDebtDependence;
    @Column(name = "OVERDUE_RATE_DEPENDENCY")
    private String overdueRateDependency;
    @Column(name = "DEPENDS_OVERNIGHT_RATE")
    private Boolean dependsOvernightRate;
    @Column(name = "DEPEND_BASIC_DEBT_RATE_90D")
    private String dependBasicDebtRate90D;
    @Column(name = "DEPEND_BASIC_DEBT_RATE_180D")
    private String dependBasicDebtRate180D;
    @Column(name = "DEPEND_BASIC_DEBT_RATE_MORE")
    private String dependBasicDebtRateMore;
    @Column(name = "DEPEND_RATE_ANOTHER_KP")
    private String dependRateAnotherKp;
    @Column(name = "FIXED_RATE_ABSOLUTE_VALUE")
    private Boolean fixedRateAbsoluteValue;
    @Column(name = "MIN_DEBT_RATE_SET")
    private Boolean minDebtRateSet;
    @Column(name = "SUBSID_UNDER_DECREE_NO240")
    private Boolean subsidUnderDecreeNo240;
    @Column(name = "LOAN_TERM_MONTHS")
    private String loanTermMonths;
    @Column(name = "LOAN_REPAY_TERM_MONTHS")
    private String loanRepayTermMonths;
    @Column(name = "LOAN_DEV_PERIOD_MONTHS")
    private String loanDevPeriodMonths;
    @Column(name = "LOAN_REPAYMENT_DATE")
    private Long loanRepaymentDate;
    @Column(name = "ANNUITY_SCHEDULE_FORM")
    private Boolean annuityScheduleForm;
    @Column(name = "LOAN_REPAY_CONCLUS_CNTRCT")
    private Boolean loanRepayConclusCntrct;
    @Column(name = "OVERDRAFT_TRNVR_DAYS")
    private Long overdraftTrnvrDays;
    @Column(name = "TYPE_GUARANTEE")
    private Long typeGuarantee;
    @Column(name = "TYPE_GUARANTEE_GUARANTEE")
    private String typeGuaranteeGuarantee;
    @Column(name = "TYPE_COLLATERAL")
    private String typeCollateral;
    @Column(name = "TYPE_GUARANTEE_COLLATERAL")
    private String typeGuaranteeCollateral;
    @Column(name = "PROVIDING_FORFEIT")
    private Boolean providingForfeit;
    @Column(name = "OVERDUE_RATE_COEFFICIENT")
    private BigDecimal overdueRateCoefficient;
    @Column(name = "INTRST_OVERDUE_PROC")
    private BigDecimal intrstOverdueProc;
    @Column(name = "PENALTY_ARREARS_PROC")
    private BigDecimal penaltyArrearsProc;
    @Column(name = "DURAT_EXTENSION_MONTHS")
    private BigDecimal duratExtensionMonths;
    @Column(name = "INTEREST_RATE")
    private Long interestRate;
    @Column(name = "GRACE_PERIOD_NUM_DAYS")
    private Long gracePeriodNumDays;
    @Column(name = "PREFERENTIAL_RATE_PROC")
    private BigDecimal preferentialRateProc;
    @Column(name = "DEBGRACE_PERIOD_NUMBERD")
    private Long debgracePeriodNumberd;
    @Column(name = "DEB_GRACE_PREF_RATE")
    private String debGracePrefRate;
    @Column(name = "PREF_RATE_PROC")
    private BigDecimal prefRateProc;
    @Column(name = "REFIN_RATE_DEPEND")
    private Long refinRateDepend;
    @Column(name = "OVERNIGHT_RATE_DEPEND")
    private Long overnightRateDepend;
    @Column(name = "TYPES_OPERATIONS")
    private String typesOperations;
    @Column(name = "GRACE_PERIOD_MONTHS")
    private Long gracePeriodMonths;
    @Column(name = "DEPEND_REFOVRN_RATE")
    private Boolean dependRefovrnRate;
    @Column(name = "PREFERENTIAL_RATE")
    private BigDecimal preferentialRate;
    @Column(name = "LOAN_AGR_DOCUMENTS")
    private Long loanAgrDocuments;
    @Column(name = "LOAN_AGR_DOCUMENTS_NUM")
    private Long loanAgrDocumentsNum;
    @Column(name = "WARRANT_AGR_DOCUMENTS")
    private Long warrantAgrDocuments;
    @Column(name = "WARRANT_AGR_DOCUMENTS_NUM")
    private Long warrantAgrDocumentsNum;
    @Column(name = "PLEDGE_AGR_DOCUMENTS")
    private Long pledgeAgrDocuments;
    @Column(name = "DEC_CODES_LOAN_PURPOSE")
    private String decCodesLoanPurpose;
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
    @Column(name = "SECURITY_FORCED")
    private Boolean securityForced;
    @Column(name = "VERIFIERS")
    private Boolean verifiers;
    @Column(name = "VERIFIERS_FORCED")
    private Boolean verifiersForced;
    @Column(name = "SCORING")
    private Boolean scoring;
    @Column(name = "RISK_MANAGERS")
    private Boolean riskManagers;
    @Column(name = "RISK_MANAGERS_FORCED")
    private Boolean riskManagersForced;
    @Column(name = "SCORING_MODE")
    private String scoringMode;
    @Column(name = "IS_OVERDUE_RATE_DEPEND")
    private String isOverdueRateDepend;

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

    public Boolean getPromotInteractWeeks() {
        return promotInteractWeeks;
    }

    public void setPromotInteractWeeks(Boolean promotInteractWeeks) {
        this.promotInteractWeeks = promotInteractWeeks;
    }

    public Boolean getTypeContractOverdraft() {
        return typeContractOverdraft;
    }

    public void setTypeContractOverdraft(Boolean typeContractOverdraft) {
        this.typeContractOverdraft = typeContractOverdraft;
    }

    public Boolean getTypeInstallmentAgreement() {
        return typeInstallmentAgreement;
    }

    public void setTypeInstallmentAgreement(Boolean typeInstallmentAgreement) {
        this.typeInstallmentAgreement = typeInstallmentAgreement;
    }

    public Boolean getTypeAgreementExpressLoan() {
        return typeAgreementExpressLoan;
    }

    public void setTypeAgreementExpressLoan(Boolean typeAgreementExpressLoan) {
        this.typeAgreementExpressLoan = typeAgreementExpressLoan;
    }

    public Boolean getTypeAgreementPosloan() {
        return typeAgreementPosloan;
    }

    public void setTypeAgreementPosloan(Boolean typeAgreementPosloan) {
        this.typeAgreementPosloan = typeAgreementPosloan;
    }

    public Boolean getTypecontractIntBanking() {
        return typecontractIntBanking;
    }

    public void setTypecontractIntBanking(Boolean typecontractIntBanking) {
        this.typecontractIntBanking = typecontractIntBanking;
    }

    public Boolean getTypeContractOnline() {
        return typeContractOnline;
    }

    public void setTypeContractOnline(Boolean typeContractOnline) {
        this.typeContractOnline = typeContractOnline;
    }

    public Long getChoosingGroupProduct() {
        return choosingGroupProduct;
    }

    public void setChoosingGroupProduct(Long choosingGroupProduct) {
        this.choosingGroupProduct = choosingGroupProduct;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBankClassifierProdCode() {
        return bankClassifierProdCode;
    }

    public void setBankClassifierProdCode(String bankClassifierProdCode) {
        this.bankClassifierProdCode = bankClassifierProdCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPurposeLoan() {
        return purposeLoan;
    }

    public void setPurposeLoan(String purposeLoan) {
        this.purposeLoan = purposeLoan;
    }

    public Long getPrincipalDebtAccount() {
        return principalDebtAccount;
    }

    public void setPrincipalDebtAccount(Long principalDebtAccount) {
        this.principalDebtAccount = principalDebtAccount;
    }

    public Long getPrincipalDebtAccount1Y() {
        return principalDebtAccount1Y;
    }

    public void setPrincipalDebtAccount1Y(Long principalDebtAccount1Y) {
        this.principalDebtAccount1Y = principalDebtAccount1Y;
    }

    public String getLoanCurrency() {
        return loanCurrency;
    }

    public void setLoanCurrency(String loanCurrency) {
        this.loanCurrency = loanCurrency;
    }

    public String getIssuingMethod() {
        return issuingMethod;
    }

    public void setIssuingMethod(String issuingMethod) {
        this.issuingMethod = issuingMethod;
    }

    public String getLoanForm() {
        return loanForm;
    }

    public void setLoanForm(String loanForm) {
        this.loanForm = loanForm;
    }

    public String getInterestRateType() {
        return interestRateType;
    }

    public void setInterestRateType(String interestRateType) {
        this.interestRateType = interestRateType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
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

    public BigDecimal getOnetimeCommissionByn() {
        return onetimeCommissionByn;
    }

    public void setOnetimeCommissionByn(BigDecimal onetimeCommissionByn) {
        this.onetimeCommissionByn = onetimeCommissionByn;
    }

    public BigDecimal getCommIssuingLoanNationCur() {
        return commIssuingLoanNationCur;
    }

    public void setCommIssuingLoanNationCur(BigDecimal commIssuingLoanNationCur) {
        this.commIssuingLoanNationCur = commIssuingLoanNationCur;
    }

    public BigDecimal getCommIssuingLoanForCur() {
        return commIssuingLoanForCur;
    }

    public void setCommIssuingLoanForCur(BigDecimal commIssuingLoanForCur) {
        this.commIssuingLoanForCur = commIssuingLoanForCur;
    }

    public BigDecimal getSolvencyRatio() {
        return solvencyRatio;
    }

    public void setSolvencyRatio(BigDecimal solvencyRatio) {
        this.solvencyRatio = solvencyRatio;
    }

    public Long getTypeContingentLiabilities() {
        return typeContingentLiabilities;
    }

    public void setTypeContingentLiabilities(Long typeContingentLiabilities) {
        this.typeContingentLiabilities = typeContingentLiabilities;
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

    public Boolean getSingleGroupAccounts() {
        return singleGroupAccounts;
    }

    public void setSingleGroupAccounts(Boolean singleGroupAccounts) {
        this.singleGroupAccounts = singleGroupAccounts;
    }

    public Long getParentProductSpecAprtprtnr() {
        return parentProductSpecAprtprtnr;
    }

    public void setParentProductSpecAprtprtnr(Long parentProductSpecAprtprtnr) {
        this.parentProductSpecAprtprtnr = parentProductSpecAprtprtnr;
    }

    public Integer getDependsRefinancingRate() {
        return dependsRefinancingRate;
    }

    public void setDependsRefinancingRate(Integer dependsRefinancingRate) {
        this.dependsRefinancingRate = dependsRefinancingRate;
    }

    public String getPrincipalDebtDependence() {
        return principalDebtDependence;
    }

    public void setPrincipalDebtDependence(String principalDebtDependence) {
        this.principalDebtDependence = principalDebtDependence;
    }

    public String getOverdueRateDependency() {
        return overdueRateDependency;
    }

    public void setOverdueRateDependency(String overdueRateDependency) {
        this.overdueRateDependency = overdueRateDependency;
    }

    public Boolean getDependsOvernightRate() {
        return dependsOvernightRate;
    }

    public void setDependsOvernightRate(Boolean dependsOvernightRate) {
        this.dependsOvernightRate = dependsOvernightRate;
    }

    public String getDependBasicDebtRate90D() {
        return dependBasicDebtRate90D;
    }

    public void setDependBasicDebtRate90D(String dependBasicDebtRate90D) {
        this.dependBasicDebtRate90D = dependBasicDebtRate90D;
    }

    public String getDependBasicDebtRate180D() {
        return dependBasicDebtRate180D;
    }

    public void setDependBasicDebtRate180D(String dependBasicDebtRate180D) {
        this.dependBasicDebtRate180D = dependBasicDebtRate180D;
    }

    public String getDependBasicDebtRateMore() {
        return dependBasicDebtRateMore;
    }

    public void setDependBasicDebtRateMore(String dependBasicDebtRateMore) {
        this.dependBasicDebtRateMore = dependBasicDebtRateMore;
    }

    public String getDependRateAnotherKp() {
        return dependRateAnotherKp;
    }

    public void setDependRateAnotherKp(String dependRateAnotherKp) {
        this.dependRateAnotherKp = dependRateAnotherKp;
    }

    public Boolean getFixedRateAbsoluteValue() {
        return fixedRateAbsoluteValue;
    }

    public void setFixedRateAbsoluteValue(Boolean fixedRateAbsoluteValue) {
        this.fixedRateAbsoluteValue = fixedRateAbsoluteValue;
    }

    public Boolean getMinDebtRateSet() {
        return minDebtRateSet;
    }

    public void setMinDebtRateSet(Boolean minDebtRateSet) {
        this.minDebtRateSet = minDebtRateSet;
    }

    public Boolean getSubsidUnderDecreeNo240() {
        return subsidUnderDecreeNo240;
    }

    public void setSubsidUnderDecreeNo240(Boolean subsidUnderDecreeNo240) {
        this.subsidUnderDecreeNo240 = subsidUnderDecreeNo240;
    }

    public String getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(String loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    public String getLoanRepayTermMonths() {
        return loanRepayTermMonths;
    }

    public void setLoanRepayTermMonths(String loanRepayTermMonths) {
        this.loanRepayTermMonths = loanRepayTermMonths;
    }

    public String getLoanDevPeriodMonths() {
        return loanDevPeriodMonths;
    }

    public void setLoanDevPeriodMonths(String loanDevPeriodMonths) {
        this.loanDevPeriodMonths = loanDevPeriodMonths;
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

    public Boolean getLoanRepayConclusCntrct() {
        return loanRepayConclusCntrct;
    }

    public void setLoanRepayConclusCntrct(Boolean loanRepayConclusCntrct) {
        this.loanRepayConclusCntrct = loanRepayConclusCntrct;
    }

    public Long getOverdraftTrnvrDays() {
        return overdraftTrnvrDays;
    }

    public void setOverdraftTrnvrDays(Long overdraftTrnvrDays) {
        this.overdraftTrnvrDays = overdraftTrnvrDays;
    }

    public Long getTypeGuarantee() {
        return typeGuarantee;
    }

    public void setTypeGuarantee(Long typeGuarantee) {
        this.typeGuarantee = typeGuarantee;
    }

    public String getTypeGuaranteeGuarantee() {
        return typeGuaranteeGuarantee;
    }

    public void setTypeGuaranteeGuarantee(String typeGuaranteeGuarantee) {
        this.typeGuaranteeGuarantee = typeGuaranteeGuarantee;
    }

    public String getTypeCollateral() {
        return typeCollateral;
    }

    public void setTypeCollateral(String typeCollateral) {
        this.typeCollateral = typeCollateral;
    }

    public String getTypeGuaranteeCollateral() {
        return typeGuaranteeCollateral;
    }

    public void setTypeGuaranteeCollateral(String typeGuaranteeCollateral) {
        this.typeGuaranteeCollateral = typeGuaranteeCollateral;
    }

    public Boolean getProvidingForfeit() {
        return providingForfeit;
    }

    public void setProvidingForfeit(Boolean providingForfeit) {
        this.providingForfeit = providingForfeit;
    }

    public BigDecimal getOverdueRateCoefficient() {
        return overdueRateCoefficient;
    }

    public void setOverdueRateCoefficient(BigDecimal overdueRateCoefficient) {
        this.overdueRateCoefficient = overdueRateCoefficient;
    }

    public BigDecimal getIntrstOverdueProc() {
        return intrstOverdueProc;
    }

    public void setIntrstOverdueProc(BigDecimal intrstOverdueProc) {
        this.intrstOverdueProc = intrstOverdueProc;
    }

    public BigDecimal getPenaltyArrearsProc() {
        return penaltyArrearsProc;
    }

    public void setPenaltyArrearsProc(BigDecimal penaltyArrearsProc) {
        this.penaltyArrearsProc = penaltyArrearsProc;
    }

    public BigDecimal getDuratExtensionMonths() {
        return duratExtensionMonths;
    }

    public void setDuratExtensionMonths(BigDecimal duratExtensionMonths) {
        this.duratExtensionMonths = duratExtensionMonths;
    }

    public Long getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Long interestRate) {
        this.interestRate = interestRate;
    }

    public Long getGracePeriodNumDays() {
        return gracePeriodNumDays;
    }

    public void setGracePeriodNumDays(Long gracePeriodNumDays) {
        this.gracePeriodNumDays = gracePeriodNumDays;
    }

    public BigDecimal getPreferentialRateProc() {
        return preferentialRateProc;
    }

    public void setPreferentialRateProc(BigDecimal preferentialRateProc) {
        this.preferentialRateProc = preferentialRateProc;
    }

    public Long getDebgracePeriodNumberd() {
        return debgracePeriodNumberd;
    }

    public void setDebgracePeriodNumberd(Long debgracePeriodNumberd) {
        this.debgracePeriodNumberd = debgracePeriodNumberd;
    }

    public String getDebGracePrefRate() {
        return debGracePrefRate;
    }

    public void setDebGracePrefRate(String debGracePrefRate) {
        this.debGracePrefRate = debGracePrefRate;
    }

    public BigDecimal getPrefRateProc() {
        return prefRateProc;
    }

    public void setPrefRateProc(BigDecimal prefRateProc) {
        this.prefRateProc = prefRateProc;
    }

    public Long getRefinRateDepend() {
        return refinRateDepend;
    }

    public void setRefinRateDepend(Long refinRateDepend) {
        this.refinRateDepend = refinRateDepend;
    }

    public Long getOvernightRateDepend() {
        return overnightRateDepend;
    }

    public void setOvernightRateDepend(Long overnightRateDepend) {
        this.overnightRateDepend = overnightRateDepend;
    }

    public String getTypesOperations() {
        return typesOperations;
    }

    public void setTypesOperations(String typesOperations) {
        this.typesOperations = typesOperations;
    }

    public Long getGracePeriodMonths() {
        return gracePeriodMonths;
    }

    public void setGracePeriodMonths(Long gracePeriodMonths) {
        this.gracePeriodMonths = gracePeriodMonths;
    }

    public Boolean getDependRefovrnRate() {
        return dependRefovrnRate;
    }

    public void setDependRefovrnRate(Boolean dependRefovrnRate) {
        this.dependRefovrnRate = dependRefovrnRate;
    }

    public BigDecimal getPreferentialRate() {
        return preferentialRate;
    }

    public void setPreferentialRate(BigDecimal preferentialRate) {
        this.preferentialRate = preferentialRate;
    }

    public Long getLoanAgrDocuments() {
        return loanAgrDocuments;
    }

    public void setLoanAgrDocuments(Long loanAgrDocuments) {
        this.loanAgrDocuments = loanAgrDocuments;
    }

    public Long getLoanAgrDocumentsNum() {
        return loanAgrDocumentsNum;
    }

    public void setLoanAgrDocumentsNum(Long loanAgrDocumentsNum) {
        this.loanAgrDocumentsNum = loanAgrDocumentsNum;
    }

    public Long getWarrantAgrDocuments() {
        return warrantAgrDocuments;
    }

    public void setWarrantAgrDocuments(Long warrantAgrDocuments) {
        this.warrantAgrDocuments = warrantAgrDocuments;
    }

    public Long getWarrantAgrDocumentsNum() {
        return warrantAgrDocumentsNum;
    }

    public void setWarrantAgrDocumentsNum(Long warrantAgrDocumentsNum) {
        this.warrantAgrDocumentsNum = warrantAgrDocumentsNum;
    }

    public Long getPledgeAgrDocuments() {
        return pledgeAgrDocuments;
    }

    public void setPledgeAgrDocuments(Long pledgeAgrDocuments) {
        this.pledgeAgrDocuments = pledgeAgrDocuments;
    }

    public String getDecCodesLoanPurpose() {
        return decCodesLoanPurpose;
    }

    public void setDecCodesLoanPurpose(String decCodesLoanPurpose) {
        this.decCodesLoanPurpose = decCodesLoanPurpose;
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

    public Boolean getSecurityForced() {
        return securityForced;
    }

    public void setSecurityForced(Boolean securityForced) {
        this.securityForced = securityForced;
    }

    public Boolean getVerifiers() {
        return verifiers;
    }

    public void setVerifiers(Boolean verifiers) {
        this.verifiers = verifiers;
    }

    public Boolean getVerifiersForced() {
        return verifiersForced;
    }

    public void setVerifiersForced(Boolean verifiersForced) {
        this.verifiersForced = verifiersForced;
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

    public Boolean getRiskManagersForced() {
        return riskManagersForced;
    }

    public void setRiskManagersForced(Boolean riskManagersForced) {
        this.riskManagersForced = riskManagersForced;
    }

    public String getScoringMode() {
        return scoringMode;
    }

    public void setScoringMode(String scoringMode) {
        this.scoringMode = scoringMode;
    }

    public String getIsOverdueRateDepend() {
        return isOverdueRateDepend;
    }

    public void setIsOverdueRateDepend(String isOverdueRateDepend) {
        this.isOverdueRateDepend = isOverdueRateDepend;
    }

}
