<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Роли</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<jsp:include page="component/main-navbar.jsp"/>
<jsp:include page="component/side-navbar.jsp"/>

<div id="page-content">
    <div class="row justify-content-center page-title">
        <p class="display-4">Роли</p>
    </div>

    <table id="roles-table" class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Описание</th>
            <th scope="col">Пользователи</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty groups}">
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td class="table-role-name">${group.name}</td>
                    <td class="table-role-description">${group.description}</td>
                    <td class="table-user-groups">
                        <c:forEach items="${group.usernames}" var="users">
                            ${users.login}
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>


    <div class="roles-page-buttons float-right">
        <button type="button" class="btn role-modal-button" disabled>
            Назначить Пользователя
        </button>

        <button type="button" class="btn show-role-modal-button" disabled>
            Просмотреть
        </button>
    </div>


    <div class="modal fade show-users-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-role-modal-content">
                <div class="modal-header create-role-modal-header">
                    <h5 class="modal-title">Просмотр подразделения</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-role-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12" id="coll">

                        </div>

                        <div>


                            <button type="button"  class="btn xxx" data-dismiss="modal" aria-label="Close">
                                Отмена
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade role-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content user-role-modal-content">
                <div class="modal-header user-role-modal-header">
                    <h5 class="modal-title">Назначить роль</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="user-role-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body user-role-modal-body">
                    <div class="row justify-content-center">
                        <div class="col-5 user-role-modal-left-panel">

                            <ul class="list-group role-modal-left-list">
                            </ul>
                        </div>
                        <div class="col-1">
                            <button type="button" class="btn role-modal-move-all-to-right-button">
                                &gt;&gt;
                            </button>
                            <button type="button" class="btn role-modal-move-to-right-button">&gt;</button>
                            <button type="button" class="btn role-modal-move-to-left-button">&lt;</button>
                            <button type="button" class="btn role-modal-move-all-to-left-button">&lt;&lt;
                            </button>
                        </div>
                        <div class="col-5 user-role-modal-right-panel">
                            <ul class="list-group role-modal-right-list">
                            </ul>
                        </div>
                    </div>
                    <div class="row role-modal-bottom  justify-content-center">
                        <p class="roles-issue-left">Доступные пользователи</p>
                        <div class="user-role-submit">
                            <button class="btn role-submit-button">
                                Назначить
                                <input class="role-modal-username" type="hidden" value="">
                            </button>
                        </div>
                        <p class="roles-issue-right">Пользователи роли</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade edit-role-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content edit-role-modal-content">
                <div class="modal-header edit-role-modal-header">
                    <h5 class="modal-title">Редактировать роль</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="edit-role-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">
                            <form name="rolesForm2" action="<c:url value="/edit-role"/>" method="post"
                                  onsubmit="return validateFormRole2()">
                                <div class="form-group">
                                    <label for="input-role-name-edit">Название:</label>
                                    <input name="roleName2" class="form-control" id="input-role-name-edit" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="input-role-description-edit">Описание:</label>
                                    <textarea name="roleDescription2" class="form-control"
                                              id="input-role-description-edit"
                                              rows="3"></textarea>
                                </div>
                                <button class="btn edit-role-submit-button">Сохранить</button>
                                <button type="button" class="btn role-modal-button" style="float: right">Назначить Пользователя</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/side-navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/content-inject.js"></script>
<script src="${pageContext.request.contextPath}/js/roles.js"></script>
</body>
</html>