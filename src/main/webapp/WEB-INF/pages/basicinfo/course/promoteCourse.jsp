<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: gaojie
  Date: 2018/7/9
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>课程发起管理</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../css/extreme/extremecomponents.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../css/extreme/extremesite.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../css/viewdetail.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../skin/default/css/default.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../skin/default/css/main.css" media="all"/>

    <style type="text/css">
        .tableBody{
            text-align: left;
            border-top: 1px solid #b7dad6;
            border-bottom: 1px solid #c1e1dd;
            padding: 6px;
        }
    </style>
</head>
<body>
<%--这里把这个外层的表单注释掉了，如果以后出问题，可以考虑恢复--%>
<%--<form name="icform" method="post">--%>

    <table class="modelTable" cellspacing="1">
        <tr>
            <td colspan="2" class="modelTitle" style="text-align: center;">课程发起管理</td>
        </tr>
    </table>
    <form action="/qggy/basicinfo/promotecourse/findByParams.action" method="post">
    <div class="textbox-header">
        <div class="textbox-inner-header">

                <div class="textbox-title">
                    课程类别:<input type="text" name="courseCategory" id="courseCategory"/>
                    课程名称:<input type="text" name="courseName" id="courseName"/>
                    上课时间:<input type="text" name="courseTimeStr" id="courseTimeStr"/>
                    上课区域:<input type="text" name="courseAreaName" id="courseAreaName"/>
                            <input type="submit" value="查询"/>
                </div>

        </div>

    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">课程列表</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid"
                        ></td>
                        <td class="tableHeader">序号</td>
                        <td class="tableHeader">课程类别</td>
                        <td class="tableHeader">课程名称</td>
                        <td class="tableHeader">上课时间</td>
                        <td class="tableHeader">上课区域</td>
                        <td class="tableHeader">想参与本课程的学生人数</td>
                        <td class="tableHeader">想参与本课程的教师人数</td>
                        <td class="tableHeader">审核状态</td>
                        <td class="tableHeader">可选择的操作</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                    <c:forEach items="${promoteCourseList}" var="o">

                        <tr>
                            <td class="tableBody"><input type="checkbox"/></td>
                            <td class="tableBody">${o.promoteCourseId}</td>
                            <td class="tableBody">${o.courseCategory}</td>
                            <td class="tableBody">${o.courseName}</td>
                            <td class="tableBody"><fmt:formatDate value="${o.courseTime}"
                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td class="tableBody">${o.courseAreaName}</td>
                            <td class="tableBody">${o.courseNumStu}</td>
                            <td class="tableBody">${o.courseNumTea}</td>
                            <td class="tableBody">
                                <c:if test="${o.coursePromoteState == 0}">待审核</c:if>
                                <c:if test="${o.coursePromoteState == 1}">审核通过</c:if>
                                <c:if test="${o.coursePromoteState == 2}">审核未通过</c:if>
                            </td>
                            <td class="tableBody">
                                <a href="/qggy/basicinfo/course/checkPromoteCourse.action?promoteCourseId=${o.promoteCourseId}"
                                    target="_Blank">查看详细信息</a>
                                <a href="/qggy/basicinfo/promotecourse/updateCoursePromoteState.action?promoteCourseId=${o.promoteCourseId}">
                                    审核未通过</a>
                                <a href="/qggy/basicinfo/promotecourse/updateCoursePromoteStatePass.action?promoteCourseId=${o.promoteCourseId}">
                                    审核通过</a>
                                <a href="#">确认发布</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
<%--</form>--%>

</body>
</html>
