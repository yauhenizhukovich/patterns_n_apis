$('#firstLevelProductGroup').change(function () {



    fillSecondLevelProductGroupFindForm();

    if (window.location.href.includes('class')) {
        setTimeout(showButton, 300)
    } else {
        setTimeout(secondlevelrowshow, 300)
    }

});

$('#firstLevelProductGroupEdit').change(function () {
    deleteOptionsFromSelect("#secondLevelProductGroupEdit");
    //deleteOptionsFromSelect("#thirdLevelProductGroupEdit");
    var thirdLv = document.getElementById('thirdLevelProductGroupEdit')
    if (thirdLv!=null){
        thirdLv.hidden = true;
    }

   var fourLv =  document.getElementById('fourthLevelProductGroupEdit')
    if (fourLv!=null){
        fourLv.hidden = true
    }


    fillSecondLevelProductGroupFindForm();
    if (window.location.href.includes('class')) {
        setTimeout(showButton, 300)
    } else {
        setTimeout(secondlevelrowshow, 300)
    }

});


$('#secondLevelProductGroup').change(function () {
    fillThirdLevelProductGroupFindForm();
    if (window.location.href.includes('group')) {
        setTimeout(showButton, 300)
    } else {
        setTimeout(thirdlevelrowshow, 300)
    }

});

$('#secondLevelProductGroupEdit').change(function () {
    fillThirdLevelProductGroupFindForm();
    document.getElementById('thirdLevelProductGroupEdit').hidden = false;
    document.getElementById('fourthLevelProductGroupEdit').hidden = true;
    if (window.location.href.includes('group')) {
        setTimeout(showButton, 300)
    } else {
        setTimeout(thirdlevelrowshow, 300)
    }

});

$('#thirdLevelProductGroup').change(function () {
    fillFourthLevelProductGroupFindForm();
    if (!window.location.href.includes('sub')) {
        setTimeout(showButton, 300)
    } else {
        setTimeout(fourthlevelrowshow, 300)
    }
});

$('#thirdLevelProductGroupEdit').change(function () {
    document.getElementById('fourthLevelProductGroupEdit').hidden = false;
    fillFourthLevelProductGroupFindForm();
    if (!window.location.href.includes('sub')) {
        setTimeout(showButton, 300)
    } else {
        setTimeout(fourthlevelrowshow, 300)
    }
});

$('#fourthLevelProductGroup').change(function () {
    fillFifthLevelProductGroupFindForm();
    setTimeout(showButton, 300)
});

$('#fourthLevelProductGroupEdit').change(function () {
    fillFifthLevelProductGroupFindForm();
    setTimeout(showButton, 300)
});

$('#species-of-product').change(function () {
    fillSubSpeciesOfProduct();
})

function fillSecondLevelProductGroupFindForm() {

    deleteOptionsFromSelect("#secondLevelProductGroup");
    deleteOptionsFromSelect("#thirdLevelProductGroup");
    deleteOptionsFromSelect("#fourthLevelProductGroup");
    deleteOptionsFromSelect("#fifthLevelProductGroup");



    $('#secondLevelProductGroupEdit').empty()
    $('#thirdLevelProductGroupEdit').empty()
    $('#fourthLevelProductGroupEdit').empty()
    $('#fifthLevelProductGroupEdit').empty()


    fillProductGroupList('#firstLevelProductGroup', '#secondLevelProductGroup');

    fillProductGroupList('#firstLevelProductGroupEdit', '#secondLevelProductGroupEdit');


    $('#secondLevelProductGroup').val(0);
    $('#thirdLevelProductGroup').val(0);
    $('#fourthLevelProductGroup').val(0);
    $('#fifthLevelProductGroup').val(0);
}

function fillThirdLevelProductGroupFindForm() {
    deleteOptionsFromSelect("#thirdLevelProductGroup");
    deleteOptionsFromSelect("#fourthLevelProductGroup");
    deleteOptionsFromSelect("#fifthLevelProductGroup");

    deleteOptionsFromSelect("#thirdLevelProductGroupEdit");
    deleteOptionsFromSelect("#fourthLevelProductGroupEdit");
    deleteOptionsFromSelect("#fifthLevelProductGroupEdit");

    fillProductGroupList('#secondLevelProductGroup', '#thirdLevelProductGroup');
    fillProductGroupList('#secondLevelProductGroupEdit', '#thirdLevelProductGroupEdit');


    $('#thirdLevelProductGroup').val(0);
    $('#fourthLevelProductGroup').val(0);
    $('#fifthLevelProductGroup').val(0);
}

function fillFourthLevelProductGroupFindForm() {
    deleteOptionsFromSelect("#fourthLevelProductGroup");
    deleteOptionsFromSelect("#fifthLevelProductGroup");

    deleteOptionsFromSelect("#fourthLevelProductGroupEdit");
    deleteOptionsFromSelect("#fifthLevelProductGroupEdit");

    fillProductGroupList('#thirdLevelProductGroup', '#fourthLevelProductGroup');

    fillProductGroupList('#thirdLevelProductGroupEdit', '#fourthLevelProductGroupEdit');


    $('#fourthLevelProductGroup').val(0);
    $('#fifthLevelProductGroup').val(0);
}

