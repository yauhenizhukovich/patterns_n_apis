$('#nsi-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.nsi-directory-page-buttons button').removeAttr('disabled');
});

var parseEntryRow = function () {
    var $nsiEntryRow = $('#nsi-table').find('.selected');
    $nsiEntryRow.find("[data-nsi]").each(function () {
        $(".view-nsi-entry-modal").find('[name=' + this.className + ']').val($(this).text());
    });
};

$(".create-cancel-nsi-entry-button").on('click', function () {
    $('.create-nsi-entry-modal input').each(function () {
        $(this).val('');
    });
    $('.create-nsi-entry-modal').modal('hide');
});

var pbidd;

$('.view-nsi-modal-button').on('click', function () {


    document.getElementById('mod-show').innerText = 'Просмотр записи'

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

    var doc = document.getElementById('input-nsi-acc_status-NAME-view-div');
    if (doc != null) {
        doc.hidden = false
        document.getElementById('input-nsi-acc_status-NAME-view-div-edit').hidden = true;
    }


    $('.view-nsi-entry-modal .form-group input').attr('disabled', '');
    $('.invalid-data').removeClass('invalid-data');
    $('.view-nsi-entry-modal').modal('show');
});

$('.nsi-edit-entry-modal-button').on('click', function () {
    var doc = document.getElementById('input-nsi-acc_status-NAME-view-div');

    document.getElementById('mod-show').innerText = 'Редактировать запись'

    if (doc != null) {
        doc.hidden = true
        var doc = document.getElementById('input-nsi-acc_status-NAME-view-div-edit').hidden = false;
    }
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

    // $('#input-nsi-acc_status-NAME-edit').val(name)

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
        url: "/belinvest/admin/nsi/depfl_product_line/get-pbCard2",
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
    $('.nsi-entry-buttons').attr('hidden', '');
    $('.nsi-entry-edit-buttons').removeAttr('hidden');
    $('.invalid-data').removeClass('invalid-data');
    $('.view-nsi-entry-modal').modal('show');
});

$('.nsi-edit-entry-button').on('click', function () {


    $('.view-nsi-entry-modal .form-group input').removeAttr('disabled');
    $('.nsi-entry-buttons').attr('hidden', '');
    $('.nsi-entry-edit-buttons').removeAttr('hidden');

});


$(document).ready((function () {

    $('.view-nsi-entry-modal').find('[data-nsi]').each(function () {
        var input = $(this).attr('type');
        if (input == 'number') {
            $(this).change((function () {
                $('.view-nsi-entry-modal').find('#errorSelect').attr('hidden', 'true');
                $('.view-nsi-entry-modal').find('#errorSelect12').attr('hidden', 'true');
                $('.view-nsi-entry-modal').find('#errorSelect3Params').attr('hidden', 'true');
                $('.nsi-edit-save-button').removeAttr('disabled');
                var value = $(this).val();
                var min = $(this).attr('min');
                var max = $(this).attr('max');
                if (min == '0' && max == '1') {
                    if (value < 0 | value > 1) {
                        $('.view-nsi-entry-modal').find('#errorSelect').removeAttr('hidden');
                        $('.nsi-edit-save-button').attr('disabled', 'true');
                        return false;
                    }
                }
                if (min == '1' && max == '2') {
                    if (value < 1 | value > 2) {
                        $('.view-nsi-entry-modal').find('#errorSelect12').removeAttr('hidden');
                        $('.nsi-edit-save-button').attr('disabled', 'true');
                        return false;
                    }
                }
                if (min == '0' && max == '2') {
                    if (value < 0 | value > 2) {
                        $('.view-nsi-entry-modal').find('#errorSelect3Params').removeAttr('hidden');
                        $('.nsi-edit-save-button').attr('disabled', 'true');
                        return false;
                    }
                }
            }))
        }
    });

    let directoryWithButtons = ["aftermath", "risks", "business_line", "product_class", "dep_product_line", "depfl_product_line", "dep_currency", "depfl_currency", "dep_terms", "depfl_terms", "prospects"];
    if (!directoryWithButtons.includes($('#domain').attr('name'))) {
        $('.create-nsi-modal-button').hide();
        $('.nsi-edit-entry-modal-button').hide();
        $('.nsi-remove-entry-button').hide();
        $('.nsi-edit-entry-button').hide();
    }
}));

