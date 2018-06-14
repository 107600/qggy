<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2018/6/13
  Time: 下午11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程押金管理</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="css/extreme/extremecomponents.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="css/extreme/extremesite.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="css/viewdetail.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="css/default.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="css/main.css" media="all"/>
    <meta charset="utf-8">
    <style>
        .odd{
            border-top: 1px solid #b7dad6;
            border-bottom: 1px solid #c1e1dd;
            color: #00554a;
            font-family: verdana, arial, helvetica, sans-serif;
            font-size: 9pt;
            font-weight: bold;
            text-align: left;
            padding: 6px;
            margin: 0px;

        }
    </style>
</head>

<body>
<form name="icform" method="post">
    <table class="modelTable" cellspacing="1">
        <tr>
            <td colspan="2" class="modelTitle">课程押金管理</td>
        </tr>
    </table>

    <div class="textbox-header">
        <div class="textbox-inner-header">

            <div class="textbox-title">
                导师工号:<input type="text" name="likes" id="likes" value="${likes}">
                时间段:<input type="text" name="likes" id="likes" value="${likes}">
                用户名:<input type="text" name="likes" id="likes" value="${likes}">
                课程编号:<input type="text" name="likes" id="likes" value="${likes}">
                <button href="#" onclick="formSubmit('list.action','_self');">查询</button>
                <button href="#" onclick="formSubmit('list.action','_self');">退回</button>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">课程押金列表</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid"
                        ></td>
                        <td class="tableHeader">导师工号</td>
                        <td class="tableHeader">用户名</td>
                        <td class="tableHeader">名称</td>
                        <td class="tableHeader">课程编号</td>
                        <td class="tableHeader">缴纳时间</td>
                        <td class="tableHeader">退回时间</td>
                        <td class="tableHeader">缴纳金额</td>
                        <td class="tableHeader">实退金额</td>
                        <td class="tableHeader">说明</td>
                        <td class="tableHeader">操作</td>
                        <td class="tableHeader">状态</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                    <tr class="odd">
                        <td><input type="checkbox"/></td>
                        <td>1</td>
                        <td>赵</td>
                        <td>申请导师</td>
                        <td>100001</td>
                        <td>2017-1-1</td>
                        <td>2017-1-10</td>
                        <td>199.00</td>
                        <td>99.00</td>
                        <td>被投诉</td>
                        <td>
                            <a href="#">修改</a>
                            <a href="#">确认</a>
                        </td>
                        <td>未退还</td>
                    </tr>
                    </tbody>
                    <tbody class="tableBody">

                    <tr class="odd">
                        <td><input type="checkbox"/></td>
                        <td>2</td>
                        <td>王</td>
                        <td>申请导师</td>
                        <td>100002</td>
                        <td>2017-1-1</td>
                        <td>2017-1-10</td>
                        <td>199.00</td>
                        <td>199.00</td>
                        <td>无</td>
                        <td>
                            <a href="#">修改</a>
                            <a href="#">确认</a>
                        </td>
                        <td>未退还</td>
                    </tr>
                    </tbody>
                    <tbody class="tableBody">

                    <tr class="odd">
                        <td><input type="checkbox"/></td>
                        <td>3</td>
                        <td>李</td>
                        <td>申请导师</td>
                        <td>100003</td>
                        <td>2017-1-1</td>
                        <td>2017-1-10</td>
                        <td>199.00</td>
                        <td>199.00</td>
                        <td>无</td>
                        <td>
                            <a href="#">修改</a>
                            <a href="#">确认</a>
                        </td>
                        <td>未退还</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>


</form>
</body>
</html>
