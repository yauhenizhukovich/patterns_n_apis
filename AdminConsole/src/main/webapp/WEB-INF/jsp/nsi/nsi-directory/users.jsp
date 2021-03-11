<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.idUser}</span>
                <span data-nsi class="ADDDATE">${user.addate}</span>
                <span data-nsi class="SURNAME">${user.surname}</span>
                <span data-nsi class="FIRST_NAME">${user.firstName}</span>
                <span data-nsi class="PATER_NAME">${user.paterName}</span>
                <span data-nsi class="USERLOGIN">${user.userlogin}</span>
                <span data-nsi class="USERPWD">${user.userpwd}</span>
                <span data-nsi class="ID_ROLE">${user.idRole}</span>
                <span data-nsi class="USEREMAIL">${user.usermail}</span>
                <span data-nsi class="PHONE">${user.phone}</span>
                <span data-nsi class="MOBPHONE">${user.mobphone}</span>
                <span data-nsi class="BIRTHDATE">${user.birthdate}</span>
                <span data-nsi class="DEPT">${user.dept}</span>
                <span data-nsi class="JOB">${user.job}</span>
                <span data-nsi class="ISCURATOR">${user.iscurator}</span>
                <span data-nsi class="ISBLOCKED">${user.isblocked}</span>
            </td>
            <td class="ID_USER">${user.idUser}</td>
            <td class="ADDDATE">${user.addate}</td>
            <td class="SURNAME">${user.surname}</td>
            <td class="FIRST_NAME">${user.firstName}</td>
            <td class="PATER_NAME">${user.paterName}</td>
            <td class="USERLOGIN">${user.userlogin}</td>
            <td class="USERPWD">${user.userpwd}</td>
            <td class="ID_ROLE">${user.idRole}</td>
            <td class="USEREMAIL">${user.usermail}</td>
            <td class="PHONE">${user.phone}</td>
            <td class="MOBPHONE">${user.mobphone}</td>
            <td class="BIRTHDATE">${user.birthdate}</td>
            <td class="DEPT">${user.dept}</td>
            <td class="JOB">${user.job}</td>
            <td class="ISCURATOR">${user.iscurator}</td>
            <td class="ISBLOCKED">${user.isblocked}</td>
        </tr>
    </c:forEach>
</c:if>

