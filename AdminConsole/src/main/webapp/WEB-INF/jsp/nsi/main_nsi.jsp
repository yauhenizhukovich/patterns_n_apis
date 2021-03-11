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


    <div class="table-responsive">
        <table id="nsi-table" class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Справочники НСИ</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty tablesDescription.tables}">
                <c:forEach items="${tablesDescription.tables}" var="table">
                    <tr>
                        <td class="NAME">
                            <a class="nav-link" href="<c:url value="/nsi/${table.key}"/>"><span
                                    class="fa fa-sticky-note mr-3"></span>
                                ${table.value}
                            </a>
                        </td>
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
