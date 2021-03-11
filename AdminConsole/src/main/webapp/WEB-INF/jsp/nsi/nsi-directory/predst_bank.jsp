<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="DOLJN_PREDST">${user.doljnPredst}</span>
                <span data-nsi class="POST_R">${user.postR}</span>
                <span data-nsi class="FIO_R_ACCESS">${user.fioRAdress}</span>
                <span data-nsi class="FIO_R">${user.fioR}</span>
                <span data-nsi class="POST_R_ACCESS">${user.postRAccess}</span>
                <span data-nsi class="MANAGER_PERSON_NUM">${user.managerPersonNum}</span>
                <span data-nsi class="DOKUM_PREDST">${user.documPredst}</span>
            </td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="DOLJN_PREDST">${user.doljnPredst}</td>
            <td class="POST_R">${user.postR}</td>
            <td class="FIO_R_ACCESS">${user.fioRAdress}</td>
            <td class="FIO_R">${user.fioR}</td>
            <td class="POST_R_ACCESS">${user.postRAccess}</td>
            <td class="MANAGER_PERSON_NUM">${user.managerPersonNum}</td>
            <td class="DOKUM_PREDST">${user.documPredst}</td>
        </tr>
    </c:forEach>
</c:if>

