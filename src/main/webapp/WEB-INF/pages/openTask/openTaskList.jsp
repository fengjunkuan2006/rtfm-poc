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
            <td class='messagebox'><span id='message'></span></td>
          </tr>
          <tr>
            <td>
              <form accept-charset='UNKNOWN' id='tabForm' method='post' name='tabForm' action='Dispatcher'
                    enctype='application/x-www-form-urlencoded'>
                <ul id='menu'>
                  <li><a href='Dispatcher?nvcm=RootContext_329'>Open Tickets</a></li>
                  <li class='current'>Open Tasks</li>
                  <li><a href='Dispatcher?nvcm=RootContext_331'>Search Tickets</a></li>
                  <li><a href='Dispatcher?nvcm=RootContext_332'>Search Tasks</a></li>
                  <li><a href='Dispatcher?nvcm=RootContext_333'>Add Task</a></li>
                  <li><a href='Dispatcher?nvcm=RootContext_334'>Raise Ticket for Customer</a></li>
                  <li><a href='Dispatcher?nvcm=RootContext_335'>Raise Ticket</a></li>
                </ul>
                <input name='nvcm' type='hidden' value=';'/></form>
            </td>
          </tr>
          <tr>
            <td>
              <table id='Green_TabContentTable' cellspacing='0' class='TabTable' cellpadding='0'>
                <tr>
                  <td><span><span><script language='Javascript'>
                    $(document).ready(function () {
                      originalUi();
                      var isTaskController = true
                      $('#resolverAssignment').mouseup(function () {
                        $('#assignType').val('doBulkResolverAssignment');
                      });
                      if (isTaskController) {
                        $('#managerAssignment').mouseup(function () {
                          $('#assignType').val('doBulkManagerAssignment');
                        });
                      }
                      $('#bulkEditButton').click(function () {
                        $(':checkbox').parents().show();
                        $(':checkbox').show();
                        $(this).hide();
                        $('#cancleBulkEditButton').show();
                      });
                      $('#cancleBulkEditButton').click(function () {
                        originalUi();
                        $(this).hide();
                        $('#bulkEditButton').show();
                        toggleAssBtn('none');
                      });
                      $(':checkbox:eq(0)').click(function () {
                        $(':checkbox').attr('checked', this.checked);
                      });
                      var $subBox = $(':checkbox:gt(0)');
                      $subBox.click(function () {
                        $(':checkbox:eq(0)').attr('checked', $subBox.length == $(':checkbox:gt(0):checked').length ? true : false);
                      });
                      $(':checkbox').click(function () {
                        $(':checkbox').each(function () {
                          $('#resolverAssignment').css('display', $(':checkbox:checked').length == 0 ? 'none' : 'block');
                          if (isTaskController) {
                            $('#managerAssignment').css('display', $(':checkbox:checked').length == 0 ? 'none' : 'block');
                          }
                        });
                        var assignmentIdsStr = '';
                        $(':checkbox:gt(0)').each(function () {
                          if ($(this).attr('checked') == true) {
                            var val = $(this).val();
                            assignmentIdsStr += val + ',';
                          }
                          ;
                        });
                        assignmentIdsStr = assignmentIdsStr.substr(0, assignmentIdsStr.length - 1)
                        $('#assignIds').val(assignmentIdsStr);
                      });
                      function toggleAssBtn(flag) {
                        $('#resolverAssignment').css('display', flag);
                        if (isTaskController) {
                          $('#managerAssignment').css('display', flag);
                        }
                      };
                      function originalUi() {
                        $(':checkbox:eq(0)').parents(':eq(1)').hide();
                        $(':checkbox:gt(0)').parent().hide();
                        $(':checkbox').hide();
                        $(':checkbox').attr('checked', false);
                      };
                    })
                  </script><form accept-charset='UNKNOWN' id='ToggleViewForm' method='post'
                                 name='ToggleViewForm' action='Dispatcher'
                                 enctype='application/x-www-form-urlencoded'><input id='assignIds'
                                                                                    value='assignIds'
                                                                                    name='assignIds'
                                                                                    type='hidden'/><input
                          id='printButton' value='Print' class='pure-button' name='printButton'
                          onclick="printButton.disabled='true';nvcm.value='RootContext_286';submit();return false;"
                          type='submit'/><input id='dueToday' value='Due Today' class='pure-button'
                                                name='dueToday'
                                                onclick="dueToday.disabled='true';nvcm.value='RootContext_287';submit();return false;"
                                                type='submit'/><input id='dueThisWeek'
                                                                      value='Due This Week'
                                                                      class='pure-button'
                                                                      name='dueThisWeek'
                                                                      onclick="dueThisWeek.disabled='true';nvcm.value='RootContext_288';submit();return false;"
                                                                      type='submit'/><input
                          id='dueThisMonth' value='Due This Month' class='pure-button'
                          name='dueThisMonth'
                          onclick="dueThisMonth.disabled='true';nvcm.value='RootContext_289';submit();return false;"
                          type='submit'/><input id='all' value='All' class='pure-button' name='all'
                                                onclick="all.disabled='true';nvcm.value='RootContext_290';submit();return false;"
                                                type='submit'/><input
                          style='display:none;float:right;' class='pure-button'
                          id='resolverAssignment' name='resolverAssignment'
                          onclick="resolverAssignment.disabled='true';nvcm.value='RootContext_291';submit();return false;"
                          value='Resolver Assignment' type='submit'/><input
                          style='display:none;float:right;' class='pure-button' id='managerAssignment'
                          name='managerAssignment'
                          onclick="managerAssignment.disabled='true';nvcm.value='RootContext_292';submit();return false;"
                          value='Manager Assignment' type='submit'/><input id='assignType'
                                                                           value='doBulkResolverAssignment'
                                                                           name='assignType'
                                                                           type='hidden'/><input
                          id='bulkEditButton' value='Bulk edit' style='display:block;float:right;'
                          class='pure-button' name='Bulk edit' type='button'/><input
                          id='cancleBulkEditButton' value='Cancel Bulk edit'
                          style='display:none;float:right;' class='pure-button'
                          name='Cancel Bulk edit' type='button'/><input name='nvcm' type='hidden'
                                                                        value=';'/></form><span><form
                          accept-charset='UNKNOWN' id='TasksForm' method='post' name='TasksForm'
                          action='Dispatcher' enctype='application/x-www-form-urlencoded'><input
                          name='nvcm' type='hidden' value=';'/>
                    <table id='TaskTable' width='100%' border='0' style=''>
                      <tr>
                        <td class='spokesoft_srs_th'><p align='Center'><input id='' value=''
                                                                              name=''
                                                                              type='checkbox'/>
                        </p></td>
                        <td class='spokesoft_srs_th'><a name='Column2'
                                                        href='Dispatcher?nvcm=RootContext_294;'>ID<img
                                height='15' width='15' border='0' src='images/down.gif'/></a>
                        </td>
                        <td class='spokesoft_srs_th'><a name='Column3'
                                                        href='Dispatcher?nvcm=RootContext_295;'>Description</a>
                        </td>
                        <td class='spokesoft_srs_th'><a name='Column4'
                                                        href='Dispatcher?nvcm=RootContext_296;'>Location</a>
                        </td>
                        <td class='spokesoft_srs_th'><a name='Column5'
                                                        href='Dispatcher?nvcm=RootContext_297;'>SLA
                          Date</a></td>
                        <td class='spokesoft_srs_th'><a name='Column6'
                                                        href='Dispatcher?nvcm=RootContext_298;'>Manager</a>
                        </td>
                        <td class='spokesoft_srs_th'><a name='Column7'
                                                        href='Dispatcher?nvcm=RootContext_299;'>Resolver</a>
                        </td>
                        <td class='spokesoft_srs_th'><a name='Column8'
                                                        href='Dispatcher?nvcm=RootContext_300;'>Priority</a>
                        </td>
                        <td class='spokesoft_srs_th'><a name='Column9'
                                                        href='Dispatcher?nvcm=RootContext_301;'>Status</a>
                        </td>
                        <td class='spokesoft_srs_th'><a name='Column10'
                                                        href='Dispatcher?nvcm=RootContext_302;'>Type</a>
                        </td>
                      </tr>
                    </table>
                  </form><span><table width='0%' cellspacing='4' border='0'>
                    <tr>
                      <td>
                        <form accept-charset='UNKNOWN' id='BackwardsForm' method='post'
                              name='BackwardsForm' action='Dispatcher'
                              enctype='application/x-www-form-urlencoded'><input
                                id='RootContext_323_0' value='&lt;&lt;' class='pure-button'
                                name='&lt;&lt;'
                                onclick="RootContext_323_0.disabled='true';nvcm.value='RootContext_323';submit();return false;"
                                type='submit'/><input id='RootContext_324_0' value='&lt;'
                                                      class='pure-button' name='&lt;'
                                                      onclick="RootContext_324_0.disabled='true';nvcm.value='RootContext_324';submit();return false;"
                                                      type='submit'/><input name='nvcm'
                                                                            type='hidden'
                                                                            value=';'/></form>
                      </td>
                      <td>
                        <form accept-charset='UNKNOWN' id='GotoIndexForm' method='post'
                              name='GotoIndexForm' action='Dispatcher'
                              enctype='application/x-www-form-urlencoded'><input
                                class='inputtext' id='GotoIndex' name='GotoIndex' maxlength='7'
                                value='1' size='3' type='text'/><input name='nvcm' type='hidden'
                                                                       value='RootContext_325;'/>
                        </form>
                        of 1
                      </td>
                      <td>
                        <form accept-charset='UNKNOWN' id='ForwardsForm' method='post'
                              name='ForwardsForm' action='Dispatcher'
                              enctype='application/x-www-form-urlencoded'><input
                                id='RootContext_326_0' value='&gt;' class='pure-button'
                                name='&gt;'
                                onclick="RootContext_326_0.disabled='true';nvcm.value='RootContext_326';submit();return false;"
                                type='submit'/><input id='RootContext_327_0' value='&gt;&gt;'
                                                      class='pure-button' name='&gt;&gt;'
                                                      onclick="RootContext_327_0.disabled='true';nvcm.value='RootContext_327';submit();return false;"
                                                      type='submit'/><input name='nvcm'
                                                                            type='hidden'
                                                                            value=';'/></form>
                      </td>
                    </tr>
                  </table></span></span></span></span></td>
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
<script type="text/javascript" src="/staticmedia/js/openTask/openTaskList.js"></script>