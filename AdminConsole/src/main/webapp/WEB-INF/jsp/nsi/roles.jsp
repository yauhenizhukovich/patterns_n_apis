<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Роли</title>
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
        <p class="display-4">Роли</p>
    </div>

    <div class="table-responsive">
        <table id="nsi-table"  class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Идентификатор роли</th>
                <th scope="col">Название роли</th>
                <th scope="col">Список операций</th>
                <th scope="col">Список пользователей</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty rolesDirectory.roles}">
                <c:forEach items="${rolesDirectory.roles}" var="role">
                    <tr>
                        <td class="info" hidden>
                            <span data-nsi class="id">${role.idRole}</span>
                            <span data-nsi class="roleName">${role.roleName}</span>
                            <span data-nsi class="description">${role.description}</span>
                            <span data-nsi class="loginUser">${role.loginUser}</span>
                        </td>
                        <td class="idRole">${role.idRole}</td>
                        <td class="roleName">${role.roleName}</td>
                        <td class="description">${role.description}</td>
                        <td class="loginUser">${role.loginUser}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
    <div class="nsi-directory-page-buttons float-right">
        <button type="button" class="btn create-nsi-modal-button" data-toggle="modal" data-target=".create-nsi-entry-modal">
            Добавить
        </button>
        <button type="button" class="btn view-nsi-modal-button" disabled>
            Просмотреть
        </button>
        <button type="button" class="btn nsi-edit-entry-modal-button" disabled>
            Редактировать
        </button>
        <button type="button" class="btn nsi-remove-entry-button" disabled>
            Удалить
        </button>
    </div>

    <div class="modal fade view-nsi-entry-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content view-nsi-entry-modal-content">
                <div class="modal-header view-nsi-entry-modal-header">
                    <h5 class="modal-title">Просмотр записи</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="view-nsi-entry-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">
                            <form>
                                <input data-nsi id="input-nsi-id-role-view" name="idRole" hidden disabled>
                                <div class="form-group">
                                    <label for="input-nsi-bank-id-role-view">Идентификатор роли:</label>
                                    <input data-nsi name="idRole" class="form-control" id="input-nsi-bank-id-role-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-role-name-view">Название роли:</label>
                                    <input data-nsi name="roleName" class="form-control" id="input-nsi-role-name-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-description-view">Список операций:</label>
                                    <input data-nsi name="description" class="form-control" id="input-nsi-description-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-loginUser-view">Список пользователей:</label>
                                    <input data-nsi name="loginUser" class="form-control" id="input-nsi-loginUser-view" disabled>
                                </div>
                                <div class="row nsi-entry-buttons justify-content-center">
                                    <button type="button" class="btn nsi-edit-entry-button">Редактировать</button>
                                    <button type="button" class="btn nsi-delete-entry-button">Удалить</button>
                                </div>
                                <div class="row nsi-entry-edit-buttons float-right" hidden="">
                                    <button type="button" class="btn nsi-edit-save-button">Сохранить</button>
                                    <button type="button" class="btn nsi-edit-cancel-button">Отмена</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%----%>
    <div class="modal fade create-nsi-entry-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-nsi-entry-modal-content">
                <div class="modal-header create-nsi-entry-modal-header">
                    <h5 class="modal-title">Создать запись в справочнике</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-nsi-entry-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">
                            <form action="<c:url value="/nsi/roles/create"/>" method="post">
                                <div class="form-group">
                                    <label for="input-nsi-id-role-create">Идентификатор роли (*):</label>
                                    <input name="idRole" class="form-control" id="input-nsi-id-role-create"
                                           placeholder="Идентификатор роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-role-name-create">Название роли (*):</label>
                                    <input name="roleName" class="form-control" id="input-nsi-role-name-create"
                                           placeholder="Название роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-description-create">Список операций:</label>
                                    <input name="description" class="form-control" id="input-nsi-description-create"
                                           placeholder="Список операций">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-login-user-create">Список пользователей:</label>
                                    <input name="loginUser" class="form-control" id="input-nsi-login-user-create"
                                           placeholder="Список пользователей">
                                </div>
                                <div class="row float-right">
                                    <button class="btn create-nsi-entry-submit-button">Создать</button>
                                    <button type="button" class="btn create-cancel-nsi-entry-button">Отмена</button>
                                </div>
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
<script src="${pageContext.request.contextPath}/js/nsi.js"></script>
</body>
</html>
