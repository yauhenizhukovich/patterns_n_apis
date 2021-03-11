<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Журнал аудита синхронизации НСИ</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<jsp:include page="../component/main-navbar.jsp"/>
<jsp:include page="../component/side-navbar.jsp"/>

<div id="page-content">
    <div class="row justify-content-center page-title">
        <p class="display-4">Журнал аудита синхронизации НСИ</p>
    </div>

    <div class="table-responsive">
        <table id="audit-table" class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Идентификатор записи в НСИ</th>
                <th scope="col">Название НСИ Системы</th>
                <th scope="col">Дата, время</th>
                <th scope="col">Действие</th>
                <th scope="col">Результат синхронизации</th>

            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty logNsiDirectory.logNsis}">
                <c:forEach items="${logNsiDirectory.logNsis}" var="logNsi">
                    <td class="info" hidden>
                        <span data-audit class="id">${logNsi.nsiName}</span>
                        <span data-audit class="nsiId">${logNsi.nsiId}</span>
                        <span data-audit class="syncDate">${logNsi.syncDate}</span>
                        <span data-audit class="syncAction">${logNsi.syncAction}</span>
                        <span data-audit class="syncResult">${logNsi.syncResult}</span>
                    </td>
                    <tr>
                        <td class="nsiName">${logNsi.nsiName}</td>
                        <td class="nsiId">${logNsi.nsiId}</td>
                        <td class="syncDate">${logNsi.syncDate}</td>
                        <td class="syncAction">${logNsi.syncAction}</td>
                        <td class="syncResult">${logNsi.syncResult}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>

</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/side-navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/content-inject.js"></script>
<script src="${pageContext.request.contextPath}/js/audit.js"></script>
</body>
</html>