function fillFifthLevelProductGroupFindForm() {
    deleteOptionsFromSelect("#fifthLevelProductGroup");
    deleteOptionsFromSelect("#fifthLevelProductGroupEdit");

    fillProductGroupList('#fourthLevelProductGroup', '#fifthLevelProductGroup');
    fillProductGroupList('#fourthLevelProductGroupEdit', '#fifthLevelProductGroupEdit');

    $('#fifthLevelProductGroup').val(0);
}

function fillProductGroupList(currentLevelSelector, nextLevelSelector) {
    let productGroups = parseProductGroups();
    let currentLevel = $(currentLevelSelector).val();

    if (currentLevel == null) {
        if (currentLevelSelector.includes('first')) {
            var iddd = $('#vid-table').find('.selected .busDr').attr('value')
            currentLevel = iddd;
        }
        if (currentLevelSelector.includes('second')) {
            var iddd = $('#vid-table').find('.selected .classProd').attr('value')
            currentLevel = iddd;
        }
        if (currentLevelSelector.includes('third')) {
            var iddd = $('#vid-table').find('.selected .groupProd').attr('value')
            currentLevel = iddd;
        }
        if (currentLevelSelector.includes('fourth')) {
            if (window.location.href.includes('sub')) {
                var iddd = $('#vid-table').find('.selected .vidProd').attr('value')
                currentLevel = iddd;
            } else {
                var iddd = $('#vid-table').find('.selected .vid-tdd').attr('value')
                currentLevel = iddd;
            }
        }
    }

    let nextLevel = $(nextLevelSelector);

    if (currentLevelSelector.includes('Edit')) {

        if (currentLevelSelector.includes('first')) {
            let option = document.createElement('option');
            option.text = 'Класс продукта'
            option.setAttribute('disabled', true);
            option.setAttribute('selected', true)
            option.setAttribute('value', 0)
            $(nextLevel).append(option);
        }

        if (currentLevelSelector.includes('second')) {
            let option = document.createElement('option');
            option.text = 'Группа продукта'
            option.setAttribute('disabled', true);
            option.setAttribute('selected', true)
            option.setAttribute('value', 0)
            $(nextLevel).append(option);
        }

        if (currentLevelSelector.includes('third')) {
            let option = document.createElement('option');
            option.text = 'Вид продукта'
            option.setAttribute('disabled', true);
            option.setAttribute('selected', true)
            option.setAttribute('value', 0)
            $(nextLevel).append(option);
        }
    }


    productGroups.forEach(el => {
        if (el.hiId === currentLevel && el.hiId !== "") {
            let option = document.createElement('option');
            option.value = el.id;
            option.text = el.name;
            option.setAttribute("tableName", el.tableName);
            $(nextLevel).append(option);
        }
    });
}