$('.nsi-edit-save-button').on('click', function () {
    document.getElementById('mod-show').innerText = 'Редактировать запись'

    var $nsiEntry = {};

    let result;


    if (window.location.href.includes('dep')) {
        if ($('#input-nsi-acc_status-NAME-view').val().length < 1) {
            result = 1;
        } else if ($('#input-nsi-acc_status-NAME-view').val().length > 150) {
            result = 2;
        }
    } else {

        $('.view-nsi-entry-modal').find('[data-nsi]').each(function () {
            if ($(this).val().length < 1) {
                result = 1;
            }

            if ($(this).val().length > 100) {
                result = 2;
            }
        });
    }

    if (result == 2) {
        alert('Поля не должны превышать 150 символов')
    } else if (result == 1) {
        alert('заполните поля')
    } else {
        $('.view-nsi-entry-modal').find('[data-nsi]').each(function () {

            $nsiEntry[$(this).attr('name')] = $(this).val();
        });
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
    }

});


$('.nsi-edit-cancel-button').on('click', function () {
    parseEntryRow();
    $('.invalid-data').removeClass('invalid-data');
    $('.view-nsi-entry-modal .form-group input').attr('disabled', '');
    $('.nsi-entry-buttons').removeAttr('hidden');
    $('.nsi-entry-edit-buttons').attr('hidden', '');


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
            fail: function () {
                console.log('error');
            }
        });
    }
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

$('.create-nsi-modal-button').on('click', function () {
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


$('#dropdown-nsi').change(function () {
    var value = $(this).val();
    var id = $(this).children(":selected").attr("data");

    console.log(id)
    console.log(value)
    $('#text-area-bpcard').val(id)
});


var departmentJson;

$(document).ready(function () {
    $.ajax({
        url: '/belinvest/admin/nsi/department/departments',
        type: 'GET',
        success: function (data) {
            var tBody = $('#dept')

            departmentJson = data
            data.forEach(function (dept) {
                var tR = document.createElement('tr')


                var td1 = document.createElement('td')
                td1.innerText = dept.name
                td1.setAttribute('value', dept.id)
                td1.setAttribute('class', 'dept-td')
                tR.append(td1)

                var td2 = document.createElement('td')
                td2.innerText = dept.shortName
                td2.setAttribute('value', dept.id)
                td2.setAttribute('class', 'dept-td')
                tR.append(td2)

                var td3 = document.createElement('td')
                var rs
                if (dept.fDevelop == 1) {
                    rs = 'да'
                } else {
                    rs = 'нет'
                }
                td3.innerText = rs
                td3.setAttribute('value', dept.id)
                td3.setAttribute('class', 'dept-td')
                tR.append(td3)

                var td4 = document.createElement('td')
                td4.innerText = dept.headId
                td4.setAttribute('value', dept.id)
                td4.setAttribute('class', 'dept-td')
                tR.append(td4)

                var td5 = document.createElement('td')

                var x
                data.forEach(function (e) {
                    if (e.id === dept.parentId) {
                        x = e.name
                    }
                })

                if (typeof x == "undefined") {
                    x = 'пусто'
                }
                td5.innerText = x
                td5.setAttribute('value', dept.id)
                tR.append(td5)

                tBody.append(tR)

                var td6 = document.createElement('td')
                td6.innerText = dept.post
                td6.setAttribute('value', dept.id)
                td6.setAttribute('class', 'dept-td')
                tR.append(td6)

            })


            var dropdown = $('#departmentsdropdown-create')

            data.forEach(function (e) {

                let option = document.createElement('option')
                option.setAttribute('data', e.id)
                option.innerText = e.name;
                dropdown.append(option)
            })

            var dropdownn = $('#departmentsdropdown')

            data.forEach(function (e) {

                let option = document.createElement('option')
                option.setAttribute('data', e.id)
                option.innerText = e.name;
                dropdownn.append(option)
            })

        },
    });
});

var allusers = []

$(document).ready(function () {
    roless = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/getUsers",
        success: function (users) {
            let dropdown = $('#departmentuser-create')
            allusers = users
            let dropdownn = $('#departmentuser')
            users.forEach(function (user) {
                let x = document.createElement('option')
                x.innerText = user.firstName + ' ' + user.surName + ' ' + user.paterName

                x.setAttribute("data", user.job)
                dropdown.append(x)
            });


            users.forEach(function (user) {
                let x = document.createElement('option')
                x.innerText = user.firstName + ' ' + user.surName + ' ' + user.paterName
                x.setAttribute("data", user.job)
                dropdownn.append(x)
            });
        }
    });
});

