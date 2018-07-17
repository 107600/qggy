<%--
  Created by IntelliJ IDEA.
  User: gaojie
  Date: 2018/7/14
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css">
        <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.0/css/jquery-weui.min.css">

        <title>课程发起的用户端界面</title>

    </head>
    <style>

        .weui-media-box_appmsg .weui-media-box__hd {
            margin-right: .8em;
            width: 80px;
            line-height: 80px;

        }

        .weui-media-box {
            padding: 10px;

        }

        .weui-panel__bd{
            font-size:2em;
            font-weight: bolder;
            text-align: center;
        }
        .weui-textarea{
            width: 100%;

        }
        .weui-btn_warn{
            width:80% ;
        }
    </style>
<body>
    <form method="post" action="/qggy/phone/user/interestCourse.action">
        <div class="weui-panel weui-panel_access">
            <div class="weui-panel__bd">课程发起</div>
        </div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">课程类别</label></div>
                <div class="weui-cell__bd">
                    ${promoteCourse.courseCategory}
                </div>
                <input type="hidden" name="courseCategory" value="${promoteCourse.courseCategory}"/>
                <%--增加一个input，用于获取promoteCourse的id，判断是哪一门课程--%>
                <input type="hidden" name="promoteCourseId" value="${promoteCourse.promoteCourseId}"/>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">课程名称</label></div>
                <div class="weui-cell__bd">
                    <%--<input class="weui-input" type="text" name="courseName"  placeholder="必填">--%>
                    <div name="courseName">${promoteCourse.courseName}</div>
                        <input type="hidden" name="courseName" value="${promoteCourse.courseName}"/>
                </div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">课程时间</label></div>
                <div class="weui-cell__bd">
                    <!--<input class="weui-input" type="datetime-local" value="" placeholder="">-->
                    <%--<input type="text" id='datetime-picker' name="courseTime1"/>--%>
                    <fmt:formatDate value="${promoteCourse.courseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">上课区域</label></div>
                <%--<input type="text" id='city-picker' name="courseAreaName"/>--%>
                <div class="weui-cell__bd">${promoteCourse.courseAreaName}</div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">课程简介</label></div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <div class="weui-textarea-counter" style="text-align: center">${promoteCourse.courseIntro}</div>
                </div>
            </div>

        </div>

        <input type="submit" class="weui-btn weui-btn_primary" value="我想参加"/>
        <div class="weui-cell__hd" style="text-align: center">
            已经有${promoteCourse.courseNumStu}名学生参加,有${promoteCourse.courseNumTea}名教师参加
        </div>
        <%--<input type="submit" class="weui-btn weui-btn_primary" value=""/>--%>
    </form>
    <%--<a href="/qggy/phone/user/studentInterest.action?courseName=${promoteCourse.courseName}&courseCategory=${promoteCourse.courseCategory}" class="weui-btn weui-btn_primary">学生参加<label>（已有${promoteCourse.courseNumStu}人想参加）</label></a>--%>
    <%--<a href="/qggy/phone/user/teacherInterest.action" class="weui-btn weui-btn_primary">导师参加<label>（已有${promoteCourse.courseNumTea}人想参加）</label></a>--%>
</body>
</html>
