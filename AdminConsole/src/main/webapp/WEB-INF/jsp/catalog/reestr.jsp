<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Реестр БИ</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">


</head>
<body>

<jsp:include page="../component/main-navbar.jsp"/>
<jsp:include page="../component/side-navbar.jsp"/>

<div id="page-content">
    <div class="row justify-content-center page-title">
        <p class="display-4">Реестр БИ</p>
    </div>


    <div class="table-responsive" style="overflow: scroll; height: 500px;;margin-left:auto;margin-right:auto;">
        <table id="nsi-table" class="table table-bordered">
            <thead>
            <tr>
                <th scope="col"></th>

                <th scope="col">Название продукта</th>
                <th scope="col">Название БИ</th>
                <th scope="col">
                    <div>Статус БИ</div>
                    <div>Дата создания БИ</div>
                </th>
                <th scope="col">Название БП</th>
                <th scope="col">
                    <div>Статус БП</div>
                    <div>Дата создания БП</div>
                </th>
                <th scope="col">Название КБП</th>

                <th scope="col">Статус Продукта</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty reestrDirectory.reestrs}">
                <c:forEach items="${reestrDirectory.reestrs}" var="reestr">
                    <tr>
                        <td><input type="checkbox"></td>


                        <td onclick="showProdJson(${reestr.productId})" class="noteId"><u
                                class="uu">${reestr.productName}</u></td>
                        <td onclick="showBI(${reestr.busInitId})" class="sign"><u class="uu">${reestr.busInitName}</u>
                        </td>
                        <td class="busInitIdd">
                            <div>${reestr.busInitStatus}</div>
                            <div>${reestr.busInitDate}</div>
                        </td>
                        <td onclick="showBO(${reestr.busOffId})" class="busInitName"><u>${reestr.busInitName}</u></td>
                        <td class="busInitStatus">
                            <div>${reestr.busProdCardProductStatus}</div>
                            <div>${reestr.busOffDate}</div>
                        </td>
                        <td onclick="showKBP(${reestr.busProdCardId})" class="busInitDate">
                            <u>${reestr.busProdCardProductName}</u></td>
                        <td class="busOffIdd">${reestr.busProdCardProductStatus}</td>

                        <td hidden="true" class="busInitId">${reestr.busInitId}</td>
                        <td hidden="true" class="busOffId">${reestr.busOffId}</td>
                        <td hidden="true" class="busProdCardId">${reestr.busProdCardId}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>


    <div class="nsi-directory-page-buttons float-left" style="margin-left: 55px">
        <button type="button" class="btn modern-product-catalog-modal-button" disabled>
            Модернизировать
        </button>
    </div>

    <div class="nsi-directory-page-buttons float-left" style="margin-left: 85px">
        <button type="button" class="btn modify-product-catalog-modal-button" disabled>
            Модифицировать
        </button>
    </div>


    <div class="nsi-directory-page-buttons float-left" style="margin-left: 100px">
        <button type="button" class="btn destroy-product-catalog-modal-button" disabled>
            Ликвидировать
        </button>

    </div>

    <div class="real-product-info-block" style="margin-top: 100px" id="real-product-info-block" hidden>
        <div class="real-product-info">

            <div class="product">
                <div class="product-name-block">
                    <h3 class="product-name"></h3>
                </div>
                <table id="real-product-table" class="table table-bordered product-table">
                    <thead>
                    <tr>
                        <th scope="col">Название поля</th>
                        <th scope="col">Значение</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="fieldName" fieldname="DEPENDS_OVERNIGHT_RATE" datalength="22" datatype="NUMBER"
                            name="Зависит от ставки овернайта	: 1-да, 0-нет." id="1">Зависит от ставки овернайта :
                            1-да, 0-нет.
                        </td>
                        <td class="DEPENDS_OVERNIGHT_RATE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEPEND_BASIC_DEBT_RATE_90D" datalength="1020"
                            datatype="VARCHAR2" name="Зависимость ставки основного долга по оборотам до 90 дней" id="2">
                            Зависимость ставки основного долга по оборотам до 90 дней
                        </td>
                        <td class="DEPEND_BASIC_DEBT_RATE_90D"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEPEND_BASIC_DEBT_RATE_180D" datalength="1020"
                            datatype="VARCHAR2"
                            name="Зависимость ставки основного долга по оборотам с 91 дня по 180 день" id="3">
                            Зависимость ставки основного долга по оборотам с 91 дня по 180 день
                        </td>
                        <td class="DEPEND_BASIC_DEBT_RATE_180D"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEPEND_BASIC_DEBT_RATE_MORE" datalength="1020"
                            datatype="VARCHAR2"
                            name="Зависимость ставки основного долга (для 2101020 по оборотам свыше 181 дня) в т.ч. для овердрафтов"
                            id="4">Зависимость ставки основного долга (для 2101020 по оборотам свыше 181 дня) в т.ч. для
                            овердрафтов
                        </td>
                        <td class="DEPEND_BASIC_DEBT_RATE_MORE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEPEND_RATE_ANOTHER_KP" datalength="1020" datatype="VARCHAR2"
                            name="Зависимость от ставки другого КП" id="5">Зависимость от ставки другого КП
                        </td>
                        <td class="DEPEND_RATE_ANOTHER_KP"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="FIXED_RATE_ABSOLUTE_VALUE" datalength="22" datatype="NUMBER"
                            name="Фиксация ставки в абсолютном значении	: 1-да, 0-нет." id="6">Фиксация ставки в
                            абсолютном значении : 1-да, 0-нет.
                        </td>
                        <td class="FIXED_RATE_ABSOLUTE_VALUE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="MIN_DEBT_RATE_SET" datalength="22" datatype="NUMBER"
                            name="Установлен минимум ставки основного долга	: 1-да, 0-нет." id="7">Установлен минимум
                            ставки основного долга : 1-да, 0-нет.
                        </td>
                        <td class="MIN_DEBT_RATE_SET"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="SUBSID_UNDER_DECREE_NO240" datalength="22" datatype="NUMBER"
                            name="Субсидии в рамках Указа №240	: 1-да, 0-нет." id="8">Субсидии в рамках Указа №240 :
                            1-да, 0-нет.
                        </td>
                        <td class="SUBSID_UNDER_DECREE_NO240"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_TERM_MONTHS" datalength="1020" datatype="VARCHAR2"
                            name="Срок выдачи кредита (в месяцах)" id="9">Срок выдачи кредита (в месяцах)
                        </td>
                        <td class="LOAN_TERM_MONTHS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_REPAY_TERM_MONTHS" datalength="1020" datatype="VARCHAR2"
                            name="Срок погашения кредита (в месяцах)" id="10">Срок погашения кредита (в месяцах)
                        </td>
                        <td class="LOAN_REPAY_TERM_MONTHS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_DEV_PERIOD_MONTHS" datalength="1020" datatype="VARCHAR2"
                            name="Срок освоения кредита (в месяцах)" id="11">Срок освоения кредита (в месяцах)
                        </td>
                        <td class="LOAN_DEV_PERIOD_MONTHS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_REPAYMENT_DATE" datalength="22" datatype="NUMBER"
                            name="Число погашения кредита. справочник" id="12">Число погашения кредита. справочник
                        </td>
                        <td class="LOAN_REPAYMENT_DATE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="ANNUITY_SCHEDULE_FORM" datalength="22" datatype="NUMBER"
                            name="Формирование аннуитетного графика: 1-да, 0-нет." id="13">Формирование аннуитетного
                            графика: 1-да, 0-нет.
                        </td>
                        <td class="ANNUITY_SCHEDULE_FORM"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_REPAY_CONCLUS_CNTRCT" datalength="22" datatype="NUMBER"
                            name="Погашение кредита в день заключения договора: 1-да, 0-нет." id="14">Погашение кредита
                            в день заключения договора: 1-да, 0-нет.
                        </td>
                        <td class="LOAN_REPAY_CONCLUS_CNTRCT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="OVERDRAFT_TRNVR_DAYS" datalength="22" datatype="NUMBER"
                            name="Оборачиваемость для овердрафтов (в днях)" id="15">Оборачиваемость для овердрафтов (в
                            днях)
                        </td>
                        <td class="OVERDRAFT_TRNVR_DAYS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_GUARANTEE" datalength="22" datatype="NUMBER"
                            name='Вид гарантии. Справочник "Виды гарантии" (NSI_805)' id="16"></td>
                        <td class="TYPE_GUARANTEE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_GUARANTEE_GUARANTEE" datalength="1020" datatype="VARCHAR2"
                            name='Вид обеспечения гарантии. Справочник "Вид обеспечения" (NSI_802).' id="17">Вид обеспечения гарантии. Справочник "Вид обеспечения"
                        (NSI_802).></td>
                        <td class="TYPE_GUARANTEE_GUARANTEE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_COLLATERAL" datalength="1020" datatype="VARCHAR2"
                            name="Вид залога. Справочник Вид залога (NSI_803)." id="18">Вид залога. Справочник Вид
                            залога (NSI_803).
                        </td>
                        <td class="TYPE_COLLATERAL"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_GUARANTEE_COLLATERAL" datalength="1020"
                            datatype="VARCHAR2" name="Вид обеспечения залога. Справочник Вид обеспечения (NSI_802)."
                            id="19">Вид обеспечения залога. Справочник Вид обеспечения (NSI_802).
                        </td>
                        <td class="TYPE_GUARANTEE_COLLATERAL"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PROVIDING_FORFEIT" datalength="22" datatype="NUMBER"
                            name="Обеспечение неустойкой: 1-да, 0-нет." id="20">Обеспечение неустойкой: 1-да, 0-нет.
                        </td>
                        <td class="PROVIDING_FORFEIT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="OVERDUE_RATE_COEFFICIENT" datalength="22" datatype="NUMBER"
                            name="Коэффициент ставки по просрочке" id="21">Коэффициент ставки по просрочке
                        </td>
                        <td class="OVERDUE_RATE_COEFFICIENT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="INTRST_OVERDUE_PROC" datalength="22" datatype="NUMBER"
                            name="Пеня по просроченным процентам в %" id="22">Пеня по просроченным процентам в %
                        </td>
                        <td class="INTRST_OVERDUE_PROC"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PENALTY_ARREARS_PROC" datalength="22" datatype="NUMBER"
                            name="Неустойка по просроченной задолженности в %" id="23">Неустойка по просроченной
                            задолженности в %
                        </td>
                        <td class="PENALTY_ARREARS_PROC"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DURAT_EXTENSION_MONTHS" datalength="22" datatype="NUMBER"
                            name="Срок пролонгации (в месяцах)" id="24">Срок пролонгации (в месяцах)
                        </td>
                        <td class="DURAT_EXTENSION_MONTHS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="INTEREST_RATE" datalength="22" datatype="NUMBER"
                            name="Размер процентной ставки" id="25">Размер процентной ставки
                        </td>
                        <td class="INTEREST_RATE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="GRACE_PERIOD_NUM_DAYS" datalength="22" datatype="NUMBER"
                            name="Льготный период (кол-во дней)" id="26">Льготный период (кол-во дней)
                        </td>
                        <td class="GRACE_PERIOD_NUM_DAYS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PREFERENTIAL_RATE_PROC" datalength="22" datatype="NUMBER"
                            name="Льготная ставка в %" id="27">Льготная ставка в %
                        </td>
                        <td class="PREFERENTIAL_RATE_PROC"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEBGRACE_PERIOD_NUMBERD" datalength="22" datatype="NUMBER"
                            name="Льготный период (кол-во дней)" id="28">Льготный период (кол-во дней)
                        </td>
                        <td class="DEBGRACE_PERIOD_NUMBERD"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEB_GRACE_PREF_RATE" datalength="1020" datatype="VARCHAR2"
                            name="Льготная ставка. Для договоров, требующих перерасчет процентов (от дебетовых оборотов)."
                            id="29">Льготная ставка. Для договоров, требующих перерасчет процентов (от дебетовых
                            оборотов).
                        </td>
                        <td class="DEB_GRACE_PREF_RATE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PREF_RATE_PROC" datalength="22" datatype="NUMBER"
                            name="Льготная ставка в %" id="30">Льготная ставка в %
                        </td>
                        <td class="PREF_RATE_PROC"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="REFIN_RATE_DEPEND" datalength="22" datatype="NUMBER"
                            name="Зависимость от  ставки рефинансирования. справочник" id="31">Зависимость от ставки
                            рефинансирования. справочник
                        </td>
                        <td class="REFIN_RATE_DEPEND"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="OVERNIGHT_RATE_DEPEND" datalength="22" datatype="NUMBER"
                            name="Зависимость от  ставки овернайт. справочник" id="32">Зависимость от ставки овернайт.
                            справочник
                        </td>
                        <td class="OVERNIGHT_RATE_DEPEND"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPES_OPERATIONS" datalength="1020" datatype="VARCHAR2"
                            name="Типы операций." id="33">Типы операций.
                        </td>
                        <td class="TYPES_OPERATIONS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="GRACE_PERIOD_MONTHS" datalength="22" datatype="NUMBER"
                            name="Льготный период в месяцах." id="34">Льготный период в месяцах.
                        </td>
                        <td class="GRACE_PERIOD_MONTHS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEPEND_REFOVRN_RATE" datalength="22" datatype="NUMBER"
                            name="Зависит от ставки рефинансирования / овернайта: 1-да, 0-нет." id="35">Зависит от
                            ставки рефинансирования / овернайта: 1-да, 0-нет.
                        </td>
                        <td class="DEPEND_REFOVRN_RATE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PREFERENTIAL_RATE" datalength="22" datatype="NUMBER"
                            name="Льготная ставка в %" id="36">Льготная ставка в %
                        </td>
                        <td class="PREFERENTIAL_RATE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_AGR_DOCUMENTS" datalength="22" datatype="NUMBER"
                            name='Документы кредитного договора. Cправочник "Список сканируемых документов" (SPIS_SCAN_DOC)' id="37">Документы кредитного договора. Cправочник "Список сканируемых
                        документов" (SPIS_SCAN_DOC)</td>
                        <td class="LOAN_AGR_DOCUMENTS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_AGR_DOCUMENTS_NUM" datalength="22" datatype="NUMBER"
                            name="количество документов, шт" id="38">количество документов, шт
                        </td>
                        <td class="LOAN_AGR_DOCUMENTS_NUM"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="WARRANT_AGR_DOCUMENTS" datalength="22" datatype="NUMBER"
                            name='Документы договора гарантии. Cправочник "Список сканируемых документов" (SPIS_SCAN_DOC)' id="39">Документы договора гарантии. Cправочник "Список сканируемых
                        документов" (SPIS_SCAN_DOC)</td>
                        <td class="WARRANT_AGR_DOCUMENTS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="WARRANT_AGR_DOCUMENTS_NUM" datalength="22" datatype="NUMBER"
                            name="количество, шт" id="40">количество, шт
                        </td>
                        <td class="WARRANT_AGR_DOCUMENTS_NUM"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PLEDGE_AGR_DOCUMENTS" datalength="22" datatype="NUMBER"
                            name='Документы договора залога. Cправочник "Список сканируемых документов" (SPIS_SCAN_DOC)'
                            id="41">Документы договора залога. Cправочник "Список сканируемых
                        документов" (SPIS_SCAN_DOC)</td>
                        <td class="PLEDGE_AGR_DOCUMENTS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEC_CODES_LOAN_PURPOSE" datalength="1020" datatype="VARCHAR2"
                            name="Расшифровка кодов целей кредитов. Справочник Целевое назначение кредитов (NSI_801)"
                            id="42">Расшифровка кодов целей кредитов. Справочник Целевое назначение кредитов (NSI_801)
                        </td>
                        <td class="DEC_CODES_LOAN_PURPOSE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="NEW_CONVEYOR" datalength="22" datatype="NUMBER"
                            name="Новый конвейер: 1-да, 0-нет." id="43">Новый конвейер: 1-да, 0-нет.
                        </td>
                        <td class="NEW_CONVEYOR"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="RULES_ANALYSIS" datalength="22" datatype="NUMBER"
                            name="Анализ по правилам: 1-да, 0-нет." id="44">Анализ по правилам: 1-да, 0-нет.
                        </td>
                        <td class="RULES_ANALYSIS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="KBB_HISTORY_ANALYSIS" datalength="22" datatype="NUMBER"
                            name="Анализ истории КББ: 1-да, 0-нет." id="45">Анализ истории КББ: 1-да, 0-нет.
                        </td>
                        <td class="KBB_HISTORY_ANALYSIS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="ISS_DATA_ANALYSIS" datalength="22" datatype="NUMBER"
                            name="Анализ данных ИСС: 1-да, 0-нет." id="46">Анализ данных ИСС: 1-да, 0-нет.
                        </td>
                        <td class="ISS_DATA_ANALYSIS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LIST_ANALYSIS" datalength="22" datatype="NUMBER"
                            name="Анализ по спискам: 1-да, 0-нет." id="47">Анализ по спискам: 1-да, 0-нет.
                        </td>
                        <td class="LIST_ANALYSIS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="SECURITY" datalength="22" datatype="NUMBER"
                            name="Безопасность: 1-да, 0-нет." id="48">Безопасность: 1-да, 0-нет.
                        </td>
                        <td class="SECURITY"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="SECURITY_FORCED" datalength="22" datatype="NUMBER"
                            name="Принудительно: 1-да, 0-нет." id="49">Принудительно: 1-да, 0-нет.
                        </td>
                        <td class="SECURITY_FORCED"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="VERIFIERS" datalength="22" datatype="NUMBER"
                            name="Верификаторы: 1-да, 0-нет." id="50">Верификаторы: 1-да, 0-нет.
                        </td>
                        <td class="VERIFIERS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="VERIFIERS_FORCED" datalength="22" datatype="NUMBER"
                            name="Принудительно: 1-да, 0-нет." id="51">Принудительно: 1-да, 0-нет.
                        </td>
                        <td class="VERIFIERS_FORCED"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="SCORING" datalength="22" datatype="NUMBER"
                            name="Скоринг: 1-да, 0-нет." id="52">Скоринг: 1-да, 0-нет.
                        </td>
                        <td class="SCORING"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="RISK_MANAGERS" datalength="22" datatype="NUMBER"
                            name="Риск-менеджеры: 1-да, 0-нет." id="53">Риск-менеджеры: 1-да, 0-нет.
                        </td>
                        <td class="RISK_MANAGERS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="RISK_MANAGERS_FORCED" datalength="22" datatype="NUMBER"
                            name="Принудительно: 1-да, 0-нет." id="54">Принудительно: 1-да, 0-нет.
                        </td>
                        <td class="RISK_MANAGERS_FORCED"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="SCORING_MODE" datalength="1020" datatype="VARCHAR2"
                            name="Скоринговая модель" id="55">Скоринговая модель
                        </td>
                        <td class="SCORING_MODE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PROMOT_INTERACT_WEEKS" datalength="22" datatype="NUMBER"
                            name='Акция "Интерактивные недели": 1-да, 0-нет.' id="56">Акция "Интерактивные недели": 1-да, 0-нет.</td>
                        <td class="PROMOT_INTERACT_WEEKS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_CONTRACT_OVERDRAFT" datalength="22" datatype="NUMBER"
                            name='Тип договора "Овердрафт": 1-да, 0-нет.' id="57">Тип договора "Овердрафт": 1-да, 0-нет.</td>
                        <td class="TYPE_CONTRACT_OVERDRAFT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_INSTALLMENT_AGREEMENT" datalength="22" datatype="NUMBER"
                            name='Тип договора "Рассрочка": 1-да, 0-нет.' id="58">Тип договора "Рассрочка": 1-да, 0-нет.</td>
                        <td class="TYPE_INSTALLMENT_AGREEMENT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_AGREEMENT_EXPRESS_LOAN" datalength="22" datatype="NUMBER"
                            name='Тип договора "Экспресс кредит": 1-да, 0-нет.' id="59">Тип договора "Экспресс кредит": 1-да, 0-нет.</td>
                        <td class="TYPE_AGREEMENT_EXPRESS_LOAN"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_AGREEMENT_POSLOAN" datalength="22" datatype="NUMBER"
                            name='Тип договора "POS- кредит": 1-да, 0-нет.' id="60">Тип договора "POS- кредит": 1-да, 0-нет.</td>
                        <td class="TYPE_AGREEMENT_POSLOAN"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPECONTRACT_INT_BANKING" datalength="22" datatype="NUMBER"
                            name='Тип договора "Интернет-банкинг": 1-да, 0-нет.' id="61">Тип договора "Интернет-банкинг": 1-да, 0-нет.</td>
                        <td class="TYPECONTRACT_INT_BANKING"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_CONTRACT_ONLINE" datalength="22" datatype="NUMBER"
                            name='Тип договора "Online": 1-да, 0-нет.' id="62">Тип договора "Online": 1-да, 0-нет.</td>
                        <td class="TYPE_CONTRACT_ONLINE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="CHOOSING_GROUP_PRODUCT" datalength="22" datatype="NUMBER"
                            name='Выбор группы для продукта. Справочник "Классификация кредитов по группам" (GROUP_LOAN)'
                            id="63">
                            Выбор группы для продукта. Справочник "Классификация кредитов по группам" (GROUP_LOAN)</td>
                        <td class="CHOOSING_GROUP_PRODUCT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PRODUCT_CODE" datalength="1020" datatype="VARCHAR2"
                            name="Код продукта" id="64">Код продукта
                        </td>
                        <td class="PRODUCT_CODE">111222</td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="BANK_CLASSIFIER_PROD_CODE" datalength="1020"
                            datatype="VARCHAR2" name="Код продукта по классификатору банка" id="65">Код продукта по
                            классификатору банка
                        </td>
                        <td class="BANK_CLASSIFIER_PROD_CODE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PRODUCT_NAME" datalength="1020" datatype="VARCHAR2"
                            name="Наименование продукта" id="66">Наименование продукта
                        </td>
                        <td class="PRODUCT_NAME">1212</td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PURPOSE_LOAN" datalength="1020" datatype="VARCHAR2"
                            name='Целевое назначение кредита (возможен выбор нескольких значений). Справочник "Целевое назначение кредитов" (NSI_801)'
                            id="67">
                            Целевое назначение кредита (возможен выбор нескольких значений). Справочник "Целевое назначение кредитов" (NSI_801)</td>
                        <td class="PURPOSE_LOAN"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PRINCIPAL_DEBT_ACCOUNT" datalength="22" datatype="NUMBER"
                            name='Счет основного долга. Справочник "План счетов" (BALANS2)' id="68">
                            Счет основного долга. Справочник "План счетов" (BALANS2)</td>
                        <td class="PRINCIPAL_DEBT_ACCOUNT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PRINCIPAL_DEBT_ACCOUNT_1Y" datalength="22" datatype="NUMBER"
                            name='Счет основного долга (для сроков не более 1 года). Справочник "План счетов" (BALANS2)'
                            id="69">
                            Счет основного долга (для сроков не более 1 года). Справочник "План счетов" (BALANS2)</td>
                        <td class="PRINCIPAL_DEBT_ACCOUNT_1Y"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_CURRENCY" datalength="1020" datatype="VARCHAR2"
                            name='Валюта кредита. Справочник "Государства и валюты" (CURRENCY)' id="70">
                            Валюта кредита. Справочник "Государства и валюты" (CURRENCY)</td>
                        <td class="LOAN_CURRENCY"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="ISSUING_METHOD" datalength="1020" datatype="VARCHAR2"
                            name='Способ выдачи. Справочник "Способ выдачи кредитных продуктов населению" (TYP_VIDACH)'
                            id="71">
                            Способ выдачи. Справочник "Способ выдачи кредитных продуктов населению" (TYP_VIDACH)</td>
                        <td class="ISSUING_METHOD"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="LOAN_FORM" datalength="1020" datatype="VARCHAR2"
                            name='Форма кредита. Cправочник "Форма кредита" (FORM_CR)' id="72">
                            Форма кредита. Cправочник "Форма кредита" (FORM_CR)</td>
                        <td class="LOAN_FORM"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="INTEREST_RATE_TYPE" datalength="1020" datatype="VARCHAR2"
                            name="Вид процентной ставки. Справочник Вид процентной ставки (NSI_570)" id="73">Вид
                            процентной ставки. Справочник Вид процентной ставки (NSI_570)
                        </td>
                        <td class="INTEREST_RATE_TYPE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PROPERTY" datalength="1020" datatype="VARCHAR2"
                            name='Объект недвижимости. Справочник "Объекты недвижимости" (REAL_ESTATE)' id="74">
                            Объект недвижимости. Справочник "Объекты недвижимости" (REAL_ESTATE)</td>
                        <td class="PROPERTY"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="ISSUE_LIMIT" datalength="22" datatype="NUMBER"
                            name="Лимит выдачи" id="75">Лимит выдачи
                        </td>
                        <td class="ISSUE_LIMIT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="MAXIMUM_ISSUE_AMOUNT" datalength="22" datatype="NUMBER"
                            name="Максимальная сумма выдачи" id="76">Максимальная сумма выдачи
                        </td>
                        <td class="MAXIMUM_ISSUE_AMOUNT"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="ONETIME_COMMISSION_BYN" datalength="22" datatype="NUMBER"
                            name="Разовая комиссия (в BYN)" id="77">Разовая комиссия (в BYN)
                        </td>
                        <td class="ONETIME_COMMISSION_BYN"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="COMM_ISSUING_LOAN_NATION_CUR" datalength="22" datatype="NUMBER"
                            name="Комиссия в % за выдачу кредита (нац. валюта)" id="78">Комиссия в % за выдачу кредита
                            (нац. валюта)
                        </td>
                        <td class="COMM_ISSUING_LOAN_NATION_CUR"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="COMM_ISSUING_LOAN_FOR_CUR" datalength="22" datatype="NUMBER"
                            name="Комиссия в % за выдачу кредита (ин. валюта)" id="79">Комиссия в % за выдачу кредита
                            (ин. валюта)
                        </td>
                        <td class="COMM_ISSUING_LOAN_FOR_CUR"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="SOLVENCY_RATIO" datalength="22" datatype="NUMBER"
                            name="Коэффициент платежеспособности" id="80">Коэффициент платежеспособности
                        </td>
                        <td class="SOLVENCY_RATIO"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="TYPE_CONTINGENT_LIABILITIES" datalength="22" datatype="NUMBER"
                            name='Вид условных обязательств. Справочник "Виды условных обязательств" (CONDITIONAL_OBLIGATIONS)'
                            id="81">
                            Вид условных обязательств. Справочник "Виды условных обязательств" (CONDITIONAL_OBLIGATIONS)</td>
                        <td class="TYPE_CONTINGENT_LIABILITIES"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="POS_ORGANIZATION" datalength="22" datatype="NUMBER"
                            name='Организация POS. Справочник "Торговые точки для POS- кредитования" (POS_KREDIT_ORGANISATIONS)' id="82">
                            Организация POS. Справочник "Торговые точки для POS- кредитования" (POS_KREDIT_ORGANISATIONS)</td>
                        <td class="POS_ORGANIZATION"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="AUTOMATIC_DECISION_MAKING" datalength="22" datatype="NUMBER"
                            name="Автоматическое принятие решения	: 1-да, 0-нет." id="83">Автоматическое принятие
                            решения : 1-да, 0-нет.
                        </td>
                        <td class="AUTOMATIC_DECISION_MAKING"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="SINGLE_GROUP_ACCOUNTS" datalength="22" datatype="NUMBER"
                            name="Единая группа счетов: 1-да, 0-нет." id="84">Единая группа счетов: 1-да, 0-нет.
                        </td>
                        <td class="SINGLE_GROUP_ACCOUNTS"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PARENT_PRODUCT_SPEC_APRTPRTNR" datalength="22"
                            datatype="NUMBER" name='Родительский продукт (для спецпредложения "Квартира от партнера") . Видимо ссылка на другой кредитный продукт' id="85">
                            Родительский продукт (для спецпредложения "Квартира от партнера") . Видимо ссылка на другой кредитный продукт
                        </td>
                        <td class="PARENT_PRODUCT_SPEC_APRTPRTNR"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="DEPENDS_REFINANCING_RATE" datalength="22" datatype="NUMBER"
                            name="Зависит от ставки рефинансирования" id="86">Зависит от ставки рефинансирования
                        </td>
                        <td class="DEPENDS_REFINANCING_RATE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="PRINCIPAL_DEBT_DEPENDENCE" datalength="1020"
                            datatype="VARCHAR2" name="Зависимость ставки основного долга" id="87">Зависимость ставки
                            основного долга
                        </td>
                        <td class="PRINCIPAL_DEBT_DEPENDENCE"></td>
                    </tr>
                    <tr>
                        <td class="fieldName" fieldname="OVERDUE_RATE_DEPENDENCY" datalength="1020" datatype="VARCHAR2"
                            name="Зависимость для ставки по просрочке" id="88">Зависимость для ставки по просрочке
                        </td>
                        <td class="OVERDUE_RATE_DEPENDENCY"></td>
                    </tr>
                    </tbody>
                </table>
            </div>


        </div>
    </div>


    <div class="modal fade view-catalog-entry-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content view-nsi-entry-modal-content">
                <div class="modal-header view-nsi-entry-modal-header">
                    <h5 class="modal-title" id="modal_title">Подробно</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="view-nsi-entry-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">
                            <form>
                                <ul class="nav nav-tabs" id="tabContent">
                                    <li class="nav-item">
                                        <a id="liA1" href="#details" class="nav-link active" data-toggle="tab">БИ</a>
                                    </li>
                                    <li class="nav-item">
                                        <a id="liA2" href="#access-security" class="nav-link"
                                           data-toggle="tab">Бизнес-предложение</a>
                                    </li>
                                    <li class="nav-item">
                                        <a id="liA3" href="#networking" class="nav-link" data-toggle="tab">КПБ</a>
                                    </li>
                                    <li class="nav-item">
                                        <a id="liA4" href="#networkingg" class="nav-link" data-toggle="tab">Продукт</a>
                                    </li>

                                </ul>

                                <%-- <div class="tab-content">
                                     <div class="tab-pane active" id="details">
                                         <div id="busInit">
                                             <div class="form-group">
                                                 <label for="ADDINFO">Дополнительная информация:</label>
                                                 <output id="ADDINFO" class="form-control-sm  output-text" name="ADDINFO"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="BUSINESSAPPIMPLDATE">Дата создания бизнес-предложения:</label>
                                                 <output id="BUSINESSAPPIMPLDATE" class="form-control-sm output-text"
                                                         name="BUSINESSAPPIMPLDATE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="BIDATE">Дата создания БИ:</label>
                                                 <output id="BIDATE" class="form-control-sm  output-text" name="BIDATE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="IMPLPLANNINGDATE">Дата планирования:</label>
                                                 <output id="IMPLPLANNINGDATE" class="form-control-sm  output-text"
                                                         name="IMPLPLANNINGDATE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="JOBTYPES">Типы работы:</label>
                                                 <output id="JOBTYPES" class="form-control-sm  output-text" name="JOBTYPES"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="MARKETANALISYS">Рыночный анализ:</label>
                                                 <output id="MARKETANALISYS" class="form-control-sm  output-text"
                                                         name="MARKETANALISYS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="MARKETANALISYSFILE">Файл рыночного анализа:</label>
                                                 <output id="MARKETANALISYSFILE" class="form-control-sm  output-text"
                                                         name="MARKETANALISYSFILE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="BINAME">Название БИ:</label>
                                                 <output id="BINAME" class="form-control-sm  output-text" name="BINAME"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="NONREALIZEEFFECTS">Нереализованные эффекты:</label>
                                                 <output id="NONREALIZEEFFECTS" class="form-control-sm  output-text"
                                                         name="NONREALIZEEFFECTS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PLANGRAPHICDATE">Планграфическая дата:</label>
                                                 <output id="PLANGRAPHICDATE" class="form-control-sm  output-text"
                                                         name="PLANGRAPHICDATE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="BIPOINT">Точка БИ:</label>
                                                 <output id="BIPOINT" class="form-control-sm  output-text" name="BIPOINT"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCT">Продукт:</label>
                                                 <output id="PRODUCT" class="form-control-sm  output-text" name="PRODUCT"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTDEVELOPERDEPT">Отдел разработчика:</label>
                                                 <output id="PRODUCTDEVELOPERDEPT" class="form-control-sm  output-text"
                                                         name="PRODUCTDEVELOPERDEPT"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTDEVELOPERFIO">ФИО разработчика продукта:</label>
                                                 <output id="PRODUCTDEVELOPERFIO" class="form-control-sm  output-text"
                                                         name="PRODUCTDEVELOPERFIO"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="REALIZEPROSPECTIVE">Реализация перспективы:</label>
                                                 <output id="REALIZEPROSPECTIVE" class="form-control-sm  output-text"
                                                         name="REALIZEPROSPECTIVE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="BISTATUS">Статус БИ:</label>
                                                 <output id="BISTATUS" class="form-control-sm  output-text" name="BISTATUS"></output>
                                             </div>
                                         </div>
                                     </div>
                                     <div class="tab-pane" id="access-security">
                                         <div id="busOffer">
                                             <div class="form-group">
                                                 <label for="BONAME">Название бизнес-предложения:</label>
                                                 <output id="BONAME" class="form-control-sm  output-text" name="BONAME"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="BOSTATUS">Статус БП:</label>
                                                 <output id="BOSTATUS" class="form-control-sm  output-text" name="BOSTATUS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTMANAGER">ФИО Менеджера продукта Сущности БИ:</label>
                                                 <output id="PRODUCTMANAGER" class="form-control-sm  output-text"
                                                         name="PRODUCTMANAGER"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTMANAGERPOSITION">Название должности:</label>
                                                 <output id="PRODUCTMANAGERPOSITION" class="form-control-sm  output-text"
                                                         name="PRODUCTMANAGERPOSITION"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTMANAGERPHONE">Номер телефона:</label>
                                                 <output id="PRODUCTMANAGERPHONE" class="form-control-sm  output-text"
                                                         name="PRODUCTMANAGERPHONE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTMANAGERDEPT">Значение подразделения:</label>
                                                 <output id="PRODUCTMANAGERDEPT" class="form-control-sm  output-text"
                                                         name="PRODUCTMANAGERDEPT"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTMANAGERSUPERVISOR">ФИО Руководителя структурного подразделения:</label>
                                                 <output id="PRODUCTMANAGERSUPERVISOR" class="form-control-sm  output-text"
                                                         name="PRODUCTMANAGERSUPERVISOR"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTMANAGERSUPERVISORPOS">Название должности руководителя структурного подразделения:</label>
                                                 <output id="PRODUCTMANAGERSUPERVISORPOS" class="form-control-sm  output-text"
                                                         name="PRODUCTMANAGERSUPERVISORPOS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTMANAGERSUPERVISORPHONE">Номер телефона руководителя структурного подразделения:</label>
                                                 <output id="PRODUCTMANAGERSUPERVISORPHONE" class="form-control-sm  output-text"
                                                         name="PRODUCTMANAGERSUPERVISORPHONE"></output>
                                             </div>
                                         </div>
                                     </div>
                                     <div class="tab-pane" id="networking">
                                         &lt;%&ndash;<div id="bpCard">
                                             <div class="form-group">
                                                 <label for="PRODUCTNAME">Название продукта:</label>
                                                 <output id="PRODUCTNAME" class="form-control-sm  output-text"
                                                         name="PRODUCTNAME"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTSTATUS">Статус продукта:</label>
                                                 <output id="PRODUCTSTATUS" class="form-control-sm  output-text"
                                                         name="PRODUCTSTATUS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="COMMONPRODUCTCHARS">Общая характеристика банковского продукта:</label>
                                                 <output id="COMMONPRODUCTCHARS" class="form-control-sm  output-text"
                                                         name="COMMONPRODUCTCHARS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="CHANGESTATUSDATE">Дата изменения статуса:</label>
                                                 <output id="CHANGESTATUSDATE" class="form-control-sm  output-text"
                                                         name="CHANGESTATUSDATE"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="PRODUCTADVANTAGES">Достоинства продукта для клиента:</label>
                                                 <output id="PRODUCTADVANTAGES" class="form-control-sm  output-text"
                                                         name="PRODUCTADVANTAGES"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="MAINPRODUCTPARAMS">Основные параметры продукта:</label>
                                                 <output id="MAINPRODUCTPARAMS" class="form-control-sm  output-text"
                                                         name="MAINPRODUCTPARAMS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="DOCSFORMS">Типовые формы документов,использующиеся для банковского продукта:</label>
                                                 <output id="DOCSFORMS" class="form-control-sm  output-text"
                                                         name="DOCSFORMS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="LPABANKS">ЛПА банка, касающиеся данного банковского продукта:</label>
                                                 <output id="LPABANKS" class="form-control-sm  output-text" name="LPABANKS"></output>
                                             </div>
                                             <div class="form-group">
                                                 <label for="ADDMATERIALS">Дополнительные материалы:</label>
                                                 <output id="ADDMATERIALS" class="form-control-sm  output-text"
                                                         name="ADDMATERIALS"></output>
                                             </div>
                                         </div>&ndash;%&gt;

                                             <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _91xQAR0LEeuNPa1IYPTRDw s-typed " style="" id="_QmSvxB0MEeuNPa1IYPTRDw" extid="bpID" cname="bpID" title=""><span class="f-label" style=""><label for="w67252aab1b1b3b1b1b1">Название продукта:</label><span class="f-required"></span><div class="f-helpcontent" style="display:none">
                                                                                     <div class="c-helpcontent"></div>
                                                                                  </div></span><aside class="decorator fontawesome icon-edit"></aside>
                                                 <div class="decorator facade" style=""><pre id="w67252aab1b1b3b1b1b1" name="bpID" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                 <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>

                                             <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _91xQAR0LEeuNPa1IYPTRDw s-typed " style="" id="_QmSvxB0MEeuNPa1IYPTRDw" extid="bpID" cname="bpID" title=""><span class="f-label" style=""><label for="w67252aab1b1b3b1b1b1">Название продукта:</label><span class="f-required"></span><div class="f-helpcontent" style="display:none">
                                                                                     <div class="c-helpcontent"></div>
                                                                                  </div></span><aside class="decorator fontawesome icon-edit"></aside>
                                                 <div class="decorator facade" style=""><pre id="w67252aab1b1b3b1b1b1" name="bpID" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                 <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>

                                             <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _91xQAR0LEeuNPa1IYPTRDw s-typed " style="" id="_QmSvxB0MEeuNPa1IYPTRDw" extid="bpID" cname="bpID" title=""><span class="f-label" style=""><label for="w67252aab1b1b3b1b1b1">Название продукта:</label><span class="f-required"></span><div class="f-helpcontent" style="display:none">
                                                                                     <div class="c-helpcontent"></div>
                                                                                  </div></span><aside class="decorator fontawesome icon-edit"></aside>
                                                 <div class="decorator facade" style=""><pre id="w67252aab1b1b3b1b1b1" name="bpID" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                 <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>

                                             <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _91xQAR0LEeuNPa1IYPTRDw s-typed " style="" id="_QmSvxB0MEeuNPa1IYPTRDw" extid="bpID" cname="bpID" title=""><span class="f-label" style=""><label for="w67252aab1b1b3b1b1b1">Название продукта:</label><span class="f-required"></span><div class="f-helpcontent" style="display:none">
                                                                                     <div class="c-helpcontent"></div>
                                                                                  </div></span><aside class="decorator fontawesome icon-edit"></aside>
                                                 <div class="decorator facade" style=""><pre id="w67252aab1b1b3b1b1b1" name="bpID" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                 <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>

                                             <div class="f-control Twelve columns  f-input  s-valid  s-linked Text _91xQAR0LEeuNPa1IYPTRDw s-typed " style="" id="_QmSvxB0MEeuNPa1IYPTRDw" extid="bpID" cname="bpID" title=""><span class="f-label" style=""><label for="w67252aab1b1b3b1b1b1">Название продукта:</label><span class="f-required"></span><div class="f-helpcontent" style="display:none">
                                                                                     <div class="c-helpcontent"></div>
                                                                                  </div></span><aside class="decorator fontawesome icon-edit"></aside>
                                                 <div class="decorator facade" style=""><pre id="w67252aab1b1b3b1b1b1" name="bpID" class="input wrap" wrap="virtual" style="" type="text"><br></pre></div>
                                                 <aside class="decorator fontawesome"></aside><span class="f-status" style="display:none;"><span>(n)</span></span></div>



                                     </div>

                                     <div class="tab-pane" id="networkingg">
                                         <div id="product">
                                             <div class="form-group">
                                                 <label for="PRODUCTNAME">Название продукта:</label>
                                                 <output id="PROD" class="form-control-sm  output-text"
                                                         name="PRODUCTNAME"></output>
                                             </div>

                                         </div>
                                     </div>
                                 </div>--%>

                                <div>

                                    <button type="button" onclick="showBI()"
                                            class="btn modern-product-catalog-modal-button">
                                        x
                                    </button>

                                    <button type="button" onclick="showBO()"
                                            class="btn modify-product-catalog-modal-button">
                                        y
                                    </button>

                                    <button type="button" onclick="showKBP()"
                                            class="btn destroy-product-catalog-modal-button">
                                        z
                                    </button>
                                </div>

                                <div class="row float-right">

                                    <button type="button" class="btn modern-product-catalog-modal-button">
                                        Модернизировать
                                    </button>

                                    <button type="button" class="btn modify-product-catalog-modal-button">
                                        Модифицировать
                                    </button>

                                    <button type="button" class="btn destroy-product-catalog-modal-button">
                                        Ликвидировать
                                    </button>
                                    <button type="button" class="btn view-cancel-catalog-entry-button">Закрыть</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/side-navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/content-inject.js"></script>
<script src="${pageContext.request.contextPath}/js/catalog.js"></script>
</body>
</html>
