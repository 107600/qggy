<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                        <li id="view"><a href="#"
                                         onclick="formSubmit('toview.action','_self');this.blur();">查看</a>
                        </li>

                        <li id="update"><a href="#"
                                           onclick="formSubmit('toupdate.action','_self');this.blur();">修改</a>
                        </li>
                        <li id="new"><a href="#"
                                        onclick="formSubmit('start.action','_self');this.blur();">退还</a>
                        </li>
                        <%--<li id="new"><a href="#"--%>
                                        <%--onclick="formSubmit('stop.action','_self');this.blur();"></a>--%>
                        <%--</li>--%>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox-header">
        <div class="textbox-inner-header">

            <div class="textbox-title">
                请输入用户名<input type="text" name="likes" id="likes" value="${likes}">
                <a href="#" onclick="formSubmit('list.action','_self');">查询</a>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">活动押金列表 ${fn:length(dataList)} 条</div>
            </div>
        </div>

        <div>

            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" style="width: 98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid"
                                                       onclick="checkAll('id',this)"></td>
                        <td class="tableHeader">活动编号</td>
                        <td class="tableHeader">活动名称</td>
                        <td class="tableHeader">用户编号</td>
                        <td class="tableHeader">用户名</td>
                        <td class="tableHeader">区域</td>
                        <td class="tableHeader">缴纳时间</td>
                        <td class="tableHeader">退回时间</td>
                        <td class="tableHeader">缴纳金额</td>
                        <td class="tableHeader">退回金额</td>
                        <td class="tableHeader">状态</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">

                    <c:forEach items="${dataList}" var="o" varStatus="status">
                        <tr class="odd" onmouseover="this.className='highlight'"
                            onmouseout="this.className='odd'">
                            <td><input type="checkbox" name="id" value="${o.id}"/></td>
                            <td>${status.index+1}</td>
                            <td>${o.activityDepositName}</td>
                            <td><a href="toview.action?id=${o.id}">${o.activityDepositUserId}</a></td>
                            <td>${o.activityDepositUserName}</td>
                            <td>${o.areaName}</td>
                            <td><fmt:formatDate value="${o.activityDepositPayTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><fmt:formatDate value="${o.activityDepositReturnTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${o.activityDepositPayMoney}</td>
                            <td>${o.activityDepositReturnMoney}</td>
                            <td>
                                <c:if test="${o.activityDepositState==1}"><a href="stop.action?id=${o.id}"><font
                                        color="green">已退回</font></a ></c:if>
                                <c:if test="${o.activityDepositState==0}"><a href="start.action?id=${o.id}">未退回</a ></c:if>
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

