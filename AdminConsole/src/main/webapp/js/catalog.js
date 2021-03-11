$('#nsi-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.nsi-directory-page-buttons button').removeAttr('disabled');
});




$('.view-catalog-modal-button').on('click', function () {
    var $nsiEntryRow = $('#nsi-table').find('.selected');
    var busInitId = '';
    var busOffId = '';
    var busProdCardId = '';
    $nsiEntryRow.find('[class=busInitId').each(function () {
        busInitId = $(this).text();
    });
    $nsiEntryRow.find('[class=busOffId').each(function () {
        busOffId = $(this).text();
    });
    $nsiEntryRow.find('[class=busProdCardId').each(function () {
        busProdCardId = $(this).text();
    });
    console.log(busInitId);
    console.log(busOffId);
    console.log(busProdCardId);

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify({bIId : busInitId}),
        url:"/belinvest/admin/catalog/reestr/getBusinessInitiative",
        success: function (data) {
            JSON.stringify(data);
            console.log(JSON.stringify(data))
            console.log(JSON.stringify(data.productDeveloperDept))
            $("#busInit").find('[name=ADDINFO]').text(JSON.stringify(data.businessInitiative.addInfo).replace(/\"/g,''));
            $("#busInit").find('[name=BUSINESSAPPIMPLDATE]').text(JSON.stringify(data.businessInitiative.businessAppimplDate).replace(/\"/g,''));
            $("#busInit").find('[name=BIDATE]').text(JSON.stringify(data.businessInitiative.biDate).replace(/\"/g,''));
            $("#busInit").find('[name=IMPLPLANNINGDATE]').text(JSON.stringify(data.businessInitiative.implPlanningDate).replace(/\"/g,''));
            $("#busInit").find('[name=JOBTYPES]').text(JSON.stringify(data.businessInitiative.jobTypes).replace(/\"/g,''));
            $("#busInit").find('[name=MARKETANALISYS]').text(JSON.stringify(data.businessInitiative.marketAnalisys).replace(/\"/g,''));
            $("#busInit").find('[name=MARKETANALISYSFILE]').text(JSON.stringify(data.businessInitiative.marketAnalisysFile).replace(/\"/g,''));
            $("#busInit").find('[name=BINAME]').text(JSON.stringify(data.businessInitiative.biName).replace(/\"/g,''));
            $("#busInit").find('[name=NONREALIZEEFFECTS]').text(JSON.stringify(data.businessInitiative.nonRealizeEffects).replace(/\"/g,''));
            $("#busInit").find('[name=PLANGRAPHICDATE]').text(JSON.stringify(data.businessInitiative.planGraphicDate).replace(/\"/g,''));
            $("#busInit").find('[name=BIPOINT]').text(JSON.stringify(data.businessInitiative.biPoint).replace(/\"/g,''));
            $("#busInit").find('[name=PRODUCT]').text(JSON.stringify(data.businessInitiative.product).replace(/\"/g,''));
            $("#busInit").find('[name=PRODUCTDEVELOPERDEPT]').text(JSON.stringify(data.businessInitiative.productDeveloperDept).replace(/\"/g,''));
            $("#busInit").find('[name=PRODUCTDEVELOPERFIO]').text(JSON.stringify(data.businessInitiative.productDeveloperFio).replace(/\"/g,''));
            $("#busInit").find('[name=REALIZEPROSPECTIVE]').text(JSON.stringify(data.businessInitiative.realizeProspective).replace(/\"/g,''));
            $("#busInit").find('[name=BISTATUS]').text(JSON.stringify(data.businessInitiative.biStatus).replace(/\"/g,''));
        }
    });

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify({bOId : busOffId}),
        url: "/belinvest/admin/catalog/reestr/getBusinessOffer",
        success: function (data) {
            JSON.stringify(data);
            console.log(JSON.stringify(data))
            $("#busOffer").find('[name=BONAME]').text(JSON.stringify(data.businessOffer.boName).replace(/\"/g,''));
            $("#busOffer").find('[name=BOSTATUS]').text(JSON.stringify(data.businessOffer.boStatus).replace(/\"/g,''));
            $("#busOffer").find('[name=PRODUCTMANAGER]').text(JSON.stringify(data.businessOffer.productManeger).replace(/\"/g,''));
            $("#busOffer").find('[name=PRODUCTMANAGERPOSITION]').text(JSON.stringify(data.businessOffer.productManegerPosition).replace(/\"/g,''));
            $("#busOffer").find('[name=PRODUCTMANAGERPHONE]').text(JSON.stringify(data.businessOffer.productManegerPhone).replace(/\"/g,''));
            $("#busOffer").find('[name=PRODUCTMANAGERDEPT]').text(JSON.stringify(data.businessOffer.productManegerDept).replace(/\"/g,''));
            $("#busOffer").find('[name=PRODUCTMANAGERSUPERVISOR]').text(JSON.stringify(data.businessOffer.productManegerSupervisor).replace(/\"/g,''));
            $("#busOffer").find('[name=PRODUCTMANAGERSUPERVISORPOS]').text(JSON.stringify(data.businessOffer.productManegerSupervisorPos).replace(/\"/g,''));
            $("#busOffer").find('[name=PRODUCTMANAGERSUPERVISORPHONE]').text(JSON.stringify(data.businessOffer.productManegerSupervisorPhone).replace(/\"/g,''));
        }
    });

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify({bPCId : busProdCardId}),
        url:"/belinvest/admin/catalog/reestr/getBPCard",
        success: function (data) {
            JSON.stringify(data);
            console.log(JSON.stringify(data))
            $("#bpCard").find('[name=PRODUCTNAME]').text(JSON.stringify(data.bpCard.productName).replace(/\"/g,''));
            $("#bpCard").find('[name=PRODUCTSTATUS]').text(JSON.stringify(data.bpCard.productStatus).replace(/\"/g,''));
            $("#bpCard").find('[name=COMMONPRODUCTCHARS]').text(JSON.stringify(data.bpCard.commonProductChars).replace(/\"/g,''));
            $("#bpCard").find('[name=CHANGESTATUSDATE]').text(JSON.stringify(data.bpCard.changeStatusDate).replace(/\"/g,''));
            $("#bpCard").find('[name=PRODUCTADVANTAGES]').text(JSON.stringify(data.bpCard.productAdvantages).replace(/\"/g,''));
            $("#bpCard").find('[name=MAINPRODUCTPARAMS]').text(JSON.stringify(data.bpCard.mainProductParams).replace(/\"/g,''));
            $("#bpCard").find('[name=DOCSFORMS]').text(JSON.stringify(data.bpCard.docsForms).replace(/\"/g,''));
            $("#bpCard").find('[name=LPABANKS]').text(JSON.stringify(data.bpCard.lbaBanks).replace(/\"/g,''));
            $("#bpCard").find('[name=ADDMATERIALS]').text(JSON.stringify(data.bpCard.addMaterials).replace(/\"/g,''));
        }
    });

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify({bPCId : busProdCardId}),
        url:"/belinvest/admin/catalog/reestr/getProduct",
        success: function (data) {
            var v =  data.msg
            console.log(JSON.stringify(v))
            $("#PROD").text(v);
        }
    });


    $('.invalid-data').removeClass('invalid-data');
    $('.view-catalog-entry-modal').modal('show');

});

$('.modern-product-catalog-modal-button').on('click', function () {
    var answer = window.confirm('Запустить процесс "модернизировать продукт"?"');

    if (answer) {
        var $nsiEntryRow = $('#nsi-table').find('.selected');
        var busInitId = '';
        var busOffId = '';
        var busProdCardId = '';
        $nsiEntryRow.find('[class=busInitId').each(function () {
            busInitId = $(this).text();
        });
        $nsiEntryRow.find('[class=busOffId').each(function () {
            busOffId = $(this).text();
        });
        $nsiEntryRow.find('[class=busProdCardId').each(function () {
            busProdCardId = $(this).text();
        });

        $.ajax({
            contentType: 'application/json',
            dataType: "json",
            type: "POST",
            data: JSON.stringify({kbpid : busProdCardId,
                                        bOId : busOffId}),
            url: "/belinvest/admin/catalog/reestr/modern-product",
            success: function (data) {
                openRequestedPopup();
                alert(data.msg);
                openRequestedPopup();
            },
            error: function (response) {
                var json = response.responseText;
                var r = JSON.parse(json);

                alert('ошибка')
                alert(r.msg)
            }
        });

    }
});

$('.modify-product-catalog-modal-button').on('click', function () {

    var answer = window.confirm('Запустить процесс "модифицировать продукт"?"');
    if (answer) {
        var $nsiEntryRow = $('#nsi-table').find('.selected');
        var busInitId = '';
        var busOffId = '';
        var busProdCardId = '';
        $nsiEntryRow.find('[class=busInitId').each(function () {
            busInitId = $(this).text();
        });
        $nsiEntryRow.find('[class=busOffId').each(function () {
            busOffId = $(this).text();
        });
        $nsiEntryRow.find('[class=busProdCardId').each(function () {
            busProdCardId = $(this).text();
        });

        $.ajax({
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify({kbpid : busProdCardId,
                bOId : busOffId}),
            type: "POST",
            url: "/belinvest/admin/catalog/reestr/modify-product",
            success: function (data) {
                openRequestedPopup();
                alert(data.msg);
                openRequestedPopup();
            },
            error: function (response) {
                var json = response.responseText;
                var r = JSON.parse(json);

                alert('ошибка')
                alert(r.msg)
            }
        });

    }
});

$('.destroy-product-catalog-modal-button').on('click', function () {
    var answer = window.confirm('Запустить процесс "ликвидировать продукт"?"');

    if (answer) {
        var $nsiEntryRow = $('#nsi-table').find('.selected');
        var busInitId = '';
        var busOffId = '';
        var busProdCardId = '';
        $nsiEntryRow.find('[class=busInitId').each(function () {
            busInitId = $(this).text();
        });
        $nsiEntryRow.find('[class=busOffId').each(function () {
            busOffId = $(this).text();
        });
        $nsiEntryRow.find('[class=busProdCardId').each(function () {
            busProdCardId = $(this).text();
        });

        $.ajax({
            contentType: 'application/json',
            dataType: "json",
            type: "POST",
            data: JSON.stringify({kbpid : busProdCardId,
                bOId : busOffId}),
            url: "/belinvest/admin/catalog/reestr/destroy-product",
            success: function (data) {
                openRequestedPopup();
                alert(data.msg);
                openRequestedPopup();

                window.location.replace("");

            },
            error: function (response) {
                alert('ошибка')
                var json = response.responseText;
                var r = JSON.parse(json);
                alert(r.msg)
            }
        });
    }
});




$(".view-cancel-catalog-entry-button").on('click', function () {
    $('.view-catalog-entry-modal').modal('hide');
});

$(document).ready(function(){
    $("#liA1").mouseover(function(){
        $("#liA1").css("color", "white");
    });
    $("#liA2").mouseover(function(){
        $("#liA2").css("color", "white");
    });
    $("#liA3").mouseover(function(){
        $("#liA3").css("color", "white");
    });
});

function openRequestedPopup() {
    windowObjectReference = window.open("http://soabpm-server:7004/bpm/workspace/faces/jsf/worklist/worklist.jspx", '_blank');
}

function showBI(busInitId) {

    windowObjectReference = window.open("/belinvest/admin/catalog/reestr/bi?biid="+busInitId+"", '_blank');

}

function showBO(busOffId) {

    windowObjectReference = window.open("/belinvest/admin/catalog/reestr/bo?boid="+busOffId+"", '_blank');

}

function showKBP(busProdCardId) {
    if (busProdCardId ==="undefined"){
        return;
    }

    windowObjectReference = window.open("/belinvest/admin/catalog/reestr/kbp?kbpid="+busProdCardId+"", '_blank');

}

function showProdJson(name) {
    if (name =="undefined"){
        return
    }

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "GET",
        url: "http://soabpm-server:7004/products/"+name+"",
        success: function (data) {
            let productTable = $('#real-product-info-block');
            $(productTable).find('.product-name-block .product-name').text(data.productName);

            $(productTable).find('.DEPENDS_OVERNIGHT_RATE').text(data.dependsOvernightRate);
            $(productTable).find('.DEPEND_BASIC_DEBT_RATE_90D').text(data.dependBasicDebtRate90D);
            $(productTable).find('.DEPEND_BASIC_DEBT_RATE_180D').text(data.dependBasicDebtRate180D);
            $(productTable).find('.DEPEND_BASIC_DEBT_RATE_MORE').text(data.ependBasicDebtRateMore);
            $(productTable).find('.DEPEND_RATE_ANOTHER_KP').text(data.dependRateAnotherKp);
            $(productTable).find('.FIXED_RATE_ABSOLUTE_VALUE').text(data.fixedRateAbsoluteValue);
            $(productTable).find('.MIN_DEBT_RATE_SET').text(data.minDebtRateSet);
            $(productTable).find('.LOAN_TERM_MONTHS').text(data.loanTermMonths);
            $(productTable).find('.LOAN_REPAY_TERM_MONTHS').text(data.loanRepayTermMonths);
            $(productTable).find('.LOAN_DEV_PERIOD_MONTHS').text(data.loanDevPeriodMonths);
            $(productTable).find('.LOAN_REPAYMENT_DATE').text(data.loanRepaymentDate);
            $(productTable).find('.ANNUITY_SCHEDULE_FORM').text(data.annuityScheduleForm);
            $(productTable).find('.LOAN_REPAY_CONCLUS_CNTRCT').text(data.loanRepayConclusCntrct);
            $(productTable).find('.OVERDRAFT_TRNVR_DAYS').text(data.overdraftTrnvrDays);
            $(productTable).find('.TYPE_GUARANTEE').text(data.typeGuarantee);
            $(productTable).find('.TYPE_GUARANTEE_GUARANTEE').text(data.typeGuaranteeGuarantee);
            $(productTable).find('.TYPE_COLLATERAL').text(data.typeCollateral);
            $(productTable).find('.TYPE_GUARANTEE_COLLATERAL').text(data.typeGuaranteeCollateral);
            $(productTable).find('.PROVIDING_FORFEIT').text(data.providingForfeit);
            $(productTable).find('.OVERDUE_RATE_COEFFICIENT').text(data.overdueRateCoefficient);
            $(productTable).find('.INTRST_OVERDUE_PROC').text(data.intrstOverdueProc);
            $(productTable).find('.PENALTY_ARREARS_PROC').text(data.penaltyArrearsProc);
            $(productTable).find('.DURAT_EXTENSION_MONTHS').text(data.duratExtensionMonths);
            $(productTable).find('.INTEREST_RATE').text(data.interestRate);
            $(productTable).find('.GRACE_PERIOD_NUM_DAYS').text(data.gracePeriodNumDays);
            $(productTable).find('.PREFERENTIAL_RATE_PROC').text(data.preferentialRateProc);
            $(productTable).find('.DEBGRACE_PERIOD_NUMBERD').text(data.debgracePeriodNumberd);
            $(productTable).find('.DEB_GRACE_PREF_RATE').text(data.debGracePrefRate);
            $(productTable).find('.PREF_RATE_PROC').text(data.prefRateProc);
            $(productTable).find('.REFIN_RATE_DEPEND').text(data.refinRateDepend);
            $(productTable).find('.OVERNIGHT_RATE_DEPEND').text(data.overnightRateDepend);
            $(productTable).find('.TYPES_OPERATIONS').text(data.typesOperations);
            $(productTable).find('.GRACE_PERIOD_MONTHS').text(data.gracePeriodMonths);
            $(productTable).find('.DEPEND_REFOVRN_RATE').text(data.dependRefovrnRate);
            $(productTable).find('.PREFERENTIAL_RATE').text(data.preferentialRate);
            $(productTable).find('.LOAN_AGR_DOCUMENTS').text(data.loanAgrDocuments);
            $(productTable).find('.LOAN_AGR_DOCUMENTS_NUM').text(data.loanAgrDocumentsNum);
            $(productTable).find('.WARRANT_AGR_DOCUMENTS').text(data.warrantAgrDocuments);
            $(productTable).find('.WARRANT_AGR_DOCUMENTS_NUM').text(data.warrantAgrDocumentsNum);
            $(productTable).find('.PLEDGE_AGR_DOCUMENTS').text(data.pledgeAgrDocuments);
            $(productTable).find('.DEC_CODES_LOAN_PURPOSE').text(data.decCodesLoanPurpose);
            $(productTable).find('.NEW_CONVEYOR').text(data.newConveyor);
            $(productTable).find('.RULES_ANALYSIS').text(data.rulesAnalysis);
            $(productTable).find('.KBB_HISTORY_ANALYSIS').text(data.kbbHistoryAnalysis);
            $(productTable).find('.ISS_DATA_ANALYSIS').text(data.issDataAnalysis);
            $(productTable).find('.LIST_ANALYSIS').text(data.listAnalysis);
            $(productTable).find('.SECURITY').text(data.security);
            $(productTable).find('.SECURITY_FORCED').text(data.securityForced);
            $(productTable).find('.VERIFIERS').text(data.verifiers);
            $(productTable).find('.VERIFIERS_FORCED').text(data.verifiersForced);
            $(productTable).find('.SCORING').text(data.scoring);
            $(productTable).find('.RISK_MANAGERS').text(data.riskManagers);
            $(productTable).find('.RISK_MANAGERS_FORCED').text(data.riskManagersForced);
            $(productTable).find('.SCORING_MODE').text(data.scoringMode);
            $(productTable).find('.PROMOT_INTERACT_WEEKS').text(data.promotInteractWeeks);
            $(productTable).find('.TYPE_CONTRACT_OVERDRAFT').text(data.typeContractOverdraft);
            $(productTable).find('.TYPE_INSTALLMENT_AGREEMENT').text(data.typeInstallmentAgreement);
            $(productTable).find('.TYPE_AGREEMENT_EXPRESS_LOAN').text(data.typeAgreementExpressLoan);
            $(productTable).find('.TYPE_AGREEMENT_POSLOAN').text(data.typeAgreementPosloan);
            $(productTable).find('.TYPECONTRACT_INT_BANKING').text(data.typecontractIntBanking);
            $(productTable).find('.TYPE_CONTRACT_ONLINE').text(data.typeContractOnline);
            $(productTable).find('.CHOOSING_GROUP_PRODUCT').text(data.choosingGroupProduct);
            $(productTable).find('.PRODUCT_CODE').text(data.productCode);
            $(productTable).find('.BANK_CLASSIFIER_PROD_CODE').text(data.bankClassifierProdCode);
            $(productTable).find('.PRODUCT_NAME').text(data.productName);
            $(productTable).find('.PURPOSE_LOAN').text(data.purposeLoan);
            $(productTable).find('.PRINCIPAL_DEBT_ACCOUNT').text(data.principalDebtAccount);
            $(productTable).find('.PRINCIPAL_DEBT_ACCOUNT_1Y').text(data.principalDebtAccount1Y);
            $(productTable).find('.LOAN_CURRENCY').text(data.loanCurrency);
            $(productTable).find('.ISSUING_METHOD').text(data.issuingMethod);
            $(productTable).find('.LOAN_FORM').text(data.loanForm);
            $(productTable).find('.INTEREST_RATE_TYPE').text(data.interestRateType);
            $(productTable).find('.PROPERTY').text(data.property);
            $(productTable).find('.ISSUE_LIMIT').text(data.issueLimit);
            $(productTable).find('.MAXIMUM_ISSUE_AMOUNT').text(data.maximumIssueAmount);
            $(productTable).find('.ONETIME_COMMISSION_BYN').text(data.onetimeCommissionByn);
            $(productTable).find('.COMM_ISSUING_LOAN_NATION_CUR').text(data.commIssuingLoanNationCur);
            $(productTable).find('.COMM_ISSUING_LOAN_FOR_CUR').text(data.commIssuingLoanForCur);
            $(productTable).find('.SOLVENCY_RATIO').text(data.solvencyRatio);
            $(productTable).find('.TYPE_CONTINGENT_LIABILITIES').text(data.typeContingentLiabilities);
            $(productTable).find('.POS_ORGANIZATION').text(data.posOrganization);
            $(productTable).find('.AUTOMATIC_DECISION_MAKING').text(data.automaticDecisionMaking);
            $(productTable).find('.SINGLE_GROUP_ACCOUNTS').text(data.singleGroupAccounts);
            $(productTable).find('.PARENT_PRODUCT_SPEC_APRTPRTNR').text(data.parentProductSpecAprtprtnr);
            $(productTable).find('.DEPENDS_REFINANCING_RATE').text(data.dependsRefinancingRate);
            $(productTable).find('.PRINCIPAL_DEBT_DEPENDENCE').text(data.principalDebtDependence);
            $(productTable).find('.OVERDUE_RATE_DEPENDENCY').text(data.overdueRateDependency);

            $(productTable).attr('hidden',false)
            window.scrollTo({top: $(productTable).offset().top, behavior: "smooth"});

            //productTable.hidden=false;
            //productTable.scrollIntoView({block: "center", behavior: "smooth"});
        },
        error: function (response) {
            var json = response.responseText;
            var r = JSON.parse(json);
            alert(r.msg)
        }
    });



    //windowObjectReference = window.open("http://soabpm-server:7004/products/"+name+"", '_blank');


}






