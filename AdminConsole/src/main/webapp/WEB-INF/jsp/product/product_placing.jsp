<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Размещение продуктов</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tree.css">
</head>
<body>
<jsp:include page="../component/main-navbar.jsp"/>
<jsp:include page="../component/side-navbar.jsp"/>

<div id="page-content">
    <div class="row justify-content-center page-title">
        <p class="display-4">Размещение продуктов</p>
    </div>
    <div id="product-group-list" hidden>
        <c:forEach items="${productGroups}" var="productGroup">
            <div class="productGroupData">
                <span class="id">${productGroup.id}</span>
                <span class="hiId">${productGroup.hiId}</span>
                <span class="name">${productGroup.name}</span>
                <span class="lev">${productGroup.lev}</span>
                <span class="tableName">${productGroup.tableName}</span>
            </div>
        </c:forEach>
    </div>

    <div class="product-placing-header">
        <form method="get" action="${pageContext.request.contextPath}/product_placing/filter" class="filter-form" id="filter-form">
            <div class="filter-hierarchy-tree">
                <select name="firstLevelProductGroup" class="group-hierarchy-list" id="firstLevelProductGroup">
                    <option value="0" selected disabled>Бизнес-направление</option>
                    <c:forEach items="${productGroups}" var="productGroup">
                        <c:if test="${productGroup.lev eq 1}">
                            <option value="${productGroup.id}">${productGroup.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <select name="secondLevelProductGroup" class="group-hierarchy-list" id="secondLevelProductGroup">
                    <option value="0" selected disabled>Класс продукта</option>
                </select>
                <select name="thirdLevelProductGroup" class="group-hierarchy-list" id="thirdLevelProductGroup">
                    <option value="0" selected disabled>Группа продукта</option>
                </select>
                <select name="fourthLevelProductGroup" class="group-hierarchy-list" id="fourthLevelProductGroup">
                    <option value="0" selected disabled>Вид продукта</option>
                </select>
                <select name="fifthLevelProductGroup" class="group-hierarchy-list" id="fifthLevelProductGroup">
                    <option value="0" selected disabled>Подвид продукта</option>
                </select>
                <select name="currency" class="group-hierarchy-list" id="currency">
                    <option value="0" selected disabled>Валюта</option>
                    <c:forEach items="${currencyList.directory}" var="currency">
                        <option value="${currency.dimid}">${currency.name}</option>
                    </c:forEach>
                </select>
                <select name="status" class="group-hierarchy-list" id="status">
                    <option value="0" selected disabled>Статус</option>
                    <c:forEach items="${statusList.directory}" var="status">
                        <option value="${status.nameRus}">${status.nameRus}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="find-button find-button-div">
                <button type="submit" form="filter-form" class="btn find-button">Фильтр</button>
            </div>
        </form>
    </div>

    <div class="buttons-for-product-manipulation">
        <div class="find-button">
            <button type="submit" id="edit-product-placing-button" class="btn edit-product-placing-button" disabled>Изменить размещение</button>
        </div>
        <div class="find-button">
            <button type="submit" id="check-product-button" class="btn check-product-button" disabled>Просмотреть продукт</button>
        </div>
    </div>


    <c:if test="${not empty tree}">
        <div id="tree">
            <div onclick="tree_toggle(arguments[0])">
                <div>Дерево</div>
                <ul class="Container">
                    <c:forEach items="${tree.child}" var="element">
                        <c:set var="element" value="${element}" scope="request"/>
                        <jsp:include page="treeElementForProduct.jsp"/>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </c:if>

    <div class="info-product-block" id="info-product-block" hidden>
        <div class="id-of-product" value="" hidden></div>
        <div class="name-of-product-block flex">
            <h6 class="label-name-of-product">Название продукта: </h6>
            <h6 class="name-of-product"></h6>
        </div>
        <div class="code-of-product-block flex">
            <h6 class="label-code-of-product">Код продукта: </h6>
            <h6 class="code-of-product"></h6>
        </div>
        <div class="species-of-product-block flex">
            <h6 class="label-species-of-product">Вид продукта: </h6>
            <select name="species-of-product" class="form-control species-of-product" id="species-of-product" required>
                <option value=""></option>
            </select>
        </div>
        <div class="subspecies-of-product-block flex">
            <h6 class="label-subspecies-of-product">Подвид продукта: </h6>
            <select name="subspecies-of-product" class="form-control subspecies-of-product" id="subspecies-of-product" required>
                <option value=""></option>
            </select>
        </div>
        <div class="product-block-manipulations-buttons">
            <div class="find-button">
                <button type="submit" id="cancel-product-change-button" class="btn cancel-product-change-button">Отмена</button>
            </div>
            <div class="find-button">
                <button type="submit" id="save-product-change-button" class="btn save-product-change-button" disabled>Сохранить</button>
            </div>
        </div>
    </div>


    <div class="real-product-info-block" id="real-product-info-block" hidden></div>

</div>


<script src="${pageContext.request.contextPath}/js/product/tree.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/side-navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/content-inject.js"></script>
<script src="${pageContext.request.contextPath}/js/product/product.js"></script>

</body>
</html>
