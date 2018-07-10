<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 2018/6/13
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>模块介绍</title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="all"/>
    <%--<script src="${pageContext.request.contextPath}/weui/lib/jquery-2.1.4.js"></script>--%>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${pageContext.request.contextPath}/js/linkageMenu.js"></script>
</head>
<body>
<form id="activity_release" action="insertActivity.action" onsubmit="return checkForm()">
    <div class="textbox"></div>
    <div class="modelDiv">

        <table class="modelTable" cellspacing="1">
            <tr>
                <td colspan="2" class="modelTitle">
                    青果活动发布
                </td>
            </tr>
            <tr>
                <td class="subModelTitle">
                    活动名称&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="activityName" type="text" name="activityName"
                                                                  placeholder="请输入活动名称">
                </td>
                <td class="subModelTitle">
                    活动类型
                    &nbsp&nbsp&nbsp&nbsp&nbsp
                    大类<select  id="firstCategory" name="firstCategory" onchange="insertSecondCategory()">
                    </select>
                    小类<select  id="secondCategory" name="secondCategory">
                        <option>请选择活动类别</option>
                    </select>

                </td>
            </tr>
            <tr>
                <td class="subModelTitle">
                    活动地点&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="address" type="text" name="address"
                                                                  placeholder="请输入活动地点">
                </td>
                <td class="subModelTitle">
                    活动时间&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="activityDate" type="date" name="activityDate" >
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动所属单位<input id="affiliatedCompany" type="text" name="affiliatedCompany" placeholder="请输入活动所属单位">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动需求
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    <input id="isNeedTeacher" type="checkbox" name="isNeedTeacher" value="0" onchange="changeCheckbox(document.getElementById('isNeedTeacher')),showTeacherOrNot(document.getElementById('isNeedTeacher').value)">导师&nbsp&nbsp&nbsp&nbsp
                    <input id="teacherNumbers" type="text" name="teacherNumbers" placeholder="请输入需要人数" style="display: none">
                    <select id="teacherDomain" name="teacherDomain" style="display: none"></select>
                    <input id="teacherDeposit" type="text" name="teacherDeposit" placeholder="请输入导师押金" style="display: none">
                    <input id="teacherReward" type="text" name="teacherReward" placeholder="请输入导师酬金" style="display: none"><br>

                    <input id="isNeedCraftsman" type="checkbox" name="isNeedCraftsman" value="0" onchange="changeCheckbox(document.getElementById('isNeedCraftsman')),showCraftsmanOrNot(document.getElementById('isNeedCraftsman').value)">匠人&nbsp&nbsp&nbsp&nbsp
                    <input id="craftsmanNumbers" type="text" name="craftsmanNumbers" placeholder="请输入需要人数" style="display: none">
                    <select id="craftsmanDomain" name="craftsmanDomain" style="display: none"></select>
                    <input id="craftsmanDeposit" type="text" name="craftsmanDeposit" placeholder="请输入匠人押金" style="display: none">
                    <input id="craftsmanReward" type="text" name="craftsmanReward" placeholder="请输入匠人酬金" style="display: none"><br>

                    <input id="isNeedVolunteer" type="checkbox" name="isNeedVolunteer" value="0" onchange="changeCheckbox(document.getElementById('isNeedVolunteer')),showVolunteerOrNot(document.getElementById('isNeedVolunteer').value)">志愿者&nbsp
                    <input id="volunteerNumbers" type="text" name="volunteerNumbers" placeholder="请输入需要人数" style="display: none">
                    <input id="volunteerDeposit" type="text" name="volunteerDeposit" placeholder="请输入志愿者押金" style="display: none">
                    <input id="volunteerReward" type="text" name="volunteerReward" placeholder="请输入志愿者酬金" style="display: none"><br>

                    <input id="isNeedAudience" type="checkbox" name="isNeedAudience" value="0" onchange="changeCheckbox(document.getElementById('isNeedAudience')),showAudienceOrNot(document.getElementById('isNeedAudience').value)">观众&nbsp&nbsp&nbsp&nbsp
                    <input id="audienceNumbers" type="text" name="audienceNumbers" placeholder="请输入需要人数" style="display: none"><br>

                    <input id="isNeedPlace" type="checkbox" name="isNeedPlace" value="0" onchange="changeCheckbox(document.getElementById('isNeedPlace')),showPlaceOrNot(document.getElementById('isNeedPlace').value)">场地&nbsp&nbsp&nbsp&nbsp
                    <select  id="placeProvider" name="placeProvider" style="display: none">
                        <option>请选择场地提供方</option>
                        <option>青果提供</option>
                        <option>第三方提供</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    交通&nbsp&nbsp<input id="traffic" type="text" name="traffic" placeholder="请输入附近交通">
                    活动图片&nbsp&nbsp<input id="image" type="file" name="image">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动描述<textarea id="activityDescribe" style="height: 200px;width: 400px; resize: none" name="activityDescribe"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle" align="center">
                    <input id="release" type="submit" value="发布">
                </td>
            </tr>
        </table>

    </div>
