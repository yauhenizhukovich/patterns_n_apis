<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.dimid}</span>
                <span data-nsi class="PARENTID">${user.parentId}</span>
                <span data-nsi class="CODE">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="CLB_EMPL_MIN_CNT">${user.clbEmplMinCnt}</span>
                <span data-nsi class="CLB_MAX_SUM">${user.clbMaxSum}</span>
                <span data-nsi class="CLB_CREDIT_SUM_MIN">${user.clbCreditSumMin}</span>
                <span data-nsi class="CLB_DEFAULT">${user.clbDefault}</span>
                <span data-nsi class="CLB_PUBLIC_ADMIN">${user.clbPublicAdmin}</span>
                <span data-nsi class="CLB_CREDIT_SUM_MAX">${user.clbCreditSumMax}</span>
                <span data-nsi class="CLB_OWNERSHIP_TYPE">${user.clbOwnershipType}</span>
                <span data-nsi class="CLB_BG_SUM_MAX">${user.clbBgSumMax}</span>
                <span data-nsi class="CLB_EMPL_MAX_CNT">${user.clbEmplMaxCnt}</span>
                <span data-nsi class="CLB_CONTRAGENT">${user.clbContragent}</span>
                <span data-nsi class="CLB_BANK_CHILD_COMP">${user.clbBankChildComp}</span>
                <span data-nsi class="CLB_BG_SUM_MIN">${user.clbBgSumMin}</span>
                <span data-nsi class="CLB_MIN_SUM">${user.clbMinSum}</span>
                <span data-nsi class="CLB_CREDIT_DEBT_CUR">${user.clbCreditDebtCur}</span>
                <span data-nsi class="CLB_CURRENCY">${user.clbCurrency}</span>

            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentId}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="CLB_EMPL_MIN_CNT">${user.clbEmplMinCnt}</td>
            <td class="CLB_MAX_SUM">${user.clbMaxSum}</td>
            <td class="CLB_CREDIT_SUM_MIN">${user.clbCreditSumMin}</td>
            <td class="CLB_DEFAULT">${user.clbDefault}</td>
            <td class="CLB_PUBLIC_ADMIN">${user.clbPublicAdmin}</td>
            <td class="CLB_CREDIT_SUM_MAX">${user.clbCreditSumMax}</td>
            <td class="CLB_OWNERSHIP_TYPE">${user.clbOwnershipType}</td>
            <td class="CLB_BG_SUM_MAX">${user.clbBgSumMax}</td>
            <td class="CLB_EMPL_MAX_CNT">${user.clbEmplMaxCnt}</td>
            <td class="CLB_CONTRAGENT">${user.clbContragent}</td>
            <td class="CLB_BANK_CHILD_COMP">${user.clbBankChildComp}</td>
            <td class="CLB_BG_SUM_MIN">${user.clbBgSumMin}</td>
            <td class="CLB_MIN_SUM">${user.clbMinSum}</td>
            <td class="CLB_CREDIT_DEBT_CUR">${user.clbCreditDebtCur}</td>
            <td class="CLB_CURRENCY">${user.clbCurrency}</td>

        </tr>
    </c:forEach>
</c:if>

