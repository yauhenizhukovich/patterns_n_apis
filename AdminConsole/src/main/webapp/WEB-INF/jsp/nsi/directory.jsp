<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
<c:if test="${not empty fail}">
    <th scope="col">${fail}</th>
</c:if>

    <jsp:include page="../nsi/nsi-component/tablename-div.jsp"/>
    <div class="table-responsive">
        <table id="nsi-table"  class="table table-bordered">
            <thead>
            <tr>
                <c:if test="${not empty directoryDTO.tableData.nameOfColumns}">
                    <c:forEach items="${directoryDTO.tableData.nameOfColumns}" var="column">
                        <th scope="col">${column.value}</th>
                    </c:forEach>
                </c:if>
            </tr>
            </thead>
            <tbody>
                <jsp:include page="../nsi/nsi-directory/${domain}.jsp"/>
            </tbody>
        </table>
    </div>
    <jsp:include page="../nsi/nsi-component/buttons-div.jsp"/>

    <jsp:include page="../nsi/nsi-component/view-div.jsp"/>
    <jsp:include page="../nsi/nsi-component/create-div.jsp"/>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/side-navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/content-inject.js"></script>
<script src="${pageContext.request.contextPath}/js/nsi.js"></script>
</body>
</html>
