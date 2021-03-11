<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.dimid}</span>
                <span data-nsi class="CODE">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="CUR_LIST">${user.curList}</span>
                <span data-nsi class="CARDTYPE_CATEGORY">${user.cardtypeCategory}</span>
                <span data-nsi class="CARDTYPE_PS">${user.cardtypePs}</span>
                <span data-nsi class="CARDTYPE_TECHNOLOGY">${user.cardtypeTechnology}</span>
                <span data-nsi class="CARDTYPE_TYPE_ADD_SERVICE">${user.cardtypeTypeAddService}</span>
                <span data-nsi class="COLOR_IB">${user.colorIb}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="CUR_LIST">${user.curList}</td>
            <td class="CARDTYPE_CATEGORY">${user.cardtypeCategory}</td>
            <td class="CARDTYPE_PS">${user.cardtypePs}</td>
            <td class="CARDTYPE_TECHNOLOGY">${user.cardtypeTechnology}</td>
            <td class="CARDTYPE_TYPE_ADD_SERVICE">${user.cardtypeTypeAddService}</td>
            <td class="COLOR_IB">${user.colorIb}</td>

        </tr>
    </c:forEach>
</c:if>

