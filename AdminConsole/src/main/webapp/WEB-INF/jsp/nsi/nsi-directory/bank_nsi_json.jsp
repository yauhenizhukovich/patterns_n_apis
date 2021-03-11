<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="SQL_TEXT">${user.sqlText}</span>
                <span data-nsi class="XML_TABLE">${user.xmlTable}</span>
                <span data-nsi class="URL_SRV">${user.urlSrv}</span>
                <span data-nsi class="DATE_LOAD">${user.dateLoad}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="NOTE">${user.note}</span>
                <span data-nsi class="JSON_TABLE">${user.jsonTable}</span>
                <span data-nsi class="id">${user.id}</span>
            </td>
            <td class="SQL_TEXT">${user.sqlText}</td>
            <td class="XML_TABLE">${user.xmlTable}</td>
            <td class="URL_SRV">${user.urlSrv}</td>
            <td class="DATE_LOAD">${user.dateLoad}</td>
            <td class="NAME">${user.name}</td>
            <td class="NOTE">${user.note}</td>
            <td class="JSON_TABLE">${user.jsonTable}</td>
            <td class="ID">${user.id}</td>
        </tr>
    </c:forEach>
</c:if>
