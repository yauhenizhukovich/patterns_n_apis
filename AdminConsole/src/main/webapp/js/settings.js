$('#settings-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.users-page-buttons button').removeAttr('disabled');
});


$('.settings-edit-modal-button').on('click', function () {

    console.log('click')

    var $owner = $('#settings-table').find('.selected .table-settings-owner').text();
    var $emailserver = $('#settings-table').find('.selected .table-settings-emailserver').text();
    var $notificationtemplate = $('#settings-table').find('.selected .table-settings-notificationtemplate').text();
    var $apiBarsNsiAddress = $('#settings-table').find('.selected .table-settings-apiBarsNsiAddress').text();
    var $apiBarsNsiUser = $('#settings-table').find('.selected .table-settings-apiBarsNsiUser').text();
    var $apiBarsNsiPwd = $('#settings-table').find('.selected .table-settings-apiBarsNsiPwd').text();
    var $apiBrisNsiAdress = $('#settings-table').find('.selected .table-settings-apiBrisNsiAdress').text();
    var $apiBrisNsiUser = $('#settings-table').find('.selected .table-settings-apiBrisNsiUser').text();
    var $apiBrisNsiPwd = $('#settings-table').find('.selected .table-settings-apiBrisNsiPwd').text();
    var $apiBarsAccAdress = $('#settings-table').find('.selected .table-settings-apiBarsAccAdress').text();
    var $apiBarsAccUser = $("#settings-table").find('.selected .table-settings-apibrisnsiuser').text();
    var $apiBarsAccPwd = $('#settings-table').find('.selected .table-settings-apibrisnsipwd').text();
    var $sedFolderPath = $('#settings-table').find('.selected .table-settings-sedFolderPath').text();
    var $timeoutSyncNsi = $('#settings-table').find('.selected .table-settings-timeoutSyncNsi').text();
    var $timeoutSyncAcc = $('#settings-table').find('.selected .table-settings-timeoutSyncAcc').text();




    $("#owner-input").val($owner)
    $("#emailserver-input").val($emailserver)
    //$("#notification-input").val($notificationtemplate)
    $("#apiBarsNsiAddress-input").val($apiBarsNsiAddress)
    $("#apiBarsNsiUser-input").val($apiBarsNsiUser)
    $("#apiBarsNsiPwd-input").val($apiBarsNsiPwd)
    $("#apiBrisNsiAdress-input").val($apiBrisNsiAdress)
    $("#apiBrisNsiUser-input").val($apiBrisNsiUser)
    $("#apiBrisNsiPwd-input").val($apiBrisNsiPwd)
    $("#apiBarsAccAdress-input").val($apiBarsAccAdress)
    $("#apiBarsAccUser-input").val($apiBarsAccUser)
    $("#apiBarsAccPwd-input").val($apiBarsAccPwd)
    $("#sedFolderPath-input").val($sedFolderPath)
    $("#timeoutSyncNsi-input").val($timeoutSyncNsi)
    $("#timeoutSyncAcc-input").val($timeoutSyncAcc)

    $('.settings-edit-modal').modal('show')

});

$('.settings-add-modal-button').on('click', function () {
    $('.settings-add-modal').modal('show')

});

$(document).ready(function () {
    roless = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-system-settings",
        success: function (groups) {
        }
    });
});


