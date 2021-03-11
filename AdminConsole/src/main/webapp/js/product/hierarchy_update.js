$('#thirdLevelProductGroup').change(function () {
    let productGroupId = {};
    productGroupId["id"] = $(this).val();
    $.ajax({
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        data: JSON.stringify(productGroupId),
        url: "/belinvest/admin/hierarchy_update/get_hierarchies_by_group",
        success: function (data){
            console.log(data);
            deleteOptionsFromSelect("#hierarchy-list")
            let hierarchyList = $('#hierarchy-list');
            data.forEach(elem => {
                let option = document.createElement('option');
                option.value = elem.name;
                option.text = elem.name;
                option.className = "hierarchyOption";
                hierarchyList.append(option);
            })
            $('#hierarchy-list').val(0);
        } ,
        fail: function () {
            console.log('error');
        }
    });
});

$('#firstLevelProductGroup').change(function(){
    fillSecondLevelProductGroupFindForm();
});

$('#secondLevelProductGroup').change(function(){
    fillThirdLevelProductGroupFindForm();
});

$('#listOfHierarchies').change(function () {
    $("#find-button").removeAttr('disabled');
})

$('#tree').on('click','.Criterion .Content',function () {
    removeSelectedTreeContent();
    $(this).addClass('selected').siblings().removeClass('selected');
    $('#line-update-button').removeAttr('disabled');
    $('#view-product-button').attr("disabled",'');
})

$('#tree').on('click','.Product .Content',function () {
    removeSelectedTreeContent();
    $(this).addClass('selected').siblings().removeClass('selected');
    $('#view-product-button').removeAttr('disabled');
    $('#line-update-button').attr("disabled",'');
})

function removeSelectedTreeContent() {
    $('#tree').find('.Content').each(function () {
        $(this).removeClass('selected');
    })
}

function validateFindForm() {
    return true;
}

function fillSecondLevelProductGroupFindForm() {

    deleteOptionsFromSelect("#secondLevelProductGroup");
    deleteOptionsFromSelect("#thirdLevelProductGroup");
    deleteOptionsFromSelect("#hierarchy-list")

    fillProductGroupList('#firstLevelProductGroup','#secondLevelProductGroup');

    $('#secondLevelProductGroup').val(0);
    $('#thirdLevelProductGroup').val(0);
    $('#hierarchy-list').val(0);
}

function fillThirdLevelProductGroupFindForm() {
    deleteOptionsFromSelect("#thirdLevelProductGroup");
    deleteOptionsFromSelect("#hierarchy-list")

    fillProductGroupList('#secondLevelProductGroup','#thirdLevelProductGroup');

    $('#thirdLevelProductGroup').val(0);
    $('#hierarchy-list').val(0);
}

function fillProductGroupList(currentLevelSelector,nextLevelSelector) {
    let productGroups = parseProductGroups();
    let currentLevel = $(currentLevelSelector).val();
    let nextLevel = $(nextLevelSelector);

    productGroups.forEach(el => {
        if(el.hiId === currentLevel){
            let option = document.createElement('option');
            option.value = el.id;
            option.text = el.name;
            option.setAttribute("tableName",el.tableName);
            $(nextLevel).append(option);
        }
    });
}

function deleteOptionsFromSelect(selector) {
    document.querySelectorAll(selector).forEach(el => {
        $(el).children().each(function () {
            if(parseInt($(this).val()) !== 0){
                $(this).remove();
            }
        });
    })
}

function parseProductGroups() {
    let productGroups = [];
    $(".productGroupData").each(function () {
        let productGroup = {};
        productGroup["id"] = $(this).find('.id').text();
        productGroup["hiId"] = $(this).find('.hiId').text();
        productGroup["name"] = $(this).find('.name').text();
        productGroup["lev"] = $(this).find('.lev').text();
        productGroup["leaf"] = $(this).find('.leaf').text();
        productGroup["tableName"] = $(this).find('.tableName').text();
        productGroups.push(productGroup);
    })
    return productGroups;
}

$('#product-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.nsi-directory-page-buttons button').removeAttr('disabled');

    if ($(this).attr("type") === "NEW"){
        $(document).find('.last-level').each(function (){
            $(this).find('input').val('');
        })

        $('.level-of-hierarchy').each(function(){
            $(this).find('input').each(function () {
                $(this).val('');
            })

            if($(this).find('.level-number').text() !== "1"){
                $(this).find('.criterionList').val(0)
            }
        })
    }
    else {

        $(this).find("[data-update-hierarchy]").each(function (){
            let elem = $(".level-of-hierarchy").find('[name=' + this.className + ']');
            elem.val($(this).text());
        });
        $(this).find("[data-update-hierarchy]").each(function (){
            let elem = $(".last-level").find('[name=' + this.className + ']');
            elem.val($(this).text());
        });


        $(this).find(".productHierValue").each(function() {
            let structId = $(this).find('.productHierarchyStructId').text();
            let value = $(this).find('.value').text();
            $('.criterionList').each(function(){
                if($(this).attr("producthierstructid") === structId){
                    $(this).val(parseInt(value));
                }
            })
        });



    }

});

