<%--
  Created by IntelliJ IDEA.
  User: anatoli.aniskevich
  Date: 03.11.2020
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>системные настройки</title>
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
        <p class="display-4">настройки</p>
    </div>



    <table id="settings-table" class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Владелец системы</th>
            <%--<th scope="col">Адрес почтового сервера</th>
            <th scope="col">Шаблон уведомлений</th>--%>
            <%--<th scope="col">Адрес API BARS НСИ</th>
            <th scope="col">Пользователь API BARS НСИ.</th>
            <th scope="col">Пароль API BARS НСИ.</th>--%>
            <th scope="col">Адрес API BRIS НСИ</th>
            <th scope="col">Пользователь API BRIS НСИ</th>
            <th scope="col">Пароль API BRIS НСИ.</th>
          <%--  <th scope="col">Адрес API BARS счет</th>
            <th scope="col">Пользователь API BARS счет</th>
            <th scope="col">Пароль API BARS счет.</th>--%>
            <%--<th scope="col">Путь к папке выгрузки для СЭД.</th>
            <th scope="col">Таймаут синхронизации НСИ, мин</th>
            <th scope="col">Таймаут синхронизации данных счета/договора/клиента, мин	Целое, 2</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty settingList}">
            <c:forEach items="${settingList}" var="list">
                <tr>
                    <td class="table-settings-owner">${list.sysOwner}</td>
                    <%--<td class="table-settings-emailserver">${list.emailServer}</td>
                    <td class="table-settings-notificationtemplate">${list.notificationTemplate}</td>--%>

                    <%--<td class="table-settings-apibarsnsiaddress">${list.apiBarsNsiAddress}</td>
                    <td class="table-settings-apibarsinsiuser">${list.apiBarsNsiUser}</td>
                    <td class="table-settings-apibarsnsipwd">${list.apiBarsNsiPwd}</td>--%>

                    <td class="table-settings-apibrisnsiadress">${list.apiBrisNsiAdress}</td>
                    <td class="table-settings-apibrisnsiuser">${list.apiBrisNsiUser}</td>
                    <td class="table-settings-apibrisnsipwd">${list.apiBrisNsiPwd}</td>

                  <%--  <td class="table-settings-apibarsaccadress">${list.apiBarsAccAdress}</td>
                    <td class="table-settings-apibarsaccadress">${list.apiBarsAccUser}</td>
                    <td class="table-settings-apibarsaccadress">${list.apiBarsAccPwd}</td>
--%>
                    <%--<td class="table-settings-sedfolderpath">${list.sedFolderPath}</td>
                    <td class="table-settings-timeoutsyncnsi">${list.timeoutSyncNsi}</td>
                    <td class="table-settings-timeoutsyncacc">${list.timeoutSyncAcc}</td>--%>
                </tr>
            </c:forEach>
        </c:if>

      <%-- <tr> <td>class="table-settings-owner">3</td></tr>
       <tr> <td>class="table-settings-emailserver">$</td></tr>
       <tr class="table-settings-notificationtemplate">3}</tr>

       <tr class="table-settings-apibarsnsiaddress">3</tr>
       <tr class="table-settings-apibarsinsiuser">3</tr>
       <tr class="table-settings-apibarsnsipwd">3</tr>

       <tr class="table-settings-apibrisnsiadress">3</tr>
       <tr class="table-settings-apibrisnsiuser">3</tr>
       <tr class="table-settings-apibrisnsipwd">2</tr>

       <tr class="table-settings-apibarsaccadress">3</tr>
       <tr class="table-settings-apibarsaccadress"></tr>
       <tr class="table-settings-apibarsaccadress">3</tr>

       <tr class="table-settings-sedfolderpath">3</tr>
       <tr class="table-settings-timeoutsyncnsi">3}</tr>
       <tr class="table-settings-timeoutsyncacc">3</tr>