function sendSettingsEdit() {
    if ($("#input-username-create").val() === "") {
        var u = $("#login-input-label").text();
        alert('заполните ' + u);
        return;
    }
    //var $dss = $("#notification-input").val().slice(-4);

    /*if ($dss.length<0) {
        if ($dss !== 'docx') {
            alert('Фомат файла должен быть docx');
            return;
        }
    }*/

   /* if ($("#timeoutSyncAcc-input").val().length>2) {
        var u = $("#timeoutSyncAcc-input-labell").text();
        alert('Поле ' + u + " не должно превышать 2х символов");
        return;
    }

    if ($("#timeoutSyncNsi-input").val().length>2) {
        var u = $("#timeoutSyncNsi-label").text();
        alert('Поле ' + u + " не должно превышать 2х символов");
        return;
    }*/

    if ($(".form-control").val().length > 150) {
        alert('поля не должны превышать 150 символов \nПроверьте правильность введенных значений');
        return;
    }

    if ($("#owner-input").val().length < 1){
          alert('Заполните  путые значения');
          return;
    }
   /* if ($("#emailserver-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }*/

    if ($("#apiBrisNsiUser-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }
    if ($("#apiBrisNsiPwd-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }
   /* if ($("#apiBarsAccAdress-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }
    if ($("#apiBarsAccUser-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }
    if ($("#apiBarsAccPwd-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }
    if ($("#sedFolderPath-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }
    if ($("#apiBarsNsiPwd-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }
    if ($("#apiBrisNsiAdress-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }

    if ($("#apiBarsNsiAddress-input").val().length < 1){
        alert('Заполните  путые значения');
        return;
    }*/




    var id = $('#settings-table').find('.selected .table-settings-owner').text();

    var p = {
        sysOwner: $("#owner-input").val(),
       /* emailServer: $("#emailserver-input").val(),
        notificationTemplate: $("#notification-input").val(),
        apiBarsNsiAddress: $("#apiBarsNsiAddress-input").val(),
        apiBarsNsiUser: $("#apiBarsNsiPwd-input").val(),
        apiBarsNsiPwd: $("#apiBrisNsiAdress-input").val(),*/
        apiBrisNsiAdress: $("#apiBrisNsiAdress-input").val(),
        apiBrisNsiUser: $("#apiBrisNsiUser-input").val(),
        apiBrisNsiPwd: $("#apiBrisNsiPwd-input").val(),

       /* apiBarsAccAdress: $("#apiBarsAccAdress-input").val(),
        apiBarsAccUser: $("#apiBarsAccUser-input").val(),
        apiBarsAccPwd: $("#apiBarsAccPwd-input").val(),
        sedFolderPath: $("#sedFolderPath-input").val(),
        timeoutSyncNsi: $("#timeoutSyncNsi-input").val(),
        timeoutSyncAcc: $("#timeoutSyncAcc-input").val(),*/

    }


    $.ajax({
        url: '/belinvest/admin/edit-settings?settingId=' + id,
        type: 'put',
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

function sendSettingsAdd() {

    var $dss = $("#notification-input-create").val().slice(-4);

    if ($dss!=='docx') {
        alert('Фомат файла должен быть docx');
        return;
    }

    if ($("#timeoutSyncNsi-input-create").val().length>2) {
        var u = $("#timeoutSyncNsi-input-label").text();
        alert('Поле ' + u + " не должно превышать 2х символов");
        return;
    }

    if ($("#timeoutSyncAcc-input-create").val().length>2) {
        var u = $("#timeoutSyncAcc-input-label").text();
        alert('Поле ' + u + " не должно превышать 2х символов");
        return;
    }

    if ($(".form-control").val().length > 150) {
        alert('поля не должны превышать 150 символов \nПроверьте правильность введенных значений');
        return;
    }

    var p = {
        sysOwner: $("#owner-input-create").val(),
        emailServer: $("#emailserver-input-create").val(),
        notificationTemplate: $("#notification-input-create").val(),

        apiBarsNsiAddress: $("#apiBarsNsiAddress-input-create").val(),
        apiBarsNsiUser: $("#apiBarsNsiUser-input-create").val(),
        apiBarsNsiPwd: $("#apiBarsNsiPwd-input-create").val(),

        apiBrisNsiAdress: $("#apiBrisNsiAdress-input-create").val(),
        apiBrisNsiUser: $("#apiBrisNsiUser-input-create").val(),
        apiBrisNsiPwd: $("#apiBrisNsiPwd-input-create").val(),

        apiBarsAccAdress: $("#apiBarsAccAdress-input-create").val(),
        apiBarsAccUser: $("#apiBarsAccUser-input-create").val(),
        apiBarsAccPwd: $("#apiBarsAccPwd-input-create").val(),
        sedFolderPath: $("#sedFolderPath-input-create").val(),

        timeoutSyncNsi: $("#timeoutSyncNsi-input-create").val(),
        timeoutSyncAcc: $("#timeoutSyncAcc-input-create").val(),

    }

    $.ajax({
        url: '/belinvest/admin/save-settings',
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