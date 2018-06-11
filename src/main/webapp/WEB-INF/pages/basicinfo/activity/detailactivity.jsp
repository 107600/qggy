<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
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
    </style>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/vdform.js"></script>
</head>
<body>
<br /><br /\
<center>

</center>
<h2 style="display:block; text-align:center;">第三方活动</h2>
<div>
    <form id="testform" action="" method="post">
        <table border="1px solid #666" align="center">
            <tr>
                <td> 活动发起单位:</td>
                <td><input  type="text" name="Name"   validata-options="validType:'Require|Chinese',msg:'不能为空"></td>
            </tr>

            <tr>
                <td>活动时间(yyyy-mm-dd)：</td>
                <td><input name="Birthday" validata-options="validType:'Date',format:'ymd',msg:'日期不存在'"></td>
            </tr>

            <tr>
                <td>活动类型:</td>
                <td><input   type="text"  name="Nick"></td>
            </tr>
            <tr>
                <td>活动主题:</td>
                <td><input   type="text"  name="Homepage"></td>
            </tr>
            <tr>
                <td>活动人数:</td>
                <td><input   type="text"  name="people" ></td>
            </tr>
            <tr>
                <td>活动金额:</td>
                <td><input   type="text"  name="place"  ></td>
            </tr>

            <td>导师需求：</td>
            <td>
                <input name="activity-need" value="1" type="checkbox">
                导师
                <input   type="text"  name="type" >
                <input   type="text"  name="teacher-num" >
                </tr>
            </td>

            <td>志愿者需求：</td>
            <td>
                <input name="volunteer-need" value="1" type="checkbox">
                志愿者
                <input   type="text"  name="volunteer-num" >
                </tr>
            </td>

            <td>观众需求：</td>
            <td>
                <input name="audience-need" value="1" type="checkbox">
                观众
                <input   type="text"  name="audience-num" >
                </tr>
            </td>

            <td>匠人需求：</td>
            <td>
                <input name="craftsman-need" value="1" type="checkbox">
                匠人
                <input   type="text"  name="craftsman-num" >
                </tr>
            </td>

            <td>场地需求：</td>
            <td>
                <input name="place-need" value="1" type="checkbox">
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
            <tr>
                <td  style="text-align:center; margin:0 auto"><input name="Submit" type="submit" value="审核通过"></td>
                <td  style="text-align:center; margin:0 auto"><input name="btn" id='btn' type="button" value="审核不通过"></td>
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
