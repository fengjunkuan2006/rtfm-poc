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
            </td>

            <td valign='top' width='100%'>
                <table cellspacing='0' width='100%' border='0' cellpadding='0'>
                    <tr>
                        <td class='messagebox'><span id='message'>Please enter your user name and password.</span></td>
                    </tr>
                    <tr>
                        <td>
                            <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                                  enctype='application/x-www-form-urlencoded'>
                                <ul id='menu'>
                                    <li class='current'>Log In</li>
                                </ul>
                                <input name='nvcm' type='hidden' value=';'/></form>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                                <tr>
                                    <td><span><span><form accept-charset='UNKNOWN' id='formLogin' method='post'
                                                          name='formLogin' action='Dispatcher'
                                                          enctype='application/x-www-form-urlencoded'>
                                        <table width='100%' style='' border='0'>
                                            <tr>
                                                <td width='20%' class='spokesoft_srs_th'>Organisation</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext' id='org'
                                                                                       name='org' tabindex='1'
                                                                                       maxlength='80' value='AWSIE'
                                                                                       size='20' type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Login Name</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext' id='USERNAME'
                                                                                       name='USERNAME' tabindex='2'
                                                                                       maxlength='80' value='adm-mcrowley' size='20'
                                                                                       type='text'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Password</td>
                                                <td class='spokesoft_srs_tbody'><input class='inputtext' id='PASSWORD'
                                                                                       name='PASSWORD' tabindex='3'
                                                                                       maxlength='50' value='spokey' size='20'
                                                                                       type='password'/></td>
                                            </tr>
                                            <tr>
                                                <td class='spokesoft_srs_th'>Remember Me?</td>
                                                <td class='spokesoft_srs_tbody'><input id='rememberMe'
                                                                                       value='rememberMe'
                                                                                       name='rememberMe'
                                                                                       type='checkbox'/></td>
                                            </tr>
                                        </table>
                                        <input id='loginButton' value='Log In' class='pure-button' name='loginButton'
                                               onclick="login();"
                                               type='button'/><input name='nvcm' type='hidden'
                                                                     value='RootContext_239;'/></form></span></span>
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
</html>
<script type="text/javascript" src="/staticmedia/js/home/login.js"></script>