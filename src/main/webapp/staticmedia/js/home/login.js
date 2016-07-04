/**
 * Created by Vic.Feng on 08/12/2015.
 */
function login() {
    var username = $("#USERNAME");
    var password = $("#PASSWORD");
    var organisation = $("#org");

    $.ajax({
        url: "/home/login",
        data: '{"username":"' + username.val() + '", "password":"' + password.val() + '", "organisation":"' + organisation.val() + '"}',
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        async: false,
        success: function (responseText) {
            if (responseText.code == 0) {
                window.location.href = '/main';
            } else {
                alert("Error");
            }
        },
        error: function () {
            alert("Error");
        }
    });
}

//Check if user press enter key
function checkEnterKey() {
    if (event.keyCode == 13) {
        login();
    }
}