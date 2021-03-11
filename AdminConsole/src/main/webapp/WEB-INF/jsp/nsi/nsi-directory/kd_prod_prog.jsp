<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.dimid}</span>
                <span data-nsi class="CODE">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="KD_PP_ST_RISK">${user.kdPpStRisk}</span>
                <span data-nsi class="KD_PP_TARG">${user.kdPpTarg}</span>
                <span data-nsi class="KD_PP_RM_DEC">${user.kdPpRmDec}</span>
                <span data-nsi class="KD_PP_COND_OBLIG">${user.kdPpCondOblig}</span>
                <span data-nsi class="KD_PP_PROD">${user.kdPpProd}</span>
                <span data-nsi class="KD_PP_TYPE">${user.kdPpType}</span>
                <span data-nsi class="KD_PP_PENYA_VAL">${user.kdPpPenyaVal}</span>
                <span data-nsi class="KD_PP_CUR_CLIENT">${user.kdPpCurClient}</span>
                <span data-nsi class="KD_PP_FORM">${user.kdPpCurForm}</span>
                <span data-nsi class="KD_PP_VID_OBES">${user.kdPpVidObes}</span>
                <span data-nsi class="KD_PP_IST_FIN">${user.kdPpIstFin}</span>
                <span data-nsi class="KD_PP_DOST">${user.kdPpDost}</span>
                <span data-nsi class="KD_PP_CUR_BANK">${user.kdPpCurBank}</span>
                <span data-nsi class="KD_PP_MICRO">${user.kdPpMicro}</span>
                <span data-nsi class="KD_PP_OBOR">${user.kdPpObor}</span>
                <span data-nsi class="KD_PP_TARIF">${user.kdPpTarif}</span>
                <span data-nsi class="KD_PP_TYPE_KR">${user.kdPpTypeKr}</span>
                <span data-nsi class="KD_PP_TERM">${user.kdPpTerm}</span>
                <span data-nsi class="KD_PP_DAYS_IN_Y">${user.kdPPDaysInY}</span>

            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="KD_PP_ST_RISK">${user.kdPpStRisk}</td>
            <td class="KD_PP_TARG">${user.kdPpTarg}</td>
            <td class="KD_PP_RM_DEC">${user.kdPpRmDec}</td>
            <td class="KD_PP_COND_OBLIG">${user.kdPpCondOblig}</td>
            <td class="KD_PP_PROD">${user.kdPpProd}</td>
            <td class="KD_PP_TYPE">${user.kdPpType}</td>
            <td class="KD_PP_PENYA_VAL">${user.kdPpPenyaVal}</td>
            <td class="KD_PP_CUR_CLIENT">${user.kdPpCurClient}</td>
            <td class="KD_PP_FORM">${user.kdPpCurForm}</td>
            <td class="KD_PP_VID_OBES">${user.kdPpVidObes}</td>
            <td class="KD_PP_IST_FIN">${user.kdPpIstFin}</td>
            <td class="KD_PP_DOST">${user.kdPpDost}</td>
            <td class="KD_PP_CUR_BANK">${user.kdPpCurBank}</td>
            <td class="KD_PP_MICRO">${user.kdPpMicro}</td>
            <td class="KD_PP_OBOR">${user.kdPpObor}</td>
            <td class="KD_PP_TARIF">${user.kdPpTarif}</td>
            <td class="KD_PP_TYPE_KR">${user.kdPpTypeKr}</td>
            <td class="KD_PP_TERM">${user.kdPpTerm}</td>
            <td class="KD_PP_DAYS_IN_Y">${user.kdPPDaysInY}</td>

        </tr>
    </c:forEach>
</c:if>