$('.save-change-level-button').on('click',function () {

        let idStruct = $(this).closest('.level-data').find('#select-criterion-for-level').attr('productHierStructId');
        let valueStruct = $(this).closest('.level-data').find('#select-criterion-for-level').val();
        let levelNumber = $(this).closest('.level-data').find('.level-number').html();
        let products = parseProducts();

        let data = {};
        data["productsId"] = [];
        products.forEach(product => {
            product.productHierValues.forEach(productHierValue => {
                if(productHierValue.productHierarchyStructLevel === levelNumber){
                    if(productHierValue.productHierarchyStructId === idStruct && productHierValue.value === valueStruct){
                        data.productsId.push(product.id);
                    }
                }
            })
        })
        data["tableName"] = $(document).find('.hierarchy .tableName').attr("value");
        data["fields"] = [];
        $(this).closest('.level-data').find('.field-for-level tbody tr').each(function () {
            data.fields.push(
                {   "fieldName" : $(this).find('.fieldName').attr("fieldName"),
                    "name"      : $(this).find('.fieldName').attr("name"),
                    "value"     : $(this).find('.value input').val(),
                    "dataLength": $(this).find('.fieldName').attr("dataLength"),
                    "dataType"  : $(this).find('.fieldName').attr("dataType")});
        });
        console.log(data);

        if(validateLevelUpdate(data)){
            $.ajax({
                contentType: 'application/json',
                type: "POST",
                dataType: "json",
                data: JSON.stringify(data),
                url: "/belinvest/admin/hierarchy_update/update",
                success: function (data){
                    console.log(data);
                    alert("Продукты успешно обновлены");
                    window.location.replace('');
                } ,
                fail: function () {
                    console.log('error');
                }
            });
        }
    });

function validateLevelUpdate(data) {
    let response = true;
    if(data.productsId.length < 1){
        alert("Не найдено ни одного подходящего продукта для обновления");
        response = false;
    }

    data.fields.forEach(el=>{
        el.value = el.value.trim();
       if(el.value !== ""){
           if(el.value.length > parseInt(el.dataLength)){
               alert("Превышено допустимое количество символов у поля "+el.name+" (допустимо:"+el.dataLength+")");
               response = false;
           }
           switch (el.dataType) {
               case "VARCHAR":
                   console.log(el.value);
                   break;
               case "VARCHAR2":
                   console.log(el.value);break;
               case "DATE":break;
               case "NUMBER":
                   if(!(!isNaN(el.value) && !isNaN(parseFloat(el.value)))){
                        alert("Введенное значение поля "+el.name+" не является числом");
                       response = false;
                   }break;
           }
       }
    });
    return response;
}

function parseProducts(){
    let products = [];
    $(document).find('#product-table tbody tr').each(function () {
        if ($(this).attr('type') !== "NEW") {
            let product = {};
            product["idFromProductTable"] = $(this).find('.idFromProductTable').html();
            product["id"] = $(this).find('.id').html();
            product["productCode"] = $(this).find('.productCode').html();
            product["productName"] = $(this).find('.productName').html();
            product["productHierValues"] = [];
            product["fields"] = [];
            $(this).find('.productHierValues').children().each(function () {
                let productHierValue = {};
                productHierValue["id"] = $(this).find('.id').html();
                productHierValue["value"] = $(this).find('.value').html();
                productHierValue["productHierarchyStructId"] = $(this).find('.productHierarchyStructId').html();
                productHierValue["productHierarchyStructLevel"] = $(this).find('.productHierarchyStructLevel').html();
                product.productHierValues.push(productHierValue);
            });
            $(this).find('.info').children().each(function () {
                let field = {};
                field["fieldName"] = $(this).attr('class');
                field["value"] = $(this).html();
                product.fields.push(field);
            });
            products.push(product);
        }
    })
    //console.log(products);
    return products;
}

