<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form>
    <input data-nsi id="input-nsi-directory-view" name="id" hidden disabled/>
    <c:if test="${not empty directoryDTO.tableData.nameOfColumns}">
        <c:forEach items="${directoryDTO.tableData.nameOfColumns}" var="column">
            <c:if test="${column.key ne primaryKey}">
                <div class="form-group">
                        <%--                    <label for="input-nsi-acc_status-${column.key}-view">${column.value}</label>--%>
                        <%--                    <input data-nsi name="${column.key}" class="form-control" id="input-nsi-acc_status-${column.key}-view" disabled>--%>
                    <c:choose>
                        <c:when test="${fields.get(column.key) eq 'NUMBER'}">
                            <label for="input-nsi-acc_status-${column.key}-view">${column.value}:</label>
                            <input data-nsi type="number" name="${column.key}" class="form-control"
                                   id="input-nsi-acc_status-${column.key}-view"
                                   placeholder="${column.value}" required>
                        </c:when>
                        <c:when test="${fields.get(column.key) eq 'DATE'}">
                            <label for="input-nsi-acc_status-${column.key}-view">${column.value}:</label>
                            <input data-nsi type="date" name="${column.key}" class="form-control"
                                   id="input-nsi-acc_status-${column.key}-view"
                                   placeholder="${column.value}" required>
                        </c:when>
                        <c:when test="${fields.get(column.key) eq 'SELECT'}">
                            <label for="input-nsi-acc_status-${column.key}-view">${column.value}:</label>
<%--                            <br>--%>
<%--                            <output id="errorSelect" style="color: rgba(255,54,0,0.92)"hidden>Параметры поля могут быть "0" или "1"</output>--%>
<%--                            <input data-nsi type="number" min="0" max="1" name="${column.key}" class="form-control"--%>
<%--                                   id="input-nsi-acc_status-${column.key}-view"--%>
<%--                                   placeholder="${column.value}" required>--%>
                            <select data-nsi name="${column.key}" class="form-control" id="input-nsi-acc_status-${column.key}-view">
                                <option value="1">Да</option>
                                <option value="0">Нет</option>
                            </select>
                        </c:when>
                        <c:when test="${fields.get(column.key) eq 'SELECT_3_PARAMS'}">
                            <label for="input-nsi-acc_status-${column.key}-view">${column.value}:</label>
                            <br>
                            <output id="errorSelect3Params" style="color: rgba(255,54,0,0.92)"hidden>Параметры поля могут быть "0", "1", "2"</output>
                            <input data-nsi type="number" min="0" max="2" name="${column.key}" class="form-control"
                                   id="input-nsi-acc_status-${column.key}-view"
                                   placeholder="${column.value}" required>
<%--                            <select data-nsi name="${column.key}" class="form-control" id="input-nsi-acc_status-${column.key}-view">--%>
<%--                                <option value="2">Да</option>--%>
<%--                                <option value="1">Нет</option>--%>
<%--                            </select>--%>
                        </c:when>
                        <c:when test="${fields.get(column.key) eq 'SELECT_1_2'}">
                            <label for="input-nsi-acc_status-${column.key}-view">${column.value}:</label>
                            <br>
                            <output id="errorSelect12" style="color: rgba(255,54,0,0.92)" hidden>Параметры поля могут быть "1" или "2"</output>
                            <input data-nsi type="number" min="1" max="2" name="${column.key}" class="form-control"
                                   id="input-nsi-acc_status-${column.key}-view"
                                   placeholder="${column.value}" required>
<%--                            <select data-nsi name="${column.key}" class="form-control" id="input-nsi-acc_status-${column.key}-view">--%>
<%--                                <option value="0">Да</option>--%>
<%--                                <option value="1">Нет</option>--%>
<%--                                <option value="2">Три</option>--%>
<%--                            </select>--%>
                        </c:when>
                        <c:otherwise>
                            <label for="input-nsi-acc_status-${column.key}-view">${column.value}:</label>
                            <input data-nsi name="${column.key}" class="form-control"
                                   id="input-nsi-acc_status-${column.key}-view"
                                   placeholder="${column.value}" required>
                            <c:choose>
                            <c:when test="${domain eq 'depfl_product_line' || domain eq 'dep_product_line'}">
                            <div class="form-group" id="input-nsi-acc_status-NAME-view-div" hidden>
                                <label for="input-nsi-acc_status-NAME-view-kbp">КБП:</label>
                                <input data-nsi=""  class="form-control" id="input-nsi-acc_status-NAME-view-kbp"  required="" disabled="disabled">
                            </div>

                                <div id="input-nsi-acc_status-NAME-view-div-edit" hidden>
                                    <br/>
                                    <label>Карточка банковского продукта</label>
                                    <div class="dropdown" >
                                        <select class="dropdown-nsi" id="dropdown-nsii">
                                        </select>
                                    </div>
                                </div>

                            </c:when>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>

                </div>
            </c:if>
        </c:forEach>
    </c:if>
    <div class="row nsi-entry-buttons justify-content-center">
        <button type="button" class="btn nsi-edit-entry-button">Редактировать</button>
    </div>
    <div class="row nsi-entry-edit-buttons float-right" hidden="">
        <button type="button" class="btn nsi-edit-save-button">Сохранить</button>
       <%-- <button type="button" class="btn nsi-delete-entry-button">Удалить</button>--%>
        <button type="button" data-dismiss="modal" class="btn nsi-edit-cancel-button">Отмена</button>
    </div>
</form>
