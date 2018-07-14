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
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"
          media="all"/>
    <script src="${pageContext.request.contextPath}/weui/lib/jquery-2.1.4.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="${pageContext.request.contextPath}/js/linkageMenu.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
</head>
<body>
<form id="activity_release" @submit="checkform" action="insertActivity.action">
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
                                                                  placeholder="请输入活动名称" v-model="activityName"><label
                        v-bind:style="errorStyle">{{activityNameError}}</label>
                </td>
                <td class="subModelTitle">
                    活动类型
                    &nbsp&nbsp&nbsp&nbsp&nbsp
                    大类<select id="firstCategory" name="firstCategory" onchange="insertSecondCategory()" ref="firstCategory">
                </select><label v-bind:style="errorStyle">{{firstCategoryError}}</label>
                    小类<select id="secondCategory" name="secondCategory" ref="secondCategory">
                    <option>请选择活动类别</option>
                </select><label v-bind:style="errorStyle">{{secondCategoryError}}</label>

                </td>
            </tr>
            <tr>
                <td class="subModelTitle">
                    活动地点&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="address" type="text" name="address"
                                                                  placeholder="请输入活动地点" v-model="address"><label
                        v-bind:style="errorStyle">{{addressError}}</label>
                </td>
                <td class="subModelTitle">
                    活动时间&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="activityDate"
                                                                                                type="date"
                                                                                                name="activityDate"
                                                                                                v-model="activityDate"><label
                        v-bind:style="errorStyle">{{activityDateError}}</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动所属单位<input id="affiliatedCompany" type="text" name="affiliatedCompany" placeholder="请输入活动所属单位"
                                 v-model="affiliatedCompany">
                    <label v-bind:style="errorStyle">{{affiliatedCompanyError}}</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动需求
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">

                    <!--导师-->

                    <input id="isNeedTeacher" type="checkbox" name="isNeedTeacher" value="0"
                           onchange="changeCheckbox(document.getElementById('isNeedTeacher')),showTeacherOrNot(document.getElementById('isNeedTeacher').value)"
                           v-model="isNeedTeacher" @change="showError">导师&nbsp&nbsp&nbsp&nbsp
                    <input id="teacherNumbers" type="text" name="teacherNumbers" placeholder="请输入需要人数"
                           style="display: none" v-model="teacherNumbers"><label v-bind:style="errorStyle">{{teacherNumbersError}}</label>
                    <select id="teacherDomain" name="teacherDomain" style="display: none"
                            v-model="teacherDomain"></select><label
                        v-bind:style="errorStyle">{{teacherDomainError}}</label>
                    <input id="teacherDeposit" type="text" name="teacherDeposit" placeholder="请输入导师押金"
                           style="display: none" v-model="teacherDeposit"><label v-bind:style="errorStyle">{{teacherDepositError}}</label>
                    <input id="teacherReward" type="text" name="teacherReward" placeholder="请输入导师酬金"
                           style="display: none" v-model="teacherReward"><label v-bind:style="errorStyle">{{teacherRewardError}}</label><br>

                    <!--匠人-->

                    <input id="isNeedCraftsman" type="checkbox" name="isNeedCraftsman" value="0"
                           onchange="changeCheckbox(document.getElementById('isNeedCraftsman')),showCraftsmanOrNot(document.getElementById('isNeedCraftsman').value)"
                           v-model="isNeedCraftsman" @change="showError">匠人&nbsp&nbsp&nbsp&nbsp
                    <input id="craftsmanNumbers" type="text" name="craftsmanNumbers" placeholder="请输入需要人数"
                           style="display: none" v-model="craftsmanNumbers"><label v-bind:style="errorStyle">{{craftsmanNumbersError}}</label>
                    <select id="craftsmanDomain" name="craftsmanDomain" style="display: none"
                            v-model="craftsmanDomain"></select><label
                        v-bind:style="errorStyle">{{craftsmanDomainError}}</label>
                    <input id="craftsmanDeposit" type="text" name="craftsmanDeposit" placeholder="请输入匠人押金"
                           style="display: none" v-model="craftsmanDeposit"><label v-bind:style="errorStyle">{{craftsmanDepositError}}</label>
                    <input id="craftsmanReward" type="text" name="craftsmanReward" placeholder="请输入匠人酬金"
                           style="display: none" v-model="craftsmanReward"><label v-bind:style="errorStyle">{{craftsmanRewardError}}</label><br>

                    <!--志愿者-->

                    <input id="isNeedVolunteer" type="checkbox" name="isNeedVolunteer" value="0"
                           onchange="changeCheckbox(document.getElementById('isNeedVolunteer')),
                           showVolunteerOrNot(document.getElementById('isNeedVolunteer').value)" v-model="isNeedVolunteer" @change="showError">志愿者&nbsp
                    <input id="volunteerNumbers" type="text" name="volunteerNumbers" placeholder="请输入需要人数"
                           style="display: none" v-model="volunteerNumbers"><label v-bind:style="errorStyle">{{volunteerNumbersError}}</label>
                    <input id="volunteerDeposit" type="text" name="volunteerDeposit" placeholder="请输入志愿者押金"
                           style="display: none" v-model="volunteerDeposit"><label v-bind:style="errorStyle">{{volunteerDepositError}}</label>
                    <input id="volunteerReward" type="text" name="volunteerReward" placeholder="请输入志愿者酬金"
                           style="display: none" v-model="volunteerReward"><label v-bind:style="errorStyle">{{volunteerRewardError}}</label><br>

                    <!--观众-->

                    <input id="isNeedAudience" type="checkbox" name="isNeedAudience" value="0"
                           onchange="changeCheckbox(document.getElementById('isNeedAudience')),
                           showAudienceOrNot(document.getElementById('isNeedAudience').value)" v-model="isNeedAudience" @change="showError">观众&nbsp&nbsp&nbsp&nbsp
                    <input id="audienceNumbers" type="text" name="audienceNumbers" placeholder="请输入需要人数"
                           style="display: none" v-model="audienceNumbers"><label v-bind:style="errorStyle">{{audienceNumbersError}}</label><br>

                    <!--场地-->

                    <input id="isNeedPlace" type="checkbox" name="isNeedPlace" value="0"
                           onchange="changeCheckbox(document.getElementById('isNeedPlace')),
                    showPlaceOrNot(document.getElementById('isNeedPlace').value)" v-model="isNeedPlace" @change="showError">场地&nbsp&nbsp&nbsp&nbsp
                    <select id="placeProvider" name="placeProvider" style="display: none" v-model="placeProvider">
                        <option>请选择场地提供方</option>
                        <option>青果提供</option>
                        <option>第三方提供</option>
                    </select><label  v-bind:style="errorStyle">{{placeProviderError}}</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    交通&nbsp&nbsp<input id="traffic" type="text" name="traffic" placeholder="请输入附近交通"
                                       v-model="traffic"><label v-bind:style="errorStyle">{{trafficError}}</label>
                    活动图片&nbsp&nbsp<input id="image" type="file" name="image" v-model="image"><label
                        v-bind:style="errorStyle">{{imageError}}</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="subModelTitle">
                    活动描述<textarea id="activityDescribe" style="height: 200px;width: 400px; resize: none"
                                  name="activityDescribe" v-model="activityDescribe"></textarea><label
                        v-bind:style="errorStyle">{{activityDescribeError}}</label>
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
<script src="${pageContext.request.contextPath}/js/activityRelease/checkform.js"></script>
<script src="${pageContext.request.contextPath}/js/activityRelease/diranddomain.js"></script>
</body>
</html>