$(document).ready(function () {
    let productGroups = parseProductGroups();
    let firstLevel = $('#firstLevelProductGroup').val();

    var firstLevelHierarchyArray = [];
    var secondLevelHierarchyArray = [];
    var thirdLevelHierarchyArray = [];
    var fouthLevelHierarchyArray = [];
    var fifthLevelHierarchyArray = [];
    var resultArray = [];

    var elems = document.querySelectorAll('select option');
    elems.forEach(v => {
        let value = v.getAttribute('value')
        if (value != "0") {
            firstLevelHierarchyArray.push(value);
        }
    });

    firstLevelHierarchyArray.forEach(ar => {
        productGroups.forEach(el => {
            if (el.hiId === ar && el.hiId !== "") {
                if (!secondLevelHierarchyArray.includes(el)) {
                    secondLevelHierarchyArray.push(el)
                    resultArray.push(el)
                }
            }
        });
    });

    if (window.location.href.includes('view') || window.location.href.includes('group')) {

        secondLevelHierarchyArray.forEach(ar => {
            productGroups.forEach(el => {
                if (el.hiId === ar.id && el.hiId !== "") {
                    if (!thirdLevelHierarchyArray.includes(el)) {
                        thirdLevelHierarchyArray.push(el)
                        resultArray.push(el)
                    }
                }
            });
        });


        if (window.location.href.includes('view')) {
            thirdLevelHierarchyArray.forEach(ar => {
                productGroups.forEach(el => {
                    if (el.hiId === ar.id && el.hiId !== "") {
                        if (!fouthLevelHierarchyArray.includes(el)) {
                            fouthLevelHierarchyArray.push(el)
                            resultArray.push(el)
                        }
                    }
                });
            });


            if (window.location.href.includes('sub')) {
                fouthLevelHierarchyArray.forEach(ar => {
                    productGroups.forEach(el => {
                        if (el.hiId === ar.id && el.hiId !== "") {
                            if (!fifthLevelHierarchyArray.includes(el)) {
                                fifthLevelHierarchyArray.push(el)
                                resultArray.push(el)
                            }
                        }
                    });
                });
            }
        }

    }


    if (window.location.href.includes('product_view')) {
        fouthLevelHierarchyArray.forEach(ar => {
            let op = document.createElement('tr');
            let option = document.createElement('td')
            let option2 = document.createElement('td')
            let option3 = document.createElement('td')
            let option4 = document.createElement('td')

            op.append(option4)
            op.append(option3)
            op.append(option2);
            op.append(option);
            op.append(option);

            let productGroups = parseProductGroups();
            let child;
            productGroups.forEach(function (f) {
                if (ar.hiId == f.id) {
                    child = ar;
                    option2.setAttribute("value", child.id);
                    option2.setAttribute("class", "bisDr")
                    option2.innerText = child.name

                }
            })

            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option2.setAttribute("value", f.id);
                    option2.setAttribute("class", "groupProd")
                    option2.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option3.setAttribute("value", f.id);
                    option3.setAttribute("class", "classProd")
                    option3.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option4.setAttribute("value", f.id);
                    option4.setAttribute("class", "busDr")
                    option4.innerText = f.name

                }
            });

            option.setAttribute("value", ar.id);
            option.setAttribute("class", "vid-tdd")
            option.innerText = ar.name
            option.setAttribute("tableName", ar.tableName);
            $('#vid').append(op);


        })
    }

    if (window.location.href.includes('sub')) {
        fifthLevelHierarchyArray.forEach(ar => {
            let op = document.createElement('tr');
            let optio = document.createElement('td')
            let option = document.createElement('td')
            let option2 = document.createElement('td')
            let option3 = document.createElement('td')
            let option4 = document.createElement('td')

            op.append(option4)
            op.append(option3)
            op.append(option2);
            op.append(option);
            op.append(option);
            op.append(optio)

            let productGroups = parseProductGroups();
            let child = ar;


            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    child = f;
                    option.setAttribute("value", f.id);
                    option.setAttribute("class", "vidProd")
                    option.innerText = f.name
                }
            })

            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option2.setAttribute("value", f.id);
                    option2.setAttribute("class", "groupProd")
                    option2.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option3.setAttribute("value", f.id);
                    option3.setAttribute("class", "classProd")
                    option3.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option4.setAttribute("value", f.id);
                    option4.setAttribute("class", "busDr")
                    option4.innerText = f.name
                    child = f;

                }
            });

            optio.setAttribute("value", ar.id);
            optio.setAttribute("class", "vid-tdd")
            optio.innerText = ar.name
            optio.setAttribute("tableName", ar.tableName);
            $('#vid').append(op);


        })
    }

    if (window.location.href.includes('group')) {
        thirdLevelHierarchyArray.forEach(ar => {
            let op = document.createElement('tr');
            let optio = document.createElement('td')
            let option = document.createElement('td')
            let option2 = document.createElement('td')
            let option3 = document.createElement('td')
            let option4 = document.createElement('td')

            // op.append(option4)
            // op.append(option3)
            op.append(option2);
            op.append(option);
            op.append(optio)

            let productGroups = parseProductGroups();
            let child = ar;


            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    child = f;
                    option.setAttribute("value", f.id);
                    option.setAttribute("class", "classProd")
                    option.innerText = f.name
                }
            })

            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option2.setAttribute("value", f.id);
                    option2.setAttribute("class", "busDr")
                    option2.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option3.setAttribute("value", f.id);
                    option3.setAttribute("class", "1")
                    option3.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option4.setAttribute("value", f.id);
                    option4.setAttribute("class", "busDr")
                    option4.innerText = f.name
                    child = f;

                }
            });

            optio.setAttribute("value", ar.id);
            optio.setAttribute("class", "vid-tdd")
            optio.innerText = ar.name
            optio.setAttribute("tableName", ar.tableName);
            $('#vid').append(op);


        })
    }

    if (window.location.href.includes('bus')) {
        firstLevelHierarchyArray.forEach(ar => {
            let op = document.createElement('tr');
            let option = document.createElement('td')
            option.setAttribute('style','text-align: center')

            op.append(option);

            productGroups.forEach(function (f) {
                if (f.id == ar) {
                    option.setAttribute("value", f.id);
                    option.setAttribute("class", "busDr")
                    option.innerText = f.name
                }
            })

            $('#vid').append(op);
        })
    }



    if (window.location.href.includes('class')) {
        secondLevelHierarchyArray.forEach(ar => {
            let op = document.createElement('tr');
            let optio = document.createElement('td')
            let option = document.createElement('td')
            let option2 = document.createElement('td')
            let option3 = document.createElement('td')
            let option4 = document.createElement('td')

            // op.append(option4)
            // op.append(option3)
            // op.append(option2);
            op.append(option);
            op.append(optio)

            let productGroups = parseProductGroups();
            let child = ar;


            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    child = f;
                    option.setAttribute("value", f.id);
                    option.setAttribute("class", "busDr")
                    option.innerText = f.name
                }
            })

            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option2.setAttribute("value", f.id);
                    option2.setAttribute("class", "vid-td")
                    option2.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option3.setAttribute("value", f.id);
                    option3.setAttribute("class", "vid-td")
                    option3.innerText = f.name
                    child = f;

                }
            })
            productGroups.forEach(function (f) {
                if (f.id == child.hiId) {
                    option4.setAttribute("value", f.id);
                    option4.setAttribute("class", "vid-td")
                    option4.innerText = f.name
                    child = f;

                }
            });

            optio.setAttribute("value", ar.id);
            optio.setAttribute("class", "vid-tdd")
            optio.innerText = ar.name
            optio.setAttribute("tableName", ar.tableName);
            $('#vid').append(op);


        })
    }

   var count =  $('#vid').children().length;
    if (count<13){
        let cl = $('.vid-page-buttons');
        cl.removeClass('vid-page-buttons')
        cl.addClass('vid-page-buttonss')
    }
})