function eraseText() {
    console.log('....')
    $('#text-area-departmentuser-create').val('');
    $('#text-area-departmentuser-edit').val('');


}

function eraseTextt() {
    $('#text-area-department-create').val('');
    $('#text-area-department-edit').val('');

}

$('#departmentuser-create').change(function () {
    var value = $(this).val();
    console.log(value)
    var id = $(this).children(":selected").attr("data");
    departId = id

    allusers.forEach(function (user) {
        if (value.includes(user.firstName)) {
            if (user.isCurator == "on") {
                $('#input-checkbox-dept-kurator').prop('checked', true);
            }
        }
    })


    var job = $(this).children(":selected").attr("data");
    console.log(job)


    $('#text-area-departmentuser-create').val(value)

    $('#inputt-dept-create').val(job)

    document.getElementById('inputt-dept-create').setAttribute('disabled', true)

    let k = $('text-area-departmentuser')
    k.attr('data', id)
});

$('#departmentuser').change(function () {
    var value = $(this).val();
    console.log(value)
    var id = $(this).children(":selected").attr("data");
    departId = id


    var job = $(this).children(":selected").attr("data");
    console.log(job)

    $('#text-area-departmentuser-edit').val(value)

    $('#inputt-dept-edit').val(job)

    let t = $('text-area-departmentuser-create')
    t.attr('data', id)

});


var departId;

$('#departmentsdropdown-create').change(function () {

    var value = $(this).val();

    var id = $(this).children(":selected").attr("data");
    departId = id


    $('#text-area-department-create').val(value)
    let k = $('#text-area-department-create')
    k.attr('data', id)

});

$('#departmentsdropdown').change(function () {

    var value = $(this).val();

    var id = $(this).children(":selected").attr("data");
    departId = id

    $('#text-area-department-edit').val(value)
    let t = $('#text-area-department-edit')
    t.attr('data', id)


});

