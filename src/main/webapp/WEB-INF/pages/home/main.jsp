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
            <jsp:include flush="true" page="/WEB-INF/pages/common/menu.jsp"/>
        </td>

        <td valign='top' width='100%'>
            <table cellspacing='0' width='100%' border='0' cellpadding='0'>
                <tr>
                    <td class='messagebox'><span id='message'>Welcome to Real Time/FM</span></td>
                </tr>
                <tr>
                    <td>
                        <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                              enctype='application/x-www-form-urlencoded'>
                            <ul id='menu'>
                                <li class='current'>Menu</li>
                                <li><a href='Dispatcher?nvcm=RootContext_263'>Work List</a></li>
                                <li><a href='Dispatcher?nvcm=RootContext_264'>Action List</a></li>
                                <li><a href='Dispatcher?nvcm=RootContext_265'>Service Management</a></li>
                            </ul>
                            <input name='nvcm' type='hidden' value=';'/></form>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                            <tr>
                                <td><span><table id='formmenutable' cellspacing='0' width='100%' cellpadding='0'
                                                 border='0' style=''>
                                    <tr>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_242;'><img
                                                            border='0' src='/staticmedia/images/search_ticket.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Open Tickets'
                                                                          href='Dispatcher?nvcm=RootContext_242;'
                                                                          class='menu'>Open Tickets</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_243;'><img
                                                            border='0' src='/staticmedia/images/raise_ticket.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Raise New Ticket'
                                                                          href='Dispatcher?nvcm=RootContext_243;'
                                                                          class='menu'>Raise New Ticket</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_244;'><img
                                                            border='0' src='/staticmedia/images/search_tasks.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Open Tasks'
                                                                          href='Dispatcher?nvcm=RootContext_244;'
                                                                          class='menu'>Open Tasks</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_245;'><img
                                                            border='0' src='/staticmedia/images/search_tasks.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Open Recommendations'
                                                                          href='Dispatcher?nvcm=RootContext_245;'
                                                                          class='menu'>Open Recommendations</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name='' href='/srs/RMDashboard'
                                                                          target='_blank'><img border='0'
                                                                                               src='/staticmedia/images/search_tasks.png'/></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a target='_blank' href='/srs/RMDashboard'
                                                                          class='menu' name='RM Dashboard'>RM
                                                        Dashboard</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name='' href='/srs/PPMDashboard'
                                                                          target='_blank'><img border='0'
                                                                                               src='/staticmedia/images/search_tasks.png'/></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a target='_blank' href='/srs/PPMDashboard'
                                                                          class='menu' name='PPM Dashboard'>PPM
                                                        Dashboard</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_246;'><img
                                                            border='0' src='/staticmedia/images/about_rtfm_icon.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Lone Working'
                                                                          href='Dispatcher?nvcm=RootContext_246;'
                                                                          class='menu'>Lone Working</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_247;'><img
                                                            border='0' src='/staticmedia/images/search_ticket.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Tickets and Tasks'
                                                                          href='Dispatcher?nvcm=RootContext_247;'
                                                                          class='menu'>Tickets and Tasks</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_248;'><img
                                                            border='0' src='/staticmedia/images/assets.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Assets'
                                                                          href='Dispatcher?nvcm=RootContext_248;'
                                                                          class='menu'>Assets</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_249;'><img
                                                            border='0' src='/staticmedia/images/defaultMenu.gif'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Audit'
                                                                          href='Dispatcher?nvcm=RootContext_249;'
                                                                          class='menu'>Audit</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_250;'><img
                                                            border='0' src='/staticmedia/images/book_room_for_user.png'/></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Room Bookings'
                                                                          href='Dispatcher?nvcm=RootContext_250;'
                                                                          class='menu'>Room Bookings</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_251;'><img
                                                            border='0' src='/staticmedia/images/timesheets.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Timesheets'
                                                                          href='Dispatcher?nvcm=RootContext_251;'
                                                                          class='menu'>Timesheets</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_252;'><img
                                                            border='0' src='/staticmedia/images/inbox_maintenance.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Messaging'
                                                                          href='Dispatcher?nvcm=RootContext_252;'
                                                                          class='menu'>Messaging</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_253;'><img
                                                            border='0' src='/staticmedia/images/manage_kb.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='FAQ and KB'
                                                                          href='Dispatcher?nvcm=RootContext_253;'
                                                                          class='menu'>FAQ and KB</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_254;'><img
                                                            border='0' src='/staticmedia/images/system_admin.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='System Admin'
                                                                          href='Dispatcher?nvcm=RootContext_254;'
                                                                          class='menu'>System Admin</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_255;'><img
                                                            border='0' src='/staticmedia/images/sensors.gif'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Sensors'
                                                                          href='Dispatcher?nvcm=RootContext_255;'
                                                                          class='menu'>Sensors</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_256;'><img
                                                            border='0' src='/staticmedia/images/reports.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Reports'
                                                                          href='Dispatcher?nvcm=RootContext_256;'
                                                                          class='menu'>Reports</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_257;'><img
                                                            border='0' src='/staticmedia/images/profile.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='User Profile'
                                                                          href='Dispatcher?nvcm=RootContext_257;'
                                                                          class='menu'>User Profile</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_258;'><img
                                                            border='0' src='/staticmedia/images/ticket_rss.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Open Tickets'
                                                                          href='Dispatcher?nvcm=RootContext_258;'
                                                                          class='menu'>Open Tickets</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_259;'><img
                                                            border='0' src='/staticmedia/images/i18n.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='I18N'
                                                                          href='Dispatcher?nvcm=RootContext_259;'
                                                                          class='menu'>I18N</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name='' href='doc/userguide/realtime.pdf'
                                                                          target='_blank'><img border='0'
                                                                                               src='/staticmedia/images/userguide.png'/></a>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a target='_blank'
                                                                          href='doc/userguide/realtime.pdf'
                                                                          class='menu' name='User Guide'>User
                                                        Guide</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_260;'><img
                                                            border='0' src='/staticmedia/images/about_rtfm_icon.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='About RTFM'
                                                                          href='Dispatcher?nvcm=RootContext_260;'
                                                                          class='menu'>About RTFM</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''>
                                            <table width='100%' border='0'>
                                                <tr>
                                                    <td align='center'><a name=''
                                                                          href='Dispatcher?nvcm=RootContext_261;'><img
                                                            border='0' src='/staticmedia/images/logout.png'/></a></td>
                                                </tr>
                                                <tr>
                                                    <td align='center'><a name='Log Out'
                                                                          href='Dispatcher?nvcm=RootContext_261;'
                                                                          class='menu'>Log Out</a></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width='25%' class=''></td>
                                    </tr>
                                </table></span></td>
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