$('#vid-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.vid-page-buttons button').removeAttr('disabled');
    $('.vid-page-buttonss button').removeAttr('disabled');
});

function parseProductGroups() {
    let productGroups = [];
    $(".productGroupData").each(function () {
        let productGroup = {};
        productGroup["id"] = $(this).find('.id').text();
        productGroup["hiId"] = $(this).find('.hiId').text();
        productGroup["name"] = $(this).find('.name').text();
        productGroup["lev"] = $(this).find('.lev').text();
        productGroup["tableName"] = $(this).find('.tableName').text();
        productGroups.push(productGroup);
    })
    return productGroups;
}

function deleteOptionsFromSelect(selector) {
    document.querySelectorAll(selector).forEach(el => {
        $(el).children().each(function () {
            if (parseInt($(this).val()) !== 0) {
                $(this).remove();
            }
        });
    })




}

$('#tree').on('click', '.Product .Content', function () {
    $('#tree').find('.Product').each(function () {
        $(this).removeClass('selected');
    })

    $(this).closest('.Product').addClass('selected').siblings().removeClass('selected');
    $('#vid-edit-button').removeAttr('disabled');
    $('#vid-delete-button').removeAttr('disabled');
});

$('#edit-product-placing-button').on('click', function () {
    transformProductDataToForm();
    doProductFormActive();
    showProductForm();
})

$('#check-product-button').on('click', function () {
    transformProductDataToForm();
    disabledProductForm();
    showProductForm();
})

$('#save-product-change-button').on('click', function () {
    let id = $('.info-product-block').find('.id-of-product').attr("value");
    let bnId = $('#species-of-product').val();
    let dbId = $('#subspecies-of-product').val();

    $.ajax({
        contentType: 'application/json',
        type: "POST",
        dataType: "json",
        data: JSON.stringify({"id": id, "bnId": bnId, "dbId": dbId}),
        url: "/belinvest/admin/product_placing/update",
        success: function (data) {
            alert("Продукт успешно обновлён")
            window.location.replace('');
        }
    });
})

$('#cancel-product-change-button').on('click', function () {
    clearProductForm();
    disabledProductForm();
    hideProductForm();
})

function showProductForm() {
    let productBlock = $('.info-product-block');
    $(productBlock).show();
    $(productBlock).removeAttr("hidden");
}

function transformProductDataToForm() {
    let product = $('#tree .selected');
    let productBlock = $('.info-product-block');

    createSpeciesForProduct($(product).find('.productId').html());

    $(productBlock).find('.id-of-product').attr("value", $(product).find('.id').html());
    $(productBlock).find('.name-of-product').html($(product).find('.name').html());
    $(productBlock).find('.code-of-product').html($(product).find('.code').html());
    $(productBlock).find('#species-of-product').val($(product).find('.bnId').html());
    fillSubSpeciesOfProduct();
    $(productBlock).find('#subspecies-of-product').val($(product).find('.dbId').html());
}

function clearProductForm() {
    let productBlock = $('.info-product-block');
    $(productBlock).find('.id-of-product').attr("value", '');
    $(productBlock).find('.name-of-product').html('');
    $(productBlock).find('.code-of-product').html('');
    deleteOptionsFromSelect("#species-of-product")
    deleteOptionsFromSelect("#subspecies-of-product")
}

function doProductFormActive() {
    let productBlock = $('.info-product-block');
    $(productBlock).find('#species-of-product').removeAttr("disabled");
    $(productBlock).find('#subspecies-of-product').removeAttr("disabled");
    $(productBlock).find('#save-product-change-button').removeAttr("disabled");
}

