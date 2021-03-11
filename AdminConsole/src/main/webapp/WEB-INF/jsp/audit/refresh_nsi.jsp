<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${directoryDTO.tableData.nameOfTable}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<domain id="domain" name="${domain}"></domain>
<jsp:include page="../component/main-navbar.jsp"/>
<jsp:include page="../component/side-navbar.jsp"/>
<div id="page-content">

    <h3>Чтобы обновить справочники НСИ нажмите кнопку.</h3>

    ${last_update_time}

    <form action="<c:url value="/audit/refresh_nsi/refresh"/>" method="post">
        <button class="btn btn-primary">Обновить</button>
    </form>

    <output>Дата последнего обновления: </output> <c:forEach items="${lastUpdateTime}" var="time">${time.value}</c:forEach>


</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/side-navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/content-inject.js"></script>
<script src="${pageContext.request.contextPath}/js/nsi.js"></script>
</body>
</html>
