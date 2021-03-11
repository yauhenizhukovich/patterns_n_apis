<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Пользователи</title>
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
        <p class="display-4">Пользователи</p>
    </div>

    <div class="table-responsive">
        <table id="nsi-table"  class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Текущая дата</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Имя</th>
                <th scope="col">Отчество</th>
                <th scope="col">Логин</th>
                <th scope="col">Пароль</th>
                <th scope="col">Айди роли</th>
                <th scope="col">Эмейл</th>
                <th scope="col">Телефон</th>
                <th scope="col">Мобильный телефон</th>
                <th scope="col">Дата рождения</th>
                <th scope="col">Деп</th>
                <th scope="col">Работа</th>
                <th scope="col">Признак кураторства</th>
                <th scope="col">Признак блокировки пользователя</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty usersDirectory.users}">
                <c:forEach items="${usersDirectory.users}" var="user">
                    <tr>
                        <td class="info" hidden>
                            <span data-nsi class="id">${user.idUser}</span>
                            <span data-nsi class="adddate">${user.adddate}</span>
                            <span data-nsi class="surname">${user.surname}</span>
                            <span data-nsi class="firstName">${user.firstName}</span>
                            <span data-nsi class="paterName">${user.paterName}</span>
                            <span data-nsi class="userlogin">${user.userlogin}</span>
                            <span data-nsi class="userpwd">${user.userpwd}</span>
                            <span data-nsi class="idRole">${user.idRole}</span>
                            <span data-nsi class="usermail">${user.usermail}</span>
                            <span data-nsi class="phone">${user.phone}</span>
                            <span data-nsi class="mobphone">${user.mobphone}</span>
                            <span data-nsi class="birthdate">${user.birthdate}</span>
                            <span data-nsi class="dept">${user.dept}</span>
                            <span data-nsi class="job">${user.job}</span>
                            <span data-nsi class="iscurator">${user.iscurator}</span>
                            <span data-nsi class="isblocked">${user.isblocked}</span>
                        </td>
                        <td class="idUser">${user.idUser}</td>
                        <td class="adddate">${user.adddate}</td>
                        <td class="surname">${user.surname}</td>
                        <td class="firstName">${user.firstName}</td>
                        <td class="paterName">${user.paterName}</td>
                        <td class="userlogin">${user.userlogin}</td>
                        <td class="userpwd">${user.userpwd}</td>
                        <td class="idRole">${user.idRole}</td>
                        <td class="usermail">${user.usermail}</td>
                        <td class="phone">${user.phone}</td>
                        <td class="mobphone">${user.mobphone}</td>
                        <td class="birthdate">${user.birthdate}</td>
                        <td class="dept">${user.dept}</td>
                        <td class="job">${user.job}</td>
                        <td class="iscurator">${user.iscurator}</td>
                        <td class="isblocked">${user.isblocked}</td>
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
                                <input data-nsi id="input-nsi-id-user-view" name="idUser" hidden disabled>
                                <div class="form-group">
                                    <label for="input-nsi-adddate-view">Текущая дата:</label>
                                    <input data-nsi type="date" name="adddate" class="form-control" id="input-nsi-adddate-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-surname-view">Фамилия:</label>
                                    <input data-nsi name="surname" class="form-control" id="input-nsi-surname-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-first-name-view">Имя:</label>
                                    <input data-nsi name="firstName" class="form-control" id="input-nsi-first-name-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-pater-name-view">Отчество:</label>
                                    <input data-nsi name="paterName" class="form-control" id="input-nsi-pater-name-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-userlogin-view">Логин:</label>
                                    <input data-nsi name="userlogin" class="form-control" id="input-nsi-userlogin-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-userpwd-view">Пароль:</label>
                                    <input data-nsi name="userpwd" class="form-control" id="input-nsi-userpwd-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-id-role-view">Айди роли:</label>
                                    <input data-nsi name="idRole" class="form-control" id="input-nsi-id-role-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-usermail-view">Эмейл:</label>
                                    <input data-nsi name="usermail" class="form-control" id="input-nsi-usermail-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-phone-view">Телефон:</label>
                                    <input data-nsi name="phone" class="form-control" id="input-nsi-phone-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-mobphone-view">Мобильный телефон:</label>
                                    <input data-nsi name="mobphone" class="form-control" id="input-nsi-mobphone-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-birthdate-view">Дата рождения:</label>
                                    <input data-nsi type="date" name="birthdate" class="form-control" id="input-nsi-birthdate-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-dept-view">Деп:</label>
                                    <input data-nsi name="dept" class="form-control" id="input-nsi-dept-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-bank-job-view">Работа:</label>
                                    <input data-nsi name="job" class="form-control" id="input-nsi-bank-job-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-iscurator-view">Признак кураторства:</label>
                                    <input data-nsi type="iscurator" min="0" max="1" name="roleName" class="form-control" id="input-nsi-iscurator-view" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-isblocked-view">Признак блокировки:</label>
                                    <input data-nsi type="isblocked" min="0" max="1" name="description" class="form-control" id="input-nsi-isblocked-view" disabled>
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
                            <form action="<c:url value="/nsi/users/create"/>" method="post">
                                <div class="form-group">
                                    <label for="input-nsi-id-user-create">Айди:</label>
                                    <input name="idUser" class="form-control" id="input-nsi-id-user-create"
                                           placeholder="Идентификатор роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-adddate-create">Текущая дата (*):</label>
                                    <input name="adddate" type="date" class="form-control" id="input-nsi-adddate-create"
                                           placeholder="Название роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-surname-create">Фамилия:</label>
                                    <input name="surname" class="form-control" id="input-nsi-surname-create"
                                           placeholder="Список операций">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-first-name-create">Имя:</label>
                                    <input name="firstName" class="form-control" id="input-nsi-first-name-create"
                                           placeholder="Список пользователей">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-pater-name-create">Отчество (*):</label>
                                    <input name="paterName" class="form-control" id="input-nsi-pater-name-create"
                                           placeholder="Идентификатор роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-userlogin-create">Логин (*):</label>
                                    <input name="userlogin" class="form-control" id="input-nsi-userlogin-create"
                                           placeholder="Название роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-userpwd-create">Пароль:</label>
                                    <input name="userpwd" class="form-control" id="input-nsi-userpwd-create"
                                           placeholder="Список операций">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-id-role-create">Айди роли:</label>
                                    <input name="idRole" class="form-control" id="input-nsi-id-role-create"
                                           placeholder="Список пользователей">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-usermail-create">Эмейл (*):</label>
                                    <input name="usermail" class="form-control" id="input-nsi-usermail-create"
                                           placeholder="Идентификатор роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-phone-create">Телефон (*):</label>
                                    <input name="phone" class="form-control" id="input-nsi-phone-create"
                                           placeholder="Название роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-mobphone-create">Мобильный телефон:</label>
                                    <input name="mobphone" class="form-control" id="input-nsi-mobphone-create"
                                           placeholder="Список операций">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-birthdate-create">Дата рождения:</label>
                                    <input name="birthdate" type="date" class="form-control" id="input-nsi-birthdate-create"
                                           placeholder="Список пользователей">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-dept-create">Деп (*):</label>
                                    <input name="dept" class="form-control" id="input-nsi-dept-create"
                                           placeholder="Идентификатор роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-job-create">Работа (*):</label>
                                    <input name="job" class="form-control" id="input-nsi-job-create"
                                           placeholder="Название роли" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-iscurator-create">Признак кураторства:</label>
                                    <input name="iscurator" type="number" min="0" max="1" class="form-control" id="input-nsi-iscurator-create"
                                           placeholder="Список операций">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-isblocked-create">Признак блокировки пользователя:</label>
                                    <input name="isblocked" type="number" min="0" max="1" class="form-control" id="input-nsi-isblocked-create"
                                           placeholder="Список операций">
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
