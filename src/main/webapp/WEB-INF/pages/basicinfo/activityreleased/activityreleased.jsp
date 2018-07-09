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
    <script>
        $(function () {
            insertTeacherDomain("#teacherDomain");
            insertCraftsmanDomain("#craftsDomain")
            insertCategory(0, "#first");
            insertSecondCategory();
        })

        function insertSecondCategory() {
            insertCategory($("#first option:selected").val(), "#second");
        }

        function insertCategory(n, m) {
            $.ajax({
                url: "/qggy/basicinfo/activitydirectory/activitydirectory.action",
                type: 'get',
                data: {id:n},
                async: false,
                success: function (data) {
                    var dataHtml = "";
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
    </script>

</head>
<body>
<form action="insertActivity.action">
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
                    活动名称&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="activityName"
                                                                  placeholder="请输入活动名称">
                </td>
                <td class="subModelTitle">
                    活动类型
                    &nbsp&nbsp&nbsp&nbsp&nbsp
                    <select  id="first" name="firstCategory" onchange="insertSecondCategory()">

                    </select>
                    <select  id="second" name="secondCategory">

                    </select>

                </td>
            </tr>
            <tr>
                <td class="subModelTitle">
                    活动地点&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="address"
                                                                  placeholder="请输入活动地点">
                </td>
                <td class="subModelTitle">
                    活动时间&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="date" name="activityDate">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动所属单位<input type="text" name="affiliatedCompany" placeholder="请输入活动所属单位">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动需求
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    <input type="checkbox" name="isNeedTeacher" value="1">导师&nbsp&nbsp&nbsp&nbsp
                    <input type="text" name="teacherNumbers" placeholder="请输入需要人数">
                    <select id="teacherDomain" name="teacherDomain"></select>
                    <input type="text" name="teacherDeposit" placeholder="请输入导师押金">
                    <input type="text" name="teacherReward" placeholder="请输入导师酬金"><br>

                    <input type="checkbox" name="isNeedCraftsman" value="1">匠人&nbsp&nbsp&nbsp&nbsp
                    <input type="text" name="craftsmanNumbers" placeholder="请输入需要人数">
                    <select id="craftsDomain" name="craftsmanDomain"></select>
                    <input type="text" name="craftsmanDeposit" placeholder="请输入匠人押金">
                    <input type="text" name="craftsmanReward" placeholder="请输入匠人酬金"><br>

                    <input type="checkbox" name="isNeedVolunteer" value="1">志愿者
                    <input type="text" name="volunteerNumbers" placeholder="请输入需要人数">
                    <input type="text" name="volunteerDeposit" placeholder="请输入志愿者押金">
                    <input type="text" name="volunteerReward" placeholder="请输入志愿者酬金"><br>

                    <input type="checkbox" name="isNeedAudience" value="1">观众&nbsp&nbsp&nbsp&nbsp
                    <input type="text" name="audienceNumbers" placeholder="请输入需要人数"><br>

                    <input type="checkbox">场地&nbsp&nbsp&nbsp&nbsp
                    <select  name="placeProvider">
                        <option>请选择场地提供方</option>
                        <option>青果提供</option>
                        <option>第三方提供</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    交通&nbsp&nbsp<input type="text" name="traffic" placeholder="请输入附近交通">
                    活动图片&nbsp&nbsp<input type="file" name="image">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动描述<textarea style="height: 200px;width: 400px; resize: none" name="activityDescribe"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle" align="center">
                    <input type="submit" value="发布">
                </td>
            </tr>
        </table>

    </div>
</form>
</body>

</html>
