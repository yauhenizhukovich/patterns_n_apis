<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="sysparam">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${sysparam.id}</span>
                <span data-nsi class="CODE">${sysparam.code}</span>
                <span data-nsi class="NAME">${sysparam.name}</span>
                <span data-nsi class="NOTE">${sysparam.note}</span>

            </td>
            <td class="ID">${sysparam.id}</td>
            <td class="CODE">${sysparam.code}</td>
            <td class="NAME">${sysparam.name}</td>
            <td class="NOTE">${sysparam.note}</td>
        </tr>
    </c:forEach>
</c:if>