function disabledProductForm() {
    let productBlock = $('.info-product-block');
    $(productBlock).find('#species-of-product').attr("disabled", '');
    $(productBlock).find('#subspecies-of-product').attr("disabled", '');
    $(productBlock).find('#save-product-change-button').attr("disabled", '');

}

function hideProductForm() {
    $('.info-product-block').hide();
}

function fillSubSpeciesOfProduct() {
    deleteOptionsFromSelect("#subspecies-of-product");
    let productGroups = parseProductGroups();
    let currentLevel = $('#species-of-product').val();
    let nextLevel = $('#subspecies-of-product');
    addEmptyOption(nextLevel);
    productGroups.forEach(el => {
        if (el.hiId === currentLevel && el.hiId !== "") {
            let option = document.createElement('option');
            option.value = el.id;
            option.text = el.name;
            option.setAttribute("tableName", el.tableName);
            $(nextLevel).append(option);
        }
    });
    $('#subspecies-of-product').val(0);
}

function createSpeciesForProduct(groupId) {
    let productGroups = parseProductGroups();
    let speciesForProduct = $('#species-of-product');

    deleteOptionsFromSelect("#species-of-product");
    addEmptyOption(speciesForProduct);
    productGroups.forEach(el => {
        if (el.hiId === groupId) {
            let option = document.createElement('option');
            option.value = el.id;
            option.text = el.name;
            $(speciesForProduct).append(option);
        }
    });
}

function addEmptyOption(selectBlock) {
    $(selectBlock).append(document.createElement('option'));
}

function secondlevelrowshow() {
    $('#secondLevelProductGroup').removeAttr('hidden')
}

function thirdlevelrowshow() {
    $('#thirdLevelProductGroup').removeAttr('hidden')
}

function fourthlevelrowshow() {
    $('#fourthLevelProductGroup').removeAttr('hidden')
}

function fourthlevelrowshow() {
    $('#fourthLevelProductGroup').removeAttr('hidden')
}

function fifthlevelrowshow() {
    $('#fifthLevelProductGroup').removeAttr('hidden')
}

function showButton() {
    $('#add_product_view_input').prop("disabled", false);
    $('#add_product_view_button').prop("disabled", false);
}

function returnSelectOptionToStart() {
    let optionArr = []

    $("#firstLevelProductGroup option").each(function() {
        let i =  $(this);
        optionArr.push(i);
    });
    $("#firstLevelProductGroup").empty()

    optionArr.forEach(function (el) {
        var li = $('<option></option>');
        li.attr('value', el.attr('value'))
        if (li.attr('value')==0){
            li.attr('selected',true)
            li.attr('disabled',true)
        }
        li.text(el.text());
        $('#firstLevelProductGroup').append(li);

    })

}

function sendd() {
    console.log('432432')


    if ($("#add_product_view_input").val().length < 1) {
        alert('Заполните пустое значение')
        returnSelectOptionToStart()
        return;
    }

    if (window.location.href.includes('bus')){
        if ($("#add_product_view_input").val().length > 10) {
            alert('Введенное значение не может превышать 10 символов')
            returnSelectOptionToStart()
            return;
        }
    }

    if (window.location.href.includes('class')){
        if ($("#add_product_view_input").val().length > 30) {
            alert('Введенное значение не может превышать 30 символов')
            returnSelectOptionToStart()
            return;
        }
    }

    if (window.location.href.includes('group')){
        if ($("#add_product_view_input").val().length > 100) {
            alert('Введенное значение не может превышать 100 символов')
            returnSelectOptionToStart()
            return;
        }
    }

    if (window.location.href.includes('view')){
        if ($("#add_product_view_input").val().length > 30) {
            alert('Введенное значение не может превышать 30 символов')
            returnSelectOptionToStart()
            return;
        }
    }


    var p = {
        businessDirections: $("#firstLevelProductGroup").val(),
        classProduct: $("#secondLevelProductGroup").val(),
        groupProduct: $("#thirdLevelProductGroup").val(),
        viewProduct: $("#fourthLevelProductGroup").val(),
        subViewProduct: $("#fifthLevelProductGroup").val(),
        inputField: $("#add_product_view_input").val()
    }

    $.ajax({
        url: '/belinvest/admin/nsi/product_view/create',
        type: 'post',
        dataType: 'json',
        data: JSON.stringify(p),
        contentType: 'application/json',
        success: function (data) {
            alert(data.msg);
            window.location.replace("");
        },
        error: function (response) {
            var json = response.responseText;
            var r = JSON.parse(json);
            alert(r.msg)
        }
    });
}

var idd;

