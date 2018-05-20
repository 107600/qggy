<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>模块介绍</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="${ctx}/skin/default/css/main.css" media="all"/>
</head>

<body>
<form>
    <div class="textbox"></div>

    <div class="modelDiv">

        <table class="modelTable" cellspacing="1">
            <tr>
                <td colspan="2" class="modelTitle">酬金管理模块介绍</td>
            </tr>

            <tr>
                <td colspan="2" class="subModelTitle">导师酬金管理</td>
            </tr>
            <tr>
                <td class="model_intro_left" width="169" colspan="2">管理员可以查看导师酬金的发放情况</td>

            </tr>

            <tr>
                <td colspan="2" class="subModelTitle">匠人酬金管理</td>
            </tr>
            <tr>
                <td class="model_intro_left" colspan="2">管理员查看匠人酬金的发放情况</td>
            </tr>

            <tfoot>
            <tr>
                <td colspan="2" class="tableFooter"></td>
            </tr>
            </tfoot>
        </table>

    </div>
</form>
</body>

</html>