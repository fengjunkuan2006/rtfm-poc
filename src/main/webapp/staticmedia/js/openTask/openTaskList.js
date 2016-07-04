/**
 * Created by Viki.Feng on 2016/6/30.
 */
$(document).ready(function () {
    $.ajax({
        url: "/openTasks",
        type: "GET",
        async: true,
        success: function (responseText) {
            if (responseText.code == 0) {
                $.each(responseText.data, function(i, item){
                    $("#TaskTable").append(
                        "<tr>" +
                        "<td class='spokesoft_srs_clean_tbody'><input id='" + item.taskId + "' value='" + item.taskId + "'name='6' type='checkbox'/></td>" +
                        "<td class='spokesoft_srs_clean_tbody'><a id='linkTask13'href='Dispatcher?nvcm=RootContext_304;'class='documentlink'name='Task 256380'>" + item.taskId + "</a></td>" +
                        "<td class='spokesoft_srs_clean_tbody'>" + item.description + "</td>" +
                        "<td class='spokesoft_srs_clean_tbody'>" + item.location + "</td>" +
                        "<td class='hasCountdown_red'>" + item.slaDate + "</td>" +
                        "<td class='spokesoft_srs_clean_tbody'>" + item.manager + "</td>" +
                        "<td class='spokesoft_srs_clean_tbody'>" + item.resolver + "</td>" +
                        "<td class='hasCountdown_green'>" + item.priority + "</td>" +
                        "<td class='spokesoft_srs_clean_tbody'>" + item.status + "</td>" +
                        "<td class='spokesoft_srs_clean_tbody'>" + item.type + "</td>" +
                        "</tr>"
                    );
                });
            } else {
                alert("Error");
            }
        },
        error: function () {
            alert("Error");
        }
    });
});