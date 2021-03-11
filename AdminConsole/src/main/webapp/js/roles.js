$('#roles-table').on('click', 'tbody tr', function() {
    $(this).addClass('selected').siblings().removeClass('selected');
    $('.roles-page-buttons button').removeAttr('disabled');
});

$('.edit-role-modal-button').on('click', function () {

    $('#input-role-name-edit').val($('.selected .table-role-name').text());
    $('#input-role-description-edit').val($('.selected .table-role-description').text());
    $('.edit-role-modal').modal('show');
});

$('.edit-role-modal').on('hidden.bs.modal', function () {
    $('#input-role-name-edit').empty();
    $('#input-role-description-edit').empty();
});

$('.remove-role-modal-button').on('click', function () {
    $('<form id="remove-role-form" action="remove-role" method="POST">' +
        '<input type="hidden" name="roleName" value="' + $('.selected .table-role-name').text() + '">' +
        '</form>').appendTo('body');
    $('#remove-role-form').submit();
});

function validateFormRole() {
    var x = document.forms["rolesForm"]["roleName"].value;
    var y = document.forms["rolesForm"]["roleDescription"].value;
    if (x.length>150 || y.length>150 || x.length<1 ) {
        alert("Длинна не должна превышать 150 символов");
        return false;
    }
    if (x.length<1 ) {
        alert("Заполните поле Название");
        return false;
    }
}

function validateFormRole2() {
    var x = document.forms["rolesForm2"]["roleName2"].value;
    var y = document.forms["rolesForm2"]["roleDescription2"].value;
    if (x.length>150 || y.length>150 ) {
        alert("Длинна не должна превышать 150 символов");
        return false;
    }

    if (x.length<1 ) {
        alert("Заполните поле Название");
        return false;
    }
}

var userss = [];


$('.create-role-submit-button').on('click', function () {
    var $userRoles = [];
    var $rolename = $('#input-role-name-create').val();
    var $roleescription = $('#input-role-description-create').val();


    var p = {
        name: $rolename,
        description: $roleescription,
        userNames: userss
    }

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify(p),
        url: "/belinvest/admin/create-role",
        success: function (data) {
            alert(data.msg)
            window.location.replace('');
            console.log('success');
        },
        error: function (response) {
            var json = response.responseText;
            var r = JSON.parse(json);
            alert(r.msg)

        }
    });
});

$('#user_selected').change(function(){
    var value = $(this).val();
    console.log(value)
    var dot = ','
    var outputValue = ''
    $textarea = $('#text-area-users');
    var text = $textarea.val();
    if (!$textarea.val().length<1){
        dot = ','
    }else {
        dot = ''
    }

    //  outputValue = outputValue+dot+$textarea.val()+value;
    text+=dot + value

    console.log(text)
    userss.push(value)
    $('#text-area-users').val(text)

});

function eraseText() {
    $('#text-area-users').val('');
    userss = [];
}

$(document).ready(function () {
    roless = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-user-names",
        success: function (userz) {

            userz.forEach(function (user) {
                console.log(user)
                var li = $('<option></option>');
                li.addClass('dropdown-item');
                li.attr('id','dropdown-item')
                li.text(user);
                $('#user_selected').append(li);
            });
        }
    });
});

/*$(document).ready(function () {
    roless = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-groups",
        success: function (groups) {
            groups.forEach(function (group) {
                var li = $('<tr></tr>');
                var liname = $('<td></td>');
                var lidesc = $('<td></td>');
                var ligroups = $('<td></td>');

                $('#tv').append(li);
                liname.addClass('table-role-name');
                lidesc.addClass('table-role-description');
                ligroups.addClass('table-user-groups');

                liname.text(group.name);
                lidesc.text(group.description);

                var roles =  group.usernames;
                roles.forEach(function (r) {
                    var nme = r.login
                    var a = $('<a></a>');
                    a.text(nme + ' ');
                    ligroups.append(a);
                })
                li.append(liname);
                li.append(lidesc);
                li.append(ligroups);
            });
        }
    });
});*/


$('.create-role-modal-button').on('click', function () {

    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-user-names",
        success: function (userz) {

            userz.forEach(function (user) {
                console.log(user)
                var li = $('<option></option>');
                li.addClass('dropdown-item');
                li.attr('id','dropdown-item')
                li.text(user);
                $('#user_selected').append(li);
            });
        }
    });

});



