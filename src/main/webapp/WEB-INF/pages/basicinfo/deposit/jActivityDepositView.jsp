<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form method="post">

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="back"><a href="list.action">返回</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">

        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">浏览活动押金信息</div>
            </div>
        </div>
        <div>
            <div>
                <table>
                    <tr>
                        <td class="columnTitle">活动名称：</td>
                        <td class="tableContent">${obj.activityDepositName}</td>
                        <td class="columnTitle">用户名：</td>
                        <td class="tableContent">${obj.activityDepositUserName}</td>
                        <td class="columnTitle">状态：</td>
                        <td class="tableContent"><c:if test="${obj.activityDepositState==1}">
                            <font color="green">已退回</font>
                        </c:if> <c:if test="${obj.activityDepositState==0}">
                            <font color="red">未退回</font>
                        </c:if></td>
                    </tr>
                    <tr>
                        <td class="columnTitle">应退金额：</td>
                        <td class="tableContent">
                            <pre>${obj.activityDepositPayMoney}</pre>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnTitle">实退金额：</td>
                        <td class="tableContent">
                            <pre>${obj.activityDepositReturnMoney}</pre>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnTitle">说明：</td>
                        <td class="tableContent">
                            <pre>${obj.activityDepositDetails}</pre>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
</html>

