<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ include file="../../baselist.jsp" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        textarea {
            width: 180px;
            border: 1px solid #ccc;
            padding: 2px;
        }

        table {
            border: 1px solid #666;
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
<h2 style="display:block; text-align:center;">第三方活动</h2>
<div>
    <%--<form id="testform" action="" method="post">--%>
        <table border="1px solid #666" align="center">
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
                            ${activity.teacherneed }
                        导师
                            ${activity.teachertype }
                            ${activity.teachernum }

                    </td>
                </tr>

                <tr>
                    <td>志愿者需求：</td>
                    <td>
                            ${activity.volunteerneed }
                        志愿者
                            ${activity.volunteernum }

                    </td>
                </tr>

                <tr>
                    <td>观众需求：</td>
                    <td>
                            ${activity.audienceneed }
                        观众
                            ${activity.audiencenum }

                    </td>
                </tr>


                <td>匠人需求：</td>
                <td>
                        ${activity.craftsmanneed }
                    匠人
                        ${activity.craftsmannum }
                    </tr>
                </td>
                <tr>
                    <td>场地需求：</td>
                    <td>
                            ${activity.placeneed }
                        需要场地

                    </td>
                </tr>

                <tr>
                    <td>缴纳押金：</td>
                    <td>
                            ${activity.deposit }
                        缴纳押金

                    </td>
                </tr>

                <tr>
                    <td>活动介绍：</td>
                    <td>${activity.introduction }</td>
                </tr>
            </c:forEach>
        </table>
    <%--</form>--%>

    <%--<c:forEach  items="${activitys}" var="activity">--%>
    <%--<tr>--%>
    <%--<td>${activity.launcher}</td>--%>
    <%--<td>${activity.time }</td>--%>
    <%--<td>${activity.theme }</td>--%>
    <%--<td>${activity.time }</td>--%>
    <%--<td>${activity.place }</td>--%>
    <%--<td>${activity.money}</td>--%>
    <%--<td>${activity.teacherneed }</td>--%>
    <%--<td>${activity.teachertype }</td>--%>
    <%--<td>${activity.teachernum}</td>--%>
    <%--<td>${activity.volunteerneed}</td>--%>
    <%--<td>${activity.volunteernum}</td>--%>
    <%--<td>${activity.craftsmanneed }</td>--%>
    <%--<td>${activity.craftsmannum}</td>--%>
    <%--<td>${activity.placeneed}</td>--%>
    <%--<td>${activity.deposit}</td>--%>
    <%--<td>${activity.introduction}</td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>

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
