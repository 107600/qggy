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
            <td colspan="2" class="modelTitle">第三方活动发布管理</td>
        </tr>
    </table>

    <div class="textbox-header">
        <div class="textbox-inner-header">

            <div class="textbox-title">
                <form action="/basicinfo/activity/show.action" method="post">
                    活动编号:<input type="text" name="likes" id="likes" value="${likes}">
                    <input type="submit" value="查询"/>
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
                        <td class="tableHeader"><input type="checkbox" name="selid"
                        ></td>
                        <td class="tableHeader">序号</td>
                        <td class="tableHeader">活动类型</td>
                        <td class="tableHeader">活动主题</td>
                        <td class="tableHeader">活动时间</td>
                        <td class="tableHeader">活动地点</td>
                        <td class="tableHeader">审核状态</td>
                        <td class="tableHeader">可选择的操作</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                    <c:forEach  items="${dataList}" var="activity">
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${activity.num }</td>
                            <td>${activity.type }</td>
                            <td>${activity.theme }</td>
                            <td>${activity.time }</td>
                            <td>${activity.place }</td>
                            <td>${activity.state }</td>






                            <td>
                                <a href="#" onclick="javascript:location.href=('view.action');this.blur();" target="_self">查看详细信息</a>


                                <%--<div onclick="javascript:location.href='detailactivityview.jsp'" target="_Blank>查看详细信息</div>--%>

                                <a href="#">审核未通过</a>
                                <a href="#">确认发布</a>
                            </td>

                        </tr>
                    </c:forEach>



                    <%--<tr class="odd">
                        &lt;%&ndash;<td><input type="checkbox"/></td>&ndash;%&gt;
                        &lt;%&ndash;<td>1</td>&ndash;%&gt;
                        &lt;%&ndash;<td>大类</td>&ndash;%&gt;
                        &lt;%&ndash;<td>聚会</td>&ndash;%&gt;
                        &lt;%&ndash;<td>周六上午9:00-11:00</td>&ndash;%&gt;
                        &lt;%&ndash;<td>杨浦区</td>&ndash;%&gt;
                        &lt;%&ndash;<td>已审核</td>&ndash;%&gt;

                    </tr>--%>
                    </tbody>
                </table>
            </div>
        </div>

    </div>






</form>
</body>
</html>