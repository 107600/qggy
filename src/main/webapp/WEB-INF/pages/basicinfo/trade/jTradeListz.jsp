﻿<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String[] stats = {"first", "second", "third"};
%>
<%@ include file="../../baselist.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<head>
    <title></title>
</head>
<script type="text/javascript">
    $(function () {
        $("#activityType").click(function () {
            if ($(this).hasClass("textbox-title")){

            }else{
                // 添加字体加粗效果
                $("#activityType").toggleClass("textbox-title")
                $("#classType").toggleClass("textbox-title")

            }


        })

        $("#classType").click(function () {
            if($(this).hasClass("textbox-title")){

            }
            else{
                $("#classType").toggleClass("textbox-title")
                $("#activityType").toggleClass("textbox-title")

            }

        })
    });

</script>

<body>
<form name="icform" method="post">

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="view"><a href="#"
                                         onclick="formSubmit('toview.action','_self');this.blur();">查看</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="textbox-inner-header" style="float: right">

        <div><a id="classType" class="textbox-title" style="font-size: medium;cursor: pointer" >课程</a>|<a
                id="activityType" style="font-size: medium;cursor: pointer">活动</a></div>
    </div>

    <div class="textbox-header">
        <div class="textbox-inner-header">

            <div class="textbox-title">
                请输入支付人姓名<input type="text" name="likes" id="likes" value="${likes}">
                <a href="#" onclick="formSubmit('list.action','_self');">查询</a>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">交易订单列表 ${fn:length(dataList)} 条</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" style="width: 98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid"
                                                       onclick="checkAll('id',this)"></td>
                        <td class="tableHeader">序号</td>
                        <td class="tableHeader">交易类型</td>
                        <td class="tableHeader">对应课程</td>
                        <td class="tableHeader">总金额</td>
                        <td class="tableHeader">支付人姓名</td>
                        <td class="tableHeader">区域</td>
                        <td class="tableHeader">支付时间</td>
                        <td class="tableHeader">支付金额</td>
                        <td class="tableHeader">状态</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                    <c:forEach items="${dataList}" var="o" varStatus="status">
                        <tr class="odd" onmouseover="this.className='highlight'"
                            onmouseout="this.className='odd'">
                            <td><input type="checkbox" name="id" value="${o.id}"/></td>
                            <td>${status.index+1}</td>
                            <td><a href="toview.action?id=${o.id}"> <c:if
                                    test="${o.category==0}">课程</c:if> <c:if
                                    test="${o.category==1}">
                                充值
                            </c:if> <c:if test="${o.category==2}">商品
                            </c:if> </a></td>
                            <td>${o.name}</td>
                            <td>${o.totalFee}</td>
                            <td>${o.payUserName}</td>
                            <td>${o.areaName}</td>
                            <td><fmt:formatDate value="${o.payTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${o.cashFee}</td>
                            <td><c:if test="${o.state==0}">
                                已支付
                            </c:if> <c:if test="${o.state==1}">
                                <font color="red">申请退款</font>
                            </c:if> <c:if test="${o.state==2}">
                                <font color="green">驳回</font>
                            </c:if> <c:if test="${o.state==3}">
                                <font color="red">部分退款</font>
                            </c:if> <c:if test="${o.state==4}">
                                <font color="green">已退款</font>
                            </c:if><c:if test="${o.state==5}">
                                <font color="green">已完成</font>
                            </c:if>
                                <c:if test="${o.state==6}">
                                    <font color="green">已开课</font>
                                </c:if>
                                <c:if test="${o.state==7}">
                                    <font color="green">未完成</font>
                                </c:if>
                            </td>
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

