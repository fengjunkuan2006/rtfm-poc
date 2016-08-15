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
    <link href="/staticmedia/components/datatable/css/jquery.dataTables_themeroller.css" rel="stylesheet"
          type="text/css"/>
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
                                    <li><a href='/asset/searchPage'>Search</a></li>
                                    <li><a href='/asset/addPage'>Add Asset</a></li>
                                </ul>
                                <input name='nvcm' type='hidden' value=';'/></form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                                <tr>
                                    <td><span><span><form accept-charset='UNKNOWN' id='ToggleViewForm' method='post'
                                                          name='ToggleViewForm' action='Dispatcher'
                                                          enctype='application/x-www-form-urlencoded'><input
                                            id='assignIds'
                                            value='assignIds'
                                            name='assignIds'
                                            type='hidden'/><input
                                            style='display:none;float:right;' class='pure-button' id='assetAssignment'
                                            name='assetAssignment'
                                            onclick="assetAssignment.disabled='true';nvcm.value='RootContext_130';submit();return false;"
                                            value='Asset Assignment' type='submit'/><input
                                            id='cancleBulkEditButton' value='Cancel Bulk edit'
                                            style='display:none;float:right;' class='pure-button'
                                            name='Cancel Bulk edit' type='button'/><input name='nvcm' type='hidden'
                                                                                          value=';'/></form><form
                                            accept-charset='UNKNOWN' id='ListAssetsForm' method='post'
                                            name='ListAssetsForm' action='Dispatcher'
                                            enctype='application/x-www-form-urlencoded'>
                                        <table id="assetListTable"></table>
                                        <input name='nvcm' type='hidden' value=';'/></form><span><table width='0%'
                                                                                                        cellspacing='4'
                                                                                                        border='0'>
                                    </table></span></span></span></td>
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

<script src="/staticmedia/components/datatable/js/jquery.dataTables.js" type="text/javascript"></script>
<script type="text/javascript">
    var table;
    $(document).ready(function () {
        var url = "/assets?${searchCondition.toString()}";
        table = $('#assetListTable').dataTable({
            "sDom": '<"H"lfrC>t<"F"ip>',

            "iDisplayLength": 15,
            "aLengthMenu": [[15, 25, 50, -1], [15, 25, 50, "All"]],
            "bSort": true,
            "bJQueryUI": true,
            "sPaginationType": "full_numbers",
            //"aaData": assets,
            "bServerSide": true,
            "sAjaxSource": url,
            "bStateSave": false,
            "aoColumns": [
                {
                    "sTitle": "Asset Reference", "sWidth":"20%", "mDataProp": function (obj) {
                    return "<a href='/asset/" + obj.keyId + "'>" + obj.assetReference + "</a>";
                }
                },
                {"sTitle": "Description", "sWidth":"30%", "mDataProp": "description"},
                {"sTitle": "Customer Account", "sWidth":"20%", "mDataProp": function (obj) {
                    if (obj.customerAccount != null) {
                        return obj.customerAccount.name;
                    } else {
                        return "";
                    }
                }
                },
                {"sTitle": "Location", "mDataProp": function (obj) {
                    if (obj.location != null) {
                        return obj.location.name;
                    } else {
                        return "";
                    }
                }
                }
            ]
        });
    });
</script>
</html>