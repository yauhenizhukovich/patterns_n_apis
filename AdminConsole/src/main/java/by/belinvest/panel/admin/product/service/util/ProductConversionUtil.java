package by.belinvest.panel.admin.product.service.util;

import java.math.BigDecimal;
import java.util.Map;

import by.belinvest.panel.admin.product.service.model.Attribute;
import by.belinvest.panel.admin.product.service.model.CardProductAdd;
import by.belinvest.panel.admin.product.service.model.CardProductEdit;
import by.belinvest.panel.admin.product.service.model.CreditProductAddRequest;
import by.belinvest.panel.admin.product.service.model.CurrencyProducts;
import by.belinvest.panel.admin.product.service.model.DepositOrCreditProducts;
import by.belinvest.panel.admin.product.service.model.DepositProductAddRequest;
import by.belinvest.panel.admin.product.service.model.DimItem;
import by.belinvest.panel.admin.product.service.model.DopProducts;
import by.belinvest.panel.admin.product.service.model.Enterprise;
import by.belinvest.panel.admin.product.service.model.Fine;
import by.belinvest.panel.admin.product.service.model.GroupRisk;
import by.belinvest.panel.admin.product.service.model.HandReplaceProduct;
import by.belinvest.panel.admin.product.service.model.MegatransactorOptions;
import by.belinvest.panel.admin.product.service.model.Options;
import by.belinvest.panel.admin.product.service.model.ReplaceProductsForProlong;
import by.belinvest.panel.admin.product.service.model.ReplaceProductsForReemision;
import by.belinvest.panel.admin.product.service.model.SmsTariff;
import by.belinvest.panel.admin.product.service.model.Uvkv;

public class ProductConversionUtil {

