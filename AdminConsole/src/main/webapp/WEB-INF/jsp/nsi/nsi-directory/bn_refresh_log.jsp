<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.name}</span>
                <span data-nsi class="STARTDATE">${user.startDate}</span>
                <span data-nsi class="ENDDATE">${user.endDate}</span>
                <span data-nsi class="CNTRECINS">${user.cntrecIns}</span>
                <span data-nsi class="CNTRECUPD">${user.cntrecUpd}</span>
                <span data-nsi class="CNTRECDEL">${user.cntrecDel}</span>
                <span data-nsi class="NOTE">${user.note}</span>
            </td>
            <td class="NAME">${user.name}</td>
            <td class="STARTDATE">${user.startDate}</td>
            <td class="ENDDATE">${user.endDate}</td>
            <td class="CNTRECINS">${user.cntrecIns}</td>
            <td class="CNTRECUPD">${user.cntrecUpd}</td>
            <td class="CNTRECDEL">${user.cntrecDel}</td>
            <td class="NOTE">${user.note}</td>
        </tr>
    </c:forEach>
</c:if>
