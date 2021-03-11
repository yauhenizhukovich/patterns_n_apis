<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Пользователи</title>
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
        <p class="display-4">Пользователи</p>
    </div>

        <table id="users-table" class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Логин</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Роли</th>
                <th scope="col">Дата добавления</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty usersList}">
                <c:forEach items="${usersList}" var="user">
                    <tr>
                        <td class="table-user-name">${user.login}</td>
                        <td class="table-user-domain">${user.surName}</td>
                        <td class="table-user-groups">
                            <c:forEach items="${user.groups}" var="groups">
                                ${groups.name}
                            </c:forEach>
                        </td>
                        <td class="table-user-description">${user.adddate}</td>
                    </tr>
                </c:forEach>
            </c:if>

            </tbody>
        </table>



    <div class="users-page-buttons float-right">
        <button type="button" class="btn user-info-modal-button" disabled>Просмотреть</button>
        <button type="button" class="btn create-user-modal-button" data-toggle="modal" data-target=".create-user-modal">
            Добавить пользователя
        </button>
        <button type="button" class="btn user-role-modal-button" disabled>
            Назначить роль
        </button>
    </div>


    <%--_______________CREATING USER_______________--%>
    <div class="modal fade create-user-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-user-modal-content">
                <div class="modal-header create-user-modal-header">
                    <h5 class="modal-title">Создать пользователя</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-user-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">

                            <div class="form-group">
                                <label for="input-username-create" id="login-input-label">Логин:</label>
                                <input name="userName" required="required" class="form-control"
                                       id="input-username-create"
                                       placeholder="Обязательно">
                            </div>
                            <div class="form-group">
                                <label for="input-user-password-create" id="input-user-password-label">Пароль:</label>
                                <input type="password" class="form-control" name="surName"
                                       id="input-user-password-create"
                                       placeholder="Минимум 8 символов">
                            </div>

                            <div class="form-group">
                                <label id="input-user-surName-label">Фамилия :</label>
                                <input type="text" class="form-control" name="surName"
                                       id="input-user-surName-create"
                                       placeholder="Обязательно">
                            </div>

                            <div class="form-group">
                                <label id="input-user-firstName-label">Имя:</label>
                                <input type="text" class="form-control" name="firstName"
                                       id="input-user-firstName-create"
                                       placeholder="Обязательно">
                            </div>

                            <div class="form-group">
                                <label id="input-user-paterName-label">Отчество:</label>
                                <input type="text" class="form-control" name="paterName"
                                       id="input-user-paterName-create"
                                       placeholder="Обязательно">
                            </div>

                            <div class="form-group">
                                <label id="input-user-mail-label">Электронная почта:</label>
                                <input type="email" class="form-control" name="usermail"
                                       id="input-user-mail-create"
                                       placeholder="Обязательно">
                            </div>

                            <div class="form-group">
                                <label id="input-user-phone-label">Телефон:</label>
                                <input type="text" class="form-control" name="phone"
                                       id="input-user-phone-create"
                                       placeholder="Обязательно">
                            </div>

                            <div class="form-group">
                                <label id="input-user-mobphone-label">Мобильный телефон:</label>
                                <input type="text" class="form-control" name="mobphone"
                                       id="input-user-mobphone-create"
                                       placeholder="Опционально">
                            </div>

                            <div class="form-group">
                                <label>Дата рождения:</label>
                                <input type="date" class="form-control" name="birthdate"
                                       id="input-user-birthdate-create"
                                       placeholder="Опционально">
                            </div>

                            <div class="form-group">
                                <label>Доступные Роли:</label>
                                <div class="dropdown" >
                                    <select  id="role_selected" style="width: 100px;height: 35px;border: 1px solid;border-radius: 15px; background-color: snow" >
                                        <option class="dropdown-item" id="dropdown-item">Выбрать</option>

                                    </select>

                                    <textarea class="form-control" style="float:right;width: 300px;
                                overflow: hidden;text-overflow: ellipsis;" rows="1" id="text-area-roles" disabled></textarea>
                                    <button style="float:right" onclick="eraseText()">X</button>
                                </div>
                            </div>


                            <div class="form-group">
                                <label>Подразделение:</label>
                                <input type="text" class="form-control" id="input-user-dept-create"
                                       placeholder="Опционально">
                            </div>

                            <div class="form-group">
                                <label>Должность:</label>
                                <input type="text" class="form-control" id="input-user-job-create"
                                       placeholder="Обязательно">
                            </div>

                            <div class="form-group">
                                <label>Кураторство:</label>
                                <input type="checkbox" name="isCurator" id="input-user-isCurator-create">
                            </div>

                            <div class="form-group">
                                <label>Блокировка:</label>
                                <input type="checkbox" name="isblocked" id="input-user-isBlock-create">
                            </div>

                            <button class="btn create-user-submit-button" onclick="send()">Создать</button>
                            <button type="button" class="btn create-user-submit-button" data-dismiss="modal" aria-label="Close" style="float: right">
                                <span class="create-user-modal-close-cross">Отмена</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<div class="modal fade ldap-users-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content ldap-users-modal-content">
            <div class="modal-header ldap-users-modal-header">
                <h5 class="modal-title">Выгрузить пользователей из LDAP</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="ldap-users-modal-close-cross">&times;</span>
                </button>
            </div>
            <div class="modal-body ldap-users-modal-body">
                <div class="row justify-content-center">
                    <div class="col-5 ldap-users-modal-left-panel">
                        <ul class="list-group ldap-users-modal-left-list">
                        </ul>
                    </div>
                    <div class="col-1">
                        <button type="button" class="btn ldap-users-modal-move-all-to-right-button">&gt;&gt;
                        </button>
                        <button type="button" class="btn ldap-users-modal-move-to-right-button">&gt;
                        </button>
                        <button type="button" class="btn ldap-users-modal-move-to-left-button">&lt;</button>
                        <button type="button" class="btn ldap-users-modal-move-all-to-left-button">
                            &lt;&lt;
                        </button>
                    </div>
                    <div class="col-5 ldap-users-modal-right-panel">
                        <ul class="list-group ldap-users-modal-right-list">
                        </ul>
                    </div>
                </div>
                <div class="row ldap-users-modal-bottom">
                    <div class="offset-4 col-4 ldap-users-load">
                        <button class="btn ldap-users-submit-button">
                            <span class="ldap-users-submit-button-text">Выгрузить</span>
                            <span class="ldap-users-spinner">
                                    <span class="spinner-border spinner-border-sm" role="status"></span>
                                    Выгрузка...
                                </span>
                        </button>
                    </div>
                    <div class="col-4">
                        <label>
                            <input type="checkbox" class="form-check-input" name="updateIfExist" value="">
                            <span>обновить</span>
                        </label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade load-ldap-user-modal" data-backdrop="static" data-keyboard="false" tabindex="-1"
     role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content load-ldap-user-content">
            <div class="modal-header load-ldap-user-header">
                <h5 class="modal-title load-ldap-user-title">Обновить данные</h5>
                <button type="button" class="close load-ldap-user-close-cross" aria-label="Close">
                    <span>&times;</span>
                </button>
            </div>
            <div class="modal-body load-ldap-user-body">
                Пользователь <span class="load-ldap-user-modal-username font-weight-bold"></span> уже
                существует.
                Обновить данные?
                <span class="load-ldap-user-modal-description" hidden></span>
            </div>
            <div class="modal-footer load-ldap-user-bottom">
                <button type="button" class="btn load-ldap-user-modal-yes-button">Да</button>
                <button type="button" class="btn load-ldap-user-modal-no-button">Нет</button>
                <button type="button" class="btn load-ldap-user-modal-cancel-button">Отмена</button>
            </div>
        </div>
    </div>
