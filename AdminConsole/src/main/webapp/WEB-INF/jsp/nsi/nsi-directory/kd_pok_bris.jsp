<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.dimid}</span>
                <span data-nsi class="CODE">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="LIST_KD_PRODUCTS">${user.listKdProducts}</span>
                <span data-nsi class="CHECK_TOPPDN_REZERV">${user.checkToppdnRezerv}</span>
                <span data-nsi class="RESERVE_PERSENT_FOR_KD">${user.reservePersentForKd}</span>

            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="LIST_KD_PRODUCTS">${user.listKdProducts}</td>
            <td class="CHECK_TOPPDN_REZERV">${user.checkToppdnRezerv}</td>
            <td class="RESERVE_PERSENT_FOR_KD">${user.reservePersentForKd}</td>

        </tr>
    </c:forEach>
</c:if>

