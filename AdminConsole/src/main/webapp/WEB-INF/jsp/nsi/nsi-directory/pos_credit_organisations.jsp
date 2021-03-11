<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.dimid}</span>
                <span data-nsi class="PARENTID">${user.parentId}</span>
                <span data-nsi class="CODE">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="PKO_NAME">${user.pkoName}</span>
                <span data-nsi class="PKO_ADRESS">${user.pkoAdress}</span>
                <span data-nsi class="PKO_UNP">${user.pkoUnp}</span>
                <span data-nsi class="PKO_BANKS">${user.pkoBanks}</span>
                <span data-nsi class="PKO_ACCOUNT">${user.pkoAccount}</span>
                <span data-nsi class="PKO_BANKS_POS">${user.pkoBankPos}</span>
                <span data-nsi class="PKO_NAME_TT">${user.pkoNameTt}</span>
                <span data-nsi class="PKO_ADRESS_TT">${user.pkoAdressTt}</span>
                <span data-nsi class="PKO_UNP_TT">${user.pkoUnpTt}</span>
                <span data-nsi class="PKO_BANKS_TT">${user.pkoBanksTt}</span>
                <span data-nsi class="PKO_ACCOUNT_TT">${user.pkoAccountTt}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentId}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="PKO_NAME">${user.pkoName}</td>
            <td class="PKO_ADRESS">${user.pkoAdress}</td>
            <td class="PKO_UNP">${user.pkoUnp}</td>
            <td class="PKO_BANKS">${user.pkoBanks}</td>
            <td class="PKO_ACCOUNT">${user.pkoAccount}</td>
            <td class="PKO_BANKS_POS">${user.pkoBankPos}</td>
            <td class="PKO_NAME_TT">${user.pkoNameTt}</td>
            <td class="PKO_ADRESS_TT">${user.pkoAdressTt}</td>
            <td class="PKO_UNP_TT">${user.pkoUnpTt}</td>
            <td class="PKO_BANKS_TT">${user.pkoBanksTt}</td>
            <td class="PKO_ACCOUNT_TT">${user.pkoAccountTt}</td>

        </tr>
    </c:forEach>
</c:if>

