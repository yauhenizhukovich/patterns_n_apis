<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden="">
                <span data-nsi="" class="id">${user.code}</span>
                <span data-nsi="" class="NAME">${user.name}</span>
            </td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
        </tr>
    </c:forEach>
</c:if>
