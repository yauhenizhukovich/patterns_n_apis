<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id" >${user.idProspects}</span>
                <span data-nsi class="PROSPECTS_NAME">${user.prospectsName}</span>
                <span data-nsi class="PROSPECTS_DESC">${user.prospectsDesc}</span>

            </td>

            <td class="PROSPECTS_NAME">${user.prospectsName}</td>
            <td class="PROSPECTS_DESC">${user.prospectsDesc}</td>

        </tr>
    </c:forEach>
</c:if>