function sendForm(domain) {
    var x;
    if (window.location.href.includes('depfl_product_line') || window.location.href.includes('dep_product_line')) {
        if ($('#input-nsi--create').val().length <1){
            alert('Заполните пустые значения')
            return;
        }


        if ($('#input-nsi--create').val().length >100){
            alert('Значение не может превышать 100 символов')
            return;
        }

        if ($('#text-area-bpcard').val().length <1){
            alert('Заполните пустые значения')
            return;
        }

        if ($('#text-area-bpcard').val().length >100){
            alert('Значение не может превышать 100 символов')
            return;
        }

        x = JSON.stringify({
            "name": $('#input-nsi--create').val(),
            "textarea": $('#text-area-bpcard').val()
        })
    } else if (window.location.href.includes('prospects')) {
        let elem1 = document.getElementsByName('PROSPECTS_NAME')
        console.log(elem1[1].value);

        let elem2 = document.getElementsByName('PROSPECTS_DESC')
        console.log(elem2[1].value);

        if (elem2[1].value.length <1){
            alert('Заполните пустые значения')
            return;
        }

        if (elem1[1].value.length <1){
            alert('Заполните пустые значения')
            return;
        }

        if (elem2[1].value.length >150){
            alert('Значение не может превышать 150 символов')
            return;
        }

        if (elem1[1].value.length >150){
            alert('Значение не может превышать 150 символов')
            return;
        }

        x = JSON.stringify({
            "name": elem1[1].value,
            "desc": elem2[1].value
        })
    } else if (window.location.href.includes('aftermath')) {
        let elem1 = document.getElementsByName('AFTERMATH_NAME')
        console.log(elem1[1].value);

        let elem2 = document.getElementsByName('AFTERMATH_DESC')
        console.log(elem2[1].value);

        if (elem2[1].value.length <1){
            alert('Заполните пустые значения')
            return;
        }

        if (elem1[1].value.length <1){
            alert('Заполните пустые значения')
            return;
        }

        if (elem2[1].value.length >150){
            alert('Значение не может превышать 150 символов')
            return;
        }

        if (elem1[1].value.length >150){
            alert('Значение не может превышать 150 символов')
            return;
        }

        x = JSON.stringify({
            "name": elem1[1].value,
            "desc": elem2[1].value
        })

    }else if (window.location.href.includes('risks')){

        let elem1 = document.getElementsByName('RISK_NAME')
        console.log(elem1[1].value);

        let elem2 = document.getElementsByName('DESCRIPTION')
        console.log(elem2[1].value);

        if (elem2[1].value.length <1){
            alert('Заполните пустые значения')
            return;
        }

        if (elem1[1].value.length <1){
            alert('Заполните пустые значения')
            return;
        }

        if (elem2[1].value.length >150){
            alert('Значение не может превышать 150 символов')
            return;
        }

        if (elem1[1].value.length >150){
            alert('Значение не может превышать 150 символов')
            return;
        }

        x = JSON.stringify({
            "name": elem1[1].value,
            "desc": elem2[1].value
        })


    } else {

        if ($('#input-nsi--create').val().length <1){
            alert('Заполните пустые значения')
            return;
        }


        if ($('#input-nsi--create').val().length >150){
            alert('Значение не может превышать 150 символов')
            return;
        }
        x = JSON.stringify({
            "name": $('#input-nsi--create').val(),
        })
    }

    $.ajax({
        url: '/belinvest/admin/nsi/' + domain + '/create',
        type: 'post',
        dataType: 'json',
        data: x,
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

function createDept() {
    if ($("#input-dept-create").val().length < 1) {
        alert('Заполните полное название подразделения');
        return;
    }

    if ($("#input-short-dept-create").val().length < 1) {
        alert('Заполните краткое название подразделения');
        return;
    }

    if ($("#input-dept-create").val().length > 150) {
        alert('Введенное значение не должно превышать 150 символов');
        return;
    }

    if ($("#input-short-dept-create").val().length > 150) {
        alert('Введенное значение не должно превышать 150 символов');
        return;
    }

    var p = {
        name: $('#input-dept-create').val(),
        shortName: $('#input-short-dept-create').val(),
        fDevelop: $("#input-checkbox-dept-create:checked").val(),
        headId: $("#text-area-departmentuser-create").val(),
        parentId: $('#text-area-department-create').attr('data'),
        post: $('#inputt-dept-create').val()

    }

    $.ajax({
        url: '/belinvest/admin/nsi/department/create',
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

$('#dept-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.vid-page-buttons button').removeAttr('disabled');
});


function deptDeleteModal() {
    var answer = window.confirm('Вы действительно хотите удалить ?');

    if (answer) {
        var iddd = $('#dept-table').find('.selected .dept-td').attr('value')

        $.ajax({
            url: '/belinvest/admin/nsi/department/hasChild/' + iddd + '',
            type: 'GET',
            success: function (data) {
                if (data == false) {

                    $.ajax({
                        url: '/belinvest/admin/nsi/department/delete/' + iddd + '',
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
                } else {

                    var answer = window.confirm("Департамент имеет дочерние подразделения. Вы уверены, что хотите удалить ?");
                    if (answer) {
                        $.ajax({
                            url: '/belinvest/admin/nsi/department/delete/' + iddd + '',
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
                    } else {
                        alert('Отменено')
                    }
                }
            },
        });
    }
}


function deptDelete() {
    var answer = window.confirm('Вы действительно хотите удалить ?');

    if (answer) {
        var iddd = $('#dept-table').find('.selected .dept-td').attr('value')

        $.ajax({
            url: '/belinvest/admin/nsi/department/delete/' + iddd + '',
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

function showDept() {
    console.log('click')
    var view = $('#dept-table').find('.selected .vid-td').text();
    idd = $('#dept-table').find('.selected .dept-td').attr('value')

    departmentJson.forEach(function (f) {
        if (f.id == idd) {
            let rs;
            if (f.fDevelop == 1) {
                rs = 'да'
            } else {
                rs = 'нет'
            }


            var x;
            departmentJson.forEach(function (e) {
                if (e.id === f.parentId) {
                    x = e.name
                }
            })


            if (typeof x == "undefined") {
                x = 'пусто'
            }

            $("#info-dept-name-id").text(' ' + f.name);
            $("#info-dept-short-id").text(' ' + f.shortName);
            $("#info-fDevelop-id").text(' ' + rs);
            $("#info-head-id").text(' ' + f.headId);
            $("#info-parent-id").text(' ' + x);
            if (f.post==null){
                $("#info-post").text(' ' + 'Отсутствует');
            }else {
                $("#info-post").text(' ' + f.post);
            }
        }
    })
    //$("#show").val(view)
    $('.show-dept-modal').modal('show')
};


function closee() {
    console.log('close')

    $('.update-dept-modal').modal('hide')
    $('.show-dept-modal').modal('hide')
}

var idDept;

function editDept() {
    console.log('click')
    var view = $('#vid-table').find('.selected .vid-td').text();
    idd = $('#dept-table').find('.selected .dept-td').attr('value')
    idDept = idd

    departmentJson.forEach(function (e) {

        var x;
        departmentJson.forEach(function (k) {
            if (k.id === e.parentId) {
                x = k.name
            }
        })

        if (typeof x == "undefined") {
            x = 'пусто'
        }

        if (e.id == idd) {
            $("#input-dept-edit").val(e.name)
            $("#input-short-dept-edit").val(e.shortName);
            $("#text-area-departmentuser-edit").val(e.headId);
            $("#text-area-department-edit").val(x);
           // $("#text-area-department-edit").attr('data',)

            if (e.fDevelop == 1) {
                $('#input-checkbox-dept-edit').prop('checked', true);
            } else {
                $('#input-checkbox-dept-edit').prop('checked', false);
            }

            if (e.post == null) {
                $('#inputt-dept-edit').val('отсутствует')
            } else {
                $('#inputt-dept-edit').val(e.post)
            }

            allusers.forEach(function (user) {
                if (e.headId.includes(user.firstName)) {
                    if (user.isCurator == "on") {
                        $('#input-checkbox-dept-kurator-edit').prop('checked', true);
                    }
                }
            })





        }
    })


    let r = $('#departmentsdropdown')


    // $("#show").val(view)
    $('.update-dept-modal').modal('show')
};


/*function eraseText() {
    $('#text-area-departmentuser-edit').val('');
    $('#text-area-department-edit').val('');

}*/

function updateDept() {

    if ($("#input-dept-edit").val().length < 1) {
        alert('Заполните полное название подразделения');
        return;
    }

    if ($("#input-short-dept-edit").val().length < 1) {
        alert('Заполните краткое название подразделения');
        return;
    }

    if ($("#input-dept-edit").val().length > 150) {
        alert('Введенное значение не должно превышать 150 символов');
        return;
    }

    if ($("#input-short-dept-edit").val().length > 150) {
        alert('Введенное значение не должно превышать 150 символов');
        return;
    }



    var p = {
        id: idDept,
        name: $('#input-dept-edit').val(),
        shortName: $('#input-short-dept-edit').val(),
        fDevelop: $("#input-checkbox-dept-edit:checked").val(),
        headId: $("#text-area-departmentuser-edit").val(),
        parentId: $('#text-area-department-edit').attr('data')

    }

    $.ajax({
        url: '/belinvest/admin/nsi/department/update',
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



