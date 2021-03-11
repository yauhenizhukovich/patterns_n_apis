<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:if test="${not empty directoryDTO.tableData.nameOfColumns}">
        <c:forEach items="${directoryDTO.tableData.nameOfColumns}" var="column">
            <c:if test="${column.key ne primaryKey}">
                <div class="form-group">
                        <c:choose>
                            <c:when test="${fields.get(column.key) eq 'NUMBER'}">
                                <label for="input-nsi-${column.key}-create">${column.value}:</label>
                                <input type="number" name="${column.key}" class="form-control"
                                       id="input-nsi-${column.key}-create"
                                       placeholder="${column.value}" required>
                            </c:when>
                            <c:when test="${fields.get(column.key) eq 'DATE'}">
                                <label for="input-nsi-${column.key}-create">${column.value}:</label>
                                <input type="date" name="${column.key}" class="form-control"
                                       id="input-nsi-${column.key}-create"
                                       placeholder="${column.value}" required>
                            </c:when>
                            <c:when test="${fields.get(column.key) eq 'SELECT'}">
                                <label for="input-nsi-${column.key}-create">${column.value}:</label>
<%--                                <input type="number" min="0" max="1" name="${column.key}" class="form-control"--%>
<%--                                       id="input-nsi-${column.key}-create"--%>
<%--                                       placeholder="${column.value}" required>--%>
                                <select data-nsi name="${column.key}" class="form-control" id="input-nsi-${column.key}-create">
                                    <option value="1">Да</option>
                                    <option value="0">Нет</option>
                                </select>
                            </c:when>
                            <c:when test="${fields.get(column.key) eq 'SELECT_1_2'}">
                                <label for="input-nsi-${column.key}-create">${column.value}:</label>
                                <input type="number" min="1" max="2" name="${column.key}" class="form-control"
                                       id="input-nsi-${column.key}-create"
                                       placeholder="${column.value}" required>
<%--                                <select data-nsi name="${column.key}" class="form-control" id="input-nsi-${column.key}-create">--%>
<%--                                    <option value="2">Да</option>--%>
<%--                                    <option value="1">Нет</option>--%>
<%--                                </select>--%>
                            </c:when>
                            <c:when test="${fields.get(column.key) eq 'SELECT_3_PARAMS'}">
                                <label for="input-nsi-${column.key}-create">${column.value}:</label>
                                <input type="number" min="0" max="2" name="${column.key}" class="form-control"
                                       id="input-nsi-${column.key}-create"
                                       placeholder="${column.value}" required>
                            </c:when>


                            <c:otherwise>
                                <label for="input-nsi-${column.key}-create">${column.value}:</label>

                                <c:choose>
                                <c:when test="${domain eq 'business_line'}">
                                    <input name="${column.key}" class="form-control"    id="input-nsi--create"
                                           placeholder="${column.value}"  required >
                                    <input hidden="true" name="TEXTAREANSI" id="text-area-bpcard" />
                                </c:when>
                                <c:otherwise>
                                    <input name="${column.key}" class="form-control"  id="input-nsi--create"
                                           placeholder="${column.value}" required >
                                    <input hidden="true" name="TEXTAREANSI" id="text-area-bpcard" />
                                </c:otherwise>
                                </c:choose>

                                <c:choose>
                                <c:when test="${domain eq 'depfl_product_line' || domain eq 'dep_product_line'}">
                                    <br/>
                                    <div>
                                        <label>Карточка банковского продукта</label>
                                        <div class="dropdown" >
                                            <select class="dropdown-nsi" id="dropdown-nsi">
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
    <div class="row float-right">
        <button class="btn create-nsi-entry-submit-button" onclick="sendForm('${domain}')">Создать</button>
        <button type="button" class="btn create-cancel-nsi-entry-button">Отмена</button>
    </div>