function editProductView() {
    let x  =$('#firstLevelProductGroupEdit').find('option:selected');
   // x.prop('selected',false)
    console.log(x.text())

    console.log('clickСдшсл')

    var view = $('#vid-table').find('.selected .vid-tdd').text();
    var busDr = $('#vid-table').find('.selected .busDr').text();
    var busDrId = $('#vid-table').find('.selected .busDr').attr('value')
    var classProd = $('#vid-table').find('.selected .classProd').text();
    var classProdId = $('#vid-table').find('.selected .busDr').attr('value')
    var group = $('#vid-table').find('.selected .groupProd').text();
    var groupId = $('#vid-table').find('.selected .busDr').attr('value')
    var vid = $('#vid-table').find('.selected .vidProd').text();
    var vidId = $('#vid-table').find('.selected .busDr').attr('value')
    console.log(busDrId)
    console.log(busDr)
    console.log(classProd)
    console.log(group)
    console.log(vid)

    fillSecondLevelProductGroupFindForm();
    fillThirdLevelProductGroupFindForm();
    fillFourthLevelProductGroupFindForm()
    // fillFifthLevelProductGroupFindForm();



    $("#firstLevelProductGroupEdit :disabled").text(busDr)
    $("#secondLevelProductGroupEdit :disabled").text(classProd)
    $("#thirdLevelProductGroupEdit :disabled").text(group)
    $("#fourthLevelProductGroupEdit :disabled").text(vid)

    $("#firstLevelProductGroupEdit :disabled").attr('value', busDrId)
    $("#secondLevelProductGroupEdit :disabled").attr('value', classProdId)
    $("#thirdLevelProductGroupEdit :disabled").attr('value', groupId)
    $("#fourthLevelProductGroupEdit :disabled").attr('value', vidId)


    idd = $('#vid-table').find('.selected .vid-tdd').attr('value')

    $("#view").val(view)

    if (window.location.href.includes('bus')){
        idd = $('#vid-table').find('.selected .busDr').attr('value')
        $("#view").val(busDr)
    }


    $('.show-vid-modal').modal('hide')
    $('.edit-vid-modal').modal('show')

};

$('.create-user-modal-close-cross').on('click', function () {
    $('#secondLevelProductGroupEdit').empty();
    $('#thirdLevelProductGroupEdit').empty();
    $('#fourthLevelProductGroupEdit').empty();

})

$('.create-user-submit-button').on('click', function () {

    $('#add_product_view_input').val('')
})

function closee() {
    console.log('close')

    $('#secondLevelProductGroupEdit').empty();
    $('#thirdLevelProductGroupEdit').empty();
    $('#fourthLevelProductGroupEdit').empty();

    $('.show-vid-modal').modal('hide')
    $('.edit-vid-modal').modal('hide')
}


function showProductView() {
    var view = $('#vid-table').find('.selected .vid-tdd').text();
    var busDr = $('#vid-table').find('.selected .busDr').text();
    var busDrId = $('#vid-table').find('.selected .busDr').attr('value')
    var classProd = $('#vid-table').find('.selected .classProd').text();
    var classProdId = $('#vid-table').find('.selected .busDr').attr('value')
    var group = $('#vid-table').find('.selected .groupProd').text();
    var groupId = $('#vid-table').find('.selected .busDr').attr('value')
    var vid = $('#vid-table').find('.selected .vidProd').text();
    var vidId = $('#vid-table').find('.selected .busDr').attr('value')
    console.log(busDrId)


    $("#showbusDr").val(busDr)
    $("#showclassProd").val(classProd)
    $("#showgroupProd").val(group)

    if (window.location.href.includes('sub')) {
        $("#showgroupvid").val(vid)
        $("#showgroupsubvid").val(view)
    }else {
        $("#showgroupvid").val(view)

    }


    if (window.location.href.includes('class')) {
        $("#showclassProd").val(view)
    }

    if (window.location.href.includes('group')) {
        $("#showgroupProd").val(view)
    }

    if (window.location.href.includes('product_view')) {
        $("#showgroupvid").val(view)
    }

    if (window.location.href.includes('sub')) {
        $("#showgroupsubvid").val(view)
    }

    idd = $('#vid-table').find('.selected .vid-tdd').attr('value')
    $("#show").val(view)
    $('.show-vid-modal').modal('show')
};

function viewEdit() {
    var vl = $('#view').val();
    console.log(idd)

    if ($("#view").val().length < 1) {
        alert('Заполните пустое значение')
        return;
    }

    if ($("#view").val().length > 30) {
        alert('Введенное значение не может превышать 30 символов')
        return;
    }

    var p = {
        businessDirections: $("#firstLevelProductGroupEdit").val(),
        classProduct: $("#secondLevelProductGroupEdit").val(),
        groupProduct: $("#thirdLevelProductGroupEdit").val(),
        viewProduct: $("#fourthLevelProductGroupEdit").val(),
        subViewProduct: $("#fifthLevelProductGroupEdit").val(),
        inputField: vl
    }


    $.ajax({
        url: '/belinvest/admin/nsi/product_view/update/' + idd + '',
        type: 'post',
        dataType: 'json',
        data: JSON.stringify(p),
        contentType: 'application/json',
        success: function (data) {
            alert(data.msg);
            window.location.replace("");
        },
        error: function (response) {
            var json = response.responseText;
            var r = JSON.parse(json);
            alert(r.msg)
        }
    });
}