</div>

<%--//////////CREATING USERS////////////--%>

<div class="modal fade user-role-modal" tabindex="-1" role="dialog">
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

                        <ul class="list-group user-role-modal-left-list">
                        </ul>
                    </div>
                    <div class="col-1">
                        <button type="button" class="btn user-role-modal-move-all-to-right-button">
                            &gt;&gt;
                        </button>
                        <button type="button" class="btn user-role-modal-move-to-right-button">&gt;</button>
                        <button type="button" class="btn user-role-modal-move-to-left-button">&lt;</button>
                        <button type="button" class="btn user-role-modal-move-all-to-left-button">&lt;&lt;
                        </button>
                    </div>
                    <div class="col-5 user-role-modal-right-panel">
                        <ul class="list-group user-role-modal-right-list">
                        </ul>
                    </div>
                </div>
                <div class="row user-role-modal-bottom  justify-content-center">
                    <p class="roles-issue-left">Доступные роли</p>
                    <div class="user-role-submit">
                        <button class="btn user-role-submit-button">
                            Назначить
                            <input class="user-role-modal-username" type="hidden" value="">
                        </button>
                    </div>
                    <p class="roles-issue-right">Роли пользователя</p>
                </div>
            </div>
        </div>
    </div>
</div>

<%--SHOWUSERS--%>
<div class="modal fade user-info-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content create-user-modal-content">
            <div class="modal-header create-user-modal-header">
                <h5 class="modal-title">Информация о пользователе </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="create-user-modal-close-cross">&times;</span>
                </button>
            </div>
            <div class="modal-body justify-content-center">
                <div class="row">
                    <div class="col-12">
                        <div class="form-group">
                            <label>Логин : <label id="info-login-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Фамилия : <label id="info-surname-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label id=>Имя: <label id="info-name-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Отчество: <label id="info-patername-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Электронная почта: <label id="info-mail-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Телефон: <label id="info-phone-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Мобильный телефон: <label id="info-mobilephone-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Дата рождения: <label id="info-birthday-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Департамент: <label id="info-dept-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Должность: <label id="info-job-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Куратор: <label id="info-iscurator-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Заблокирован: <label id="info-isblocked-id"></label></label>
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
<script src="${pageContext.request.contextPath}/js/users.js"></script>
</body>
</html>
