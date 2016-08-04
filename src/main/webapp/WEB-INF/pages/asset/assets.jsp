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
                                                                                          value=';'/></form>
                                        <table id='ListAssetsTable' width='100%' border='0' style=''>
                                            <tr>
                                                <td class='spokesoft_srs_th'><a name='Column2'
                                                                                href='#'>Asset
                                                    Reference</a></td>
                                                <td class='spokesoft_srs_th'><a name='Column3'
                                                                                href='#'>Description</a>
                                                </td>
                                                <td class='spokesoft_srs_th'><a name='Column4'
                                                                                href='#'>Customer
                                                    Account</a></td>
                                                <td class='spokesoft_srs_th'><a name='Column5'
                                                                                href='#'>Location</a>
                                                </td>


                                            </tr>
                                            <c:forEach items="${list}" var="asset">
                                                <tr>
                                                    <td class='spokesoft_srs_clean_tbody'><a id='linkAsset1'
                                                                                             href='/asset/${asset.keyId}'
                                                                                             class='documentlink'
                                                                                             name='Asset KC-EML-001'>${asset.assetReference}</a>
                                                    </td>
                                                    <td class='spokesoft_srs_clean_tbody'>${asset.description}</td>
                                                    <td class='spokesoft_srs_clean_tbody'>${asset.customerAccount.name}</td>
                                                    <td class='spokesoft_srs_clean_tbody'>${asset.location.name}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                        <input name='nvcm' type='hidden' value=';'/><span><table width='0%'
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
</html>