function viewDelete() {
    var answer = window.confirm('Вы действительно хотите удалить ?');


    if (answer) {
        var iddd ;

            if(window.location.href.includes('bus')){
                iddd  = $('#vid-table').find('.selected .busDr').attr('value')
            }else {
              iddd  = $('#vid-table').find('.selected .vid-tdd').attr('value')
            }

        $.ajax({
            url: '/belinvest/admin/nsi/product_view/delete/' + iddd + '',
            type: 'delete',
            success: function (data) {
                alert(data.msg);
                window.location.replace("");
            },
            error: function (response) {
                var json = response.responseText;
                var r = JSON.parse(json);
                alert(r.msg)
            }
        });
    }
}


$('#nsi-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.vid-page-buttons button').removeAttr('disabled');
})

$('.create-user-submit-button').on('click', function () {
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/nsi/depfl_product_line/get-pbCard",
        success: function (cards) {
            cards.forEach(function (card) {
                var li = $('<option></option>');
                li.attr('data', card.bPId)
                // li.attr('data-val',card.bpid)
                li.text(card.productName);
                $('#dropdown-nsi').append(li);
            })
        }
    });
})


$(".create-cancel-nsi-entry-button").on('click', function () {
    $('.create-nsi-entry-modal input').each(function () {
        $(this).val('');
    });
    $('.create-modal').modal('hide');
});

$('#dropdown-nsi').change(function () {
    var value = $(this).val();
    var id = $(this).children(":selected").attr("data");
    $('.create-nsi-entry-submit-button').removeAttr('disabled')
    $('.create-nsi-entry-submit-button-e').removeAttr('disabled')

    console.log(id)
    console.log(value)
    $('#text-area-bpcard').val(id)
});

$('#dropdown-nsii').change(function () {
    var value = $(this).val();
    var id = $(this).children(":selected").attr("data");
    $('.create-nsi-entry-submit-button').removeAttr('disabled')

    console.log(id)
    console.log(value)
    $('#text-area-bpcardd').val(id)
});

var parseEntryRow = function () {
    var $nsiEntryRow = $('#nsi-table').find('.selected');
    $nsiEntryRow.find("[data-nsi]").each(function () {
        $(".view-nsi-entry-modal").find('[name=' + this.className + ']').val($(this).text());
    });

};

$('.view-nsi-modal-button').on('click', function () {
    var x;
    var $nsiEntryRow = $('#nsi-table').find('.selected');
    $nsiEntryRow.find("[data-nsi]").each(function () {
        if (this.className == "id") {
            x = $(this).text();
        }
    });

    parseEntryRow();
    console.log(x)

    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/nsi/depfl_product_line/get-pbCard-by-nsi-id/" + x + "",
        success: function (data) {
            console.log(data.productName)
            $('#input-nsi-acc_status-NAME-view-kbp').val(data.productName);
        }
    });


    $('.view-nsi-entry-modal .form-group input').attr('disabled', 'true');
    $('.invalid-data').removeClass('invalid-data');
    $('.view-nsi-entry-modal').modal('show');
});

var pbidd;

$('.nsi-edit-entry-modal-button').on('click', function () {
    parseEntryRow();

    var x;
    var name
    var $nsiEntryRow = $('#nsi-table').find('.selected');
    $nsiEntryRow.find("[data-nsi]").each(function () {
        if (this.className == "id") {
            x = $(this).text();
        }
    });

    var $nsiEntryRow = $('#nsi-table').find('.selected');
    $nsiEntryRow.find("[data-nsi]").each(function () {
        if (this.className == "NAME") {
            name = $(this).text();
        }
    });

    $('#input-nsi-acc_status-NAME-edit').val(name)


    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/nsi/depfl_product_line/get-pbCard-by-nsi-id/" + x + "",
        success: function (data) {
            $('#dropdown-nsii').empty()
            $('#text-area-bpcardd').val(data.bPId);
            var lii = $('<option></option>');
            lii.attr('selected', true);
            lii.attr('data', data.bPId)
            lii.text(data.productName);
            console.log(data.productName)
            $('#dropdown-nsii').append(lii);


            $.ajax({
                dataType: "json",
                url: "/belinvest/admin/nsi/depfl_product_line/get-pbCard",
                success: function (cards) {
                    cards.forEach(function (card) {
                        var li = $('<option></option>');
                        li.attr('data', card.bPId)
                        li.text(card.productName);
                        $('#dropdown-nsii').append(li);
                    })
                }
            });

        }
    });


    $('.view-nsi-entry-modal .form-group input').removeAttr('disabled');
    // $('.nsi-entry-buttons').attr('hidden', '');
    // $('.nsi-entry-edit-buttons').removeAttr('hidden');
    $('.invalid-data').removeClass('invalid-data');
    $('.edit-nsi-entry-modal').modal('show');
});

