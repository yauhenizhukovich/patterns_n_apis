<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<li class="Node ExpandClosed">
    <c:if test="${element.typ ne 2}">
        <div class="Expand"></div>
    </c:if>
    <div class="Info" hidden>
        <div class="id">${element.id}</div>
        <div class="hiId">${element.hiId}</div>
        <div class="lev">${element.lev}</div>
        <div class="typ">${element.typ}</div>
        <div class="realId">${element.realId}</div>
        <div class="realHiId">${element.realHiId}</div>
    </div>

    <div class="Content">${element.name}</div>
    <c:if test="${not empty element.child}">
        <ul class="Container">
            <c:forEach items="${element.child}" var="element">
                <c:set var="element" value="${element}" scope="request"/>
                <jsp:include page="treeElement.jsp"/>
            </c:forEach>
        </ul>
    </c:if>
</li>