$('.role-modal-button').on('click', function () {

    $('.role-modal-left-list').empty();
    $('.role-modal-right-list').empty();

    $('.edit-role-modal').modal('hide')

    var $role = $('#roles-table').find('.selected .table-role-name').text();


    $.when(fillUsers($role), fillUsersByRole($role)).then(function () {
        $('.role-modal-username').val($role);
        $('.role-modal').modal('show')
    });
});

$('.show-role-modal-button').on('click', function () {

    $('.edit-role-modal').modal('hide')
    $('.show-users-modal').modal('show')


    var $role = $('#roles-table').find('.selected .table-role-name').text();

    $('#coll').empty()

    document.getElementById('coll').innerHTML = '<div class="form-group">\n' +
        '                                <label><strong>Пользователи Роли</strong> <label id="info-dept-name-id"></label></label>\n' +
        '                            </div>'

    u = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-users-by-role?roleName=" + $role,
        success: function (userz) {
            u = userz;
            $('#coll')
            u.forEach(function (us) {
               // var $div = $('<div>');
                var div =  document.createElement('div')
                div.setAttribute('class','form-group')
                //var $label = $('<label>');
                var label =  document.createElement('label')
                label.innerText = us
                div.append(label)
                $('#coll').append(div)


            })
        }
    });


});


function fillUsers(role) {
    u = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-user-names",
        success: function (userz) {
            u = userz;
            $('.role-modal-left-list').empty();
            u.forEach(function (us) {
                var $li = $('<li>');
                $li.addClass('list-group-item');
                $li.text(us);
                $li.click(function () {
                    $(this).toggleClass('pressed');
                });
                $('.role-modal-left-list').append($li);
            })
        }
    });

}

function fillUsersByRole(roleName) {

    u = [];
    $.ajax({
        dataType: "json",
        url: "/belinvest/admin/get-users-by-role?roleName=" + roleName,
        success: function (userz) {
            u = userz;
            u.forEach(function (us) {
                var $li = $('<li>');
                $li.addClass('list-group-item');
                $li.text(us);
                $li.click(function () {
                    $(this).toggleClass('pressed');
                });
                $('.role-modal-right-list').append($li);
            })
        }
    });

}


$(".role-modal-move-to-right-button").click(function () {
    $(".role-modal-left-list .pressed").detach().appendTo(".role-modal-right-list");
    $(".role-modal-right-list .pressed").removeClass('pressed');
});

$(".role-modal-move-to-left-button").click(function () {
    $(".role-modal-right-list .pressed").detach().appendTo(".role-modal-left-list");
    $(".role-modal-left-list .pressed").removeClass('pressed');
});


$(".role-modal-move-all-to-right-button").click(function () {
    $(".role-modal-left-list .list-group-item").detach().appendTo(".role-modal-right-list");
    $(".role-modal-left-list .pressed").removeClass('pressed');
    $(".role-modal-right-list .pressed").removeClass('pressed');
});

$(".role-modal-move-all-to-left-button").click(function () {
    $(".role-modal-right-list .list-group-item").detach().appendTo(".role-modal-left-list");
    $(".role-modal-left-list .pressed").removeClass('pressed');
    $(".role-modal-right-list .pressed").removeClass('pressed');
});

$('.role-submit-button').on('click', function () {
    var $users = [];
    var v = [];
    var $removeUsers = []
    var $role = $('.role-modal-username').val();

    $('.role-modal-right-list .list-group-item').each(function () {
            $users.push($(this).text());
        }
    );

    $('.role-modal-left-list .list-group-item').each(function () {
       var us =  $(this).text()
        if(v.includes(us)){
            $removeUsers.push(us)
        }
        v.push(us)

        }
    );

    var p = {
        users: $users,
        removeUsers: $removeUsers
    }

    $.ajax({
        contentType: 'application/json',
        dataType: "json",
        type: "POST",
        data: JSON.stringify(p),
        url: "/belinvest/admin/update-user-roles-users?role=" + $role,
        success: function () {
            alert('Пользователи успешно назначены')
            window.location.replace('');
        },
        error: function () {
            alert('Ошибка сохранения')
        }
    });
});