$('.save-change-product-button').on('click',function () {

    let selectedProduct = $(document).find('#product-table tr.selected');

    if($(selectedProduct).attr("type") === "NEW"){
        createProduct();
    }else if($(selectedProduct).attr("type") === "CREATED"){
        let id = [];
        id.push($(selectedProduct).find('td.id').html());
        updateProduct(id);
    }else {
        alert("Выберите продукт из таблицы (Новый - для создания нового продукта, или код и название продукта, который вы хотите изменить)");
    }

})

function createProduct(){
    let data = {};
    data["productsId"] = [];
    data["tableName"] = $(document).find('.hierarchy .tableName').attr("value");
    data["fields"] = [];
    $(document).find('.level-data .field-for-level tbody tr').each(function () {
        data.fields.push(
            {   "fieldName" : $(this).find('.fieldName').attr("fieldName"),
                "name"   : $(this).find('.fieldName').attr("name"),
                "value"     : $(this).find('.value input').val(),
                "dataLength": $(this).find('.fieldName').attr("dataLength"),
                "dataType"  : $(this).find('.fieldName').attr("dataType")
            }
            );
    });

    data["productName"] = $(document).find('.hierarchy .productName').attr("value");
    data["productCode"] = $(document).find('.hierarchy .productCode').attr("value");
    data["hierarchyId"] = $(document).find('.hierarchy .id').attr("value");
    data["productGroupId"] = $(document).find('.hierarchy .productGroupId').attr("value");
    let productCodeField = $(document).find('.hierarchy .productCode').attr("value");
    data.fields.forEach(element => {
        if(element.fieldName === productCodeField){
            data["fieldNameProductCode"] = element.value;
        }
    });

    data["productHierValues"] = [];
    $(document).find('.level-of-hierarchy .criterionList').each(function () {
        data.productHierValues.push({"value":$(this).val(),
            "productHierarchyStruct":{"id":$(this).attr("productHierStructId")}
        })
    });

    validateCreateProductData(data)
        .then((response) => {
            if(response){
                $.ajax({
                    contentType: 'application/json',
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(data),
                    url: "/belinvest/admin/hierarchy_update/create-product",
                    success: function (data){
                        alert("Продукт успешно создан")
                        window.location.replace('');
                    } ,
                    fail: function () {
                        console.log('error');
                    }
                });
            }
        })
}

function checkIsLineExistAJAX(body) {
    return new Promise((resolve, reject) => {
        $.ajax({
            contentType: 'application/json',
            type: "POST",
            dataType: "json",
            data: JSON.stringify(body),
            url: "/belinvest/admin/hierarchy_update/checkLine",
            success: function (data){
                console.log(data)
                resolve(data);
            } ,
            fail: function () {
            }
        });
    })

}

function validateCreateProductData(serverData){
    let response = true;

    return new Promise(((resolve, reject) => {

        let productLine = $(document).find('.hierarchy .productLine').attr("value");
        let selectedProductLine;
        $('.level-data').each(function () {
            if($(this).find('.level-number').html() === "1"){
                selectedProductLine = $(this).find('.criterionList option:selected');
            }
        })

        let isNull = false;
        serverData.productHierValues.forEach(el=>{
            if(el.value == null){
                isNull = true;
                response = false;
            }
        })
        if(isNull){
            alert("Должно быть выбрано название для каждого уровня");
        }

        serverData.fields.forEach((el)=>{
            el.value = el.value.trim();
            if(el.value !== ""){
                if(el.value.length > parseInt(el.dataLength)){
                    alert("Превышено допустимое количество символов у поля "+el.name+" (допустимо:"+el.dataLength+")");
                    response = false;
                }
                switch (el.dataType) {
                    case "VARCHAR":
                        break;
                    case "VARCHAR2":
                        break;
                    case "DATE":
                        break;
                    case "NUMBER":
                        if(!(!isNaN(el.value) && !isNaN(parseFloat(el.value)))){
                            alert("Введенное значение поля "+el.name+" не является числом");
                            response = false;
                        }break;
                }
            }
            else {
                if (el.fieldName === serverData.productCode) {
                    alert("Поле " + el.name + " не дожно быть пустым");
                    response = false;
                }
                if (el.fieldName === serverData.productName) {
                    alert("Поле " + el.name + " не дожно быть пустым");
                    response = false;
                }
            }
        });

        resolve(response)
    }))

    /*return new Promise(((resolve, reject) => {

        let productLine = $(document).find('.hierarchy .productLine').attr("value");
        let selectedProductLine;
        $('.level-data').each(function () {
            if($(this).find('.level-number').html() === "1"){
                selectedProductLine = $(this).find('.criterionList option:selected');
            }
        })

        checkIsLineExistAJAX(
            {hierarchyId : serverData.hierarchyId,
                   value : $(selectedProductLine).attr('value') ,
                   productStructId : $(selectedProductLine).parent().attr("producthierstructid")
        })
            .then((data)=>{
                let isNull = false;
                serverData.productHierValues.forEach(el=>{
                    if(el.value == null){
                        isNull = true;
                        response = false;
                    }
                })
                if(isNull){
                    alert("Должно быть выбрано название для каждого уровня");
                }

                if(productLine !== ""){
                    if(productLine !== $(selectedProductLine).text()){
                        alert("Название линейки для данной иерархии уже существует - "+productLine+" .Пожалуйста, выберите его для Название уровня 1.");
                        response = false;
                    }
                }else {
                    if(data == true){
                        alert("Такая линейка уже существует ("+ $(selectedProductLine).text() +"). Выберите другую.");
                        response = false;
                    }else {
                        console.log("Ok")
                    }
                }
                serverData.fields.forEach((el)=>{
                    el.value = el.value.trim();
                    if(el.value !== ""){
                        if(el.value.length > parseInt(el.dataLength)){
                            alert("Превышено допустимое количество символов у поля "+el.name+" (допустимо:"+el.dataLength+")");
                            response = false;
                        }
                        switch (el.dataType) {
                            case "VARCHAR":
                                break;
                            case "VARCHAR2":
                                break;
                            case "DATE":
                                break;
                            case "NUMBER":
                                if(!(!isNaN(el.value) && !isNaN(parseFloat(el.value)))){
                                    alert("Введенное значение поля "+el.name+" не является числом");
                                    response = false;
                                }break;
                        }
                    }
                    else {
                        if (el.fieldName === serverData.productCode) {
                            alert("Поле " + el.name + " не дожно быть пустым");
                            response = false;
                        }
                        if (el.fieldName === serverData.productName) {
                            alert("Поле " + el.name + " не дожно быть пустым");
                            response = false;
                        }
                    }
                });

                resolve(response)
            })

    }))*/
}

