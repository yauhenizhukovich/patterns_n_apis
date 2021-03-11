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
                <span data-nsi class="K1">${user.k1}</span>
                <span data-nsi class="K2">${user.k2}</span>
                <span data-nsi class="K3">${user.k3}</span>
                <span data-nsi class="OLD_CODES">${user.oldCodes}</span>

            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentId}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="K3">${user.k1}</td>
            <td class="K2">${user.k2}</td>
            <td class="K3">${user.k3}</td>
            <td class="OLD_CODES">${user.oldCodes}</td>

        </tr>
    </c:forEach>
</c:if>

