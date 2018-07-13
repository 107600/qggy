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
</body>
<script>
    //使用vue来校验表单
    const vueForm = new Vue({
        el: '#activity_release',
        data: {
            errorStyle: {
                color: 'red',
            },
            activityName: null,
            address: null,
            affiliatedCompany: null,
            activityDate: null,
            traffic: null,
            image: null,
            activityDescribe: null,


            isNeedTeacher: false,
            teacherNumbers: null,
            teacherDomain: '请选择导师领域',
            teacherDeposit: null,
            teacherReward: null,

            isNeedCraftsman: false,
            craftsmanNumbers: null,
            craftsmanDomain: '请选择匠人领域',
            craftsmanDeposit: null,
            craftsmanReward: null,

            isNeedVolunteer: false,
            volunteerNumbers: null,
            volunteerDeposit: null,
            volunteerReward: null,

            isNeedAudience:false,
            audienceNumbers:null,

            isNeedPlace:false,
            placeProvider:'请选择场地提供方',

            //错误变量
            activityNameError: null,
            addressError: null,
            affiliatedCompanyError: null,
            activityDateError: null,
            trafficError: null,
            imageError: null,
            activityDescribeError: null,

            teacherNumbersError: null,
            teacherDomainError: null,
            teacherDepositError: null,
            teacherRewardError: null,

            craftsmanNumbersError: null,
            craftsmanDomainError: null,
            craftsmanDepositError: null,
            craftsmanRewardError: null,

            volunteerNumbersError: null,
            volunteerDepositError: null,
            volunteerRewardError: null,

            audienceNumbersError:null,

            placeProviderError:null,

            firstCategoryError:null,
            secondCategoryError:null,

            error: '*必填',
            numerror: '*必填数字'

        },
        methods: {
            checkform: function (e) {
                this.activityNameError = null,
                    this.addressError = null,
                    this.affiliatedCompanyError = null,
                    this.activityDateError = null,
                    this.trafficError = null,
                    this.imageError = null,
                    this.activityDescribeError = null,
                    this.teacherNumbersError = null,
                    this.teacherDomainError = null,
                    this.teacherDepositError = null,
                    this.teacherRewardError = null,
                    this.craftsmanNumbersError = null,
                    this.craftsmanDomainError = null,
                    this.craftsmanDepositError = null,
                    this.craftsmanRewardError = null,
                    this.volunteerNumbersError = null,
                    this.volunteerDepositError = null,
                    this.volunteerRewardError = null,
                    this.audienceNumbersError = null,
                    this.placeProviderError = null,
                    this.firstCategoryError = null,
                    this.secondCategoryError = null;


                if (this.activityName &&
                    this.address &&
                    this.affiliatedCompany &&
                    this.activityDate &&
                    this.traffic &&
                    this.activityDescribe &&
                    ((this.isNeedTeacher && !isIllNum(this.teacherNumbers)) || !this.isNeedTeacher) &&
                    ((this.isNeedTeacher && this.teacherDomain != '请选择导师领域') || !this.isNeedTeacher) &&
                    ((this.isNeedTeacher && !isIllNum(this.teacherDeposit)) || !this.isNeedTeacher) &&
                    ((this.isNeedTeacher && (!isIllNum(this.teacherReward)) || !this.isNeedTeacher)) &&

                    ((this.isNeedCraftsman && !isIllNum(this.craftsmanNumbers)) || !this.isNeedCraftsman) &&
                    ((this.isNeedCraftsman && this.craftsmanDomain != '请选择匠人领域') || !this.isNeedCraftsman) &&
                    ((this.isNeedCraftsman && !isIllNum(this.craftsmanDeposit)) || !this.isNeedCraftsman) &&
                    ((this.isNeedCraftsman && (!isIllNum(this.craftsmanReward)) || !this.isNeedCraftsman))

                    ((this.isNeedVolunteer && !isIllNum(this.volunteerNumbers)) || !this.isNeedVolunteer) &&
                    ((this.isNeedVolunteer && !isIllNum(this.volunteerDeposit)) || !this.isNeedVolunteer) &&
                    ((this.isNeedVolunteer && (!isIllNum(this.volunteerReward)) || !this.isNeedVolunteer))

                    ((this.isNeedAudience && !isIllNum(this.audienceNumbers)) || !this.isNeedAudience) &&

                    ((this.isNeedPlace && this.placeProvider !='请选择场地提供方' || !this.isNeedPlace)) &&

                    this.$refs.firstCategory.value !='请选择活动类别' &&
                    this.$refs.secondCategory.value !='请选择活动类别'

                ) return true;


                if (!this.activityName) this.activityNameError = this.error;
                if (!this.address) this.addressError = this.error;
                if (!this.affiliatedCompany) this.affiliatedCompanyError = this.error;
                if (!this.activityDate) this.activityDateError = this.error;
                if (!this.traffic) this.trafficError = this.error;
                if (!this.image) this.imageError = this.error;
                if (!this.activityDescribe) this.activityDescribeError = this.error;
                if (!((this.isNeedTeacher && !isIllNum(this.teacherNumbers)) || !this.isNeedTeacher)) this.teacherNumbersError = this.numerror;
                if (!((this.isNeedTeacher && this.teacherDomain != '请选择导师领域') || !this.isNeedTeacher)) this.teacherDomainError = this.error;
                if (!((this.isNeedTeacher && !isIllNum(this.teacherDeposit)) || !this.isNeedTeacher)) this.teacherDepositError = this.numerror;
                if (!((this.isNeedTeacher && !isIllNum(this.teacherReward)) || !this.isNeedTeacher)) this.teacherRewardError = this.numerror;

                if (!((this.isNeedCraftsman && !isIllNum(this.craftsmanNumbers)) || !this.isNeedCraftsman)) this.craftsmanNumbersError = this.numerror;
                if (!((this.isNeedCraftsman && this.craftsmanDomain != '请选择匠人领域') || !this.isNeedCraftsman)) this.craftsmanDomainError = this.error;
                if (!((this.isNeedCraftsman && !isIllNum(this.craftsmanDeposit)) || !this.isNeedCraftsman)) this.craftsmanDepositError = this.numerror;
                if (!((this.isNeedCraftsman && !isIllNum(this.craftsmanReward)) || !this.isNeedCraftsman)) this.craftsmanRewardError = this.numerror;

                if (!((this.isNeedVolunteer && !isIllNum(this.volunteerNumbers)) || !this.isNeedVolunteer)) this.volunteerNumbersError = this.numerror;
                if (!((this.isNeedVolunteer && !isIllNum(this.volunteerDeposit)) || !this.isNeedVolunteer)) this.volunteerDepositError = this.numerror;
                if (!((this.isNeedVolunteer && !isIllNum(this.volunteerReward)) || !this.isNeedVolunteer)) this.volunteerRewardError = this.numerror;

                if(!((this.isNeedAudience && !isIllNum(this.audienceNumbers)) || !this.isNeedAudience)) this.audienceNumbersError = this.numerror;

                if(!((this.isNeedPlace && this.placeProvider !='请选择场地提供方' || !this.isNeedPlace))) this.placeProviderError = this.error;

                if(this.$refs.firstCategory.value == '请选择活动类别') this.firstCategoryError =this.error;
                    if(this.$refs.secondCategory.value == '请选择活动类别') this.secondCategoryError = this.error;
                e.preventDefault();
            },
            showError: function () {
                if (!this.isNeedTeacher) {
                    this.teacherNumbers = null,
                        this.teacherDomain = "请选择导师领域",
                        this.teacherDeposit = null,
                        this.teacherReward = null,

                        this.teacherNumbersError = null,
                        this.teacherDomainError = null,
                        this.teacherDepositError = null,
                        this.teacherRewardError = null;
                }
                if (!this.isNeedCraftsman) {
                    this.craftsmanNumbers = null,
                        this.craftsmanDomain = "请选择匠人领域",
                        this.craftsmanDeposit = null,
                        this.craftsmanReward = null,

                        this.craftsmanNumbersError = null,
                        this.craftsmanDomainError = null,
                        this.craftsmanDepositError = null,
                        this.craftsmanRewardError = null;
                }

                if (!this.isNeedVolunteer) {
                    this.volunteerNumbers = null,
                        this.volunteerDeposit = null,
                        this.volunteerReward = null,

                        this.volunteerNumbersError = null,
                        this.volunteerDepositError = null,
                        this.volunteerRewardError = null;
                }
                if (!this.isNeedAudience) {
                    this.audienceNumbers = null,
                        this.audienceNumbersError = null;
                }
                if (!this.isNeedPlace) {
                    this.placeProvider = '请选择场地提供方',
                        this.placeProviderError = null;
                }
            }

        }
    })

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
            data: {id: n},
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

    //用单纯的js来校验表单
    function checkForm() {
        var activityName = document.getElementById("activityName").value;
        var address = document.getElementById("address").value;
        var firstCategory = document.getElementById("firstCategory").value;
        var secondCategory = document.getElementById("secondCategory").value;
        var affiliatedCompany = document.getElementById("affiliatedCompany").value;
        var activityDate = document.getElementById("activityDate").value;

        var isNeedTeacher = document.getElementById("isNeedTeacher").value;
        var isNeedCraftsman = document.getElementById("isNeedCraftsman").value;
        var isNeedVolunteer = document.getElementById("isNeedVolunteer").value;
        var isNeedAudience = document.getElementById("isNeedAudience").value;

        var teacherNumbers = document.getElementById("teacherNumbers").value;
        var craftsmanNumbers = document.getElementById("craftsmanNumbers").value;
        var volunteerNumbers = document.getElementById("volunteerNumbers").value;
        var audienceNumbers = document.getElementById("audienceNumbers").value;

        var teacherDomain = document.getElementById("teacherDomain").value;
        var craftsmanDomain = document.getElementById("craftsmanDomain").value;

        var teacherDeposit = document.getElementById("teacherDeposit").value;
        var craftsmanDeposit = document.getElementById("craftsmanDeposit").value;
        var volunteerDeposit = document.getElementById("volunteerDeposit").value;

        var teacherReward = document.getElementById("teacherReward").value;
        var craftsmanReward = document.getElementById("craftsmanReward").value;
        var volunteerReward = document.getElementById("volunteerReward").value;

        var isNeedPlace = document.getElementById("isNeedPlace").value;
        var placeProvider = document.getElementById("placeProvider").value;
        var traffic = document.getElementById("traffic").value;
        var image = document.getElementById("image").value;
        var activityDescribe = document.getElementById("activityDescribe").value;

        if (isNull(activityName)) {
            alert("活动名称不能为空");
            return false;
        }
        else if (firstCategory == "请选择活动类别") {
            alert("请选择活动类别");
            return false;
        }
        else if (secondCategory == "请选择活动类别") {
            alert("请选择活动类别");
            return false;
        }
        else if (isNull(address)) {
            alert("活动地点不能为空");
            return false;
        }
        else if (isNull(activityDate)) {
            alert("请选择时间");
            return false;
        }
        else if (isNull(affiliatedCompany)) {
            alert("所属单位不能为空");
            return false;
        }
        else if (isNeed(isNeedTeacher) && isIllNum(teacherNumbers)) {
            alert("导师人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanNumbers)) {
            alert("匠人人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedVolunteer) && isIllNum(volunteerNumbers)) {
            alert("志愿者人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedAudience) && isIllNum(audienceNumbers)) {
            alert("观众人数请输入数字");
            return false;
        }
        else if (isNeed(isNeedTeacher) && teacherDomain == "请选择导师领域") {
            alert("请选择导师领域");
            return false;
        }
        else if (isNeed(isNeedTeacher) && isIllNum(teacherDeposit)) {
            alert("导师押金请输入数字");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && craftsmanDomain == "请选择匠人领域") {
            alert("请选择匠人领域");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanDeposit)) {
            alert("匠人押金请输入数字");
            return false;
        }
        else if (isNeed(isNeedVolunteer) && isIllNum(volunteerDeposit)) {
            alert("志愿者押金请输入数字");
            return false;
        }
        else if (isNeed(isNeedTeacher) && isIllNum(teacherReward)) {
            alert("导师酬金请输入数字");
            return false;
        }
        else if (isNeed(isNeedCraftsman) && isIllNum(craftsmanReward)) {
            alert("匠人酬金请输入数字");
            return false;
        }
        else if (isNeed(isNeedVolunteer) && isIllNum(volunteerReward)) {
            alert("志愿者酬金请输入数字");
            return false;
        }
        else if (isNeed(isNeedPlace) && placeProvider == "请选择场地提供方") {
            alert("请选择场地提供方");
            return false;
        }
        else if (isNull(traffic)) {
            alert("交通不能为空");
            return false;
        }
        else if (isNull(image)) {
            alert("请选择活动图片");
            return false;
        }
        else if (isNull(activityDescribe)) {
            alert("活动描述不能为空");
            return false;
        }
        else return true;

    }

    //判断是否为空
    function isNull(x) {
        return ($.trim(x) == "");
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
        obj.value = Math.abs(obj.value - 1);
    }

    //显示或隐藏场地
    function showPlaceOrNot(x) {
        if (x == 1) {
            document.getElementById("placeProvider").style.display = "";
        } else document.getElementById("placeProvider").style.display = "none";
    }

    //显示或隐藏观众
    function showAudienceOrNot(x) {
        if (x == 1) {
            document.getElementById("audienceNumbers").style.display = "";
        } else document.getElementById("audienceNumbers").style.display = "none";
    }

    //显示或隐藏志愿者
    function showVolunteerOrNot(x) {
        var volunteerNumbers = document.getElementById("volunteerNumbers");
        var volunteerDeposit = document.getElementById("volunteerDeposit");
        var volunteerReward = document.getElementById("volunteerReward");
        if (x == 1) {
            volunteerNumbers.style.display = "";
            volunteerDeposit.style.display = "";
            volunteerReward.style.display = "";
        } else {
            volunteerNumbers.style.display = "none";
            volunteerDeposit.style.display = "none";
            volunteerReward.style.display = "none";
        }
    }

    //显示或隐藏匠人
    function showCraftsmanOrNot(x) {
        var craftsmanNumbers = document.getElementById("craftsmanNumbers");
        var craftsmanDomain = document.getElementById("craftsmanDomain");
        var craftsmanDeposit = document.getElementById("craftsmanDeposit");
        var craftsmanReward = document.getElementById("craftsmanReward");
        if (x == 1) {
            craftsmanNumbers.style.display = "";
            craftsmanDomain.style.display = "";
            craftsmanDeposit.style.display = "";
            craftsmanReward.style.display = "";
        } else {
            craftsmanNumbers.style.display = "none";
            craftsmanDomain.style.display = "none";
            craftsmanDeposit.style.display = "none";
            craftsmanReward.style.display = "none";
        }
    }

    //显示或隐藏导师
    function showTeacherOrNot(x) {
        var teacherNumbers = document.getElementById("teacherNumbers");
        var teacherDomain = document.getElementById("teacherDomain");
        var teacherDeposit = document.getElementById("teacherDeposit");
        var teacherReward = document.getElementById("teacherReward");
        if (x == 1) {
            teacherNumbers.style.display = "";
            teacherDomain.style.display = "";
            teacherDeposit.style.display = "";
            teacherReward.style.display = "";
        } else {
            teacherNumbers.style.display = "none";
            teacherDomain.style.display = "none";
            teacherDeposit.style.display = "none";
            teacherReward.style.display = "none";
        }
    }
</script>

</html>