function updateProduct(id){
    let data = {};
    data["productsId"] = id;
    data["tableName"] = $(document).find('.hierarchy .tableName').attr("value");
    data["fields"] = [];
    $(document).find('.last-level .field-for-level tbody tr').each(function () {
        data.fields.push(
            {   "fieldName" : $(this).find('.fieldName').attr("fieldName"),
                "name"      : $(this).find('.fieldName').attr("name"),
                "value"     : $(this).find('.value input').val(),
                "dataLength": $(this).find('.fieldName').attr("dataLength"),
                "dataType"  : $(this).find('.fieldName').attr("dataType")});
    });
    data["productName"] = $(document).find('.hierarchy .productName').attr("value");
    data["productCode"] = $(document).find('.hierarchy .productCode').attr("value");
    console.log(data);

    validateUpdateProductData(data)
        .then((response)=>{
            if(response){
                $.ajax({
                    contentType: 'application/json',
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(data),
                    url: "/belinvest/admin/hierarchy_update/update",
                    success: function (data){
                        alert("Продукт успешно изменен")
                        window.location.replace('');
                    } ,
                    fail: function () {
                        console.log('error');
                    }
                });
            }
        });

}

function validateUpdateProductData(data){
    let response = true;

    return new Promise(((resolve, reject) => {
        if(data.productsId.length < 1){
            alert("Не найдено ни одного подходящего продукта для обновления");
            response = false;
        }

        data.fields.forEach(el=>{
            el.value = el.value.trim();
            if(el.value !== ""){
                if(el.value.length > parseInt(el.dataLength)){
                    alert("Превышено допустимое количество символов у поля "+el.name+" (допустимо:"+el.dataLength+")");
                    response = false;
                }
                switch (el.dataType) {
                    case "VARCHAR":
                        break;
                    case "VARCHAR2":
                        break;
                    case "DATE":
                        break;
                    case "NUMBER":
                        if(!(!isNaN(el.value) && !isNaN(parseFloat(el.value)))){
                            alert("Введенное значение поля "+el.name+" не является числом");
                            response = false;
                        }break;
                }
            }
            else {
                if (el.fieldName === data.productCode) {
                    alert("Поле " + el.name + " не дожно быть пустым");
                    response = false;
                }
                if (el.fieldName === data.productName) {
                    alert("Поле " + el.name + " не дожно быть пустым");
                    response = false;
                }
            }
        });

        resolve(response);
    }))
}

$('#view-product-button').on('click',function(){
    let selectedProduct = $('#tree .selected').parent();
    $('#product-id-input-form').attr("value",$(selectedProduct).find('.realId:first').text());
    $('#product-view-form').submit();
})

