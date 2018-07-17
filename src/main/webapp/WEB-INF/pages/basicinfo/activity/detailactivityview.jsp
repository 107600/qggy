<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ include file="../../baselist.jsp" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        textarea {
            width: 720px;
            border: 20px solid #008866;
            padding: 2px;
        }

        table {
            width: 1000px;
            height: 600px;
            border: 2px solid #008866;
        }

    </style>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../../js/jquery-1.4.2.js"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css"
          href="../../../js/vdform.js"/>

</head>
<body>
<h2 style="display:block; text-align:center;">第三方活动</h2>
<div>

        <table border="3px solid  #008866"  border-width="20px"  align="center">
            <c:forEach items="${activitys}" var="activity">
                <tr>
                    <td> 活动发起单位:</td>
                    <td>${activity.launcher}</td>
                </tr>

                <tr>
                    <td>活动时间(yyyy-mm-dd)：</td>
                    <td>${activity.time }</td>
                </tr>

                <tr>
                    <td>活动地点:</td>
                    <td>${activity.place }</td>
                </tr>

                <tr>
                    <td>活动类型:</td>
                    <td>${activity.type }</td>
                </tr>
                <tr>
                    <td>活动主题:</td>
                    <td>${activity.theme }</td>
                </tr>
                <tr>
                    <td>活动人数:</td>
                    <td>${activity.people }</td>
                </tr>
                <tr>
                    <td>活动金额:</td>
                    <td>${activity.money }</td>
                </tr>

                <tr>
                    <td>导师需求：</td>
                        <td>
                        是否需要导师：
                            ${activity.teacherneed }

                        导师类型：
                            ${activity.teachertype }

                        导师人数：
                            ${activity.teachernum }
                        </td>
                </tr>

                <tr>
                    <td>志愿者需求：</td>
                    <td>
                        是否需要志愿者：
                            ${activity.volunteerneed }
                        志愿者人数：
                            ${activity.volunteernum }
                    </td>
                </tr>

                <tr>
                    <td>观众需求：</td>
                    <td>
                        是否需要观众：
                            ${activity.audienceneed }
                        观众人数：
                            ${activity.audiencenum }
                    </td>
                </tr>


                <td>匠人需求：</td>
                <td>
                    是否需要匠人：
                        ${activity.craftsmanneed }
                    匠人人数：
                        ${activity.craftsmannum }
                </td>
                <tr>
                    <td>场地需求：</td>
                    <td>
                        是否需要场地：
                            ${activity.placeneed }
                    </td>
                </tr>

                <tr>
                    <td>缴纳押金：</td>
                    <td>
                        是否缴纳押金：
                            ${activity.deposit }
                    </td>
                </tr>

                <tr>
                    <td>活动介绍：</td>
                    <td>${activity.introduction }</td>
                </tr>

                <tr>
                    <td>审核意见：</td>
                    <td>${activity.suggestion}</td>
                </tr>
            </c:forEach>
        </table>

    <script>
        $('#testform').checkForm();
        $("#btn").click(function () {
            alert($('#testform').checkFormResult());
            $('#testform').submit();

        });
    </script>

</div>
</body>
</html>
