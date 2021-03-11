<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<li class="Node ExpandClosed">
    <c:if test="${empty element.child && element.typ eq 2}">
        <div class="Product">
            <div class="Info" hidden>
                <div class="id">${element.id}</div>
                <div class="hiId">${element.hiId}</div>
                <div class="lev">${element.lev}</div>
                <div class="typ">${element.typ}</div>
                <div class="name">${element.name}</div>
                <div class="realId">${element.realId}</div>
                <div class="code">${element.productElement.code}</div>
                <div class="bnId">${element.productElement.bnId}</div>
                <div class="dbId">${element.productElement.dbId}</div>
                <div class="productId">${element.productElement.productId}</div>
            </div>
            <div class="Content">${element.name}</div>
        </div>
    </c:if>
    <c:if test="${empty element.child && element.typ ne 2}">
        <c:if test="${element.typ eq 0}">
            <div class="Expand"></div>
            <div class="Group">
                <div class="Info" hidden>
                    <div class="id">${element.id}</div>
                    <div class="hiId">${element.hiId}</div>
                    <div class="lev">${element.lev}</div>
                    <div class="typ">${element.typ}</div>
                </div>
                <div class="Content">${element.name}</div>
            </div>
        </c:if>
        <c:if test="${element.typ eq 1}">
            <div class="Expand"></div>
            <div class="Criterion">
                <div class="Info" hidden>
                    <div class="id">${element.id}</div>
                    <div class="hiId">${element.hiId}</div>
                    <div class="lev">${element.lev}</div>
                    <div class="typ">${element.typ}</div>
                    <div class="prodHierId">${element.prodHierId}</div>
                </div>
                <div class="Content">${element.name}</div>
            </div>
        </c:if>
    </c:if>
    <c:if test="${not empty element.child && element.typ eq 1}">
        <div class="Expand"></div>
        <div class="Criterion">
            <div class="Info" hidden>
                <div class="id">${element.id}</div>
                <div class="hiId">${element.hiId}</div>
                <div class="lev">${element.lev}</div>
                <div class="typ">${element.typ}</div>
                <div class="prodHierId">${element.prodHierId}</div>
            </div>
            <div class="Content">${element.name}</div>
            <ul class="Container">
                <c:forEach items="${element.child}" var="element">
                    <c:set var="element" value="${element}" scope="request"/>
                    <jsp:include page="treeElementForProduct.jsp"/>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <c:if test="${not empty element.child && element.typ eq 0}">
        <div class="Expand"></div>
        <div class="Group">
            <div class="Info" hidden>
                <div class="id">${element.id}</div>
                <div class="hiId">${element.hiId}</div>
                <div class="lev">${element.lev}</div>
                <div class="typ">${element.typ}</div>
            </div>
            <div class="Content">${element.name}</div>
            <ul class="Container">
                <c:forEach items="${element.child}" var="element">
                    <c:set var="element" value="${element}" scope="request"/>
                    <jsp:include page="treeElementForProduct.jsp"/>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</li>