    public static CreditProductAddRequest convertRealProductToCreditProductAddRequest(Map<String, Object> realProduct) {
        return CreditProductAddRequest.Builder.aCreditProductAddRequest()
                .userCode("test@mail.com")  //TODO
                .kodProd((String) realProduct.get("PRODUCT_CODE"))
                .nameProd((String) realProduct.get("PRODUCT_NAME"))
                .kodProdBank((String) realProduct.get("BANK_CLASSIFIER_PROD_CODE"))
                .choiceGroup((BigDecimal) realProduct.get("CHOOSING_GROUP_PRODUCT"))
                .isOnline(convertBigDecimalToBoolean(realProduct.get("TYPE_CONTRACT_ONLINE")))
                .IB(convertBigDecimalToBoolean(realProduct.get("TYPECONTRACT_INT_BANKING")))
                .POS(convertBigDecimalToBoolean(realProduct.get("TYPE_AGREEMENT_POSLOAN")))
                .IsInstallment(convertBigDecimalToBoolean(realProduct.get("TYPE_INSTALLMENT_AGREEMENT")))
                .IsOver(convertBigDecimalToBoolean(realProduct.get("TYPE_CONTRACT_OVERDRAFT")))
                .Discount(convertBigDecimalToBoolean(realProduct.get("PROMOT_INTERACT_WEEKS")))
                .goalKP(new String[] {(String) realProduct.get("PURPOSE_LOAN")})
                .account(convertBigDecimalToString(realProduct.get("PRINCIPAL_DEBT_ACCOUNT")))
                .accountDop(convertBigDecimalToString(realProduct.get("PRINCIPAL_DEBT_ACCOUNT_1Y")))
                .currency(new String[] {(String) realProduct.get("LOAN_CURRENCY")})
                .typeGive((String) realProduct.get("ISSUING_METHOD"))
                .formKP(new String[] {(String) realProduct.get("LOAN_FORM")})
                .percentStavka((String) realProduct.get("INTEREST_RATE_TYPE"))
                .realEstate(new String[] {(String) realProduct.get("PROPERTY")})
                .limitGive((BigDecimal) realProduct.get("ISSUE_LIMIT"))
                .maxSum((BigDecimal) realProduct.get("MAXIMUM_ISSUE_AMOUNT"))
                .razCommission((BigDecimal) realProduct.get("ONETIME_COMMISSION_BYN"))
                .commissionNac((BigDecimal) realProduct.get("COMM_ISSUING_LOAN_NATION_CUR"))
                .commissionIN((BigDecimal) realProduct.get("COMM_ISSUING_LOAN_FOR_CUR"))
                .kofPlat((BigDecimal) realProduct.get("SOLVENCY_RATIO"))
                .ifObyaz(convertBigDecimalToString(realProduct.get("TYPE_CONTINGENT_LIABILITIES")))
                .orgPOS(String.valueOf(realProduct.get("POS_ORGANIZATION")))
                .avtoResh(convertBigDecimalToBoolean(realProduct.get("AUTOMATIC_DECISION_MAKING")))
                .edGroupAccount(convertBigDecimalToBoolean(realProduct.get("SINGLE_GROUP_ACCOUNTS")))
                .prodParent(convertBigDecimalToString(realProduct.get("PARENT_PRODUCT_SPEC_APRTPRTNR")))
                .termGive(new BigDecimal[] {convertStringToBigDecimal(realProduct.get("LOAN_TERM_MONTHS"))})
                .termPay(new BigDecimal[] {convertStringToBigDecimal(realProduct.get("LOAN_REPAY_TERM_MONTHS"))})
                .termDevelop(new BigDecimal[] {convertStringToBigDecimal(realProduct.get("LOAN_DEV_PERIOD_MONTHS"))})
                .datePay((BigDecimal) realProduct.get("LOAN_REPAYMENT_DATE"))
                .anGrafik(convertBigDecimalToBoolean(realProduct.get("ANNUITY_SCHEDULE_FORM")))
                .payDateFinish(convertBigDecimalToBoolean(realProduct.get("LOAN_REPAY_CONCLUS_CNTRCT")))
                .Turn((BigDecimal) realProduct.get("OVERDRAFT_TRNVR_DAYS"))
                .typeGarant(convertBigDecimalToString(realProduct.get("TYPE_GUARANTEE")))
                .typeGarantOb(new String[] {(String) realProduct.get("TYPE_GUARANTEE_GUARANTEE")})
                .typeZalog(new String[] {(String) realProduct.get("TYPE_COLLATERAL")})
                .typeZalogOb(new String[] {(String) realProduct.get("TYPE_GUARANTEE_COLLATERAL")})
                .IsObespNeust(convertBigDecimalToBoolean(realProduct.get("PROVIDING_FORFEIT")))
                .kofProsroch((BigDecimal) realProduct.get("OVERDUE_RATE_COEFFICIENT"))
                .penProsroch((BigDecimal) realProduct.get("INTRST_OVERDUE_PROC"))
                .Neust((BigDecimal) realProduct.get("PENALTY_ARREARS_PROC"))
                .ProlongPeriod((BigDecimal) realProduct.get("DURAT_EXTENSION_MONTHS"))
                .ProlongSt((BigDecimal) realProduct.get("INTEREST_RATE"))
                .typeLessDep((String) realProduct.get("DEB_GRACE_PREF_RATE"))
                .GraceStDeb((BigDecimal) realProduct.get("PREF_RATE_PROC"))
                .GracePeriod((BigDecimal) realProduct.get("GRACE_PERIOD_NUM_DAYS"))
                .GraceSt((BigDecimal) realProduct.get("PREFERENTIAL_RATE_PROC"))
                .GracePeriodDeb((BigDecimal) realProduct.get("DEBGRACE_PERIOD_NUMBERD"))
                .typeRefLessDeb(String.valueOf(realProduct.get("REFIN_RATE_DEPEND")))
                .typeOvernLessDeb(String.valueOf(realProduct.get("OVERNIGHT_RATE_DEPEND")))
                .GraseTypeOper(new String[] {(String) realProduct.get("TYPES_OPERATIONS")})
                .GracePeriodLess((BigDecimal) realProduct.get("GRACE_PERIOD_MONTHS"))
                .stRefLess(convertBigDecimalToBoolean(realProduct.get("DEPEND_REFOVRN_RATE")))
                .GraceStLess((BigDecimal) realProduct.get("PREFERENTIAL_RATE"))
                .docKD(String.valueOf(realProduct.get("LOAN_AGR_DOCUMENTS")))
                .docGarant(convertBigDecimalToString(realProduct.get("WARRANT_AGR_DOCUMENTS")))
                .docGarantCol(convertBigDecimalToString(realProduct.get("WARRANT_AGR_DOCUMENTS_NUM")))
                .docZalog(convertBigDecimalToString(realProduct.get("PLEDGE_AGR_DOCUMENTS")))
                .docZalogCol(null)    //unknown
                .testRule(convertBigDecimalToBoolean(realProduct.get("RULES_ANALYSIS")))
                .testKBB(convertBigDecimalToBoolean(realProduct.get("KBB_HISTORY_ANALYSIS")))
                .testISS(convertBigDecimalToBoolean(realProduct.get("ISS_DATA_ANALYSIS")))
                .testList(convertBigDecimalToBoolean(realProduct.get("LIST_ANALYSIS")))
                .safety(convertBigDecimalToBoolean(realProduct.get("SECURITY")))
                .safetyDop(convertBigDecimalToBoolean(realProduct.get("SECURITY_FORCED")))
                .ver(convertBigDecimalToBoolean(realProduct.get("VERIFIERS")))
                .verDop(convertBigDecimalToBoolean(realProduct.get("VERIFIERS_FORCED")))
                .rickM(convertBigDecimalToBoolean(realProduct.get("RISK_MANAGERS")))
                .rickMgDop(convertBigDecimalToBoolean(realProduct.get("RISK_MANAGERS_FORCED")))
                .build();
    }

