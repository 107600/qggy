<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2018/7/16
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>

<body>
<form name="icform" method="post">

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="view">
                            <a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a>
                        </li>
                        <li id="update"><a href="#"
                                           onclick="formSubmit('toupdate.action','_self');this.blur();">修改</a>
                        </li>

                        <li id="new"><a href="#"
                                        onclick="formSubmit('classinsert.action','_self');this.blur();">插班</a>
                        </li>
                        <li id="stop"><a href="#"
                                         onclick="formSubmit('classdelete.action','_self');this.blur();">删除</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">班级列表</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)">
                        </td>
                        <td class="tableHeader">序号</td>
                        <td class="tableHeader">活动名称</td>
                        <td class="tableHeader">活动大类</td>
                        <td class="tableHeader">活动小类</td>
                        <td class="tableHeader">活动时间</td>
                        <td class="tableHeader">活动地点</td>
                        <td class="tableHeader">活动描述</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                    <c:forEach items="${activitylists}" var="o" varStatus="status">
                        <tr class="odd" onmouseover="this.className='highlight'"
                            onmouseout="this.className='odd'">
                            <td><input type="checkbox" name="id" value="${o.id}"/>
                            </td>
                            <td>${status.index+1}</td>
                            <td><a href="toview.action?id=${o.id}">${o.activityName}</a>
                            </td>
                            <td>${o.firstCategory}</td>
                            <td>${o.secondCategory}</td>
                            <td><fmt:formatDate value="${o.activityDate}" pattern="yyyy-MM-dd"/>
                                    </td>
                            <td>${o.address}</td>
                            <td>${o.activityDescribe}</td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
</html>

