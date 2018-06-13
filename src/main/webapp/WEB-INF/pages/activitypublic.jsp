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
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="css/main.css" media="all"/>
    <script src="jquery.2.0.0.js"></script>
    <script src="linkageMenu.js"></script>

    <script>
        function changeProvince(code) {
            var url = "/buyer/city.shtml";
            var params = {"code": code};
            $.post(url, params, function (data) {
                var citys = data.citys;
                var html = '<option value="" selected>城市</option>';
                for (var i = 0; i < citys.length; i++) {
                    html += '<option value="' + citys[i].code + '">' + citys[i].name + '</option>';
                }
                $("#city").html(html);
                $("#town").html('<option value="" selected>县/区</option>');
            }, "json");
        }

        function changeCity(code) {
            var url = "/buyer/town.shtml";
            var params = {"code": code};
            $.post(url, params, function (data) {
                var towns = data.towns;
                var html = '<option value="" selected>县/区</option>';
                for (var i = 0; i < towns.length; i++) {
                    html += '<option value="' + towns[i].code + '">' + towns[i].name + '</option>';
                }
                $("#town").html(html);
            }, "json");
        }

    </script>
</head>
<body>
<form>
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
                    活动名称&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="activity-name"
                                                                  placeholder="请输入活动名称">
                </td>
                <td class="subModelTitle">
                    活动类型<!--二级联动技术难点-->
                    &nbsp&nbsp&nbsp&nbsp&nbsp
                    <select name="first-class" id="selectOne">
                        <option value="请选择活动大类">请选择活动大类</option>
                        <option value="活动大类">活动大类</option>
                    </select>
                    <select name="second-class" id="selectTwo">
                        <option value="请选择活动小类">请选择活动小类</option>
                        <option value="活动小类">活动小类</option>
                    </select>
                    <span class="word">
							<select name="province" id="province" onchange="changeProvince(this.value)">
								<option value="" selected>省/直辖市</option>
								<c:forEach items="${provinces}" var="province">
								<option value="${province.code}"
                                        <c:if test="${buyer.province==province.code}">selected="selected"</c:if>>${province.name}</option>
                                </c:forEach>
							</select>
							<select name="city" id="city" onchange="changeCity(this.value)">
								<option value="" selected>城市</option>
								<c:forEach items="${citys}" var="city">
                                    <option value="${city.code}"
                                            <c:if test="${buyer.city==city.code}">selected="selected"</c:if>>${city.name}</option>
                                </c:forEach>
							</select>
							<select name="town" id="town">
								<option value="" selected>县/区</option>
							<c:forEach items="${towns}" var="town">
                                <option value="${town.code}"
                                        <c:if test="${buyer.town==town.code}">selected="selected"</c:if>>${town.name}</option>
                            </c:forEach>
							</select>
						</span>
                </td>
            </tr>
            <tr>
                <td class="subModelTitle">
                    活动地点&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="activity-name"
                                                                  placeholder="请输入活动地点">
                </td>
                <td class="subModelTitle">
                    活动时间&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="date" name="activity-date">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动所属单位<input type="text" name="activity-name" placeholder="请输入活动所属单位">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动需求
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    <input type="checkbox" name="角色">导师&nbsp&nbsp&nbsp&nbsp
                    <input type="text" name="人数" placeholder="请输入需要人数">
                    <select>
                        <option>请选择导师领域</option>
                    </select>
                    <input type="text" name="押金" placeholder="请输入导师押金">
                    <input type="text" name="酬金" placeholder="请输入导师酬金"><br>
                    <input type="checkbox" name="角色">匠人&nbsp&nbsp&nbsp&nbsp
                    <input type="text" name="人数" placeholder="请输入需要人数">
                    <select>
                        <option>请选择匠人领域</option>
                    </select>
                    <input type="text" name="押金" placeholder="请输入匠人押金">
                    <input type="text" name="酬金" placeholder="请输入匠人酬金"><br>
                    <input type="checkbox" name="角色">志愿者
                    <input type="text" name="人数" placeholder="请输入需要人数">
                    <input type="text" name="押金" placeholder="请输入导师押金">
                    <input type="text" name="酬金" placeholder="请输入导师酬金"><br>
                    <input type="checkbox" name="角色">观众&nbsp&nbsp&nbsp&nbsp
                    <input type="text" name="人数" placeholder="请输入需要人数"><br>
                    <input type="checkbox" name="角色">场地&nbsp&nbsp&nbsp&nbsp
                    <select>
                        <option>请选择导师领域</option>
                        <option>青果提供</option>
                        <option>第三方提供</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    交通&nbsp&nbsp<input type="text" name="交通" placeholder="请输入附近交通">
                    活动图片&nbsp&nbsp<input type="file">
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动描述<textarea style="height: 200px;width: 400px; resize: none"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle" align="center">
                    <input type="button" value="发布">
                </td>
            </tr>
        </table>

    </div>
</form>
</body>

</html>
