<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.id}</span>
                <span data-nsi class="USER_ID">${user.userId}</span>
                <span data-nsi class="ROLE_ID">${user.roleId}</span>
                <span data-nsi class="ROLE_DESC">${user.roleDesc}</span>
                <span data-nsi class="ROLE_LOCK">${user.roleLock}</span>
                <span data-nsi class="DATE_FROM">${user.dateFrom}</span>
                <span data-nsi class="DATE_TO">${user.dateTo}</span>
                <span data-nsi class="USER_FULLNAME">${user.userFullname}</span>

            </td>
            <td class="ID">${user.id}</td>
            <td class="USER_ID">${user.userId}</td>
            <td class="ROLE_ID">${user.roleId}</td>
            <td class="ROLE_DESC">${user.roleDesc}</td>
            <td class="ROLE_LOCK">${user.roleLock}</td>
            <td class="DATE_FROM">${user.dateFrom}</td>
            <td class="DATE_TO">${user.dateTo}</td>
            <td class="USER_FULLNAME">${user.userFullname}</td>

        </tr>
    </c:forEach>
</c:if>

