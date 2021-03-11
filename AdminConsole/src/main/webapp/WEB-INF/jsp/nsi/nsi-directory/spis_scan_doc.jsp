<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.dimid}</span>
                <span data-nsi class="PARENTID">${user.parentid}</span>
                <span data-nsi class="CODE">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="SCAN_PAC">${user.scanPac}</span>
                <span data-nsi class="SCAN_TYPE">${user.scanType}</span>
                <span data-nsi class="DZ_VID_ZAL">${user.dzVidZal}</span>
                <span data-nsi class="DZ_PREDMET">${user.dzPredmet}</span>
                <span data-nsi class="DZ_VID_OBESP">${user.dzVidObesp}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentid}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="SCAN_PAC">${user.scanPac}</td>
            <td class="SCAN_TYPE">${user.scanType}</td>
            <td class="DZ_VID_ZAL">${user.dzVidZal}</td>
            <td class="DZ_PREDMET">${user.dzPredmet}</td>
            <td class="DZ_VID_OBESP">${user.dzVidObesp}</td>
        </tr>
    </c:forEach>
</c:if>