$('#line-update-button').on('click',function () {
    let data = {};
    let values = [];

    let selectedCriterion = $('#tree .selected').parent();

    let temp = $(selectedCriterion);
    while ($(temp).attr("class") !== "Group"){
        if($(temp).attr("class") === "Criterion"){
            values.push({"text":$(temp).find('.Content:first').text(),
                                "level":parseInt($(temp).find('.lev:first').text())-3})
        }
        temp = $(temp).parent();
    }

    data["productHierId"] = $(selectedCriterion).find(".prodHierId:first").text();

    console.log(data);

    $.ajax({
        dataType: "html",
        contentType: 'application/json',
        type: "POST",
        data: JSON.stringify(data),
        url: "/belinvest/admin/hierarchy_update/line",
        success: function (response){
            document.open();
            document.write(response);
            document.close();
            selectProductLine();
            selectUserCriterionFromTree(values);
            let id = $('.hierarchy').find('.id').attr("value");
            window.history.pushState(null, "Линейка продукта", "/belinvest/admin/hierarchy_update/get_hierarchy?hierarchyId="+id);
        } ,
        fail: function () {
            console.log('error');
        }
    });
});

function selectUserCriterionFromTree(values) {
    let level;
    let text;
    let criterionSelect;
    $('.level-data').each(function () {
        criterionSelect = $(this).find('.criterionList');
        level = $(this).find('.level-number').text();
        $(values).each(function () {
           if(parseInt(this.level) === parseInt(level)){
               text = this.text;
           }
        })

        $(this).find('.criterionForLevel').each(function () {
            if($(this).text() === text){
                console.log($(this).attr("value"));
                $(criterionSelect).val($(this).attr("value"));
            }
        })
    })
}

$('.cancel-change-level-button, .cancel-change-product-button').on('click',function (){
    clearLevelInputs(this)
});

function clearLevelInputs(button) {
    let hierarchyLevel = $(button).closest('.level-data');
    $(hierarchyLevel).find(".value input").each(function () {
        $(this).val("");
    })
    if($(button).attr("lastLevelButton") === "true"){
        $("#product-table").find('tr.selected').removeClass("selected")
    }
}

function selectProductLine() {
    let lineId = parseInt($(document).find('.hierarchy .lineId').attr("value"));
    let firstLevelCriterion;

    $('.level-data').each(function () {
        if($(this).find('.level-number').html() === "1"){
            firstLevelCriterion = $(this).find('.criterionList');
        }
    })

    $(firstLevelCriterion).val(lineId);
    $(firstLevelCriterion).prop('disabled', true);
}

$(document).ready(() => {
    selectProductLine();
})


$('.synchronize-change-product-button').on('click',function (){
    synchronizeOneProduct();
});

$('.synchronize-change-level-button').on('click',function (){
    let productsId = synchronizeProductsBySample(this);
    synchronize(productsId);
});

function synchronizeProductsBySample(button) {
    let idStruct = $(button).closest('.level-data').find('#select-criterion-for-level').attr('productHierStructId');
    let valueStruct = $(button).closest('.level-data').find('#select-criterion-for-level').val();
    let levelNumber = $(button).closest('.level-data').find('.level-number').html();
    let products = parseProducts();

    let productsId = [];
    products.forEach(product => {
        product.productHierValues.forEach(productHierValue => {
            if(productHierValue.productHierarchyStructLevel === levelNumber){
                if(productHierValue.productHierarchyStructId === idStruct && productHierValue.value === valueStruct){
                    productsId.push(product.idFromProductTable);
                }
            }
        })
    })

    return productsId;
}

function synchronizeOneProduct() {
    let selectedProduct = $(document).find('#product-table tr.selected');

    if($(selectedProduct).attr("type") === "CREATED"){
        let productsId = [];
        productsId.push($(selectedProduct).find('td.idFromProductTable').html());
        synchronize(productsId);
    }else {
        alert("Выберите существующий продукт из таблицы для синхронизации");
    }
}

function synchronize(productsId) {
    console.log(productsId)
    if(productsId.length !== 0){
        $.ajax({
            contentType: 'application/json',
            type: "POST",
            dataType: "json",
            data: JSON.stringify({
                "productsId": productsId
            }),
            url: "/belinvest/admin/hierarchy_update/synchronize",
            success: function (data){
                //alert("Синхронизация прошла успешно")
                alert(data.msg)
                //window.location.replace('');
            } ,
            error: function (response) {
                var json = response.responseText;
                var r = JSON.parse(json);
                alert(r.msg)
            }
        });
    }else {
        alert("Не найдено ни одного продукта для синхронизации");
    }
}