    public static CardProductEdit convertRealProductToCardProductEdit(Map<String, Object> realProduct) {
        return CardProductEdit.Builder.aCardProductEdit()
                .userCode("123")   // TODO
                .nameCardProduct((String) realProduct.get("NAME"))
                .binCardProduct((String) realProduct.get("BIN"))
                .cardProductId(convertBigDecimalToString(realProduct.get("SYS_ID")))
                .expireCardProduct(convertStringToBigDecimal(realProduct.get("VALIDITY_MONTHS")))
                .codeCardTypeCardProduct((String) realProduct.get("CARD_TYPE2"))
                .nameLangCardProduct(convertBigDecimalToString(realProduct.get("NAME_LANGUAGE_ON_THE_CARD")))
                .cardNameCardProduct((String) realProduct.get("NAME_ON_THE_CARD"))
                .urlCardProduct((String) realProduct.get("URL"))
                .isicCardProduct(convertBigDecimalToString(realProduct.get("ISIS")))
                .onlineOrderCardProduct(convertBigDecimalToBoolean(realProduct.get("ONLINE_ORDER")))
                .comissionCardProduct(convertBigDecimalToBoolean(realProduct.get("SPEC_ORDER_PROC_FEES31W32W")))
                .mainCardProduct(convertBigDecimalToBoolean(realProduct.get("RELEASE_AS_MAIN")))
                .virtualOperationCardProduct(convertBigDecimalToBoolean(realProduct.get("POSSIB_DEPOSIT_ISSUE_VIRT_TERM")))
                .banProlongCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB_CARD_RENEWAL")))
                .banReemisionCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB_CARD_REPLACEMENT")))
                .additionalCardProduct(convertBigDecimalToBoolean(realProduct.get("RELEASE_AS_ADDITIONAL")))
                .cashbackCardProduct(convertBigDecimalToBoolean(realProduct.get("AVAILABLE_FOR_CASHBACK")))
                .dispatchPinCardProduct(convertBigDecimalToBoolean(realProduct.get("PIN_CVV_SMS_SENDING")))
                .analysisNonCashTurnoverCardProduct(convertBigDecimalToBoolean(realProduct.get("ANALYSIS_B_N_REVOLUTIONS")))
                .megatransactorCardProduct(convertBigDecimalToBoolean(realProduct.get("PART_ACT_MEGATRANSFORMER")))
                .banGiveMoneyCardProduct(convertBigDecimalToBoolean(realProduct.get("FORBID_CASH_FROM_CARD_ACC")))
                .doNotIncludeDocumentsCardProduct(convertBigDecimalToBoolean(realProduct.get("NOTINCLUDE_CARD_ACCAGR_DAYLIST")))
                .notChangeCardAtTheCardPackageInIBCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB_REPLAC_CARD_PUMP_CARD")))
                .manyFunctionalCardsCardProduct(convertBigDecimalToBoolean(realProduct.get("MIIK")))
                .customDesignCardProduct(convertBigDecimalToBoolean(realProduct.get("INDIVIDUAL_DESIGN")))
                .customDeliveryCardProduct(convertBigDecimalToBoolean(realProduct.get("DELIVERY")))
                .cancelCompareVspomCardProduct(convertBigDecimalToBoolean(realProduct.get("CANCEL_CHECK_SUBCARD")))
                .saveCardNameVspomCardProduct(convertBigDecimalToBoolean(realProduct.get("SAVE_CARD_NAME_REPLAC_AUXCARD")))
                .banOperationInternetCardProduct(convertBigDecimalToBoolean(realProduct.get("NOINTERNET_OPT_AVAILABLE")))
                .freeVeiwBalanceCardProduct(convertBigDecimalToBoolean(realProduct.get("FREE_VIEW_BALANCE_CALLCONTCENT")))
                .allowComissionCardProduct(convertBigDecimalToBoolean(realProduct.get("ALLOW_COMMISSION_ONLINE_ORDER")))
                .applIdEmvCardProduct(convertBigDecimalToString(realProduct.get("EMV_APPID")))
                .designIdEmvCardProduct(convertBigDecimalToString(realProduct.get("EMV_DESIGNID")))
                .virtualCardProduct(convertBigDecimalToBoolean(realProduct.get("VIRTUAL_CARD")))
                .avtomaticEmissionCardProduct(convertBigDecimalToBoolean(realProduct.get("AUTOMATIC_EMISSION")))
                .dboCardProduct(convertBigDecimalToBoolean(realProduct.get("CARD_FOR_DBO")))
                .minCountCardProduct((BigDecimal) realProduct.get("MINIMUM_NUMBER_OF_CARDS"))
                .countForGenerationCardProduct((BigDecimal) realProduct.get("NUMBER_CARDS_GENERATE"))
                .allowSetLimitCardProduct(convertBigDecimalToBoolean(realProduct.get("ALLOW_SETTING_LIMITS")))
                .sumSetLimitBrisCardProduct((BigDecimal) realProduct.get("FOR_INSTALL_IN_BRIS"))
                .sumSetLimitIbCardProduct((BigDecimal) realProduct.get("FOR_INSTALL_INTERNET_BANKING"))
                .editCardNameCardProduct(convertBigDecimalToBoolean(realProduct.get("ABIL_EDIT_NAME_ON_MAP")))
                .lenCardNameCardProduct((BigDecimal) realProduct.get("NAME_LENGTH_ON_MAP"))
                .allowProlongIbCardProduct(convertBigDecimalToBoolean(realProduct.get("RENEWAL_ALLOWED")))
                .allowReemissionCardProduct(convertBigDecimalToBoolean(realProduct.get("REPLACEMENT_ALLOWED")))
                .mediaView1934CardProduct((String) realProduct.get("MEDIA_VIEW"))
                .cardView1934CardProduct((String) realProduct.get("CARD_TYPE3"))
                .socialPurpose1934CardProduct(convertBigDecimalToString(realProduct.get("SOCIAL_AFFIL_PURPOSE")))
                .dopServicesCardProduct(convertBigDecimalToString(realProduct.get("ADDITIONAL_SERVICES")))
                .kobrendovayaCardProduct(convertBigDecimalToBoolean(realProduct.get("COBRAND")))
                .contactlessCardProduct(convertBigDecimalToBoolean(realProduct.get("CONTACTLESS")))
                .optionsCardProduct(
                        new Options[] {new Options("1", true, "35581926")} // TODO
                )
                .avtomaticReplaceRateCardProduct(convertBigDecimalToBoolean(realProduct.get("AUTOMAT_INTEREST_RATE_CHANGE")))
                .rateValueCardProduct((BigDecimal) realProduct.get("BID_VALUE"))
                .transferDepositRateCardProduct(convertBigDecimalToBoolean(realProduct.get("TRANSF_RATE_RENEWING_CARD")))
                .disableAdditionalPaymentsCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB__ADDITIONAL_CONTRBTNS")))
                .noActiveDepositCardProduct(false)         // unknown
                .depositOrCreditCardProduct(new DepositOrCreditProducts[0])
                .transferCreditRateWhenProlongCardProduct(convertBigDecimalToBoolean(realProduct.get("TRANSFER_RATE_RENEW_CARD")))
                .transferCreditRateWhenLimitChangedCardProduct(convertBigDecimalToBoolean(realProduct.get("RESCHED_RATE_INCREAS_OVRDRFT")))
                .transferCreditRateWhenReplaceCardProduct(convertBigDecimalToBoolean(realProduct.get("RESCHED_RATE_REPLAC_CARD")))
                .dopProductForCardProduct(new DopProducts[0])
                .currencyProductForCardProduct(new CurrencyProducts[0])
                .fineCardProduct(new Fine[0])
                .replaceProductForProlongCardProduct(new ReplaceProductsForProlong[0])
                .replaceProductForReemisionCardProduct(new ReplaceProductsForReemision[0])
                .handReplaceProductCardProduct(new HandReplaceProduct[0])
                .minSumNonCashTurnoverCardProduct((BigDecimal) realProduct.get("MIN_AMNT_CASHLSS_TRNVR_BYN"))
                .cardServiceDiscountCardProduct((BigDecimal) realProduct.get("CARD_SERVICE_CHRG_PROC_DSCNT"))
                .isFreeCardProduct(convertBigDecimalToBoolean(realProduct.get("IS_FREE")))
                .smsTariffCardProduct(new SmsTariff[0])
                .uvkvCardProduct(new Uvkv[0])
                .groupRiskCardProduct(new GroupRisk[0])
                .megatransactorOptionsCardProduct(new MegatransactorOptions[0])
                .enterpriseCardProduct(new Enterprise[0])
                .build();
    }

