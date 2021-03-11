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
                <span data-nsi class="DEP_PROC_DECREASE_STAV">${user.decreaseStav}</span>
                <span data-nsi class="DEP_VID_PROC_STAV">${user.prodStav}</span>
                <span data-nsi class="DEP_SUMBL">${user.depSumbl}</span>
                <span data-nsi class="DEP_SROK">${user.srok}</span>
                <span data-nsi class="DEP_TYPE">${user.type}</span>
                <span data-nsi class="DEP_SR_VOZVRAT">${user.srVozvrat}</span>
                <span data-nsi class="DEP_POROG_SUM">${user.porogSum}</span>
                <span data-nsi class="DEP_SUM_SPIS">${user.sumSpis}</span>
                <span data-nsi class="DEP_MAX_SROK">${user.maxSrok}</span>
                <span data-nsi class="DEP_STAV_SPIS">${user.stavSpis}</span>
                <span data-nsi class="DEP_USL_RASTOR">${user.uslRastor}</span>
                <span data-nsi class="DEP_BLOC">${user.bloc}</span>
                <span data-nsi class="DEP_SUMDOG">${user.sumdog}</span>
                <span data-nsi class="DEP_ALLOW_ADDITION">${user.allowAddition}</span>
                <span data-nsi class="DEP_BAN_DEYS">${user.banDeys}</span>
                <span data-nsi class="DEP_STAV_RAST">${user.stavRast}</span>
                <span data-nsi class="DEP_STAVKA">${user.depStavka}</span>
                <span data-nsi class="DEP_GOAL">${user.goal}</span>
                <span data-nsi class="DEP_SHKALA_STAV">${user.shkalaStav}</span>
                <span data-nsi class="DEP_KOL">${user.kol}</span>
                <span data-nsi class="DEP_TYPE_NACH_PROC">${user.nachProc}</span>
                <span data-nsi class="DEP_PROC_RAST">${user.procRast}</span>
                <span data-nsi class="DEP_MAX_STAV">${user.maxStav}</span>
                <span data-nsi class="DEP_MAX_LIMIT">${user.maxLimit}</span>
                <span data-nsi class="DEP_PROC_TAKE_ALLOW">${user.takeAllow}</span>
                <span data-nsi class="DEP_MIN_SROK">${user.minSrok}</span>
                <span data-nsi class="DEP_STAV_RAST_VAL">${user.stavRastVal}</span>
                <span data-nsi class="DEP_SROK_WAIT_RETURN">${user.srokWaitReturn}</span>
                <span data-nsi class="DEP_LIMIT">${user.limit}</span>
                <span data-nsi class="DEP_TYPE_CONTRACT">${user.contract}</span>
                <span data-nsi class="DEP_ADDITIONAL_INCOME">${user.additionalIncome}</span>
                <span data-nsi class="DEP_KONTR_MAX_STAV">${user.kontrMaxStav}</span>
                <span data-nsi class="DEP_CURRENCY">${user.currency}</span>
                <span data-nsi class="DEP_STAV_POROG">${user.stavPorog}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentId}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="DEP_PROC_DECREASE_STAV">${user.decreaseStav}</td>
            <td class="DEP_VID_PROC_STAV">${user.prodStav}</td>
            <td class="DEP_SUMBL">${user.depSumbl}</td>
            <td class="DEP_SROK">${user.srok}</td>
            <td class="DEP_TYPE">${user.type}</td>
            <td class="DEP_SR_VOZVRAT">${user.srVozvrat}</td>
            <td class="DEP_POROG_SUM">${user.porogSum}</td>
            <td class="DEP_SUM_SPIS">${user.sumSpis}</td>
            <td class="DEP_MAX_SROK">${user.maxSrok}</td>
            <td class="DEP_STAV_SPIS">${user.stavSpis}</td>
            <td class="DEP_USL_RASTOR">${user.uslRastor}</td>
            <td class="DEP_BLOC">${user.bloc}</td>
            <td class="DEP_SUMDOG">${user.sumdog}</td>
            <td class="DEP_ALLOW_ADDITION">${user.allowAddition}</td>
            <td class="DEP_BAN_DEYS">${user.banDeys}</td>
            <td class="DEP_STAV_RAST">${user.stavRast}</td>
            <td class="DEP_STAVKA">${user.depStavka}</td>
            <td class="DEP_GOAL">${user.goal}</td>
            <td class="DEP_SHKALA_STAV">${user.shkalaStav}</td>
            <td class="DEP_KOL">${user.kol}</td>
            <td class="DEP_TYPE_NACH_PROC">${user.nachProc}</td>
            <td class="DEP_PROC_RAST">${user.procRast}</td>
            <td class="DEP_MAX_STAV">${user.maxStav}</td>
            <td class="DEP_MAX_LIMIT">${user.maxLimit}</td>
            <td class="DEP_PROC_TAKE_ALLOW">${user.takeAllow}</td>
            <td class="DEP_MIN_SROK">${user.minSrok}</td>
            <td class="DEP_STAV_RAST_VAL">${user.stavRastVal}</td>
            <td class="DEP_SROK_WAIT_RETURN">${user.srokWaitReturn}</td>
            <td class="DEP_LIMIT">${user.limit}</td>
            <td class="DEP_TYPE_CONTRACT">${user.contract}</td>
            <td class="DEP_ADDITIONAL_INCOME">${user.additionalIncome}</td>
            <td class="DEP_KONTR_MAX_STAV">${user.kontrMaxStav}</td>
            <td class="DEP_CURRENCY">${user.currency}</td>
            <td class="DEP_STAV_POROG">${user.stavPorog}</td>
        </tr>
    </c:forEach>
</c:if>

