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
                        <td class='messagebox'><span id='message'></span></td>
                    </tr>
                    <tr>
                        <td>
                            <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                                  enctype='application/x-www-form-urlencoded'>
                                <ul id='menu'>
                                    <li class='current'>Search</li>
                                    <li><a href='/asset/addPage'>Add Asset</a></li>
                                </ul>
                                <input name='nvcm' type='hidden' value=';'/></form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                                <tr>
                                    <td><span><span><form accept-charset='UNKNOWN' id='SearchAssetForm' method='post'
                                                          name='SearchAssetForm' action='/assets'
                                                          enctype='application/x-www-form-urlencoded'>
                                        <table width='100%' style='' border='0'>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Reference</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext' id='Reference'
                                                                                       name='assetReference'
                                                                                       maxlength='100'
                                                                                       value='' size='40' type='text'/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Description</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                       id='Description'
                                                                                       name='description'
                                                                                       maxlength='100' value=''
                                                                                       size='40' type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Manufacturer</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                       id='MANUFACTURER'
                                                                                       name='manufacturer'
                                                                                       maxlength='50' value='' size='40'
                                                                                       type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Serial Number</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                       id='SERIAL_NUMBER'
                                                                                       name='serialNumber'
                                                                                       maxlength='50' value='' size='40'
                                                                                       type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Service Provider</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext'
                                                                                       id='SERVICE_PROVIDER'
                                                                                       name='serviceProvider'
                                                                                       maxlength='50' value='' size='40'
                                                                                       type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Customer Account</td>
                                                <td class='spokesoft_srs_tbody'><select id='CustomerAccountId'
                                                                                        name='accountId'
                                                                                        class='inputtext'>
                                                    <option selected="selected" value="1" label="All Customer Accounts">
                                                        All Customer Accounts
                                                    </option>
                                                </select></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Location</td>
                                                <td class='spokesoft_srs_tbody'><span><input id='LocationId' value='2'
                                                                                             name='LocationId'
                                                                                             type='hidden'/><input
                                                        id='LOCATION' value='1' name='LOCATION' type='hidden'/>
                                                <select name="locationId" id="LOCATION_">
                                                    <option value="1">Please select an Location.</option>
                                                </select></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Asset Group</td>
                                                <td class='spokesoft_srs_tbody'><select id='AssetGroup'
                                                                                        name='groupId'
                                                                                        class='inputtext'>
                                                    <option value="112" label="No group">No group</option>
                                                </select></td>
                                            </tr>
                                        </table>
                                        <input id='SearchButton' value='Search' class='pure-button' name='SearchButton'
                                               onclick="submit()"
                                               type='submit'/><input name='nvcm' type='hidden'
                                                                     value='RootContext_494;'/><input
                                            class='pure-button' id='RootContext_496' name='Clear'
                                            tabindex='0' value='Clear' type='reset'/></form></span></span></td>
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
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "/customerAccounts",
            type: "GET",
            async: true,
            success: function (data) {
                $.each(data, function (i, item) {
                    $("#CustomerAccountId").append("<option value=" + item.keyId + " >" + item.name + "</option>");
                });
            }
        });
    })
</script>
</body>
</html>