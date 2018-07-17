<%--
  Created by IntelliJ IDEA.
  User: gaojie
  Date: 2018/7/16
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示导师的详细信息</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../skin/default/css/main.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../css/extreme/extremecomponents.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../css/extreme/extremesite.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../css/viewdetail.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../skin/default/css/default.css" media="all"/>
    <meta charset="utf-8">
    <style>
        .modelTitle{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="textbox"></div>
    <div class="modelDiv">

        <table class="modelTable" cellspacing="1">
            <thead>
            <tr>
                <td  colspan="9" class="modelTitle">导师详细信息</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="tablebody">真实姓名：${student.userName}</td>
                <td class="tablebody">电话号码：${student.phoneNumber}</td>
                <td class="tablebody">电子邮箱：${student.email}</td>
            </tr>
            <tr>
                <td class="tablebody">工作单位：${student.company}</td>
                <td class="tablebody">性&nbsp;&nbsp;别：${student.sex}</td>
                <td class="tablebody"> 申请角色: </td>
            </tr>
            <tr>
                <td class="tablebody">家庭住址：${student.adress}</td>
                <td class="tablebody">&nbsp;微信号：${student.weiXin}</td>
                <td class="tablebody">身份证号：${student.shenFen}</td>
            </tr>
            <tr>
                <td class="tablebody">区&nbsp;&nbsp;域：${student.areaName}</td>
                <td class="tablebody">擅长领域：${student.likes}</td>
            </tr>
        </table>
    </div>
    <div style="text-align: left;padding-left: 135px;"> <span>申请者自述</span> ${student.zishu}</div>

</body>
</html>