</form>
</body>
<script>
    $(function () {
        insertTeacherDomain("#teacherDomain");
        insertCraftsmanDomain("#craftsmanDomain")
        insertCategory(0, "#firstCategory");
        insertSecondCategory();
    })

    function insertSecondCategory() {
        insertCategory($("#firstCategory option:selected").val(), "#secondCategory");
    }

    function insertCategory(n, m) {
        $.ajax({
            url: "/qggy/basicinfo/activitydirectory/activitydirectory.action",
            type: 'get',
            data: {id:n},
            async: false,
            success: function (data) {
                var dataHtml = "<option>请选择活动类别</option>";
                /*
                  后台返回的data是含两个json对象的数组
                  alert(data[0].id);
                  alert(data[0].activityCategory);
                  alert(data[1].id);
                  alert(data[1].activityCategory);
                */
                $.each(
                    data, function (index, obj) {
                        dataHtml += "<option value=" + obj.id + ">" + obj.activityCategory + "</option>";
                    }
                );
                $(m).html(dataHtml);
            }
        })
    }

    //从后台读导师领域
    function insertTeacherDomain(m) {
        $.ajax({
            url: "/qggy/basicinfo/teacherdomain/selectteacherdomain.action",
            type: 'get',
            async: false,
            success: function (data) {
                var dataHtml = "<option>请选择导师领域</option>";
                $.each(
                    data, function (index, obj) {
                        dataHtml += "<option value=" + obj.id + ">" + obj.domainName + "</option>";
                    }
                );
                $(m).html(dataHtml);
            }
        })
    }

    //从后台读匠人领域
    function insertCraftsmanDomain(m) {
        $.ajax({
            url: "/qggy/basicinfo/craftsmandomain/selectcraftsmandomain.action",
            type: 'get',
            async: false,
            success: function (data) {
                var dataHtml = "<option>请选择匠人领域</option>";
                $.each(
                    data, function (index, obj) {
                        dataHtml += "<option value=" + obj.id + ">" + obj.domainName + "</option>";
                    }
                );
                $(m).html(dataHtml);
            }
        })
    }

    //校验表单
    function checkForm(){
        var activityName =  document.getElementById("activityName").value;
        var address=document.getElementById("address").value;
        var firstCategory = document.getElementById("firstCategory").value;
        var secondCategory = document.getElementById("secondCategory").value;
        var affiliatedCompany=document.getElementById("affiliatedCompany").value;
        var activityDate = document.getElementById("activityDate").value;

        var isNeedTeacher=document.getElementById("isNeedTeacher").value;
        var isNeedCraftsman=document.getElementById("isNeedCraftsman").value;
        var isNeedVolunteer=document.getElementById("isNeedVolunteer").value;
        var isNeedAudience=document.getElementById("isNeedAudience").value;

        var teacherNumbers=document.getElementById("teacherNumbers").value;
        var craftsmanNumbers=document.getElementById("craftsmanNumbers").value;
        var volunteerNumbers=document.getElementById("volunteerNumbers").value;
        var audienceNumbers=document.getElementById("audienceNumbers").value;

        var teacherDomain = document.getElementById("teacherDomain").value;
        var craftsmanDomain = document.getElementById("craftsmanDomain").value;

        var teacherDeposit=document.getElementById("teacherDeposit").value;
        var craftsmanDeposit=document.getElementById("craftsmanDeposit").value;
        var volunteerDeposit=document.getElementById("volunteerDeposit").value;

        var teacherReward=document.getElementById("teacherReward").value;
        var craftsmanReward=document.getElementById("craftsmanReward").value;
        var volunteerReward=document.getElementById("volunteerReward").value;

        var placeProvider=document.getElementById("placeProvider").value;
        var traffic=document.getElementById("traffic").value;
        var image=document.getElementById("image").value;
        var activityDescribe=document.getElementById("activityDescribe").value;

        if(isNull(activityName))
        {
            alert("活动名称不能为空");
            return false;
        }
        else if(isNull(address))
        {
            alert("活动地点不能为空");
            return false;
        }
        else if (firstCategory == "请选择活动类别" || secondCategory == "请选择活动类别")
        {
            alert("请选择活动类别");
            return false;
        }
        else if(isNull(activityDate))
        {
            alert("请选择时间");
            return false;
        }
        else if(isNull(affiliatedCompany))
        {
            alert("所属单位不能为空");
            return false;
        }
        else if (isNeed(isNeedTeacher) && isIllNum(teacherNumbers))
        {
            alert("导师人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanNumbers))
        {
            alert("匠人人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedVolunteer) && isIllNum(volunteerNumbers))
        {
            alert("志愿者人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedAudience) && isIllNum(audienceNumbers))
        {
            alert("观众人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedTeacher) && teacherDomain == "请选择导师领域")
        {
            alert("请选择导师领域");
            return false;
        }
        else if (isNeed(isNeedTeacher) && isIllNum(teacherDeposit))
        {
            alert("导师押金请输入数字");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && craftsmanDomain == "请选择匠人领域")
        {
            alert("请选择匠人领域");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanDeposit))
        {
            alert("匠人押金请输入数字");
            return false;
        }
        else if (isNeed(isNeedVolunteer) && isIllNum(volunteerDeposit))
        {
            alert("志愿者押金请输入数字");
            return false;
        }
        else if (isNeed(isNeedTeacher) && isIllNum(teacherReward))
        {
            alert("导师酬金请输入数字");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanReward))
        {
            alert("匠人酬金请输入数字");
            return false;
        }
        else if (isNeed(isNeedVolunteer) && isIllNum(volunteerReward))
        {
            alert("志愿者酬金请输入数字");
            return false;
        }
        else if (placeProvider == "请选择场地提供方")
        {
            alert("请选择场地提供方");
            return false;
        }
        else if (isNull(traffic))
        {
            alert("交通不能为空");
            return false;
        }
        else if (isNull(image))
        {
            alert("请选择活动图片");
            return false;
        }
        else if (isNull(activityDescribe))
        {
            alert("活动描述不能为空");
            return false;
        }
        else return true;
    }

    //判断是否为空
    function isNull(x){
        return ($.trim(x)=="");
    }

    //判断是否需要相关角色
    function isNeed(x) {
        return (x == 1);
    }

    //判断数字输入是否非法
    function isIllNum(x) {
        return (isNull(x) || isNaN(x));
    }
    /* //提示信息
     function msg(x) {
         switch (x) {
             case 'activityName':
                 alert("活动名称不能为空")
                 return false;
                 break;
         }
     }*/

    //改变需求复选框的值
    function changeCheckbox(obj) {
        obj.value = Math.abs(obj.value-1);
    }

    //显示或隐藏场地
    function showPlaceOrNot(x) {
        if (x == 1) {
            document.getElementById("placeProvider").style.display = "";
        }else document.getElementById("placeProvider").style.display = "none";
    }

    //显示或隐藏观众
    function showAudienceOrNot(x) {
        if (x == 1) {
            document.getElementById("audienceNumbers").style.display = "";
        }else document.getElementById("audienceNumbers").style.display = "none";
    }

    //显示或隐藏志愿者
    function showVolunteerOrNot(x) {
        var volunteerNumbers =document.getElementById("volunteerNumbers");
        var volunteerDeposit =document.getElementById("volunteerDeposit");
        var volunteerReward =document.getElementById("volunteerReward");
            if (x == 1) {
                volunteerNumbers.style.display = "";
                volunteerDeposit.style.display = "";
                volunteerReward.style.display = "";
            }else {
                volunteerNumbers.style.display = "none";
                volunteerDeposit.style.display = "none";
                volunteerReward.style.display = "none";
            }
    }

    //显示或隐藏匠人
    function showCraftsmanOrNot(x) {
        var craftsmanNumbers =document.getElementById("craftsmanNumbers");
        var craftsmanDomain = document.getElementById("craftsmanDomain");
        var craftsmanDeposit =document.getElementById("craftsmanDeposit");
        var craftsmanReward =document.getElementById("craftsmanReward");
        if (x == 1) {
            craftsmanNumbers.style.display = "";
            craftsmanDomain.style.display = "";
            craftsmanDeposit.style.display = "";
            craftsmanReward.style.display = "";
        }else {
            craftsmanNumbers.style.display = "none";
            craftsmanDomain.style.display = "none";
            craftsmanDeposit.style.display = "none";
            craftsmanReward.style.display = "none";
        }
    }

    //显示或隐藏导师
    function showTeacherOrNot(x) {
        var teacherNumbers =document.getElementById("teacherNumbers");
        var teacherDomain=document.getElementById("teacherDomain");
        var teacherDeposit =document.getElementById("teacherDeposit");
        var teacherReward =document.getElementById("teacherReward");
        if (x == 1) {
            teacherNumbers.style.display = "";
            teacherDomain.style.display = "";
            teacherDeposit.style.display = "";
            teacherReward.style.display = "";
        }else {
            teacherNumbers.style.display = "none";
            teacherDomain.style.display = "none";
            teacherDeposit.style.display = "none";
            teacherReward.style.display = "none";
        }
    }
</script>

</html>
