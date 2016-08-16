<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vic.Feng
  Date: 17/11/2015
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<html xmlns='http://www.w3.org/1999/xhtml'>
<head><title>RealTime /FM Ticket And Task Management</title>
    <jsp:include flush="true" page="/WEB-INF/pages/common.jsp"/>
</head>
<body id='srs_standard'>
<div align='justify'>
    <table cellspacing='0' width='100%' border='0' cellpadding='0'>
        <jsp:include flush="true" page="/WEB-INF/pages/common/header.jsp"/>
        <tr>
            <td valign='top'>
                <jsp:include flush="true" page="/WEB-INF/pages/common/menu_asset.jsp"/>
            </td>

            <td valign='top' width='100%'>
                <table cellspacing='0' width='100%' border='0' cellpadding='0'>
                    <tr>
                        <td class='messagebox'><span
                                id='message'>Please make changes and click on the update button.<br/>Enter Customer Account details and click the 'Add' button.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                                  enctype='application/x-www-form-urlencoded'>
                                <ul id='menu'>
                                    <li class='current'>Add Account</li>
                                </ul>
                                <input name='nvcm' type='hidden' value=';'/></form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                                <tr>
                                    <td><span><form accept-charset='UNKNOWN' id='acctForm' method='post' name='acctForm'
                                                    action='Dispatcher' enctype='application/x-www-form-urlencoded'>
                                        <table width='100%' style='' border='0'>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Name</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext' id='inputName'
                                                                                       name='inputName' maxlength='80'
                                                                                       value='' size='40' type='text'/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Number</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext' id='Number'
                                                                                       name='Number' maxlength='80'
                                                                                       value='' size='40' type='text'/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Location</td>
                                                <td class='spokesoft_srs_tbody'><span><input  value='-1'
                                                                                             name='location'
                                                                                             type='hidden'/>
                                                    <select id="Location" class='inputtext'>
                                                        <option value='-1' label='Please select an account.'>Please select an account. </option>
                                                    </select><span id="locat"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Active</td>
                                                <td class='spokesoft_srs_tbody'><input id='active'
                                                                                       value='active' name='active'
                                                                                       type='checkbox' onclick="check()"/></td>
                                            </tr>
                                        </table>
                                        <input id='updateButton' value='Add' class='pure-button' name='updateButton'
                                               onclick="submitInfo()"
                                               type='button'/></form></span>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    var checkstate = 0;
    function check() {
        if (document.getElementById("active").checked) {
            checkstate = 1;


        } else {
            checkstate = 0;

        }
    }

    $.ajax({
        url: "/locations",
        type: "GET",
        async: true,
        success: function (data) {
            $.each(data, function (i, item) {
                    $("#Location").append("<option value=" + item.keyId + " >" + item.name + "</option>");

            })
        }
    });

    $("#Location").change(function () {
        $.ajax({
            url: "/findChild/" + $("#Location").val(),
            type: "GET",
            async: true,
            success: function (data) {
                if (data != null && data.length > 0) {
                    var domStr = "<select id='subLocation' class='inputtext' name='subLocationId' onchange='setSelectVal(this)'><option value='0' selected='selected'>Select Location</option>";
                    $.each(data, function (i, item) {
                        domStr += "<option value='" + item.keyId + "' label='" + item.name + "'>" + item.name + "</option>";
                    })
                    domStr += "</select>";
                    $("#locat").html(domStr);
                }
            }
        })
    });

    function submitInfo() {
        $.ajax({
            url: "/customerAccount",
            data: '{"name":"' + $("#inputName").val() + '",' +
            ' "number":"' + $("#Number").val() + '",' + '"location":"1",' +
            ' "active":' + checkstate + '}',
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            async: false,
            success: function (responseText) {
                $("#message").text(responseText.message);


            },
            error: function () {
                alert("Error");

            }
        });
    }

</script>
</html>