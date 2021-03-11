$('#users-table').on('click', 'tbody tr', function () {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.users-page-buttons button').removeAttr('disabled');
});

var roless = [];

function eraseText() {
    $('#text-area-roles').val('');
    roless = [];
}


$('#role_selected').change(function(){
    var value = $(this).val();
    console.log(value)
    var dot = ','
    var outputValue = ''
    $textarea = $('#text-area-roles');
    var text = $textarea.val();
    if (!$textarea.val().length<1){
        dot = ','
    }else {
        dot = ''
    }

    //  outputValue = outputValue+dot+$textarea.val()+value;
    text+=dot + value

    console.log(text)
    roless.push(value)
    $('#text-area-roles').val(text)

});

$(document).ready(function () {
    roless = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/roles-user-is-not",
        success: function (groups) {
            groups.forEach(function (group) {
                var li = $('<option></option>');
                li.addClass('dropdown-item');
                li.attr('id','dropdown-item')
                li.text(group.name);
                $('#role_selected').append(li);
            });
        }
    });
});

$(document).ready(function () {
    roless = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-user-list",
        success: function (groups) {
            groups.forEach(function (group) {
                var li = $('<tr></tr>');
                var liuser = $('<td></td>');
                var lidomain = $('<td></td>');
                var ligroups = $('<td></td>');
                var liadddate = $('<td></td>');
                $('#tt').append(li);
                liuser.addClass('table-user-name');
                lidomain.addClass('table-user-domain');
                ligroups.addClass('table-user-groups');
                liadddate.addClass('table-user-description');

                liuser.text(group.login);
                lidomain.text(group.surName);

                var roles =  group.groups;
                roles.forEach(function (r) {
                    var nme = r.name
                    var a = $('<a></a>');
                    a.text(nme + ' ');
                    ligroups.append(a);
                })

                liadddate.text(group.adddate);
                li.append(liuser);
                li.append(lidomain);
                li.append(ligroups);
                li.append(liadddate);

            });
        }
    });
});



function fa() {
    alert('dsadsadsadasdasdas')
    //window.location.replace('');
}

