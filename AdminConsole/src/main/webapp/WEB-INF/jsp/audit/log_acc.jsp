<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Журнал аудита синхронизации данных счета/договора/клиента</title>
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
        <p class="display-4">Журнал аудита синхронизации данных счета/договора/клиента</p>
    </div>

    <div class="table-responsive">
        <table id="nsi-table"  class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Название Планировщика</th>
                <th scope="col">Идентификатор записи в НСИ</th>
                <th scope="col">Дата, время</th>
                <th scope="col">Действие</th>
                <th scope="col">Результат синхронизации</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty logAccDirectory.logAccs}">
                <c:forEach items="${logAccDirectory.logAccs}" var="logAcc">
                    <tr>
                        <td class="info" hidden>
                            <span data-nsi class="id">${logAcc.taskName}</span>
                            <span data-nsi class="nsiId">${logAcc.nsiId}</span>
                            <span data-nsi class="syncDate">${logAcc.syncDate}</span>
                            <span data-nsi class="syncAction">${logAcc.syncAction}</span>
                            <span data-nsi class="syncResult">${logAcc.syncResult}</span>
                        </td>
                        <td class="taskName">${logAcc.taskName}</td>
                        <td class="nsiId">${logAcc.nsiId}</td>
                        <td class="syncDate">${logAcc.syncDate}</td>
                        <td class="syncAction">${logAcc.syncAction}</td>
                        <td class="syncResult">${logAcc.syncResult}</td>
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
<script src="${pageContext.request.contextPath}/js/nsi.js"></script>
</body>
</html>
