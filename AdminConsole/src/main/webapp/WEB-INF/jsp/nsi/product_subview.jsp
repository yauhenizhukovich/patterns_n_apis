<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Подвид продукта</title>
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
        <p id="subviewlabel" class="display-4">Подвид продукта</p>
    </div>

    <div id="product-group-list" hidden>
        <c:forEach items="${productGroups}" var="productGroup">
            <div class="productGroupData">
                <span class="id">${productGroup.id}</span>
                <span class="hiId">${productGroup.hiId}</span>
                <span class="name">${productGroup.name}</span>
                <span class="lev">${productGroup.lev}</span>
                <span class="tableName">${productGroup.tableName}</span>
            </div>
        </c:forEach>
    </div>


    <table id="vid-table" class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Бизнес-направление</th>
            <th scope="col">Класс продукта</th>
            <th scope="col">Группа продукта</th>
            <th scope="col">Вид продукта</th>
            <th scope="col">Подвид продукта</th>
        </tr>
        </thead>
        <tbody id="vid">

        </tbody>
    </table>
    <div class="vid-page-buttons float-right">
        <button type="button" class="btn xxx" id="vid-edit-button"  onclick="editProductView()" disabled>Редактировать</button>
        <button type="button" class="btn xxx" onclick="showProductView()" disabled>
            Просмотреть
        </button>
        <button type="button" class="btn create-user-submit-button" data-toggle="modal" data-target=".create-vid-modal">Добавить</button>
        <button type="button" class="btn xxx" id="vid-delete-button" disabled onclick="viewDelete()">Удалить</button>
    </div>


    <div class="modal fade create-vid-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-user-modal-content">
                <div class="modal-header create-user-modal-header">
                    <h5 class="modal-title">Добавить запись</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-user-modal-close-cross">&times;</span>
                    </button>
                </div>

                <div class="modal-body justify-content-center">
                    <div class="row">

                        <div class="col-12">
                            <div class="form-group">
                                <select name="firstLevelProductGroup" class="group-hierarchy-list"
                                        id="firstLevelProductGroup"
                                        required>
                                    <option value="0" selected disabled>Бизнес-направление</option>
                                    <c:forEach items="${productGroups}" var="productGroup">
                                        <c:if test="${productGroup.lev eq 1}">
                                            <option value="${productGroup.id}">${productGroup.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">

                                <br>
                                <select hidden="true" name="secondLevelProductGroup" class="group-hierarchy-list"
                                        id="secondLevelProductGroup" required>
                                    <option value="0" selected disabled>Класс продукта</option>
                                </select>

                            </div>

                            <div class="form-group">

                                <br>
                                <select hidden="true" name="thirdLevelProductGroup" class="group-hierarchy-list"
                                        id="thirdLevelProductGroup" required>
                                    <option value="0" selected disabled>Группа продукта</option>
                                </select>
                            </div>

                            <div class="form-group">

                                <br>
                                <select hidden="true" name="fourthLevelProductGroup" class="group-hierarchy-list"
                                        id="fourthLevelProductGroup" required>
                                    <option value="0" selected disabled>Вид продукта</option>
                                </select>
                            </div>

                            <div class="form-group">

                                <div class="buttons-for-product-manipulation"  >
                                    <input type="text" class="form-control" id="add_product_view_input"
                                           style="width: 300px; height: 45px" disabled>

                                    <button type="button" id="add_product_view_button" class="btn create-user-submit-button" disabled
                                            onclick="sendd()" >Добавить
                                    </button>
                                    <button type="button" data-dismiss="modal" class="btn nsi-edit-cancel-button">Отмена</button>


                                </div>
                            </div>
                        </div>


                        <%-- <div class="col12">
                             <div class="form-group">
                             <select name="firstLevelProductGroup" class="group-hierarchy-list"
                                     id="firstLevelProductGroup"
                                     required>
                                 <option value="0" selected disabled>Бизнес-направление</option>
                                 <c:forEach items="${productGroups}" var="productGroup">
                                     <c:if test="${productGroup.lev eq 1}">
                                         <option value="${productGroup.id}">${productGroup.name}</option>
                                     </c:if>
                                 </c:forEach>
                             </select>
                         </div>
                             <div>
                                 <br>
                                 <select hidden="true" name="secondLevelProductGroup" class="group-hierarchy-list"
                                         id="secondLevelProductGroup" required>
                                     <option value="0" selected disabled>Класс продукта</option>
                                 </select>
                             </div>
                             <div>
                                 <br>
                                 <select hidden="true" name="thirdLevelProductGroup" class="group-hierarchy-list"
                                         id="thirdLevelProductGroup" required>
                                     <option value="0" selected disabled>Группа продукта</option>
                                 </select>
                             </div>

                             <div>
                                 <br>
                                 <select hidden="true" name="fourthLevelProductGroup" class="group-hierarchy-list"
                                         id="fourthLevelProductGroup"
                                         required>
                                     <option value="0" selected disabled>Вид продукта</option>
                                 </select>
                             </div>

                             <div class="form-group" style="float: right">
                             <div class="buttons-for-product-manipulation"  >
                                 <input type="text" class="form-control" id="add_product_view_input"
                                        style="width: 150px; height: 45px">
                                 <div class="find-button">
                                     <button type="submit" id="add_product_view_button" class="btn check-product-button" disabled
                                             onclick="sendd()" >Добавить
                                     </button>
                                 </div>
                             </div>
                         </div>
                         </div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <div class="modal fade edit-vid-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-user-modal-content">
                <div class="modal-header create-user-modal-header">
                    <h5 class="modal-title">Редактировать запись</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-user-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="modal-body justify-content-center">
                    <div class="row">
                        <div class="col-12">

                    <div class="form-group">
                        <select name="firstLevelProductGroup" class="group-hierarchy-list"
                                id="firstLevelProductGroupEdit"
                                required>
                            <option value="0" selected disabled>Бизнес-направление</option>
                            <c:forEach items="${productGroups}" var="productGroup">
                                <c:if test="${productGroup.lev eq 1}">
                                    <option value="${productGroup.id}">${productGroup.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">

                        <br>
                        <select  name="secondLevelProductGroup" class="group-hierarchy-list"
                                id="secondLevelProductGroupEdit" required>
                        </select>

                    </div>

                    <div class="form-group">

                        <br>
                        <select  name="thirdLevelProductGroup" class="group-hierarchy-list"
                                id="thirdLevelProductGroupEdit" required>
                        </select>
                    </div>

                    <div class="form-group">

                        <br>
                        <select name="fourthLevelProductGroup" class="group-hierarchy-list"
                                id="fourthLevelProductGroupEdit" required>
                        </select>
                    </div>

                    <br>
                    <input name="userName" required="required" class="form-control"
                           id="view"
                           placeholder="Обязательно">
                    <br>
                    <button class="btn create-user-submit-button"onclick="viewEdit()" style="float: right">Сохранить</button>
<%--
                    <button class="btn create-user-submit-button"type="button" onclick="viewDelete()" >Удалить</button>
--%>
                    <button class="btn create-user-submit-button"type="button" onclick="closee()" >Отмена</button>
                </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade show-vid-modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content create-user-modal-content">
                <div class="modal-header create-user-modal-header">
                    <h5 class="modal-title">Просмотр записи</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="create-user-modal-close-cross">&times;</span>
                    </button>
                </div>
                <div class="form-group">
                    <br>
                    <input name="userName" required="required" class="form-control" disabled="disabled"
                           id="showbusDr"
                           placeholder="Обязательно">
                    <br>
                    <input name="userName" required="required" class="form-control" disabled="disabled"
                           id="showclassProd"
                           placeholder="Обязательно">
                    <br>
                    <input name="userName" required="required" class="form-control" disabled="disabled"
                           id="showgroupProd"
                           placeholder="Обязательно">
                    <br>
                    <input name="userName" required="required" class="form-control" disabled="disabled"
                           id="showgroupvid"
                           placeholder="Обязательно">
                    <br>
                    <input name="userName" required="required" class="form-control" disabled="disabled"
                           id="showgroupsubvid"
                           placeholder="Обязательно" style="background-color: #2aa198 ">
                    <br>
                    <button  class="btn create-user-submit-button" onclick="editProductView()" style="float: right">Редактировать</button>
                    <button class="btn create-user-submit-button"type="button" onclick="viewDelete()" >Удалить</button>
                    <button class="btn create-user-submit-button"type="button" onclick="closee()">Отмена</button>
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