--%>
        </tbody>
    </table>
    <div class="users-page-buttons float-right">
        <button type="button" class="btn settings-edit-modal-button" disabled >Редактировать</button>
    </div>



    <div class="modal fade settings-edit-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-user-modal-content">
                <div class="modal-header create-user-modal-header">
                    <h5 class="modal-title">Изменить параметр</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-user-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="owner-input" id="owner-label">Владелец системы</label>
                                <input  maxlength="200"
                                        class="form-control"   id="owner-input">
                            </div>

                          <%--  <div class="form-group">
                                <label for="owner-input" id="emailserver-label">Адрес почтового сервера.</label>
                                <input maxlength="200"
                                       class="form-control"   id="emailserver-input">
                            </div>

                            <div class="form-group">
                                <label for="owner-input">Шаблон уведомлений *.docx.</label>
                                <input type="file" maxlength="200"
                                       id="notification-input" >
                            </div>--%>

                           <%-- <div class="form-group">
                                <label for="owner-input" id="apiBarsNsiAddress-label">Адрес API BARS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsNsiAddress-input">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBarsNsiPwd-label">Пользователь API BARS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsNsiPwd-input">
                            </div>--%>

                            <div class="form-group">
                                <label for="owner-input" id="apiBrisNsiAdress-label">Пользователь API BARS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBrisNsiAdress-input">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBrisNsiUser-label">Пользователь API BRIS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBrisNsiUser-input">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBrisNsiPwd-label">Пароль API BRIS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBrisNsiPwd-input">
                            </div>

                           <%-- <div class="form-group">
                                <label for="owner-input" id="apiBarsAccAdress-label" >Пользователь API BARS счет</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsAccAdress-input">
                            </div>--%>

                           <%-- <div class="form-group">
                                <label for="owner-input" id="apiBarsAccUser-label">Пользователь API BARS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsAccUser-input">
                            </div>--%>

                           <%-- <div class="form-group">
                                <label for="owner-input" id="apiBarsAccPwd-input-labell">Пароль API BARS счет</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsAccPwd-input">
                            </div>--%>

                           <%-- <div class="form-group">
                                <label for="owner-input" id="sedFolderPath-label">Путь к папке выгрузки для СЭД</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="sedFolderPath-input">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="timeoutSyncNsi-label">Таймаут синхронизации НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="timeoutSyncNsi-input">
                            </div>

                            <div class="form-group">
                                <label for="owner-input"  id="timeoutSyncAcc-input-labell">Таймаут синхронизации данных счета/договора/клиента</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="timeoutSyncAcc-input">
                            </div>--%>

                            <button class="btn create-user-submit-button"onclick="sendSettingsEdit()">Сохранить</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade settings-add-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-user-modal-content">
                <div class="modal-header create-user-modal-header">
                    <h5 class="modal-title">Добавить параметр</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-user-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label for="owner-input" id="owner-input-input">Владелец системы</label>
                                <input  maxlength="200"
                                        class="form-control"   id="owner-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="emailserver-input-label">Адрес почтового сервера.</label>
                                <input maxlength="200"
                                       class="form-control"   id="emailserver-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="notification-input-label">«Шаблон уведомлений». *docx </label>
                                <input type="file" maxlength="200"
                                       class="form-control"  id="notification-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBarsNsiAddress-input-label">Адрес API BARS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsNsiAddress-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBarsNsiUser-input-label" >Пользователь API BARS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsNsiUser-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBarsNsiPwd-input-label">Пароль API BARS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsNsiPwd-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBrisNsiAdress-input-label" >Адрес API BRIS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBrisNsiAdress-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBrisNsiUser-input-label">Пользователь API BRIS НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBrisNsiUser-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBrisNsiPwd-input-label">Пароль API BARS счет</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBrisNsiPwd-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBarsAccAdress-input-label">Адресс API BARS счет</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsAccAdress-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBarsAccUser-input-label">Пользователь API BARS </label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsAccUser-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="apiBarsAccPwd-input-label">Пароль API BARS счет</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="apiBarsAccPwd-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input" id="sedFolderPath-input-label">Путь к папке выгрузки для СЭД</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="sedFolderPath-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input"  id="timeoutSyncNsi-input-label">Таймаут синхронизации НСИ</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="timeoutSyncNsi-input-create">
                            </div>

                            <div class="form-group">
                                <label for="owner-input"  id="timeoutSyncAcc-input-label">Таймаут синхронизации данных счета/договора/клиента</label>
                                <input name="system_owner" maxlength="200"
                                       class="form-control"   id="timeoutSyncAcc-input-create">
                            </div>

                            <button class="btn create-user-submit-button"onclick="sendSettingsAdd()">Сохранить</button>
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
    <script src="${pageContext.request.contextPath}/js/settings.js"></script>



</body>
</html>