    public static CardProductAdd convertRealProductToCardProductAdd(Map<String, Object> realProduct) {
        return CardProductAdd.Builder.aCardProductAdd()
                .userCode("123")   // TODO
                .nameCardProduct((String) realProduct.get("NAME"))
                .binCardProduct((String) realProduct.get("BIN"))
                .cardTypeCardProduct(convertBigDecimalToString(realProduct.get("CARD_TYPE")))
                .expireCardProduct(convertStringToBigDecimal(realProduct.get("VALIDITY_MONTHS")))
                .currencyCardProduct(convertBigDecimalToString(realProduct.get("CURRENCY")))
                .minBalanceResidentCardProduct((BigDecimal) realProduct.get("MINIMUM_BALANCE_RESIDENT"))
                .minBalanceNoResidentCardProduct((BigDecimal) realProduct.get("MINIMUM_BALANCE_NONRESIDENT"))
                .preNominalCardProduct((BigDecimal) realProduct.get("PRESET_DENOMINATION"))
                .codeCardTypeCardProduct((String) realProduct.get("CARD_TYPE2"))
                .nameLangCardProduct(convertBigDecimalToString(realProduct.get("NAME_LANGUAGE_ON_THE_CARD")))
                .cardNameCardProduct((String) realProduct.get("NAME_ON_THE_CARD"))
                .urlCardProduct((String) realProduct.get("URL"))
                .isicCardProduct(convertBigDecimalToString(realProduct.get("ISIS")))
                .onlineOrderCardProduct(convertBigDecimalToBoolean(realProduct.get("ONLINE_ORDER")))
                .comissionCardProduct(convertBigDecimalToBoolean(realProduct.get("SPEC_ORDER_PROC_FEES31W32W")))
                .mainCardProduct(convertBigDecimalToBoolean(realProduct.get("RELEASE_AS_MAIN")))
                .virtualOperationCardProduct(convertBigDecimalToBoolean(realProduct.get("POSSIB_DEPOSIT_ISSUE_VIRT_TERM")))
                .banProlongCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB_CARD_RENEWAL")))
                .banReemisionCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB_CARD_REPLACEMENT")))
                .additionalCardProduct(convertBigDecimalToBoolean(realProduct.get("RELEASE_AS_ADDITIONAL")))
                .cashbackCardProduct(convertBigDecimalToBoolean(realProduct.get("AVAILABLE_FOR_CASHBACK")))
                .dispatchPinCardProduct(convertBigDecimalToBoolean(realProduct.get("PIN_CVV_SMS_SENDING")))
                .analysisNonCashTurnoverCardProduct(convertBigDecimalToBoolean(realProduct.get("ANALYSIS_B_N_REVOLUTIONS")))
                .megatransactorCardProduct(convertBigDecimalToBoolean(realProduct.get("PART_ACT_MEGATRANSFORMER")))
                .banGiveMoneyCardProduct(convertBigDecimalToBoolean(realProduct.get("FORBID_CASH_FROM_CARD_ACC")))
                .doNotIncludeDocumentsCardProduct(convertBigDecimalToBoolean(realProduct.get("NOTINCLUDE_CARD_ACCAGR_DAYLIST")))
                .notChangeCardAtTheCardPackageInIBCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB_REPLAC_CARD_PUMP_CARD")))
                .manyFunctionalCardsCardProduct(convertBigDecimalToBoolean(realProduct.get("MIIK")))
                .customDesignCardProduct(convertBigDecimalToBoolean(realProduct.get("INDIVIDUAL_DESIGN")))
                .customDeliveryCardProduct(convertBigDecimalToBoolean(realProduct.get("DELIVERY")))
                .cancelCompareVspomCardProduct(convertBigDecimalToBoolean(realProduct.get("CANCEL_CHECK_SUBCARD")))
                .saveCardNameVspomCardProduct(convertBigDecimalToBoolean(realProduct.get("SAVE_CARD_NAME_REPLAC_AUXCARD")))
                .banOperationInternetCardProduct(convertBigDecimalToBoolean(realProduct.get("NOINTERNET_OPT_AVAILABLE")))
                .freeVeiwBalanceCardProduct(convertBigDecimalToBoolean(realProduct.get("FREE_VIEW_BALANCE_CALLCONTCENT")))
                .allowComissionCardProduct(convertBigDecimalToBoolean(realProduct.get("ALLOW_COMMISSION_ONLINE_ORDER")))
                .applIdEmvCardProduct(convertBigDecimalToString(realProduct.get("EMV_APPID")))
                .designIdEmvCardProduct(convertBigDecimalToString(realProduct.get("EMV_DESIGNID")))
                .virtualCardProduct(convertBigDecimalToBoolean(realProduct.get("VIRTUAL_CARD")))
                .avtomaticEmissionCardProduct(convertBigDecimalToBoolean(realProduct.get("AUTOMATIC_EMISSION")))
                .dboCardProduct(convertBigDecimalToBoolean(realProduct.get("CARD_FOR_DBO")))
                .minCountCardProduct((BigDecimal) realProduct.get("MINIMUM_NUMBER_OF_CARDS"))
                .countForGenerationCardProduct((BigDecimal) realProduct.get("NUMBER_CARDS_GENERATE"))
                .allowSetLimitCardProduct(convertBigDecimalToBoolean(realProduct.get("ALLOW_SETTING_LIMITS")))
                .sumSetLimitBrisCardProduct((BigDecimal) realProduct.get("FOR_INSTALL_IN_BRIS"))
                .sumSetLimitIbCardProduct((BigDecimal) realProduct.get("FOR_INSTALL_INTERNET_BANKING"))
                .editCardNameCardProduct(convertBigDecimalToBoolean(realProduct.get("ABIL_EDIT_NAME_ON_MAP")))
                .lenCardNameCardProduct((BigDecimal) realProduct.get("NAME_LENGTH_ON_MAP"))
                .allowProlongIbCardProduct(convertBigDecimalToBoolean(realProduct.get("RENEWAL_ALLOWED")))
                .allowReemissionCardProduct(convertBigDecimalToBoolean(realProduct.get("REPLACEMENT_ALLOWED")))
                .mediaView1934CardProduct((String) realProduct.get("MEDIA_VIEW"))
                .cardView1934CardProduct((String) realProduct.get("CARD_TYPE3"))
                .socialPurpose1934CardProduct(convertBigDecimalToString(realProduct.get("SOCIAL_AFFIL_PURPOSE")))
                .dopServicesCardProduct(convertBigDecimalToString(realProduct.get("ADDITIONAL_SERVICES")))
                .kobrendovayaCardProduct(convertBigDecimalToBoolean(realProduct.get("COBRAND")))
                .contactlessCardProduct(convertBigDecimalToBoolean(realProduct.get("CONTACTLESS")))
                .optionsCardProduct(
                        new Options[] {new Options("1", true, "35581926")} // TODO
                )
                .avtomaticReplaceRateCardProduct(convertBigDecimalToBoolean(realProduct.get("AUTOMAT_INTEREST_RATE_CHANGE")))
                .rateValueCardProduct((BigDecimal) realProduct.get("BID_VALUE"))
                .transferDepositRateCardProduct(convertBigDecimalToBoolean(realProduct.get("TRANSF_RATE_RENEWING_CARD")))
                .disableAdditionalPaymentsCardProduct(convertBigDecimalToBoolean(realProduct.get("PROHIB__ADDITIONAL_CONTRBTNS")))
                .noActiveDepositCardProduct(false)         // unknown
                .depositOrCreditCardProduct(new DepositOrCreditProducts[0])
                .transferCreditRateWhenProlongCardProduct(convertBigDecimalToBoolean(realProduct.get("TRANSFER_RATE_RENEW_CARD")))
                .transferCreditRateWhenLimitChangedCardProduct(convertBigDecimalToBoolean(realProduct.get("RESCHED_RATE_INCREAS_OVRDRFT")))
                .transferCreditRateWhenReplaceCardProduct(convertBigDecimalToBoolean(realProduct.get("RESCHED_RATE_REPLAC_CARD")))
                .dopProductForCardProduct(new DopProducts[0])
                .currencyProductForCardProduct(new CurrencyProducts[0])
                .fineCardProduct(new Fine[0])
                .replaceProductForProlongCardProduct(new ReplaceProductsForProlong[0])
                .replaceProductForReemisionCardProduct(new ReplaceProductsForReemision[0])
                .handReplaceProductCardProduct(new HandReplaceProduct[0])
                .minSumNonCashTurnoverCardProduct((BigDecimal) realProduct.get("MIN_AMNT_CASHLSS_TRNVR_BYN"))
                .cardServiceDiscountCardProduct((BigDecimal) realProduct.get("CARD_SERVICE_CHRG_PROC_DSCNT"))
                .isFreeCardProduct(convertBigDecimalToBoolean(realProduct.get("IS_FREE")))
                .smsTariffCardProduct(new SmsTariff[0])
                .uvkvCardProduct(
                        new Uvkv[] {new Uvkv("35581951", "32486060", false)} // TODO
                )
                .groupRiskCardProduct(
                        new GroupRisk[] {new GroupRisk("32192468", true)}
                )
                .megatransactorOptionsCardProduct(new MegatransactorOptions[0])
                .enterpriseCardProduct(new Enterprise[0])
                .packageIdProduct("123")  // TODO
                .build();
    }

