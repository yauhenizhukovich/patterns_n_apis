<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.idRisk}</span>
                <span data-nsi class="RISK_NAME">${user.riskName}</span>
                <span data-nsi class="DESCRIPTION">${user.description}</span>

            </td>
            <td class="ID_RISK" hidden>${user.idRisk}</td>
            <td class="RISK_NAME">${user.riskName}</td>
            <td class="DESCRIPTION">${user.description}</td>
        </tr>
    </c:forEach>
</c:if>

