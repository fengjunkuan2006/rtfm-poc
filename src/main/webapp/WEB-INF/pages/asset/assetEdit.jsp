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
                        <td>
                            <table width='100%' style='spokesoft_srs_clean_table' border='2'>
                                <tr>
                                    <td width='15%' class='spokesoft_srs_clean_tbody'>Asset :</td>
                                    <td class='spokesoft_srs_clean_tbody'>18051</td>
                                    <td class='spokesoft_srs_clean_tbody'> KC-EML-001</td>
                                    <td class='spokesoft_srs_clean_tbody'>Quarterly EM Lighting Maintenance</td>
                                </tr>
                                <tr>
                                    <td colspan='5' class='spokesoft_srs_clean_tbody'>
                                        <form accept-charset='UNKNOWN' id='ReturnToListForm' method='post'
                                              name='ReturnToListForm' action='Dispatcher'
                                              enctype='application/x-www-form-urlencoded'><input
                                                name='nvcm' type='hidden' value=';'/></form>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td class='messagebox'>
                            <div id="tipInfo"></div>
                            <div id='message'>Please make changes and click 'Update'.</div></td>
                    </tr>
                    <tr>
                        <td>
                            <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                                  enctype='application/x-www-form-urlencoded'>
                                <ul id='menu'>
                                    <li class='current'>Edit Asset</li>
                                </ul>
                                <input name='nvcm' type='hidden' value=';'/></form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                                <tr>
                                    <td><span><span><form action=' method=' post'
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
                                                                                                   name='assetReference'
                                                                                                   maxlength='50'
                                                                                                   value='${assets.assetReference}'
                                                                                                   size='50'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Description (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                                   id='Description'
                                                                                                   name='description'
                                                                                                   maxlength='200'
                                                                                                   value='${assets.description}'
                                                                                                   size='80'
                                                                                                   type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Customer Account (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><select id='CustomerAccount'
                                                                                                    class='inputtext'
                                                                                                    name='accountId'>
                                                    <%--<option value='${assets.accountId}' label='Select an Account'>${assets.accountId}</option>--%>

                                                </select><input id='AddAccountButton' value='Add Account'
                                                                class='pure-button' name='AddAccountButton'
                                                                onclick="window.location.href='/customerAccount/addPage'"
                                                                type='button'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Location (*)</td>
                                                <td colspan='3' class='spokesoft_srs_tbody'><input
                                                        name='locationId' id="locationId" type="hidden"
                                                        value="0"><select id="Location" class='inputtext'>
                                                </select>
                                                    <span id="locat"></span></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Manufacturer</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                       id='Manufacturer'
                                                                                       name='manufacturer'
                                                                                       maxlength='50'
                                                                                       value='${assets.manufacturer}'
                                                                                       size='30'
                                                                                       type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Serial Number</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                       id='SerialNumber'
                                                                                       name='serialNumber'
                                                                                       maxlength='50'
                                                                                       value='${assets.serialNumber}'
                                                                                       size='30'
                                                                                       type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Group (*)</td>
                                                <td class='spokesoft_srs_tbody'><select id='AssetGroup' name='groupId'
                                                                                        class='inputtext'>
                                                    <%-- <option value='${assets.groupId}'
                                                             label='No group'>${assets.groupId}</option>--%>
                                                </select></td>
                                            </tr>
                                        </table>
                                        <input id='UpdateButton' value='Update' class='pure-button' name='UpdateButton'
                                               type='button'/></form>
                                        <script language='Javascript'>
                                            cal.manageFields('LastServiced_trigger', 'LastServiced', '%d/%m/%Y');</script></span></span>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "/customerAccounts",
            type: "GET",
            async: true,
            success: function (data) {
                $.each(data, function (i, item) {
                    if (item.keyId == ${assets.accountId}) {
                        $("#CustomerAccount").append("<option value='" + item.keyId + "' selected='selected' >" + item.name + "</option>");
                    } else {
                        $("#CustomerAccount").append("<option value='" + item.keyId + "' >" + item.name + "</option>");
                    }
                })
            }
        });
        $.ajax({
            url: "/locations",
            type: "GET",
            async: true,
            success: function (data) {
                $.each(data, function (i, item) {
                    if (item.keyId == ${assets.locationId}) {
                        $("#Location").append("<option value=" + item.keyId + " selected='selected' >" + item.name + "</option>");
                    } else {
                        $("#Location").append("<option value=" + item.keyId + " >" + item.name + "</option>");
                    }
                })
            }
        });
        $.ajax({
            url: "/groups",
            type: "GET",
            async: true,
            success: function (data) {
                $.each(data, function (i, item) {
                    if (item.keyId == ${assets.groupId}) {
                        $("#AssetGroup").append("<option value=" + item.keyId + " selected='selected' >" + item.name + "</option>");
                    } else {
                        $("#AssetGroup").append("<option value=" + item.keyId + " >" + item.name + "</option>");
                    }
                })
            }
        });
        var flag = false;
        $("#Location").change(function () {
            $("#locationId").val($("#Location").val());
            $.ajax({
                url: "/findChild/" + $("#Location").val(),
                type: "GET",
                async: true,
                success: function (data) {
                    if (data != null && data.length > 0) {
                        flag = true;
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

        function setSelectVal(obj) {
            $("#locationId").val($(obj).val());
        }

        $("#UpdateButton").click(function () {
            var locationId = 0;
            if (flag) {
                locationId = $("#subLocation").val();
            } else {
                locationId = $("#Location").val();
            }
            var jsonData = {
                "keyId":${assets.keyId},
                "assetReference": $("#Reference").val(),
                "description": $("#Description").val(),
                "accountId": $("#CustomerAccount").val(),
                "locationId": locationId,
                "manufacturer": $("#Manufacturer").val(),
                "serialNumber": $("#SerialNumber").val(),
                "groupId": $("#AssetGroup").val()
            };
            $.ajax({
                url: "/updateAsset",
                data: JSON.stringify(jsonData),
                type: "POST",
                dataType: "json",
                contentType: "application/json",
                async: false,
                success: function (data) {
                    if(data.code == 0) {
                        $("#tipInfo").text(data.message);
                    }
                }
            });
        });
    });
</script>
</body>
</html>