    public static DepositProductAddRequest convertRealProductToDepositProductAddRequest(Map<String, Object> realProduct) {
        return DepositProductAddRequest.Builder.aDepositProductAddRequest()
                .codeDepProduct((String) realProduct.get("CODE"))
                .typeDepProduct(convertStringToBigDecimal(realProduct.get("PRODUCT_TYPE")))
                .classifierDepProduct(convertBigDecimalToString(realProduct.get("CLASS_CODE")))
                .nameDepProduct((String) realProduct.get("PRODUCT_NAME"))
                .annulDepProduct(convertBigDecimalToBoolean(realProduct.get("ISREVOKE")))
                .currencyDepProduct((String) realProduct.get("CURRENCY_CODE"))
                .typePercentDepProduct((BigDecimal) realProduct.get("INTEREST_RATE_TYPE"))
                .typeBaseDepProduct((BigDecimal) realProduct.get("BASE_VALUE_TYPE"))
                .viewPercentDepProduct((BigDecimal) realProduct.get("INTEREST_RATE_KIND"))
                .sumCloseDepProduct((BigDecimal) realProduct.get("CLOSING_AMOUNT"))
                .procCloseDepProduct((BigDecimal) realProduct.get("CLOSING_PROC"))
                .termTypeDepProduct(convertStringToBigDecimal(realProduct.get("TERM_UNIT")))
                .termDepProduct((BigDecimal) realProduct.get("TERM"))
                .capitalizationDepProduct((BigDecimal) realProduct.get("OBTAINING_PROC_METHOD"))
                .accountCardDepProduct(convertBigDecimalToBoolean(realProduct.get("IS_CARD_PROC")))
                .currencyLimitDepProduct(convertBigDecimalToString(realProduct.get("LIMIT_CURRENCY")))
                .minSumDepProduct((BigDecimal) realProduct.get("MINIMUM_DEPOSIT_AMOUNT"))
                .renewalSumDepProduct((BigDecimal) realProduct.get("REFILL_MIN_AMOUNT"))
                .maxRenewalSumDepProduct((BigDecimal) realProduct.get("REFILL_MAX_AMOUNT"))
                .withdrawalTypeDepProduct(convertStringToBigDecimal(realProduct.get("PARTIAL_ISSUANCE")))
                .linkedAccountDepProduct(convertBigDecimalToBoolean(realProduct.get("HAVING_LINKED_ACCOUNT")))
                .closeToCurrentDepProduct(convertBigDecimalToBoolean(realProduct.get("ONLY_CURRENT_CLOSE")))
                .extraDepProduct(convertBigDecimalToBoolean(realProduct.get("ADDITIONAL_INFORMATION")))
                .otherFaceDepProduct(convertBigDecimalToBoolean(realProduct.get("OTHER_PERSON")))
                .invalidChildDepProduct(convertBigDecimalToBoolean(realProduct.get("OPEN_FOR_DISABLED_CHILD")))
                .representDepProduct(convertBigDecimalToBoolean(realProduct.get("AUTHORIZED_REPRESENTATIVE")))
                .ibOpenDepProduct(convertBigDecimalToBoolean(realProduct.get("OPENING_IB")))
                .taxDepProduct(convertBigDecimalToBoolean(realProduct.get("INCOME_TAX_CALC")))
                .smsDiscDepProduct(convertBigDecimalToBoolean(realProduct.get("SMS_NOTIF_DISCOUNT")))
                .smsDiscSizeDepProduct((BigDecimal) realProduct.get("DISCOUNT_AMOUNT"))
                .currentSumDepProduct((BigDecimal) realProduct.get("POSTE_RESTANT_PROC"))
                .termRenewalTypeDepProduct(convertStringToBigDecimal(realProduct.get("REFILL_TERM_UNIT")))
                .termRenewalDepProduct((BigDecimal) realProduct.get("REFILL_TERM"))
                .withdrawalPeriodDepProduct(convertStringToBigDecimal(realProduct.get("PARTIAL_FREQ_ISSUE")))
                .withdrawalSumDepProduct((BigDecimal) realProduct.get("PARTIAL_ISSUE_AMOUNT"))
                .withdrawalMinBalanceDepProduct((BigDecimal) realProduct.get("PARTIAL_ISSUE_MIN_BALANCE"))
                .withdrawalPercentDepProduct((BigDecimal) realProduct.get("PARTIAL_ISSUE_MIN_PROC"))
                .withdrawalSumMaxDepProduct(convertBigDecimalToBoolean(realProduct.get("PART_ISSUE_MORE_MONTH")))
                .withdrawalProhibitedDepProduct(convertBigDecimalToBoolean(realProduct.get("PART_ISSUE_DENIED")))
                .withdrawalTermTypDepProduct(convertBigDecimalToBoolean(convertStringToBigDecimal(realProduct.get("PART_ISSUE_TERM_UNIT"))))
                .withdrawalTermDepProduct((BigDecimal) realProduct.get("PART_REFILL_TERM"))
                .formDepProduct((String) realProduct.get("CONTRACT_FORM"))
                .userCode("ivanov_i.developers.lwo.org")    // TODO
                .renewalPeriodDepProduct(new BigDecimal(1))  // TODO
                .legalrepresentDepProduct(false)    // TODO
                .prohibManualOpenDepProduct(false)// TODO
                .prohibManualCloseDepProduct(false)// TODO
                .isCancelPeriodDepProduct(false)// TODO
                .cancelPeriodDepProduct(new BigDecimal(12))// TODO
                .build();

    }

