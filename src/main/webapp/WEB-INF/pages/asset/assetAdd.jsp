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
                        <td class='messagebox'><span id='message'>Please add new details and click 'Add'.</span></td>
                    </tr>
                    <tr>
                        <td>
                            <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                                  enctype='application/x-www-form-urlencoded'>
                                <ul id='menu'>
                                    <li><a href='/asset/searchPage'>Search</a></li>
                                    <li class='current'>Add Asset</li>
                                </ul>
                                <input name='nvcm' type='hidden' value=';'/></form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                                <tr>
                                    <td><span><span><form accept-charset='UNKNOWN' id='AssetForm' method='post'
                                                          name='AssetForm' action='Dispatcher'
                                                          enctype='multipart/form-data'>
                                        <style type='text/css'>.type-file-box {
                                            position: relative;
                                            width: 260px
                                        }

                                        .type-file-file {
                                            position: absolute;
                                            top: 0;
                                            left: 0;
                                            height: 24px;
                                            filter: alpha(opacity:0);
                                            opacity: 0;
                                            width: 220px
                                        }</style>
                                        <script type='text/javascript' language='Javascript'>$(function () {
                                            var textButton = "<input type='text' name='textfield' id='textfield' class='inputtext'/><input type='button' name='button' id='button' value='Browse' />"
                                            $(textButton).insertBefore("#AttachmentId");
                                            $("#AttachmentId").change(function () {
                                                $("#textfield").val($("#AttachmentId").val());
                                            });
                                        });</script>
                                        <table width='100%' style='' border='0'>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Asset Reference (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='Reference'
                                                                                                   name='Reference'
                                                                                                   maxlength='50'
                                                                                                   value='' size='50'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Description (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='Description'
                                                                                                   name='Description'
                                                                                                   maxlength='200'
                                                                                                   value='' size='80'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Customer Account (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'>
                                                    <select
                                                        onchange="javascript:AssetForm.nvcm.value='RootContext_330'; document.AssetForm.submit();"
                                                        id='CustomerAccount' class='inputtext' name='CustomerAccount'>
                                                    <option selected='selected' value='-1' label='Select an Account'>
                                                        Select an Account
                                                    </option>
                                                </select><input id='AddAccountButton' value='Add Account'
                                                                class='pure-button' name='AddAccountButton'
                                                                onclick="window.location.href='/customerAccount/addPage'"
                                                                type='submit'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Location (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><span><select id='Location'
                                                                                                          name='Location'
                                                                                                          class='inputtext'>
                                                    <option value='-1' label='Please select an account.'>Please select
                                                        an account.
                                                    </option>
                                                </select></span> <span id="locat"></span></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Group (*)</td>
                                                <td colspan="3" class='spokesoft_srs_tbody'>
                                                    <select id='AssetGroup'
                                                            name='AssetGroup'
                                                            class='inputtext'>
                                                        <option selected='selected' value='-1' label='No group'>No group
                                                        </option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Manufacturer</td>
                                                <td colspan="3" class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='Manufacturer'
                                                                                                   name='Manufacturer'
                                                                                                   maxlength='50'
                                                                                                   value='' size='30'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Serial Number</td>
                                                <td colspan="3" class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='SerialNumber'
                                                                                                   name='SerialNumber'
                                                                                                   maxlength='50'
                                                                                                   value='' size='30'
                                                                                                   type='text'/></td>
                                                </td>
                                            </tr>
                                        </table>
                                        <input id='UpdateButton' value='Add' class='pure-button' name='UpdateButton'
                                               onclick="submitInfo()"
                                               type='button'/></form><script
                                            language='Javascript'>var cal = Calendar.setup({
                                        animation: false,
                                        weekNumbers: true,
                                        fdow: 1,
                                        showTime: false,
                                        onSelect: function (cal, date) {
                                            this.hide();
                                            if (typeof (LastServicedTemp) != 'undefined') {
                                                LastServicedTemp = cal.selection.getDates()[0];
                                            }
                                            $('#LastServiced').change();
                                        }
                                    });
                                    cal.manageFields('LastServiced_trigger', 'LastServiced', '%d/%m/%Y');</script></span></span>
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
    $.ajax({
        url: "/groups",
        type: 'GET',
        success: function (data) {
            $.each(data, function (i, value) {
                $("#AssetGroup").append("<option value='" + value.keyId + "'>" + value.name + "</option>");
            });
        },
    });

    $.ajax({
        url: "/customerAccounts",
        type: 'GET',
        success: function (data) {
            $.each(data, function (i, value) {
                $("#CustomerAccount").append("<option value='" + value.keyId + "'>" + value.name + "</option>");
            });
        },
    });

    $.ajax({
        url:"/locations",
        type:"GET",
        async:true,
        success:function(data){
            $.each(data,function(i,item){
                $("#Location").append("<option value=" + item.keyId + " >" + item.name + "</option>");
            })
        }
    })

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
        if ($("#Reference").val() == "" || $("#Description").val() == "" || $("#Account").val() == "Please Choose" || $("#Location").val() == "Please Choose" || $("#Manufacturer").val() == "" || $("#SerialNumber").val() == "" || $("#AssetGroup").val() == "No group") {
            $("#message").text("Please select from available options AND empty field not allowed");
            setTimeout('$("#message").text("")', 2000);
        } else {
            $.ajax({
                url: "/asset",
                data: '{"assetReference":"' + $("#Reference").val() + '",' +
                ' "description":"' + $("#Description").val() + '",' + '"accountId":"1",' + ' "locationId":"1",' +
                '"manufacturer":"' + $("#Manufacturer").val() + '",' +
                '"serialNumber":"' + $("#SerialNumber").val() + '",' +
                ' "groupId":"' + $("#AssetGroup").val() + '"}',
                type: "POST",
                dataType: "json",
                contentType: "application/json",
                async: false,
                success: function (responseText) {
                    $("#info").text(responseText.message);
                    setTimeout('$("#message").text("")', 2000);
                },
                error: function () {
                    alert("Error");

                }
            });
        }
    }
</script>
</html>