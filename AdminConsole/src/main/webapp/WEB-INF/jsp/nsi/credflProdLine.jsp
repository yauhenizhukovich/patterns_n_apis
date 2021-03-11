<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Справочник линеек кредитных продуктов (для бизнес-направления = Розничный)</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tree.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<jsp:include page="../component/main-navbar.jsp"/>
<jsp:include page="../component/side-navbar.jsp"/>

<div id="page-content">
    <div class="row justify-content-center page-title">
        <p class="display-4">Справочник линеек кредитных продуктов (для бизнес-направления = Розничный)</p>
    </div>

    <table id="nsi-table" class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Код</th>
            <th scope="col">Наименование</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty directoryDTO.directory}">
            <c:forEach items="${directoryDTO.directory}" var="user">
                <tr>
                    <td class="info" hidden="">
                        <span data-nsi="" class="id">${user.code}</span>
                        <span data-nsi="" class="NAME">${user.name}</span>
                    </td>
                    <td class="CODE">${user.code}</td>
                    <td class="NAME">${user.name}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>

    <div class="vid-page-buttons float-right">
        <button type="button" class="btn nsi-edit-entry-modal-button"
                disabled>Редактировать
        </button>
        <button type="button" class="btn view-nsi-modal-button"  disabled>
            Просмотреть
        </button>
        <button type="button" class="btn create-user-submit-button" data-toggle="modal"
                data-target=".create-modal">Добавить
        </button>
        <button type="button" class="btn nsi-remove-entry-button"  disabled >
            Удалить
        </button>
    </div>


    <div class="modal fade create-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-nsi-entry-modal-content">
                <div class="modal-header create-nsi-entry-modal-header">
                    <h5 class="modal-title">Создать запись в справочнике</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-nsi-entry-modal-close-cross">×</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">
                                <div class="form-group">
                                    <label for="input-nsi-NAME-create">Наименование:</label>
                                    <input name="NAME" class="form-control" min="1" id="input-nsi-NAME-create"
                                           placeholder="Наименование" required="" max="100">
                                    <input hidden="true" name="TEXTAREANSI" id="text-area-bpcard">
                                    <br>
                                    <div>
                                        <label>Карточка банковского продукта</label>
                                        <div class="dropdown">
                                            <select class="dropdown-nsi" id="dropdown-nsi">
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row float-right">
                                    <button class="btn create-nsi-entry-submit-button-e" disabled>Создать</button>
                                    <button type="button" class="btn create-cancel-nsi-entry-button">Отмена</button>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
                            <div class="col-12">
                                <form>
                                    <input data-nsi="" id="input-nsi-directory-view" name="id" hidden="" disabled="">
                                    <div class="form-group">
                                        <label for="input-nsi-acc_status-NAME-view">Наименование:</label>
                                        <input data-nsi="" name="NAME" class="form-control" id="input-nsi-acc_status-NAME-view" placeholder="Наименование" required="" disabled="disabled">
                                    </div>
                                    <div class="form-group">
                                        <label for="input-nsi-acc_status-NAME-view">КБП:</label>
                                        <input data-nsi=""  class="form-control" id="input-nsi-acc_status-NAME-view-kbp"  required="" disabled="disabled">
                                    </div>
                                    <div class="row nsi-entry-buttons justify-content-center">
                                        <button type="button" class="btn nsi-edit-entry-button">Редактировать</button>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade edit-nsi-entry-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content view-nsi-entry-modal-content">
        <div class="modal-header view-nsi-entry-modal-header">
            <h5 class="modal-title">Редактировать</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span class="view-nsi-entry-modal-close-cross">×</span>
            </button>
        </div>
        <div class="modal-body justify-content-center">
            <div class="row">
                <div class="col-12">
                    <form>
                        <input data-nsi="" id="input-nsi-directory-edit" name="id" hidden="" disabled="">
                        <div class="form-group">
                            <label for="input-nsi-acc_status-NAME-view">Наименование:</label>
                            <input data-nsi="" name="NAME" class="form-control" min="1" max="30" id="input-nsi-acc_status-NAME-edit" placeholder="Наименование" required="">
                        </div>
                        <input hidden="true" name="TEXTAREANSI" id="text-area-bpcardd">
                        <label>Карточка банковского продукта</label>
                        <div class="dropdown">
                            <select class="dropdown-nsi" id="dropdown-nsii">
                            </select>
                        </div>
                        <div class="row nsi-entry-edit-buttons float-right">
                            <button type="button" class="btn nsi-edit-save-button">Сохранить</button>
<%--
                            <button type="button" class="btn nsi-delete-entry-button">Удалить</button>
--%>
                            <button type="button" data-dismiss="modal" class="btn nsi-edit-cancel-button">Отмена</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
        </div>
    </div>




</div>
<script src="${pageContext.request.contextPath}/js/product/tree.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/side-navbar.js"></script>
<script src="${pageContext.request.contextPath}/js/content-inject.js"></script>
<script src="${pageContext.request.contextPath}/js/product/product_placing.js"></script>

</body>
</html>

