<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.sfId}</span>
                <span data-nsi class="SF_NAME">${user.sfName}</span>
                <span data-nsi class="SF_DESC">${user.sfDesc}</span>

            </td>
            <td class="SF_ID">${user.sfId}</td>
            <td class="SF_NAME">${user.sfName}</td>
            <td class="SF_DESC">${user.sfDesc}</td>
        </tr>
    </c:forEach>
</c:if>

