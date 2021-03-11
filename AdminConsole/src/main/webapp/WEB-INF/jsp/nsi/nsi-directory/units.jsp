<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.idUnit}</span>
                <span data-nsi class="UNIT_FULLNAME">${user.unitFullName}</span>
                <span data-nsi class="UNIT_NAME">${user.unitName}</span>
                <span data-nsi class="IS_DEVELOPER">${user.isDeveloper}</span>
                <span data-nsi class="MANAGER_NAME">${user.managerName}</span>
                <span data-nsi class="MANAGER_POSITION">${user.managerPosition}</span>
                <span data-nsi class="CURATOR">${user.curator}</span>
                <span data-nsi class="SUPERIOR_UNIT">${user.superiorUnit}</span>

            </td>
            <td class="ID_UNIT">${user.idUnit}</td>
            <td class="UNIT_FULLNAME">${user.unitFullName}</td>
            <td class="UNIT_NAME">${user.unitName}</td>
            <td class="IS_DEVELOPER">${user.isDeveloper}</td>
            <td class="MANAGER_NAME">${user.managerName}</td>
            <td class="MANAGER_POSITION">${user.managerPosition}</td>
            <td class="CURATOR">${user.curator}</td>
            <td class="SUPERIOR_UNIT">${user.superiorUnit}</td>
        </tr>
    </c:forEach>
</c:if>

