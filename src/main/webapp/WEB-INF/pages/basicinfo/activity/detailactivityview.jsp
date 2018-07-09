<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ include file="../../baselist.jsp" %>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        textarea {
            width:180px;
            border:1px solid #ccc;
            padding:2px;
        }
        table{
            border:1px solid #666;
        }
        /*http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js*/
    </style>
    <%--<script href="../../../js/jquery-1.4.2.js" type="text/javascript"></script>--%>
    <%--<script type="text/javascript" href="../../../js/vdform.js"></script>--%>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../../js/jquery-1.4.2.js"/>
    <link rel="sty.lesheet" rev="stylesheet" type="text/css"
          href="../../../js/vdform.js"/>


</head>
<body>
<br /><br />
<center>

</center>
<h2 style="display:block; text-align:center;">第三方活动</h2>
<div>
    <form id="testform" action="" method="post">
        <table border="1px solid #666" align="center">
            <tr>
                <td> 活动发起单位:</td>
                <td><input  type="text" name="Name"></td>
            </tr>

            <tr>
                <td>活动时间(yyyy-mm-dd)：</td>
                <td><input  type="text" name="time"></td>
            </tr>

            <tr>
                <td>活动地点:</td>
                <td><input  type="text" name="place" ></td>
            </tr>

            <tr>
                <td>活动类型:</td>
                <td><input   type="text"   name="type"></td>
            </tr>
            <tr>
                <td>活动主题:</td>
                <td><input   type="text"  name="theme"></td>
            </tr>
            <tr>
                <td>活动人数:</td>
                <td><input   type="text"  name="people" ></td>
            </tr>
            <tr>
                <td>活动金额:</td>
                <td><input   type="text"  name="money"  ></td>
            </tr>

            <td>导师需求：</td>
            <td>
                <input name="teacherneed" value="1" type="checkbox">
                导师
                <input   type="text"  name="type" >
                <input   type="text"  name="teachernum" >
                </tr>
            </td>

            <td>志愿者需求：</td>
            <td>
                <input name="volunteerneed" value="1" type="checkbox">
                志愿者
                <input   type="text"  name="volunteernum" >
                </tr>
            </td>

            <td>观众需求：</td>
            <td>
                <input name="audienceneed" value="1" type="checkbox">
                观众
                <input   type="text"  name="audiencenum" >
                </tr>
            </td>

            <td>匠人需求：</td>
            <td>
                <input name="craftsmanneed" value="1" type="checkbox">
                匠人
                <input   type="text"  name="craftsmannum" >
                </tr>
            </td>

            <td>场地需求：</td>
            <td>
                <input name="placeneed" value="1" type="checkbox">
                需要场地
                </tr>
            </td>

            <td>缴纳押金：</td>
            <td>
                <input name="deposit" value="1" type="checkbox">
                缴纳押金
                </tr>
            </td>


            <tr>
                <td>活动介绍：</td>
                <td><textarea name="Description"  >活动介绍</textarea></td>
            </tr>
        </table>
    </form>
    <script>
        $('#testform').checkForm();
        $("#btn").click(function(){
            alert( $('#testform').checkFormResult());
            $('#testform').submit();

        });
    </script>
</div>
</body>
</html>
