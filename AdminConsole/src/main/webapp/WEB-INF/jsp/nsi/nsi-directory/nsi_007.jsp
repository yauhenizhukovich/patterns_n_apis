<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty directoryDTO.directory}">
    <c:forEach items="${directoryDTO.directory}" var="user">
        <tr>
            <td class="info" hidden>
                <span data-nsi class="id">${user.dimid}</span>
                <span data-nsi class="CODE">${user.code}</span>
                <span data-nsi class="NAME">${user.name}</span>
                <span data-nsi class="NAME_SWIFT">${user.nameSwift}</span>
                <span data-nsi class="BORDER_STATE">${user.borderState}</span>
                <span data-nsi class="RATING_VALUTA">${user.ratingValuta}</span>
                <span data-nsi class="CODE_SWIFT">${user.codeSwift}</span>
                <span data-nsi class="RATING_NACVAL">${user.ratingNacval}</span>
                <span data-nsi class="SIGN_OESR">${user.signOesr}</span>
                <span data-nsi class="OFFSHOR_ZONE">${user.offshorZone}</span>
                <span data-nsi class="SIGN_EU">${user.signEu}</span>
                <span data-nsi class="SIGNS_CORRUPTION">${user.signsCorruption}</span>
                <span data-nsi class="HAZARDOUS_REGION">${user.hazardousRegion}</span>
                <span data-nsi class="CODE_VALUTA">${user.codeValuta}</span>
                <span data-nsi class="ISO_ALPHA3_CODE">${user.isoAlpha3Code}</span>
                <span data-nsi class="GROUP_COUNTRY">${user.groupCountry}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="NAME_SWIFT">${user.nameSwift}</td>
            <td class="BORDER_STATE">${user.borderState}</td>
            <td class="RATING_VALUTA">${user.ratingValuta}</td>
            <td class="CODE_SWIFT">${user.codeSwift}</td>
            <td class="RATING_NACVAL">${user.ratingNacval}</td>
            <td class="SIGN_OESR">${user.signOesr}</td>
            <td class="OFFSHOR_ZONE">${user.offshorZone}</td>
            <td class="SIGN_EU">${user.signEu}</td>
            <td class="SIGNS_CORRUPTION">${user.signsCorruption}</td>
            <td class="HAZARDOUS_REGION">${user.hazardousRegion}</td>
            <td class="CODE_VALUTA">${user.codeValuta}</td>
            <td class="ISO_ALPHA3_CODE">${user.isoAlpha3Code}</td>
            <td class="GROUP_COUNTRY">${user.groupCountry}</td>
        </tr>
    </c:forEach>
</c:if>

