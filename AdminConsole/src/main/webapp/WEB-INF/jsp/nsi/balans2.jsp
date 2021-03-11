<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>баланс</title>
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
        <p class="display-4">Баланс</p>
    </div>

    <div class="table-responsive">
        <table id="nsi-table" class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Наименование</th>
                <th scope="col">Идентификатор. PK</th>
                <th scope="col">Код 1</th>
                <th scope="col">Код 2</th>
                <th scope="col">Код 3</th>
                <th scope="col">Код 4</th>

            </tr>
            </thead>
            <tbody>
            <c:if test="${not empty balans2Directory.balanses}">
                <c:forEach items="${balans2Directory.balanses}" var="balans">
                    <tr>
                        <td class="info" hidden>
                            <span data-nsi class="id">${balans.id}</span>
                            <span data-nsi class="dimId">${balans.dimId}</span>
                            <span data-nsi class="scode1">${balans.scode1}</span>
                            <span data-nsi class="scode2">${balans.scode2}</span>
                            <span data-nsi class="scode3">${balans.scode3}</span>
                            <span data-nsi class="scode4">${balans.scode4}</span>
                            <span data-nsi class="name">${balans.name}</span>
                            <span data-nsi class="accAp">${balans.accAp}</span>
                            <span data-nsi class="accOc">${balans.accOc}</span>
                            <span data-nsi class="accPn">${balans.accPn}</span>
                            <span data-nsi class="auditCode">${balans.auditCode}</span>
                            <span data-nsi class="blClBank">${balans.blClBank}</span>
                            <span data-nsi class="blDefault">${balans.blDefault}</span>
                            <span data-nsi class="blFormName">${balans.blFormName}</span>
                            <span data-nsi class="blNo">${balans.blNo}</span>
                            <span data-nsi class="blRequ">${balans.blRequ}</span>
                            <span data-nsi class="caOc">${balans.caOc}</span>
                            <span data-nsi class="raOc">${balans.raOc}</span>
                            <span data-nsi class="close">${balans.close}</span>
                        </td>
                        <td class="name">${balans.name}</td>
                        <td class="dimId">${balans.dimId}</td>
                        <td class="scode1">${balans.scode1}</td>
                        <td class="scode2">${balans.scode2}</td>
                        <td class="scode3">${balans.scode3}</td>
                        <td class="scode4">${balans.scode4}</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
    <div class="nsi-directory-page-buttons float-right">
        <button type="button" class="btn create-nsi-modal-button" data-toggle="modal"
                data-target=".create-nsi-entry-modal">
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
                                <input data-nsi id="input-nsi-balans2-id-view" name="id" hidden disabled>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-name-view">Наименование:</label>
                                    <input data-nsi name="name" class="form-control" id="input-nsi-balans2-name-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-dim-id-view">Идентификатор. PK:</label>
                                    <input data-nsi name="dimId" class="form-control" id="input-nsi-balans2-dim-id-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-1-view">Код 1:</label>
                                    <input data-nsi name="scode1" class="form-control"
                                           id="input-nsi-balans2-scode-1-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-2-view">Код 2:</label>
                                    <input data-nsi name="scode2" class="form-control"
                                           id="input-nsi-balans2-scode-2-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-3-view">Код 3:</label>
                                    <input data-nsi name="scode3" class="form-control"
                                           id="input-nsi-balans2-scode-3-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-4-view">Код 4:</label>
                                    <input data-nsi name="scode4" class="form-control"
                                           id="input-nsi-balans2-scode-4-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-acc-ap-view">Характер счета
                                        (активный/пассивный):</label>
                                    <input data-nsi name="accAp" class="form-control" id="input-nsi-balans2-acc-ap-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-acc-oc-view">Признак закрытия:</label>
                                    <input data-nsi name="accOc" class="form-control" id="input-nsi-balans2-acc-oc-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-acc-pn-view">Признак переоценки валюты лицевого
                                        счета:</label>
                                    <input data-nsi name="accPn" class="form-control" id="input-nsi-balans2-acc-pn-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-audit-code-view">Код статьи для аудита:</label>
                                    <input data-nsi name="auditCode" class="form-control"
                                           id="input-nsi-balans2-audit-code-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-cl-bank-view">Клиентский-банковский:</label>
                                    <input data-nsi name="BlClBank" class="form-control"
                                           id="input-nsi-balans2-bl-cl-bank-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-default-view">Значение по умолчанию:</label>
                                    <input data-nsi name="blDefault" class="form-control"
                                           id="input-nsi-balans2-bl-default-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-form-name-view">Название элемента формы:</label>
                                    <input data-nsi name="blFormName" class="form-control"
                                           id="input-nsi-balans2-bl-form-name-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-no-view">Порядок ввода:</label>
                                    <input data-nsi name="blNo" class="form-control" id="input-nsi-balans2-bl-no-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-requ-view">Обязательность заполнения:</label>
                                    <input data-nsi name="blRequ" class="form-control"
                                           id="input-nsi-balans2-bl-requ-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-ca-oc-view">Допустимый контрагент:</label>
                                    <input data-nsi name="caOc" class="form-control" id="input-nsi-balans2-ca-oc-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-ra-oc-view">Допустимое резидентство:</label>
                                    <input data-nsi name="raOc" class="form-control" id="input-nsi-balans2-ra-oc-view"
                                           disabled>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-close-view">Признак закрытия:</label>
                                    <input data-nsi name="close" class="form-control" id="input-nsi-balans2-close-view"
                                           disabled>
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
                            <form action="<c:url value="/nsi/balans2/create"/>" method="post">
                                <div class="form-group">
                                    <label for="input-nsi-balans2-name-create">Наименование:</label>
                                    <input name="name" class="form-control" id="input-nsi-balans2-name-create"
                                           placeholder="Наименование">
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-dim-id-create">Идентификатор. PK (*):</label>
                                    <input name="dimId" class="form-control" id="input-nsi-balans2-dim-id-create"
                                           placeholder="Идентификатор. PK" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-1-create">Код 1 (*):</label>
                                    <input name="scode1" class="form-control" id="input-nsi-balans2-scode-1-create"
                                           placeholder="Код 1" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-2-create">Код 2 (*):</label>
                                    <input name="scode2" class="form-control" id="input-nsi-balans2-scode-2-create"
                                           placeholder="Код 2" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-3-create">Код 3 (*):</label>
                                    <input name="scode3" class="form-control" id="input-nsi-balans2-scode-3-create"
                                           placeholder="Код 3" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-scode-4-create">Код 4 (*):</label>
                                    <input name="scode4" class="form-control" id="input-nsi-balans2-scode-4-create"
                                           placeholder="Код 4" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-acc-ap-create">Характер счета (активный/пассивный)
                                        (*):</label>
                                    <input name="accAp" class="form-control" id="input-nsi-balans2-acc-ap-create"
                                           placeholder="Характер счета (активный/пассивный)" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-acc-oc-create">Признак закрытия (*):</label>
                                    <input name="accOc" class="form-control" id="input-nsi-balans2-acc-oc-create"
                                           placeholder="Признак закрытия" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-acc-pn-create">Признак переоценки валюты лицевого
                                        счета (*):</label>
                                    <input name="accPn" class="form-control" id="input-nsi-balans2-acc-pn-create"
                                           placeholder="Признак переоценки валюты лицевого счета" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-audit-code-create">Код статьи для аудита (*):</label>
                                    <input name="auditCode" class="form-control"
                                           id="input-nsi-balans2-audit-code-create"
                                           placeholder="Код статьи для аудита" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-cl-bank-create">Клиентский-банковский (*):</label>
                                    <input name="blClBank" class="form-control" id="input-nsi-balans2-bl-cl-bank-create"
                                           placeholder="Клиентский-банковский" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-default-create">Значение по умолчанию (*):</label>
                                    <input name="blDefault" class="form-control"
                                           id="input-nsi-balans2-bl-default-create"
                                           placeholder="Значение по умолчанию" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-form-name-create">Название элемента формы
                                        (*):</label>
                                    <input name="blFormName" class="form-control"
                                           id="input-nsi-balans2-bl-form-name-create"
                                           placeholder="Название элемента формы" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-no-create">Порядок ввода (*):</label>
                                    <input name="blNo" class="form-control" id="input-nsi-balans2-bl-no-create"
                                           placeholder="Порядок ввода" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-bl-requ-create">Обязательность заполнения (*):</label>
                                    <input name="blRequ" class="form-control" id="input-nsi-balans2-bl-requ-create"
                                           placeholder="Обязательность заполнения" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-ca-oc-create">Допустимый контрагент (*):</label>
                                    <input name="caOc" class="form-control" id="input-nsi-balans2-ca-oc-create"
                                           placeholder="Допустимый контрагент" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-ra-oc-create">Допустимое резидентство (*):</label>
                                    <input name="raOc" class="form-control" id="input-nsi-balans2-ra-oc-create"
                                           placeholder="Допустимое резидентство" required>
                                </div>
                                <div class="form-group">
                                    <label for="input-nsi-balans2-close-create">Признак закрытия (*):</label>
                                    <input name="close" class="form-control" id="input-nsi-balans2-close-create"
                                           placeholder="Признак закрытия" required>
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
