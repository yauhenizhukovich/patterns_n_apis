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
                <span data-nsi class="NSI_116_SH_VD">${user.nsi116ShVd}</span>
                <span data-nsi class="NSI_116_GROUP_NUM">${user.nsi116GroupNum}</span>
                <span data-nsi class="NSI_116_TARIF">${user.nsi116Tarif}</span>
                <span data-nsi class="NSI_116_OP">${user.nsi116Op}</span>
                <span data-nsi class="NSI_116_DATE_CLOSE">${user.nsi116DateClose}</span>
                <span data-nsi class="NSI_116_TUNN">${user.nsi116Tunn}</span>
                <span data-nsi class="NSI_116_AVALIABLE_FOR_DBO">${user.nsi116AvaliableForDbo}</span>
                <span data-nsi class="NSI_116_TMIN">${user.nsi116Tmin}</span>
                <span data-nsi class="NSI_116_NOPAY">${user.nsi116Nopay}</span>
                <span data-nsi class="NSI_116_SH_VO">${user.nsi116ShVo}</span>
                <span data-nsi class="NSI_116_TYPE_TARIF">${user.nsi116TypeTarif}</span>
                <span data-nsi class="NSI_116_DATE_OPEN">${user.nsi116DateOpen}</span>
                <span data-nsi class="NSI_116_SH_OP">${user.nsi116ShOp}</span>
                <span data-nsi class="NSI_116_PACK_GROUP">${user.nsi116PackGroup}</span>
                <span data-nsi class="NSI_116_VAL">${user.nsi116Val}</span>
                <span data-nsi class="NSI_116_SH_NP">${user.nsi116ShNp}</span>
                <span data-nsi class="NSI_116_TMAX">${user.nsi116Tmax}</span>
                <span data-nsi class="NSI_116_TPODR">${user.nsi116Tpodr}</span>
                <span data-nsi class="NSI_116_TYPE_ITEM">${user.nsi116TypeItem}</span>
                <span data-nsi class="NSI_116_TVAL">${user.nsi116Tval}</span>
            </td>
            <td class="DIMID">${user.dimid}</td>
            <td class="PARENTID">${user.parentId}</td>
            <td class="CODE">${user.code}</td>
            <td class="NAME">${user.name}</td>
            <td class="NSI_116_SH_VD">${user.nsi116ShVd}</td>
            <td class="NSI_116_GROUP_NUM">${user.nsi116GroupNum}</td>
            <td class="NSI_116_TARIF">${user.nsi116Tarif}</td>
            <td class="NSI_116_OP">${user.nsi116Op}</td>
            <td class="NSI_116_DATE_CLOSE">${user.nsi116DateClose}</td>
            <td class="NSI_116_TUNN">${user.nsi116Tunn}</td>
            <td class="NSI_116_AVALIABLE_FOR_DBO">${user.nsi116AvaliableForDbo}</td>
            <td class="NSI_116_TMIN">${user.nsi116Tmin}</td>
            <td class="NSI_116_NOPAY">${user.nsi116Nopay}</td>
            <td class="NSI_116_SH_VO">${user.nsi116ShVo}</td>
            <td class="NSI_116_TYPE_TARIF">${user.nsi116TypeTarif}</td>
            <td class="NSI_116_DATE_OPEN">${user.nsi116DateOpen}</td>
            <td class="NSI_116_SH_OP">${user.nsi116ShOp}</td>
            <td class="NSI_116_PACK_GROUP">${user.nsi116PackGroup}</td>
            <td class="NSI_116_VAL">${user.nsi116Val}</td>
            <td class="NSI_116_SH_NP">${user.nsi116ShNp}</td>
            <td class="NSI_116_TMAX">${user.nsi116Tmax}</td>
            <td class="NSI_116_TPODR">${user.nsi116Tpodr}</td>
            <td class="NSI_116_TYPE_ITEM">${user.nsi116TypeItem}</td>
            <td class="NSI_116_TVAL">${user.nsi116Tval}</td>
        </tr>
    </c:forEach>
</c:if>