    public static Boolean convertBigDecimalToBoolean(Object object) {
        if (object != null) {
            BigDecimal bigDecimalObject = (BigDecimal) object;
            return bigDecimalObject.equals(new BigDecimal("0"));
        }
        return false;
    }

    public static String convertBigDecimalToString(Object object) {
        if (object != null) {
            BigDecimal bigDecimalObject = (BigDecimal) object;
            return String.valueOf(bigDecimalObject);
        }
        return null;
    }

    public static String convertIntegerToString(Object object) {
        if (object != null) {
            Integer integerObject = (Integer) object;
            return String.valueOf(integerObject);
        }
        return null;
    }

    public static String convertLongToString(Object object) {
        if (object != null) {
            Long longObject = (Long) object;
            return String.valueOf(longObject);
        }
        return null;
    }

    public static BigDecimal convertStringToBigDecimal(Object object) {
        if (object != null) {
            String stringObject = (String) object;
            int integerObject = Integer.parseInt(stringObject);
            return BigDecimal.valueOf(integerObject);
        }
        return null;
    }

    public static DimItem convertRealProductToUrDepDimItem(Map<String, Object> realProduct) {
        DimItem dimItem = new DimItem();
        dimItem.setCode((String) realProduct.get("CODE"));
        dimItem.setDimType("URDEP");
        dimItem.setName((String) realProduct.get("NAME"));
        dimItem.setUserCode("xodorcova_ei@belinvestbank.by");
        for (Map.Entry<String, Object> entry : realProduct.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("DEP")) {
                Attribute attribute = new Attribute();
                attribute.setName(key);
                attribute.setValue(String.valueOf(entry.getValue()));
                dimItem.addAttribute(key, attribute);
            }
        }
        return dimItem;
    }

    public static DimItem convertRealProductToUrCredDimItem(Map<String, Object> realProduct) {
        DimItem dimItem = new DimItem();
        dimItem.setCode((String) realProduct.get("CODE"));
        dimItem.setDimType("URKRED");
        dimItem.setName((String) realProduct.get("NAME"));
        dimItem.setUserCode("xodorcova_ei@belinvestbank.by");
        for (Map.Entry<String, Object> entry : realProduct.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("UR") || key.startsWith("CLOSE")) {
                Attribute attribute = new Attribute();
                attribute.setName(key);
                attribute.setValue(String.valueOf(entry.getValue()));
                dimItem.addAttribute(key, attribute);
            }
        }
        return dimItem;
    }

}
