<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>第三方活动发布管理管理</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../../css/extreme/extremecomponents.css"/>
    <link rel="sty.lesheet" rev="stylesheet" type="text/css"
          href="../../../css/extreme/extremesite.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../../css/viewdetail.css"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../../css/default.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../../css/main.css" media="all"/>
    <meta charset="utf-8">
    <style>
        {
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
    <table class="modelTable" cellspacing="1">
        <tr>
            <td colspan="2" class="modelTitle">第三方活动发布管理</td>
        </tr>
    </table>

    <div class="textbox-header">
        <div class="textbox-inner-header">
            <div class="textbox-title">
            <form action="/basicinfo/activity/show.action" method="post">
                活动编号:<input type="text" name="likes" id="likes" value="${likes}">
                <input type="submit" value="查询"  style=width:50px;height:20px;line-height:20px;border:none;background:#F8F8FF;color:#696969;/>
            </form>
        </div>
            </div>
    </div>

    <div class="textbox-header">
        <div class="textbox-inner-header">
            <div class="textbox-title">
                <form action= "/basicinfo/activity/shenhepassActivity.action" method="post">
                    <style>
                        #sub{width:50px;height:20px;line-height:20px;border:none; background:#F8F8FF;color:#696969 ;}
                    </style>
                    查看审核通过活动:<input type="submit" value="查看"  id="sub" >
                </form>
            </div>
        </div>
    </div>



    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">活动列表</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                    <thead>
                    <tr>
                        <td class="tableHeader" style="text-align: center">序号</td>
                        <td class="tableHeader" style="text-align: center">活动类型</td>
                        <td class="tableHeader" style="text-align: center">活动主题</td>
                        <td class="tableHeader" style="text-align: center">活动时间</td>
                        <td class="tableHeader" style="text-align: center">活动地点</td>
                        <td class="tableHeader" style="text-align: center">审核状态</td>
                        <td class="tableHeader" colspan="4" style="text-align: center">可选择的操作</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                    <c:forEach  items="${activitys}" var="activity">
                        <tr>
                            <td>${activity.num }</td>
                            <td>${activity.type }</td>
                            <td>${activity.theme }</td>
                            <td>${activity.time }</td>
                            <td>${activity.place }</td>
                            <td>${activity.state }</td>

                            <td>
                                <form action="/basicinfo/activity/view.action" method="post">
                                    <input type="hidden" name=num  value="${activity.num }">
                                    <input type="submit" value="查看详情" style="width:80px;height:30px;border:0px; background:#F8F8FF;color:#696969 ;"/>
                                </form>
                            </td>

                            <td>
                                <form action="/basicinfo/activity/shenhefActivity.action" method="post">
                                    <input type="hidden" name=num  value="${activity.num }">
                                    <input type="submit" value="审核未通过" style="width:80px;height:30px;border:0px; background:#F8F8FF;color:#696969 ;"/>
                                </form>
                            </td>

                            <td>
                                <form action="/basicinfo/activity/shenheActivity.action" method="post">
                                    <input type="hidden" name=num  value="${activity.num }">
                                    <input type="submit" value="审核通过" style="width:80px;height:30px;border:0px; background:#F8F8FF;color:#696969 ;"/>
                                </form>
                            </td>

                            <td>
                                <form action="/basicinfo/activity/submitactivity.action" method="post">
                                    <input type="hidden" name=num  value="${activity.num }">
                                    <input type="text"    name="suggestion" id="suggestion" value="${suggestion}" style=width:80px;height:20px;line-height:20px;  >
                                    <input type="submit" value="提交"  style=width:30px;height:20px;line-height:20px;border:none;background:#F8F8FF;color:#696969;/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>


    </div>

</body>
</html>