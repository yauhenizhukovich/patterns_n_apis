<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.id}</span>
                <span data-nsi class="ROLE_NAME">${user.roleName}</span>
                <span data-nsi class="ROLE_DESC">${user.roleDesc}</span>
                <span data-nsi class="ROLE_DESC2">${user.roleDesc2}</span>
                <span data-nsi class="CREATE_DATE">${user.creatDate}</span>

            </td>
            <td class="ID">${user.id}</td>
            <td class="ROLE_NAME">${user.roleName}</td>
            <td class="ROLE_DESC">${user.roleDesc}</td>
            <td class="ROLE_DESC2">${user.roleDesc2}</td>
            <td class="CREATE_DATE">${user.creatDate}</td>

        </tr>
    </c:forEach>
</c:if>