$('.nsi-edit-entry-button').on('click', function () {
    var x;
    var name
    var $nsiEntryRow = $('#nsi-table').find('.selected');
    $nsiEntryRow.find("[data-nsi]").each(function () {
        if (this.className == "id") {
            x = $(this).text();
        }
    });

    var $nsiEntryRow = $('#nsi-table').find('.selected');
    $nsiEntryRow.find("[data-nsi]").each(function () {
        if (this.className == "NAME") {
            name = $(this).text();
        }
    });

    $('#input-nsi-acc_status-NAME-edit').val(name)


    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/nsi/depfl_product_line/get-pbCard-by-nsi-id/" + x + "",
        success: function (data) {
            $('#text-area-bpcardd').val(data.bPId);
            console.log('sss')
            pbidd = data.bPId;
        }
    });


    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/nsi/depfl_product_line/get-pbCard",
        success: function (cards) {
            cards.forEach(function (card) {
                var li = $('<option></option>');
                if (card.bPId == pbidd) {
                    li.attr('selected', true);
                }
                li.attr('data', card.bPId)
                // li.attr('data-val',card.bpid)
                li.text(card.productName);
                $('#dropdown-nsii').append(li);
            })
        }
    });
    $('.view-nsi-entry-modal .form-group input').removeAttr('disabled');
    $('.view-nsi-entry-modal').modal('hide')

    $('.edit-nsi-entry-modal').modal('show')
});

$('.nsi-remove-entry-button').on('click', function () {

    var answer = window.confirm('Вы действительно хотите удалить ?');

    if (answer) {
        $.ajax({
            contentType: 'application/json',
            type: "POST",
            data: $('.selected').find('.id').text(),
            url: window.location.href + "/remove",
            success: function () {
                alert('успешно удалено')
                window.location.replace('');
            },
            error: function () {
                alert('ошибка')
                console.log('ошибка');
            }
        });
    }
});

$('.nsi-edit-save-button').on('click', function  () {
    if ($('#input-nsi-acc_status-NAME-edit').val().length < 1){
        alert('Заполните пустые значения')
        return;
    }

    if ($('#input-nsi-acc_status-NAME-edit').val().length > 150){
        alert('Количество символов не должно превышать 150')
        return;
    }

    var $nsiEntry = {};

    $('.view-nsi-entry-modal').find('[data-nsi]').each(function () {
        $nsiEntry[$(this).attr('name')] = $(this).val();
    });

    $nsiEntry.NAME = $("#input-nsi-acc_status-NAME-edit").val()
    $nsiEntry.idCard = $('#text-area-bpcardd').val();

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify($nsiEntry),
        url: window.location.href + "/edit",
        success: function () {
            window.location.replace('');
        },
        error: function () {
            console.log('error');
            alert("Ошибка при обращении к серверу. Попробуйте позже.")
        }
    });

});


$('.nsi-delete-entry-button').on('click', function () {
    var answer = window.confirm('Вы действительно хотите удалить ?');

    if (answer) {
        var $nsiEntry = {};
        $('.view-nsi-entry-modal').find('[data-nsi]').each(function () {
            $nsiEntry[$(this).attr('name')] = $(this).val();
        });
        var deleteId = JSON.parse(JSON.stringify($nsiEntry)).id;
        $.ajax({
            contentType: 'application/json',
            type: "POST",
            data: deleteId,
            url: window.location.href + "/remove",
            success: function () {
                window.location.replace('');
            },
            fail: function () {
                console.log('error');
            }
        });
    }
});

$('.create-user-submit-button').on('click', function () {

    if (!window.location.href.includes('bus')) {
        document.getElementById('secondLevelProductGroup').hidden = true;
        document.getElementById('thirdLevelProductGroup').hidden = true;
        document.getElementById('fourthLevelProductGroup').hidden = true;
        document.getElementById('fifthLevelProductGroup').hidden = true;
    }
        $('#add_product_view_input').val('');
})


$('.create-nsi-entry-submit-button-e').on('click', function () {

    var domain

    if (window.location.href.includes('fl')){
        domain = 'credfl_product_line'
    }else if (window.location.href.includes('card')){
        domain = 'card_product_line'
    }else {
        domain = 'cred_product_line'
    }

    if ($('#input-nsi-NAME-create').val().length < 1){
        alert('Заполните пустые значения')
        return;
    }

    if ($('#input-nsi-NAME-create').val().length >150){
        alert('Значение не может превышать 150 символов')
        return;
    }

    $.ajax({
        url: '/belinvest/admin/nsi/'+domain+'/create',
        type: 'post',
        dataType: 'json',
        data: JSON.stringify({
            "name": $('#input-nsi-NAME-create').val(),
            "textAreaNsi": $('#text-area-bpcard').val()
        }),
        contentType: 'application/json',
        success: function (data) {
            alert(data.msg);
            window.location.replace("");
        },
        error: function (response) {
            var json = response.responseText;
            var r = JSON.parse(json);
            alert(r.msg)

        }
    });


});
