<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Подразделения</title>
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
        <p class="display-4">Подразделения</p>
    </div>

    <div class="table-responsive">
        <table id="dept-table"  class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Полное название подразделение</th>
                <th scope="col">Краткое название подразделение</th>
                <th scope="col">Признак разработчика</th>
                <th scope="col">ФИО Руководителя</th>
                <th scope="col">Название вышестоящего подразделения</th>
                <th scope="col">Должность руководителя</th>
            </tr>
            </thead>
            <tbody id="dept">

            </tbody>
        </table>
    </div>
    <div class="vid-page-buttons float-right">
        <button type="button" class="btn xxx" id="vid-edit-button"  onclick="editDept()" disabled>Редактировать</button>
        <button type="button" class="btn xxx" onclick="showDept()" disabled>
            Просмотреть
        </button>
        <button type="button" class="btn xxx" data-toggle="modal" data-target=".create-dept-modal">Добавить</button>
        <button type="button" class="btn xxx" id="vid-delete-button" disabled onclick="deptDeleteModal()">Удалить</button>
    </div>

</div>

<div class="modal fade show-dept-modal" tabindex="-1" role="dialog">
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
                    <div class="col-12">

                        <div class="form-group">
                            <label>Наименование подразделения : <label id="info-dept-name-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label>Краткое наименование : <label id="info-dept-short-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label id=>Признак разработчика: <label id="info-fDevelop-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label id=>ФИО руководителя: <label id="info-head-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label id=>Название вышестоящего подразделения: <label id="info-parent-id"></label></label>
                        </div>
                        <div class="form-group">
                            <label id=>Должность руководителя: <label id="info-post"></label></label>
                        </div>
                    </div>
                    <div>


                    <button class="btn xxx" onclick="deptDeleteModal()">Удалить</button>

                    <button type="button" class="btn xxx"  onclick="editDept()">Редактировать</button>

                    <button type="button"  class="btn xxx" data-dismiss="modal" aria-label="Close">
                        Отмена
                    </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade update-dept-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content create-role-modal-content">
            <div class="modal-header create-role-modal-header">
                <h5 class="modal-title">Изменить подразделение</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="create-role-modal-close-cross">&times;</span>
                </button>
            </div>
            <div class="modal-body justify-content-center">
                <div class="row">
                    <div class="col-12">

                        <div class="form-group">
                            <label >Полное название подразделения:</label>
                            <input name="roleName" class="form-control" id="input-dept-edit"
                                   placeholder="обязательно">
                        </div>
                        <div class="form-group">
                            <label >Краткое название подразделения:</label>
                            <input name="roleName" class="form-control" id="input-short-dept-edit"
                                   placeholder="обязательно">
                        </div>

                        <div class="form-group">
                            <label>Признак разработчика:</label>
                            <input type="checkbox" name="isCurator" id="input-checkbox-dept-edit">
                        </div>


                        <div class="form-group">
                            <label>ФИО руководителя:</label>
                            <div class="dropdown">
                                <select id="departmentuser" style="width: 100px;height: 35px;border: 1px solid;border-radius: 15px; background-color: snow">
                                    <option></option>

                                </select>
                                <textarea class="form-control" style="float:right;width: 300px;
                                overflow: hidden;text-overflow: ellipsis;" rows="1" id="text-area-departmentuser-edit"
                                          disabled></textarea>
                                <button style="float:right" onclick="eraseText()">X</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label >Должность Руководителя:</label>
                            <input name="roleName" class="form-control"
                                   placeholder="" id="inputt-dept-edit" disabled>
                        </div>
                        <div class="form-group">
                            <label>Признак Кураторства:</label>
                            <input type="checkbox" name="isCurator" id="input-checkbox-dept-kurator-edit" class="input-checkbox-dept-create">
                        </div>
                        <div class="form-group">
                            <label>Подразделения:</label>
                            <div class="dropdown">
                                <select id="departmentsdropdown" style="width: 100px;height: 35px;border: 1px solid;border-radius: 15px; background-color: snow">
                                    <option ></option>
                                </select>
                                <textarea class="form-control" style="float:right;width: 300px;
                                overflow: hidden;text-overflow: ellipsis;"  rows="1" id="text-area-department-edit"
                                          disabled></textarea>
                                <button style="float:right" onclick="eraseTextt()">X</button>
                            </div>
                        </div>
                        <button class="btn xxx" onclick="updateDept()">Сохранить</button>
                        <button type="button" class=" btn xxx" data-dismiss="modal" aria-label="Close">
                            Отмена
                        </button>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade create-dept-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content create-role-modal-content">
            <div class="modal-header create-role-modal-header">
                <h5 class="modal-title">Добавить подразделение</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="create-role-modal-close-cross">&times;</span>
                </button>
            </div>
            <div class="modal-body justify-content-center">
                <div class="row">
                    <div class="col-12">

                        <div class="form-group">
                            <label >Полное название подразделения:</label>
                            <input name="roleName" class="form-control" id="input-dept-create"
                                   placeholder="обязательно">
                        </div>
                        <div class="form-group">
                            <label >Краткое название подразделения:</label>
                            <input name="roleName" class="form-control" id="input-short-dept-create"
                                   placeholder="обязательно">
                        </div>

                        <div class="form-group">
                            <label>Признак разработчика:</label>
                            <input type="checkbox" name="isCurator" id="input-checkbox-dept-create" class="input-checkbox-dept-create">
                        </div>


                        <div class="form-group">
                            <label>ФИО руководителя:</label>
                            <div class="dropdown">
                                <select id="departmentuser-create" style="width: 100px;height: 35px;border: 1px solid;border-radius: 15px; background-color: snow">
                                    <option></option>

                                </select>
                                <textarea class="form-control" style="float:right;width: 300px;
                                overflow: hidden;text-overflow: ellipsis;" rows="1" id="text-area-departmentuser-create"
                                          disabled></textarea>
                                <button style="float:right" onclick="eraseText()">X</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label >Должность Руководителя:</label>
                            <input name="roleName" class="form-control"
                                   placeholder="" id="inputt-dept-create" >
                        </div>

                        <div class="form-group">
                            <label>Признак Кураторства:</label>
                            <input type="checkbox" name="isCurator" id="input-checkbox-dept-kurator" class="input-checkbox-dept-create">
                        </div>


                        <div class="form-group">
                            <label>Подразделения:</label>
                            <div class="dropdown">
                                <select id="departmentsdropdown-create" style="width: 100px;height: 35px;border: 1px solid;border-radius: 15px; background-color: snow">
                                    <option ></option>
                                </select>
                                <textarea class="form-control" style="float:right;width: 300px;
                                overflow: hidden;text-overflow: ellipsis;"  rows="1" id="text-area-department-create"
                                          disabled></textarea>
                                <button style="float:right" onclick="eraseTextt()">X</button>
                            </div>
                        </div>
                        <button class="btn xxx" onclick="createDept()">Сохранить</button>
                        <button type="button" class="btn xxx" data-dismiss="modal" aria-label="Close">
                           Отмена
                        </button>


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
<script src="${pageContext.request.contextPath}/js/nsi.js"></script>
</body>
</html>
