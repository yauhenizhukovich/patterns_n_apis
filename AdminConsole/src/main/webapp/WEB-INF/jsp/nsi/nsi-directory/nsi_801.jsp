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
                <span data-nsi class="LGOTNOST_SIGN">${user.lgotnostSign}</span>
                <span data-nsi class="REFER_INVEST">${user.referInvest}</span>
                <span data-nsi class="GOSMEROPRIATIA">${user.gosmeropriatia}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentId}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="LGOTNOST_SIGN">${user.lgotnostSign}</td>
            <td class="REFER_INVEST">${user.referInvest}</td>
            <td class="GOSMEROPRIATIA">${user.gosmeropriatia}</td>
        </tr>
    </c:forEach>
</c:if>

