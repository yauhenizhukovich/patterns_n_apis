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
                <span data-nsi class="KURS_KOL">${user.kursKol}</span>
                <span data-nsi class="STATE">${user.state}</span>
                <span data-nsi class="BBB_CODE">${user.bbbCode}</span>
                <span data-nsi class="FGENDER">${user.fgender}</span>
                <span data-nsi class="CURR_PERIOD_KOT">${user.currPeriodKot}</span>
                <span data-nsi class="CURR_ORDER">${user.currOrder}</span>
                <span data-nsi class="SIGN_KONTROL">${user.signKontrol}</span>
                <span data-nsi class="PRINT_1P">${user.print1P}</span>
                <span data-nsi class="PRINT_1R">${user.print1R}</span>
                <span data-nsi class="PRINT_2R">${user.print2R}</span>
                <span data-nsi class="PRINT_NP">${user.printNP}</span>
                <span data-nsi class="IGENDER">${user.igender}</span>
                <span data-nsi class="PRINT_NR">${user.printNR}</span>
                <span data-nsi class="PRINT_FNR">${user.printFNR}</span>
                <span data-nsi class="KURS_PRICE">${user.kursPrice}</span>
                <span data-nsi class="KOD_CURR_NUM">${user.kodCurrNum}</span>
                <span data-nsi class="PRINT_F2R">${user.printF2R}</span>
                <span data-nsi class="PRINT_F1">${user.printF1}</span>
                <span data-nsi class="CURR_TYPE">${user.currType}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentId}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="KURS_KOL">${user.kursKol}</td>
            <td class="STATE">${user.state}</td>
            <td class="BBB_CODE">${user.bbbCode}</td>
            <td class="FGENDER">${user.fgender}</td>
            <td class="CURR_PERIOD_KOT">${user.currPeriodKot}</td>
            <td class="CURR_ORDER">${user.currOrder}</td>
            <td class="SIGN_KONTROL">${user.signKontrol}</td>
            <td class="PRINT_1P">${user.print1P}</td>
            <td class="PRINT_1R">${user.print1R}</td>
            <td class="PRINT_2R">${user.print2R}</td>
            <td class="PRINT_NP">${user.printNP}</td>
            <td class="IGENDER">${user.igender}</td>
            <td class="PRINT_NR">${user.printNR}</td>
            <td class="PRINT_FNR">${user.printFNR}</td>
            <td class="KURS_PRICE">${user.kursPrice}</td>
            <td class="KOD_CURR_NUM">${user.kodCurrNum}</td>
            <td class="PRINT_F2R">${user.printF2R}</td>
            <td class="PRINT_F1">${user.printF1}</td>
            <td class="CURR_TYPE">${user.currType}</td>
        </tr>
    </c:forEach>
</c:if>

