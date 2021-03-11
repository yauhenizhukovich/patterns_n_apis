<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Журнал аудита системных событий</title>
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
        <p class="display-4">Журнал аудита системных событий</p>
    </div>

    <div class="table-responsive">
        <table id="audit-table" class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Дата, время</th>
                <th scope="col">Тип сообщения</th>
                <th scope="col">Источник записи</th>
                <th scope="col">Имя сервера</th>
                <th scope="col">Текст сообщения</th>

            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty logSysEventDirectory.logSysEvents}">
                <c:forEach items="${logSysEventDirectory.logSysEvents}" var="logSysEvent">
                    <td class="info" hidden>
                        <span data-audit class="id">${logSysEvent.eventDate}</span>
                        <span data-audit class="eventType">${logSysEvent.eventType}</span>
                        <span data-audit class="eventSource">${logSysEvent.eventSource}</span>
                        <span data-audit class="serverName">${logSysEvent.serverName}</span>
                        <span data-audit class="message">${logSysEvent.message}</span>
                    </td>
                    <tr>
                        <td class="eventDate">${logSysEvent.eventDate}</td>
                        <td class="eventType">${logSysEvent.eventType}</td>
                        <td class="eventSource">${logSysEvent.eventSource}</td>
                        <td class="serverName">${logSysEvent.serverName}</td>
                        <td class="message">${logSysEvent.message}</td>
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