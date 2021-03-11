<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.idAftermath}</span>
                <span data-nsi class="AFTERMATH_NAME">${user.aftermathName}</span>
                <span data-nsi class="AFTERMATH_DESC">${user.aftermathDesc}</span>
            </td>
            <td class="ID_AFTERMATH" hidden>${user.idAftermath}</td>
            <td class="AFTERMATH_NAME">${user.aftermathName}</td>
            <td class="AFTERMATH_DESC">${user.aftermathDesc}</td>
        </tr>
    </c:forEach>
</c:if>