function send() {
    if ($("#input-username-create").val().length<1) {
        var u = $("#login-input-label").text();
        alert('заполните ' + u);
        return;
    }

    if ($("#input-user-firstName-create").val().length<1) {
        var u = $("#input-user-firstName-label").text();
        alert('заполните ' + u);
        return;
    }

    if ($("#input-user-surName-create").val().length<1) {
        var u = $("#input-user-surName-label").text();
        alert('заполните ' + u);
        return;
    }

    if ($("#input-user-paterName-create").val().length<1) {
        var u = $("#input-user-paterName-label").text();
        alert('заполните ' + u);
        return;
    }

    if ($("#input-user-mail-create").val().length<1) {
        var u = $("#input-user-mail-label").text();
        alert('заполните ' + u);
        return;
    }

    if ($("#input-user-phone-create").val().length<1) {
        var u = $("#input-user-phone-label").text();
        alert('заполните ' + u);
        return;
    }

    if ($("#input-user-password-create").val().length<8) {
        alert('Пароль должен содержать не менее 8 символов');
        return;
    }


    if ($(".form-control").val().length > 150) {
        alert('поля не должны превышать 150 символов \nПроверьте правильность введенных значений');
        return;
    }

    var p = {
        login: $("#input-username-create").val(),
        password: $("#input-user-password-create").val(),
        surName: $("#input-user-surName-create").val(),
        firstName: $("#input-user-firstName-create").val(),
        paterName: $("#input-user-paterName-create").val(),
        usermail: $("#input-user-mail-create").val(),
        phone: $("#input-user-phone-create").val(),
        mobphone: $("#input-user-mobphone-create").val(),
        birthdate: $("#input-user-birthdate-create").val(),
        dept: $("#input-user-dept-create").val(),
        job: $("#input-user-job-create").val(),
        roles: roless,
        isCurator: $("#input-user-isCurator-create:checked").val(),
        isblocked: $("#input-user-isBlock-create:checked").val(),

    }


    $.ajax({
        url: '/belinvest/admin/create-user',
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

//LOADING USERS FROM LDAP
// $(".ldap-users-modal-button").click(function () {
//     $.ajax({
//         dataType: "json",
//         url: "ldap-users",
//         success: function (users) {
//             $('.ldap-users-modal-left-list').empty();user-info-modal
//             $('.ldap-users-modal-right-list').empty();
//             $('.ldap-users-load input').empty();
//             users.forEach(function (user) {
//                 var $li = $('<li>');
//                 $li.addClassoutputValue('list-group-item');
//
//                 var $span = $('<span>');
//                 $span.attr('name', 'name');
//                 $span.text(user['name']);
//
//                 var $input = $('<input>');
//                 $input.attr('value', user['description']);
//                 $input.attr('type', 'hidden');
//                 $input.attr('name', 'description');
//
//                 $span.appendTo($li);
//                 $input.appendTo($li);
//                 $li.click(function () {
//                     $(this).toggleClass('pressed');
//                 });
//                 $('.ldap-users-modal-left-list').append($li);
//             });
//         }
//     });
// });
//
// $(".ldap-users-modal-move-to-right-button").click(function () {
//     $(".ldap-users-modal-left-list .pressed").detach().appendTo(".ldap-users-modal-right-list");
//     $(".ldap-users-modal-right-list .pressed").removeClass('pressed');
// });
//
// $(".ldap-users-modal-move-to-left-button").click(function () {
//     $(".ldap-users-modal-right-list .pressed").detach().appendTo(".ldap-users-modal-left-list");
//     $(".ldap-users-modal-left-list .pressed").removeClass('pressed');
// });
//
//
// $(".ldap-users-modal-move-all-to-right-button").click(function () {
//     $(".ldap-users-modal-left-list .list-group-item").detach().appendTo(".ldap-users-modal-right-list");
//     $(".ldap-users-modal-left-list .pressed").removeClass('pressed');
//     $(".ldap-users-modal-right-list .pressed").removeClass('pressed');
// });
//
// $(".ldap-users-modal-move-all-to-left-button").click(function () {
//     $(".ldap-users-modal-right-list .list-group-item").detach().appendTo(".ldap-users-modal-left-list");
//     $(".ldap-users-modal-left-list .pressed").removeClass('pressed');
//     $(".ldap-users-modal-right-list .pressed").removeClass('pressed');
// });
//
// var $ldapUsersToUpdate = [];
//
// $(".ldap-users-submit-button").click(function () {
//
//     var $ldapUsers = [];
//     var $ldapUser;
//     $('.ldap-users-modal-right-list .list-group-item').each(function () {
//         $ldapUser = {};
//         $ldapUser.name = $(this).find("span[name='name']").text();
//         $ldapUser.description = $(this).find("input[name='description']").val();
//         $ldapUsers.push($ldapUser);
//     });
//
//     var $ldapUsersJSON = JSON.stringify($ldapUsers);
//     var $updateIfExist = $('.ldap-users-modal-bottom input[name="updateIfExist"]').is(':checked');
//     $.ajax({
//         contentType: 'application/json',
//         dataType: "json",
//         data: $ldapUsersJSON,
//         type: "POST",
//         url: "load-ldap-users?updateIfExist=" + $updateIfExist,
//         beforeSend: function () {
//             $('.ldap-users-submit-button').attr('disabled', true);
//             $('.ldap-users-submit-button-text').hide();
//             $('.ldap-users-spinner').show();
//         },
//         success: function (ldapUsersToUpdate) {
//             $('.ldap-users-modal').modal('hide');
//             $ldapUsersToUpdate = ldapUsersToUpdate;
//             $offerLdapUserToUpdate();
//         }
//     });
// });
//
// var $offerLdapUserToUpdate = function () {
//     if (Array.isArray($ldapUsersToUpdate) && $ldapUsersToUpdate.length > 0) {
//         var $user = $ldapUsersToUpdate.shift();
//         $('.load-ldap-user-modal-username').text($user['name']);
//         $('.load-ldap-user-modal-description').text($user['description']);
//         $('.load-ldap-user-modal').modal('show');
//     } else {
//         window.location.replace("");
//     }
// };
//
// $('.load-ldap-user-modal-yes-button').click(function () {
//     var $user = {};
//     $user.name = $('.load-ldap-user-modal-username').text();
//     $user.description = $('.load-ldap-user-modal-description').text();
//
//     var $userJSON = JSON.stringify($user);
//
//     $.ajax({
//         contentType: 'application/json',
//         dataType: "json",
//         data: $userJSON,
//         type: "POST",
//         url: "update-ldap-user",
//         success: function () {
//             $offerLdapUserToUpdate();
//         },
//         error: function () {
//             $offerLdapUserToUpdate();
//         }
//     });
// });
//
// $('.load-ldap-user-modal-no-button').click(function () {
//     $offerLdapUserToUpdate();
// });
//
// $('.load-ldap-user-modal-cancel-button').click(function () {
//     $ldapUsersToUpdate = [];
//     window.location.replace("");
// });
//
// $('.load-ldap-user-close-cross').click(function () {
//     $offerLdapUserToUpdate();
// });

////////////////////////////////////////////

function fillNotUserRoles(username) {
    return $.ajax({
        dataType: "json",
        url: "/belinvest/admin/roles-user-is-not?userName=" + username,
        success: function (groups) {
            groups.forEach(function (group) {
                var $li = $('<li>');
                $li.addClass('list-group-item');
                $li.text(group['name']);
                $li.click(function () {
                    $(this).toggleClass('pressed');
                });
                $('.user-role-modal-left-list').append($li);
            });
        }
    });
}

function fillUserRoles(username) {
    return $.ajax({
        dataType: "json",
        url: "/belinvest/admin/user-roles?userName=" + username,
        success: function (groups) {
            groups.forEach(function (group) {
                var $li = $('<li>');
                $li.addClass('list-group-item');
                $li.text(group['name']);
                $li.click(function () {
                    $(this).toggleClass('pressed');
                });
                $('.user-role-modal-right-list').append($li);
            });
        }
    });
}


$('.user-role-modal-button').on('click', function () {

    $('.user-role-modal-left-list').empty();
    $('.user-role-modal-right-list').empty();

    var $username = $('#users-table').find('.selected .table-user-name').text();


    $.when(fillNotUserRoles($username), fillUserRoles($username)).then(function () {
        $('.user-role-modal-username').val($username);
        $('.user-role-modal').modal('show')
    });

});

///////////////

$('.user-info-modal-button').on('click', function () {

    var $username = $('#users-table').find('.selected .table-user-name').text();


    //$('.user-role-modal-username').val($username);
    $('.user-info-modal').modal('show')


    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "GET",
        url: "/belinvest/admin/get-info-by-user?userName=" + $username,
        success: function (data) {
            setUserInfo(data);
        },
        error: function (response) {
            var json = response.responseText;
            var r = JSON.parse(json);

           // alert(r.msg)
        }
    });
});

function setUserInfo(json) {
    $("#info-login-id").text(' ' + json.login);
    $("#info-surname-id").text(' ' + json.surName);
    $("#info-name-id").text(' ' + json.firstName);
    $("#info-patername-id").text(' ' + json.paterName);
    $("#info-mail-id").text(' ' + json.usermail);
    $("#info-phone-id").text(' ' + json.phone);
    $("#info-mobilephone-id").text(' ' + json.mobphone);
    $("#info-birthday-id").text(' ' + json.birthdate);
    $("#info-dept-id").text(' ' + json.dept);
    $("#info-job-id").text(' ' + json.job);
    $("#info-iscurator-id").text(' ' + json.isCurator);
    $("#info-isblocked-id").text(' ' + json.isblocked);
}


$(".user-role-modal-move-to-right-button").click(function () {
    $(".user-role-modal-left-list .pressed").detach().appendTo(".user-role-modal-right-list");
    $(".user-role-modal-right-list .pressed").removeClass('pressed');
});

$(".user-role-modal-move-to-left-button").click(function () {
    $(".user-role-modal-right-list .pressed").detach().appendTo(".user-role-modal-left-list");
    $(".user-role-modal-left-list .pressed").removeClass('pressed');
});


$(".user-role-modal-move-all-to-right-button").click(function () {
    $(".user-role-modal-left-list .list-group-item").detach().appendTo(".user-role-modal-right-list");
    $(".user-role-modal-left-list .pressed").removeClass('pressed');
    $(".user-role-modal-right-list .pressed").removeClass('pressed');
});

$(".user-role-modal-move-all-to-left-button").click(function () {
    $(".user-role-modal-right-list .list-group-item").detach().appendTo(".user-role-modal-left-list");
    $(".user-role-modal-left-list .pressed").removeClass('pressed');
    $(".user-role-modal-right-list .pressed").removeClass('pressed');
});

$('.user-role-submit-button').on('click', function () {
    var $userRoles = [];
    var $username = $('.user-role-modal-username').val();

    $('.user-role-modal-right-list .list-group-item').each(function () {
            $userRoles.push($(this).text());
        }
    );

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify($userRoles),
        url: "/belinvest/admin/update-user-roles?userName=" + $username,
        success: function (data) {
            alert(data.msg)
            window.location.replace('');
            console.log('success');
        },
        error: function (response) {
            console.log(response.msg);
        }
    });
});

