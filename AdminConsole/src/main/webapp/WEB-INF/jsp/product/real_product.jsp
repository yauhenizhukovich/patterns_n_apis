<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="real-product-info">
    <c:if test="${not empty fullProductDTO}">
        <div class="product">
            <div class="product-name">
                <c:forEach items="${fullProductDTO.productDTO.realProduct}" var="entry">
                    <c:if test="${entry.key eq fullProductDTO.productDTO.product.productGroup.productName}">
                        <h2>${entry.value}</h2>
                    </c:if>
                </c:forEach>
            </div>
            <table id="real-product-table" class="table table-bordered product-table">
                <thead>
                <tr>
                    <th scope="col">Название поля</th>
                    <th scope="col">Значение</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${fullProductDTO.fields}" var="field">
                    <tr>
                        <td class="fieldName" fieldName="${field.fieldName}" dataLength="${field.dataLength}" dataType="${field.dataType}" name="${field.name}" id="${field.id}">${field.name}</td>
                        <c:forEach items="${fullProductDTO.productDTO.realProduct}" var="entry">
                            <c:if test="${field.fieldName eq entry.key}">
                                <td class="${entry.key}">${entry.value}</td>
                            </c:if>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>
