<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<!-- <h1>青果综合管理平台</h1> -->
<div class="top_logo">
</div>

<form name="icform" method="post">
    <table class="modelTable" cellspacing="1">
        <tr>
            <td colspan="2" class="modelTitle" style="text-align: center;">发起课程的详细信息</td>
        </tr>
    </table>

    <h2>课程简介</h2>
    <div style="width: 45%;height: 15%">
        ${promoteCourse.courseIntro}
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title" style="text-align: center;">已参与本课程的老师</div>
            </div>
        </div>

        <div>
            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%" align="center">
                    <thead>
                    <tr>
                        <td class="tableHeader" style="text-align: center;"><input type="checkbox" name="selid"></td>
                        <td class="tableHeader" style="text-align: center;">序号</td>
                        <td class="tableHeader" style="text-align: center;">员工编号</td>
                        <td class="tableHeader" style="text-align: center;">姓名</td>
                        <td class="tableHeader" style="text-align: center;">领域</td>
                        <td class="tableHeader" style="text-align: center;">信用积分</td>
                        <td class="tableHeader" style="text-align: center;">可选择的操作</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">
                    <c:forEach items="${promoteCourseVOList}" var="o">
                        <c:if test="${o.state == 3}">
                            <tr class="odd">
                                <td><input type="checkbox"/></td>
                                <td>1</td>
                                <td>001</td>
                                <td>${o.userName}</td>
                                <td>${o.courseCategory}</td>
                                <td>${o.creditPoints}</td>
                                <td><a href="/qggy/basicinfo/promotecourse/tutorinformation.action?userOpenid=${o.userOpenid}"
                                       target="_Blank">查看详细信息</a></td>
                                <%--"/qggy/phone/user/myBillHistory.action"--%>
                            </tr>
                        </c:if>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title" style="text-align: center;">已参与本课程的学生（先保留）</div>
            </div>
        </div>

        <div>
            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%" align="center">
                    <thead>
                    <tr>
                        <td class="tableHeader" style="text-align: center;"><input type="checkbox" name="selid"></td>
                        <td class="tableHeader" style="text-align: center;">序号</td>
                        <td class="tableHeader" style="text-align: center;">会员号</td>
                        <td class="tableHeader" style="text-align: center;">姓名</td>
                        <td class="tableHeader" style="text-align: center;">可选择的操作</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">
                    <c:forEach items="${promoteCourseVOList}" var="o">
                        <c:if test="${o.state == 1}">
                            <tr class="odd">
                                <td><input type="checkbox"/></td>
                                <td>1</td>
                                <td>001</td>
                                <td>${o.userName}</td>
                                <td><a href="#" target="_Blank">查看详细信息</a></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
  </form>
</body>
</html>
