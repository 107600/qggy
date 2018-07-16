<%@ page language="java" pageEncoding="" %>
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
                <td colspan="2" class="modelTitle">老师管理模块介绍</td>
            </tr>

            <tr>
                <td colspan="2" class="subModelTitle">课件管理</td>
            </tr>
            <tr>
                <td class="model_intro_left" width="169" colspan="2">老师可以在这里上传课件</td>

            </tr>

            <tr>
                <td colspan="2" class="subModelTitle">申请管理</td>
            </tr>
            <tr>
                <td class="model_intro_left" colspan="2">新用户注册成为导师或匠人</td>
            </tr>

            <tr>
                <td colspan="2" class="subModelTitle">导师管理</td>
            </tr>
            <tr>
                <td class="model_intro_left" colspan="2">已经注册成为导师的人</td>
            </tr>

            <tr>
                <td colspan="2" class="subModelTitle">匠人管理</td>
            </tr>
            <tr>
                <td class="model_intro_left" colspan="2">已经成为匠人的人</td>
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