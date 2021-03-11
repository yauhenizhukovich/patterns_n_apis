<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.pscId}</span>
                <span data-nsi class="PSC_NAME">${user.pscName}</span>
                <span data-nsi class="PSC_DESC">${user.pscDesc}</span>

            </td>
            <td class="PSC_ID">${user.pscId}</td>
            <td class="PSC_NAME">${user.pscName}</td>
            <td class="PSC_DESC">${user.pscDesc}</td>

        </tr>
    </c:forEach>
</c:if>

